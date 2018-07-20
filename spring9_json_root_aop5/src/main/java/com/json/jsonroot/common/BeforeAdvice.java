package com.json.jsonroot.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/*
JoinPoint : �������̽��� �޼���
Signature getSignature() : ȣ��Ǵ� �޼��忡 ���� ������ ���մϴ�.
Object getTarget() : Ŭ���̾�Ʈ�� ȣ���� �����Ͻ� �޼��带 �����ϴ� ����Ͻ� ��ü
Object[] getArgs() : Ŭ���̾�Ʈ�� �޼��带 ȣ���� �� �Ѱ��� ���� ����� Object

�������� ó���� ������ LogAdvice Ŭ������ beforeLog()�޼���� �����մϴ�.
Advice : Ⱦ�� ���ɿ� �ش��ϴ� ���� ����� �ǹ��ϸ� ������ Ŭ������ �޼���� �ۼ��˴ϴ�.
 */

@Service
@Aspect
public class BeforeAdvice{
	/*
	 @Pointcut�� �����մϴ�.
	 �ϳ��� Advice Ŭ���� �ȿ� ���� ���� ����Ʈ ���� ������ �� �ֽ��ϴ�.
	 ���� ���� ����Ʈ ���� �ĺ��ϱ� ���� ���� �޼��带 �̿��մϴ�.
	 �� �޼���� ��ü�� ����ִ� �޼���� �ܼ��� ������ ���� �ĺ��ϱ� ���� �̸����θ� ���˴ϴ�.
	 */
	//pointcut
	@Pointcut("execution(* com.json.jsonroot..*Impl.get*(..))")
	public void getPointcut() {}
	
	/*
	 
	 @Before : �����Ͻ� �޼��� ���� ���� �����մϴ�.
	 @Before("getPointcut()") : getPointcut() ���� �޼���� ������ �޼��尡 ���� ���� Advice�� �޼��� beforeLog()�� ���� ȣ��˴ϴ�.
	
	 */
	 
	 //Advice
	@Before("getPointcut()")
	public void beforeLog(JoinPoint proceeding) {
	      System.out.println("========> BeforeAdvice : �����Ͻ� ���� ���� �� �����Դϴ�.");
	      System.out.println("========> "+proceeding.getTarget().getClass().getName()+"��"+proceeding.getSignature().getName()+"ȣ���Դϴ�.");
	   }
}

