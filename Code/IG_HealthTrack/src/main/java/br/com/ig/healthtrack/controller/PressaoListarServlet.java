package br.com.ig.healthtrack.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ig.healthtrack.bean.Pressao;
import br.com.ig.healthtrack.dao.PressaoDAO;
import br.com.ig.healthtrack.factory.DAOFactory;

/**
 * Servlet implementation class ProdutoListarController
 */
@WebServlet("/pressaolistar")
public class PressaoListarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PressaoDAO dao;

	public PressaoListarServlet() {
    	super();
		 dao = DAOFactory.getPressaoDAO();
    }
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int codigoUsuario = (int)session.getAttribute("codigoUsuario");
		
		ArrayList<Pressao> lista = (ArrayList<Pressao>) dao.listar(codigoUsuario);
		request.setAttribute("pressao", lista);
		
		request.getRequestDispatcher("historico-pressao.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		doGet(request, response);
		
		
	}

}
