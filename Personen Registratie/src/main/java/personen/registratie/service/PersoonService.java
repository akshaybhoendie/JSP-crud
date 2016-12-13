package personen.registratie.service;

import personen.registratie.controller.PersoonController;
import personen.registratie.dao.PersoonDao;
import personen.registratie.entity.Persoon;

import java.util.List;

/**
 * Created by abhoendie on 11/30/2016.
 */
public class PersoonService {

    PersoonDao persoonDao;

    public PersoonService() {
        persoonDao  = new PersoonDao();
    }

    public List <Persoon> selectAll(){

        return persoonDao.selectAllPerson();
    }

    public int insertPersoon(Persoon persoon){

      return persoonDao.insertPerson(persoon);
    }

    public int updatePerson(Persoon persoon){

        return persoonDao.updatePerson(persoon);
    }

    public int deletePerson(int persoonId){

        return persoonDao.deletePerson(persoonId);
    }

    public Persoon selectPersonRecord(int persoonid){

        return persoonDao.selectPersonRecord(persoonid);
    }


}
