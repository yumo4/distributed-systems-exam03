package de.fhws.fiw.fds.ex03.client.web;

import de.fhws.fiw.fds.ex03.client.models.ModuleClientModel;
import de.fhws.fiw.fds.sutton.client.web.GenericWebClient;
import de.fhws.fiw.fds.sutton.client.web.WebApiResponse;
import de.fhws.fiw.fds.ex03.client.models.PartnerUniversityClientModel;

import java.io.IOException;
public class PartnerUniversityWebClient {
    private GenericWebClient<PartnerUniversityClientModel> client;

    public PartnerUniversityWebClient() {
        this.client = new GenericWebClient<>();
    }

    public PartnerUniversityWebResponse getDispatcher( String url ) throws IOException
    {
        return createResponse( this.client.sendGetSingleRequest( url ) );
    }


    public PartnerUniversityWebResponse getSinglePartnerUniversity(String url) throws IOException {
        return createResponse(this.client.sendGetSingleRequest(url, PartnerUniversityClientModel.class));
    }

    public PartnerUniversityWebResponse getCollectionOfPartnerUniversities(String url) throws IOException {
        return createResponse(this.client.sendGetCollectionRequest(url, PartnerUniversityClientModel.class));
    }

    public PartnerUniversityWebResponse postNewPartnerUniversity(String url, PartnerUniversityClientModel partnerUniversity)
            throws IOException {
        return createResponse(this.client.sendPostRequest(url, partnerUniversity));
    }

    public PartnerUniversityWebResponse putPartnerUniversity(String url, PartnerUniversityClientModel partnerUniversity) throws IOException {
        return createResponse(this.client.sendPutRequest(url, partnerUniversity));
    }

    public PartnerUniversityWebResponse deletePartnerUniversity(String url) throws IOException {
        return createResponse(this.client.sendDeleteRequest(url));
    }

    public PartnerUniversityWebResponse resetDatabaseOnServer(String url) throws IOException {
        return createResponse(this.client.sendGetSingleRequest(url + "/resetdatabase"));
    }

    private PartnerUniversityWebResponse createResponse(WebApiResponse<PartnerUniversityClientModel> response) {
        return new PartnerUniversityWebResponse(response.getResponseData(), response.getResponseHeaders(),
                response.getLastStatusCode());
    }

    // TODO: CRUD PartnerUniversityModules

//    public PartnerUniversityWebResponse getSinglePartnerUniversityModule(String url) throws IOException {
//        return createResponse(this.client.sendGetSingleRequest(url, ModuleClientModel.class));
//    }
//
//    public PartnerUniversityWebResponse getCollectionOfPartnerUniversitiyModules(String url) throws IOException {
//        return createResponse(this.client.sendGetCollectionRequest(url, ModuleClientModel.class));
//    }
//
//    public PartnerUniversityWebResponse postNewPartnerUniversityModule(String url, ModuleClientModel module)
//            throws IOException {
//        return createResponse(this.client.sendPostRequest(url, module));
//    }
//
//    public PartnerUniversityWebResponse putPartnerUniversityModule(String url, ModuleClientModel module) throws IOException {
//        return createResponse(this.client.sendPutRequest(url, module));
//    }
//
//    public PartnerUniversityWebResponse deletePartnerUniversityModule(String url) throws IOException {
//        return createResponse(this.client.sendDeleteRequest(url));
//    }
//
////    public PartnerUniversityWebResponse resetDatabaseOnServer(String url) throws IOException {
////        return createResponse(this.client.sendGetSingleRequest(url + "/resetdatabase"));
////    }
//
//    private PartnerUniversityWebResponse createResponse(WebApiResponse<ModuleClientModel> response) {
//        return new PartnerUniversityWebResponse(response.getResponseData(), response.getResponseHeaders(),
//                response.getLastStatusCode());
//    }
}
