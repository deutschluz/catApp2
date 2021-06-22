package com.revature.servlets;

import javax.servlet.http.HttpServlet;

import com.google.gson.Gson;
import com.revature.beans.Cat;
import com.revature.services.CatServiceImpl;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;

public class CatServlet extends HttpServlet{
	//something gson here
	private CatServiceImpl cs = new CatServiceImpl();
	private Gson gson=new Gson();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		String uri= req.getRequestURI();
		
		//log this later
		System.out.println(uri);
		
		//for GET reqs
		/**
		 * localhost:8080/CatServlet/cats -> getall cats methods
		 * 
		 *cats/<id> -> get a cat by id
		 *
		 */
		
		switch(uri) {
		case "/CatServlet/cats":{
			System.out.println("Getting all cats...");
			List<Cat> cats= cs.getAllCats();
			System.out.println(cats);
			try {
				res.getWriter().append(gson.toJson(cats,Cat.class));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
		default:
		
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) {
		
	}
}