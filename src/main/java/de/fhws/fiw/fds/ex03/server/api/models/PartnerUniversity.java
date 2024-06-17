package de.fhws.fiw.fds.ex03.server.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import de.fhws.fiw.fds.sutton.server.api.hyperlinks.Link;
import de.fhws.fiw.fds.sutton.server.api.hyperlinks.annotations.SuttonLink;
import de.fhws.fiw.fds.sutton.server.models.AbstractModel;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDate;
import java.util.List;

@JsonRootName("parteruniversity")
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "partneruniversity")
public class PartnerUniversity extends AbstractModel{
    private String name;
    private String country;
    private String departmentName;
    private String departmentURL;
    private String contactPerson;
    private int outgoingStudents; // >= 1
    private int incomingStudents; // >= 1

    private LocalDate springSemesterStart;
    private LocalDate autumnSemesterStart;
    private List<Module> modules;

    @SuttonLink(
            value = "partneruniversities/${id}",
            rel = "self"
    )
    private transient Link selfLink;

    @SuttonLink(
            value = "partneruniversities/${id}/modules",
            rel = "getModulesOfParnerUniversities"
    )
    private transient Link module;

    public PartnerUniversity() {
        // make JPA happy
    }

    public PartnerUniversity(String name, String country, String departmentName, String departmentURL, String contactPerson, int outgoingStudents, int incomingStudents, LocalDate springSemesterStart, LocalDate autumnSemesterStart, List<Module> modules) {
        this.name = name;
        this.country = country;
        this.departmentName = departmentName;
        this.departmentURL = departmentURL;
        this.contactPerson = contactPerson;
        this.outgoingStudents = outgoingStudents;
        this.incomingStudents = incomingStudents;
        this.springSemesterStart = springSemesterStart;
        this.autumnSemesterStart = autumnSemesterStart;
        this.modules = modules;
    }

    public Link getSelfLink() {
        return selfLink;
    }
    public void setSelfLink(Link selfLink) {
        this.selfLink = selfLink;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentURL() {
        return departmentURL;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public int getOutgoingStudents() {
        return outgoingStudents;
    }

    public int getIncomingStudents() {
        return incomingStudents;
    }

    public LocalDate getSpringSemesterStart() {
        return springSemesterStart;
    }

    public LocalDate getAutumnSemesterStart() {
        return autumnSemesterStart;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentURL(String departmentURL) {
        this.departmentURL = departmentURL;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public void setOutgoingStudents(int outgoingStudents) {
        this.outgoingStudents = outgoingStudents;
    }

    public void setIncomingStudents(int incomingStudents) {
        this.incomingStudents = incomingStudents;
    }

    public void setSpringSemesterStart(LocalDate springSemesterStart) {
        this.springSemesterStart = springSemesterStart;
    }

    public void setAutumnSemesterStart(LocalDate autumnSemesterStart) {
        this.autumnSemesterStart = autumnSemesterStart;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return "PartnerUniversityModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentURL='" + departmentURL + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", outgoingStudents=" + outgoingStudents +
                ", incomingStudents=" + incomingStudents +
                ", springSemesterStart=" + springSemesterStart +
                ", autumnSemesterStart=" + autumnSemesterStart +
                ", modules=" + modules +
                '}';
    }
}
