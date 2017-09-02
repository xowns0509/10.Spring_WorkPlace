package sample5collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {

		// 스프링의 설정파일 읽는 놈
		ApplicationContext context = new ClassPathXmlApplicationContext("sample5collection/applicationContext.xml");

		// 리스트 2개를 클래스 하나에 넣어 둔 것일 뿐
		// 연관성은 없음. 그래서
		// intList에 value를 5개 넣어주고
		// member값 셋을 10개 넣어두면
		// 5개ㅜ 10개씩 출력
		ListBean bean = (ListBean) context.getBean("bean");
		for (Integer i : bean.getIntList()) {
			System.out.println(i);
		}
		for (MemberBean m : bean.getMemberList()) {
			System.out.println(m.getName() + ":" + m.getMessage());
		}

	}

}