package proj.security.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import proj.vo.BbsCommVO;
import proj.vo.BbsVO;
import proj.vo.SearchVO;



@Repository
public class BbsDao {
	@Autowired
	private SqlSessionTemplate ss;

	public void insertBbs(BbsVO vo) {
		ss.insert("bbs.ins", vo);
	}

	public List<BbsVO> getList(SearchVO vo) {
		return ss.selectList("bbs.list", vo);
	}

	public int getTotalCount() {
		return ss.selectOne("bbs.listTotal");
	}

	public BbsVO getDetail(int num) {
		return ss.selectOne("bbs.detail", num);
	}

	// comm
	public void insertComm(BbsCommVO vo) {
		ss.insert("bbs.commIn", vo);
	}

	public List<BbsCommVO> getCommList(int kcode) {
		return ss.selectList("bbs.commList", kcode);
	}

	public void BbsHitUp(int num) {
		ss.update("bbs.hitup", num);
	}

}
