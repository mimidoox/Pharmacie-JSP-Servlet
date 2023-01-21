package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import service.PharmacieService;
import service.PharmacienService;
import service.PhotoService;
import service.VilleService;
import service.ZoneService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import entities.Pharmacie;
import entities.Pharmacien;
import entities.Photo;
import entities.Zone;

/**
 * Servlet implementation class ajouPharmaController
 */
public class ajouPharmaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private PharmacieService ps;
     private ZoneService zs;
     private PharmacienService phs;
     private PhotoService pp;
     private VilleService vs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajouPharmaController() {
    	ps = new PharmacieService();
        zs = new ZoneService();
        phs = new PharmacienService();
        pp = new PhotoService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
			
			String nom = request.getParameter("nom");
			String adresse = request.getParameter("adresse");
			double latitude = Double.parseDouble(request.getParameter("latitude"));
			double longitude = Double.parseDouble(request.getParameter("longitude"));
			Zone zone = zs.findById(Integer.parseInt(request.getParameter("zone")));
			Pharmacien pharmacien = (Pharmacien) session.getAttribute("pharmacien");
			
				Part file = request.getPart("photo");
				String imgFileName = file.getSubmittedFileName();
				String uploadPath = "C:/Users/DELL/Desktop/PharmaLoc/PharmaLoc/src/main/webapp/images/"+imgFileName;
				FileOutputStream fos = new FileOutputStream(uploadPath);
				InputStream is = file.getInputStream();
				byte[] data = new byte[is.available()];
	            is.read(data);
	            fos.write(data);
	            fos.close();
			
			
			
			Pharmacie pharma =new Pharmacie(nom,adresse,latitude,longitude,zone,pharmacien);
			ps.create(pharma);
			Photo p=new Photo(imgFileName,pharma);
			pp.create(p);
			
			response.sendRedirect("ajoutPharma.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
