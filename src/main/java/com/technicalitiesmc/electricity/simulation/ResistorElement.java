package com.technicalitiesmc.electricity.simulation;

import com.technicalitiesmc.api.electricity.IEnergyReceiver;

import javax.annotation.Nullable;

/**
 * Created by Elec332 on 14-11-2017.
 */
public class ResistorElement extends AbstractResistorElement<IEnergyReceiver> {

	public ResistorElement(IEnergyReceiver receiver) {
		super(receiver);
		this.resistance = receiver.getResistance();
	}

	private double resistance;

	@Override
	public double getResistance() {
		return resistance;
	}

	@Nullable
	@Override
	protected IEnergyReceiver getReceiver() {
		return energyTile;
	}

	@Override
	public void apply() {
		energyTile.receivePower(getVoltageDiff(), current);
	}

}