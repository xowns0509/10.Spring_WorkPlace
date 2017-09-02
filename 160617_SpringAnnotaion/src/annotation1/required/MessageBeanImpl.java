package annotation1.required;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

public class MessageBeanImpl implements MessageBean {

	private String name;
	private String message;

	@Override
	public void sayHello() {
		System.out.println(name + "님께" + message);

	}

	public String getName() {
		return name;
	}

	@Required
	// 단 이것만 달랑 썼다 해도 스프링이 자동으로 잡진 않으므로
	// xml가서 org.springframework.beans.factory.annotation.RequiredAnnotationBeanPostProcessor 잡아줌
	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
