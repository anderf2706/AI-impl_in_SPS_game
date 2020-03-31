package com.game1;

import com.game1.Nature;

import java.util.Comparator;

public class INTComparatorNature implements Comparator<Nature> {

	@Override
	public int compare(Nature o1, Nature o2) {
		return o2.gety().compareTo(o1.gety());
	}


}
