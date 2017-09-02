package user.process;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import user.entity.UserEntity;
import user.entity.UserEntityInterface;

/**
 * 그래서 여기는 B차장이 만드는 모듈의 test버전
 * 
 */
@RunWith(MockitoJUnitRunner.class)// 어노테이션 대소문자 다 가림. 주의
// 클래스가 완성 안됬지만 그걸 가상으로 만들어 줌.
// 안 들어왔지만 값 인정해주는게 Mock안에 기술되는 내용.
public class UserServiceTest {
	
	@InjectMocks //과장이 만든 모듈. 껴들어가는 모듈
	private UserService userService;
	
	@Mock//완성되지 않은 타인의 모듈을 여기다 기술
	private UserEntityInterface userEntity;
	// 이게 완성 된 상태에서 과장의 것이 잘 된 것만 증명해주면 되.
	
	public void testFindAllUserCount(){
		int count = userService.findAllUsersCount();
		assertEquals(0, count);
		
		count = userService.findAllUsersCount();
		assertEquals(1, count);
		
	}
	
	
	@Test
	public void testfindAllUsersCount(){
		UserEntity userEntity = new UserEntity();
		int count = userEntity.selectAllUserCount();
		// 코딩 자체가 앞사람이 만들어야 제작가능.
		// 다른 모듈 에서 넘어오는 단계가 완성이 안되어 여기도 작업하기 어려울 때
		// 다른 모듈 관계 없이 내꺼 테스트 하고 싶다 할 때.
		// 회원가입, 로그인 보다 물건 사는거 먼저 개발한다 싶다 할 때.
		assertEquals(1, count);
		//mockito
		
	}

}
