package de.fhws.fiw.fds.ex03.client.rest;

import de.fhws.fiw.fds.ex03.client.models.ModuleClientModel;
import de.fhws.fiw.fds.ex03.client.models.PartnerUniversityClientModel;
import de.fhws.fiw.fds.ex03.client.web.PartnerUniversityWebClient;
import de.fhws.fiw.fds.sutton.client.rest2.AbstractRestClient;
import de.fhws.fiw.fds.sutton.client.utils.Link;
import de.fhws.fiw.fds.ex03.server.api.states.partneruniversities.PartnerUniversityRelTypes.*;
import de.fhws.fiw.fds.ex03.server.api.states.partneruniversities_modules.PartnerUniversityModuleRelTypes.*;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static de.fhws.fiw.fds.ex03.server.api.states.partneruniversities.PartnerUniversityRelTypes.GET_SINGLE_PARTNERUNIVERSITY;

public class Ex03RestClient extends AbstractRestClient{

    // Edit BASE_URL here for video
     private static final String BASE_URL = "http://localhost:8080/ex03/api";
//    private static final String BASE_URL = "http://localhost:8080/demo/api";

    private static final String GET_ALL_PARTNERUNIVERSITIES = "getAllPartnerUniversities";
    private static final String CREATE_PARTNERUNIVERSITY = "createPartnerUniversity";
    private static final String CREATE_MODULE = "createModuleOfPartnerUniversity";


    private List<PartnerUniversityClientModel> currentPartnerUniversityData;
    private int cursorPartnerUniversityData = 0;

    private List<ModuleClientModel> currentModuleData;
    private int cursorModuleData = 0;

    final private PartnerUniversityWebClient client;

    public Ex03RestClient() {
        super();
        this.client = new PartnerUniversityWebClient();
        this.currentPartnerUniversityData = Collections.EMPTY_LIST;
    }

    public void resetDatabase() throws IOException {
        processResponse(this.client.resetDatabaseOnServer(BASE_URL), (response) -> {
        });
    }

    public void start() throws IOException {
        processResponse(this.client.getDispatcher(BASE_URL), (response) -> {
        });
    }


//    public boolean isLocationHeaderAvailable()
//    {
//        return locationHeaderURL != null;
//    }
    public boolean isCreatePartnerUniversityAllowed(){
        return isLinkAvailable(CREATE_PARTNERUNIVERSITY);
    }
    public boolean isGetAllPartnerUniversitiesAllowed(){
        return isLinkAvailable(GET_ALL_PARTNERUNIVERSITIES);
    }
    public boolean isGetSinglePartnerUniversityAllowed(){
        return !this.currentPartnerUniversityData.isEmpty() || isLocationHeaderAvailable();
    }

    // [C]reate PU
    public void createPartnerUniversity(PartnerUniversityClientModel partnerUniversity) throws IOException{
        if(isCreatePartnerUniversityAllowed()){
            processResponse(this.client.postNewPartnerUniversity(getUrl(CREATE_PARTNERUNIVERSITY), partnerUniversity), (response) -> {
                this.currentPartnerUniversityData = Collections.EMPTY_LIST;
                this.cursorPartnerUniversityData= 0;
            });
        } else {
            throw new IllegalStateException();
        }
    }

//     [C]reate PU-Module
//    public void createPartnerUniversityModule(ModuleClientModel moduleClientModel) throws IOException{
//        if(isCreatePartnerUniversityAllowed()){
//            processResponse(this.client.postNewPartnerUniversityModule(getUrl(CREATE_PARTNERUNIVERSITY), partnerUniversity), (response) -> {
//                this.currentModuleData = Collections.EMPTY_LIST;
//                this.cursorModuleData= 0;
//            });
//        } else {
//            throw new IllegalStateException();
//        }
//    }


    // [R]ead PU
    public void getAllPartneruniversities() throws IOException {
        if (isGetAllPartnerUniversitiesAllowed()) {
            processResponse(this.client.getCollectionOfPartnerUniversities(getUrl(GET_ALL_PARTNERUNIVERSITIES)), (response) -> {
                this.currentPartnerUniversityData = new LinkedList(response.getResponseData());
                this.cursorPartnerUniversityData = 0;
            });
        } else {
            throw new IllegalStateException();
        }
    }

    public List<PartnerUniversityClientModel> partnerUniversityData() {
        if (this.currentPartnerUniversityData.isEmpty()) {
            throw new IllegalStateException();
        }
        return this.currentPartnerUniversityData;
    }
    public void getSinglePartnerUniversity() throws IOException {
        if ( isLocationHeaderAvailable()) {
            getSinglePartnerUniversity(getLocationHeaderURL());
        }
        else if (!this.currentPartnerUniversityData.isEmpty()) {
            getSinglePartnerUniversity(this.cursorPartnerUniversityData);
        }
        else {
            throw new IllegalStateException();
        }
    }

