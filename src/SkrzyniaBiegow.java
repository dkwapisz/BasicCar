public class SkrzyniaBiegow extends Komponent{
    private Integer aktualnyBieg = 1;
    private final Integer iloscBiegow;
    private double aktualnePrzelozenie = 1.5;
    private Sprzeglo sprzeglo;

    public SkrzyniaBiegow(String nazwa, Integer waga, Integer cena, Integer iloscBiegow, Sprzeglo sprzeglo) {
        super(nazwa, waga, cena);
        this.iloscBiegow = iloscBiegow;
        this.sprzeglo = sprzeglo;
    }

    public Sprzeglo getSprzeglo() {
        return sprzeglo;
    }

    public void zwiekszBieg() {
        if (aktualnyBieg + 1 <= iloscBiegow) {
            aktualnyBieg = aktualnyBieg + 1;
            aktualnePrzelozenie = aktualnePrzelozenie + 0.3;
            if (aktualnyBieg == 1) {
                aktualnePrzelozenie = 1.2;
            }
        }
    }

    public void zmniejszBieg() {
        if (aktualnyBieg - 1 >= 0) {
            aktualnyBieg = aktualnyBieg - 1;
            aktualnePrzelozenie = aktualnePrzelozenie - 0.3;
            if (aktualnyBieg == 0) {
                aktualnePrzelozenie = 0;
            }
        }
    }

    public Integer getIloscBiegow() { return iloscBiegow; }
    public Integer getAktBieg() { return aktualnyBieg; }
    public double getAktPrzelozenie() { return aktualnePrzelozenie; }
}
