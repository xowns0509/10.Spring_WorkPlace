package user.process;

import user.entity.UserEntity;
import user.entity.UserEntityInterface;

/*
 * 여기는 B라는 차장님이 만드는 모듈
 */
public class UserService {

	private UserEntityInterface userEntity;
	
	
	
	public void setUserEntity(UserEntityInterface userEntity) {
		this.userEntity = userEntity;
	}



	public int findAllUsersCount(){
		
		int count = userEntity.selectAllUserCount();
		// 다른 모듈에서 넘어는 단계가 완성이 안되어서 여기도 작업 하기 어려운 상황
		if( count == 0){
			System.out.println("등록된 사용자가 없습니다");
		}else{
			System.out.println(count+"명있습니다.");
		}
		return count;
	}
}
