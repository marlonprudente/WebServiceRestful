/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */
package com.marlonprudente.database;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Marlon Prudente <marlon.oliveira at alunos.utfpr.edu.br>
 */
@Entity
@Table(name = "hoteis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hoteis.findAll", query = "SELECT h FROM Hoteis h")
    , @NamedQuery(name = "Hoteis.findById", query = "SELECT h FROM Hoteis h WHERE h.id = :id")
    , @NamedQuery(name = "Hoteis.findByCidade", query = "SELECT h FROM Hoteis h WHERE h.cidade = :cidade")
    , @NamedQuery(name = "Hoteis.findByNomehotel", query = "SELECT h FROM Hoteis h WHERE h.nomehotel = :nomehotel")
    , @NamedQuery(name = "Hoteis.findByDataentrada", query = "SELECT h FROM Hoteis h WHERE h.dataentrada = :dataentrada")
    , @NamedQuery(name = "Hoteis.findByDatasaida", query = "SELECT h FROM Hoteis h WHERE h.datasaida = :datasaida")
    , @NamedQuery(name = "Hoteis.findByQuantidadequartos", query = "SELECT h FROM Hoteis h WHERE h.quantidadequartos = :quantidadequartos")
    , @NamedQuery(name = "Hoteis.findByNumeromaxpessoas", query = "SELECT h FROM Hoteis h WHERE h.numeromaxpessoas = :numeromaxpessoas")})
public class Hoteis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "CIDADE")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "NOMEHOTEL")
    private String nomehotel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATAENTRADA")
    @Temporal(TemporalType.DATE)
    private Date dataentrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATASAIDA")
    @Temporal(TemporalType.DATE)
    private Date datasaida;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTIDADEQUARTOS")
    private int quantidadequartos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMEROMAXPESSOAS")
    private int numeromaxpessoas;

    public Hoteis() {
    }

    public Hoteis(Integer id) {
        this.id = id;
    }

    public Hoteis(Integer id, String cidade, String nomehotel, Date dataentrada, Date datasaida, int quantidadequartos, int numeromaxpessoas) {
        this.id = id;
        this.cidade = cidade;
        this.nomehotel = nomehotel;
        this.dataentrada = dataentrada;
        this.datasaida = datasaida;
        this.quantidadequartos = quantidadequartos;
        this.numeromaxpessoas = numeromaxpessoas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNomehotel() {
        return nomehotel;
    }

    public void setNomehotel(String nomehotel) {
        this.nomehotel = nomehotel;
    }

    public Date getDataentrada() {
        return dataentrada;
    }

    public void setDataentrada(Date dataentrada) {
        this.dataentrada = dataentrada;
    }

    public Date getDatasaida() {
        return datasaida;
    }

    public void setDatasaida(Date datasaida) {
        this.datasaida = datasaida;
    }

    public int getQuantidadequartos() {
        return quantidadequartos;
    }

    public void setQuantidadequartos(int quantidadequartos) {
        this.quantidadequartos = quantidadequartos;
    }

    public int getNumeromaxpessoas() {
        return numeromaxpessoas;
    }

    public void setNumeromaxpessoas(int numeromaxpessoas) {
        this.numeromaxpessoas = numeromaxpessoas;
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
        if (!(object instanceof Hoteis)) {
            return false;
        }
        Hoteis other = (Hoteis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.marlonprudente.database.Hoteis[ id=" + id + " ]";
    }
    
}
