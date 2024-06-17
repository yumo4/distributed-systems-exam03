package de.fhws.fiw.fds.ex03.server.api.states.partneruniversities_modules;

import de.fhws.fiw.fds.ex03.server.api.models.Module;
import de.fhws.fiw.fds.ex03.server.database.DaoFactory;
import de.fhws.fiw.fds.sutton.server.api.states.delete.AbstractDeleteRelationState;
import de.fhws.fiw.fds.sutton.server.database.results.NoContentResult;
import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.responseAdapter.JerseyResponse;
import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import de.fhws.fiw.fds.sutton.server.database.results.SingleModelResult;
import jakarta.ws.rs.core.Response;

public class DeleteSinglePartnerUniversityModule extends AbstractDeleteRelationState<Response, Module> {

    public DeleteSinglePartnerUniversityModule(ServiceContext serviceContext, long modelIdToDelete, long primaryId) {
        super(serviceContext, modelIdToDelete, primaryId);
        this.suttonResponse = new JerseyResponse<>();
    }


    @Override
    protected SingleModelResult<Module> loadModel() {
        return DaoFactory.getInstance().getPartnerUniversityModuleDao().readById(this.primaryId, this.modelIdToDelete);
    }

    @Override
    protected NoContentResult deleteModel() {
        return DaoFactory.getInstance().getPartnerUniversityModuleDao().deleteRelation(this.primaryId, this.modelIdToDelete);
    }

    @Override
    protected void defineTransitionLinks() {
        addLink(PartnerUniversityModuleUri.REL_PATH,
                PartnerUniversityModuleRelTypes.GET_ALL_MODULES,
                getAcceptRequestHeader(),
                this.primaryId);
    }
}
