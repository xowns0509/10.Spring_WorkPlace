package user.process;


import user.entity.UserEntity;
import user.entity.UserEntityInterface;

/**
 * 여기는 B차장이 만드는 모듈
 * 
 */
public class UserService {

	private UserEntityInterface userEntity;

	public void setUserEntity(UserEntityInterface userEntity) {
		this.userEntity = userEntity;
	}

	public int findAllUsersCount() {
		int count = userEntity.selectAllUserCount(); // 그 사람이 만든 걸 갖고 왔을 때.

		//내 것이 아무것도 문제가 없다는 걸 증명하면 끝인 거 잖아.
		if (count == 0) {
			System.out.println("0000");
		} else {
			System.out.println(count + "1111");
		}
		return count;

	}

}
