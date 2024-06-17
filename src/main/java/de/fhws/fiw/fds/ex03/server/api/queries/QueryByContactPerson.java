package de.fhws.fiw.fds.ex03.server.api.queries;
import de.fhws.fiw.fds.sutton.server.api.queries.AbstractQuery;
import de.fhws.fiw.fds.sutton.server.api.queries.PagingBehaviorUsingOffsetSize;
import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.ex03.server.api.models.PartnerUniversity;
import de.fhws.fiw.fds.ex03.server.database.DaoFactory;
import de.fhws.fiw.fds.ex03.server.database.PartnerUniversityDao;


public class QueryByContactPerson<R> extends AbstractQuery<R, PartnerUniversity> {
    private String contactPerson;

    public QueryByContactPerson(String contactPerson, int offset, int size) {
        this.contactPerson = contactPerson;
        this.pagingBehavior = new PagingBehaviorUsingOffsetSize<>(offset, size);
    }

    public String getContactPerson() {
        return this.getContactPerson();
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }



    protected CollectionModelResult<PartnerUniversity> doExecuteQuery(SearchParameter searchParameter) throws DatabaseException {
        return DaoFactory.getInstance().getPartnerUniversityDao().readByContactPerson(
                this.contactPerson,
                searchParameter);
    }
}
