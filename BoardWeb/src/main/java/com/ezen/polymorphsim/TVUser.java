package com.ezen.polymorphsim;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {
	public static void main(String[] args) {
		
		//1. 스프링 컨테이너 구동
		AbstractApplicationContext factory = 
					new GenericXmlApplicationContext("applicationContext.xml");
		
		//2. 스프링 컨테이너에서 필요한 빈을 요청
		TV tv1 = (TV)factory.getBean("tv");
		TV tv2 = (TV)factory.getBean("tv");
		
		tv1.powerOn();
		tv1.volumeUp();
		tv2.volumeDown();
		
		factory.close();
	}
}
