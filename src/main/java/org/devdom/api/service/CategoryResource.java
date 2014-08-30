package org.devdom.api.service;

import java.util.List;
import org.devdom.api.model.dao.CategoryDao;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.devdom.api.model.dto.Category;
import org.devdom.api.model.dto.MasterCategory;

/** 
 * 
 * @author      Carlos Vásquez Polanco
 */
@Path("/category")
public class CategoryResource {

    private final CategoryDao categoryDao = new CategoryDao();
    private MasterCategory masterCategory = new MasterCategory();
    
    /**
     *
     * @param acceptHeader
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public MasterCategory index(@HeaderParam("Accept") String acceptHeader,
                                @Context UriInfo uri){

        String url = uri.getAbsolutePath().toString();

        return categoryDao.getMasterCategorySortById("desc",acceptHeader,url);

    }
    
    /**
     *
     * @param page
     * @param acceptHeader
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/page/{page}")
    public MasterCategory findCategoriesByPage(@PathParam("page") @DefaultValue("1") int page,
                                               @HeaderParam("Accept") String acceptHeader,
                                               @Context UriInfo uri){

        String url = uri.getAbsolutePath().toString();

        return categoryDao.getMasterCategorySortById("desc",acceptHeader,url,page);
    }

    /**
     *
     * @param field
     * @param acceptHeader
     * @param sort
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/sort-by/{field}/{sort}")
    public MasterCategory findCategoriesSortById(@PathParam("field") @DefaultValue("id") String field,
                                                 @HeaderParam("Accept") String acceptHeader,
                                                 @PathParam("sort") @DefaultValue("ASC") String sort,
                                                 @Context UriInfo uri) {
        
        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        if(field.toLowerCase().equals("id")){
            masterCategory = categoryDao.getMasterCategorySortById(sort, acceptHeader, path);
        }else if(field.toLowerCase().equals("name")){
            masterCategory = categoryDao.getMasterCategorySortByName(sort, acceptHeader, path);
        }else{
            masterCategory = categoryDao.getMasterCategorySortByName(sort, acceptHeader, path);
        }

        return masterCategory;

    }
    
    /**
     *
     * @param field
     * @param acceptHeader
     * @param sort
     * @param page
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/sort-by/{field}/{sort}/page/{page}")
    public MasterCategory findCategoriesSortByIdAndPage(@PathParam("field") @DefaultValue("id") String field,
                                                        @HeaderParam("Accept") String acceptHeader,
                                                        @PathParam("sort") @DefaultValue("ASC") String sort,
                                                        @PathParam("page") @DefaultValue("1") int page,
                                                        @Context UriInfo uri) {

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        switch (field.toLowerCase()) {
            case "id":
                masterCategory = categoryDao.getMasterCategorySortById(sort, acceptHeader, path, page);
                break;
            case "name":
                masterCategory = categoryDao.getMasterCategorySortByName(sort, acceptHeader, path, page);
                break;
            default:
                masterCategory = categoryDao.getMasterCategorySortByName(sort, acceptHeader, path, page);
                break;
        }

        return masterCategory;
    }
    
    /**
     *
     * @param categoryId
     * @param acceptHeader
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/id/{category_id}")
    public List<Category> findCategoryById(@PathParam("category_id") @DefaultValue("0") int categoryId,
                                    @HeaderParam("Accept") String acceptHeader,
                                    @Context UriInfo uri){

        return categoryDao.findCategoryById(categoryId);

    }

}