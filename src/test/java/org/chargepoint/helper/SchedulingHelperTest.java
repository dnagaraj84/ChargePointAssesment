package org.chargepoint.helper;

import java.util.ArrayList;
import java.util.List;

import org.chargepoint.entity.Charger;
import org.chargepoint.entity.Task;
import org.chargepoint.entity.Truck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


/**
 * Tests the integrity of {@link SchedulingHelper}.
 *
 * @author Nagaraj Diveela
 */
public final class SchedulingHelperTest
{
	/**
	 * Class under test.
	 */
	private SchedulingHelper schedulingHelper;


	/**
	 * Initialization.<p/>
	 * <p>
	 * Creates and sets up the service under test.
	 */
	@Before
	public void setUp()
	{
		schedulingHelper = new SchedulingHelper();
	}


	/**
	 * Tests the integrity of {@link SchedulingHelper#scheduleBasedOnShortRemainingTime(List, List, double)}.
	 */
	@Test
	public void testScheduleBasedOnShortRemainingTime()
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
		final double chargingHoursPerDay = 1;
		final double chargingMinutesPerDay = chargingHoursPerDay * 60;

		final List<Truck> trucks = new ArrayList<>();
		final List<Charger> chargers = new ArrayList<>();

		trucks.add(truck01);
		trucks.add(truck02);
		trucks.add(truck03);
		trucks.add(truck04);

		chargers.add(charger01);
		chargers.add(charger02);

		final List<Task> tasks = schedulingHelper.scheduleBasedOnShortRemainingTime(chargers, trucks, chargingMinutesPerDay);

