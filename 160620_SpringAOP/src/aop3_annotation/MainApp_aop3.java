package aop3_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AOP(Aspect Oriented Program) :관점 지향 프로그램 1. 스프링 API의 interface를 이용한 방법
 * 
 * @author TaeJoon
 *
 */
public class MainApp_aop3 {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("aop3_annotation/applicationContext_aop3.xml");

		MessageBean_aop3 bean = context.getBean("targetBean", MessageBean_aop3.class);

		System.out.println("bean.sayHello(); start ------------------------------------");
		bean.sayHello();
		System.out.println("bean.sayHello(); end ------------------------------------");
		
		System.out.println("bean.test(); start ------------------------------------");
		bean.engSayHello();
		System.out.println("bean.korSayHello(); end ------------------------------------");
		

	}

}
