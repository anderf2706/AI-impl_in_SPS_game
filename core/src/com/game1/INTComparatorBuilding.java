package com.game1;

import com.game1.Nature;

import java.util.Comparator;

public class INTComparatorBuilding implements Comparator<Building> {

	@Override
	public int compare(Building o1, Building o2) {
		return o2.gety().compareTo(o1.gety());
	}


}
