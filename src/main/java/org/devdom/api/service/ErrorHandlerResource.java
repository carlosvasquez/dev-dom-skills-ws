package org.devdom.api.service;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Carlos Vásquez Polanco
 */
@Path("/error")
public class ErrorHandlerResource{

    /**
     *
     * @param acceptHeader
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/404")
    public Response index(@HeaderParam("Accept") String acceptHeader,
                                                 @Context UriInfo uri){

        return Response.status(Status.BAD_REQUEST)
                       .entity("pagina no encontrada!")
                       .type(MediaType.TEXT_PLAIN)
                       .build();

    }
    
    /**
     *
     * @param acceptHeader
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/500/IllegalArgument")
    public Response IllegalArgument(@HeaderParam("Accept") String acceptHeader,
                                                 @Context UriInfo uri){

        return Response.status(Status.BAD_REQUEST)
                       .entity("argumento no permitido!")
                       .type(MediaType.TEXT_PLAIN)
                       .build();

    }
    
    /**
     *
     * @param acceptHeader
     * @param uri
     * @return
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("/500/PersistenceUnitLoading")
    public Response PersistenceUnitLoading(@HeaderParam("Accept") String acceptHeader,
                                                 @Context UriInfo uri){

        return Response.status(Status.BAD_REQUEST)
                       .entity("no pudo ser cargado el archivo de persistencia. Contacte al administrador :) ")
                       .type(MediaType.TEXT_PLAIN)
                       .build();

    }
    
}