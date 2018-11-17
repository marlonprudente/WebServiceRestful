/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */
package com.marlonprudente.rest;

import com.google.gson.Gson;
import com.marlonprudente.database.Hoteis;
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
import javax.ws.rs.PathParam;
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
    @Path("/todas")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHospedagens() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restful");
        EntityManager em = emf.createEntityManager();
        Gson gson = new Gson();
        return "{\"hospedagens\": " + gson.toJson(em.createQuery("SELECT h FROM Hoteis h", Hoteis.class).getResultList()) + "}"; 
    }

    /**
     * PUT method for updating or creating an instance of HospedagemResource
     * @param id
     * @param content representation for the resource
     */
    @PUT
    @Path("/{id}/{quantidade}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String reservarQuarto(@PathParam("id") Integer id, @PathParam("quantidade") Integer quantidade){
        String resultado = "";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restful");
        EntityManager em = emf.createEntityManager();
        Hoteis hoteis = em.createQuery("SELECT h FROM Hoteis h WHERE h.id = " + id, Hoteis.class).getSingleResult();
        Gson gson = new Gson();        
        if(hoteis == null){
            resultado = "Não há Hoteis com o id solicitado.";
            return gson.toJson(resultado);
        }
        if(hoteis.getNumeromaxpessoas() >= quantidade){
            em.getTransaction().begin();
            hoteis.setNumeromaxpessoas(hoteis.getNumeromaxpessoas() - quantidade);
            em.persist(hoteis);
            em.getTransaction().commit();
            em.close();
            emf.close();
            resultado = "Quarto reservdo com sucesso.";
        }else{
            resultado = "Este quarto não está mais disponível para a quantidade solicitada.";       
        }      

        return gson.toJson(resultado);
    }
}
