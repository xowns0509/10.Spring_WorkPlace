package calc;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {

	@BeforeClass
	public static void beforeClass(){
		System.out.println("맨 처음");
	}

	@AfterClass
	public static void afterClass(){
		System.out.println("끝에"); //예를 들어, DB가 닫힐 때.
	}
	
	// 부분적인 단위테스트시에 사용.
	// 중간발표
	// 중요한 걸 먼저 개발하도록 권장.
	// 그때 이런걸 사용.

	
	@Before
	public void init(){
		System.out.println("@Test 전 초기화 작업");
	}

	@After
	public void uninit(){
		System.out.println("@Test의 후반 작업");
	}
	
	
	@Test
	// '이 함수는 테스트함수야' 라고 jUnit라이브러리가 불러주는 거.
	// 테스트 메소드는 반드시 void여야 한다.
	public void testAdd() {

		Calculator cal = new Calculator();
		int result = cal.add(3, 4);
		// if (result == 7)
		// System.out.println("더하기 테스트 성공");
		assertEquals(7, result);// ctrl + 1
		// result의 값이 7이면 테스팅 성공이란 뜻.
		// 만약 assertEquals(9, result);로 한다면 틀리기 때문에 왼쪽에 틀렸다고 뜸.
		
		result = cal.sub(3, 4);
		assertEquals(-1, result);
		result = cal.mul(3, 4);
		assertEquals(12, result);
		result = cal.div(100, 102);
		assertEquals(0, result);
		

	}

	// public static void main(String[] args) {
	// Calculator cal = new Calculator();
	//
	// int result = cal.add(3, 4);
	// if (result == 7)
	// System.out.println("더하기 테스트 성공");
	//
	// }
	//

}
