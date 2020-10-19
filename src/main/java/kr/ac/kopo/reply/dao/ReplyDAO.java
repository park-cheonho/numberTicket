package kr.ac.kopo.reply.dao;

import java.util.List;

import kr.ac.kopo.reply.vo.ReplyVO;

/**
 * 댓글관련 crud
 * @author cheon
 *
 */
public interface ReplyDAO {

	/**
	 * 댓글등록
	 */
	void insert(ReplyVO replyVO);
	
	/**
	 * 해당 게시물의 댓글 조회
	 * @param boardNo 조회할 게시물 번호
	 * @return 조회된 댓글 VO의 리스트
	 */
	List<ReplyVO> selectAll(int boardNo);
	
	
	/**
	 * 댓글 삭제
	 * @param replyNo 삭제할 댓글번호
	 * 
	 */
	void delete(int replyNo);
	
	/**
	 * 댓글번호에 해당 게시불 번호 조회 
	 * @param replyNo 댓글번호
	 * @retrun 댓글번호에 
	 */
	int selectBoardNo(int replyNo);
}
