package br.com.ig.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.ig.healthtrack.bean.Usuario;
import br.com.ig.healthtrack.dao.UsuarioDAO;
import br.com.ig.healthtrack.exception.DBException;
import br.com.ig.healthtrack.factory.DAOFactory;
import br.com.ig.healthtrack.utils.CriptografiaUtils;

/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UsuarioDAO dao;

    
	public UsuarioServlet() {
		 super();
		 dao = DAOFactory.getUsuarioDAO();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		
		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request,response);
			break;
		case "login":
			login(request, response);
			break;
		}
		
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			
			HttpSession session = request.getSession();
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
						
			Usuario usuario = dao.obterPorEmail(email);
			
			var senhaCriptografada = CriptografiaUtils.criptografar(senha);
			var senhaBanco = usuario.getSenha();
			
			if(senhaBanco.equals(senhaCriptografada)) {
				session.setAttribute("codigoUsuario", usuario.getCodigo());
				session.setAttribute("nomeUsuario", usuario.getNome());
				request.getRequestDispatcher("dashboard.jsp").forward(request, response);
			}
			else {
				   System.out.println("<script type=\"text/javascript\">");
				   System.out.println("alert('Usuário ou senha incorretos');");
				   System.out.println("location='Login.jsp';");
				   System.out.println("</script>");				
			}
				
			
			request.setAttribute("msg", "Usuário atualizado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		
	}
	
	
	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String nome = request.getParameter("nome");
			String apelido = request.getParameter("apelido");
			int altura = Integer.parseInt(request.getParameter("altura"));
			String cpf = request.getParameter("cpf").replaceAll("[^\\d ]","");
						
	     	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(format.parse(request.getParameter("dataNascimento")));
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String celular = request.getParameter("celular").replaceAll("[^\\d ]","");
			int sexo = Integer.parseInt(request.getParameter("sexo"));
			
			Usuario usuario = new Usuario(codigo,
					nome,
					apelido,
					null,
					altura,
					cpf,
					null,
					dataNascimento,
					email,
					senha,
					celular,
					sexo); 
			
			dao.atualizar(usuario);
			
			request.setAttribute("msg", "Usuário atualizado!");
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("Peso.jsp").forward(request, response);
	}
	


	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
			String nome = request.getParameter("nome");
			String apelido = request.getParameter("apelido");
			int altura = Integer.parseInt(request.getParameter("altura"));
			String cpf = request.getParameter("cpf").replaceAll("[^\\d ]","");
						
	     	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(format.parse(request.getParameter("dataNascimento")));
			
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			String celular = request.getParameter("celular").replaceAll("[^\\d ]","");
			int sexo = Integer.parseInt(request.getParameter("sexo"));
			
			Usuario usuario = new Usuario(0,
					nome,
					apelido,
					null,
					altura,
					cpf,
					null,
					dataNascimento,
					email,
					senha,
					celular,
					sexo); 
			
			dao.cadastrar(usuario);
			
			request.setAttribute("msg", "Usuário cadastrado!");
			
		}catch(DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar");
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("erro","Por favor, valide os dados");
		}
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("codigo"));
		Usuario usuario = dao.obter(id);
		request.setAttribute("usuario", usuario);
		
		request.getRequestDispatcher("edicao-usuario.jsp").forward(request, response);
	}
}
