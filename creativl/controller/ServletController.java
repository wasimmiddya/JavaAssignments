package com.creativl.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.creativl.dto.Student;
import com.creativl.factory.UserServiceFactory;
import com.creativl.service.UserService;

@WebServlet("/controller/*")
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Method :: GET!");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Method :: POST!");

		String formType = request.getParameter("form-type");

		// If the form sent by the user is a sign-up form then this block of code will
		// be executed.
		if (formType.equalsIgnoreCase("SignUp")) {

			Student student = new Student();

			student.setfName(request.getParameter("fname"));
			student.setlName(request.getParameter("lname"));
			student.setSid(Integer.parseInt(request.getParameter("sid")));
			student.setPassword(request.getParameter("pwd"));

			UserService userService = UserServiceFactory.getServiceFactory();
			Integer count = userService.createRecord(student);
			PrintWriter out = response.getWriter();

			if (count > 0) {
				out.println("<h1 style='color: green'> SignUp successful!</h1>");
				out.println("<a href='./index.html'>Home</a>");
			} else {
				out.println("<h1 style='color: red'> SignUp failed!</h1>");
				out.println("<a href='./index.html'>Home</a>");
			}
		}

		// If the form sent by the user is log-in form then this block of code will be
		// executed.
		if (formType.equalsIgnoreCase("LogIn")) {
			Integer sid = Integer.parseInt(request.getParameter("sid"));
			Student student = null;
			UserService serviceFactory = UserServiceFactory.getServiceFactory();
			student = serviceFactory.getRecordById(sid);

			PrintWriter out = response.getWriter();
			HttpSession session = request.getSession();

			if (student != null) {
				session.setAttribute("fName", student.getfName());
				session.setAttribute("lName", student.getlName());
				session.setAttribute("sid", student.getSid());
				session.setAttribute("password", student.getPassword());

				out.println("<h1 style='color: green'> Log-in successful!</h1>");
				out.println("<a href='./profile.jsp'>Go to Profile</a>");
				
			} else {
				out.println("<h1 style='color: red'> SignUp failed!</h1>");
				out.println("<a href='./index.html'>Home</a>");
			}
		}
		
		/*
		 * If the form sent by the user is a update form then this block of code will be executed.
		 */
		if (formType.equalsIgnoreCase("Update")) {
			
			Student student = new Student();
			
			student.setSid(Integer.parseInt(request.getParameter("sid")));
			student.setfName(request.getParameter("fname"));
			student.setlName(request.getParameter("lname"));
			student.setPassword(request.getParameter("pwd"));
			
			System.out.println(student.getfName());
			System.out.println(student.getSid());
			
			UserService userService = UserServiceFactory.getServiceFactory();
			Integer rowsAffected = userService.updateRecordById(student);
			HttpSession session = request.getSession();
			
			PrintWriter out = response.getWriter();
			
			if (rowsAffected > 0) {
				session.setAttribute("fName", student.getfName());
				session.setAttribute("lName", student.getlName());
				session.setAttribute("sid", student.getSid());
				
				session.setAttribute("password", student.getPassword());
				out.println("<h1 style='color: green'> Profile updated successful!</h1>");
				out.println("<a href='./../profile.jsp'>See Profile</a>");
			} else {
				out.println("<h1 style='color: red'> Failed to update profile.</h1>");
				out.println("<a href='./../index.html'>Home</a>");
			}
		}
		
		
	}

	/*
	 * This method is implemented for processing extra activities apart from CRUD
	 * operation.
	 */
	private void doProcess(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String uri = req.getRequestURI();
		UserService userService = null;

		System.out.println(uri);

		if (uri.endsWith("prof_edit")) {
			try {
				Integer id = Integer.parseInt(req.getParameter("sid"));
				
				userService = UserServiceFactory.getServiceFactory();
				Student student = userService.getRecordById(id);
				System.out.println(student);
				
				if (id != 0) {
					req.setAttribute("fName", student.getfName());
					req.setAttribute("lName", student.getlName());
					req.setAttribute("password", student.getPassword());
					System.out.println("id != 0");
				}
				
				req.getRequestDispatcher("../edit_prof.jsp").forward(req, resp);
				System.out.println("Statement after request forwarded!");
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		
		if (uri.endsWith("/log_out")) {
			HttpSession session = null;
			session = req.getSession();
			session.invalidate();
			
			PrintWriter out = resp.getWriter();
			System.out.println(session);
			if (true) {
				out.println("<h1 style='color: green'> Log-out successful!</h1>");
				out.println("<a href='./../index.html'>Home</a>");
			}
		}
	}

}
