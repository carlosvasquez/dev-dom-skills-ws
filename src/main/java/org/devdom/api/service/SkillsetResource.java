package org.devdom.api.service;

import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.devdom.api.model.dao.CategoryDao;
import org.devdom.api.model.dao.SkillsDao;
import org.devdom.api.model.dto.Skills;
import org.devdom.api.model.dto.MasterSkillset;

/**
 *
 * @author Carlos Vásquez Polanco
 */

@Path("/skill")
public class SkillsetResource {

    private final SkillsDao skillsDao = new SkillsDao();
    private final CategoryDao categoryDao = new CategoryDao();
    
    /**
     *
     * @param acceptHeader
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public MasterSkillset findAllSkills(@HeaderParam("Accept") String acceptHeader,
                                        @Context UriInfo uri
                                        ){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return skillsDao.getAllSkills(acceptHeader, path);

    }
    
    /**
     *
     * @param acceptHeader
     * @param page
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("page/{page}")
    public MasterSkillset findAllSkills(@HeaderParam("Accept") String acceptHeader,
                                        @PathParam("page") int page,
                                        @Context UriInfo uri
                                        ){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return skillsDao.getAllSkills(acceptHeader, path, page);

   }
    
    /**
     *
     * @param id
     * @param acceptHeader
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("by/category/id/{id}")
    public MasterSkillset findSkillsByCategoryId(@PathParam("id") int id,
                                                 @HeaderParam("Accept") String acceptHeader,
                                                 @Context UriInfo uri
                                            ){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return skillsDao.getSkillsByCategoryId(id, acceptHeader, path);

   }

    /**
     *
     * @param id
     * @param page
     * @param acceptHeader
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("by/category/id/{id}/page/{page}")
    public MasterSkillset findSkillsByCategoryIdAndPage(@PathParam("id") int id,
                                                        @PathParam("page") @DefaultValue("1") int page,
                                                        @HeaderParam("Accept") String acceptHeader,
                                                        @Context UriInfo uri){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return skillsDao.getSkillsByCategoryId(id, acceptHeader, path, page);
        
    }
    
    /**
     *
     * @param id
     * @param acceptHeader
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("id/{id}")
    public List<Skills> findSkillsById(@PathParam("id") int id,
                                       @HeaderParam("Accept") String acceptHeader,
                                       @Context UriInfo uri){
        
        String path = uri.getAbsolutePath().toString();
        return skillsDao.findSkillsById(id);

    }
    
    /**
     *
     * @param id
     * @param acceptHeader
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("by/developer/id/{id}")
    public MasterSkillset findSkillsByDeveloperId(@PathParam("id") int id,
                                       @HeaderParam("Accept") String acceptHeader,
                                       @Context UriInfo uri){
        
        String path = uri.getAbsolutePath().toString();
        
        return skillsDao.getSkillsByDeveloperId(id, acceptHeader, path);
        
    }
    
    /**
     *
     * @param id
     * @param page
     * @param acceptHeader
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("by/developer/id/{id}/page/{page}")
    public MasterSkillset findSkillsByDeveloperIdAndPage(@PathParam("id") int id,
                                       @PathParam("page") @DefaultValue("1") int page,
                                       @HeaderParam("Accept") String acceptHeader,
                                       @Context UriInfo uri){
        
        String path = uri.getAbsolutePath().toString();
        
        return skillsDao.getSkillsByDeveloperId(id, acceptHeader, path, page);
        
    }
    
    /**
     *
     * @param categoryId
     * @param votesGt
     * @param limit
     * @param acceptHeader
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("where")
    public MasterSkillset findAllSkillsByTopFilters(@DefaultValue("0") @QueryParam("category_id") int categoryId,
                                                    @DefaultValue("0") @QueryParam("votes_gt") int votesGt,
                                                    @DefaultValue("20") @QueryParam("limit") int limit,
                                                    @HeaderParam("Accept") String acceptHeader,
                                                    @Context UriInfo uri){

        String path = uri.getAbsolutePath().toString();

        return skillsDao.getAllSkillsByTopFilters(categoryId, votesGt, limit, acceptHeader, path);

    }
    
    /**
     *
     * @param categoryId
     * @param votesGt
     * @param limit
     * @param page
     * @param acceptHeader
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("where/page/{page}")
    public MasterSkillset findAllSkillsByTopFiltersAndPage(@DefaultValue("0") @QueryParam("category_id") int categoryId,
                                                    @DefaultValue("0") @QueryParam("votes_gt") int votesGt,
                                                    @DefaultValue("20") @QueryParam("limit") int limit,
                                                    @DefaultValue("1") @PathParam("page") int page,
                                                    @HeaderParam("Accept") String acceptHeader,
                                                    @Context UriInfo uri){

        String path = uri.getAbsolutePath().toString();

        return skillsDao.getAllSkillsByTopFilters(categoryId, votesGt, limit, acceptHeader, path, page);

    }

}
