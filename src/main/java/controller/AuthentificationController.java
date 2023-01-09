package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UtilisateurService;

import java.io.IOException;
import java.util.List;

import entities.Admin;
import entities.Pharmacien;
import entities.Utilisateur;

/**
 * Servlet implementation class AuthentificationController
 */
public class AuthentificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurService us;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthentificationController() {
        us = new UtilisateurService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 
		if(!request.getParameter("email").equals("") && !request.getParameter("password").equals("")) {
			String login = request.getParameter("email");
			String password = request.getParameter("password");

			 if(us.findUserByEmail(login)!=null) {
				 Utilisateur u = us.findUserByEmail(login);
				 if (u.getPassword().equals(password)) {
					 for(Utilisateur ut : us.findAdmins()) {
						 if(ut.getId()==u.getId()) {
							 HttpSession session = request.getSession();
								session.setAttribute("admin", u);
								response.sendRedirect("villes.jsp");
						 }else {
							 HttpSession session = request.getSession();
								session.setAttribute("pharmacien", u);
								response.sendRedirect("zones.jsp");
						 }
					 }
						
					} 
					}
			 else {
					response.sendRedirect("authentification.jsp");
			}

			
			
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		}
	
	
	public int isExist(Utilisateur r) {
		int id=-1;
		for(Utilisateur u:us.findAll()) {
			if(u.getLogin()==r.getLogin() && u.getPassword()==r.getPassword()) {
				
				id= u.getId();
				
			}
			else {
				id= -1;
			}
			
		}return id;
		
	}
}