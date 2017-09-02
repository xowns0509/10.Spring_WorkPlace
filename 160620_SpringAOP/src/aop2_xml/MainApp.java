package aop2_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * AOP(Aspect Oriented Program) :관점 지향 프로그램 1. 스프링 API의 interface를 이용한 방법
 * 
 * @author TaeJoon
 *
 */
public class MainApp {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("aop2_xml/applicationContext.xml");

		MessageBean bean = context.getBean("targetBean", MessageBean.class);

		System.out.println("bean.sayHello(); start ------------------------------------");
		bean.sayHello();
		System.out.println("bean.sayHello(); end ------------------------------------");
		
		System.out.println("bean.test(); start ------------------------------------");
		bean.engSayHello();
		System.out.println("bean.korSayHello(); end ------------------------------------");
		

	}

}
