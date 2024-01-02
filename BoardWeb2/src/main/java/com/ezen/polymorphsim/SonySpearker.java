package com.ezen.polymorphsim;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpearker implements Spearker{
	
	public SonySpearker() {
		System.out.println("SonySpearker 생성자");
	}

	@Override
	public void volumeUp() {
		System.out.println("SonySpearker volumeUp");
	}

	@Override
	public void volumeDown() {
		System.out.println("SonySpearker volumeDown");
	}

}