package de.fhws.fiw.fds.ex03.server.api.states.partneruniversities;

import de.fhws.fiw.fds.ex03.server.api.states.partneruniversities_modules.PartnerUniversityModuleRelTypes;
import de.fhws.fiw.fds.ex03.server.api.states.partneruniversities_modules.PartnerUniversityModuleUri;
import de.fhws.fiw.fds.ex03.server.database.PartnerUniversityModuleDao;
import de.fhws.fiw.fds.sutton.server.api.caching.CachingUtils;
import de.fhws.fiw.fds.sutton.server.api.caching.EtagGenerator;
import de.fhws.fiw.fds.sutton.server.api.serviceAdapters.responseAdapter.JerseyResponse;
import de.fhws.fiw.fds.sutton.server.api.services.ServiceContext;
import de.fhws.fiw.fds.sutton.server.api.states.get.AbstractGetState;
import de.fhws.fiw.fds.sutton.server.database.results.SingleModelResult;
import de.fhws.fiw.fds.sutton.server.models.AbstractModel;
import de.fhws.fiw.fds.ex03.server.api.models.PartnerUniversity;
import de.fhws.fiw.fds.ex03.server.database.DaoFactory;
import jakarta.ws.rs.core.Response;
public class GetSinglePartnerUniversity extends AbstractGetState<Response, PartnerUniversity> {

    public GetSinglePartnerUniversity(ServiceContext serviceContext, long requestedId) {
        super(serviceContext, requestedId);
        this.suttonResponse = new JerseyResponse<>();
    }

    @Override
    protected SingleModelResult<PartnerUniversity> loadModel() {
        return DaoFactory.getInstance().getPartnerUniversityDao().readById(this.requestedId);
    }

    @Override
    protected boolean clientKnowsCurrentModelState(AbstractModel modelFromDatabase) {
        return this.suttonRequest.clientKnowsCurrentModel(modelFromDatabase);
    }

    @Override
    protected void defineHttpCaching() {
        final String eTagOfModel = EtagGenerator.createEtag(this.requestedModel.getResult());
        this.suttonResponse.entityTag(eTagOfModel);
        this.suttonResponse.cacheControl(CachingUtils.create30SecondsPublicCaching());
    }

    @Override
    protected void defineTransitionLinks() {
        addLink( PartnerUniversityUri.REL_PATH_ID, PartnerUniversityRelTypes.UPDATE_SINGLE_PARTNERUNIVERSITY, getAcceptRequestHeader( ),
                this.requestedId);
        addLink( PartnerUniversityUri.REL_PATH_ID, PartnerUniversityRelTypes.DELETE_SINGLE_PARTNERUNIVERSITY, getAcceptRequestHeader( ),
                this.requestedId);
        addLink( PartnerUniversityUri.REL_PATH_ID, PartnerUniversityRelTypes.GET_ALL_PARTNERUNIVERSITIES, getAcceptRequestHeader( ),
                this.requestedId);
        addLink(PartnerUniversityModuleUri.REL_PATH, PartnerUniversityModuleRelTypes.CREATE_MODULE, getAcceptRequestHeader(), this.requestedId);
        addLink(PartnerUniversityModuleUri.REL_PATH, PartnerUniversityModuleRelTypes.GET_ALL_MODULES, getAcceptRequestHeader(), this.requestedId);
    }
}
