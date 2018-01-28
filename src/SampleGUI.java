import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class SampleGUI extends JFrame{

    //declaration of global variables
    private JButton button1;
    private JLabel label1, label2, label3;
    private JTextField textField1, textField2;
    private JCheckBox dollarSign, commaSeparator;
    private JRadioButton addNums, subtractNums, multNums, divideNums;
    private JSlider howManyTimes;
    private double number1, number2;
    private double totalCalc;


    public static void main(String[] args) {
        new SampleGUI();
    }

    public SampleGUI(){
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel thePanel = new JPanel();

        button1 = new JButton("Calculate");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    number1 = Double.parseDouble(textField1.getText());
                    number2 = Double.parseDouble(textField2.getText());
                }catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(SampleGUI.this,
                            "Please Enter the Right Info.",
                            "Error",JOptionPane.ERROR_MESSAGE );
                }

                if (addNums.isSelected()){
                    totalCalc = addNumbers(number1, number2, howManyTimes.getValue());
                }else if (subtractNums.isSelected()){
                    totalCalc = subtractNumbers(number1, number2, howManyTimes.getValue());
                }else if (multNums.isSelected()){
                    totalCalc = multiplyNumbers(number1, number2, howManyTimes.getValue());
                }else {
                    totalCalc = divideNumbers(number1, number2, howManyTimes.getValue());
                }

                if (dollarSign.isSelected()){
                    NumberFormat numFormat = NumberFormat.getCurrencyInstance();
                    JOptionPane.showMessageDialog(SampleGUI.this,
                            numFormat.format(totalCalc),
                            "Solution", JOptionPane.INFORMATION_MESSAGE);
                }else if (commaSeparator.isSelected()){
                    NumberFormat numFormat = NumberFormat.getNumberInstance();
                    JOptionPane.showMessageDialog(SampleGUI.this,
                            numFormat.format(totalCalc),
                            "Solution", JOptionPane.INFORMATION_MESSAGE);

                }else {
                    JOptionPane.showMessageDialog(SampleGUI.this,
                            totalCalc,
                            "Solution", JOptionPane.INFORMATION_MESSAGE);

                }
            }
        });
        thePanel.add(button1);

        label1 =  new JLabel("Number 1");
        thePanel.add(label1);

        textField1 = new JTextField(5);
        thePanel.add(textField1);

        label2 =  new JLabel("Number 2");
        thePanel.add(label2);

        textField2 = new JTextField(5);
        thePanel.add(textField2);

        dollarSign = new JCheckBox("Dollars");
        commaSeparator = new JCheckBox("Commas");

        thePanel.add(dollarSign);
        thePanel.add(commaSeparator);

        addNums = new JRadioButton("Add");
        subtractNums = new JRadioButton("Subtract");
        multNums = new JRadioButton("Multiply");
        divideNums = new JRadioButton("Division");

        ButtonGroup group = new ButtonGroup();

        group.add(addNums);
        group.add(subtractNums);
        group.add(multNums);
        group.add(divideNums);

        addNums.setSelected(true);

        JPanel operPanel = new JPanel();
        Border operBorder = BorderFactory.createTitledBorder("Operations");
        operPanel.setBorder(operBorder);

        operPanel.add(addNums);
        operPanel.add(subtractNums);
        operPanel.add(multNums);
        operPanel.add(divideNums);

        thePanel.add(operPanel);

        label3 = new JLabel("Perform how many times");
        thePanel.add(label3);

        howManyTimes = new JSlider(0, 99, 1);
        howManyTimes.setMinorTickSpacing(2);
        howManyTimes.setMajorTickSpacing(10);
        howManyTimes.setPaintTicks(true);
        howManyTimes.setPaintLabels(true);
        howManyTimes.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                label3.setText("Perform how many time? " + howManyTimes.getValue());
            }
        });
        thePanel.add(howManyTimes);

        textField1.requestFocus();
        this.add(thePanel);
        this.setVisible(true);


    }

    private double addNumbers(double number1, double number2, int value) {
        double sum = 0;
        sum = (number1 + number2) * value;
        return sum;
    }

    private double subtractNumbers(double number1, double number2, int value) {
        double diff = 0;
        diff = (number1 - number2) * value;
        return diff;
    }

    private double multiplyNumbers(double number1, double number2, int value) {
        double product = 0;
        product = (number1 * number2) * value;
        return product;
    }

    private double divideNumbers(double number1, double number2, int value) {
        double quotient = 0;
        quotient = (number1 / number2) * value;
        return quotient;
    }
}
