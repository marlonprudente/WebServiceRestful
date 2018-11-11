/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */
package com.marlonprudente.rest;

import com.google.gson.Gson;
import com.marlonprudente.database.Pacotes;
import com.marlonprudente.database.Passagens;
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
@Path("Pacotes")
public class PacotesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PacotesResource
     */
    public PacotesResource() {
    }

    /**
     * Retrieves representation of an instance of com.marlonprudente.rest.PacotesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPacotes() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restful");
        EntityManager em = emf.createEntityManager();
        Gson gson = new Gson();
        return gson.toJson(em.createQuery("SELECT p FROM Pacotes p", Pacotes.class).getResultList()); 
    }

    /**
     * PUT method for updating or creating an instance of PacotesResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
