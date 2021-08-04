package org.chargepoint.controller;

import java.util.List;
import java.util.Objects;

import org.chargepoint.entity.Charger;
import org.chargepoint.entity.Task;
import org.chargepoint.entity.Truck;
import org.chargepoint.helper.ISchedulingHelper;
import org.chargepoint.helper.SchedulingHelper;


/**
 * The fleet service class which implements {link {@link IFleetService}}.
 *
 * @author Nagaraj Diveela
 */
public class FleetService implements IFleetService
{
	@Override
	public void identifyEffectiveWayOfCharging(final List<Charger> chargers, final List<Truck> trucks, final double chargingHoursPerDay)
	{
		printAvailableChargersAndTrucks(trucks, chargers);
		
		final ISchedulingHelper schedulingHelper = new SchedulingHelper();

		final List<Task> identifiedTasks = schedulingHelper.scheduleBasedOnShortRemainingTime(chargers, trucks, chargingHoursPerDay);

		printSchedules(identifiedTasks);
	}

	
	private void printAvailableChargersAndTrucks(final List<Truck> trucks, final List<Charger> chargers)
	{
		if (Objects.nonNull(chargers) && Objects.nonNull(trucks))
		{
			System.out.println("----------Following Charging ports are available --------");
			for(Charger charger : chargers)
			{
				System.out.println("The charger with unique id = "+charger.getUniqueId() + " with charging rate of "+charger.getChargingRate());
			}

			System.out.println("----------Following trucks are available for charging--------");
			
			for(Truck truck : trucks)
			{
				System.out.println("The truck with unique id = "+truck.getUniqueId() + " with battery capacity of "+truck.getBatteryCapacity() + " with current level at "+truck.getCurrentChargeLevel());
			}
		}
	}
	
	
	/**
	 * Print the schedule based on which fleets been charged in which charging ports.
	 *
	 * @param tasks The scheduled task for the given period of time frame. Must not be {@code null}.
	 */
	private void printSchedules(final List<Task> tasks)
	{
		System.out.println("----------------------------------------------------------------");
		System.out.println("Results : ");

		for (final Task task : tasks)
		{
			final Charger charger = task.getCharger();
			final List<Truck> trucks = task.getTrucks();

			for (final Truck truck : trucks)
			{
				System.out.println("The truck with unique id = " + truck.getUniqueId() + " is charging at station = " + charger.getUniqueId());
			}
		}

		System.out.println("----------------------------------------------------------------");
	}
}
