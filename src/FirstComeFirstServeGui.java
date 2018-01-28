import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FirstComeFirstServeGui extends JFrame {

    //declaration of private global variables
    private JLabel intro, process, burst;
    private JButton submit;
    private JPanel container;
    private JTextField processNumber, burstTimeNumber;
    private JFrame thisFrame;
    private int numberOfProcess;

    public FirstComeFirstServeGui(){
        thisFrame = new JFrame();
        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(container,  ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JPanel introPanel = new JPanel();
        intro = new JLabel("First Come First Serve");
        introPanel.add(intro);

        JPanel inputArea = new JPanel();
        process = new JLabel("Enter the total number of process:");
        processNumber = new JTextField(5);
        submit = new JButton("Submit");
        inputArea.add(process);
        inputArea.add(processNumber);
        inputArea.add(submit);

        submit.addActionListener(new buttonListener());

        container.add(introPanel);
        container.add(inputArea);

        thisFrame.add(container);
        setupGui();

    }

    private void setupGui() {
        //thisFrame.setSize(400,400);
        thisFrame.pack();
        thisFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        thisFrame.setLocationRelativeTo(null);
        thisFrame.setTitle("First Come First Serve");
        thisFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new FirstComeFirstServeGui();
    }

    private class buttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                numberOfProcess = Integer.parseInt(processNumber.getText());
            }catch (NumberFormatException exception){
                JOptionPane.showMessageDialog(FirstComeFirstServeGui.this,
                        "Please Enter an Integer Only!", "Error",JOptionPane.ERROR_MESSAGE);

            }
            Border processInputBorder = BorderFactory.createTitledBorder("Process Input");
            JPanel processInputArea = new JPanel();
            processInputArea.setBorder(processInputBorder);
            List<Integer> burstArrayList = new ArrayList<>();

            for (int index = 0; index < numberOfProcess; index++){
                burst = new JLabel("P[" + (index + 1) + "]");
                burstTimeNumber = new JTextField(5);
                processInputArea.add(burst);
                processInputArea.add(burstTimeNumber);
            }
            container.add(processInputArea);
            container.revalidate();
            validate();
            thisFrame.pack();

        }
    }
}
