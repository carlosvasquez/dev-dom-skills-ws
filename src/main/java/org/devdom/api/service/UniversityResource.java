package org.devdom.api.service;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.devdom.api.model.dao.CategoryDao;
import org.devdom.api.model.dao.UniversityDao;
import org.devdom.api.model.dto.MasterUniversity;
import org.devdom.api.model.dto.University;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@Path("/university")
public class UniversityResource {
    
    private final CategoryDao categoryDao = new CategoryDao();
    private final UniversityDao universityDao = new UniversityDao();
    
    /**
     *
     * @param acceptHeader
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public MasterUniversity findAllUniversity(@HeaderParam("Accept") String acceptHeader,
                                              @Context UriInfo uri){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return universityDao.getAllUniversities(acceptHeader, path);

    }
    
    /**
     *
     * @param acceptHeader
     * @param page
     * @param uri
     * @return
     */
    @GET
    @Path("page/{page}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public MasterUniversity findAllUniversityAndPage(@HeaderParam("Accept") String acceptHeader,
                                                     @PathParam("page") int page,
                                                     @Context UriInfo uri){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return universityDao.getAllUniversities(acceptHeader, path, page);

    }
    
    /**
     *
     * @param acceptHeader
     * @param id
     * @param uri
     * @return
     */
    @GET
    @Path("id/{id}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<University> findUniversityById(@HeaderParam("Accept") String acceptHeader,
                                               @PathParam("id") int id,
                                               @Context UriInfo uri){

        String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return universityDao.getUniversityById(id, acceptHeader, path);

    }
    
}
