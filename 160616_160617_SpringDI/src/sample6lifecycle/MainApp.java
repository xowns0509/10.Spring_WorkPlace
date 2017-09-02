package sample6lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		// sayHello()함수 호출... 하기위해선 일단
		// 스프링의 설정파일 읽는 놈
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("sample6lifecycle/applicationContext.xml");

		// ApplicationContext의 부모인 AbstractApplicationContext로 만듬.

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"sample6lifecycle/applicationContext.xml");
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("sample6lifecycle/applicationContext.xml");

		MessageBean bean = context.getBean("bean", MessageBean.class);
		// getBean으로
		// bean의
		// id를
		// 지명.
		// 근데
		// 그놈은
		// MessageBean이란
		// 클래스지.
		bean.sayHello();

		// 굳이 10. 종료를 보기 위해(메모리 해제시키기 위해) destroy(); 가 필요.
		// context.destroy();를 실행하기 위해 ApplicationContext가 아닌
		// AbstractApplicationContext로 context생성해야 한다.
		context.destroy();

	}
}
