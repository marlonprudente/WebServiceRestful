/*
 * Este sotfware foi feito para a UTFPR - Campus Curitiba;
 * O Código é livre para uso não comercial;
 * Desenvolvido através do Netbeans IDE.
 */
package com.marlonprudente.rest;

import com.google.gson.Gson;
import com.marlonprudente.database.Pacotes;
import com.marlonprudente.database.Passagens;
import java.util.List;
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
        return "{\"pacotes\": "  + gson.toJson(em.createQuery("SELECT p FROM Pacotes p", Pacotes.class).getResultList()) + "}";        
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String comprarPacote(@PathParam("id") Integer id){
        String resultado = "";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restful");
        EntityManager em = emf.createEntityManager();
        Pacotes pacote = em.createQuery("SELECT p FROM Pacotes p WHERE p.id = " + id, Pacotes.class).getSingleResult();
        Gson gson = new Gson();
        
        if(pacote == null){
            resultado = "Não há pacotes com o id solicitado";
            return gson.toJson(resultado);
        }
        if(pacote.getQantidadePessoas() > 0){
            em.getTransaction().begin();
            pacote.setQantidadePessoas(0);
            em.persist(pacote);
            em.getTransaction().commit();
            em.close();
            emf.close();
            resultado = "Pacote comprado com sucesso";
        }else{
            resultado = "Este pacote não está mais disponível";
        }
        
        return gson.toJson(resultado);
    }
}
