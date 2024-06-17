package de.fhws.fiw.fds.ex03.server.database.inmemory;
import de.fhws.fiw.fds.ex03.server.database.ModuleDao;
import de.fhws.fiw.fds.sutton.server.database.IDatabaseAccessObject;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.inmemory.AbstractInMemoryRelationStorage;
import de.fhws.fiw.fds.sutton.server.database.inmemory.InMemoryPaging;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.ex03.server.api.models.Module;
import de.fhws.fiw.fds.ex03.server.database.PartnerUniversityModuleDao;

public class PartnerUniversityModuleStorage extends AbstractInMemoryRelationStorage<Module> implements PartnerUniversityModuleDao {

    final private ModuleDao moduleStorage;
    public PartnerUniversityModuleStorage(ModuleDao moduleStorage) {
        this.moduleStorage = moduleStorage;
    }


    @Override
    protected IDatabaseAccessObject<Module> getSecondaryStorage() {
//        return (IDatabaseAccessObject<Module>) this.moduleStorage;
        return this.moduleStorage;
    }

    // ByModuleName
    @Override
    public CollectionModelResult<Module> readByModuleName(long primaryId, String name, SearchParameter searchParameter) {
        return InMemoryPaging.page(
                this.readAllLinkedByPredicate(primaryId, (p) -> name.isEmpty() || p.getModuleName().equals(name)),
                searchParameter.getOffset(), searchParameter.getSize()
        );
    }

    // ByModuleSemester
//    @Override
//    public CollectionModelResult<Module> readByModuleSemester(long primaryId, Integer moduleSemester, SearchParameter searchParameter) {
//        return InMemoryPaging.page(
//                this.readAllLinkedByPredicate(primaryId, (p) -> moduleSemester.toString().isEmpty() || p.getModuleSemester() == moduleSemester),
//                searchParameter.getOffset(), searchParameter.getSize()
//        );
//    }
    // ByModuleCreditPoints
//    @Override
//    public CollectionModelResult<Module> readByModuleCreditPoints(long primaryId, Integer moduleCreditPoints, SearchParameter searchParameter) {
//        return InMemoryPaging.page(
//                this.readAllLinkedByPredicate(primaryId, (p) -> moduleCreditPoints.toString().isEmpty() || p.getModuleCreditPoints() == moduleCreditPoints),
//                searchParameter.getOffset(), searchParameter.getSize()
//        );
//    }
    // All
    @Override
    public CollectionModelResult<Module> readAllLinked(long primaryId, SearchParameter searchParameter) {
        return InMemoryPaging.page(
                this.readAllLinkedByPredicate(primaryId, (p) -> true),
                searchParameter.getOffset(), searchParameter.getSize()
        );
    }

    @Override
    public void resetDatabase() {

    }

    @Override
    public void initializeDatabase() {

    }


}
