package com.raos.ecommerce.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.raos.ecommerce.web.dao.ProductDAO;
import com.raos.ecommerce.web.util.DispatchHelper;

/**
 * Servlet implementation class Pagination
 */
@WebServlet("/admin/products/pagination")
public class Pagination extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pagination() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		ProductDAO dao = new ProductDAO();
		long rows = dao.getNumberOfRows();
		int lastPageNumber = (int) (Math.ceil(((double)rows) / 10));
		dao.close();

		request.setAttribute("page", page);
		request.setAttribute("rows", rows);
		request.setAttribute("lastPageNumber", lastPageNumber);
		DispatchHelper.dispatch("/WEB-INF/jsp/admin/pagination.jsp", request, response);
	}

}
