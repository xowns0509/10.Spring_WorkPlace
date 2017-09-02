package aop3_annotation.order;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;

/**
 * AOP(Aspect Oriented Program) :관점 지향 프로그램 3. annotation 기반으로 이용. 골뱅이 쓰라고
 * 
 * @author TaeJoon
 *
 */
// @Aspect, @Order()<<이건 순서지정, @Around<<메소드 앞에 쓰는거
// 근데 @Around 말고 각 메소드별 어노테이션이 존재.
@Aspect
@Order(1)
public class LoggingSample {
	
	@Before("execution(public * *(..))")
	public void before(JoinPoint p) {
		System.out.println("before: 메소드 호출 전" + p);

	}

	@AfterReturning("execution(public * *(..))")
	public void afterReturning(JoinPoint p) {
		System.out.println("afterReturning: 메소드 호출 된 후 예외발생 없는 경우" + p);

	}

	@After("execution(public * *(..))")
	public void afterFinally(JoinPoint p) {
		System.out.println("afterFinally: 메소드 호출 된 후 예외발생 관계 없이 호출" + p);

	}

}
