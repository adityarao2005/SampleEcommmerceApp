package com.raos.ecommerce.web.controller;

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
 * Servlet implementation class ShopController
 */
@WebServlet("/shop")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Fetch all products from the database
		// return view with products displaying templates
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));

		ProductDAO dao = new ProductDAO();
		List<Product> products = dao.getProducts(10, page);
		long rows = dao.getNumberOfRows();
		int lastPageNumber = (int) (Math.ceil((double)rows / 10));
		products.forEach(e -> {
			if (e.getImage() == null || e.getImage().trim().isEmpty()) {
				e.setImage(request.getContextPath() + "/resources/images/default_image.jpg");
			}
		});
		dao.close();
		
//		User user = null;
//		HttpSession session = request.getSession(false);
//		if (session == null || session.getAttribute("user") == null) {
//			response.sendRedirect(request.getContextPath() + "login");
//			return;
//		}
//		user = (User) session.getAttribute("user");
		
		request.setAttribute("products", products);
		request.setAttribute("page", page);
		request.setAttribute("rows", rows);
		request.setAttribute("lastPageNumber", lastPageNumber);
		DispatchHelper.dispatch("/WEB-INF/jsp/shop.jsp", request, response);
	}

}
