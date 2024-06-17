//package de.fhws.fiw.fds.ex03.server.api.queries;
//
//import de.fhws.fiw.fds.ex03.server.database.DaoFactory;
//import de.fhws.fiw.fds.ex03.server.api.models.Module;
//import de.fhws.fiw.fds.sutton.server.api.queries.AbstractRelationQuery;
//import de.fhws.fiw.fds.sutton.server.api.queries.PagingBehaviorUsingOffsetSize;
//import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
//import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
//import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
//
//public class QueryByModuleSemester<R> extends AbstractRelationQuery<R, Module> {
//
//    private int moduleSemester;
//
//    private int waitingTime;
//
//    public QueryByModuleSemester(long primaryId, int moduleSemester, int offset, int size) {
//        super(primaryId);
//        this.moduleSemester = moduleSemester;
//        this.pagingBehavior = new PagingBehaviorUsingOffsetSize<>(offset, size);
//    }
//
//    public int getModuleSemester() {
//        return moduleSemester;
//    }
//
//    public void setModuleSemester(int moduleSemester) {
//        this.moduleSemester = moduleSemester;
//    }
//
//    public int getWaitingTime() {
//        return waitingTime;
//    }
//
//    public void setWaitingTime(int waitingTime) {
//        this.waitingTime = waitingTime;
//    }
//
//    @Override
//    protected CollectionModelResult<Module> doExecuteQuery(SearchParameter searchParameter) throws DatabaseException {
//        return DaoFactory.getInstance().getPartnerUniversityModuleDao().readByModuleSemester(this.primaryId, this.moduleSemester, searchParameter);
//    }
//}
//
