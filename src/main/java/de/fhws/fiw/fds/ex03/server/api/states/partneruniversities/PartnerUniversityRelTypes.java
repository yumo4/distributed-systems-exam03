package de.fhws.fiw.fds.ex03.server.api.states.partneruniversities;

public interface PartnerUniversityRelTypes {

    String CREATE_PARTNERUNIVERSITY = "createPartnerUniversity";
    String GET_ALL_PARTNERUNIVERSITIES = "getAllPartnerUniversities";
    String GET_SINGLE_PARTNERUNIVERSITY = "getPartnerUniversity";
    String UPDATE_SINGLE_PARTNERUNIVERSITY  = "updatePartnerUniversity";
    String DELETE_SINGLE_PARTNERUNIVERSITY = "deletePartnerUniversity";

    String FILTER_BY_NAME = "filterByName";
    String FILTER_BY_COUNTRY = "filterByCountry";
    String FILTER_BY_NAME_AND_COUNTRY = "filterByNameAndCountry";
}
