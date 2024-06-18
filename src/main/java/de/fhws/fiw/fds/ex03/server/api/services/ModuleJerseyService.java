//package de.fhws.fiw.fds.ex03.server.api.services;
//
//
//import de.fhws.fiw.fds.ex03.server.api.states.partneruniversities_modules.*;
//import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.Exceptions.SuttonWebAppException;
//import de.fhws.fiw.fds.sutton.server.api.services.AbstractJerseyService;
//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;
//
//import static jdk.javadoc.internal.tool.Main.execute;
//
//@Path("modules")
//public class ModuleJerseyServeice extends AbstractJerseyService {
//    @GET
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response getAllLocations() {
//        try {
//            return new GetAllPartnerUniversityModules( this.serviceContext, new GetAllPartnerUniversityModules().AllPartnerUniversityModules<>( ) ).execute( );
//        } catch (SuttonWebAppException e) {
//            throw new WebApplicationException(Response.status(e.getStatus().getCode())
//                    .entity(e.getExceptionMessage()).build());
//        }
//    }
//
//    @GET
//    @Path("{id: \\d+}")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response getSinglePartnerUniversityModule(@PathParam("id") final long id) {
//        try {
//            return new GetSinglePartnerUniversityModule( this.serviceContext, id ).execute( );
//        } catch (SuttonWebAppException e) {
//            throw new WebApplicationException(Response.status(e.getStatus().getCode())
//                    .entity(e.getExceptionMessage()).build());
//        }
//    }
//
//    @POST
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response createSinglePartnerUniversityModule(final Module puModuleModel) {
//        try {
//            return new PostNewPartnerUniversityModule( this.serviceContext, puModuleModel ).execute( );
//        } catch (SuttonWebAppException e) {
//            throw new WebApplicationException(Response.status(e.getStatus().getCode())
//                    .entity(e.getExceptionMessage()).build());
//        }
//    }
//
//    @PUT
//    @Path("{id: \\d+}")
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response updateSinglePartnerUniversityModule(@PathParam("id") final long id, final Module puModuleModel) {
//        try {
//            return new PutSinglePartnerUniversityModule( this.serviceContext, id, puModuleModel ).execute( );
//        } catch (SuttonWebAppException e) {
//            throw new WebApplicationException(Response.status(e.getStatus().getCode())
//                    .entity(e.getExceptionMessage()).build());
//        }
//    }
//
//    @DELETE
//    @Path("{id: \\d+}")
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response deleteSinglePartnerUniversityModule(@PathParam("id") final long id) {
//        try {
//            return new DeleteSinglePartnerUniversityModule( this.serviceContext, id ).execute( );
//        } catch (SuttonWebAppException e) {
//            throw new WebApplicationException(Response.status(e.getStatus().getCode())
//                    .entity(e.getExceptionMessage()).build());
//        }
//    }
//}
