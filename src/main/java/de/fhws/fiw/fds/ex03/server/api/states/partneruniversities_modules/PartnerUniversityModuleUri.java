package de.fhws.fiw.fds.ex03.server.api.states.partneruniversities_modules;
import de.fhws.fiw.fds.ex03.Start;

public interface PartnerUniversityModuleUri {
    String SHOW_ALL_PARAMETER = "showAll";
    String PATH_ELEMENT = "partneruniversities/{id}/modules";

    String REL_PATH = Start.CONTEXT_PATH + "/api/" + PATH_ELEMENT;
    String REL_PATH_SHOW_ALL = Start.CONTEXT_PATH + "/api/" + PATH_ELEMENT + "?" + SHOW_ALL_PARAMETER + "=true";
    String REL_PATH_SHOW_ONLY_LINKED = Start.CONTEXT_PATH + "/api/" + PATH_ELEMENT + "?" + SHOW_ALL_PARAMETER + "=false";
    String REL_PATH_ID = REL_PATH + "/{id}";

}
