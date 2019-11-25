package com.coo.s4.transfer;

import org.springframework.stereotype.Component;

@Component
public class Transfer {
	
	
	public void taxi() {
		System.out.println(" -택시-");
		System.out.println("택시택시택시 즉시즉시즉시");
		System.out.println(" -택시-");
	}
	
	public void getBus(String cardName) {
		System.out.println(" --버스--");
		System.out.println(" 음악듣기");
		System.out.println(" --버스--");
	}
	
	
	public void getSubway(String cardName) {
		System.out.println(" ---지하철--- ");
		System.out.println("폰보기");
		System.out.println(" ---지하철---");
	}
	
	public void car() {
		System.out.println("----붕붕----");
		System.out.println("전방주시");
		System.out.println("----붕붕----");
	}

}
