package com.json.jsonroot.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/*
JoinPoint : 인터페이스의 메서드
Signature getSignature() : 호출되는 메서드에 대한 정보를 구합니다.
Object getTarget() : 클라이언트가 호출한 비지니스 메서드를 포함하는 비즈니스 객체
Object[] getArgs() : 클라이언트가 메서드를 호출할 때 넘겨준 인자 목록을 Object

공통으로 처리할 로직을 LogAdvice 클래스에 beforeLog()메서드로 구현합니다.
Advice : 횡단 관심에 해당하는 공통 기능을 의미하며 독립된 클래스의 메서드로 작성됩니다.
 */

@Service
@Aspect
public class BeforeAdvice{
	/*
	 @Pointcut을 설정합니다.
	 하나의 Advice 클래스 안에 여러 개의 포인트 컷을 선언할 수 있습니다.
	 여러 개의 포인트 컷을 식별하기 위해 참조 메서드를 이용합니다.
	 이 메서드는 몸체가 비어있는 메서드로 단순히 포인터 컷을 식별하기 위한 이름으로만 사용됩니다.
	 */
	//pointcut
	@Pointcut("execution(* com.json.jsonroot..*Impl.get*(..))")
	public void getPointcut() {}
	
	/*
	 
	 @Before : 비지니스 메서드 실행 전에 동작합니다.
	 @Before("getPointcut()") : getPointcut() 참조 메서드로 지정한 메서드가 실행 전에 Advice의 메서드 beforeLog()가 먼저 호출됩니다.
	
	 */
	 
	 //Advice
	@Before("getPointcut()")
	public void beforeLog(JoinPoint proceeding) {
	      System.out.println("========> BeforeAdvice : 비지니스 로직 수행 전 동작입니다.");
	      System.out.println("========> "+proceeding.getTarget().getClass().getName()+"의"+proceeding.getSignature().getName()+"호출입니다.");
	   }
}

