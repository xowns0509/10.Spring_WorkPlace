package execise;
// 스프링을 왜? 일단 유지보수 쉽게 하려고. 초보자와 전문가의 코딩실력 상향평준화.

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import execise.order.domain.Customer;
import execise.order.service.CustomerService;

public class Main {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("execise/beans.xml");
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		// 설정 폴더를 자바로 만들었다.
//		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/execise/beans.xml");
		// 
		
		CustomerService customerService = (CustomerService)ctx.getBean("customerService");
		
		
		Customer customer = new Customer();
		customer.setId(1);
		customer.setName("홍길동");
		customer.setAddress("서울시");
		customer.setEmail("dong@kosta.go.kr");
		// 추후에 Customer 객체도 빈즈로 생성한다면??

		customerService.saveCustomer(customer);
		customer.setName("홍길자");
		customerService.updateCustomer(customer);
		customerService.deleteCustomer(1);		
		
	}

}
