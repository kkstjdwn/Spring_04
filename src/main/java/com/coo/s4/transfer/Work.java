package com.coo.s4.transfer;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class Work {
	@Inject
	private Transfer transfer;

	public void goToWork() {
		
		transfer.getBus("samsung");
		transfer.getSubway("kakao");
		
	}

}
