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
import org.devdom.api.model.dao.DeveloperDao;
import org.devdom.api.model.dao.GroupDao;
import org.devdom.api.model.dao.SkillsDao;
import org.devdom.api.model.dao.UniversityDao;
import org.devdom.api.model.dao.WorkDao;
import org.devdom.api.model.dto.DeveloperStats;
import org.devdom.api.model.dto.GroupInformation;
import org.devdom.api.model.dto.Skills;
import org.devdom.api.model.dto.University;
import org.devdom.api.model.dto.Work;

/**
 *
 * @author Carlos Vasquez Polanco
 */
@Path("/find")
public class FindResource {
    
    private final DeveloperDao developerDao = new DeveloperDao();
    private final GroupDao groupDao = new GroupDao();
    private final UniversityDao universityDao = new UniversityDao();
    private final WorkDao workDao = new WorkDao();
    private final SkillsDao skillsDao = new SkillsDao();
    
    /**
     *
     * @param acceptHeader
     * @param uri
     * @param q
     * @return
     * @throws java.lang.Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("top20")
    public List<DeveloperStats> findDevelopersTop20ByName(@HeaderParam("Accept") String acceptHeader,
                                                  @Context UriInfo uri,
                                                  @QueryParam("q") String q
                                                 ) throws Exception{

        return developerDao.findDevelopersBySearchTop20(q);
    }
    
    /**
     *
     * @param acceptHeader
     * @param uri
     * @param fullname
     * @return
     * @throws java.lang.Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("profile")
    public List<DeveloperStats> findDevelopersProfileByProfile(@HeaderParam("Accept") String acceptHeader,
                                                  @Context UriInfo uri,
                                                  @QueryParam("q") String fullname
                                                 ) throws Exception{

        return developerDao.findDevelopersBySearchProfile(fullname);
    }
    
    /**
     *
     * @param acceptHeader
     * @param uri
     * @param q
     * @return
     * @throws Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("group")
    public List<GroupInformation> findGroupInformationByGroupName(@HeaderParam("Accept") String acceptHeader,
                                                  @Context UriInfo uri,
                                                  @QueryParam("q") String q
                                                 ) throws Exception{
        return groupDao.findGroupsByTypedName(q);
    }
    
    /**
     *
     * @param acceptHeader
     * @param uri
     * @param q
     * @return
     * @throws Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("university")
    public List<University> findUniversitiesInformationByTypedName(@HeaderParam("Accept") String acceptHeader,
                                                  @Context UriInfo uri,
                                                  @QueryParam("q") String q
                                                 ) throws Exception{
        return universityDao.findUniversitiesByTypedName(q);
    }
    
    /**
     *
     * @param acceptHeader
     * @param uri
     * @param q
     * @return
     * @throws Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("work")
    public List<Work> findWorksInformationByTypedName(@HeaderParam("Accept") String acceptHeader,
                                                  @Context UriInfo uri,
                                                  @QueryParam("q") String q
                                                 ) throws Exception{
        return workDao.findWorksByTypedName(q);
    }

    /**
     *
     * @param acceptHeader
     * @param uri
     * @param q
     * @return
     * @throws Exception
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path("skills")
    public List<Skills> findSkillsByTypedName(@HeaderParam("Accept") String acceptHeader,
                                                  @Context UriInfo uri,
                                                  @QueryParam("q") String q
                                                 ) throws Exception{
        return skillsDao.findSkillsByTypedName(q);
    }

}
