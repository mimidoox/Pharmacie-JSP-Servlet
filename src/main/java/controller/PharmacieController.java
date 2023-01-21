package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service.PharmacieService;
import service.PharmacienService;
import service.PhotoService;
import service.VilleService;
import service.ZoneService;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;

import entities.Pharmacie;
import entities.Pharmacien;
import entities.Photo;
import entities.Ville;
import entities.Zone;

/**
 * Servlet implementation class PharmacieController
 */
@MultipartConfig
public class PharmacieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private PharmacieService ps;
       private ZoneService zs;
       private PharmacienService phs;
       private PhotoService pp;
       private VilleService vs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmacieController() {
        ps = new PharmacieService();
        zs = new ZoneService();
        phs = new PharmacienService();
        pp = new PhotoService();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				pp.delete(pp.findByPharma(ps.findById(id)));
				ps.delete(ps.findById(id));
				
				response.sendRedirect("pharmacies.jsp");
			}
			if (request.getParameter("op").equals("update")) {
				Pharmacie v = ps.findById(Integer.parseInt(request.getParameter("id")));
				response.sendRedirect("pharmacies.jsp?id=" + v.getId() + "&nom=" + v.getNom()+"&adresse="+v.getAdresse()+"&latitude="+v.getLatitude()+"&longitude="+v.getLongitude()+"&zone="+v.getZone());
			}
			if (request.getParameter("op").equals("localisation")) {
                Pharmacie p = ps.findById(Integer.parseInt(request.getParameter("id")));
                response.sendRedirect("map.jsp?&latitude=" + p.getLatitude() + "&longitude=" + p.getLongitude() );}

		} else if (!request.getParameter("id").equals("")) {
			
			Pharmacie v = ps.findById(Integer.parseInt(request.getParameter("id")));
			String nom = request.getParameter("nom");
			String adresse = request.getParameter("adresse");
			Pharmacien pharmacien = phs.findById(Integer.parseInt(request.getParameter("pharmacien")));
			
			double latitude = Double.parseDouble(request.getParameter("latitude"));
			double longitude = Double.parseDouble(request.getParameter("longitude"));
			Zone zone = zs.findById(Integer.parseInt(request.getParameter("zone")));
			v.setNom(nom);
			v.setAdresse(adresse);
			v.setLatitude(latitude);
			v.setLongitude(longitude);
			v.setZone(zone);
			v.setPharmacien(pharmacien);
			ps.update(v);
			response.sendRedirect("pharmacies.jsp");
			
		}else  {
			
			String nom = request.getParameter("nom");
			String adresse = request.getParameter("adresse");
			double latitude = Double.parseDouble(request.getParameter("latitude"));
			double longitude = Double.parseDouble(request.getParameter("longitude"));
			Zone zone = zs.findById(Integer.parseInt(request.getParameter("zone")));
			Pharmacien pharmacien = phs.findById(Integer.parseInt(request.getParameter("pharmacien")));
			
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
			/*} catch(Exception e) {
				e.printStackTrace();
			}*/
			response.sendRedirect("pharmacies.jsp");
			
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
