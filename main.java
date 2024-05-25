import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCCalculator extends JFrame {
    private JTextField pesoField;
    private JTextField alturaField;
    private JLabel resultadoLabel;

    public IMCCalculator() {
        setTitle("Calculadora de IMC");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        JLabel pesoLabel = new JLabel("Peso (Kg):");
        pesoField = new JTextField();
        JLabel alturaLabel = new JLabel("Altura (Cm):");
        alturaField = new JTextField();
        JButton calcularButton = new JButton("Calcular");
        resultadoLabel = new JLabel("");

        add(pesoLabel);
        add(pesoField);
        add(alturaLabel);
        add(alturaField);
        add(calcularButton);
        add(new JLabel(""));
        add(resultadoLabel);

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(pesoField.getText());
            double alturaCm = Double.parseDouble(alturaField.getText());
            double alturaM = alturaCm / 100;

            double imc = peso / (alturaM * alturaM);

            String classificacao;
            if (imc < 18.5) {
                classificacao = "Abaixo do peso";
            } else if (imc < 24.9) {
                classificacao = "Peso normal";
            } else if (imc < 29.9) {
                classificacao = "Sobrepeso";
            } else {
                classificacao = "Obesidade";
            }

            resultadoLabel.setText(String.format("IMC: %.2f - %s", imc, classificacao));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IMCCalculator().setVisible(true);
            }
        });
    }
}