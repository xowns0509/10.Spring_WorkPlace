package annotation2.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		// sayHello()함수 호출... 하기위해선 일단
		// 스프링의 설정파일 읽는 놈
		ApplicationContext context = new ClassPathXmlApplicationContext("annotation2/autowired/applicationContext.xml");

		
		
		
		MessageBean bean = context.getBean("message", MessageBean.class);

		bean.sayHello();


	}
}
