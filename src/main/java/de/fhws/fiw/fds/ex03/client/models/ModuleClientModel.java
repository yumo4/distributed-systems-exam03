package de.fhws.fiw.fds.ex03.client.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.fhws.fiw.fds.sutton.client.converters.ClientLinkJsonConverter;
import de.fhws.fiw.fds.sutton.client.model.AbstractClientModel;
import de.fhws.fiw.fds.sutton.client.utils.Link;

public class ModuleClientModel extends AbstractClientModel{
    private String moduleName;
    private int moduleSemester;
    private int moduleCreditPoints;

    @JsonDeserialize(using = ClientLinkJsonConverter.class)
    private transient Link selfLinkOnSecond;

    @JsonDeserialize(using = ClientLinkJsonConverter.class)
    private transient Link selfLink;

    public ModuleClientModel(){}

    public ModuleClientModel(String moduleName, int moduleSemester, int moduleCreditPoints) {
        this.moduleName = moduleName;
        this.moduleSemester = moduleSemester;
        this.moduleCreditPoints = moduleCreditPoints;
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getModuleSemester() {
        return moduleSemester;
    }

    public int getModuleCreditPoints() {
        return moduleCreditPoints;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public void setModuleSemester(int moduleSemester) {
        this.moduleSemester = moduleSemester;
    }

    public void setModuleCreditPoints(int moduleCreditPoints) {
        this.moduleCreditPoints = moduleCreditPoints;
    }

    public Link getSelfLinkOnSecond() {
        return selfLinkOnSecond;
    }

    public void setSelfLinkOnSecond(Link selfLinkOnSecond) {
        this.selfLinkOnSecond = selfLinkOnSecond;
    }

    public Link getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(Link selfLink) {
        this.selfLink = selfLink;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", name='" + moduleName + '\'' +
                ", semester=" + moduleSemester +
                ", creditPoints=" + moduleCreditPoints +
                '}';
    }
}

