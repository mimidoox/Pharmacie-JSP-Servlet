package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GardeService;
import service.PharmacieDeGardeService;
import service.PharmacieService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

import entities.Garde;
import entities.Pharmacie;
import entities.PharmacieDeGarde;
import entities.PharmacieDeGardePK;

/**
 * Servlet implementation class PharmaGardeController
 */
public class PharmaGardeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		private GardeService gs;
		private PharmacieService ps;
		private PharmacieDeGardeService pdgs;
    public PharmaGardeController() {
        gs= new GardeService() ;
        ps = new PharmacieService();
        pdgs = new PharmacieDeGardeService();}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	  */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String datedeb =request.getParameter("datedeb");
		String datefin =request.getParameter("datefin");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			Date dd = sdf.parse(datedeb);
			System.out.println("dd:"+dd);
			Date df = sdf.parse(datefin);
			int idp = Integer.parseInt(request.getParameter("pharmacie"));
			Pharmacie p = ps.findById(idp);
			Garde ga = gs.findById( Integer.parseInt(request.getParameter("garde")));
			PharmacieDeGardePK id = new PharmacieDeGardePK(p.getId(), ga.getId(),dd);
		    
			pdgs.create(new PharmacieDeGarde(id,df,p,ga));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	    response.sendRedirect("pharmagardes.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	

}
}