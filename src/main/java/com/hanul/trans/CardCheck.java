package com.hanul.trans;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CardCheck {
	@Around("execution(* com.hanul.trans.Transport.*())")
	public Object check(ProceedingJoinPoint join) {
		System.out.println("ī�����");
		System.out.println("�л��Դϴ�.");
		Object obj = null;
		
		try {
			obj=join.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ī�����");
		System.out.println("��--");
		return obj;
	}
	
	@Before("execution(* com.hanul.trans.Trip.*())")
	public void packing() {
		System.out.println("���α�");
	}
}
