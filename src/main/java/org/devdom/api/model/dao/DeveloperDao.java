package org.devdom.api.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.devdom.api.model.dto.DeveloperInformation;
import org.devdom.api.model.dto.DeveloperStats;
import org.devdom.api.model.dto.MasterDeveloper;
import org.devdom.api.model.dto.Pagination;
import org.devdom.api.model.dto.Skills;
import org.devdom.api.model.dto.University;
import org.devdom.api.util.IPagination;

/**
 *
 * @author Carlos Vásquez Polanco
 */
public class DeveloperDao {
    
    private final int ROWS_PER_PAGE = IPagination.ROWS_PER_PAGE;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    private final MasterDeveloper masterDeveloper = new MasterDeveloper();
    private final SkillsDao skillDao = new SkillsDao();
    private int currentPage = 1;
    private int from = 0;
    private int to = 0;
    private int rowCount = 0;

    /**
     *
     */
    public DeveloperDao(){  }

    /**
     *
     * @param path
     * @return
     */
    public String getRealPath(String path){
        return (path.lastIndexOf("/")==(path.length()-1))?path.substring(0, path.lastIndexOf("/")):path;
    }
    
    /**
     *
     * @param universityId
     * @param acceptHeader
     * @param url
     * @return
     */
    public MasterDeveloper getMasterDeveloperByUniversityId(int universityId, String acceptHeader, String url) throws Exception{
        return getMasterDeveloperByUniversityId(universityId, acceptHeader, url,1);
    }
    
    /**
     *
     * @param universityId
     * @param acceptHeader
     * @param url
     * @param page
     * @return
     */
    public MasterDeveloper getMasterDeveloperByUniversityId(int universityId, String acceptHeader, String url, int page) throws Exception{
        
        String path = getRealPath(url);
        currentPage = page;

        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);

        UniversityDao universityDao = new UniversityDao();
        List<University> university = universityDao.findUniversityById(universityId);
        List<DeveloperInformation> developers = findDevelopersByUniversityId(universityId);
        rowCount = developers.size();

        to = (to>rowCount)?rowCount:to;

        developers = developers.subList(from, to);

        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        masterDeveloper.setUniversity(university);
        masterDeveloper.setDevelopers(developers);
        masterDeveloper.setPagination(pagination);

