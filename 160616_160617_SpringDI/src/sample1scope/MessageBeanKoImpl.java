package sample1scope;

public class MessageBeanKoImpl implements MessageBean {

	public void sayHello(String name) {
		System.out.println(name + "님 반갑습니다.");
	}

	// 만약 ko를 두 번 썼다면 메모리에 두 번 띄웠을까?
	// 확인위해 생성자 함수 작성.
	public MessageBeanKoImpl(String name) {
		System.out.println("KO 생성자함수 출력");
		// 메모리에 두 번 띄웠으면 두 번 출력되어야지.
		// >> 결론은 한 번 나옴
	}

}
