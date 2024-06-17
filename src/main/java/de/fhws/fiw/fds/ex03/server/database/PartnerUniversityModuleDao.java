package de.fhws.fiw.fds.ex03.server.database;

import de.fhws.fiw.fds.sutton.server.database.IDatabaseRelationAccessObject;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.ex03.server.api.models.Module;

public interface PartnerUniversityModuleDao extends IDatabaseRelationAccessObject<Module> {

    CollectionModelResult<Module> readByModuleName(long primaryId, String moduleName, SearchParameter searchParameter);
//    CollectionModelResult<Module> readByModuleSemester(long primaryId, int moduleSemester, SearchParameter searchParameter);
//    CollectionModelResult<Module> readByModuleCreditPoints(long primaryId, int moduleCreditPoints, SearchParameter searchParameter);

    void initializeDatabase();

    void resetDatabase();

}
