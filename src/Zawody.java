public class Zawody {
    private String nazwa;
    private String data;
    private Samochod[] uczestnicy;

    public String getData() { return data; }
    public String getNazwa() { return nazwa; }

    public Zawody(String nazwa, String data, Samochod[] uczestnicy) {
        this.nazwa = nazwa;
        this.data = data;
        this.uczestnicy = uczestnicy;


    }
}