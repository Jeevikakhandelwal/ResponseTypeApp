package com.abc.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download")
public class ImageRespnseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Setting MIME Response
		response.setContentType("image/jpeg");
		
		//Getting the Writer Object to send the response
		//PrintWriter => character data best suited
		//ServletOutputStream => binary data best suited
		ServletOutputStream out=response.getOutputStream();
		String path="C:\\Users\\Jeevika\\eclipse-workspace\\ResponseTypeApp\\src\\main\\webapp\\WEB-INF\\newPhoto.jpeg";
		
		File file=new File(path);
		FileInputStream fis= new FileInputStream(file);
		byte[] b= new byte[(int) file.length()];
		fis.read(b);
		
		out.write(b);
		out.flush();
		fis.close();
		//Closing Stream
		out.close();
	}

}
