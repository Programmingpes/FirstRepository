package controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.MemberDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardLikeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		String id = ((MemberDTO)request.getSession().getAttribute("dto")).getId();
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("id", id);
		
		int result = BoardService.getInstance().insertBoardLike(map);
		
		response.getWriter().write(String.valueOf(result));
		
		return null;
	}

}
