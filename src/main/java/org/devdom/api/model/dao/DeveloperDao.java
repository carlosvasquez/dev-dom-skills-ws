package org.devdom.api.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.devdom.api.model.dto.Developer;
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

    public DeveloperDao(){  }

    public String getRealPath(String path){
        return (path.lastIndexOf("/")==(path.length()-1))?path.substring(0, path.lastIndexOf("/")):path;
    }
    
    public MasterDeveloper getMasterDeveloperByUniversityId(int universityId, String acceptHeader, String url){
        return getMasterDeveloperByUniversityId(universityId, acceptHeader, url,1);
    }
    
    public MasterDeveloper getMasterDeveloperByUniversityId(int universityId, String acceptHeader, String url, int page){
        
        String path = getRealPath(url);
        currentPage = page;

        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);

        UniversityDao universityDao = new UniversityDao();
        List<University> university = universityDao.findUniversityById(universityId);
        List<Developer> developers = findDevelopersByUniversityId(universityId);
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
    
    public MasterDeveloper getMasterDeveloperBySkillId(int skillID,String acceptHeader, String url){

        return getMasterDeveloperBySkillId(skillID,acceptHeader,url,1);
        
    }

    public MasterDeveloper getMasterDeveloperBySkillId(int skillID, String acceptHeader, String url, int page) {
        
        String path = getRealPath(url);
        currentPage = page;
        
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        
        List<Developer> developers = findDevelopersBySkillId(skillID);
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
    
    public MasterDeveloper getAllDevelopers(String acceptHeader, String url){
        return getAllDevelopers(acceptHeader, url, 1);
    }
    
    public MasterDeveloper getAllDevelopers(String acceptHeader, String url, int page){
    
        String path = getRealPath(url);
        currentPage = page;
        
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        
        List<Developer> developers = findAllDevelopers();
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
            
    public MasterDeveloper getAllDevelopersByFilters(String firstName, String lastName, String sort, int limit, String acceptHeader, String url){
        return getAllDevelopersByFilters(firstName, lastName, sort, limit, acceptHeader, url, 1);
    }
    
    public MasterDeveloper getAllDevelopersByFilters(String firstName, String lastName, String sort, int limit, String acceptHeader, String url, int page) {
        
        String path = getRealPath(url);
        currentPage = page;
        
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        
        List<Developer> developers = findAllDevelopersByFilters(firstName, lastName, sort, limit);
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
    
    public MasterDeveloper getDeveloperById(int id,String acceptHeader, String url){
        return getDeveloperById(id, acceptHeader, url, 1);
    }
    
    public MasterDeveloper getDeveloperById(int id,String acceptHeader, String url, int page){
        
        String path = getRealPath(url);
        currentPage = page;
        
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        UniversityDao universityDao = new UniversityDao();
        List<University> university = universityDao.findUniversityByDeveloperId(id);
        List<Developer> developers = findDeveloperById(id);
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
    
    private List<Developer> findDevelopersBySkillId(int skillID){
        EntityManager em = emf.createEntityManager();
        try{
            return (List<Developer>) em.createNamedQuery("Developer.findDevelopersBySkillId")
                    .setParameter("skill_id", skillID)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Developer> findDeveloperById(int id){
        EntityManager em = emf.createEntityManager();
        try{
            return (List<Developer>) em.createNamedQuery("Developer.findDeveloperById")
                    .setParameter("id", id)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Developer> findAllDevelopers(){
        EntityManager em = emf.createEntityManager();
        try{
            return (List<Developer>) em.createNamedQuery("Developer.findAllDevelopers")
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Developer> findAllDevelopersByFilters(String firstName, String lastName, String sort, int limit){
        EntityManager em = emf.createEntityManager();
        try{
            return (List<Developer>) em.createNamedQuery("Developer.findAllDevelopersByFilters")
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
    
    public List<Developer> findDevelopersByUniversityId(int universityId){
        EntityManager em = emf.createEntityManager();
        try{
            return (List<Developer>) em.createNamedQuery("Developer.findDevelopersByUniversityId")
                    .setParameter("university_id", universityId)
                    .getResultList();
        }finally{
            if (em != null) {
                em.close();
            }
        }
    }

}
