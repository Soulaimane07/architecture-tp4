package services;

import org.yourcompany.yourproject.entities.*;
import org.yourcompany.yourproject.services.*;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SalleServiceTest {

    private SalleService salleService;
    private Salle salle;

    @BeforeAll
    void setUpAll() {
        salleService = new SalleService();
    }

    @BeforeEach
    void setUp() {
        salle = new Salle();
        salle.setCode("A101");
        salleService.create(salle);
    }

    @AfterEach
    void tearDown() {
        Salle foundSalle = salleService.findById(salle.getId());
        if (foundSalle != null) {
            salleService.delete(foundSalle);
        }
    }

    @Test
    void testCreate() {
        assertNotNull(salle.getId(), "Salle should have been created with an ID");
    }

    @Test
    void testFindById() {
        Salle foundSalle = salleService.findById(salle.getId());
        assertNotNull(foundSalle, "Salle should be found");
        assertEquals(salle.getCode(), foundSalle.getCode(), "Found salle should match");
    }

    @Test
    void testUpdate() {
        salle.setCode("B202");
        boolean result = salleService.update(salle);
        assertTrue(result, "Salle should be updated successfully");

        Salle updatedSalle = salleService.findById(salle.getId());
        assertEquals("B202", updatedSalle.getCode(), "Updated salle code should match");
    }

    @Test
    void testDelete() {
        boolean result = salleService.delete(salle);
        assertTrue(result, "Salle should be deleted successfully");

        Salle foundSalle = salleService.findById(salle.getId());
        assertNull(foundSalle, "Salle should not be found after deletion");
    }

    @Test
    void testFindAll() {
        List<Salle> salles = salleService.findAll();
        assertNotNull(salles, "Salles list should not be null");
        assertTrue(salles.size() > 0, "Salles list should contain at least one salle");
    }
}
