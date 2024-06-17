package de.fhws.fiw.fds.ex03.server.api.queries;

import de.fhws.fiw.fds.sutton.server.api.queries.AbstractQuery;
import de.fhws.fiw.fds.sutton.server.api.queries.PagingBehaviorUsingOffsetSize;
import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.ex03.server.api.models.PartnerUniversity;
import de.fhws.fiw.fds.ex03.server.database.DaoFactory;
import de.fhws.fiw.fds.ex03.server.database.PartnerUniversityDao;

public class QueryByIncomingStudents<R> extends AbstractQuery<R, PartnerUniversity> {
    private int incomingStudents;

    public QueryByIncomingStudents(int incomingStudents, int offset, int size) {
        this.incomingStudents = incomingStudents;
        this.pagingBehavior = new PagingBehaviorUsingOffsetSize<>(offset, size);
    }

    public int getIncomingStudents() {
        return this.incomingStudents;
    }

    public void setIncomingStudents(int incomingStudents) {
        this.incomingStudents = incomingStudents;
    }



    protected CollectionModelResult<PartnerUniversity> doExecuteQuery(SearchParameter searchParameter) throws DatabaseException {
        return DaoFactory.getInstance().getPartnerUniversityDao().readByOutgoingStudents(
                this.incomingStudents,
                searchParameter);
    }
}
