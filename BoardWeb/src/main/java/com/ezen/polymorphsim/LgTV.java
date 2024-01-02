package com.ezen.polymorphsim;

public class LgTV implements TV{

	public LgTV() {
		System.out.println("생성자 LGTV");
	}
	
	@Override
	public void powerOn() {
		System.out.println("LGTV powerON");
	}

	@Override
	public void powerOff() {
		System.out.println("LGTV powerOff");
	}

	@Override
	public void volumeUp() {
		System.out.println("LGTV volumeUp");
	}

	@Override
	public void volumeDown() {
		System.out.println("LGTV volumeDown");
	}

}
