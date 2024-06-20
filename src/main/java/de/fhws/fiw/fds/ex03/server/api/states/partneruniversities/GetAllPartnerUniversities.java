package de.fhws.fiw.fds.ex03.server.api.states.partneruniversities;

import de.fhws.fiw.fds.ex03.server.api.models.PartnerUniversity;
import de.fhws.fiw.fds.sutton.server.api.states.get.AbstractGetCollectionState;
import de.fhws.fiw.fds.sutton.server.api.queries.AbstractQuery;
import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.responseAdapter.JerseyResponse;
import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import jakarta.ws.rs.core.Response;

public class GetAllPartnerUniversities extends AbstractGetCollectionState<Response, PartnerUniversity> {

    public GetAllPartnerUniversities(ServiceContext serviceContext, AbstractQuery<Response, PartnerUniversity> query) {
        super(serviceContext, query);
        this.suttonResponse = new JerseyResponse<>();
    }

    @Override
    protected void defineTransitionLinks() {
        addLink(PartnerUniversityUri.REL_PATH, PartnerUniversityRelTypes.CREATE_PARTNERUNIVERSITY, getAcceptRequestHeader());

        addLink(PartnerUniversityUri.REL_PATH, PartnerUniversityRelTypes.FILTER_BY_NAME, getAcceptRequestHeader());
        addLink(PartnerUniversityUri.REL_PATH, PartnerUniversityRelTypes.FILTER_BY_COUNTRY, getAcceptRequestHeader());
        addLink(PartnerUniversityUri.REL_PATH, PartnerUniversityRelTypes.FILTER_BY_NAME_AND_COUNTRY, getAcceptRequestHeader());
    }
}
