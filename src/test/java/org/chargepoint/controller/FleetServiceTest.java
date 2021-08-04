package org.chargepoint.controller;

import java.util.ArrayList;
import java.util.List;

import org.chargepoint.entity.Charger;
import org.chargepoint.entity.Task;
import org.chargepoint.entity.Truck;
import org.chargepoint.helper.SchedulingHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Tests the integrity of {@link FleetService}.
 *
 * @author Nagaraj Diveela
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(FleetService.class)
public class FleetServiceTest
{
	/**
	 * References the fleet service class.
	 */
	@InjectMocks
	private FleetService fleetService;


	@Test
	public void testIdentifyEffectiveWayOfChargingAssertNoExceptions() throws Exception
	{
		final List<Truck> trucks = new ArrayList<>();
		final List<Charger> chargers = new ArrayList<>();
		final List<Task> tasks = new ArrayList<>();

		final double chargingHoursPerDay = 1;
		final double chargingMinutesPerDay = chargingHoursPerDay * 60;

		final SchedulingHelper schedulingHelper = mock(SchedulingHelper.class);
		when(schedulingHelper.scheduleBasedOnShortRemainingTime(chargers, trucks, chargingMinutesPerDay)).thenReturn(tasks);
		PowerMockito.whenNew(SchedulingHelper.class).withNoArguments().thenReturn(schedulingHelper);

		fleetService.identifyEffectiveWayOfCharging(chargers, trucks, chargingMinutesPerDay);

		verify(schedulingHelper, times(1)).scheduleBasedOnShortRemainingTime(chargers, trucks, chargingMinutesPerDay);
	}
}
