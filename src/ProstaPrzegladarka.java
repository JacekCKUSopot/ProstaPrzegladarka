import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProstaPrzegladarka extends JFrame {
    private JLabel lblAdres;
    private JTextField txtAdres;
    private JButton btnPrzejdz;
    private JLabel lblZawartoscStrony;
    private JLabel lblStatus;

    public ProstaPrzegladarka() {

        setTitle("Prosta Przeglądarka (BorderLayout)");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5, 5));

        // NORTH: panel z etykietą „Adres:" i polem tekstowym na adres URL oraz przyciskiem „Przejdź"
        // definiujemy panel, który znajdzie się w rejonie NORTH
        JPanel panel = new JPanel();
        panel.setBackground(new Color(220, 230, 242)); // Kolor jasnoniebieski dla panelu
        add(panel, BorderLayout.NORTH);

        // Definiujemy kontrolki dla panelu
        lblAdres = new JLabel("Adres: ");
        txtAdres = new JTextField(10);
        btnPrzejdz = new JButton("Przejdź");

        // CENTER: etykieta wyświetlająca tekst „Zawartość strony: [tu adres]" po kliknięciu „Przejdź"
        lblZawartoscStrony = new JLabel("Zawartość strony:", SwingConstants.CENTER);
        add(lblZawartoscStrony, BorderLayout.CENTER);

        // SOUTH: etykieta statusu wyświetlająca „Załadowano: " + wpisany adres lub błąd, gdy pole jest puste
        lblStatus = new JLabel("Załadowano:", SwingConstants.CENTER);
        add(lblStatus, BorderLayout.SOUTH);

        // dodajemy kontrolki do panelu
        panel.add(lblAdres);
        panel.add(txtAdres);
        panel.add(btnPrzejdz);

        btnPrzejdz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String adres = txtAdres.getText().trim();
                    if (adres.isEmpty()) {
                        throw new Exception("Błąd:");
                    }
                    lblZawartoscStrony.setText("Zawartość strony: [" + adres + "]");
                    lblStatus.setText("Załadowano: " + adres);
                    txtAdres.setText("");
                } catch (Exception ex) {
                    lblStatus.setText(ex.getMessage() + " pole nie może być puste");
                    lblZawartoscStrony.setText("Zawartość strony:");
                }
                // Wymuszenie fokusu na polu tekstowym
                txtAdres.requestFocusInWindow();
            }
        });

        setVisible(true);

    }

    public static void main(String[] args) {
        new ProstaPrzegladarka();
    }
}