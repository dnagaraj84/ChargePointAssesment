package org.chargepoint.entity;

/**
 * The POJO describing the Charging ports.
 *
 * @author Nagaraj Diveela
 */
public final class Charger
{
	private String uniqueId;

	private double chargingRate;


	public Charger(final String uniqueId, final double chargingRate)
	{
		this.uniqueId = uniqueId;
		this.chargingRate = chargingRate;
	}


	public String getUniqueId()
	{
		return uniqueId;
	}


	public void setUniqueId(final String uniqueId)
	{
		this.uniqueId = uniqueId;
	}


	public double getChargingRate()
	{
		return chargingRate;
	}


	public void setChargingRate(final double chargingRate)
	{
		this.chargingRate = chargingRate;
	}
}
