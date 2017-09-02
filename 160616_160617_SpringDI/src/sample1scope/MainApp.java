package sample1scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// MessageBeanKoImpl ko = new MessageBeanKoImpl();
		/*
		 * ko.sayHello("홍길자");
		 * 
		 * MessageBeanEnlmpl en = new MessageBeanEnlmpl(); en.sayHello("Hong");
		 * 
		 * // 경우에 따라 한글모드와 영문모드 선택 된다면?
		 * 
		 * // 다형성에 의해 MessageBean bean = new MessageBeanKoImpl();// 한글모드 //
		 * MessageBean bean = new MessageBeanEnImpl();//영문모드
		 * bean.sayHello("홍길동");
		 */

		// 이미 서버에 올려놨는데
		// 개발자가 수정을 해야되
		// 그럼 다시 컴파일 해야하지
		// 그럼 클래스 파일이 만들어지고
		// 서버로 가서
		// 서버를 다시 실행해야해
		// 껏다 켜야 한다고
		// 사소한거 하나라도 수정해야 할 때 그렇게 해야 하잖아.
		//
		// 객체 생성하는 거를 연관도를 낮출 수 없을 까
		// 그것이 스프링의 DI개념
		// 원래는 자바파일에서 new를 이용해 객체를 생성해야 하잖아
		// 그걸 그냥 xml에서 객체 생성하겠다고

		// --------------------------------------------------
		// xml 파일을 만들어 거기서 죄다 객체를 생성한다
		// 그럼 위의 new... 로 객체 생성하는 문장들은 죄다 필요 없지.

		// 스프링의 설정파일 읽는 놈
		ApplicationContext context = new ClassPathXmlApplicationContext("sample1scope/applicationContext.xml");

		MessageBean bean = context.getBean("ko", MessageBean.class);// ko 갖고 오겠어
		// MessageBean bean = context.getBean("en", MessageBean.class);//en 갖고 오겠어
		bean.sayHello("홍길숙");

		// 자바소스에서 new 코딩을 없애고 두 클래스간의 결합도를 낮춰서
		// 한쪽 클래스 변경으로 인해 새로 컴파일/ 복사/ 실행... 을 안해도 될 수 있게끔(서버 재시작을 막아줘).

		// 일본어가 필요해? 그럼
		// xml에서 만든 다음에 여기서 실행.

		// [2] id대신 별칭으로 불러오기
		MessageBean bean2 = context.getBean("d", MessageBean.class);// 별칭명 d로 갖고 오겠어
		bean2.sayHello("홍길동");

		// 만약 ko를 두 번 썼다면 메모리에 두 번 띄웠을까?
		// 확인위해 생성자 함수 작성.
		// 메모리에 두 번 띄웠으면 두 번 출력되어야지.
		// >> 결론은 한 번 나옴
		
		// main에서 ko를 두 번 이상을 쓴다 하더라도
		// default(기본값)는 맨 처음 생성한 하나 갖고 매번 씀(싱글톤임)
		// 
		// 
		// 하지만 그렇게 되면 동기화 문제가 발생하니까,
		// (각자 자기정보를 객체마다 갖고 있어야 할 필요가 있을 때 - 여러 명의 사용자 정보)
		// 그걸 방지하는 것도 있다. 매 객체 마다 메모리에 올리는 경우.
		// 범위를 지정. scope >>>xml로
		
		// ko는 메모리에 단 한 번만 올라오기 때문에
		// 생성자 함수에 의한 출력이 딱 한 번만 나오고
		// scope="prototype"으로 준 en의 생성자함수 출력문은 
		// 메인함수에서 불릴 때마다 실행됨.
		// 즉, 내가 쓰려고 하는 순간에 불려지는 거임.
	
		// 그래서, 객체생성을, applicationContext가 하긴 하는 데
		// 첫 기동(서버나 앱) 시 부터 메모리에 올리는 건지
		// 호출 시마다 불리는 건지 차이가 난다는 것.
		// 메모리에 올리는 시점이 틀려짐
		
		// DAO 같은 건 싱글톤으로 해도 되지.
		// 공유해도 되는거니까
		// 사용자정보같은거, VO객체같은건
		// 프로토타입으로 가야지. 죄다 달라야 하니까
		
		
		MessageBean bean3 = context.getBean("en", MessageBean.class);		
		MessageBean bean4 = context.getBean("en", MessageBean.class);// 별칭명 d로 갖고
		// 오겠어

	}

}
