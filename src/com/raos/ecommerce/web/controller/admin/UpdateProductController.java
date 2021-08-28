package com.raos.ecommerce.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raos.ecommerce.web.dao.ProductDAO;
import com.raos.ecommerce.web.models.Product;

/**
 * Servlet implementation class UpdateProductController
 */
@WebServlet("/admin/product/update/*")
public class UpdateProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO: Work with error handling
		String[] pathParts = request.getPathInfo().split("/");
		String productID = pathParts[1];
		String temp = "";
		ProductDAO dao = new ProductDAO();
		Product product = dao.load(productID);
		if ((temp = request.getParameter("name")) != null && !temp.trim().isEmpty()) {
			product.setName(temp);
		}
		if ((temp = request.getParameter("description")) != null && !temp.trim().isEmpty()) {
			product.setDescription(temp);
		}
		if ((temp = request.getParameter("price")) != null && !temp.trim().isEmpty()) {
			try {
				product.setPrice(Double.parseDouble(temp));
			} catch (Exception e) {

			}
		}
		if ((temp = request.getParameter("numberInStock")) != null && !temp.trim().isEmpty()) {
			try {
				product.setNumberInStock(Long.parseLong(temp));
			} catch (Exception e) {

			}
		}

		dao.close();
	}

}
