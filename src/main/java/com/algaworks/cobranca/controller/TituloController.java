package com.algaworks.cobranca.controller;

import com.algaworks.cobranca.model.StatusTitulos;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rchibana on 2017/03/22.
 */
@Controller
@RequestMapping("/titulos")
public class TituloController {

    @Autowired
    private Titulos titulos;

    @GetMapping("/novo")
    public ModelAndView novo(){
        ModelAndView modelAndView = new ModelAndView("CadastroTitulo");
        modelAndView.addObject(new Titulo());
        return modelAndView;
    }

    @PostMapping
    public String salvar(@Validated Titulo titulo, Errors errors, RedirectAttributes attributes){

        if(errors.hasErrors()){
            return "CadastroTitulo";
        }

        titulos.save(titulo);
        attributes.addFlashAttribute("mensagem", "Titulo salvo com sucesso");
        return "redirect:/titulos/novo";
    }

    @GetMapping
    public ModelAndView pesquisar(){
        final List<Titulo> todosTitulos = titulos.findAll();
        ModelAndView modelAndView = new ModelAndView("PesquisaTitulos");
        modelAndView.addObject("titulos", todosTitulos);
        return modelAndView;
    }

    @ModelAttribute("todosStatusTitulo")
    public List<StatusTitulos> todosStatusTitulo(){
        return Arrays.asList(StatusTitulos.values());
    }

}
