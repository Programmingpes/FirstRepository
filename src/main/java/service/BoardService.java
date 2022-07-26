package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import config.DBManager;
import dto.BoardCommentDTO;
import dto.BoardDTO;
import dto.FileDTO;
import mapper.BoardMapper;

public class BoardService {
	private static BoardService instance = new BoardService();
	private BoardService() {
	}
	public static BoardService getInstance() {
		if(instance == null)
			instance = new BoardService();
		return instance;
	}
	public List<BoardDTO> selectBoardList(int pageNo) {
		return BoardMapper.getInstance().selectBoardList(pageNo);
	}
	public int selectAllCount() {
		return BoardMapper.getInstance().selectAllCount();
	}
	public void insertBoard(BoardDTO dto) {
		BoardMapper.getInstance().insertBoard(dto);
	}
	public BoardDTO selectBoard(int bno) {
		return BoardMapper.getInstance().selectBoard(bno);
	}
	public void deleteBoard(int bno) {
		BoardMapper.getInstance().deleteBoard(bno);
	}
	public void updateBoard(BoardDTO dto) {
		BoardMapper.getInstance().updateBoard(dto);
	}
	public void addBoardCount(int bno) {
		BoardMapper.getInstance().addCountBoard(bno);
	}
	public int insertBoardLike(HashMap<String, Object> map) {
		int result = BoardMapper.getInstance().insertBoardLike(map);
		if(result == 0)
			BoardMapper.getInstance().deleteBoardLike(map);
		return result;
	}
	public int insertBoardHate(HashMap<String, Object> map) {
		int result = BoardMapper.getInstance().insertBoardHate(map);
		if(result == 0)
			BoardMapper.getInstance().deleteBoardHate(map);
		return result;
	}
	public void insertBoardComment(BoardCommentDTO dto) {
		BoardMapper.getInstance().insertBoardComment(dto);
	}
	public List<BoardCommentDTO> selectCommentList(int bno) {
		return BoardMapper.getInstance().selectBoardCommentList(bno);
	}
	public void deleteBoardComment(int cno) {
		BoardMapper.getInstance().deleteBoardComment(cno);		
	}
	public int insertBoardCommentLike(HashMap<String, Object> map) {
		int result =BoardMapper.getInstance().insertBoardCommentLike(map);
		if(result == 0)
			BoardMapper.getInstance().deleteBoardCommentLike(map);
		return result;
	}
	public int insertBoardCommentHate(HashMap<String, Object> map) {
		int result =BoardMapper.getInstance().insertBoardCommentHate(map);
		if(result == 0)
			BoardMapper.getInstance().deleteBoardCommentHate(map);
		return result;
	}
	public int selectBoardNo() {
		return BoardMapper.getInstance().selectBoardNo();
	}
	public int insertFile(FileDTO file) {
		return BoardMapper.getInstance().insertFile(file);
	}
	public List<FileDTO> selectFileList(int bno) {
		return BoardMapper.getInstance().selectFileList(bno);
	}
	public FileDTO selectFile(HashMap<String, Integer> map) {
		return BoardMapper.getInstance().selectFile(map);
	}
	
}













