package org.chargepoint.entity;

import java.util.Objects;


/**
 * Truck Description.
 *
 * @author Nagaraj Diveela
 */
public final class Truck implements Comparable
{
	private String uniqueId;

	private double batteryCapacity;

	private double currentChargeLevel;

	private double remainingChargingTime;


	public Truck(final String uniqueId, final double batteryCapacity, final double currentChargeLevel)
	{
		this.uniqueId = uniqueId;
		this.batteryCapacity = batteryCapacity;
		this.currentChargeLevel = currentChargeLevel;
	}


	public String getUniqueId()
	{
		return uniqueId;
	}


	public void setUniqueId(final String uniqueId)
	{
		this.uniqueId = uniqueId;
	}


	public double getBatteryCapacity()
	{
		return batteryCapacity;
	}


	public void setBatteryCapacity(final double batteryCapacity)
	{
		this.batteryCapacity = batteryCapacity;
	}


	public double getCurrentChargeLevel()
	{
		return currentChargeLevel;
	}


	public void setCurrentChargeLevel(final double currentChargeLevel)
	{
		this.currentChargeLevel = currentChargeLevel;
	}


	public double getRemainingChargingTime()
	{
		return remainingChargingTime;
	}


	public void setRemainingChargingTime(final double remainingChargingTime)
	{
		this.remainingChargingTime = remainingChargingTime;
	}


	@Override
	public boolean equals(final Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (o == null || getClass() != o.getClass())
		{
			return false;
		}
		final Truck truck = (Truck) o;
		return Double.compare(truck.batteryCapacity, batteryCapacity) == 0 &&
			   Double.compare(truck.currentChargeLevel, currentChargeLevel) == 0 &&
			   Double.compare(truck.remainingChargingTime, remainingChargingTime) == 0 &&
			   Objects.equals(uniqueId, truck.uniqueId);
	}


	@Override
	public int hashCode()
	{
		return Objects.hash(uniqueId, batteryCapacity, currentChargeLevel, remainingChargingTime);
	}


	@Override
	public int compareTo(final Object o)
	{
		return (getBatteryCapacity() < ((Truck) o).getBatteryCapacity() ? -1 : (getBatteryCapacity() == ((Truck) o).getBatteryCapacity() ? 0 : 1));
	}
}
