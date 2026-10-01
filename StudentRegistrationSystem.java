import java.awt.*;
import javax.swing.*;

public class StudentRegistrationSystem extends JFrame {

    private final JTextField nameField, regField;
    private final JRadioButton maleRadio, femaleRadio, otherRadio;
    private final ButtonGroup genderGroup;
    private final JComboBox<String> deptCombo;
    private final JButton submitButton;

    public StudentRegistrationSystem() {
        setTitle("Student Registration System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        // Form Fields
        add(new JLabel(" Student Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel(" Register Number:"));
        regField = new JTextField();
        add(regField);

        add(new JLabel(" Gender:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        otherRadio = new JRadioButton("Other");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        genderGroup.add(otherRadio);
        genderPanel.add(maleRadio);
        genderPanel.add(femaleRadio);
        genderPanel.add(otherRadio);
        add(genderPanel);

        add(new JLabel(" Department:"));
        String[] departments = {"Computer Science", "Information Technology", "Electronics", "Mechanical", "Civil"};
        deptCombo = new JComboBox<>(departments);
        add(deptCombo);

        submitButton = new JButton("Submit");
        add(submitButton);
        add(new JLabel("")); // Empty cell placeholder

        submitButton.addActionListener(e -> handleSubmit());

        setLocationRelativeTo(null);
    }

    private void handleSubmit() {
        String name = nameField.getText().trim();
        String regNo = regField.getText().trim();
        
        String gender = "";
        if (maleRadio.isSelected()) gender = "Male";
        else if (femaleRadio.isSelected()) gender = "Female";
        else if (otherRadio.isSelected()) gender = "Other";

        String dept = (String) deptCombo.getSelectedItem();

        if (name.isEmpty() || regNo.isEmpty() || gender.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String details = String.format("Student Registered Successfully!\n\nName: %s\nReg No: %s\nGender: %s\nDepartment: %s", 
                                       name, regNo, gender, dept);
        JOptionPane.showMessageDialog(this, details, "Registration Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRegistrationSystem().setVisible(true));
    }
}