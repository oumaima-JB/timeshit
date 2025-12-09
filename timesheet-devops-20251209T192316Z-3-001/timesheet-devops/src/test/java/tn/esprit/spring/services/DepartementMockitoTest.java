package tn.esprit.spring.services;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class DepartementMockitoTest {

    @Mock
    private Employe mockEmploye1;

    @Mock
    private Employe mockEmploye2;

    @Mock
    private Entreprise mockEntreprise;

    @InjectMocks
    private Departement departement = new Departement();

    @Test
    @Order(1)
    void testCreateDepartement() {
        departement.setId(1L);
        departement.setName("Informatique");

        log.info("Création d'un département : id={}, name={}",
                departement.getId(), departement.getName());

        Assertions.assertEquals(1L, departement.getId());
        Assertions.assertEquals("Informatique", departement.getName());
    }

    @Test
    @Order(2)
    void testEntrepriseRelation() {
        departement.setEntreprise(mockEntreprise);

        log.info("Association d'une entreprise au département");

        Assertions.assertEquals(mockEntreprise, departement.getEntreprise());
    }

    @Test
    @Order(3)
    void testEmployesRelation() {
        List<Employe> employeList = List.of(mockEmploye1, mockEmploye2);
        departement.setEmployes(employeList);

        log.info("Ajout de 2 employés dans le département");

        Assertions.assertEquals(2, departement.getEmployes().size());
        Assertions.assertTrue(departement.getEmployes().contains(mockEmploye1));
        Assertions.assertTrue(departement.getEmployes().contains(mockEmploye2));
    }

    @Test
    @Order(4)
    void testModifyFields() {
        departement.setName("RH");

        log.info("Modification du département en name={}", departement.getName());

        Assertions.assertEquals("RH", departement.getName());
    }

    @Test
    @Order(5)
    void testMockitoInteractions() {
        when(mockEntreprise.toString()).thenReturn("FakeEntreprise");

        departement.setEntreprise(mockEntreprise);
        String str = departement.getEntreprise().toString();
        log.info("Test toString Entreprise : {}", str);

        Assertions.assertEquals("FakeEntreprise", str);
        // ✅ plus de verify sur toString()
    }
}
