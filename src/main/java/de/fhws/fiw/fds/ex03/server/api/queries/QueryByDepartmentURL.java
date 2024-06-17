package de.fhws.fiw.fds.ex03.server.api.queries;

import de.fhws.fiw.fds.sutton.server.api.queries.AbstractQuery;
import de.fhws.fiw.fds.sutton.server.api.queries.PagingBehaviorUsingOffsetSize;
import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.ex03.server.api.models.PartnerUniversity;
import de.fhws.fiw.fds.ex03.server.database.DaoFactory;
import de.fhws.fiw.fds.ex03.server.database.PartnerUniversityDao;

public class QueryByDepartmentURL<R> extends AbstractQuery<R, PartnerUniversity> {
    private String departmentURL;

    public QueryByDepartmentURL(String departmentURL, int offset, int size) {
        this.departmentURL = departmentURL;
        this.pagingBehavior = new PagingBehaviorUsingOffsetSize<>(offset, size);
    }

    public String getDepartmentURL() {
        return this.departmentURL;
    }

    public void setDepartmentURL(String departmentURL) {
        this.departmentURL = departmentURL;
    }



    protected CollectionModelResult<PartnerUniversity> doExecuteQuery(SearchParameter searchParameter) throws DatabaseException {
        return DaoFactory.getInstance().getPartnerUniversityDao().readByDepartmentURL(
                this.departmentURL,
                searchParameter);
    }
}
