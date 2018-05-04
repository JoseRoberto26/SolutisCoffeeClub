package com.jose.solutis.server.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity

public class CapsulaCafe {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Não pode ser nulo")
    private String marca;
    private String sabor;
    private Integer doses;

    public CapsulaCafe() {
    }


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public Integer getDoses() {
        return doses;
    }

    public void setDoses(Integer doses) {
        this.doses = doses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
