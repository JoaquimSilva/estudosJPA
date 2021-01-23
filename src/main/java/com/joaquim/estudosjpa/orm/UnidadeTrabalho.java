package com.joaquim.estudosjpa.orm;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="unidades")
public class UnidadeTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descricao;

    private String endereco;

    @ManyToMany (mappedBy = "unidades", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios;


    public UnidadeTrabalho(String descricao, String endereco, List<Funcionario> funcionarios) {
        this.descricao = descricao;
        this.endereco = endereco;
        this.funcionarios = funcionarios;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "UnidadeTrabalho{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }
}
