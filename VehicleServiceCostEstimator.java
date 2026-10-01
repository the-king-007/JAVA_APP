import javax.swing.*;
import java.awt.*;

public class VehicleServiceCostEstimator {

    // MODEL
    static class ServiceModel {
        public static double calculateCost(boolean gen, boolean oil, boolean brake, boolean bat) {
            double cost = 0;
            if (gen) cost += 1000;
            if (oil) cost += 800;
            if (brake) cost += 1200;
            if (bat) cost += 500;
            return cost;
        }
    }

    // VIEW
    static class ServiceView extends JFrame {
        JTextField regField = new JTextField(10);
        JComboBox<String> typeBox = new JComboBox<>(new String[]{"Two Wheeler", "Car"});
        JCheckBox chkGen = new JCheckBox("General Service (₹1,000)");
        JCheckBox chkOil = new JCheckBox("Oil Change (₹800)");
        JCheckBox chkBrake = new JCheckBox("Brake Service (₹1,200)");
        JCheckBox chkBat = new JCheckBox("Battery Check (₹500)");
        JButton calcBtn = new JButton("Calculate Cost");
        JLabel resultLabel = new JLabel("Total Service Cost: ₹0.00");

        public ServiceView() {
            setTitle("Vehicle Service Cost Estimator");
            setSize(380, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(new GridLayout(8, 1, 5, 5));

            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            topPanel.add(new JLabel("Reg No:")); topPanel.add(regField);
            topPanel.add(new JLabel("Type:")); topPanel.add(typeBox);

            add(topPanel);
            add(chkGen); add(chkOil); add(chkBrake); add(chkBat);
            add(calcBtn);
            add(resultLabel);

            setLocationRelativeTo(null);
        }
    }

    // CONTROLLER & MAIN
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ServiceView view = new ServiceView();

            view.calcBtn.addActionListener(e -> {
                double total = ServiceModel.calculateCost(
                        view.chkGen.isSelected(),
                        view.chkOil.isSelected(),
                        view.chkBrake.isSelected(),
                        view.chkBat.isSelected()
                );
                view.resultLabel.setText(String.format("Total Service Cost: ₹%.2f", total));
            });

            view.setVisible(true);
        });
    }
}