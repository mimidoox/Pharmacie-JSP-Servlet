package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.GardeService;

import java.io.IOException;

import entities.Garde;

/**
 * Servlet implementation class GardeController
 */
public class GardeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private GardeService gs;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GardeController() {
        gs = new GardeService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				gs.delete(gs.findById(id));
				response.sendRedirect("gardes.jsp");
			}
			if (request.getParameter("op").equals("update")) {
				Garde g = gs.findById(Integer.parseInt(request.getParameter("id")));
				response.sendRedirect("gardes.jsp?id=" + g.getId() + "&type=" + g.getType());
			}

		} else if (!request.getParameter("id").equals("")) {
			Garde g = gs.findById(Integer.parseInt(request.getParameter("id")));
			String type = request.getParameter("nom");
			g.setType(type);
			gs.update(g);
			response.sendRedirect("gardes.jsp");
			
		}else  {
			
			String type = request.getParameter("nom");
			gs.create(new Garde(type));
			response.sendRedirect("gardes.jsp");
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
