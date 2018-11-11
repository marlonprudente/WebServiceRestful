/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */
package com.marlonprudente.rest;

import com.google.gson.Gson;
import com.marlonprudente.database.Hoteis;
import com.marlonprudente.database.Pacotes;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Marlon Prudente <marlon.oliveira at alunos.utfpr.edu.br>
 */
@Path("Hospedagem")
public class HospedagensResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HospedagemResource
     */
    public HospedagensResource() {
    }

    /**
     * Retrieves representation of an instance of com.marlonprudente.rest.HospedagemResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getHospedagens() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restful");
        EntityManager em = emf.createEntityManager();
        Gson gson = new Gson();
        return gson.toJson(em.createQuery("SELECT h FROM Hoteis h", Hoteis.class).getResultList()); 
    }

    /**
     * PUT method for updating or creating an instance of HospedagemResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
