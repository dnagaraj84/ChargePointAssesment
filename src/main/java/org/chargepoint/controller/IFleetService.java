package org.chargepoint.controller;

import java.util.List;

import org.chargepoint.entity.Charger;
import org.chargepoint.entity.Truck;


/**
 * The fleet service which helps in scheduling the charging the fleets with charging ports.
 *
 * @author Nagaraj Diveela
 */
public interface IFleetService
{
	/**
	 * Method to identify the effective way of scheduling the charging mechanism.
	 *
	 * @param chargers            The available charging ports in the charge station. Must not be {@code null}.
	 * @param trucks              The trucks which needs to be recharged. Must not be {@code null}.
	 * @param chargingHoursPerDay The available time frame for charging the fleets. Must not be {@code null}.
	 */
	void identifyEffectiveWayOfCharging(List<Charger> chargers, List<Truck> trucks, double chargingHoursPerDay);
}
