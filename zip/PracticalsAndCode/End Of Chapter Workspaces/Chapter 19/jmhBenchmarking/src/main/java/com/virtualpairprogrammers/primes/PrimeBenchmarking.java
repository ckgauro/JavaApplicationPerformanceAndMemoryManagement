package com.virtualpairprogrammers.primes;

import org.openjdk.jmh.annotations.Benchmark;

public class PrimeBenchmarking {
	
	
	@Benchmark
	public void version1() {
		main.Main v1main = new main.Main();
		try {
			v1main.version1();
		} catch (InterruptedException e) {
			
		}
	}
	
	@Benchmark
	public void version2() {
		main.Main v2main = new main.Main();
		try {
			v2main.version2();
		} catch (InterruptedException e) {
			
		}
	}
}
