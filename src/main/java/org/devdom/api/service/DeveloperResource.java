package org.devdom.api.service;

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
import org.devdom.api.model.dao.DeveloperDao;
import org.devdom.api.model.dto.MasterDeveloper;

/**
 *
 * @author Carlos Vasquez Polanco
 */
@Path("/developer")
public class DeveloperResource {
    
    private final CategoryDao categoryDao = new CategoryDao();
    private final DeveloperDao developerDao = new DeveloperDao();
    
    /**
     *
     * @param acceptHeader
     * @param uri
     * @return
     * @throws java.lang.Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public MasterDeveloper index(@HeaderParam("Accept") String acceptHeader,
                                 @Context UriInfo uri) throws Exception{

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return developerDao.getAllDevelopers(acceptHeader, path);

    }
    
    /**
     *
     * @param id
     * @param page
     * @param acceptHeader
     * @param uri
     * @return
     * @throws java.lang.Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("page/{page}")
    public MasterDeveloper findAllDeveloperByPage(@PathParam("id") int id,
                                                 @DefaultValue("1") @PathParam("page") int page,
                                                 @HeaderParam("Accept") String acceptHeader,
                                                 @Context UriInfo uri
                                            ) throws Exception{
        
        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return developerDao.getAllDevelopers(acceptHeader, path, page);
        
    }
    
    /**
     *
     * @param skillID
     * @param acceptHeader
     * @param uri
     * @return
     * @throws java.lang.Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("by/skill/id/{id}")
    public MasterDeveloper developersBySkillID(@PathParam("id") int skillID,
                                                 @HeaderParam("Accept") String acceptHeader,
                                                 @Context UriInfo uri
                                            ) throws Exception{

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return developerDao.getMasterDeveloperBySkillId(skillID, acceptHeader, path);

    }
    
    /**
     *
     * @param skillID
     * @param page
     * @param acceptHeader
     * @param uri
     * @return
     * @throws java.lang.Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("by/skill/id/{id}/page/{page}")
    public MasterDeveloper developersBySkillIDAndPage(@PathParam("id") int skillID,
                                                  @PathParam("page") @DefaultValue("1") int page,
                                                 @HeaderParam("Accept") String acceptHeader,
                                                 @Context UriInfo uri
                                            ) throws Exception{

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return developerDao.getMasterDeveloperBySkillId(skillID, acceptHeader, path,page);
    }
    
    /**
     *
     * @param id
     * @param acceptHeader
     * @param uri
     * @return
     * @throws java.lang.Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("id/{id}")
    public MasterDeveloper developersByID(@PathParam("id") int id,
                                                 @HeaderParam("Accept") String acceptHeader,
                                                 @Context UriInfo uri
                                            ) throws Exception{

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return developerDao.getDeveloperById(id, acceptHeader, path);

    }
    
    /**
     *
     * @param id
     * @param acceptHeader
     * @param page
     * @param uri
     * @return
     * @throws java.lang.Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("id/{id}/page/{page}")
    public MasterDeveloper developersByIDAndPage(@PathParam("id") int id,
                                                 @HeaderParam("Accept") String acceptHeader,
                                                 @DefaultValue("1") @PathParam("page") int page,
                                                 @Context UriInfo uri
                                            ) throws Exception{

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return developerDao.getDeveloperById(id, acceptHeader, path,page);

    }
    
    /**
     *
     * @param acceptHeader
     * @param uri
     * @param firstName
     * @param lastName
     * @param sort
     * @param limit
     * @return
     * @throws java.lang.Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("where")
    public MasterDeveloper allDevelopersByFilters(@HeaderParam("Accept") String acceptHeader,
                                                  @Context UriInfo uri,
                                                  @QueryParam("first_name") String firstName,
                                                  @QueryParam("last_name") String lastName,
                                                  @QueryParam("sort") String sort,
                                                  @QueryParam("limit") int limit
                                                 ) throws Exception{
         String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return developerDao.getAllDevelopersByFilters(firstName, lastName, sort, limit, acceptHeader, path);
        
    }
    
    /**
     *
     * @param acceptHeader
     * @param page
     * @param uri
     * @param firstName
     * @param lastName
     * @param sort
     * @param limit
     * @return
     * @throws java.lang.Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("where/page/{page}")
    public MasterDeveloper allDevelopersByFilters(@HeaderParam("Accept") String acceptHeader,
                                                  @DefaultValue("1") @PathParam("page") int page,
                                                  @Context UriInfo uri,
                                                  @QueryParam("first_name") String firstName,
                                                  @QueryParam("last_name") String lastName,
                                                  @QueryParam("sort") String sort,
                                                  @QueryParam("limit") int limit
                                                 ) throws Exception{
         String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return developerDao.getAllDevelopersByFilters(firstName, lastName, sort, limit, acceptHeader, path, page);
        
    }
    
    /**
     *
     * @param universityId
     * @param acceptHeader
     * @param uri
     * @return
     * @throws java.lang.Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("by/university/id/{universityId}")
    public MasterDeveloper getMasterDeveloperByUniversityId(@PathParam("universityId") int universityId,
                                                            @HeaderParam("Accept") String acceptHeader,
                                                            @Context UriInfo uri) throws Exception{

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return developerDao.getMasterDeveloperByUniversityId(universityId, acceptHeader, path);
        
    }
    
    /**
     *
     * @param universityId
     * @param acceptHeader
     * @param page
     * @param uri
     * @return
     * @throws java.lang.Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("by/university/id/{universityId}/page/{page}")
    public MasterDeveloper getMasterDeveloperByUniversityIdAndPage(@PathParam("universityId") int universityId,
                                                            @HeaderParam("Accept") String acceptHeader,
                                                            @DefaultValue("1") @PathParam("page") int page,
                                                            @Context UriInfo uri) throws Exception{

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return developerDao.getMasterDeveloperByUniversityId(universityId, acceptHeader, path, page);
        
    }

}
