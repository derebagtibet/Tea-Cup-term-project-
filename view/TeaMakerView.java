/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author emirersan
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import composite.StateLed;
import composite.StateLedGroup;
public class TeaMakerView extends JFrame {
    private final JTextField cupsField = new JTextField(5);

    private final JButton filledButton = new JButton("FILLED");
    private final JButton startButton = new JButton("START");
    private final JButton boilButton = new JButton("BOIL WATER");
    private final JButton resetButton = new JButton("RESET");
    private final JButton totalMonthlyButton = new JButton("TOTAL CUPS (MONTH)");
    private final JButton totalDailyButton = new JButton("TOTAL CUPS (TODAY)");

    private final JLabel stateLabel = new JLabel("STATE: EMPTY");
    private final JLabel totalLabel = new JLabel("TOTAL: 0");

    private final JTextArea messageArea = new JTextArea(6, 30);
    private final JLabel emptyLed = new JLabel("EMPTY ○");
    private final JLabel idleLed = new JLabel("IDLE ○");
    private final JLabel makingLed = new JLabel("MAKING_TEA ○");
    private final JLabel boilingLed = new JLabel("BOILING_WATER ○");
    private final JLabel doneLed = new JLabel("DONE ○");

    private final StateLedGroup ledGroup = new StateLedGroup();

    public TeaMakerView() {
        super("Tea Maker");

        messageArea.setEditable(false);
        ledGroup.add(new StateLed("EMPTY", emptyLed));
        ledGroup.add(new StateLed("IDLE", idleLed));
        ledGroup.add(new StateLed("MAKING_TEA", makingLed));
        ledGroup.add(new StateLed("BOILING_WATER", boilingLed));
        ledGroup.add(new StateLed("DONE", doneLed));
        ledGroup.setActive("EMPTY");


        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Cups:"));
        topPanel.add(cupsField);
        topPanel.add(filledButton);
        topPanel.add(startButton);
        topPanel.add(boilButton);
        topPanel.add(resetButton);

        JPanel middlePanel = new JPanel(new GridLayout(3, 1));

        JPanel statePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statePanel.add(stateLabel);

        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        totalPanel.add(totalLabel);
        totalPanel.add(totalMonthlyButton);
        totalPanel.add(totalDailyButton);

        JPanel ledPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
       
        ledPanel.add(emptyLed);
        ledPanel.add(idleLed);
        ledPanel.add(makingLed);
        ledPanel.add(boilingLed);
        ledPanel.add(doneLed);

        middlePanel.add(statePanel);
        middlePanel.add(ledPanel);
        middlePanel.add(totalPanel);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(new JLabel("Messages:"), BorderLayout.NORTH);
        bottomPanel.add(new JScrollPane(messageArea), BorderLayout.CENTER);

        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        
    }

    public void showView() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }

    public String getCupsText() {
        return cupsField.getText();
    }

    public void setStateText(String state) {
    stateLabel.setText("STATE: " + state);
    setActiveLed(state);
}

    public void setTotalText(String total) {
        totalLabel.setText("TOTAL: " + total);
    }

    public void appendMessage(String message) {
        messageArea.append(message + "\n");
    }

    public JButton getFilledButton() {
        return filledButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getBoilButton() {
        return boilButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JButton getTotalMonthlyButton() {
        return totalMonthlyButton;
    }

    public JButton getTotalDailyButton() {
        return totalDailyButton;
    }
    public void setActiveLed(String stateName) {
    ledGroup.setActive(stateName);
}

    
}
