package de.fhws.fiw.fds.ex03.server.api.queries;

import de.fhws.fiw.fds.sutton.server.api.queries.AbstractQuery;
import de.fhws.fiw.fds.sutton.server.api.queries.PagingBehaviorUsingOffsetSize;
import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.ex03.server.api.models.PartnerUniversity;
import de.fhws.fiw.fds.ex03.server.database.DaoFactory;
import de.fhws.fiw.fds.ex03.server.database.PartnerUniversityDao;

public class QueryByDepartmentName<R> extends AbstractQuery<R, PartnerUniversity> {
    private String departmentName;

    public QueryByDepartmentName(String departmentName, int offset, int size) {
        this.departmentName = departmentName;
        this.pagingBehavior = new PagingBehaviorUsingOffsetSize<>(offset, size);
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }



    protected CollectionModelResult<PartnerUniversity> doExecuteQuery(SearchParameter searchParameter) throws DatabaseException {
        return DaoFactory.getInstance().getPartnerUniversityDao().readByDepartmentName(
                this.departmentName,
                searchParameter);
    }
}
