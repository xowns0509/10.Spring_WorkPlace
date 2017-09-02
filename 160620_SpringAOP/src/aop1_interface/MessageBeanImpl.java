package aop1_interface;

public class MessageBeanImpl implements MessageBean {

	@Override
	public void sayHello() {
		
		System.out.println("sayHello() 호출");
		// TODO Auto-generated method stub
	}

	@Override
	public void korSayHello() {
		
		System.out.println("korSayHello() 호출");
		// TODO Auto-generated method stub
	}

	@Override
	public void test() {
		
		System.out.println("test() 호출");
		// TODO Auto-generated method stub
	}
	
	public void enSayHello(){
		
		System.out.println("enSayHello() 호출");
	}

}
