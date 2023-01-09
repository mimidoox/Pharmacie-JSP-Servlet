package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.PharmacienService;
import service.UtilisateurService;
import util.Utils;

import java.io.IOException;

import entities.Pharmacien;
import entities.Utilisateur;
import entities.Ville;

/**
 * Servlet implementation class RegistrationController
 */
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurService us;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        us = new UtilisateurService(); 
        }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
		String prenom = request.getParameter("firstName");
		String nom = request.getParameter("LastName");
		String login= request.getParameter("email");
		String pass1= request.getParameter("password1");
		String pass2= request.getParameter("password2");
		if(prenom!=""&&nom!=""&&login!=""&&pass1!=""&&pass2!=""&&pass1==pass2) {
			ps.create(new Pharmacien(login,"",nom,prenom,login,pass1));
			response.sendRedirect("index.jsp");*/
			//if(!request.getParameter("firstName").equals("") && !request.getParameter("LastName").equals("") && !request.getParameter("email").equals("") && !request.getParameter("password1").equals("") && !request.getParameter("password2").equals("")) {
				String prenom = request.getParameter("firstName");
				String nom = request.getParameter("lastName");
				String login= request.getParameter("username");
				String email= request.getParameter("email");
				String tel = request.getParameter("tel");
				String pass1= request.getParameter("password1");
				String pass2= request.getParameter("password2");
				us.create(new Pharmacien(email,tel,nom,prenom,login,Utils.MD5(pass2)));
				response.sendRedirect("authentification.jsp");
			}
			
		
			

		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
