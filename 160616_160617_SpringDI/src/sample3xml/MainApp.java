package sample3xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		// 스프링의 설정파일 읽는 놈
		ApplicationContext context = new ClassPathXmlApplicationContext("sample3xml/applicationContext.xml");

//		MemberDAO dao2 = context.getBean("dao2", MemberDAO.class);
//		dao2.insert();
		
		MemberDAO dao1 = context.getBean("dao1", MemberDAO.class);
		dao1.insert();
				
	}

}
