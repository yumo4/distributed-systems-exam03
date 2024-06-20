package de.fhws.fiw.fds.ex03.server.api.services;


import de.fhws.fiw.fds.ex03.server.api.queries.QueryByModuleName;
import de.fhws.fiw.fds.ex03.server.api.states.partneruniversities_modules.*;
import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.Exceptions.SuttonWebAppException;
import de.fhws.fiw.fds.sutton.server.api.services.AbstractJerseyService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import de.fhws.fiw.fds.ex03.server.api.models.Module;
import de.fhws.fiw.fds.ex03.server.api.states.partneruniversities_modules.*;



//@Path("modules")
@Path("partneruniversities/{id}/modules")
public class ModuleJerseyService extends AbstractJerseyService {
    public ModuleJerseyService() { super();}
//    @GET
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response getAllPartnerUniversityModules() {
//        try {
//            return new GetAllPartnerUniversityModules( this.serviceContext, new GetAllPartnerUniversityModules().AllLocations<>()).execute();
//        } catch (SuttonWebAppException e) {
//            throw new WebApplicationException(Response.status(e.getStatus().getCode())
//                    .entity(e.getExceptionMessage()).build());
//        }
//    }
//    @GET
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response getAllPartnerUniversitiesModules(
//            @PathParam("id") final long primaryId,
//    //            @PathParam("partnerUniversityId") final long partnerUniversityId,
//            @DefaultValue("") @QueryParam("modulename") final String moduleName,
//    //            @DefaultValue("") @QueryParam("country") final String country,
//    //            @DefaultValue("") @QueryParam("contactperson") final String contactPerson,
//    //            @DefaultValue("") @QueryParam("deptartmentname") final String departmentName,
//    //            @DefaultValue("") @QueryParam("deptartmenturl") final String departmentURL,
//            @DefaultValue("0") @QueryParam("offset") int offset,
//            @DefaultValue("20") @QueryParam("size") int size) {
//        try {
//            return new GetAllPartnerUniversityModules(
//                    this.serviceContext,
//                    new QueryByModuleName<>(moduleName, offset, size)
////    //                    new QueryByName<>(name, offset, size),
////    //                    new QueryByCountry<>(country, offset, size),
////    //                    new QueryByContactPerson<>(contactPerson, offset, size),
////    //                    new QueryByDepartmentURL<>(departmentURL, offset, size)
////    //                    new QueryByDepartmentName<>(departmentName, offset, size),
//            ).execute();
//        } catch (SuttonWebAppException e) {
//            throw new WebApplicationException(e.getExceptionMessage(), e.getStatus().getCode());
//        }
//    }
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllPartnerUniversityModules(@PathParam("id") long partnerUniversityId,
               @DefaultValue("") @QueryParam("modulename") final String moduleName,
               @DefaultValue("0") @QueryParam("offset") int offset,
               @DefaultValue("20") @QueryParam("size") int size) {
        try {
            return new GetAllPartnerUniversityModules(
                    this.serviceContext,
                    partnerUniversityId,
                    new QueryByModuleName<>(partnerUniversityId,moduleName, offset, size)
            ).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

//    @GET
////    @Path("{id: \\d+}")
//    @Path("{moduleid: \\d+}")
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response getSinglepartnerUniversityModule(@PathParam("id") long partneruniversityId, @PathParam("moduleid") final long moduleId) {
//        try {
//            return new GetSinglePartnerUniversityModule( this.serviceContext, partnerUniversityId, moduleId ).execute( );
//        } catch (SuttonWebAppException e) {
//            throw new WebApplicationException(Response.status(e.getStatus().getCode())
//                    .entity(e.getExceptionMessage()).build());
//        }
//    }
    @Path("{moduleId: \\d+}")
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getSinglepartnerUniversityModule(@PathParam("id") long partnerUniversityId,
                                                     @PathParam("moduleId") long moduleId) {
        try {
            return new GetSinglePartnerUniversityModule(this.serviceContext, partnerUniversityId, moduleId).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

//    @POST
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response createSinglePartnerUniversityModule( ,final Module moduleModel) {
//        try {
//            return new PostNewPartnerUniversityModule( this.serviceContext, moduleModel ).execute( );
//        } catch (SuttonWebAppException e) {
//            throw new WebApplicationException(Response.status(e.getStatus().getCode())
//                    .entity(e.getExceptionMessage()).build());
//        }
//    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createSinglePartnerUniversityModule(@PathParam("id") long partnerUniversityId,
                                                     final Module moduleModel) {
        try {
            return new PostNewPartnerUniversityModule(this.serviceContext, partnerUniversityId, moduleModel).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }
//
//    @PUT
//    @Path("{id: \\d+}")
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response updateSinglePartnerUnviersityModule(@PathParam("id") final long id, final Module moduleModel) {
//        try {
//            return new PutSinglePartnerUniversityModule( this.serviceContext, id, moduleModel ).execute( );
//        } catch (SuttonWebAppException e) {
//            throw new WebApplicationException(Response.status(e.getStatus().getCode())
//                    .entity(e.getExceptionMessage()).build());
//        }
//    }

    @PUT
    @Path("{moduleId: \\d+}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateSinglePartnerUniversityModule(@PathParam("id") long partnerUniversityId,
                                                     @PathParam("moduleId") long moduleId, final Module moduleModel) {
        try {
            return new PutSinglePartnerUniversityModule(this.serviceContext, partnerUniversityId, moduleId, moduleModel).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }
//
//    @DELETE
//    @Path("{id: \\d+}")
//    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//    public Response deleteSinglePartnerUniversityModule(@PathParam("id") final long id) {
//        try {
//            return new DeleteSinglePartnerUniversityModule(this.serviceContext, id).execute( );
//        } catch (SuttonWebAppException e) {
//            throw new WebApplicationException(Response.status(e.getStatus().getCode())
//                    .entity(e.getExceptionMessage()).build());
//        }
//    }

    @DELETE
    @Path("{moduleId: \\d+}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deleteSinglePartnerUniversityModule(@PathParam("id") long partnerUniversityId,
                                                     @PathParam("moduleId") long moduleId) {
        try {
            return new DeleteSinglePartnerUniversityModule(this.serviceContext, partnerUniversityId, moduleId).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }
}
