package org.devdom.api.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.devdom.api.model.dto.Category;
import org.devdom.api.model.dto.MasterCategory;
import org.devdom.api.model.dto.Pagination;
import org.devdom.api.util.IPagination;

/**
 * Clase CategoryDao.
 * 
 * @author      Carlos Vásquez Polanco
 */
public class CategoryDao implements Serializable {

    private final int ROWS_PER_PAGE = IPagination.ROWS_PER_PAGE;
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    private final MasterCategory masterCategory = new MasterCategory();
    private int currentPage = 1;
    private int from = 0;
    private int to = 0;
    
    private int rowCount = 0;
    
    /**
     *
     */
    public CategoryDao(){ }

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
     * @param sort
     * @param acceptHeader
     * @param url
     * @return
     */
    public MasterCategory getMasterCategorySortById(String sort,String acceptHeader, String url){

        return getMasterCategorySortById(sort,acceptHeader,url,1);
        
    }

    /**
     *
     * @param sort
     * @param acceptHeader
     * @param url
     * @param page
     * @return
     */
    public MasterCategory getMasterCategorySortById(String sort, String acceptHeader, String url, int page){
        
        String path = getRealPath(url);
        currentPage = page;
        
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        List<Category> category = findCategoriesSortById("desc");
        rowCount = category.size();

        to = (to>rowCount)?rowCount:to;

        category = category.subList(from, to);

        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        
        masterCategory.setCategory(category);
        masterCategory.setPagination(pagination);

        return masterCategory;
    }
    
    /**
     *
     * @param sort
     * @param acceptHeader
     * @param url
     * @return
     */
    public MasterCategory getMasterCategorySortByName(String sort,String acceptHeader, String url){

        return getMasterCategorySortByName(sort,acceptHeader,url,1);
        
    }
    
    /**
     *
     * @param sort
     * @param acceptHeader
     * @param url
     * @param page
     * @return
     */
    public MasterCategory getMasterCategorySortByName(String sort, String acceptHeader, String url, int page){
        
        String path = getRealPath(url);
        currentPage = page;

        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        List<Category> category = findCategoriesSortById("desc");
        rowCount = category.size();

        to = (to>rowCount)?rowCount:to;

        category = category.subList(from, to);

        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        
        masterCategory.setCategory(category);
        masterCategory.setPagination(pagination);

        return masterCategory;
        
    }

    private List<Category> findCategoriesSortById(String sort){
        EntityManager em = emf.createEntityManager();
        try{
            return (List<Category>) em.createNamedQuery("Category.findCategoriesSortById")
                    .setParameter("sort", sort)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    private List<Category> findCategoriesSortByName(String sort){
        EntityManager em = emf.createEntityManager();
        try{
            return (List<Category>) em.createNamedQuery("Category.findCategoriesSortByName")
                    .setParameter("sort", sort)
                    .getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     *
     * @param name
     * @return
     */
    public List<Category> findCategoriesByName(String name) {
        EntityManager em = emf.createEntityManager();
        try{
            return (List<Category>) em.createNamedQuery("Category.findCategoriesByName")
                    .setParameter("name",name)
                    .getResultList();
        }finally{
            if (em != null) {
                em.close();
            }
        }
    }
    
    /**
     *
     * @param categoryId
     * @param acceptHeader
     * @param path
     * @return
     */
    public MasterCategory getMasterCategoryById(int categoryId, String acceptHeader, String path) {

        return this.getMasterCategoryById(categoryId, acceptHeader, path,1);
    }
    
    /**
     *
     * @param id
     * @param acceptHeader
     * @param path
     * @param page
     * @return
     */
    public MasterCategory getMasterCategoryById(int id, String acceptHeader, String path, int page){
        
        currentPage = page;
        from = (currentPage-1)*ROWS_PER_PAGE;
        to = (from+ROWS_PER_PAGE);
        
        List<Category> category = this.findCategoryById(id);
        
        Pagination pagination = new Pagination();
        pagination.setPositionCurrentPage(currentPage);
        pagination.setRowsPerPages(ROWS_PER_PAGE);
        pagination.setTotalRow(rowCount);
        pagination.setDataType(acceptHeader);
        pagination.setAbsolutePath(path);
        pagination.generate();
        
        masterCategory.setCategory(category);
        masterCategory.setPagination(pagination);
        
        return masterCategory;
    }
            
    /**
     *
     * @param id
     * @return
     */
    public List<Category> findCategoryById(int id){
        EntityManager em = emf.createEntityManager();
        try{
            return (List<Category>) em.createNamedQuery("Category.findCategoryById")
                    .setParameter("category_id", id)
                    .getResultList();
        }finally{
            if (em != null) {
                em.close();
            }
        }
    }

}