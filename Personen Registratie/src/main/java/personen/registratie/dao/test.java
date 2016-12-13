package personen.registratie.dao;

import personen.registratie.entity.Persoon;
import personen.registratie.service.PersoonService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by abhoendie on 11/30/2016.
 */
public class test {
    public static void main(String[] args) throws SQLException {
        PersoonService persoonService = new PersoonService();
        Persoon output = persoonService.selectPersonRecord(6);

        System.out.println(output.getPersoonId() + " | " + output.getNaam()+ " | " + output.getVoornaam() + " | " + output.getAdress() + " | "
        + output.getGeboorteDatum());


       /* List<Persoon> persoonx = persoonService.selectAll();
        for (Persoon persooninsert : persoonx) {

            System.out.println(persooninsert.getPersoonId()+ " | " + persooninsert.getNaam()+ " | " + persooninsert.getVoornaam()+ " | " + persooninsert.getAdress()+ " | " + persooninsert.getGeboorteDatum());
        }
*/

    }
}
