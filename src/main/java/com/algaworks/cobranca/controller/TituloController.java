package com.algaworks.cobranca.controller;

import com.algaworks.cobranca.model.StatusTitulos;
import com.algaworks.cobranca.model.Titulo;
import com.algaworks.cobranca.repository.Titulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping("/novo")
    public ModelAndView novo(){
        ModelAndView modelAndView = new ModelAndView("CadastroTitulo");
        modelAndView.addObject("todosStatusTitulo", StatusTitulos.values());
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(Titulo titulo){
        titulos.save(titulo);

        ModelAndView modelAndView = new ModelAndView("CadastroTitulo");
        modelAndView.addObject("mensagem", "Titulo salvo com sucesso");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView pesquisar(){
        ModelAndView modelAndView = new ModelAndView("PesquisaTitulos");
        return modelAndView;
    }

    @ModelAttribute("todosStatusTitulo")
    public List<StatusTitulos> todosStatusTitulo(){
        return Arrays.asList(StatusTitulos.values());
    }

}
