package org.chargepoint;

import java.util.ArrayList;
import java.util.List;

import org.chargepoint.controller.FleetService;
import org.chargepoint.controller.IFleetService;
import org.chargepoint.entity.Charger;
import org.chargepoint.entity.Truck;


/**
 * The fleet scheduling application.
 */
public class Application
{
	public static void main(final String[] args)
	{
		// Define the charging ports here.
		final Charger charger01 = new Charger("C001", 50);
		final Charger charger02 = new Charger("C002", 50);

		// Define the fleets here.
		final Truck truck01 = new Truck("T001", 40, 25);
		final Truck truck02 = new Truck("T002", 40, 50);
		final Truck truck03 = new Truck("T003", 40, 75);
		final Truck truck04 = new Truck("T004", 40, 90);

		// Provide the charging hours for the day here.
		// Converting into minutes
		final double chargingHoursPerDay = 1 * 60;

		final List<Truck> trucks = new ArrayList<>();
		final List<Charger> chargers = new ArrayList<>();

		trucks.add(truck01);
		trucks.add(truck02);
		trucks.add(truck03);
		trucks.add(truck04);

		chargers.add(charger01);
		chargers.add(charger02);

		final IFleetService fleetService = new FleetService();

		fleetService.identifyEffectiveWayOfCharging(chargers, trucks, chargingHoursPerDay);
	}
}
