package sample4properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		// 스프링의 설정파일 읽는 놈
		ApplicationContext context = new ClassPathXmlApplicationContext("sample4properties/applicationContext.xml");
		
		MemberDAO dao1 = context.getBean("dao1", MemberDAO.class);
		dao1.insert();
				
	}

}