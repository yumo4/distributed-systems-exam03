package de.fhws.fiw.fds.ex03.server.api.queries;

import de.fhws.fiw.fds.sutton.server.api.queries.AbstractQuery;
import de.fhws.fiw.fds.sutton.server.api.queries.PagingBehaviorUsingOffsetSize;
import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.ex03.server.api.models.PartnerUniversity;
import de.fhws.fiw.fds.ex03.server.database.DaoFactory;
import de.fhws.fiw.fds.ex03.server.database.PartnerUniversityDao;
public class QueryByOutgoingStudents<R> extends AbstractQuery<R, PartnerUniversity> {
    private int outgoingStudents;

    public QueryByOutgoingStudents(int outgoingStudents, int offset, int size) {
        this.outgoingStudents = outgoingStudents;
        this.pagingBehavior = new PagingBehaviorUsingOffsetSize<>(offset, size);
    }

    public int getOutgoingStudents() {
        return this.outgoingStudents;
    }

    public void setOutgoingStudents(int outgoingStudents) {
        this.outgoingStudents = outgoingStudents;
    }



    protected CollectionModelResult<PartnerUniversity> doExecuteQuery(SearchParameter searchParameter) throws DatabaseException {
        return DaoFactory.getInstance().getPartnerUniversityDao().readByOutgoingStudents(
                this.outgoingStudents,
                searchParameter);
    }
}
