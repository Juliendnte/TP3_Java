package PTest.PTP3.Test2.Test;

import PTP_POO.PTP3.Model.Timbre;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;

public class TestTimbre {

    private Timbre timbre;
    private  HashMap<String, String> map;

    @Before
    public void setUp(){
        map = new HashMap<>();
        map.put("Filet", "Filet décoratif rouge");
        map.put("Facial", "Portrait de Louis Pasteur");
        map.put("Dentelure", "12 1/2 x 12 1/2");
        map.put("Pays", "France");
        map.put("Designation", "Timbre-poste ordinaire");
        map.put("Oeuvre", "Louis Pasteur en laboratoire");
        map.put("SignatureGraveur", "Albert Decaris");
        map.put("SignatureDessinateur", "Pierre Gandon");
        timbre = new Timbre(map);
    }

    @Test
    public void TestGetTimbre(){
        assertEquals(timbre.getTimbre(), map);
    }

    @Test
    public void TestUpdate(){
        timbre.update("Pays","Malte");
        assertEquals(timbre.getValTimbre("Pays"),"Malte");
    }
}
