package annotation3.resource;

import java.io.IOException;

import javax.annotation.Resource;

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
	@Resource(name="outputer")//아니면(name="outputer2")
	// 이걸 썼으면 골뱅이에 관련된 클래스를 갖고 와야지???
	// 오토와이어드는 결국 누가 누구와 엮이는지 모르므로 실무에서는 리소스가 더 많이 쓰임
	private Outputer out;

	
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
