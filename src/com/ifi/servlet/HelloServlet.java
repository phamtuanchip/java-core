package com.ifi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.transport.http.client.HttpCookie;

public class HelloServlet extends HttpServlet {

    @Override
	public void destroy() {
    	System.out.println("Destroying...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Initing...");
		String paramvalue = getServletConfig().getInitParameter("paramname");
		System.out.println("paramname = " + paramvalue);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        
        Enumeration<String> names = request.getParameterNames();
        
        while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			String value = request.getParameter(name);
			
		}
        
		
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        String docType = "";
        out.println(docType + "<HTML>\n" + "<HEAD><TITLE>Hello</TITLE></HEAD>\n" 
            + "<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1>Hello</H1>\n"
            + "</BODY></HTML>");
    }

	
}
