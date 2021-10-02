package com.raos.ecommerce.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raos.ecommerce.web.dao.ProductDAO;
import com.raos.ecommerce.web.models.Product;
import com.raos.ecommerce.web.util.DispatchHelper;

/**
 * Servlet implementation class ProductDetailController
 */
@WebServlet("/product/*")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductDetailController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Fetch product by ID and display page product detail view
		String[] pathParts = request.getPathInfo().split("/");
		String token = pathParts[1];
		ProductDAO dao = new ProductDAO();
		try {
			Product product = dao.load(token);
			if (product == null) {
				response.sendError(404);
				return;
			}
			request.setAttribute("product", product);
			DispatchHelper.dispatch("/WEB-INF/jsp/product-detail.jsp", request, response);
		} finally {
			dao.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
