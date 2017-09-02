package sample6lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageBeanImpl implements MessageBean, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
	// BeanNameAware 추가. bean 이름에 값 지정. 메모리에 올려놨으면 그걸 참조해야 할거 아냐.
	// 스프링이 빈관리 해주는거 잖아
	// 자바용어로 인스턴스인놈들
	// 스프링으로 넘어오며 그놈들을 bean이라고 부르잖아.
	// bean이라는
	// 스프링은 id놈들을 관리. 정확히는 bean들 관리. 그게 BeanFactory. 그걸 어느시점에 메모리에 올릴까?
	// 그럼 값 초기화는 언제.

	public MessageBeanImpl() {
		System.out.println("1. 생성자 - 인스턴스화 될 때");

	}

	private String greeting;

	public void setGreeting(String greeting) {
		this.greeting = greeting;
		System.out.println("2. 프러퍼티 greeting을 지정");
	}

	@Override
	public void setBeanName(String arg0) {
		System.out.println("3. 빈의 이름 설정(arg0 출력): " + arg0);
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("4. Bean Factory 에 설정(arg0 출력): " + arg0);
	}

	@Override
	public void sayHello() {
		System.out.println("9. bean의 메소드사용(greeting 출력): " + greeting);
		// TODO Auto-generated method stub
		// 스프링의 빈은 이렇게

	}
	// MessageBeanImpl의 객체는 스프링에서.(xml)

	public void init() {
		System.out.println("7. 초기화를 담당하는 init메소드: " + greeting);
	}

	// InitializingBean 추가로 인한 overri...
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("6. 초기화를 담당하는 init메소드 전의 Initializing Bean의 프러퍼티 지정: " + greeting);
		// 초기화를 담당하는 bean을 설정할 때 불려진다?
	}

	//그럼 메모리에서 언제 해제당할까? DisposableBean 추가
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("10. 메모리 해제시(종료)" + greeting);		
	}
	

}
