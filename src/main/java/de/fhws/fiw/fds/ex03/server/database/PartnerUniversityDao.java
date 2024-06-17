package de.fhws.fiw.fds.ex03.server.database;

import de.fhws.fiw.fds.sutton.server.database.IDatabaseAccessObject;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.ex03.server.api.models.PartnerUniversity;
public interface PartnerUniversityDao extends IDatabaseAccessObject<PartnerUniversity>{
    CollectionModelResult<PartnerUniversity> readByName(String name, SearchParameter searchParameter);
    CollectionModelResult<PartnerUniversity> readByCountry(String country, SearchParameter searchParameter);
    CollectionModelResult<PartnerUniversity> readByDepartmentName(String departmentName, SearchParameter searchParameter);
    CollectionModelResult<PartnerUniversity> readByDepartmentURL(String departmentURl, SearchParameter searchParameter);
    CollectionModelResult<PartnerUniversity> readByContactPerson(String contactPerson, SearchParameter searchParameter);
    CollectionModelResult<PartnerUniversity> readByOutgoingStudents(int outgoingStudents, SearchParameter searchParameter);
    CollectionModelResult<PartnerUniversity> readByIncomingStudents(int incomingStudents, SearchParameter searchParameter);
    // readBySpringSemesterStart
    // readByAutumnSemesterStart

//    void initializeDatabase();
    void resetDatabase();
}
