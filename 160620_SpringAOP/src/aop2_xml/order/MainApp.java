package aop2_xml.order;

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

		ApplicationContext context = new ClassPathXmlApplicationContext("aop2_xml/order/applicationContext.xml");

		MemberService service = context.getBean("targetBean", MemberService.class);
		service.update("홍길동");
		

	}

}
