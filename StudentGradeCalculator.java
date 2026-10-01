import java.awt.*;
import javax.swing.*;

public class StudentGradeCalculator {

    // MODEL
    static class StudentModel {
        private String name;
        private final double total, avg;
        private final String grade;

        public StudentModel(String name, double m1, double m2, double m3) {
            this.name = name;
            this.total = m1 + m2 + m3;
            this.avg = total / 3.0;

            if (avg >= 90) grade = "A";
            else if (avg >= 75) grade = "B";
            else if (avg >= 60) grade = "C";
            else if (avg >= 50) grade = "D";
            else grade = "F";
        }

        public double getTotal() { return total; }
        public double getAvg() { return avg; }
        public String getGrade() { return grade; }
    }

    // VIEW
    static class StudentView extends JFrame {
        JTextField nameField = new JTextField(10);
        JTextField m1Field = new JTextField(5);
        JTextField m2Field = new JTextField(5);
        JTextField m3Field = new JTextField(5);
        JButton calcBtn = new JButton("Calculate Result");
        JLabel totalLabel = new JLabel("Total: ");
        JLabel avgLabel = new JLabel("Average: ");
        JLabel gradeLabel = new JLabel("Grade: ");

        public StudentView() {
            setTitle("Student Grade Calculator");
            setSize(320, 260);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(7, 2, 5, 5));

            add(new JLabel("Student Name:")); add(nameField);
            add(new JLabel("Mark 1:")); add(m1Field);
            add(new JLabel("Mark 2:")); add(m2Field);
            add(new JLabel("Mark 3:")); add(m3Field);
            add(calcBtn); add(new JLabel(""));
            add(totalLabel); add(avgLabel);
            add(gradeLabel); add(new JLabel(""));

            setLocationRelativeTo(null);
        }
    }

    // CONTROLLER & MAIN
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentView view = new StudentView();

            view.calcBtn.addActionListener(e -> {
                try {
                    String name = view.nameField.getText();
                    double m1 = Double.parseDouble(view.m1Field.getText());
                    double m2 = Double.parseDouble(view.m2Field.getText());
                    double m3 = Double.parseDouble(view.m3Field.getText());

                    StudentModel model = new StudentModel(name, m1, m2, m3);

                    view.totalLabel.setText(String.format("Total: %.2f", model.getTotal()));
                    view.avgLabel.setText(String.format("Average: %.2f", model.getAvg()));
                    view.gradeLabel.setText("Grade: " + model.getGrade());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(view, "Please enter valid numeric marks.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            view.setVisible(true);
        });
    }
}