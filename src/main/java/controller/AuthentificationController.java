package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.UtilisateurService;
import util.Utils;

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
			

			 if(us.findUserByEmailPass(login,Utils.MD5(password))!=null) {
				 boolean isAdmin=false;
				 Utilisateur u = us.findUserByEmailPass(login,Utils.MD5(password));
				 if (u.getPassword().equals(Utils.MD5(password))) {
					 HttpSession session = request.getSession();
					
					 for(Utilisateur ut:us.findAdmins()) {
						 if(ut.getId()==u.getId()) {
							 	isAdmin=true;
							 	break;
								
								
						 }
					 }
					 		if(isAdmin==false) {
								session.setAttribute("pharmacien", u);
								response.sendRedirect("mespharmacies.jsp");
								}
					 		else {
					 			session.setAttribute("admin", u);
								response.sendRedirect("dashbord.jsp");
						 }
					 }
						
					} else {
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