        return masterDeveloper;
    }
    
    /**
     *
     * @param skillID
     * @param acceptHeader
     * @param url
     * @return
     */
    public MasterDeveloper getMasterDeveloperBySkillId(int skillID,String acceptHeader, String url){

        return getMasterDeveloperBySkillId(skillID,acceptHeader,url,1);
        
    }

    /**
     *
     * @param skillID
     * @param acceptHeader
     * @param url
     * @param page
     * @return
     */
    public MasterDeveloper getMasterDeveloperBySkillId(int skillID, String acceptHeader, String url, int page) {
        
        String path = getRealPath(url);
        currentPage = page;
        
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        
        List<DeveloperInformation> developers = findDevelopersBySkillId(skillID);
        List<Skills> skills = skillDao.findSkillsById(skillID);
        rowCount = developers.size();

        to = (to>rowCount)?rowCount:to;

        developers = developers.subList(from, to);

        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        masterDeveloper.setDevelopers(developers);
        masterDeveloper.setSkills(skills);
        masterDeveloper.setPagination(pagination);

        return masterDeveloper;
    }
    
    /**
     *
     * @param acceptHeader
     * @param url
     * @return
     */
    public MasterDeveloper getAllDevelopers(String acceptHeader, String url){
        return getAllDevelopers(acceptHeader, url, 1);
    }
    
    /**
     *
     * @param acceptHeader
     * @param url
     * @param page
     * @return
     */
    public MasterDeveloper getAllDevelopers(String acceptHeader, String url, int page){
    
        String path = getRealPath(url);
        currentPage = page;
        
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        
        List<DeveloperInformation> developers = findAllDevelopers();
        rowCount = developers.size();

        to = (to>rowCount)?rowCount:to;

        developers = developers.subList(from, to);

        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        masterDeveloper.setDevelopers(developers);
        masterDeveloper.setPagination(pagination);

        return masterDeveloper;
    }
            
    /**
     *
     * @param firstName
     * @param lastName
     * @param sort
     * @param limit
     * @param acceptHeader
     * @param url
     * @return
     */
    public MasterDeveloper getAllDevelopersByFilters(String firstName, String lastName, String sort, 
                                                     int limit, String acceptHeader, String url) throws Exception{
        return getAllDevelopersByFilters(firstName, lastName, sort, limit, acceptHeader, url, 1);
    }
    
    /**
     *
     * @param firstName
     * @param lastName
     * @param sort
     * @param limit
     * @param acceptHeader
     * @param url
     * @param page
     * @return
     */
    public MasterDeveloper getAllDevelopersByFilters(String firstName, String lastName, String sort, int limit, String acceptHeader, String url, int page) throws Exception {
        
        String path = getRealPath(url);
        currentPage = page;
        
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        
        List<DeveloperInformation> developers = findAllDevelopersByFilters(firstName, lastName, sort, limit);
        rowCount = developers.size();

        to = (to>rowCount)?rowCount:to;

        developers = developers.subList(from, to);

        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        masterDeveloper.setDevelopers(developers);
        masterDeveloper.setPagination(pagination);

        return masterDeveloper;
    }
    
    /**
     *
     * @param id
     * @param acceptHeader
     * @param url
     * @return
     */
    public MasterDeveloper getDeveloperById(int id,String acceptHeader, String url){
        return getDeveloperById(id, acceptHeader, url, 1);
    }
    
    /**
     *
     * @param id
     * @param acceptHeader
     * @param url
     * @param page
     * @return
     */
    public MasterDeveloper getDeveloperById(int id,String acceptHeader, String url, int page){
        
        String path = getRealPath(url);
        currentPage = page;
        
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        UniversityDao universityDao = new UniversityDao();
        List<University> university = universityDao.findUniversityByDeveloperId(id);
        List<DeveloperInformation> developers = findDeveloperById(id);
        List<Skills> skills = skillDao.findSkillsByDeveloperId(id);
        rowCount = skills.size();

        to = (to>rowCount)?rowCount:to;

        skills = skills.subList(from, to);

        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        
        masterDeveloper.setUniversity(university);
        masterDeveloper.setDevelopers(developers);
        masterDeveloper.setSkills(skills);
        masterDeveloper.setPagination(pagination);

        return masterDeveloper;
    }
    
    private List<DeveloperInformation> findDevelopersBySkillId(int skillID){
        EntityManager em = emf.createEntityManager();
        try{
            return (List<DeveloperInformation>) em.createNamedQuery("Developer.findDevelopersBySkillId")
                    .setParameter("skill_id", skillID)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     *
     * @param id
     * @return
     */
    public List<DeveloperInformation> findDeveloperById(int id){
        EntityManager em = emf.createEntityManager();
        try{
            return (List<DeveloperInformation>) em.createNamedQuery("Developer.findDeveloperById")
                    .setParameter("id", id)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    /**
     *
     * @return
     */
    public List<DeveloperInformation> findAllDevelopers(){
        EntityManager em = emf.createEntityManager();
        try{
            return (List<DeveloperInformation>) em.createNamedQuery("Developer.findAllDevelopers")
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    /**
     *
     * @param firstName
     * @param lastName
     * @param sort
     * @param limit
     * @return
     */
    public List<DeveloperInformation> findAllDevelopersByFilters(String firstName, String lastName, String sort, int limit) throws Exception{
        EntityManager em = emf.createEntityManager();
        try{
            return (List<DeveloperInformation>) em.createNamedQuery("Developer.findAllDevelopersByFilters")
                    .setParameter("first_name",firstName)
                    .setParameter("last_name",lastName)
                    .setParameter("sort",sort)
                    .setParameter("limit",limit)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    /**
     *
     * @param universityId
     * @return
     */
    public List<DeveloperInformation> findDevelopersByUniversityId(int universityId) throws Exception{
        EntityManager em = emf.createEntityManager();
        try{
            return (List<DeveloperInformation>) em.createNamedQuery("Developer.findDevelopersByUniversityId")
                    .setParameter("university_id", universityId)
                    .getResultList();
        }finally{
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<DeveloperStats> findDevelopersBySearchProfile(String fullname) throws Exception{
        EntityManager em = emf.createEntityManager();
        try{
            return (List<DeveloperStats>) em.createNamedQuery("Developer.search_developers_profile")
                    .setParameter("fullname",fullname)
                    .getResultList();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    public List<DeveloperStats> findDevelopersBySearchTop20(String fullname) throws Exception {
        EntityManager em = emf.createEntityManager();
        try{
            return (List<DeveloperStats>) em.createNamedQuery("Developer.search_top20")
                    .setParameter("fullname",fullname)
                    .getResultList();
        }finally{
            if(em != null){
                em.close();
            }
        }
    }
}
