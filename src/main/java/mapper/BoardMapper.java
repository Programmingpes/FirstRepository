package mapper;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import config.DBManager;
import dto.BoardCommentDTO;
import dto.BoardDTO;
import dto.FileDTO;

public class BoardMapper {
	private static BoardMapper instance = new BoardMapper();
	
	
	private BoardMapper() {
	}

	public static BoardMapper getInstance() {
		if(instance == null)
			instance = new BoardMapper();
		return instance;
	}

	public List<BoardDTO> selectBoardList(int pageNo) {
		SqlSession session = DBManager.getInstance().getSession();
		List<BoardDTO> list = session.selectList("selectBoardList", pageNo);
		session.close();
		return list;
		
	}

	public int selectAllCount() {
		SqlSession session = DBManager.getInstance().getSession();
		int count = session.selectOne("selectAllCount");
		session.close();
		return count;
	}

	public void insertBoard(BoardDTO dto) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.insert("insertBoard", dto);
		session.commit();
		session.close();
	}

	public BoardDTO selectBoard(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		BoardDTO dto = session.selectOne("selectBoard", bno);
		session.close();
		return dto;
	}

	public void deleteBoard(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.delete("deleteBoard", bno);
		session.commit();
		session.close();
	}

	public void updateBoard(BoardDTO dto) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.update("updateBoard", dto);
		session.commit();
		session.close();
	}

	public int insertBoardLike(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("insertBoardLike", map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(result);
		session.commit();
		session.close();
		return result;
	}

	public void deleteBoardLike(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.delete("deleteBoardLike", map);
		session.commit();
		session.close();
	}

	public int insertBoardHate(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("insertBoardHate", map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(result);
		session.commit();
		session.close();
		return result;
	}
	
	public void deleteBoardHate(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.delete("deleteBoardHate", map);
		session.commit();
		session.close();
	}

	public void insertBoardComment(BoardCommentDTO dto) {
		SqlSession session = DBManager.getInstance().getSession();
		session.insert("insertBoardComment", dto);
		session.commit();
		session.close();
	}

	public List<BoardCommentDTO> selectBoardCommentList(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		List<BoardCommentDTO> list = session.selectList("selectBoardCommentList", bno);
		session.close();
		return list;
	}

	public void addCountBoard(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		session.update("addCountBoard", bno);
		session.commit();
		session.close();
	}

	public void deleteBoardComment(int cno) {
		SqlSession session = DBManager.getInstance().getSession();
		session.update("deleteBoardComment", cno);
		session.commit();
		session.close();
	}

	public int insertBoardCommentLike(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("insertBoardCommentLike", map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		session.commit();
		session.close();
		return result;
	}

	public void deleteBoardCommentLike(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		session.delete("deleteBoardCommentLike", map);
		session.commit();
		session.close();
	}

	public int insertBoardCommentHate(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = 0;
		try {
			result = session.insert("insertBoardCommentHate", map);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		session.commit();
		session.close();
		return result;
	}

	public void deleteBoardCommentHate(HashMap<String, Object> map) {
		SqlSession session = DBManager.getInstance().getSession();
		session.delete("deleteBoardCommentHate", map);
		session.commit();
		session.close();
	}

	public int selectBoardNo() {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.selectOne("selectBoardNo");
		session.close();
		return result;
	}

	public int insertFile(FileDTO file) {
		SqlSession session = DBManager.getInstance().getSession();
		int result = session.insert("insertFile", file);
		session.commit();
		session.close();
		return result;
	}

	public List<FileDTO> selectFileList(int bno) {
		SqlSession session = DBManager.getInstance().getSession();
		List<FileDTO> filelist = session.selectList("selectFileList", bno);
		session.close();
		return filelist;
	}

	public FileDTO selectFile(HashMap<String, Integer> map) {
		SqlSession session = DBManager.getInstance().getSession();
		FileDTO dto = session.selectOne("selectFile", map);
		session.close();
		return dto;
	}
	
}
