package aop2_xml.order;

import org.aspectj.lang.JoinPoint;

public class LoggingSample {
	public void before(JoinPoint p) {
		System.out.println("before: 메소드 호출 전" + p);

	}
	
	public void afterReturning(JoinPoint p){
		System.out.println("afterReturning: 메소드 호출 된 후 예외발생 없는 경우" + p);
		
	}
	
	public void afterFinally(JoinPoint p){
		System.out.println("afterFinally: 메소드 호출 된 후 예외발생 관계 없이 호출" + p);
		
	}

}
