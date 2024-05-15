package PTest.PTP3.Test1.Test;

import PTP_POO.PTP3.Model.Carte;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

public class TestCarte {

    private Carte carte;

    @Before
    public void setUp() {
        carte = new Carte("10", "pique");
    }

    @Test
    public void TestAssign(){
        Carte carte2 = new Carte("2","carreau");
        carte2.assign(carte);
        assertEquals(carte, carte2);
    }

    @Test
    public void TestString(){
        assertEquals("10 de pique",carte.toString());
    }

    @Test
    public void TestEquals(){
        Carte carte2 = new Carte("10","pique");
        assumeTrue("Les deux cartes ne sont pas égales", carte.equals(carte2));
    }

    @Test
    public void TestSetVal(){
        carte.setVal("3");
        assertEquals("3",carte.getVal());
    }

    @Test
    public void TestSetColor(){
        carte.setCouleur("pique");
        assertEquals(Carte.e_couleur.pique ,carte.getCouleur());
    }
}
