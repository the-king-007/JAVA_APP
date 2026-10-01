import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CourseManagementSystem extends JFrame {

    private final JList<String> courseList;
    private final JTable studentTable;
    private final DefaultTableModel tableModel;
    private final JTextField nameField;
    private final JButton addButton, removeButton;

    public CourseManagementSystem() {
        setTitle("Student Course Management System");
        setSize(650, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Available Courses List
        String[] courses = {"Java Programming", "Data Structures", "Database Systems", "Web Development", "Computer Networks"};
        courseList = new JList<>(courses);
        courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane listScrollPane = new JScrollPane(courseList);
        listScrollPane.setBorder(BorderFactory.createTitledBorder("Available Courses"));
        listScrollPane.setPreferredSize(new Dimension(180, 0));

        // Table Setup
        String[] columnNames = {"Student Name", "Course", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0);
        studentTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(studentTable);
        tableScrollPane.setBorder(BorderFactory.createTitledBorder("Enrollment Records"));

        // Control Panel
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        controlPanel.add(new JLabel("Student Name:"));
        nameField = new JTextField(12);
        controlPanel.add(nameField);

        addButton = new JButton("Add Registration");
        removeButton = new JButton("Remove Selected");
        controlPanel.add(addButton);
        controlPanel.add(removeButton);

        add(listScrollPane, BorderLayout.WEST);
        add(tableScrollPane, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        // Action Listeners
        addButton.addActionListener(e -> addCourseRegistration());
        removeButton.addActionListener(e -> removeCourseRegistration());

        setLocationRelativeTo(null);
    }

    private void addCourseRegistration() {
        String name = nameField.getText().trim();
        String selectedCourse = courseList.getSelectedValue();

        if (name.isEmpty() || selectedCourse == null) {
            JOptionPane.showMessageDialog(this, "Please enter a student name and select a course.", "Input Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        tableModel.addRow(new Object[]{name, selectedCourse, "Enrolled"});
        nameField.setText("");
        courseList.clearSelection();
    }

    private void removeCourseRegistration() {
        int selectedRow = studentTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Select a record from the table to remove.", "Selection Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CourseManagementSystem().setVisible(true));
    }
}