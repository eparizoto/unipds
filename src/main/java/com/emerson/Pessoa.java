package com.emerson;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.util.List;

/**
 * @author emerson
 * O Panache define que se você deixar os atributos públicos, ele cria os getters e setters automaticamente e gerencia
 * isso para você. Se você quiser, pode criar os getters e setters manualmente, mas ai você vai precisar gerenciar isso.
 */
@Entity
public class Pessoa extends PanacheEntity {
    public String nome;
    public int anoNascimento;

    public static List<Pessoa> findByAnoNascimento(int anoNascimento) {
        return find("anoNascimento", anoNascimento).list();
    }
}


