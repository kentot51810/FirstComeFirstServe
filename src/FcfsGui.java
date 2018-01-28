import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FcfsGui extends JFrame {

    //declaration of global variable
    private JFrame frame;
    private JPanel container;
    private JButton submitButton;
    private JTextField processInput;

    private static int numberOfProcess = 0;

    public FcfsGui() {
        onCreateGui();
    }

    public static void main(String[]a){
        SwingUtilities.invokeLater(FcfsGui::new);
    }

    private  void onCreateGui() {
        frame = new JFrame();
        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        setUpFrame();
        setUpIntroLayer();
        setUpSubmitLayer();
        setUpOutputLayer();


        frame.add(container);
        frame.pack();
        frame.setVisible(true);
    }

    private void setUpOutputLayer() {

    }

    private  void setUpSubmitLayer() {
        JPanel submitLayer = new JPanel(true);
        submitLayer.setBorder(BorderFactory.createTitledBorder("submitLayer"));
        //submitLayer.setLayout(new BoxLayout(submitLayer,BoxLayout.LINE_AXIS));

        JLabel process = new JLabel("Enter the total number of process:");
        processInput = new JTextField(5);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ButtonListener());

        submitLayer.add(process);
        submitLayer.add(processInput);
        submitLayer.add(submitButton);

        container.add(submitLayer);
    }

    private  void setUpIntroLayer() {
        JPanel introLayer = new JPanel();
        introLayer.setBorder(BorderFactory.createTitledBorder("introLayer"));
        introLayer.setLayout(new FlowLayout());

        JLabel introLabel = new JLabel("First Come First Serve");
        introLabel.setSize(10,10);
        introLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        introLayer.add(introLabel);
        introLayer.setSize(15, 5);
        container.add(introLayer);
    }

    private void setUpFrame() {
        frame.setTitle("FCFS Scheduling Algorithm");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submitButton){
                try{
                    numberOfProcess = Integer.parseInt(processInput.getText());
                }catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(FcfsGui.this,
                            "Error! Please enter a correct integer!","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
}
