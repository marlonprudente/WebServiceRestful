/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */
package com.marlonprudente.database;

import com.google.gson.Gson;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
@Table(name = "passagens")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passagens.findAll", query = "SELECT p FROM Passagens p")
    , @NamedQuery(name = "Passagens.findById", query = "SELECT p FROM Passagens p WHERE p.id = :id")
    , @NamedQuery(name = "Passagens.findByOrigem", query = "SELECT p FROM Passagens p WHERE p.origem = :origem")
    , @NamedQuery(name = "Passagens.findByDestino", query = "SELECT p FROM Passagens p WHERE p.destino = :destino")
    , @NamedQuery(name = "Passagens.findByValor", query = "SELECT p FROM Passagens p WHERE p.valor = :valor")
    , @NamedQuery(name = "Passagens.findByPoltronas", query = "SELECT p FROM Passagens p WHERE p.poltronas = :poltronas")
    , @NamedQuery(name = "Passagens.findByData", query = "SELECT p FROM Passagens p WHERE p.data = :data")})
public class Passagens implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ORIGEM")
    private String origem;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DESTINO")
    private String destino;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOR")
    private long valor;
    @Column(name = "POLTRONAS")
    private Integer poltronas;
    @Column(name = "DATA")
    @Temporal(TemporalType.DATE)
    private Date data;

    public Passagens() {
    }

    public Passagens(Integer id) {
        this.id = id;
    }

    public Passagens(Integer id, String origem, String destino, long valor) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Integer getPoltronas() {
        return poltronas;
    }

    public void setPoltronas(Integer poltronas) {
        this.poltronas = poltronas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        if (!(object instanceof Passagens)) {
            return false;
        }
        Passagens other = (Passagens) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        Map<String, String> tabela = new HashMap<String,String>();
        tabela.put("id", id.toString());
        tabela.put("origem", origem);
        tabela.put("destino", destino);
        tabela.put("valor", String.valueOf(valor));
        tabela.put("poltronas", poltronas.toString());
        tabela.put("data", data.toString());
        
        Gson gson = new Gson();
        
        return gson.toJson(tabela);
    }
    
}
