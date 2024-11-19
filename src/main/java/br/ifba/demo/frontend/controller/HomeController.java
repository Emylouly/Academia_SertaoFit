package br.ifba.demo.frontend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class HomeController {

	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	@PostMapping("process_login")
	public ModelAndView process_login(HttpServletRequest request, Model model ) {
		//TODO: process POST request
		System.out.println("--------------| process_login");
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		System.out.println("--------------| usuario: " + usuario);
		System.out.println("--------------| senha..: " + senha );

		ModelAndView mav = new ModelAndView();
		if ( senha.equals("123456") ) {
			mav.setViewName("dashboard");
		}
		else {
			mav.setViewName("erro");
		}
		return mav;
	}
	
	@GetMapping("/cadastrar_livro")
	public ModelAndView cadastrar_livro() {
		List<StatusLivro> lista_status = new ArrayList<StatusLivro>();
		StatusLivro st1 = new StatusLivro(1, "Comprado");
		StatusLivro st2 = new StatusLivro(2, "Lido");
		StatusLivro st3 = new StatusLivro(3, "Perdido");
		StatusLivro st4 = new StatusLivro(4, "Emprestado");
		StatusLivro st5 = new StatusLivro(5, "Desejado");

		lista_status.add( st1 );
		lista_status.add( st2 );
		lista_status.add( st3 );
		lista_status.add( st4 );
		lista_status.add( st5 );

		ModelAndView mav = new ModelAndView();
		mav.addObject("edicao", 12);
		mav.addObject("lista", lista_status);
		mav.setViewName("CadastrarLivro");
		return mav;
	}
}
