package aop2_xml;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * AOP(Aspect Oriented Program) :관점 지향 프로그램 2. xml 기반으로 이용
 * 
 * @author TaeJoon
 *
 */
public class LogginAdvice {

	public Object around(ProceedingJoinPoint point) throws Throwable {
		String methodName = point.getSignature().getName(); // 함수 이름 얻어오기

		System.out.println("[사전작업]" + methodName);
		Object obj = point.proceed(); // 진행하고자 하는
		// 낚아 채기만 하는거니까 고스란히 돌려줘야 하지.
		System.out.println("[사후작업]" + methodName);
		return obj;

	}

}
