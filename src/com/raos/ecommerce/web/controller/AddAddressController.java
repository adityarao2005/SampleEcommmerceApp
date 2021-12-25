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
import com.raos.ecommerce.web.models.Address;
import com.raos.ecommerce.web.models.User;
import com.raos.ecommerce.web.util.DispatchHelper;

/**
 * Servlet implementation class AddAddressController
 */
@WebServlet("/checkout/add-address")
public class AddAddressController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAddressController() {
		super();
		// TODO Auto-generated constructor stub
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
			try (UserDAO userDao = new UserDAO()) {
				user = userDao.load(user.getId());
			}
			if (user.getCart() == null || user.getCart().getProducts().isEmpty()) {
				response.sendRedirect("../");
			}
			DispatchHelper.dispatch("/WEB-INF/jsp/add-address.jsp", request, response);
		}
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
				response.sendRedirect("../admin");
				return;
			}
		}
		if (user != null) {
			String country = request.getParameter("country");
			String state = request.getParameter("state");
			String city = request.getParameter("city");
			int streetNo = Integer.parseInt(request.getParameter("street-no"));
			String street = request.getParameter("street");
			String zip = request.getParameter("zip");

			Address address = new Address(city, state, street, country, streetNo, zip);
			try (UserDAO userDao = new UserDAO()) {
				user = userDao.load(user.getId());
			}

			try (AddressDAO addressDao = new AddressDAO()) {
				addressDao.addAddresses(address, user);
			}
		}

		response.sendRedirect("addresses");
	}

}
