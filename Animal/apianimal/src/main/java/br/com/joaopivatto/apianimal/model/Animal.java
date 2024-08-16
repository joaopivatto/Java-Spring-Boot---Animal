package br.com.joaopivatto.apianimal.model;

import jakarta.persistence.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    int id;
    private String nome;
    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private String raca;

    public Animal(){
        this.id = 0;
        this.nome = "";
        this.dataNascimento = new Date();
        this.raca = "";
    }

    public Animal(int id, String nome, Date dataNascimento, String raca){
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.raca = raca;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return new SimpleDateFormat("yyyy-MM-dd").format(dataNascimento);
    }

    public String getRaca() {
        return raca;
    }

    public void setDataNascimento(String dataNascimento) throws ParseException {
        this.dataNascimento = new SimpleDateFormat("yyyy-MM-dd").parse(dataNascimento);
    }
}

