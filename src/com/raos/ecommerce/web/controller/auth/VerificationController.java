package com.raos.ecommerce.web.controller.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raos.ecommerce.web.dao.UserDAO;
import com.raos.ecommerce.web.models.User;

/**
 * Servlet implementation class VerificationController
 */
@WebServlet("/email/verification/*")
public class VerificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VerificationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] pathParts = request.getPathInfo().split("/");
		String token = pathParts[1];

		UserDAO userDao = new UserDAO();
		try {
			User user = userDao.getUserByToken(token);
			if (user == null || user.isActive()) {
				response.sendError(404);
				return;
			}

			user.setActive(true);
		} finally {
			userDao.close();
		}
	}
}
