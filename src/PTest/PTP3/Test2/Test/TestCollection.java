package PTest.PTP3.Test2.Test;

import PTP_POO.PTP3.Model.CollectionTimbre;
import PTP_POO.PTP3.Model.Timbre;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class TestCollection {

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
    public void TestWrite(){
        ArrayList<Timbre> arrayList = new ArrayList<>();
        CollectionTimbre coll = new CollectionTimbre(arrayList);
        coll.recupCollection();
        System.out.println(coll);
    }
}
