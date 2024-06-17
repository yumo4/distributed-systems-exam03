package de.fhws.fiw.fds.ex03;

import de.fhws.fiw.fds.ex03.server.api.services.PartnerUniversityJerseyService;
import de.fhws.fiw.fds.sutton.server.api.AbstractJerseyApplication;
import de.fhws.fiw.fds.ex03.server.api.services.DispatcherJerseyService;
import jakarta.ws.rs.ApplicationPath;

import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class SuttonEx03JerseyApplication extends AbstractJerseyApplication {

    @Override
    protected Set<Class<?>> getServiceClasses() {
        final Set<Class<?>> returnValue = new HashSet<>();

//        returnValue.add(PersonJerseyService.class);
        returnValue.add(PartnerUniversityJerseyService.class);
//        returnValue.add(LocationJerseyService.class);
        returnValue.add(DispatcherJerseyService.class);

        return returnValue;
    }

}
