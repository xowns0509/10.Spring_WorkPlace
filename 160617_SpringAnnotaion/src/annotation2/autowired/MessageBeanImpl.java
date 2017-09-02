package annotation2.autowired;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class MessageBeanImpl implements MessageBean {

	private String name;
	private String message;

	public String getName() {
		return name;
	}

	@Required
	// 단 이것만 달랑 썼다 해도 스프링이 자동으로 잡진 않으므로
	// xml가서
	// org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor
	// 잡아줌
	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// ######################
	@Autowired // setter나 생성자 인자 없이도 DI 가능... 하게끔 해주는 거. 의존관계 주입.
	@Qualifier("outputer2") //객체가 2개 이상이면 누구 선택 할 지 스프링은 모르기때문에 qualifier로 지정
	private Outputer out;
	// 인터페이스잖아. 값 지정 안했어
	// 원래 여기다가 값을 지정하기 위해
	// public void setOutputer(Outputer){
	// this.out = out;
	// }해야 하잖아.
	
	@Override
	public void sayHello() {
		System.out.println(name + "님께" + message);

		try {
			out.writeMessage(name + "님께" + message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