		Assert.assertNotNull(tasks);
		Assert.assertSame(tasks.size(), 2);
		Assert.assertThat(tasks.get(0).getCharger().getUniqueId(), is("C001"));
		Assert.assertThat(tasks.get(0).getTrucks().get(0).getUniqueId(), is("T001"));
	}


	/**
	 * Tests the integrity of {@link SchedulingHelper#scheduleBasedOnShortRemainingTime(List, List, double)}.
	 */
	@Test
	public void testScheduleBasedOnShortRemainingTimeWithEmptyLists()
	{
		// Provide the charging hours for the day here.
		// Converting into minutes
		final double chargingHoursPerDay = 1;
		final double chargingMinutesPerDay = chargingHoursPerDay * 60;

		final List<Truck> trucks = new ArrayList<>();
		final List<Charger> chargers = new ArrayList<>();

		final List<Task> tasks = schedulingHelper.scheduleBasedOnShortRemainingTime(chargers, trucks, chargingMinutesPerDay);

		Assert.assertNotNull(tasks);
		Assert.assertSame(tasks.size(), 0);
	}


	/**
	 * Tests the integrity of {@link SchedulingHelper#scheduleBasedOnShortRemainingTime(List, List, double)}.
	 */
	@Test
	public void testScheduleBasedOnShortRemainingTimeWithZeroChargingTime()
	{
		// Provide the charging hours for the day here.
		// Converting into minutes
		final double chargingHoursPerDay = 0;
		final double chargingMinutesPerDay = chargingHoursPerDay * 60;

		final List<Truck> trucks = new ArrayList<>();
		final List<Charger> chargers = new ArrayList<>();

		final List<Task> tasks = schedulingHelper.scheduleBasedOnShortRemainingTime(chargers, trucks, chargingMinutesPerDay);

		Assert.assertNotNull(tasks);
		Assert.assertSame(tasks.size(), 0);
	}


	/**
	 * Tests the integrity of {@link SchedulingHelper#scheduleBasedOnShortRemainingTime(List, List, double)}.
	 */
	@Test
	public void testScheduleBasedOnShortRemainingTimeWithEmptyChargers()
	{
		// Define the fleets here.
		final Truck truck01 = new Truck("T001", 40, 25);
		final Truck truck02 = new Truck("T002", 40, 50);
		final Truck truck03 = new Truck("T003", 40, 75);
		final Truck truck04 = new Truck("T004", 40, 90);

		// Provide the charging hours for the day here.
		// Converting into minutes
		final double chargingHoursPerDay = 1;
		final double chargingMinutesPerDay = chargingHoursPerDay * 60;

		final List<Truck> trucks = new ArrayList<>();
		final List<Charger> chargers = new ArrayList<>();

		trucks.add(truck01);
		trucks.add(truck02);
		trucks.add(truck03);
		trucks.add(truck04);

		final List<Task> tasks = schedulingHelper.scheduleBasedOnShortRemainingTime(chargers, trucks, chargingMinutesPerDay);

		Assert.assertNotNull(tasks);
		Assert.assertSame(tasks.size(), 0);
	}


	/**
	 * Tests the integrity of {@link SchedulingHelper#scheduleBasedOnShortRemainingTime(List, List, double)}.
	 */
	@Test
	public void testScheduleBasedOnShortRemainingTimeWithEmptyFleets()
	{
		// Define the charging ports here.
		final Charger charger01 = new Charger("C001", 50);
		final Charger charger02 = new Charger("C002", 50);

		// Provide the charging hours for the day here.
		// Converting into minutes
		final double chargingHoursPerDay = 1;
		final double chargingMinutesPerDay = chargingHoursPerDay * 60;

		final List<Truck> trucks = new ArrayList<>();
		final List<Charger> chargers = new ArrayList<>();

		chargers.add(charger01);
		chargers.add(charger02);

		final List<Task> tasks = schedulingHelper.scheduleBasedOnShortRemainingTime(chargers, trucks, chargingMinutesPerDay);

		Assert.assertNotNull(tasks);
		Assert.assertSame(tasks.size(), 0);
	}


	/**
	 * Tests the integrity of {@link SchedulingHelper#scheduleBasedOnShortRemainingTime(List, List, double)}.
	 */
	@Test
	public void testScheduleBasedOnShortRemainingTimeWithNullFleets()
	{
		// Define the charging ports here.
		final Charger charger01 = new Charger("C001", 50);
		final Charger charger02 = new Charger("C002", 50);

		// Provide the charging hours for the day here.
		// Converting into minutes
		final double chargingHoursPerDay = 1;
		final double chargingMinutesPerDay = chargingHoursPerDay * 60;

		final List<Truck> trucks = null;
		final List<Charger> chargers = new ArrayList<>();

		chargers.add(charger01);
		chargers.add(charger02);

		final List<Task> tasks = schedulingHelper.scheduleBasedOnShortRemainingTime(chargers, trucks, chargingMinutesPerDay);

		Assert.assertNotNull(tasks);
		Assert.assertSame(tasks.size(), 0);
	}


	/**
	 * Tests the integrity of {@link SchedulingHelper#scheduleBasedOnShortRemainingTime(List, List, double)}.
	 */
	@Test
	public void testScheduleBasedOnShortRemainingTimeWithNullChargingPorts()
	{
		// Define the fleets here.
		final Truck truck01 = new Truck("T001", 40, 25);
		final Truck truck02 = new Truck("T002", 40, 50);
		final Truck truck03 = new Truck("T003", 40, 75);
		final Truck truck04 = new Truck("T004", 40, 90);

		// Provide the charging hours for the day here.
		// Converting into minutes
		final double chargingHoursPerDay = 1;
		final double chargingMinutesPerDay = chargingHoursPerDay * 60;

		final List<Truck> trucks = new ArrayList<>();
		final List<Charger> chargers = null;

		trucks.add(truck01);
		trucks.add(truck02);
		trucks.add(truck03);
		trucks.add(truck04);

		final List<Task> tasks = schedulingHelper.scheduleBasedOnShortRemainingTime(chargers, trucks, chargingMinutesPerDay);

		Assert.assertNotNull(tasks);
		Assert.assertSame(tasks.size(), 0);
	}


	/**
	 * Tests the integrity of {@link SchedulingHelper#scheduleBasedOnShortRemainingTime(List, List, double)}.
	 */
	@Test
	public void testScheduleBasedOnShortRemainingTimeWithBothObjectsNull()
	{
		// Provide the charging hours for the day here.
		// Converting into minutes
		final double chargingHoursPerDay = 1;
		final double chargingMinutesPerDay = chargingHoursPerDay * 60;

		final List<Truck> trucks = null;
		final List<Charger> chargers = null;

		final List<Task> tasks = schedulingHelper.scheduleBasedOnShortRemainingTime(chargers, trucks, chargingMinutesPerDay);

		Assert.assertNotNull(tasks);
		Assert.assertSame(tasks.size(), 0);
	}
}
