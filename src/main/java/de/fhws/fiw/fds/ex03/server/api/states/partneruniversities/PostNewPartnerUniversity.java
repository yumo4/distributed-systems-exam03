package de.fhws.fiw.fds.ex03.server.api.states.partneruniversities;

import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.responseAdapter.JerseyResponse;
import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import de.fhws.fiw.fds.sutton.server.api.states.post.AbstractPostState;
import de.fhws.fiw.fds.sutton.server.database.results.NoContentResult;
import de.fhws.fiw.fds.ex03.server.api.models.PartnerUniversity;
import de.fhws.fiw.fds.ex03.server.database.DaoFactory;
import jakarta.ws.rs.core.Response;
public class PostNewPartnerUniversity extends AbstractPostState<Response, PartnerUniversity>{
    public PostNewPartnerUniversity(ServiceContext serviceContext, PartnerUniversity modelToStore) {
        super(serviceContext, modelToStore);
        this.suttonResponse = new JerseyResponse<>();
    }

    @Override
    protected NoContentResult saveModel() {
        return DaoFactory.getInstance().getPartnerUniversityDao().create(this.modelToStore);
    }

    @Override
    protected void defineTransitionLinks() {
        addLink(PartnerUniversityUri.REL_PATH_ID, PartnerUniversityRelTypes.GET_SINGLE_PARTNERUNIVERSITY, getAcceptRequestHeader(),
                this.modelToStore.getId());
//        addLink( PartnerUniversityUri.REL_PATH_ID, PartnerUniversityRelTypes.DELETE_SINGLE_PARTNERUNIVERSITY, getAcceptRequestHeader( ),
//                this.requestedId );
//        addLink(PartnerUniversityModuleUri.REL_PATH, PartnerUniversityModuleRelTypes.CREATE_MODULE, getAcceptRequestHeader(), this.requestedId);
    }
}
