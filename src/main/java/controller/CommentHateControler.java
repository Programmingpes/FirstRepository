package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.BoardService;
import view.ModelAndView;

public class CommentHateControler implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno"));
		String id = ((MemberDTO)request.getSession().getAttribute("dto")).getId();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("cno", cno);
		map.put("id", id);
		
		int result = BoardService.getInstance().insertBoardCommentHate(map);
		
		response.getWriter().write(String.valueOf(result));
		return null;
	}

}
