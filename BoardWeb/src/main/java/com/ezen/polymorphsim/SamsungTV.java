package com.ezen.polymorphsim;

public class SamsungTV implements TV{
	
	private Spearker spearker;
	private int price;
	
	public void initMethod() {
		System.out.println("생성자 initMethod ==> 초기화 문장 기입");
	}
	
	public void destroyMethod() {
		System.out.println("객체 소멸시 구동");
	}

	public SamsungTV() {
		System.out.println("생성자 SamsungTV");
	}
	
	public SamsungTV(Spearker spearker) {
		this.spearker = spearker;
		System.out.println("생성자 SamsungTV(spearker)");
	}
	
	public SamsungTV(Spearker spearker, int price) {
		this.spearker = spearker;
		this.price = price;
		System.out.println("생성자 SamsungTV(spearker) : " + price);
	}
	
	public void setSpearker(Spearker spearker) {
		this.spearker = spearker;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public void powerOn() {
		System.out.println("SamsungTV powerOn : " + price);	
	}

	@Override
	public void powerOff() {
		System.out.println("SamsungTV powerOff");
	}

	@Override
	public void volumeUp() {
//		System.out.println("SamsungTV volumeUp");
//		spearker = new SonySpearker();
		spearker.volumeUp();
	}

	@Override
	public void volumeDown() {
//		System.out.println("SamsungTV volumeDown");
//		spearker = new SonySpearker();
		spearker.volumeDown();
	}

}
