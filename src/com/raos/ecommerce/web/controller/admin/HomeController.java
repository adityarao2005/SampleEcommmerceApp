package com.raos.ecommerce.web.controller.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.raos.ecommerce.web.dao.UserDAO;
import com.raos.ecommerce.web.models.User;
import com.raos.ecommerce.web.util.DispatchHelper;

/**
 * Servlet implementation class HomeController
 */
@WebServlet(name = "AdminHomeController", urlPatterns = { "/admin" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isAuth = true;
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("user") == null) {
			isAuth = false;
		} else {
			UserDAO dao = new UserDAO();
			isAuth = dao.getUserByEmail(((User) session.getAttribute("user")).getEmail()).isAdmin();
			dao.close();
		}
		
		if (!isAuth) {
			response.sendError(403);
			return;
		}
		
		DispatchHelper.dispatch("/WEB-INF/jsp/admin/index.jsp", request, response);
	}

}
