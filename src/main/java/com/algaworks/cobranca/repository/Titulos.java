package com.algaworks.cobranca.repository;

import com.algaworks.cobranca.model.Titulo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rchibana on 2017/03/28.
 */
public interface Titulos extends JpaRepository<Titulo, Long> {
}
