// import NumberPK package with class NumberPk 

import NumberPK.NumberPk;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//  NumberG GUI class that extends JFrame and implements ActionListener
public class NumberG extends JFrame implements ActionListener {
    private final JTextField inputField;
    private final JComboBox<String> checkType;
    private final JLabel resultLabel;

    public NumberG() {
        setTitle("Number Checker");
        setSize(600, 450); // Bigger window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(new Color(255, 245, 250)); // soft pink
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel titleLabel = new JLabel("Number Checker");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(new Color(102, 0, 153));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPanel.add(titleLabel, gbc);

        // Input Label
        gbc.gridy++;
        gbc.gridwidth = 1;
        JLabel numLabel = new JLabel("Enter a Number:");
        numLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        
        contentPanel.add(numLabel, gbc);

        // Input Field
        inputField = new JTextField();
        inputField.setFont(new Font("Segoe UI", Font.PLAIN, 22));
   
        gbc.gridx = 1;
        contentPanel.add(inputField, gbc);

        // ComboBox Label
        gbc.gridx = 0;
        gbc.gridy++;
        JLabel typeLabel = new JLabel("Choose check type:");
        typeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        contentPanel.add(typeLabel, gbc);

        
        
        // ComboBox
        String[] options = {"Even / Odd","Armstrong", "Prime", "Palindrome","Factorial", "Check All"};
        checkType = new JComboBox<>(options);
        checkType.setFont(new Font("Segoe UI", Font.PLAIN, 22));
        gbc.gridx = 1;
        contentPanel.add(checkType, gbc);
        

        
        // Button
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton checkButton = new JButton("Check Now");
        checkButton.setFont(new Font("Segoe UI", Font.BOLD, 26));
        checkButton.setBackground(new Color(102, 0, 153)); // Light blue
        checkButton.setForeground(Color.WHITE); 
        checkButton.setFocusPainted(false);
        checkButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor on hover
        checkButton.addActionListener(this);
        contentPanel.add(checkButton, gbc);


// Result Label   
        gbc.gridy++;
        resultLabel = new JLabel("Waiting for input...");
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        resultLabel.setForeground(Color.DARK_GRAY);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPanel.add(resultLabel, gbc);

        setContentPane(contentPanel);
        setVisible(true);
    }
//switch for selection
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int num = Integer.parseInt(inputField.getText().trim());
            String selected = (String) checkType.getSelectedItem();
            String result = "";

            switch (selected) {
                 case "Even / Odd":
                    result = num + (NumberPk.isEven(num) ? " is an Even number." : " is an Odd number.");
                    break;
                case "Armstrong":
                    result = num + (NumberPk.isArmstrong(num) ? " is an Armstrong number." : " is not an Armstrong number.");
                    break;
                case "Prime":
                    result = num + (NumberPk.isPrime(num) ? " is a Prime number." : " is not a Prime number.");
                    break;
                case "Palindrome":
                    result = num + (NumberPk.isPalindrome(num) ? " is a Palindrome." : " is not a Palindrome.");
                    break;
                 case "Factorial":
                    int f = NumberPk.factorial(num);
                    result = (f == -1) ? "Invalid input. Factorial not possible." : "Factorial of " + num + " is " + f;
                    break;
                case "Check All":
                    StringBuilder sb = new StringBuilder();
                    sb.append("Armstrong: ").append(NumberPk.isArmstrong(num) ? "Yes" : "No").append(" | ");
                    sb.append("Prime: ").append(NumberPk.isPrime(num) ? "Yes" : "No").append(" | ");
                    sb.append("Even: ").append(NumberPk.isEven(num) ? "Yes" : "No").append(" | ");
                    sb.append("Palindrome: ").append(NumberPk.isPalindrome(num) ? "Yes" : "No").append(" | ");
                    int fact = NumberPk.factorial(num);
                    sb.append("Factorial: ").append(fact == -1 ? "Invalid" : fact);
                    result = sb.toString();
                    break;
            }

            resultLabel.setText(result);
            resultLabel.setForeground(new Color(0, 102, 0)); // dark green
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number.");
            resultLabel.setForeground(Color.RED);
        }
    }
//main method
    public static void main(String[] args) {

       NumberG numberG = new NumberG();
    }
}

