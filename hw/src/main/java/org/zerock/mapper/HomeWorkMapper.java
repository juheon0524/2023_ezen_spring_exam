package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.HomeWorkVO;

public interface HomeWorkMapper {
	
//	@Select("select * from tbl_board where bno > 0")
	public List<HomeWorkVO> getList();
	
	//insert문 bno값 알 필요 없을떄
	public void insert(HomeWorkVO vo);
	//insert문 bno값 알 필요 있을떄
	public void inserteSelectKey(HomeWorkVO vo);
	//bno로 데이터 조회
	public HomeWorkVO read(Long id);
	//bno값을 데이터 삭제
	public int delete(Long id);
	//데이터 업데이트
	public int update(HomeWorkVO vo);
}
