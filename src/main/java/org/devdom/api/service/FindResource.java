package org.devdom.api.service;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.devdom.api.model.dao.CategoryDao;
import org.devdom.api.model.dao.DeveloperDao;
import org.devdom.api.model.dto.Developer;

/**
 *
 * @author Carlos Vasquez Polanco
 */
@Path("/find")
public class FindResource {
    
    private final DeveloperDao developerDao = new DeveloperDao();
    private final CategoryDao categoryDao = new CategoryDao();
    /**
     *
     * @param acceptHeader
     * @param uri
     * @param q
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("top20")
    public List<Developer> findDevelopersTop20ByName(@HeaderParam("Accept") String acceptHeader,
                                                  @Context UriInfo uri,
                                                  @QueryParam("q") String q
                                                 ){

        return developerDao.findDevelopersBySearchTop20(q);
    }
    
    /**
     *
     * @param acceptHeader
     * @param uri
     * @param fullname
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("profile")
    public List<Developer> findDevelopersProfileByProfile(@HeaderParam("Accept") String acceptHeader,
                                                  @Context UriInfo uri,
                                                  @QueryParam("q") String fullname
                                                 ){
         String path = categoryDao.getRealPath(uri.getAbsolutePath().toString());

        return developerDao.findDevelopersBySearchProfile(fullname);
    }
    
}
