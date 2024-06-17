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
//public class QueryByModuleCreditPoints<R> extends AbstractRelationQuery<R, Module> {
//
//    private int moduleCreditPoints;
//
//    private int waitingTime;
//
//    public QueryByModuleCreditPoints(long primaryId, int moduleCreditPoints, int offset, int size) {
//        super(primaryId);
//        this.moduleCreditPoints = moduleCreditPoints;
//        this.pagingBehavior = new PagingBehaviorUsingOffsetSize<>(offset, size);
//    }
//
//    public int getModuleCreditPoints() {
//        return moduleCreditPoints;
//    }
//
//    public void setModuleCreditPoints(int moduleCreditPoints) {
//        this.moduleCreditPoints = moduleCreditPoints;
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
//        return DaoFactory.getInstance().getPartnerUniversityModuleDao().readByModuleCreditPoints(this.primaryId, this.moduleCreditPoints, searchParameter);
//    }
//}
//
