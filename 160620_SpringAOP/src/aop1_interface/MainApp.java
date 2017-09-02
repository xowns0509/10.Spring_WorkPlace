package aop1_interface;

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

		ApplicationContext context = new ClassPathXmlApplicationContext("aop1_interface/applicationContext.xml");

		MessageBean bean = context.getBean("proxy", MessageBean.class);

		System.out.println("bean.sayHello(); 출력------------------------------------");
		bean.sayHello();
		
		System.out.println("bean.test(); 출력------------------------------------");
		bean.test();

		System.out.println("bean.korSayHello(); 출력------------------------------------");
		bean.korSayHello();
		
		MessageBeanImpl bean1 = context.getBean("proxy", MessageBeanImpl.class);

		System.out.println("bean.sayHello(); 출력------------------------------------");
		bean1.sayHello();
		
		System.out.println("bean.test(); 출력------------------------------------");
		bean1.test();

		System.out.println("bean.korSayHello(); 출력------------------------------------");
		bean1.korSayHello();
		
		bean1.enSayHello();

	}

}
