abstract public class Komponent {
    private final String nazwa;
    private final Integer waga;
    private final Integer cena;


    public Komponent(String nazwa, int waga, int cena) {
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }
    public Integer getWaga() {
        return waga;
    }
    public Integer getCena() {
        return cena;
    }

}
