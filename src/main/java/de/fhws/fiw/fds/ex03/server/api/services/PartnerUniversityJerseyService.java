package de.fhws.fiw.fds.ex03.server.api.services;


import de.fhws.fiw.fds.ex03.server.api.models.Module;
import de.fhws.fiw.fds.ex03.server.api.models.PartnerUniversity;
import de.fhws.fiw.fds.ex03.server.api.queries.QueryByModuleName;
import de.fhws.fiw.fds.ex03.server.api.queries.QueryByName;
import de.fhws.fiw.fds.ex03.server.api.states.partneruniversities.*;
import de.fhws.fiw.fds.ex03.server.api.states.partneruniversities_modules.*;
import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.Exceptions.SuttonWebAppException;
import de.fhws.fiw.fds.sutton.server.api.services.AbstractJerseyService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class PartnerUniversityJerseyService extends AbstractJerseyService {

//    public PersonJerseyService() {
    public PartnerUniversityJerseyService() {
        super();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getAllPartnerUniversities(
//            @PathParam("partnerUniversityId") final long partnerUniversityId,
            @DefaultValue("") @QueryParam("name") final String name,
            @DefaultValue("0") @QueryParam("offset") int offset,
            @DefaultValue("20") @QueryParam("size") int size) {
        try {
            return new GetAllPartnerUniversities(
                    this.serviceContext,
                    new QueryByName<>(name, offset, size)
            ).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(e.getExceptionMessage(), e.getStatus().getCode());
        }
    }

    @GET
    @Path("{id: \\d+}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getSinglePartnerUniversity(@PathParam("id") final long id) {
        try {
            return new GetSinglePartnerUniversity(this.serviceContext, id).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response
                    .status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build()
            );
        }
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response createSinglePartnerUniversity(final PartnerUniversity partnerUniversity) {
        try {
            return new PostNewPartnerUniversity(this.serviceContext, partnerUniversity).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @PUT
    @Path("{id: \\d+}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updateSinglePartnerUniversity(@PathParam("id") final long id, final PartnerUniversity partnerUniversity) {
        try {
            return new PutSinglePartnerUniversity(this.serviceContext, id, partnerUniversity).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @DELETE
    @Path("{id: \\d+}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response deleteSinglePartnerUniversity(@PathParam("id") final long id) {
        try {
            return new DeleteSinglePartnerUniversity(this.serviceContext, id).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @GET
    @Path("{partnerUniversityId: \\d+}/modules")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getPartnerUniversityModules(@PathParam("partnerUniversityId") final long partnerUniversityId,
                                         @DefaultValue("") @QueryParam("moduleName") final String moduleName,
                                         @DefaultValue("0") @QueryParam("offset") int offset,
                                         @DefaultValue("20") @QueryParam("size") int size) {
        try {
            // TODO: QueryByModuleName
            return new GetAllPartnerUniversityModules(this.serviceContext, partnerUniversityId, new QueryByModuleName<>(partnerUniversityId, moduleName, offset, size)).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @GET
    @Path("{partnerUniversityId: \\d+}/modules/{moduleId: \\d+}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response getPartnerUniversityModule(@PathParam("partnerUniversityId") final long partnerUniversityId,
                                            @PathParam("moduleId") final long moduleId) {
        try {
            return new GetSinglePartnerUniversityModule( this.serviceContext, partnerUniversityId, moduleId ).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @POST
    @Path("{partnerUniversityId: \\d+}/modules")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    // TODO: fix
    public Response createPartnerUniversityModule(@PathParam("partnerUniversityId") final long partnerUniversityId, final Module module) {
        try {
            return new PostNewPartnerUniversityModule( this.serviceContext, partnerUniversityId, module ).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @PUT
    @Path("{partnerUniversityId: \\d+}/modules/{moduleId: \\d+}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response updatePartnerUniversityModule(@PathParam("partnerUniversityId") final long partnerUniversityId,
                                              @PathParam("moduleId") final long moduleId, final Module module) {
        try {
            return new PutSinglePartnerUniversityModule( this.serviceContext, partnerUniversityId, moduleId, module ).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

    @DELETE
    @Path("{partnerUniversityId: \\d+}/modules/{moduleId: \\d+}")
    public Response deletePartnerUniversityModule(@PathParam("partnerUniversityId") final long partnerUniversityId,
                                           @PathParam("moduleId") final long moduleId) {
        try {
            return new DeleteSinglePartnerUniversityModule( this.serviceContext, moduleId, partnerUniversityId ).execute();
        } catch (SuttonWebAppException e) {
            throw new WebApplicationException(Response.status(e.getStatus().getCode())
                    .entity(e.getExceptionMessage()).build());
        }
    }

}
