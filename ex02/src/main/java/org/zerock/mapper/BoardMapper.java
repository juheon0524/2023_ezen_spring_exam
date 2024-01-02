package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criterial;

public interface BoardMapper {
//	@Select("select * from tbl_board where bno > 0")
	public List<BoardVO> getList();

	//페이징 처리
	public List<BoardVO> getListWithPaging(Criterial cri);
	
	//insert문 bno값 알 필요 없을떄
	public void insert(BoardVO vo);
	//insert문 bno값 알 필요 있을떄
	public void inserteSelectKey(BoardVO vo);
	//bno로 데이터 조회
	public BoardVO read(Long bno);
	//bno값을 데이터 삭제
	public int delete(Long bno);
	//데이터 업데이트
	public int update(BoardVO vo);
	//전체 갯수 구하기
	public int getTotalCount(Criterial cri);
	
	//테스트용
	public List<BoardVO> searchTest(Map<String, Map<String, String>>map);
}
