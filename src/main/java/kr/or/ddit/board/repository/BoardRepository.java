package kr.or.ddit.board.repository;

import kr.or.ddit.board.model.BoardVo;

public class BoardRepository implements BoardRepositoryI{

	@Override
	public BoardVo getBoard(int boardNo) {
		// db에서 조회를 해야하나, 지금은 설정이 갖춰지지 않았으므로
		// 가짜 객체(Mock)
		if(boardNo==1) {
			return new BoardVo(1, "첫번쨰 글", "내용");
		}
		
		else
		return null;
	}
}
