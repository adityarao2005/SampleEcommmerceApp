package com.raos.ecommerce.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.raos.ecommerce.web.dao.ProductDAO;
import com.raos.ecommerce.web.models.Cart;
import com.raos.ecommerce.web.models.Product;
import com.raos.ecommerce.web.models.User;
import com.raos.ecommerce.web.util.DispatchHelper;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/cart")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		DispatchHelper.dispatch("/WEB-INF/jsp/cart.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productID = request.getParameter("product_id");

		ProductDAO dao = new ProductDAO();
		Product product = dao.load(productID);
		dao.close();

		if (product == null) {
			response.sendError(404);
			return;
		}

		HttpSession session = request.getSession(false);
		User user = null;
		if (session != null && (user = (User) session.getAttribute("user")) != null) {
//			CartDAO cartDao = new CartDAO();
//			cartDao.addToCart(product, user);
//			cartDao.close();
			System.out.println(user.getCart());
		} else {
			response.sendError(403);
			return;
		}
	}
}
