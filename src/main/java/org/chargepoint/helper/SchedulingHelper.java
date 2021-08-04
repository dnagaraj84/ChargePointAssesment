package org.chargepoint.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.chargepoint.entity.Charger;
import org.chargepoint.entity.Task;
import org.chargepoint.entity.Truck;


/**
 * SchedulingHelper Description.
 *
 * @author Nagaraj Diveela
 */
public class SchedulingHelper implements ISchedulingHelper
{
	@Override
	public List<Task> scheduleBasedOnShortRemainingTime(final List<Charger> chargers, final List<Truck> trucks, final double chargingHoursPerDay)
	{
		final List<Task> tasks = new ArrayList<>();

		if (!Objects.nonNull(chargers) || !Objects.nonNull(trucks))
		{
			return tasks;
		}
		else
		{
			// 1. Sort the trucks list based on remaining time to charge.
			Collections.sort(trucks);

			// 2. Based on the remaining time assign fleets to the available charging ports.
			for (final Iterator<Charger> iterator = chargers.iterator(); iterator.hasNext(); )
			{
				final Charger charger = iterator.next();
				double tempHours = chargingHoursPerDay;
				final List<Truck> allottedTrucks = new ArrayList<>();

				for (final Iterator<Truck> truckIterator = trucks.iterator(); truckIterator.hasNext(); )
				{
					final Truck truck = truckIterator.next();

					populateRemainingTimeForFullCharge(truck, charger);

					if (truck.getRemainingChargingTime() <= tempHours)
					{
						allottedTrucks.add(truck);

						tempHours = tempHours - truck.getRemainingChargingTime();
						truckIterator.remove();
					}
				}

				if (!allottedTrucks.isEmpty())
				{
					tasks.add(new Task(allottedTrucks, charger));
				}

				iterator.remove();
			}
		}

		return tasks;
	}


	/**
	 * Populate the remaining time for the fleets to be fully charges based on the formula derived.
	 *
	 * @param truck   The trucks which needs to be recharged. Must not be {@code null}.
	 * @param charger The available charging ports in the charge station. Must not be {@code null}.
	 */
	private void populateRemainingTimeForFullCharge(final Truck truck, final Charger charger)
	{
		// Formula =  total charge time = battery capacity / (charge power * 0.9). 
		// 0.9 - Is the average power efficiency.		
		final double totalChargeTimeInHours = truck.getBatteryCapacity() / (charger.getChargingRate() * 0.9);

		// Calculate remaining time needs to get fully charged based on current level.		
		final double chargeTimeInHoursBasedOnCurrentLevel = (100 - truck.getCurrentChargeLevel()) * (totalChargeTimeInHours / 100);
		final double chargeTimeInMinsBasedOnCurrentLevel = chargeTimeInHoursBasedOnCurrentLevel * 60;

		truck.setRemainingChargingTime(chargeTimeInMinsBasedOnCurrentLevel);
	}
}
