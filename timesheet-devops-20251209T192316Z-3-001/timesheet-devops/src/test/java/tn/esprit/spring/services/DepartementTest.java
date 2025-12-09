package tn.esprit.spring.services;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Entreprise;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*; // ✅ Import statique pour when(), verify(), etc.

public class DepartementTest {

    private Departement departement;
    private Employe mockEmp1;
    private Employe mockEmp2;
    private Entreprise mockEntreprise;

    @BeforeEach
    void setUp() {
        mockEmp1 = Mockito.mock(Employe.class);
        mockEmp2 = Mockito.mock(Employe.class);
        mockEntreprise = Mockito.mock(Entreprise.class);

        departement = new Departement("Informatique");
        departement.setId(1L);
        departement.setEntreprise(mockEntreprise);
        departement.setEmployes(List.of(mockEmp1, mockEmp2));
    }

    @Test
    void testBasicFieldsAssignment() {
        departement.setId(2L);
        departement.setName("RH");

        assertEquals(2L, departement.getId());
        assertEquals("RH", departement.getName());
    }

    @Test
    void testRelationships() {
        assertEquals(mockEntreprise, departement.getEntreprise());
        assertEquals(2, departement.getEmployes().size());
        assertTrue(departement.getEmployes().contains(mockEmp1));
        assertTrue(departement.getEmployes().contains(mockEmp2));

        // Changer les relations
        Entreprise newEntreprise = Mockito.mock(Entreprise.class);
        Employe newEmp = Mockito.mock(Employe.class);

        departement.setEntreprise(newEntreprise);
        departement.setEmployes(List.of(newEmp));

        assertEquals(newEntreprise, departement.getEntreprise());
        assertEquals(1, departement.getEmployes().size());
        assertEquals(newEmp, departement.getEmployes().get(0));
    }

    @Test
    void testConstructorAndToString() {
        Departement dep = new Departement("Finance");
        assertEquals("Finance", dep.getName());
        assertTrue(dep.toString().contains("Finance")); // fonctionne après override toString()
    }

    @Test
    void testMockitoInteractions() {
        when(mockEntreprise.toString()).thenReturn("FakeEntreprise");

        String str = departement.getEntreprise().toString();
        assertEquals("FakeEntreprise", str);

        // ✅ plus de verify sur toString() car Mockito ne permet pas
    }

    @Test
    void testSerialVersionUIDSerialization() throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(bos);
        out.writeObject(departement);

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bis);
        Departement deserialized = (Departement) in.readObject();

        assertEquals(departement.getName(), deserialized.getName());
    }
}
