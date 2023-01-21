package service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import entities.Zone;

/**
 * Servlet implementation class VilleZoneController
 */
public class VilleZoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VilleService vs;
    private ZoneService zs;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VilleZoneController() {
    	 vs = new VilleService();
         zs = new ZoneService();
    }

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("m"));
		response.setContentType("application/json;charset=UTF-8");
		List<Zone> z = zs.findZonesByVille(vs.findById(id));
		for(Zone zz:z) {
			System.out.println(zz);
		}
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}

}
