package org.devdom.api.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.devdom.api.model.dto.Group;
import org.devdom.api.model.dto.GroupInformation;

/**
 *
 * @author Carlos Vásquez Polanco
 */
public class GroupDao {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

    /**
     * Trae todos los datos informativos de los grupos
     * @return
     * @throws Exception 
     */
    public List<Group> findAllGroups() throws Exception{
        EntityManager em = emf.createEntityManager();
        try{
            return (List<Group>) em.createNamedQuery("group.findAll")
                    .getResultList();
        }finally{
            if(em!=null|em.isOpen())
                em.close();
        }
    }
    
    /**
     * return información sobre un grupo determinado según el ID
     * @param groupId
     * @return
     * @throws Exception 
     */
    public Group findGroupById(String groupId) throws Exception{

        EntityManager em = emf.createEntityManager();
        try{
            return (Group) em.createNamedQuery("group.findByGroupId")
                    .setParameter("group_id", groupId)
                    .getSingleResult();
        }finally{
            if(em!=null|em.isOpen())
                em.close();
        }
    }
    
    public List<GroupInformation> findGroupsByTypedName(String find) throws Exception{
        
        EntityManager em = emf.createEntityManager();
        try{
            return (List<GroupInformation>) em.createNamedQuery("Group.search_group")
                    .setParameter("find", find)
                    .getResultList();
        }finally{
            if(em!=null|em.isOpen())
                em.close();
        }
    }

}