package Servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import Util.TransmitData;

public class TransCommand extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request == null) {
			return;
		}
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		/*read the parameter from request*/
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line = br.readLine()) != null) {
			sb.append(line);
		}
		String IPaddress = sb.toString();
		

		PrintWriter out = response.getWriter();
		String jsonObject = "null";
		try {
			if (TransmitData.DATA_Command != "") {
				String[] a = new String[2];
				a = TransmitData.DATA_Command.split("@@");
				if (a[0].equals(IPaddress)){				
					jsonObject = a[1];
					TransmitData.DATA_Command = "";
				} else {
					jsonObject = "null";
				}
			} else {
				jsonObject = "null";				
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		out.write(jsonObject.toString());
		out.flush();
		out.close();
	}

}
