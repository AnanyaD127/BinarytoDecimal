import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    private JFrame frame;
    private JPanel mainPanel;
    private JTextField binaryTextField;
    private JTextField decimalTextField;
    private JButton convertButton;

    public App() {
        frame = new JFrame("Binary to Decimal Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        mainPanel = new JPanel(new GridLayout(3, 1));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        binaryTextField = new JTextField();
        binaryTextField.setHorizontalAlignment(JTextField.CENTER);

        decimalTextField = new JTextField();
        decimalTextField.setEditable(false);
        decimalTextField.setHorizontalAlignment(JTextField.CENTER);

        convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertBinaryToDecimal();
            }
        });

        mainPanel.add(binaryTextField);
        mainPanel.add(convertButton);
        mainPanel.add(decimalTextField);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void convertBinaryToDecimal() {
        String binaryInput = binaryTextField.getText().trim();

        try {
            // Convert binary string to decimal
            long decimalValue = Long.parseLong(binaryInput, 2);
            decimalTextField.setText(String.valueOf(decimalValue));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid binary input. Please enter a valid binary number.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            binaryTextField.setText("");
            decimalTextField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}
