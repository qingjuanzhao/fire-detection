package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.TransmitData;

public class SendCommandServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request == null) {
			return;
		}
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String res_command = "null";
		try {
			if (TransmitData.DATA_Command != "") {
				res_command = TransmitData.DATA_Command;
				TransmitData.DATA_Command = "";
			} else {
				res_command = "null";				
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		out.write(res_command);
		out.flush();
		out.close();
	}

}
