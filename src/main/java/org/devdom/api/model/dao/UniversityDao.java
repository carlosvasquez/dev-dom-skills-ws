package org.devdom.api.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.devdom.api.model.dto.MasterUniversity;
import org.devdom.api.model.dto.Pagination;
import org.devdom.api.model.dto.University;

/**
 *
 * @author Carlos Vasquez Polanco
 */
public class UniversityDao {
    
    private final MasterUniversity masterUniversity = new MasterUniversity();
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    private final int ROWS_PER_PAGE = 10;
    private int from = 0;
    private int to = 0;
    private int rowCount = 0;
    private int currentPage = 1;
    
    /**
     *
     */
    public UniversityDao(){    }
    
    /**
     *
     * @param universityId
     * @param acceptHeader
     * @param path
     * @return
     * @throws java.lang.Exception
     */
    public List<University> getUniversityById(int universityId,String acceptHeader, String path) throws Exception{
        return findUniversityById(universityId);
    }

    /**
     *
     * @param acceptHeader
     * @param path
     * @return
     * @throws java.lang.Exception
     */
    public MasterUniversity getAllUniversities(String acceptHeader, String path) throws Exception{
        
        return getAllUniversities(acceptHeader, path, 1);
    }

    /**
     *
     * @param acceptHeader
     * @param path
     * @param page
     * @return
     * @throws java.lang.Exception
     */
    public MasterUniversity getAllUniversities(String acceptHeader, String path, int page) throws Exception{
        currentPage = page;
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);

        List<University> universities = findAllUniversities();
        rowCount = universities.size();

        to = (to>rowCount)?rowCount:to;

        universities = universities.subList(from,to); 

        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();

        masterUniversity.setPagination(pagination);
        masterUniversity.setUniversity(universities);

        return masterUniversity;
    }
    
    /**
     *
     * @return
     * @throws java.lang.Exception
     */
    public List<University> findAllUniversities() throws Exception{

        EntityManager em = emf.createEntityManager();
        List<University> universities = null; 
        try{
            universities = em.createNamedQuery("University.findAllUniversities")
                 .getResultList();
         } finally {
            if (em != null) {
                em.close();
            }
        }
        return universities;
    }
    
    /**
     *
     * @param universityId
     * @return
     * @throws java.lang.Exception
     */
    public List<University> findUniversityById(int universityId) throws Exception{
        EntityManager em = emf.createEntityManager();
        List<University> university = null; 
        try{
            university = em.createNamedQuery("University.findUniversityById")
                    .setParameter("university_id",universityId)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return university;
    }
    
    /**
     *
     * @param developerId
     * @return
     * @throws java.lang.Exception
     */
    public List<University> findUniversitiesByDeveloperId(long developerId) throws Exception{
        EntityManager em = emf.createEntityManager();
        List<University> university = null;
        try{
            university = em.createNamedQuery("University.findUniversityByDeveloperId")
                    .setParameter("developer_id",developerId)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return university;
    }
    
    /**
     *
     * @param name
     * @return
     * @throws Exception
     */
    public List<University> findUniversitiesByTypedName(String name) throws Exception{
        EntityManager em = emf.createEntityManager();
        List<University> universities = null;
        try{
            universities = em.createNamedQuery("University.search_developers_university")
                    .setParameter("name",name)
                    .getResultList();
        } finally{
            if(em != null){
                em.close();
            }
        }
        return universities;
    }
}
