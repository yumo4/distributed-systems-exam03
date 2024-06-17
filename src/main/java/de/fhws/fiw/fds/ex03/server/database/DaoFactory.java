package de.fhws.fiw.fds.ex03.server.database;

import de.fhws.fiw.fds.ex03.server.api.models.Module;
import de.fhws.fiw.fds.ex03.server.database.inmemory.ModuleStorage;
import de.fhws.fiw.fds.ex03.server.database.inmemory.PartnerUniversityModuleStorage;
import de.fhws.fiw.fds.ex03.server.database.inmemory.PartnerUniversityStorage;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.sutton.server.database.results.NoContentResult;
import de.fhws.fiw.fds.sutton.server.database.results.SingleModelResult;

public class DaoFactory {
    private static DaoFactory INSTANCE;



    public static DaoFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DaoFactory();
        }

        return INSTANCE;
    }

    private final PartnerUniversityDao partnerUniversityDao;
    private final ModuleDao moduleDao;
    private final PartnerUniversityModuleDao partnerUniversityModuleDao;


    private DaoFactory(){
        this.partnerUniversityDao = new PartnerUniversityStorage();
        this.moduleDao = new ModuleStorage();
        this.partnerUniversityModuleDao = new PartnerUniversityModuleStorage(this.moduleDao);
    }

    public PartnerUniversityDao getPartnerUniversityDao() {
        return this.partnerUniversityDao;
    }

    public ModuleDao getModuleDao() {
        return this.moduleDao;
    }

    public PartnerUniversityModuleDao getPartnerUniversityModuleDao() {
//        return this.partnerUniversityModuleDao;
        return partnerUniversityModuleDao;
    }
}
