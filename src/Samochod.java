public class Samochod extends Thread{

    private boolean stanWlaczenia;
    private final String nrRejest;
    private final String model;
    private final Integer maxPredkosc;
    private final Silnik silnik;
    private final SkrzyniaBiegow skrzynia;
    private final String marka;
    private double V;
    private Pozycja cel;
    private final Pozycja pozycja;

    public Samochod(String nrRejest, String model, Integer maxPredkosc, Silnik silnik, SkrzyniaBiegow skrzynia, String marka, Pozycja pozycja) {
        this.nrRejest = nrRejest;
        this.model = model;
        this.maxPredkosc = maxPredkosc;
        this.silnik = silnik;
        this.skrzynia = skrzynia;
        this.marka = marka;
        this.pozycja = pozycja;
        this.cel = pozycja;
        this.start();
    }

    @Override
    public void run() {
        V = 0;
        while(true) {
            if (pozycja.getX() != cel.getX() || pozycja.getY()  != cel.getY()) {
                setAktPredkosc();
                pozycja.przemiesc(V, 200, cel);
                System.out.println("V: " + V + "\tX: " + pozycja.getX() + "\tY: " + pozycja.getY());
            }
            if (pozycja.getX() == cel.getX() && pozycja.getY()  == cel.getY()) {
                V = 0;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void wlacz() {
        this.stanWlaczenia = true;
        this.silnik.uruchom();
    }
    public void wylacz() {
        this.stanWlaczenia = false;
        this.silnik.zatrzymaj();
    }
    public void wcisnijSprzeglo() {
        if(this.stanWlaczenia)
            this.skrzynia.getSprzeglo().wcisnij();
    }
    public void zwolnijSprzeglo() {
        if(this.stanWlaczenia)
            this.skrzynia.getSprzeglo().zwolnij();
    }
    public void zmniejszBieg() {
        if(this.stanWlaczenia)
            this.skrzynia.zmniejszBieg();
    }
    public void zwiekszBieg() {
        if(this.stanWlaczenia)
            this.skrzynia.zwiekszBieg();
    }
    public void dodajGazu() {
        if(this.stanWlaczenia)
            this.silnik.zwiekszObroty();
    }
    public void ujmijGazu() {
        if(this.stanWlaczenia)
            this.silnik.zmniejszObroty();
    }

    public void jedzDo(Pozycja nowyCel) {
        if(this.stanWlaczenia)
            this.cel = nowyCel;
    }

    public boolean getStan() { return stanWlaczenia; }
    public String getNrRejest() { return nrRejest; }
    public String getModel() { return model; }
    public Integer getMaxPredkosc() { return maxPredkosc; }
    public Silnik getSilnik() { return silnik; }
    public SkrzyniaBiegow getSkrzynia() { return skrzynia; }
    public Pozycja getAktPozycja() { return pozycja; }
    public Integer getWaga() { return skrzynia.getWaga() + silnik.getWaga(); }
    public double getPredkosc() { return V; };

    public void setAktPredkosc() {
        double V = silnik.getObroty()/60 * skrzynia.getAktPrzelozenie() * Math.PI * 0.4572;
        if (skrzynia.getSprzeglo().getStanSprzegla()) {
            this.V = getPredkosc();
        }
        if (V > maxPredkosc) {
            this.V = maxPredkosc;
        }
        this.V = V;
    }

    @Override
    public String toString() {
        return nrRejest + ',' + model + "," + marka;
    }

}