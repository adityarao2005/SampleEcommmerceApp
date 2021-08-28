package com.raos.ecommerce.web.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raos.ecommerce.web.dao.ProductDAO;
import com.raos.ecommerce.web.models.Product;
import com.raos.ecommerce.web.util.DispatchHelper;

/**
 * Servlet implementation class ListProductsController
 */
@WebServlet("/admin/products")
public class ListProductsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListProductsController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

		ProductDAO dao = new ProductDAO();
		List<Product> products = dao.getProducts(10, page);
		long rows = dao.getNumberOfRows();
		int lastPageNumber = (int) (Math.ceil((double)rows / 10));
		dao.close();
		
		request.setAttribute("products", products);
		request.setAttribute("page", page);
		request.setAttribute("rows", rows);
		request.setAttribute("lastPageNumber", lastPageNumber);
		DispatchHelper.dispatch("/WEB-INF/jsp/admin/products.jsp", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

		ProductDAO dao = new ProductDAO();
		List<Product> products = dao.getProducts(10, page);
		dao.close();

		request.setAttribute("products", products);
		DispatchHelper.dispatch("/WEB-INF/jsp/admin/list_products.jsp", request, response);
	}
}
