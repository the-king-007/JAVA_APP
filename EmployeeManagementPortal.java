import javax.swing.*;
import java.awt.*;

public class EmployeeManagementPortal {

    // MODEL
    static class PortalModel {
        private String username = "admin";
        private String password = "admin123";

        public boolean authenticate(String user, String pass) {
            return username.equals(user) && password.equals(pass);
        }

        public boolean changePassword(String oldP, String newP, String confP) {
            if (password.equals(oldP) && newP.equals(confP) && !newP.isEmpty()) {
                password = newP;
                return true;
            }
            return false;
        }
    }

    // VIEW & CONTROLLER
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PortalModel model = new PortalModel();

            JFrame frame = new JFrame("Employee Management Portal");
            frame.setSize(400, 250);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JTextField userField = new JTextField(10);
            JPasswordField passField = new JPasswordField(10);
            JButton loginBtn = new JButton("Login");

            JPanel loginPanel = new JPanel(new GridLayout(3, 2, 10, 10));
            loginPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            loginPanel.add(new JLabel("Username:")); loginPanel.add(userField);
            loginPanel.add(new JLabel("Password:")); loginPanel.add(passField);
            loginPanel.add(new JLabel("")); loginPanel.add(loginBtn);

            frame.add(loginPanel);

            loginBtn.addActionListener(e -> {
                String u = userField.getText();
                String p = new String(passField.getPassword());

                if (model.authenticate(u, p)) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");

                    // Setup Menu Bar after successful login
                    JMenuBar menuBar = new JMenuBar();

                    JMenu menuEmp = new JMenu("Employee");
                    JMenuItem itemAddEmp = new JMenuItem("Add Employee");
                    JMenuItem itemViewEmp = new JMenuItem("View Employee");
                    menuEmp.add(itemAddEmp); menuEmp.add(itemViewEmp);

                    JMenu menuTools = new JMenu("Tools");
                    JMenuItem itemChangePass = new JMenuItem("Change Password");
                    JMenuItem itemExitTools = new JMenuItem("Exit");
                    menuTools.add(itemChangePass); menuTools.add(itemExitTools);

                    JMenu menuExit = new JMenu("Exit");
                    JMenuItem itemLogout = new JMenuItem("Logout");
                    JMenuItem itemExitApp = new JMenuItem("Exit Application");
                    menuExit.add(itemLogout); menuExit.add(itemExitApp);

                    menuBar.add(menuEmp); menuBar.add(menuTools); menuBar.add(menuExit);
                    frame.setJMenuBar(menuBar);

                    // Add Employee Action
                    itemAddEmp.addActionListener(evt -> {
                        JTextField idF = new JTextField(), nameF = new JTextField(), deptF = new JTextField();
                        Object[] form = {"ID:", idF, "Name:", nameF, "Department:", deptF};
                        if (JOptionPane.showConfirmDialog(frame, form, "Add Employee", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                            JOptionPane.showMessageDialog(frame, "Employee Details Added!");
                        }
                    });

                    // Change Password Action
                    itemChangePass.addActionListener(evt -> {
                        JPasswordField oldP = new JPasswordField(), newP = new JPasswordField(), confP = new JPasswordField();
                        Object[] form = {"Old Password:", oldP, "New Password:", newP, "Confirm Password:", confP};
                        if (JOptionPane.showConfirmDialog(frame, form, "Change Password", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                            boolean success = model.changePassword(
                                    new String(oldP.getPassword()),
                                    new String(newP.getPassword()),
                                    new String(confP.getPassword())
                            );
                            if (success) JOptionPane.showMessageDialog(frame, "Password Changed Successfully!");
                            else JOptionPane.showMessageDialog(frame, "Password Change Failed!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    });

                    // Exit / Logout Actions
                    itemLogout.addActionListener(evt -> System.exit(0));
                    itemExitApp.addActionListener(evt -> System.exit(0));
                    itemExitTools.addActionListener(evt -> System.exit(0));

                    frame.revalidate();
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Credentials!", "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            });

            frame.setVisible(true);
        });
    }
}