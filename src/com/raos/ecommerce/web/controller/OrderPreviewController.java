package com.raos.ecommerce.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.raos.ecommerce.web.dao.AddressDAO;
import com.raos.ecommerce.web.dao.CartDAO;
import com.raos.ecommerce.web.dao.UserDAO;
import com.raos.ecommerce.web.models.User;
import com.raos.ecommerce.web.util.DispatchHelper;

/**
 * Servlet implementation class OrderPreviewController
 */
@WebServlet("/checkout/order-preview")
public class OrderPreviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderPreviewController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User user = null;
		if (session != null && (user = (User) session.getAttribute("user")) != null) {
			if (user.isAdmin()) {
				response.sendRedirect("admin");
				return;
			}
		}
		if (user != null) {
			int address_id = Integer.parseInt(request.getParameter("address_id"));
			try (AddressDAO cartDAO = new AddressDAO()) {
				request.setAttribute("address", cartDAO.load(address_id));
			}
			try (UserDAO userDAO = new UserDAO()) {
				user = userDAO.load(user.getId());
				request.setAttribute("cart", user.getCart());
			}
			request.setAttribute("products", user.getCart().getProducts());
			DispatchHelper.dispatch("/WEB-INF/jsp/order-preview.jsp", request, response);
		}
	}

}
