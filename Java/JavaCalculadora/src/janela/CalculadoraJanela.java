package janela;

import constants.ConstantesDef;

import javax.swing.*;

import botoes.CalculadoraBotoes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraJanela extends JFrame implements ActionListener {
    private final SpringLayout springLayout = new SpringLayout();
    private CalculadoraBotoes calculatorService;

    // display field
    private JTextField displayField;

    // buttons
    private JButton[] buttons;

    // flags
    private boolean pressedOperator = false;
    private boolean pressedEquals = false;

    public CalculadoraJanela(){
        super(ConstantesDef.APP_NAME);
        setSize(ConstantesDef.APP_SIZE[0], ConstantesDef.APP_SIZE[1]);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(springLayout);

        calculatorService = new CalculadoraBotoes();

        addGuiComponents();
    }

    public void addGuiComponents(){
        // add display components
        addDisplayFieldComponents();

        // add button components
        addButtonComponents();
    }

    public void addDisplayFieldComponents(){
        JPanel displayFieldPanel = new JPanel();
        displayField = new JTextField(ConstantesDef.TEXTFIELD_LENGTH);
        displayField.setFont(new Font("Dialog", Font.PLAIN, ConstantesDef.TEXTFIELD_FONTSIZE));
        displayField.setEditable(false);
        displayField.setText("0");
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);

        displayFieldPanel.add(displayField);

        this.getContentPane().add(displayFieldPanel);
        springLayout.putConstraint(SpringLayout.NORTH, displayFieldPanel, ConstantesDef.TEXTFIELD_SPRINGLAYOUT_NORTHPAD, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.WEST, displayFieldPanel, ConstantesDef.TEXTFIELD_SPRINGLAYOUT_WESTPAD, SpringLayout.WEST, this);
    }

    public void addButtonComponents(){
        GridLayout gridLayout = new GridLayout(ConstantesDef.BUTTON_ROWCOUNT, ConstantesDef.BUTTON_COLCOUNT);
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(gridLayout);
        buttons = new JButton[ConstantesDef.BUTTON_COUNT];
        for(int i = 0; i < ConstantesDef.BUTTON_COUNT; i++){
            JButton button = new JButton(getButtonLabel(i));
            button.setFont(new Font("Dialog", Font.PLAIN, ConstantesDef.BUTTON_FONTSIZE));
            button.addActionListener(this);

            buttonPanel.add(button);
        }

        gridLayout.setHgap(ConstantesDef.BUTTON_HGAP);
        gridLayout.setVgap(ConstantesDef.BUTTON_VGAP);

        this.getContentPane().add(buttonPanel);

        springLayout.putConstraint(SpringLayout.NORTH, buttonPanel, ConstantesDef.BUTTON_SPRINGLAYOUT_NORTHPAD, SpringLayout.NORTH, this);
        springLayout.putConstraint(SpringLayout.WEST, buttonPanel, ConstantesDef.BUTTON_SPRINGLAYOUT_WESTPAD, SpringLayout.WEST, this);
    }
    public String getButtonLabel(int buttonIndex){
        switch(buttonIndex){
            case 0:
                return "7";
            case 1:
                return "8";
            case 2:
                return "9";
            case 3:
                return "/";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "x";
            case 8:
                return "1";
            case 9:
                return "2";
            case 10:
                return "3";
            case 11:
                return "-";
            case 12:
                return "0";
            case 13:
                return ".";
            case 14:
                return "+";
            case 15:
                return "=";
        }
        return "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonCommand = e.getActionCommand();
        if(buttonCommand.matches("[0-9]")){
            if(pressedEquals || pressedOperator || displayField.getText().equals("0"))
                displayField.setText(buttonCommand);
            else
                displayField.setText(displayField.getText() + buttonCommand);

            // update flags
            pressedOperator = false;
            pressedEquals = false;
        }else if(buttonCommand.equals("=")){
            // calculate
            calculatorService.setNum2(Double.parseDouble(displayField.getText()));

            double result = 0;
            switch(calculatorService.getMathSymbol()){
                case '+':
                    result = calculatorService.add();
                    break;
                case '-':
                    result = calculatorService.subtract();
                    break;
                case '/':
                    result = calculatorService.divide();
                    break;
                case 'x':
                    result = calculatorService.multiply();
                    break;
            }

            // update the display field
            displayField.setText(Double.toString(result));

            // update flags
            pressedEquals = true;
            pressedOperator = false;

        }else if(buttonCommand.equals(".")){
            if(!displayField.getText().contains(".")){
                displayField.setText(displayField.getText() + buttonCommand);
            }
        }else{ // operator
            if(!pressedOperator)
                calculatorService.setNum1(Double.parseDouble(displayField.getText()));

            calculatorService.setMathSymbol(buttonCommand.charAt(0));

            // update flags
            pressedOperator = true;
            pressedEquals = false;
        }
    }
}
