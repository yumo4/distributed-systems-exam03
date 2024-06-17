package de.fhws.fiw.fds.ex03.server.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import de.fhws.fiw.fds.sutton.server.api.hyperlinks.Link;
import de.fhws.fiw.fds.sutton.server.api.hyperlinks.annotations.SecondarySelfLink;
import de.fhws.fiw.fds.sutton.server.api.hyperlinks.annotations.SelfLink;
import de.fhws.fiw.fds.sutton.server.models.AbstractModel;
import jakarta.xml.bind.annotation.XmlRootElement;

@JsonRootName("module")
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "module")
public class Module extends AbstractModel{
    private String moduleName;
    private int moduleSemester;
    private int moduleCreditPoints;

    @SecondarySelfLink(
            primaryPathElement = "partneruniversities",
            secondaryPathElement = "modules"
    )
    private transient Link selfLinkOnSecond;

    @SelfLink(pathElement = "modules")
    private transient Link selfLink;

    public Module() {
        // make JPA happy
    }

    public Module(String moduleName, int moduleSemester, int moduleCreditPoints) {
        this.moduleName = moduleName;
        this.moduleSemester = moduleSemester;
        this.moduleCreditPoints = moduleCreditPoints;
    }


    public Link getSelfLinkOnSecond() {
        return selfLinkOnSecond;
    }

    public void setSelfLinkOnSecond(final Link selfLinkOnSecond) {
        this.selfLinkOnSecond = selfLinkOnSecond;
    }

    public Link getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(final Link selfLink) {
        this.selfLink = selfLink;
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

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", modulename='" + moduleName + '\'' +
                ", semester=" + moduleSemester +
                ", creditPoints=" + moduleCreditPoints +
                '}';
    }
}
