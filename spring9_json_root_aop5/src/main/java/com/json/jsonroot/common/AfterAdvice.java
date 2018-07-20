package com.json.jsonroot.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

//공통으로 처리할 로직을 LogAdvice 

@Service
@Aspect
public class AfterAdvice {
	
	@Pointcut("execution(* com.json.jsonroot..*Impl.set*(..))")
	public void setPointcut() {}
	
	@After("setPointcut()")
	public void afterLog(JoinPoint proceeding) {
	      System.out.println("========> AfterAdvice : 비지니스 로직 수행 후 동작입니다.");
	      System.out.println("========> "+proceeding.getTarget().getClass().getName()+"의"+proceeding.getSignature().getName()+"호출입니다.");
	   }

}
