package de.fhws.fiw.fds.ex03;

import de.fhws.fiw.fds.sutton.server.AbstractStart;

public class Start extends AbstractStart {

    public static final String CONTEXT_PATH = "ex03";

    public static void main(String[] args) throws Exception {
        new Start().startTomcat();
    }

    @Override
    protected String contextPath() {
        return CONTEXT_PATH;
    }
}
