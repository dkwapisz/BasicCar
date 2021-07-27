import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SamochodGUI extends Thread {
    private JPanel panel;
    private JTextField modelField;
    private JTextField nrRejField;
    private JTextField wagaField;
    private JTextField predField;
    private JTextField nazwaSkrzyniaField;
    private JTextField cenaSkrzyniaField;
    private JTextField wagaSkrzyniaField;
    private JTextField biegField;
    private JTextField nazwaSilnikField;
    private JTextField cenaSilnikField;
    private JTextField wagaSilnikField;
    private JTextField obrotyField;
    private JTextField nazwaSprzegloField;
    private JTextField cenaSprzegloField;
    private JTextField wagaSprzegloField;
    private JTextField stanSprzegloField;
    private JButton wlaczButton;
    private JButton wylaczButton;
    private JComboBox comboBox1;
    private JButton dodajButton;
    private JButton usunButton;
    private JButton nacisnijSprzeglo;
    private JButton zwolnijSprzeglo;
    private JButton dodajGaz;
    private JButton ujmijGaz;
    private JButton zwiekszBieg;
    private JButton zmniejszBieg;
    private JLabel samIcon;
    private JPanel mapa;
    private Samochod samochod;

    @Override
    public void run() {
        super.run();
        while(true) {
            if (samochod !=null) {
                refresh(samochod);
            }
            else {
                setClear();
            }
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public SamochodGUI() {
        wlaczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null)
                    samochod.wlacz();
                refresh(samochod);
            }
        });
        wylaczButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null)
                    samochod.wylacz();
                refresh(samochod);
            }
        });
        zmniejszBieg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null && samochod.getSkrzynia().getSprzeglo().getStanSprzegla())
                    samochod.zmniejszBieg();
                refresh(samochod);
            }
        });
        zwiekszBieg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null && samochod.getSkrzynia().getSprzeglo().getStanSprzegla())
                    samochod.zwiekszBieg();
                refresh(samochod);
            }
        });
        dodajGaz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null)
                    samochod.dodajGazu();
                refresh(samochod);
            }
        });
        ujmijGaz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null)
                    samochod.ujmijGazu();
                refresh(samochod);
            }
        });
        nacisnijSprzeglo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null)
                    samochod.wcisnijSprzeglo();
                refresh(samochod);
            }
        });
        zwolnijSprzeglo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null)
                    samochod.zwolnijSprzeglo();
                refresh(samochod);
            }
        });
        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame f = new NowySamochodGUI(comboBox1);
                f.pack();
                f.setVisible(true);
                refresh(samochod);
            }
        });
        usunButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(samochod != null)
                    samochod.interrupt();
                    comboBox1.removeItem(samochod);
                refresh(samochod);
            }
        });

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                samochod = (Samochod) comboBox1.getSelectedItem();
                refresh(samochod);
            }
        });
        mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(samochod != null) {
                    samochod.jedzDo(new Pozycja(e.getX(), e.getY()));
                }
                refresh(samochod);
            }
        });
        start();
    }

    private void refresh(Samochod samochod) {
        if(samochod != null) {
            samIcon.setVisible(true);
            modelField.setText(samochod.getModel());
            nrRejField.setText(samochod.getNrRejest());
            wagaField.setText(String.valueOf(samochod.getWaga()));
            predField.setText(String.valueOf(samochod.getPredkosc()));
            nazwaSkrzyniaField.setText(samochod.getSkrzynia().getNazwa());
            cenaSkrzyniaField.setText(String.valueOf(samochod.getSkrzynia().getCena()));
            wagaSkrzyniaField.setText(String.valueOf(samochod.getSkrzynia().getWaga()));
            biegField.setText(String.valueOf(samochod.getSkrzynia().getAktBieg()));
            nazwaSilnikField.setText(samochod.getSilnik().getNazwa());
            cenaSilnikField.setText(String.valueOf(samochod.getSilnik().getCena()));
            wagaSilnikField.setText(String.valueOf(samochod.getSilnik().getWaga()));
            obrotyField.setText(String.valueOf(samochod.getSilnik().getObroty()));
            nazwaSprzegloField.setText(samochod.getSkrzynia().getSprzeglo().getNazwa());
            cenaSprzegloField.setText(String.valueOf(samochod.getSkrzynia().getSprzeglo().getCena()));
            wagaSprzegloField.setText(String.valueOf(samochod.getSkrzynia().getSprzeglo().getWaga()));
            stanSprzegloField.setText(String.valueOf(samochod.getSkrzynia().getSprzeglo().getStanSprzegla()));
            samIcon.setLocation((int) samochod.getAktPozycja().getX(), (int) samochod.getAktPozycja().getY());
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("SamochodGUI");
        frame.setPreferredSize(new Dimension(1600, 900));
        frame.setContentPane(new SamochodGUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setClear() {
        modelField.setText("");
        nrRejField.setText("");
        wagaField.setText("");
        predField.setText("");
        nazwaSkrzyniaField.setText("");
        cenaSkrzyniaField.setText("");
        wagaSkrzyniaField.setText("");
        biegField.setText("");
        nazwaSilnikField.setText("");
        cenaSilnikField.setText("");
        wagaSilnikField.setText("");
        obrotyField.setText("");
        nazwaSprzegloField.setText("");
        cenaSprzegloField.setText("");
        wagaSprzegloField.setText("");
        stanSprzegloField.setText("");
        samIcon.setVisible(false);
    }

}