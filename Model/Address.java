package Model;

public class Address {
    private final String vorname;
    private final String nachname;
    private String adresse;
    private String plz;
    private String stadt;
    private String telefonnummer;

    public Address(String vorname, String nachname, String adresse, String plz, String stadt, String telefonnummer) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.plz = plz;
        this.stadt = stadt;
        this.telefonnummer = telefonnummer;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getPlz() {
        return plz;
    }

    public String getStadt() {
        return stadt;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s, %s %s, %s", vorname, nachname, adresse, plz, stadt, telefonnummer);
    }
}
