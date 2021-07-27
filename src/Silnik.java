public class Silnik extends Komponent {
    private final float maxObroty;
    private float obroty = 0;

    public Silnik(String nazwa, int waga, int cena, float maxObroty) {
        super(nazwa, waga, cena);
        this.maxObroty = maxObroty;
    }


    public float getMaxObroty() { return maxObroty; }
    public float getObroty() { return obroty; }

    public void uruchom() {
        obroty = 700;
    }

    public void zatrzymaj() {
        obroty = 0;
    }

    public void zwiekszObroty() {
        if (obroty + 100 <= maxObroty)
            obroty = obroty + 100;
    }

    public void zmniejszObroty() {
        if (obroty - 100 >= 0)
            obroty = obroty - 100; }
}