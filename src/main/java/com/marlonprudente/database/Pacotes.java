/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */
package com.marlonprudente.database;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marlon Prudente <marlon.oliveira at alunos.utfpr.edu.br>
 */
@Entity
@Table(name = "pacotes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacotes.findAll", query = "SELECT p FROM Pacotes p")
    , @NamedQuery(name = "Pacotes.findById", query = "SELECT p FROM Pacotes p WHERE p.id = :id")
    , @NamedQuery(name = "Pacotes.findByPassagemID", query = "SELECT p FROM Pacotes p WHERE p.passagemID = :passagemID")
    , @NamedQuery(name = "Pacotes.findByHotelID", query = "SELECT p FROM Pacotes p WHERE p.hotelID = :hotelID")
    , @NamedQuery(name = "Pacotes.findByValor", query = "SELECT p FROM Pacotes p WHERE p.valor = :valor")
    , @NamedQuery(name = "Pacotes.findByQantidadePessoas", query = "SELECT p FROM Pacotes p WHERE p.qantidadePessoas = :qantidadePessoas")})
public class Pacotes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PassagemID")
    private int passagemID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HotelID")
    private int hotelID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Valor")
    private long valor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QantidadePessoas")
    private int qantidadePessoas;

    public Pacotes() {
    }

    public Pacotes(Integer id) {
        this.id = id;
    }

    public Pacotes(Integer id, int passagemID, int hotelID, long valor, int qantidadePessoas) {
        this.id = id;
        this.passagemID = passagemID;
        this.hotelID = hotelID;
        this.valor = valor;
        this.qantidadePessoas = qantidadePessoas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPassagemID() {
        return passagemID;
    }

    public void setPassagemID(int passagemID) {
        this.passagemID = passagemID;
    }

    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public int getQantidadePessoas() {
        return qantidadePessoas;
    }

    public void setQantidadePessoas(int qantidadePessoas) {
        this.qantidadePessoas = qantidadePessoas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacotes)) {
            return false;
        }
        Pacotes other = (Pacotes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marlonprudente.database.Pacotes[ id=" + id + " ]";
    }
    
}
