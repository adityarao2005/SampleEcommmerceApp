package com.raos.ecommerce.web.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raos.ecommerce.web.dao.ProductDAO;
import com.raos.ecommerce.web.models.Product;

/**
 * Servlet implementation class CreateProductController
 */
@WebServlet("/admin/product")
public class CreateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateProductController() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> errors = new LinkedList<String>();
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		double cost = 0;
		if (name == null || name.trim().isEmpty()) {
			errors.add("Name is empty");
		}
		if (price == null || price.trim().isEmpty()) {
			errors.add("Price is empty");
		}
		try {
			cost = Double.parseDouble(price);
		} catch (Exception e) {
			errors.add("Price must be a integer");
		}
		if (!errors.isEmpty()) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND);
			PrintWriter out = response.getWriter();
			errors.forEach((e) -> {
				out.println(e);
			});
		} else {
			response.setStatus(HttpServletResponse.SC_OK);
			Product product = new Product();
			product.setName(name);
			product.setDescription(description);
			product.setNumberInStock(0);
			product.setPrice(cost);

			ProductDAO dao = new ProductDAO();
			dao.save(product);
			dao.close();
		}
	}

}
