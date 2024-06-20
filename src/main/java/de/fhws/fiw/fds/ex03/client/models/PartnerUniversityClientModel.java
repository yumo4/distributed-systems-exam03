package de.fhws.fiw.fds.ex03.client.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.fhws.fiw.fds.sutton.client.converters.ClientLinkJsonConverter;
import de.fhws.fiw.fds.sutton.client.model.AbstractClientModel;
import de.fhws.fiw.fds.sutton.client.utils.Link;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDate;
import java.util.List;

@XmlRootElement
public class PartnerUniversityClientModel extends AbstractClientModel{
    private String name;
    private String country;
    private String departmentName;
    private String departmentURL;
    private String contactPerson;
    private int outgoingStudents; // >= 1
    private int incomingStudents; // >= 1

    private LocalDate springSemesterStart;
    private LocalDate autumnSemesterStart;
    private List<ModuleClientModel> moduleClientModels;

    @JsonDeserialize(using = ClientLinkJsonConverter.class)
    private Link selfLink;

    @JsonDeserialize(using = ClientLinkJsonConverter.class)
    private Link location;

    public PartnerUniversityClientModel() {
    }

    public PartnerUniversityClientModel(String name, String country, String departmentName, String departmentURL, String contactPerson, int outgoingStudents, int incomingStudents, LocalDate springSemesterStart, LocalDate autumnSemesterStart, List<ModuleClientModel> moduleClientModels) {
        this.name = name;
        this.country = country;
        this.departmentName = departmentName;
        this.departmentURL = departmentURL;
        this.contactPerson = contactPerson;
        this.outgoingStudents = outgoingStudents;
        this.incomingStudents = incomingStudents;
        this.springSemesterStart = springSemesterStart;
        this.autumnSemesterStart = autumnSemesterStart;
        this.moduleClientModels = moduleClientModels;
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

    public List<ModuleClientModel> getModules() {
        return moduleClientModels;
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

    public void setModules(List<ModuleClientModel> moduleClientModels) {
        this.moduleClientModels = moduleClientModels;
    }

    @JsonIgnore
    public Link getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(Link selfLink) {
        this.selfLink = selfLink;
    }

    @JsonIgnore
    public Link getLocation() {
        return location;
    }

    public void setLocation(Link location) {
        this.location = location;
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
                ", modules=" + moduleClientModels +
                '}';
    }

}
