package de.fhws.fiw.fds.ex03.server.api.states.partneruniversities_modules;

import de.fhws.fiw.fds.ex03.server.api.states.partneruniversities.PartnerUniversityRelTypes;
import de.fhws.fiw.fds.ex03.server.api.states.partneruniversities.PartnerUniversityUri;
import de.fhws.fiw.fds.sutton.server.api.queries.AbstractRelationQuery;
import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.responseAdapter.JerseyResponse;
import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import de.fhws.fiw.fds.ex03.server.api.models.Module;
import de.fhws.fiw.fds.sutton.server.api.states.get.AbstractGetCollectionRelationState;
import jakarta.ws.rs.core.Response;

public class GetAllPartnerUniversityModules extends AbstractGetCollectionRelationState<Response, Module> {

    public GetAllPartnerUniversityModules(ServiceContext serviceContext, long primaryId, AbstractRelationQuery<Response, Module> query) {
        super(serviceContext, primaryId, query);
        this.suttonResponse = new JerseyResponse<>();
    }

    @Override
    protected void defineTransitionLinks() {
//        addLink(PartnerUniversityModuleUri.REL_PATH,
        addLink(PartnerUniversityModuleUri.REL_PATH_ID,
                PartnerUniversityModuleRelTypes.CREATE_MODULE,
                getAcceptRequestHeader(), this.primaryId);


        addLink(PartnerUniversityModuleUri.REL_PATH_SHOW_ALL,
                PartnerUniversityModuleRelTypes.GET_ALL_MODULES,
                getAcceptRequestHeader(),
                this.primaryId);


//        addLink(PartnerUniversityUri.REL_PATH + "?name={NAME}", PartnerUniversityRelTypes.FILTER_BY_NAME, getAcceptRequestHeader());
//        addLink(PartnerUniversityUri.REL_PATH + "?country={COUNTRY}", PartnerUniversityRelTypes.FILTER_BY_COUNTRY, getAcceptRequestHeader());
//        addLink(PartnerUniversityUri.REL_PATH + "?universityName={NAME}&country={COUNTRY}", PartnerUniversityRelTypes.FILTER_BY_NAME_AND_COUNTRY, getAcceptRequestHeader());
        //addLink(UniversityUri.REL_PATH + "?universityName={NAME}&country={COUNTRY}&order={ORDER}", UniversityRelTypes.FILTER_BY_NAME_AND_COUNTRY_ORDER, getAcceptRequestHeader());
//        addLink(UniversityUri.REL_PATH + "?offset={OFFSET}&size={SIZE}", UniversityRelTypes.PAGING_OF_UNIVERSITIES, getAcceptRequestHeader());

    }
}
