package com.epam.memorylyeak;

import java.util.HashMap;
import java.util.Map;

public class EpamEmployeeCache {
	private Map<Integer, EpamEmployee> cache = new HashMap<Integer, EpamEmployee>();
	
	private int counter;
	
	public EpamEmployee getEmployee(int number) {
		return cache.get(number);
	}
	
	public int addEmployee(EpamEmployee employee) {
		System.out.println("adding to cache employee #" + counter);
		cache.put(counter++, employee);
		return counter;
	}
}
