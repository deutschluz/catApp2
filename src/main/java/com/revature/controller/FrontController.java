package com.revature.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.delegates.FrontControllerDelegate;

public class FrontController extends HttpServlet {
	private RequestHandler rh = new RequestHandler();
	
	// this method is where we will funnel all of our requests
	// so that we can give them to the handler to get back the
	// appropriate delegate, then call that delegate
	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FrontControllerDelegate fcd = rh.handle(req, resp);
		
		if (fcd != null)
			fcd.process(req, resp);
		else
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		//process(request, response);
	    response.getWriter().append("Welcome to the Front Controller");	
		String uri = request.getRequestURI();
		StringBuffer url = request.getRequestURL();
		System.out.println(uri);
		
		response.getWriter().append("\n" + uri);
		
		// Sessions
		HttpSession session = request.getSession();
		System.out.println(session.getId());
		
		session.setAttribute("loggedInUser", "{'firstName': 'Dan', 'lastName': 'Felleman', 'age': 756}");
		
		System.out.println(session.getAttribute("loggedInUser"));
		
		session.setMaxInactiveInterval(0);
//		session.invalidate();
		
		
		switch (uri) {
		
		case "/ServletExample/html/catapp.html": {
			response.getWriter().append("\nTest Worked!");
			response.getWriter().append("\n" + session.getAttribute("loggedInUser"));
			break;
		}
		
		default: {
			response.sendError(418, "Come back later, I'm busy...");
			break;
			}
	
	}
		
	}

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		process(request, response);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
}
