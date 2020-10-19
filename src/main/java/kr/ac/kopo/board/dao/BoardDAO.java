package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.vo.BoardVO;

public interface BoardDAO {

	/**
	 * 전체 게시글 조회 서비스
	 * throws Exception 해주는게 좋음
	 */
	public List<BoardVO> selectAll();
	
	/**
	 * 새글등록 서비스
	 */
	public void insert(BoardVO board);
	
	/**
	 * 게시글 상세 조회서비스
	 * @param no 게시글 번호	 
	 */
	public BoardVO selectByNo(int no);
	
	/**
	 * 해당 게시물의 댓글 카운트 증가
	 * @param no 증가시킬 게시물 번호
	 * 
	 */
	public void incrementReplyCnt(int no);
	
	/**
	 * 해당 게시물의 댓글 카운트 감소
	 * @param no 감소시킬 게시물 번호
	 * 
	 */
	public void reduceReplyCnt(int no);
}
