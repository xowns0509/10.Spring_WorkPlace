package aop3_annotation.order;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

/**
 * AOP(Aspect Oriented Program) :관점 지향 프로그램 3. annotation 기반으로 이용. 골뱅이 쓰라고
 * 
 * @author TaeJoon
 *
 */
//@Aspect, @order()<<이건 순서지정, @Around<<메소드 앞에 쓰는거
// 근데 @Around 말고 각 메소드별 어노테이션이 존재.
@Aspect
@Order(2)
public class LoggingAdvice {
	
	@Around("execution(public * *(..))")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		
		String methodName = point.getSignature().getName(); // 함수 이름 얻어오기

		System.out.println("[사전작업]" + methodName);
		Object obj = point.proceed(); // 진행하고자 하는
		// 낚아 채기만 하는거니까 고스란히 돌려줘야 하지.
		System.out.println("[사후작업]" + methodName);
		return obj;

	}

}
