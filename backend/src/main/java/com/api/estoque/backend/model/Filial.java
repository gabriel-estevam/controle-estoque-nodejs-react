package com.api.estoque.backend.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.api.estoque.backend.model.enums.StatusOption;

@Entity
@Table(name = "filial")
public class Filial implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_filial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String cnpj;
    @Column(name = "status")
    private Integer statusFilial;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Filial() {

    }

    public Filial(Long id, String name, String phoneNumber, String cnpj, StatusOption statusFilial) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.cnpj = cnpj;
     //   this.usuario = usuario;
        setStatusFilial(statusFilial);
    }

    public Long getIdFilial() {
        return id;
    }

    public void setIdFilial(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public StatusOption getStatusFilial() {
        return StatusOption.valueOf(statusFilial);
    }

    public void setStatusFilial(StatusOption statusFilial) {
        if(statusFilial != null) {
            this.statusFilial = statusFilial.getCode();
        }
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Filial other = (Filial) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    
}
