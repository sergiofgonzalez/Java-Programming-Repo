package org.joolzminer.examples.async.api;

import org.joolzminer.examples.async.utils.Utils;

public class ExchangeService {
	public enum Money {
		USD(1.0),
		EUR(1.35387),
		GBP(1.69715);
		
		private final double rate;
		
		Money(double rate) {
			this.rate = rate;
		}	
	}
	
	public static double getRate(Money source, Money target) {
		Utils.randomDelay();
		return target.rate / source.rate;
	}
}
