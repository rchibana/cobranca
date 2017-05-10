package com.algaworks.cobranca.controller;

import com.algaworks.cobranca.model.StatusTitulos;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        modelAndView.addObject("todosStatusTitulo", StatusTitulos.values());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView salvar(Titulo titulo){
        titulos.save(titulo);

        ModelAndView modelAndView = new ModelAndView("CadastroTitulo");
        modelAndView.addObject("mensagem", "Titulo salvo com sucesso");
        return modelAndView;
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
