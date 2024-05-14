package PTest.PTP3.Test1.Test;

import PTP_POO.PTP3.Model.Carte;
import PTP_POO.PTP3.Model.Paquet;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

public class TestPaquet {

    private Paquet paquet;

    @Before
    public void setUp(){
        paquet = new Paquet(new ArrayList<>());
    }

    @Test
    public void add(){
        Carte carte = new Carte("4", "pique");
        paquet.add(new Carte(carte));
        assertEquals(carte, paquet.getL_cartes().getLast());
    }
}
