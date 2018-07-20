package com.json.jsonroot.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//�������� ó���� ������ LogAdvice 

@Service
@Aspect
public class AfterAdvice {
	
	@Pointcut("execution(* com.json.jsonroot..*Impl.set*(..))")
	public void setPointcut() {}
	
	@After("setPointcut()")
	public void afterLog(JoinPoint proceeding) {
	      System.out.println("========> AfterAdvice : �����Ͻ� ���� ���� �� �����Դϴ�.");
	      System.out.println("========> "+proceeding.getTarget().getClass().getName()+"��"+proceeding.getSignature().getName()+"ȣ���Դϴ�.");
	   }

}
