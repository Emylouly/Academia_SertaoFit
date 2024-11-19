package br.ifba.demo.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/cadastro")
	public String cadastro() {
		return "cadastro";
	}
	
    @GetMapping("/quemSomos")
	public String quemSomos() {
		return "quemSomos";
	}

    @GetMapping("/planos")
	public String planos() {
		return "planos";
	}

    @GetMapping("/perfil")
	public String perfil() {
		return "perfil";
	}

    @GetMapping("/treinos")
	public String treinos() {
		return "treinos";
	}

    @GetMapping("/arquivos")
	public String arquivos() {
		return "arquivos";
	}

	@GetMapping("/perfil2")
	public String perfil2(){
		return "perfil2";
	}

	@PostMapping("/process_login")
    public ModelAndView processLogin(HttpServletRequest request) {
        // Pega os valores dos campos de email e senha do formulário
        String usuario = request.getParameter("usuario");
        String senha = request.getParameter("senha");

        System.out.println("Usuário: " + usuario); // Para depuração
        System.out.println("Senha: " + senha);     // Para depuração

        ModelAndView mav = new ModelAndView();

        // Validação simples das credenciais
        if ("josegomes@gmail.com".equals(usuario) && "123".equals(senha)) {
            mav.setViewName("perfil");  // Se as credenciais estão corretas, redireciona para o perfil
        } 
        
        else if("emily@gmail.com".equals(usuario) && "123".equals(senha)) {
            mav.setViewName("perfil2");  // Se as credenciais estão corretas, redireciona para o perfil2
        } 

        else {
            mav.setViewName("login");  // Se as credenciais estão incorretas, retorna à página de login
            mav.addObject("errorMessage", "Credenciais inválidas. Tente novamente.");
        }

        return mav;
    }
	
}