/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */
package com.marlonprudente.rest;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import com.marlonprudente.database.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author Marlon Prudente <marlon.oliveira at alunos.utfpr.edu.br>
 */
@Path("Passagens")
public class PassagensResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PassagensResource
     */
    public PassagensResource() {
        
    }
    /**
     * Retrieves representation of an list of instance of com.marlonprudente.rest.PassagensResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPassagens(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restful");
        EntityManager em = emf.createEntityManager();
        Gson gson = new Gson();
        return gson.toJson(em.createQuery("SELECT p FROM Passagens p", Passagens.class).getResultList());        
    }
    @POST
    @Path("/Passagens/{id}/{quantidade}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void comprarPassagem(@PathParam("id") Integer passagemId,@PathParam("quantidade") Integer quantidadeAcentos){
        
    }
    

    /**
     * PUT method for updating or creating an instance of PassagensResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
