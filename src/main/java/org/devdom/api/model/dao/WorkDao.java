package org.devdom.api.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.devdom.api.model.dto.Work;

/**
 *
 * @author Ronny Placencia
 */
public class WorkDao {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    
    public List<Work> findWorksByTypedName(String name) throws Exception{
        EntityManager em = emf.createEntityManager();
        try{
            return (List<Work>) em.createNamedQuery("Work.search_developers_work")
                    .setParameter("name", name)
                    .getResultList();
        }finally{
            if(em!=null|em.isOpen())
                em.close();
        }
    }
    
}
