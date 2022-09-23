package br.com.sgsistemas.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns =  "/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		System.out.println("Cadastrando empresa...");
		
		String razaoSocial = request.getParameter("razaoSocial");
		
		//Banco banco = new Banco();
		Empresa empresa = new Empresa(3,razaoSocial);
		Banco.adiciona(empresa);
		
		PrintWriter out = response.getWriter();
		out.println("Empresa " + razaoSocial + " cadastrada com sucesso!");
		
		List<Empresa> lista = new ArrayList<>();
		lista = Banco.getEmpresas();
		lista.forEach(list -> System.out.println(list));
	}

}
