package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Util.TransmitData;

public class SendSensorDataServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request == null) {
			return;
		}
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		String res_data = "null";
		try {
			if (TransmitData.DATA_Sensor_Data != "") {
				res_data = TransmitData.DATA_Sensor_Data;
				TransmitData.DATA_Sensor_Data = "";
			} else {
				res_data = "null";				
			}
			
		} catch (Exception e){
			e.printStackTrace();
		}
		
		out.write(res_data);
		out.flush();
		out.close();
	}

}
