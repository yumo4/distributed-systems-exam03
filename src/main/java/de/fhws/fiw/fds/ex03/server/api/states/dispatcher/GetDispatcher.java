package de.fhws.fiw.fds.ex03.server.api.states.dispatcher;


import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.responseAdapter.JerseyResponse;
import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import de.fhws.fiw.fds.sutton.server.api.states.get.AbstractGetDispatcherState;
import de.fhws.fiw.fds.ex03.server.api.states.partneruniversities.PartnerUniversityRelTypes;
import de.fhws.fiw.fds.ex03.server.api.states.partneruniversities.PartnerUniversityUri;
import de.fhws.fiw.fds.sutton.server.api.states.get.AbstractGetRelationState;
import jakarta.ws.rs.core.Response;

public class GetDispatcher extends AbstractGetDispatcherState<Response> {

    public GetDispatcher(ServiceContext serviceContext) {
        super(serviceContext);
        this.suttonResponse = new JerseyResponse<>();
    }

    @Override
    protected void defineTransitionLinks() {
        addLink(PartnerUniversityUri.REL_PATH, PartnerUniversityRelTypes.GET_ALL_PARTNERUNIVERSITIES, getAcceptRequestHeader());
        addLink(PartnerUniversityUri.REL_PATH, PartnerUniversityRelTypes.CREATE_PARTNERUNIVERSITY, getAcceptRequestHeader());
    }
}
