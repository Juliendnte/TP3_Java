package PTest.PTP3.Test2.Test;

import PTP_POO.PTP3.Model.CollectionTimbre;
import PTP_POO.PTP3.Model.Timbre;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCollection {

    private ArrayList<Timbre> arrayList;
    private CollectionTimbre coll;

    @Before
    public void setUp(){
        HashMap<String, String> map = new HashMap<>();
        map.put("Designation", "Timbre-poste");
        map.put("Valeur", "1 Franc");
        map.put("Dentelure", "12 x 12");
        map.put("Année","1995");
        map.put("Pays", "France");
        map.put("Oeuvre", "Portrait de Marianne");
        map.put("SignatureDessinateur", "Jean Dupont");
        arrayList = new ArrayList<>();
        arrayList.add(new Timbre(map));
        coll = new CollectionTimbre(arrayList);
    }

    @Test
    public void TesttoString(){
        assertEquals(coll.toString(),"Collection de timbres:\n" +
                "Timbre:\n" +
                "Designation: Timbre-poste\n" +
                "SignatureDessinateur: Jean Dupont\n" +
                "Année: 1995\n" +
                "Valeur: 1 Franc\n" +
                "Pays: France\n" +
                "Dentelure: 12 x 12\n" +
                "Oeuvre: Portrait de Marianne\n" +
                "\n");


    }

    @Test
    public void TestWrite(){
        coll.saveCollection();
        System.out.println(coll);
        assertEquals(coll.recupCollection(),coll.getL_timbres());
    }

}
