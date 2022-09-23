package br.com.sgsistemas.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listaDeEmpresas")
public class ListaDeEmpresas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<Empresa> lista = new ArrayList<>();
		lista = Banco.getEmpresas();
		
		String listaPessoas="";
		for(Empresa empresa : lista) {
			listaPessoas +=  "<li>" + empresa.getNome() + "</li>";
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html>"
				  + "<body>"
				  + "<ul>"
				  + listaPessoas
				  + "</ul>"
				  + "</body>"
				  + "</html>");
	}


}
