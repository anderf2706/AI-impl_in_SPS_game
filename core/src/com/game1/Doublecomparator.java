package com.game1;

import java.util.Comparator;
import java.util.List;

public class Doublecomparator implements Comparator<List>
{
	@Override
	public int compare(List o1, List o2) {
		return Double.compare((Double)o1.get(0), (Double)o2.get(0));
	}
}