    public void getSinglePartnerUniversity(int index) throws IOException {
        getSinglePartnerUniversity(this.currentPartnerUniversityData.get(index).getSelfLink().getUrl());
    }

    private void getSinglePartnerUniversity(String url) throws IOException {
        processResponse(this.client.getSinglePartnerUniversity(url), (response) -> {
            this.currentPartnerUniversityData = new LinkedList(response.getResponseData());
            this.cursorPartnerUniversityData = 0;
        });
    }

    public void setPartnerUniversityCursor(int index) {
        if (0 <= index && index < this.currentPartnerUniversityData.size()) {
            this.cursorPartnerUniversityData = index;
        } else {
            throw new IllegalArgumentException();
        }
    }


//    public void updatePartnerUniversity(int index, PartnerUniversityClientModel partnerUniversityClientModel) throws IOException {
////    public void updatePartnerUniversity(int index , PartnerUniversityClientModel partnerUniversityClientModel) throws IOException {
////        updatePartnerUniversity(index, this.currentPartnerUniversityData.get(index).getSelfLink().getUrl(), partnerUniversityClientModel);
////        updatePartnerUniversity(index, this.currentPartnerUniversityData.get(index).getSelfLink().getUrl(), partnerUniversityClientModel);
//
//        this.currentPartnerUniversityData= new LinkedList();
//        Link updatedResourceLink = getLink(GET_ALL_PARTNERUNIVERSITIES);
//        partnerUniversityClientModel.setSelfLink(updatedResourceLink);
//        this.currentPartnerUniversityData.add(partnerUniversityClientModel);
//        this.currentPartnerUniversityData = 0;
//    }

//    public void updatePartnerUniversity(int index, String url, PartnerUniversityClientModel updatedPartnerUniversity) throws IOException {
//        processResponse(this.client.putPartnerUniversity(url, updatedPartnerUniversity), (response) -> {
////            this.currentPartnerUniversityData.set(index, updatedPartnerUniversity);
////            this.currentPartnerUniversityData.set(index, updatedPartnerUniversity);
////            this.currentPartnerUniversityData= new LinkedList();
////                Link updatedResourceLink = getLink(GET_ALL_PARTNERUNIVERSITIES);
////                model.setSelfLink(updatedResourceLink);
////                this.currentPartnerUniversityData.add(model);
////                this.currentPartnerUniversityData = 0;
//        });
//    }
//    public void updatePartnerUniversity(int index, String url, PartnerUniversityClientModel updatedPartnerUniversity) throws IOException {
//    public void updatePartnerUniversity(int index, PartnerUniversityClientModel updatedPartnerUniversity) throws IOException {
//        if (0 <= index && index < this.currentPartnerUniversityData.size()) {
//            String url = this.currentPartnerUniversityData.get(index).getSelfLink().getUrl();
//        processResponse(this.client.putPartnerUniversity(url, updatedPartnerUniversity), (response) -> {
//            this.currentPartnerUniversityData.set(index, updatedPartnerUniversity);
//        });
//        } else {
//            throw new IllegalArgumentException();
//        }
//    }

    // TODO: FIX UPDATE
    public void updatePartnerUniversity(int index, PartnerUniversityClientModel partnerUniversityClientModel) throws IOException{
        updatePartnerUniversity(this.currentPartnerUniversityData.get(index).getSelfLink().getUrl(), partnerUniversityClientModel);
    }
    public void updatePartnerUniversity(String url, PartnerUniversityClientModel partnerUniversityClientModel) throws IOException{
//        processResponse(this.client.putPartnerUniversity(url, partnerUniversityClientModel), (response -> {
        processResponse(this.client.putPartnerUniversity(url, partnerUniversityClientModel), (response -> {
//           this.currentPartnerUniversityData.set(url, partnerUniversityClientModel);
           this.currentPartnerUniversityData = new LinkedList();
                Link updatedResourceLink = getLink(GET_SINGLE_PARTNERUNIVERSITY);
                partnerUniversityClientModel.setSelfLink(updatedResourceLink);
                this.currentPartnerUniversityData.add(partnerUniversityClientModel);
                this.cursorPartnerUniversityData = 0;
        }));
    }
    // [D]elete PU

    public void deletePartnerUniversity(int index) throws IOException {
        deletePartnerUniversity(this.currentPartnerUniversityData.get(index).getSelfLink().getUrl());
    }
    public void deletePartnerUniversity(String url) throws IOException {
       processResponse(this.client.deletePartnerUniversity(url), (response) -> {

            this.currentPartnerUniversityData.remove(url);
            if (this.cursorPartnerUniversityData >= this.currentPartnerUniversityData.size()) {
                this.cursorPartnerUniversityData = this.currentPartnerUniversityData.size() - 1;
            }
        });
    }

}
