import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NowySamochodGUI extends JFrame {
    private JPanel panel;
    private JButton dodajButton;
    private JButton anulujButton;
    private JTextField nrRejestracyjny;
    private JTextField model;
    private JTextField marka;
    private JRadioButton a5BiegowManualnaRadioButton;
    private JRadioButton a6BiegowManualnaRadioButton;
    private JRadioButton benzynaRadioButton;
    private JRadioButton dieselRadioButton;
    private JTextField maxPredkosc;

    public NowySamochodGUI(JComboBox comboBox1)  {
        setContentPane(panel);

        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (isAllSet()) {
                    int iloscBiegow = 0;
                    int maxPredk;
                    int maxObr = 0;
                    int wagaSkrz = 0;
                    int wagaSiln = 0;
                    int cenaSkrz = 0;
                    int cenaSiln = 0;
                    String typSilnika = "";
                    String typSkrzyni = "";
                    if(a5BiegowManualnaRadioButton.isSelected()) {
                        iloscBiegow = 5;
                        wagaSkrz = 50;
                        cenaSkrz = 1000;
                        typSkrzyni = "5 biegowa";
                    }
                    else if(a6BiegowManualnaRadioButton.isSelected()) {
                        iloscBiegow = 6;
                        wagaSkrz = 60;
                        cenaSkrz = 1200;
                        typSkrzyni = "6 biegowa";
                    }
                    if(benzynaRadioButton.isSelected()){
                        typSilnika = "Benzyna";
                        maxObr = 6000;
                        wagaSiln = 100;
                        cenaSiln = 10000;
                    }
                    else if(dieselRadioButton.isSelected()){
                        typSilnika = "Diesel";
                        maxObr = 5000;
                        wagaSiln = 120;
                        cenaSiln = 12000;
                    }
                    try {
                        if(Integer.parseInt(maxPredkosc.getText()) < 0) {
                            maxPredk = -Integer.parseInt(maxPredkosc.getText());
                        } else {
                            maxPredk = Integer.parseInt(maxPredkosc.getText());
                        }
                    } catch (NumberFormatException nfe) {
                        return;
                    }
                    Sprzeglo sprzeglo = new Sprzeglo("Sprzeglo", 20, 1000);
                    Silnik silnik = new Silnik(typSilnika, wagaSiln, cenaSiln, maxObr);
                    SkrzyniaBiegow skrzynia = new SkrzyniaBiegow(typSkrzyni, wagaSkrz, cenaSkrz, iloscBiegow, sprzeglo);
                    Pozycja pozycjaStart = new Pozycja(5, 10);
                    Samochod samochod = new Samochod(nrRejestracyjny.getText(), model.getText(), maxPredk, silnik, skrzynia, marka.getText(), pozycjaStart);

                    comboBox1.addItem(samochod);
                    setClear();
                }
            }
        });
        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                setClear();
            }
        });
    }

    public boolean isAllSet() {
        if(nrRejestracyjny.getText().equals("") || model.getText().equals("") || marka.getText().equals("")) {
            return false;
        }
        if(!benzynaRadioButton.isSelected() && !dieselRadioButton.isSelected()) {
            return false;
        }
        if(!a5BiegowManualnaRadioButton.isSelected() && !a6BiegowManualnaRadioButton.isSelected()){
            return false;
        }
        if(maxPredkosc.getText().equals("")) {
            return false;
        }
        return true;
    }

    public void setClear() {
        model.setText("");
        marka.setText("");
        nrRejestracyjny.setText("");
        maxPredkosc.setText("");
        a5BiegowManualnaRadioButton.setSelected(false);
        a6BiegowManualnaRadioButton.setSelected(false);
        dieselRadioButton.setSelected(false);
        benzynaRadioButton.setSelected(false);
    }


}
