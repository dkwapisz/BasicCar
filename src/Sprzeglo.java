public class Sprzeglo extends Komponent{
    private boolean stanSprzegla;

    public Sprzeglo(String nazwa, int waga, int cena) {
        super(nazwa, waga, cena);
    }

    public boolean getStanSprzegla() {
        return stanSprzegla;
    }

    public void wcisnij() {
        stanSprzegla = true;
    }

    public void zwolnij() {
        stanSprzegla = false;
    }


}
