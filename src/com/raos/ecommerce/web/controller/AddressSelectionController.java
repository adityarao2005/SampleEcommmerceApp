package com.raos.ecommerce.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.raos.ecommerce.web.dao.AddressDAO;
import com.raos.ecommerce.web.dao.UserDAO;
import com.raos.ecommerce.web.models.User;
import com.raos.ecommerce.web.util.DispatchHelper;

/**
 * Servlet implementation class AddressSelectionController
 */
@WebServlet("/checkout/addresses")
public class AddressSelectionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddressSelectionController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		User user = null;
		if (session != null && (user = (User) session.getAttribute("user")) != null) {
			if (user.isAdmin()) {
				response.sendRedirect("../admin");
				return;
			}
		}
		if (user != null) {
			try (UserDAO dao = new UserDAO()) {
				user = dao.load(user.getId());
				request.setAttribute("addresses", user.getAddresses());
			}
			DispatchHelper.dispatch("/WEB-INF/jsp/addresses.jsp", request, response);
		}
	}

}
