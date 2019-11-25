package com.coo.s4.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class Card {
	
	public void cash() {
		System.out.println("우리같은 사람은 현금이 좋은데");
	}
	

	public Object cardCheck(ProceedingJoinPoint join) {
		System.out.println("삑! 승차입니다");
		Object obj = null;
		try {
			Object[] args = join.getArgs();
			for (Object object : args) {
				System.out.println(object);
			}
			obj = join.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("삑! 하차입니다");
		
		return obj;
	}
}
