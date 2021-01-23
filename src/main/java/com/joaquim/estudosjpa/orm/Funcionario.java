package com.joaquim.estudosjpa.orm;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name="funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cpf;
    private BigDecimal salario;
    private Calendar dataContratacao;
    @ManyToOne
    @JoinColumn (name = "cargo_id", nullable = false)
    private Cargo cargo;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "funcionarios_unidade", joinColumns = {@JoinColumn(name = "fk_funcionario")}, inverseJoinColumns = {@JoinColumn(name = "fk_funcionario")})
    private List<UnidadeTrabalho> unidadeTrabalhos;

    public Funcionario(String nome, String cpf, BigDecimal salario, Calendar dataContratacao, Cargo cargo) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.dataContratacao = dataContratacao;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public Calendar getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(Calendar dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", salario=" + salario +
                ", dataContratacao=" + dataContratacao +
                '}';
    }
}
