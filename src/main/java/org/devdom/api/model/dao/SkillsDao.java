package org.devdom.api.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.devdom.api.model.dto.MasterSkillset;
import org.devdom.api.model.dto.Pagination;
import org.devdom.api.model.dto.Skills;

/**
 * Clase SkillsDao.
 * 
 * @author      Carlos Vásquez Polanco
 */
public class SkillsDao{
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

    private final MasterSkillset skillset = new MasterSkillset();
    private final CategoryDao category = new CategoryDao();
    private final int ROWS_PER_PAGE = 10;
    private int from = 0;
    private int to = 0;
    private int rowCount = 0;
    private int currentPage = 1;
    
    /**
     *
     */
    public SkillsDao(){
    }

    /**
     *
     * @param categoryId
     * @param votesGt
     * @param limit
     * @param acceptHeader
     * @param path
     * @return
     */
    public MasterSkillset getAllSkillsByTopFilters(int categoryId, int votesGt, int limit, String acceptHeader, String path){
        return getAllSkillsByTopFilters(categoryId, votesGt, limit, acceptHeader, path, 1);
    }

    /**
     *
     * @param categoryId
     * @param votesGt
     * @param limit
     * @param acceptHeader
     * @param path
     * @param page
     * @return
     */
    public MasterSkillset getAllSkillsByTopFilters(int categoryId, int votesGt, int limit, String acceptHeader, String path, int page) {

        currentPage = page;
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);

        List<Skills> skills = findAllSkillsByTopFilters(categoryId, votesGt, limit);
        rowCount = skills.size();

        to = (to>rowCount)?rowCount:to;

        skills = skills.subList(from,to); 

        if(categoryId!=0){
            skillset.setCategory(category.findCategoryById(categoryId));
        }

        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        
        skillset.setPagination(pagination);
        skillset.setSkills(skills);
        
        return skillset;
    }
    
    /**
     *
     * @param acceptHeader
     * @param path
     * @return
     */
    public MasterSkillset getAllSkills(String acceptHeader, String path){
        
        return getAllSkills(acceptHeader, path, 1);
    }
    
    /**
     *
     * @param acceptHeader
     * @param path
     * @param page
     * @return
     */
    public MasterSkillset getAllSkills(String acceptHeader, String path, int page) {
        currentPage = page;
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        List<Skills> skills = this.findAllSkills();
        rowCount = skills.size();
        
        to = (to>rowCount)?rowCount:to;
        
        skills = skills.subList(from,to); 
        
        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        
        skillset.setPagination(pagination);
        skillset.setSkills(skills);
        
        return skillset;
    }
    
    /**
     *
     * @param id
     * @param acceptHeader
     * @param path
     * @return
     */
    public MasterSkillset getSkillsByDeveloperId(int id, String acceptHeader, String path) {
        
        return getSkillsByDeveloperId(id,acceptHeader,path,1);
    }
    
    /**
     *
     * @param developerId
     * @param acceptHeader
     * @param path
     * @param page
     * @return
     */
    public MasterSkillset getSkillsByDeveloperId(int developerId, String acceptHeader, String path, int page) {
        
        DeveloperDao developerDao = new DeveloperDao();
        currentPage = page;
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        List<Skills> skills = this.findSkillsByDeveloperId(developerId);
        
        rowCount = skills.size();
        
        to = (to>rowCount)?rowCount:to;
        
        skills = skills.subList(from,to); 
        
        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();

        skillset.setPagination(pagination);
        skillset.setDevelopers(developerDao.findDeveloperById(developerId));
        skillset.setSkills(skills);

        return skillset;

    }
        
    /**
     *
     * @param id
     * @param acceptHeader
     * @param path
     * @return
     */
    public MasterSkillset getSkillsByCategoryId(int id, String acceptHeader, String path) {
        
        return getSkillsByCategoryId(id,acceptHeader,path,1);
    }

    /**
     *
     * @param categoryId
     * @param acceptHeader
     * @param path
     * @param page
     * @return
     */
    public MasterSkillset getSkillsByCategoryId(int categoryId, String acceptHeader, String path, int page){
        
        currentPage = page;
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        List<Skills> skills = this.findSkillsByCategoryId(categoryId);
        rowCount = skills.size();
        
        to = (to>rowCount)?rowCount:to;
        
        skills = skills.subList(from,to); 
        
        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        
        skillset.setPagination(pagination);
        skillset.setCategory(category.findCategoryById(categoryId));
        skillset.setSkills(skills);
        
        return skillset;
        
    }

    private List<Skills> findSkillsByCategoryId(int category_id){
        
        EntityManager em = emf.createEntityManager();
        List<Skills> skills = null; 
        try{

            skills = em.createNamedQuery("Skills.findSkillsByCategoryId")
                       .setParameter("category_id",category_id)
                       .getResultList();

        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return skills;
    }
    
    /**
     *
     * @param developerId
     * @return
     */
    public List<Skills> findSkillsByDeveloperId(int developerId){
        
        EntityManager em = emf.createEntityManager();
        List<Skills> skills = null; 
        try{

            skills = em.createNamedQuery("Skills.findSkillsByDeveloperId")
                       .setParameter("developer_id",developerId)
                       .getResultList();

        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return skills;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public List<Skills> findSkillsById(int id){

        EntityManager em = emf.createEntityManager();
        
        List<Skills> skills = null; 
        
        try{
            skills = em.createNamedQuery("Skills.findSkillsById")
                 .setParameter("skill_id",id)
                 .getResultList();
         }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return skills;

    }
    
    /**
     *
     * @return
     */
    public List<Skills> findAllSkills(){

        EntityManager em = emf.createEntityManager();
        
        List<Skills> skills = null; 
        
        try{
            skills = em.createNamedQuery("Skills.findAllSkills")
                 .getResultList();
         }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

        return skills;

    }
    
    /**
     *
     * @param categoryId
     * @param votesGt
     * @param limit
     * @return
     */
    public List<Skills> findAllSkillsByTopFilters(int categoryId, int votesGt, int limit){
        EntityManager em = emf.createEntityManager();
        
        List<Skills> skills = null;
        
        try{
            skills = em.createNamedQuery("Skills.findAllSkillsByTopFilters")
                    .setParameter("category_id", categoryId)
                    .setParameter("votes_gt", votesGt)
                    .setParameter("limit", limit)
                    .getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        
        return skills;
    }

    /**
     *
     * @param universityId
     * @return
     */
    public List<Skills> findPopularLanguagesByUniversityId(int universityId) {
        EntityManager em = emf.createEntityManager();
        
        List<Skills> skills = null;
        
        try{
            skills = em.createNamedQuery("Skills.findPopularLanguagesByUniversityId")
                    .setParameter("university_id",universityId)
                    .getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if (em != null) {
                em.close();
            }
        }
        return skills;
    }

    /**
     *
     * @param universityId
     * @return
     */
    public List<Skills> findPopularSkillsByUniversityId(int universityId) {
        EntityManager em = emf.createEntityManager();
        
        List<Skills> skills = null;
        
        try{
            skills = em.createNamedQuery("Skills.findPopularSkillsByUniversityId")
                    .setParameter("university_id",universityId)
                    .getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            if (em != null) {
                em.close();
            }
        }
        return skills;
    }

}