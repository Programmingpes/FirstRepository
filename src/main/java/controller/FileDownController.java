package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.FileDTO;
import service.BoardService;
import view.ModelAndView;

public class FileDownController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		int fno = Integer.parseInt(request.getParameter("fno"));
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("bno", bno);
		map.put("fno", fno);
		FileDTO dto = BoardService.getInstance().selectFile(map);
		String path = "c:\\fileupload\\" + dto.getFileName();
		
		File file = new File(path);
		
		String fileName = URLEncoder.encode(dto.getFileName(), "utf-8");
		
		response.setHeader("Content-Disposition", "attachement;fileName=" + fileName);
		response.setHeader("Content-Transfer-Encoding", "binary");
		response.setContentLength((int)file.length());
		
		FileInputStream fis = new FileInputStream(file);
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		byte[] buffer = new byte[1024*1024]; // 1메가
		
		while(true) {
			int size = fis.read(buffer); // 파일 사이즈를 확인, 1메가 단위로 끊어서
			if(size == -1) break;
			
			bos.write(buffer, 0, size);
			bos.flush();
		}
		fis.close();
		bos.close();
		return null;
	}

}
