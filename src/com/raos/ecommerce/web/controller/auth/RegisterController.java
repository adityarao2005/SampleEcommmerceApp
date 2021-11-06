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
import com.raos.ecommerce.web.service.MailService;
import com.raos.ecommerce.web.util.DispatchHelper;
import com.raos.ecommerce.web.util.EncryptHelper;
import com.raos.ecommerce.web.util.UrlHelpers;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterController() {
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
		DispatchHelper.dispatch("/WEB-INF/jsp/register.jsp", request, response);
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

		User user = null;
		UserDAO userDao = new UserDAO();
		if ((user = userDao.getUserByEmail(email)) != null) {
			errors.add("Email already is registered");
		}

		if (errors != null && !errors.isEmpty()) {
			request.setAttribute("errors", errors);
			request.setAttribute("email", email);
			userDao.close();
			DispatchHelper.dispatch("/WEB-INF/jsp/register.jsp", request, response);
			return;
		}

		user = new User();
		user.setEmail(email);
		user.setPassword(EncryptHelper.encrypt(password));

		userDao.save(user);
		userDao.close();

		String fullContextPath = UrlHelpers.toURL(request.getScheme(), request.getServerName(), request.getServerPort(),
				request.getContextPath());
		String token = user.getToken();
		String verificationLink = fullContextPath + "/email/verification/" + token;

		MailService mailService = new MailService();
		mailService.setTo(email);
		mailService.setFrom("noreply@mail.com");
		mailService.setSubject("Email Verification");
		String content = "Hello user,<br> This is a verification email sent from the website" + " <a href='"
				+ fullContextPath + "'>" + fullContextPath + "</a> saying that you have registered to our site. "
				+ "If you have not registered, ignore this email and we will delete the account that has registered to our site shortly. "
				+ "If you have registered, click the <a href='" + verificationLink
				+ "'>here</a> to enable the account<br>";
		mailService.setContent(content);
		mailService.send();

		DispatchHelper.dispatch("/WEB-INF/jsp/verification.jsp", request, response);
	}

}
