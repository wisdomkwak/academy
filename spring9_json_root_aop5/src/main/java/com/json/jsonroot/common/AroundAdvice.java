package com.json.jsonroot.common;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;
	/*
	 PreceedingJoinPoint �������̽� JoinPoint�� ����߱� ������ JoinPoint�� ���� ��� �޼��带 �����մϴ�.
	 Around Advice������ ProceedingJoinPoint�� �ް������� ����ϴµ� �� ������ proceed()�޼��尡 �ʿ��ϱ� �����Դϴ�.
     Around Advice�� ��� ����Ͻ� �޼��� ���� ���� �Ŀ� ����Ǵµ� ����Ͻ� �޼��带 ȣ���ϱ� ���ؼ��� 
     ProceedingJoinPoint�� proceed()�޼��尡 �ʿ��մϴ�.
          ��, Ŭ���̾�Ʈ�� ��û�� ����æ �����̽���  Ŭ���̾�Ʈ�� ȣ���� ����Ͻ� �޼���(ServcieImpl�� get���� �����ϴ� �޼���)�� ȣ���ϱ� ����
     ProceedingJoinPoin ��ü�� �Ű� ������ �޾� proceed()�޼��带 ���ؼ� ����Ͻ� �޼��带 ȣ���� �� �ֽ��ϴ�.
	 */
@Service
@Aspect //@Aspect�� ������ Ŭ�������� Pointcut�� Advice�� �����ϴ� ������ �־�� �մϴ�.
public class AroundAdvice {
	/*
	 @Pointcut�� �����մϴ�.
	 �ϳ��� Adivce Ŭ���� �ȿ� ���� ���� ����Ʈ ���� ������ �� �ֽ��ϴ�.
	 ���� ���� ����Ʈ ���� �ĺ��ϱ� ���� ���� �޼��带 �̿��մϴ�.
	 �� �޼���� ��ü�� ����ִ� �޼���� �ܼ��� ������ ���� �ĺ��ϱ� ���� �̸����θ� ���˴ϴ�.
	 */
	//pointcut
	@Pointcut("execution(* com.json.jsonroot..*Impl.set*(..))")
	public void getPointcut() {}
	
	@Around("getPointcut()")
	public Object aroundLog(ProceedingJoinPoint proceeding) throws Throwable {
		
		System.out.println("========> AroundAdvice�� before : �����Ͻ� �޼��� ���� �� �Դϴ�.");
		StopWatch sw = new StopWatch();
		sw.start();
		
		//�� �ڵ��� ������ ���Ŀ� ���� ����� ���� �ڵ带 ��ġ ��Ű�� �˴ϴ�.
		//��� ��ü�� �޼��� public void setInsert(BoardVO b)�� ȣ���մϴ�.
		Object result = proceeding.proceed();
		
		sw.stop();
		
		System.out.println("========> AroundAdvice�� after : �����Ͻ� �޼��� ���� �� �Դϴ�.");
		
	   //org.aspectj.lang.Signature �������̽��� ȣ��Ǵ� �޼���� ���õ� ������ �����մϴ�.
	   //String getName() �޼����� �̸��� ���մϴ�.
	   //String toLongString() �޼��带 �����ϰ� ǥ���� ������ ���մϴ�.(�޼����� ���� Ÿ��, �Ķ���� Ÿ��)
	   //String toShortString() �޼��带 �����ϰ� ǥ���� ������ ���մϴ�(�⺻ ������ �޼����� �̸�)
	   //Object[] getArgs() : Ŭ���̾�Ʈ�� �޼��带 ȣ���� �� �Ѱ��� ���� ����� Object �迭�� �����մϴ�.
		
		Signature sig = proceeding.getSignature();
		System.out.printf("========> %s.%s(%s) \n",proceeding.getTarget().getClass().getSimpleName(),
				sig.getName(), Arrays.toString(proceeding.getArgs()));
		
		System.out.println("========> "+proceeding.getSignature().getName()+"()�޼ҵ� ���� �ð� : "+sw.getTotalTimeMillis()+"(ms)��");
		System.out.println("========> "+proceeding.getTarget().getClass().getName());
		
		return result;
	}
}
