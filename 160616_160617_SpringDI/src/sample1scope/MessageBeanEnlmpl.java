package sample1scope;

public class MessageBeanEnlmpl implements MessageBean {
	
	public void sayHello(String name){
		System.out.println(name + ", Good morning!!!");
	}
	
	public MessageBeanEnlmpl(String name){
		System.out.println("EN 생성자함수 출력");
	}

}
