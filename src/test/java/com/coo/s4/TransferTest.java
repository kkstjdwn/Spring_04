package com.coo.s4;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.coo.s4.transfer.Work;

public class TransferTest extends TestAbstractCase{
	
	@Inject
	private Work work;
	@Test
	public void test() {
		
		work.rideTaxi();
		
	}

}
