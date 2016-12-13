package personen.registratie.entity;

/**
 * Created by abhoendie on 11/30/2016.
 */
public class Persoon {

    private int persoonId;
    private String naam;
    private String voornaam;
    private String adress;
    private String geboorteDatum;

    public int getPersoonId() {
        return persoonId;
    }

    public void setPersoonId(int persoonId) {
        this.persoonId = persoonId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getGeboorteDatum() {
        return geboorteDatum;
    }

    public void setGeboorteDatum(String geboorteDatum) {
        this.geboorteDatum = geboorteDatum;
    }


    @Override
    public String toString() {
        return "Persoon{" +
                "persoonId=" + persoonId +
                ", naam='" + naam + '\'' +
                ", voornaam='" + voornaam + '\'' +
                ", adress='" + adress + '\'' +
                ", geboorteDatum='" + geboorteDatum + '\'' +
                '}';
    }
}



