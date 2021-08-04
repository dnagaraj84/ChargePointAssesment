package org.chargepoint.helper;

import java.util.List;

import org.chargepoint.entity.Charger;
import org.chargepoint.entity.Task;
import org.chargepoint.entity.Truck;


/**
 * The interface which describes about the scheduling algorithm which needs to be implemented.
 *
 * @author Nagaraj Diveela
 */
public interface ISchedulingHelper
{
	/**
	 * The shortest remaining time algorithm for scheduling the fleets.
	 *
	 * @param chargers            The available charging ports in the charge station. Must not be {@code null}.
	 * @param trucks              The trucks which needs to be recharged. Must not be {@code null}.
	 * @param chargingHoursPerDay The available time frame for charging the fleets. Must not be {@code null}.
	 * @return The list of {@link Task} containing details about the task which will be scheduled.
	 */
	List<Task> scheduleBasedOnShortRemainingTime(List<Charger> chargers, List<Truck> trucks, double chargingHoursPerDay);
}
