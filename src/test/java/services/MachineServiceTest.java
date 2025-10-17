package services;

import org.yourcompany.yourproject.entities.*;
import org.yourcompany.yourproject.services.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MachineServiceTest {

    private MachineService machineService;
    private Machine machine;
    private Salle salle;
    private SalleService salleService;

    @BeforeAll
    void setUpAll() {
        machineService = new MachineService();
        salleService = new SalleService();
    }

    @BeforeEach
    void setUp() {
        salle = new Salle("A101");
        salleService.create(salle);

        machine = new Machine();
        machine.setRef("MACH-001");
        machine.setDateAchat(new Date());
        machine.setSalle(salle);

        machineService.create(machine);
    }

    @AfterEach
    void tearDown() {
        // Supprimer la machine si elle existe
        Machine foundMachine = machineService.findById(machine.getId());
        if (foundMachine != null) {
            machineService.delete(foundMachine);
        }

        // Supprimer la salle si elle existe
        Salle foundSalle = salleService.findById(salle.getId());
        if (foundSalle != null) {
            salleService.delete(foundSalle);
        }
    }

    @Test
    void testCreate() {
        assertNotNull(machine.getId(), "Machine should have been created with an ID");
    }

    @Test
    void testFindById() {
        Machine foundMachine = machineService.findById(machine.getId());
        assertNotNull(foundMachine, "Machine should be found");
        assertEquals(machine.getRef(), foundMachine.getRef(), "Found machine should match");
    }

    @Test
    void testUpdate() {
        machine.setRef("MACH-002");
        boolean result = machineService.update(machine);
        assertTrue(result, "Machine should be updated successfully");

        Machine updatedMachine = machineService.findById(machine.getId());
        assertEquals("MACH-002", updatedMachine.getRef(), "Updated machine ref should match");
    }

    @Test
    void testDelete() {
        boolean result = machineService.delete(machine);
        assertTrue(result, "Machine should be deleted successfully");

        Machine foundMachine = machineService.findById(machine.getId());
        assertNull(foundMachine, "Machine should not be found after deletion");
    }

    @Test
    void testFindBetweenDate() {
        List<Machine> machines = machineService.findBetweenDate(
            new Date(System.currentTimeMillis() - 86400000), // Hier
            new Date() // Aujourd'hui
        );
        assertNotNull(machines, "Machines list should not be null");
        assertTrue(machines.size() > 0, "Machines list should contain at least one machine");
    }
}
