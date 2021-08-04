package org.chargepoint.entity;

import java.util.List;


/**
 * The POJO describing the tasks to be scheduled.
 *
 * @author Nagaraj Diveela
 */
public final class Task
{
	private List<Truck> trucks;

	private Charger charger;


	public Task(final List<Truck> trucks, final Charger charger)
	{
		this.trucks = trucks;
		this.charger = charger;
	}


	public List<Truck> getTrucks()
	{
		return trucks;
	}


	public void setTrucks(final List<Truck> trucks)
	{
		this.trucks = trucks;
	}


	public Charger getCharger()
	{
		return charger;
	}


	public void setCharger(final Charger charger)
	{
		this.charger = charger;
	}
}
