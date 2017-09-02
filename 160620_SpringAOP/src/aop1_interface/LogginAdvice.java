package aop1_interface;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * AOP(Aspect Oriented Program) :관점 지향 프로그램 1. 스프링 API의 interface를 이용한 방법
 * 
 * @author TaeJoon
 *
 */
public class LogginAdvice implements MethodInterceptor {

	// 얘가 뭘 하냐면.
	// 어떤 함수가 호출 되기 전과 후에 공통 관심사항?!
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		// 공통관심사항 사전처리 부분
		String methodName = invocation.getMethod().getName();
		System.out.println("[LOG]: " + methodName + "이 호출되기 전 관심사항");

		Object obj = invocation.proceed();//껴들어가는 거
		// 공통관심사항 사후처리 부분.
		System.out.println("[LOG]: " + methodName + "이 호출된 후의 관심사항");
		
		return obj;
	}
	// beans를 관리해주는 스프링이.

}
