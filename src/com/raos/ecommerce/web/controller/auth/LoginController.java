package com.raos.ecommerce.web.controller.auth;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.raos.ecommerce.web.dao.UserDAO;
import com.raos.ecommerce.web.models.User;
import com.raos.ecommerce.web.util.DispatchHelper;
import com.raos.ecommerce.web.util.EncryptHelper;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		if (session != null && session.getAttribute("user") != null) {
			((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath());
			return;
		}

		DispatchHelper.dispatch("/WEB-INF/jsp/login.jsp", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		List<String> errors = new LinkedList<String>();

		if (email == null || email.isEmpty()) {
			errors.add("Email is required");
		}

		if (password == null || password.isEmpty()) {
			errors.add("Password is required");
		}

		if (errors != null && !errors.isEmpty()) {
			request.setAttribute("errors", errors);
			DispatchHelper.dispatch("/WEB-INF/jsp/register.jsp", request, response);
			return;
		}

		User user = null;
		UserDAO dao = new UserDAO();
		user = dao.getUserByEmail(email);
		dao.close();

		if (user == null || !EncryptHelper.decrypt(user.getPassword()).equals(password)) {
			errors.add("Invalid credentials");
		}

		if (errors != null && !errors.isEmpty()) {
			request.setAttribute("errors", errors);
			request.setAttribute("email", email);
			DispatchHelper.dispatch("/WEB-INF/jsp/login.jsp", request, response);
			return;
		}

		HttpSession session = request.getSession(true);
		session.setAttribute("user", user);
		response.sendRedirect(request.getContextPath());

	}

}
