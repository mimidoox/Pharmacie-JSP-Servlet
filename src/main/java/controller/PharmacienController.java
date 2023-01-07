package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PharmacienService;
import service.UtilisateurService;

import java.io.IOException;

/**
 * Servlet implementation class PharmacienController
 */
public class PharmacienController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PharmacienService ps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmacienController() {
        ps = new PharmacienService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				ps.delete(ps.findById(id));
				response.sendRedirect("pharmaciens.jsp");
			}}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
