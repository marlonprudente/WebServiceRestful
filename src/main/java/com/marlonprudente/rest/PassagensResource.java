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
     * Retrieves representation of an instance of com.marlonprudente.rest.HelloworldResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "Hello World!";
    }
    /**
     * Retrieves representation of an list of instance of com.marlonprudente.rest.PassagensResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/todas")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPassagens(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restful");
        EntityManager em = emf.createEntityManager();
        Gson gson = new Gson();
        return "{\"passagens\": " + gson.toJson(em.createQuery("SELECT p FROM Passagens p", Passagens.class).getResultList()) + "}";        
    }
    /**
     * Metodo de compra de passagens
     * @param id identificação da passagem
     * @param quantidade numero de poltronas
     * @return  resultado da operacao para o cliente
     */
    @PUT
    @Path("/{id}/{quantidade}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String comprarPassagem(@PathParam("id") Integer id, @PathParam("quantidade") Integer quantidade){
        String resultado = "";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restful");
        EntityManager em = emf.createEntityManager();
        Passagens passagem = em.createQuery("SELECT p FROM Passagens p WHERE p.id = " + id, Passagens.class).getSingleResult();
        Gson gson = new Gson();
        
        if(passagem == null){
            resultado = "Não há passagens com o id solicitado.";
            return gson.toJson(resultado);
        }
        if(passagem.getPoltronas() >= quantidade){
            em.getTransaction().begin();
            passagem.setPoltronas(passagem.getPoltronas() - quantidade);
            em.persist(passagem);
            em.getTransaction().commit();
            em.close();
            emf.close();
            resultado = "Passagem comprada com sucesso.";
        }else{
            resultado = "Esta passagem não está mais disponível para a quantidade solicitada.";
        }      

        return gson.toJson(resultado);
    }
}
