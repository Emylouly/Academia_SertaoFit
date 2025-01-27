package br.ifba.demo.frontend.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import br.ifba.demo.frontend.service.CadastroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import br.ifba.demo.frontend.dto.CadastroDTO;

@Controller
public class CadastroController {

    @Autowired
    private CadastroService cadastroService;

    @PostMapping("/cadastro/save")
    public String save(@ModelAttribute CadastroDTO cadastroDTO) {
        cadastroService.save(cadastroDTO);
        return "redirect:/cadastro/listAll"; 
    }

    @GetMapping("/cadastro/listAll")
    public ModelAndView listAll() {
        List<CadastroDTO> listaCadastros = cadastroService.listAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("listaCadastro", listaCadastros);
        mv.setViewName("cadastro");
        return mv;
    }

    @GetMapping("/cadastro/findById/{id}")
    public ModelAndView getById(@PathVariable Long id) {
        CadastroDTO cadastro = cadastroService.getById(id);
        ModelAndView mv = new ModelAndView();
        if (cadastro != null) {
            mv.addObject("listaCadastros", List.of(cadastro));
        } else {
            mv.addObject("errorMessage", "Cadastro não encontrado!");
        }
        mv.setViewName("cadastro");
        return mv;
    }

    @GetMapping("/cadastro/findByNome/{nomeCadastro}")
    public ModelAndView getByNome(@RequestParam("nomeCadastro") String nomeCadastro) {
        List<CadastroDTO> cadastros = cadastroService.getByNome(nomeCadastro);
        ModelAndView mv = new ModelAndView();
        if (!cadastros.isEmpty()) {
            mv.addObject("listaCadastros", cadastros);
        } else {
            mv.addObject("errorMessage", "Cadastro não encontrado!");
        }
        mv.setViewName("cadastro");
        return mv;
    }

    @GetMapping("/cadastro/findByCpf/{cpfCadastro}")
    public ModelAndView getByCpf(@RequestParam("cpfCadastro") String cpfCadastro) {
        CadastroDTO cadastro = cadastroService.getByCpf(cpfCadastro);
        ModelAndView mv = new ModelAndView();
        if (cadastro != null) {
            mv.addObject("listaCadastro", List.of(cadastro));
        } else {
            mv.addObject("errorMessage", "Cadastro não encontrado!");
        }
        mv.setViewName("cadastro");
        return mv;
    }

    @GetMapping("/cadastro/findByEmail/{emailCadastro}")
    public ModelAndView getByEmail(@RequestParam("emailCadastro") String emailCadastro) {
        CadastroDTO cadastro = cadastroService.getByEmail(emailCadastro);
        ModelAndView mv = new ModelAndView();
        if (cadastro != null) {
            mv.addObject("listaCadastro", List.of(cadastro));
        } else {
            mv.addObject("errorMessage", "Cadastro não encontrado!");
        }
        mv.setViewName("cadastro");
        return mv;
    }

    @GetMapping("/cadastro/delete/{id}")
    public ModelAndView delete(@PathVariable Long id) {
        cadastroService.delete(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("deleteMessage", "Cadastro excluído!");
        mv.setViewName("cadastro"); 
        return mv;
    }
}
