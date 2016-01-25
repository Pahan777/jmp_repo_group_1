package com.epam.memorylyeak;

public class Main {
	
	public static void main(String[] args) {
		EpamEmployeeCache cache = new EpamEmployeeCache();
		
		while (true) {
			cache.addEmployee(new EpamEmployee("Leonid"));
		}
	}
}
