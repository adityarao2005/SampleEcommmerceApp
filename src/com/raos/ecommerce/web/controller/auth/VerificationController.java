package com.raos.ecommerce.web.controller.auth;

import java.io.IOException;
import java.util.Arrays;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raos.ecommerce.web.dao.UserDAO;
import com.raos.ecommerce.web.models.User;
import com.raos.ecommerce.web.util.DispatchHelper;
import com.raos.ecommerce.web.util.EncryptHelper;

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
		System.out.println(Arrays.asList(pathParts));
		String token = pathParts[1];
		UUID uuid = UUID.fromString(token);
		UserDAO userDao = new UserDAO();
		User user = userDao.getUserByToken(uuid);
		userDao.close();
		System.out.println(user);
		if (user == null || user.isActive()) {
			response.sendError(404);
			return;
		}
		DispatchHelper.dispatch("/WEB-INF/jsp/verification.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String[] pathParts = request.getPathInfo().split("/");
		String token = pathParts[1];
		UUID uuid = UUID.fromString(token);

		UserDAO userDao = new UserDAO();
		try {
			User user = userDao.getUserByToken(uuid);
			if (user == null || user.isActive() || !user.getEmail().equals(email)
					|| !EncryptHelper.decrypt(user.getPassword()).equals(password) || uuid.equals(user.getToken())) {
				response.sendError(404);
				return;
			}

			user.setActive(true);
		} finally {
			userDao.close();
		}
	}
}
