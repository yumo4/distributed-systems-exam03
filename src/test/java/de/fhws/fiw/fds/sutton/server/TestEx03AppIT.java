package de.fhws.fiw.fds.sutton.server;
import com.github.javafaker.Faker;
import de.fhws.fiw.fds.ex03.client.models.ModuleClientModel;
import de.fhws.fiw.fds.ex03.client.models.PartnerUniversityClientModel;
import de.fhws.fiw.fds.ex03.client.rest.Ex03RestClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEx03AppIT {
    final private Faker faker = new Faker();
    private Ex03RestClient client;

    @BeforeEach
    public void setUp() throws IOException{
        this.client = new Ex03RestClient();
        this.client.resetDatabase();
    }

    @Test
    public void test_dispatcher_is_available() throws IOException {
        client.start();
        assertEquals(200, client.getLastStatusCode());
        // changing BASE_URL  & CONTEXT_PATH and then running tests doesnt work -> i have to restart START
    }

    @Test
    public void test_dispatcher_is_get_all_partneruniversities_allowed() throws IOException {
        client.start();
        assertTrue(client.isGetAllPartnerUniversitiesAllowed());
    }

    @Test
    public void test_create_partneruniversity_is_create_partneruniversity_allowed() throws IOException {
        client.start();
        assertTrue(client.isCreatePartnerUniversityAllowed());
    }

    @Test void test_create_partneruniversity() throws IOException
    {
        client.start();
        var moduleList = new ArrayList<ModuleClientModel>();
        var testModule = new ModuleClientModel();
        testModule.setModuleName("Test Module");
        testModule.setModuleSemester(1);
        testModule.setModuleCreditPoints(5);
        moduleList.add(testModule);

        var pu = new PartnerUniversityClientModel();
        pu.setName("Test University");
        pu.setCountry("Test Country");
        pu.setDepartmentName("Test Department");
        pu.setDepartmentURL("test-department.test-university.com");
        pu.setContactPerson("Contact Test");
        pu.setOutgoingStudents(5);
        pu.setIncomingStudents(5);
        pu.setSpringSemesterStart(LocalDate.of( 2024, 3, 1));
        pu.setAutumnSemesterStart(LocalDate.of( 2024, 9, 1));
        pu.setModules(moduleList);


        client.createPartnerUniversity(pu);
        assertEquals(201, client.getLastStatusCode());
    }

    @Test void test_create_partneruniversity_and_get_new_partneruniversity() throws IOException
    {
        client.start();

        var moduleList = new ArrayList<ModuleClientModel>();
        var testModule = new ModuleClientModel();
        testModule.setModuleName("Test Module");
        testModule.setModuleSemester(1);
        testModule.setModuleCreditPoints(5);
        moduleList.add(testModule);

        var pu = new PartnerUniversityClientModel();
        pu.setName("Test University");
        pu.setCountry("Test Country");
        pu.setDepartmentName("Test Department");
        pu.setDepartmentURL("test-department.test-university.com");
        pu.setContactPerson("Contact Person");
        pu.setOutgoingStudents(5);
        pu.setIncomingStudents(5);
        pu.setSpringSemesterStart(LocalDate.of( 2024, 3, 1));
        pu.setAutumnSemesterStart(LocalDate.of( 2024, 9, 1));
        pu.setModules(moduleList);

        client.createPartnerUniversity(pu);
        assertEquals(201, client.getLastStatusCode());
        assertTrue( client.isGetSinglePartnerUniversityAllowed());

        client.getSinglePartnerUniversity();
        assertEquals(200, client.getLastStatusCode());

        var puFromServer = client.partnerUniversityData().getFirst();
        assertEquals( "Test University", puFromServer.getName());
        assertEquals( "Test Country", puFromServer.getCountry());
        assertEquals( "Test Department", puFromServer.getDepartmentName());
        assertEquals( "test-department.test-university.com", puFromServer.getDepartmentURL() );
        assertEquals( "Contact Person", puFromServer.getContactPerson());
        assertEquals( 5, puFromServer.getOutgoingStudents());
        assertEquals( 5, puFromServer.getIncomingStudents());
        assertEquals(LocalDate.of(2024,3,1), puFromServer.getSpringSemesterStart() );
        assertEquals(LocalDate.of(2024,9,1), puFromServer.getAutumnSemesterStart() );
        assertEquals("Test Module", puFromServer.getModules().getFirst().getModuleName());
        assertEquals(1, puFromServer.getModules().getFirst().getModuleSemester());
        assertEquals(5, puFromServer.getModules().getFirst().getModuleCreditPoints());
    }

    @Test void test_create_5_partneruniversities_and_get_all() throws IOException
    {
        for( int i=0; i<5; i++ ) {
            client.start();

            var pu = new PartnerUniversityClientModel();
            pu.setName(faker.name().name());
            pu.setCountry(faker.country().countryCode2());
            pu.setDepartmentName(faker.commerce().department());
            pu.setDepartmentURL(faker.internet().url());
            pu.setContactPerson(faker.name().name());
            pu.setOutgoingStudents(faker.number().numberBetween(1,25));
            pu.setIncomingStudents(faker.number().numberBetween(1,25));
            pu.setSpringSemesterStart(LocalDate.of(2024, 3, 1));
            pu.setAutumnSemesterStart(LocalDate.of(2024, 9, 1));

            client.createPartnerUniversity(pu);
            assertEquals(201, client.getLastStatusCode());
        }

        client.start();
        assertTrue( client.isGetAllPartnerUniversitiesAllowed() );

        client.getAllPartneruniversities();
        assertEquals(200, client.getLastStatusCode());
        assertEquals(5, client.partnerUniversityData().size());

        client.setPartnerUniversityCursor(0);
        client.getSinglePartnerUniversity();
        assertEquals(200, client.getLastStatusCode());
    }

    @Test void test_update_partneruniversity_and_get_new_partneruniversity() throws IOException
    {
        client.start();

        var moduleList = new ArrayList<ModuleClientModel>();
        var testModule = new ModuleClientModel();
        testModule.setModuleName("Test Module");
        testModule.setModuleSemester(1);
        testModule.setModuleCreditPoints(5);
        moduleList.add(testModule);

        var pu = new PartnerUniversityClientModel();
        pu.setName("Test University");
        pu.setCountry("Test Country");
        pu.setDepartmentName("Test Department");
        pu.setDepartmentURL("test-department.test-university.com");
        pu.setContactPerson("Contact Person");
        pu.setOutgoingStudents(5);
        pu.setIncomingStudents(5);
        pu.setSpringSemesterStart(LocalDate.of( 2024, 3, 1));
        pu.setAutumnSemesterStart(LocalDate.of( 2024, 9, 1));
        pu.setModules(moduleList);

        client.createPartnerUniversity(pu);
        assertEquals(201, client.getLastStatusCode());
        assertTrue( client.isGetSinglePartnerUniversityAllowed());

        var pu2 = new PartnerUniversityClientModel();
        var moduleList2 = new ArrayList<ModuleClientModel>();
        var testModule2 = new ModuleClientModel();
        testModule2.setModuleName("Test Module2");
        testModule2.setModuleSemester(2);
        testModule2.setModuleCreditPoints(2);
        moduleList2.add(testModule);
        pu2.setName("Test University 2");
        pu2.setCountry("Test Country 2");
        pu2.setDepartmentName("Test Department 2");
        pu2.setDepartmentURL("test-department2.test-university2.com");
        pu2.setContactPerson("Contact Person2");
        pu2.setOutgoingStudents(3);
        pu2.setIncomingStudents(3);
        pu2.setSpringSemesterStart(LocalDate.of( 2023, 3, 15));
        pu2.setAutumnSemesterStart(LocalDate.of( 2023, 10, 1));
        pu2.setModules(moduleList2);

        client.getSinglePartnerUniversity();

        client.updatePartnerUniversity(0,pu2);
//        client.updatePartnerUniversity(1,pu2);

//        assertEquals(200, client.getLastStatusCode());
//        client.getSinglePartnerUniversity();
        assertEquals(200, client.getLastStatusCode());

        var puFromServer = client.partnerUniversityData().getFirst();
        assertEquals( "Test University2", puFromServer.getName() );
        assertEquals( "Test Country2", puFromServer.getCountry() );
        assertEquals( "Test Department2", puFromServer.getDepartmentName() );
        assertEquals( "test-department2.test-university2.com", puFromServer.getDepartmentURL() );
        assertEquals( "Contact Person2", puFromServer.getContactPerson() );
        assertEquals( 3, puFromServer.getOutgoingStudents() );
        assertEquals( 3, puFromServer.getIncomingStudents() );
        assertEquals(LocalDate.of(2023,3,15), puFromServer.getSpringSemesterStart() );
        assertEquals(LocalDate.of(2023,10,1), puFromServer.getAutumnSemesterStart() );
        assertEquals("Test Module2", puFromServer.getModules().getFirst().getModuleName());
        assertEquals(2, puFromServer.getModules().getFirst().getModuleSemester());
        assertEquals(2, puFromServer.getModules().getFirst().getModuleCreditPoints());
    }

    @Test void test_delete_partneruniversity_and_get_new_partneruniversity() throws IOException
    {
        client.start();

        var moduleList = new ArrayList<ModuleClientModel>();
        var testModule = new ModuleClientModel();
        testModule.setModuleName("Test Module");
        testModule.setModuleSemester(1);
        testModule.setModuleCreditPoints(5);
        moduleList.add(testModule);

        var pu = new PartnerUniversityClientModel();
        pu.setName("Test University");
        pu.setCountry("Test Country");
        pu.setDepartmentName("Test Department");
        pu.setDepartmentURL("test-department.test-university.com");
        pu.setContactPerson("Contact Person");
        pu.setOutgoingStudents(5);
        pu.setIncomingStudents(5);
        pu.setSpringSemesterStart(LocalDate.of( 2024, 3, 1));
        pu.setAutumnSemesterStart(LocalDate.of( 2024, 9, 1));
        pu.setModules(moduleList);

        client.createPartnerUniversity(pu);
        assertEquals(201, client.getLastStatusCode());

        client.getSinglePartnerUniversity();
        client.deletePartnerUniversity(0);
        assertEquals(204, client.getLastStatusCode());

        client.getSinglePartnerUniversity();
        assertEquals(404, client.getLastStatusCode());
    }
   // CRUD PartnerUniversitiesModules
}
