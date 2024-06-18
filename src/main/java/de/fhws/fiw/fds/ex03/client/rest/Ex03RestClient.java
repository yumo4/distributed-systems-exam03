package de.fhws.fiw.fds.ex03.client.rest;

import de.fhws.fiw.fds.ex03.client.models.ModuleClientModel;
import de.fhws.fiw.fds.ex03.client.models.PartnerUniversityClientModel;
import de.fhws.fiw.fds.ex03.client.web.PartnerUniversityWebClient;
import de.fhws.fiw.fds.sutton.client.rest2.AbstractRestClient;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
public class Ex03RestClient extends AbstractRestClient{

    // change hier wieder zu demo?
     private static final String BASE_URL = "http://localhost:8080/ex03/api";
//    private static final String BASE_URL = "http://localhost:8080/demo2/api";
    private static final String GET_ALL_PARTNERUNIVERSITIES = "getAllPartnerUniversities";
    private static final String CREATE_PARTNERUNIVERSITY = "createPartnerUniversity";


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

    public boolean isCreatePartnerUniversityAllowed(){
        return isLinkAvailable(CREATE_PARTNERUNIVERSITY);
    }
    public boolean isGetAllPartnerUniversitiesAllowed(){
        return isLinkAvailable(GET_ALL_PARTNERUNIVERSITIES);
    }
    public boolean isGetSinglePartnerUniversityAllowed(){
        return !this.currentPartnerUniversityData.isEmpty();
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
    public void getSingleParterUniversity() throws IOException {
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

    public void updatePartnerUniversity(int index, PartnerUniversityClientModel updatedPartnerUniversity) throws IOException {
        if (0 <= index && index < this.currentPartnerUniversityData.size()) {
            String url = this.currentPartnerUniversityData.get(index).getSelfLink().getUrl();
            processResponse(this.client.putPartnerUniversity(url, updatedPartnerUniversity), (response) -> {
                this.currentPartnerUniversityData.set(index, updatedPartnerUniversity);
            });
        } else {
            throw new IllegalArgumentException();
        }
    }

    // [D]elete PU
    public void deletePartnerUniversity(int index) throws IOException {
        if (0 <= index && index < this.currentPartnerUniversityData.size()) {
            String url = this.currentPartnerUniversityData.get(index).getSelfLink().getUrl();
            processResponse(this.client.deletePartnerUniversity(url), (response) -> {
                this.currentPartnerUniversityData.remove(index);
                if (this.cursorPartnerUniversityData >= this.currentPartnerUniversityData.size()) {
                    this.cursorPartnerUniversityData = this.currentPartnerUniversityData.size() - 1;
                }
            });
        } else {
            throw new IllegalArgumentException();
        }
    }

}
