package sample2value;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		// 스프링의 설정파일 읽는 놈
		ApplicationContext context = new ClassPathXmlApplicationContext("sample2value/applicationContext.xml");

		// memberBean타입으로 읽어오겠다.
		// MemberBean bean = context.getBean("member", MemberBean.class);
		// System.out.println(bean.getName() + bean.getAge() +
		// bean.getMessage());
		//
		// MemberBean bean2 = context.getBean("member2", MemberBean.class);//
		// memberBean타입으로 읽어오겠다.
		// System.out.println(bean2.getName() + bean2.getAge() +
		// bean2.getMessage());

		MemberDAO dao1 = context.getBean("dao1", MemberDAO.class);
		dao1.insert();

		MemberDAO dao2 = context.getBean("dao2", MemberDAO.class);
		dao2.insert();

	}

}
