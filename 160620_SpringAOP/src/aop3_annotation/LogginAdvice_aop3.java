package aop3_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * AOP(Aspect Oriented Program) :관점 지향 프로그램 3. annotation 이용
 * 
 * @author TaeJoon
 *
 */
@Aspect
public class LogginAdvice_aop3 {

	@Around("execution(public * aop3_annotaion.*.*Hello(..))")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		String methodName = point.getSignature().getName(); // 함수 이름 얻어오기

		System.out.println("[사전작업]" + methodName);
		Object obj = point.proceed(); // 진행하고자 하는
		// 낚아 채기만 하는거니까 고스란히 돌려줘야 하지.
		System.out.println("[사후작업]" + methodName);
		return obj;

	}

}
