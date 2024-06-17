package de.fhws.fiw.fds.ex03.server.database.inmemory;

import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.inmemory.AbstractInMemoryStorage;
import de.fhws.fiw.fds.sutton.server.database.inmemory.InMemoryPaging;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.ex03.server.api.models.PartnerUniversity;
import de.fhws.fiw.fds.ex03.server.database.PartnerUniversityDao;
import java.util.function.Predicate;

public class PartnerUniversityStorage extends AbstractInMemoryStorage<PartnerUniversity> implements PartnerUniversityDao {

    public void resetDatabase() {
        this.storage.clear();
    }
    // ByName
    @Override
    public CollectionModelResult<PartnerUniversity> readByName(String name, SearchParameter searchParameter) {
        return InMemoryPaging.page(this.readAllByPredicate(
                byName(name),
                searchParameter
        ), searchParameter.getOffset(), searchParameter.getSize());
    }
    private Predicate<PartnerUniversity> byName(String name) {
        return p -> (name.isEmpty() || p.getName().equals(name) );
    }
    // ByCountry
    @Override
    public CollectionModelResult<PartnerUniversity> readByCountry(String country, SearchParameter searchParameter) {
        return InMemoryPaging.page(this.readAllByPredicate(
                byCountry(country),
                searchParameter
        ), searchParameter.getOffset(), searchParameter.getSize());
    }
    private Predicate<PartnerUniversity> byCountry(String country) {
        return p -> (country.isEmpty() || p.getName().equals(country) );
    }
    // ByDepartmentName
    @Override
    public CollectionModelResult<PartnerUniversity> readByDepartmentName(String departmentName, SearchParameter searchParameter) {
        return InMemoryPaging.page(this.readAllByPredicate(
                byDepartmentName(departmentName),
                searchParameter
        ), searchParameter.getOffset(), searchParameter.getSize());
    }
    private Predicate<PartnerUniversity> byDepartmentName(String departmentName) {
        return p -> (departmentName.isEmpty() || p.getName().equals(departmentName) );
    }
    // ByDepartmentURL
    @Override
    public CollectionModelResult<PartnerUniversity> readByDepartmentURL(String departmentURL, SearchParameter searchParameter) {
        return InMemoryPaging.page(this.readAllByPredicate(
                byDepartmentURL(departmentURL),
                searchParameter
        ), searchParameter.getOffset(), searchParameter.getSize());
    }
    private Predicate<PartnerUniversity> byDepartmentURL(String departmentURL) {
        return p -> (departmentURL.isEmpty() || p.getName().equals(departmentURL) );
    }
    // ByContactPerson
    @Override
    public CollectionModelResult<PartnerUniversity> readByContactPerson(String contactPerson, SearchParameter searchParameter) {
        return InMemoryPaging.page(this.readAllByPredicate(
                byContactPerson(contactPerson),
                searchParameter
        ), searchParameter.getOffset(), searchParameter.getSize());
    }
    private Predicate<PartnerUniversity> byContactPerson(String contactPerson) {
        return p -> (contactPerson.isEmpty() || p.getName().equals(contactPerson) );
    }
    // ByOutgoingStudents
    @Override
    public CollectionModelResult<PartnerUniversity> readByOutgoingStudents(int outgoingStudents, SearchParameter searchParameter) {
        return InMemoryPaging.page(this.readAllByPredicate(
                byOutgoingStudents(outgoingStudents),
                searchParameter
        ), searchParameter.getOffset(), searchParameter.getSize());
    }


    private Predicate<PartnerUniversity> byOutgoingStudents(Integer outgoingStudents) {
        return p -> (outgoingStudents.toString().isEmpty()  || p.getOutgoingStudents() == outgoingStudents);
    }
    // ByIncomingStudents
    @Override
    public CollectionModelResult<PartnerUniversity> readByIncomingStudents(int incomingStudents, SearchParameter searchParameter) {
        return InMemoryPaging.page(this.readAllByPredicate(
                byIncomingStudents(incomingStudents),
                searchParameter
        ), searchParameter.getOffset(), searchParameter.getSize());
    }


    private Predicate<PartnerUniversity> byIncomingStudents(Integer incomingStudents) {
        return p -> (incomingStudents.toString().isEmpty()  || p.getOutgoingStudents() == incomingStudents);
    }
    // ByStartSpringSemester
    // ByStartAutumnSemester


}
