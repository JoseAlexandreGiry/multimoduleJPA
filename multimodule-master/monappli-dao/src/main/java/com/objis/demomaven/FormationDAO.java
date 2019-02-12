package com.objis.demomaven;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;

import com.objis.demomaven.domaine.Formation;

public class FormationDAO {

	/**
     * @see HttpServlet#HttpServlet()
     */
    public FormationDAO() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	public void create(EntityManagerFactory emf, Formation maformation) throws ServletException, IOException{
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(maformation);
        tx.commit();
        em.close();
    }
	
	public List<Formation> read(EntityManagerFactory emf) throws ServletException, IOException{
		EntityManager em = emf.createEntityManager();
        return em.createQuery("SELECT f FROM Formation f", Formation.class).getResultList();
    }
}
