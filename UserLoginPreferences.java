import java.awt.*;
import javax.swing.*;

public class UserLoginPreferences extends JFrame {

    private final JTextField userField;
    private final JPasswordField passField;
    private final JCheckBox rememberBox, notifyBox;
    private final JButton loginButton;

    public UserLoginPreferences() {
        setTitle("User Login & Preferences");
        setSize(380, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel(" Username:"));
        userField = new JTextField();
        add(userField);

        add(new JLabel(" Password:"));
        passField = new JPasswordField();
        add(passField);

        rememberBox = new JCheckBox("Remember Me");
        notifyBox = new JCheckBox("Receive Notifications");
        add(rememberBox);
        add(notifyBox);

        loginButton = new JButton("Login");
        add(loginButton);
        add(new JLabel(""));

        loginButton.addActionListener(e -> handleLogin());

        setLocationRelativeTo(null);
    }

    private void handleLogin() {
        String username = userField.getText().trim();
        String password = new String(passField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password.", "Login Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        StringBuilder msg = new StringBuilder();
        msg.append("Welcome, ").append(username).append("!\nLogin Successful.\n\nPreferences Saved:");
        msg.append("\n- Remember Me: ").append(rememberBox.isSelected() ? "Yes" : "No");
        msg.append("\n- Receive Notifications: ").append(notifyBox.isSelected() ? "Yes" : "No");

        JOptionPane.showMessageDialog(this, msg.toString(), "Login Status", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserLoginPreferences().setVisible(true));
    }
}