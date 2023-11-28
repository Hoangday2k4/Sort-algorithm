package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CompareModePanel extends JPanel {
    private JLabel algorithmNameLabel1;
    private JLabel algorithmNameLabel2;
    private JButton backCompareMode;
    private JComboBox<String> compareComboBox1;
    private JComboBox<String> compareComboBox2;
    private JLabel compareModeMessenger;
    private JPanel comparePanel1;
    private JPanel comparePanel2;
    private JButton compareStartButton;

    public JLabel getAlgorithmNameLabel1() {
        return algorithmNameLabel1;
    }

    public JLabel getAlgorithmNameLabel2() {
        return algorithmNameLabel2;
    }

    public JButton getBackCompareMode() {
        return backCompareMode;
    }

    public JComboBox<String> getCompareComboBox1() {
        return compareComboBox1;
    }

    public JComboBox<String> getCompareComboBox2() {
        return compareComboBox2;
    }

    public JLabel getCompareModeMessenger() {
        return compareModeMessenger;
    }

    public JPanel getComparePanel1() {
        return comparePanel1;
    }

    public JPanel getComparePanel2() {
        return comparePanel2;
    }

    public JButton getCompareStartButton() {
        return compareStartButton;
    }

    public CompareModePanel() {
        initComponents();
    }

    private void initComponents() {
        backCompareMode = new JButton();
        compareModeMessenger = new JLabel();
        compareStartButton = new JButton();
        compareComboBox1 = new JComboBox<>();
        comparePanel1 = new JPanel();
        compareComboBox2 = new JComboBox<>();
        comparePanel2 = new JPanel();
        algorithmNameLabel1 = new JLabel();
        algorithmNameLabel2 = new JLabel();

        setBackground(new Color(51, 51, 51));

        backCompareMode.setBackground(new Color(0, 204, 204));
        backCompareMode.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        backCompareMode.setText("Back");

        compareModeMessenger.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        compareModeMessenger.setForeground(new Color(255, 255, 255));
        compareModeMessenger.setHorizontalAlignment(SwingConstants.CENTER);
        compareModeMessenger.setText("Compare Mode");

        compareStartButton.setBackground(new Color(0, 204, 204));
        compareStartButton.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        compareStartButton.setText("Start");

        compareComboBox1.setBackground(new Color(0, 204, 204));
        compareComboBox1.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        compareComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "chọn", "Bubble sort", "Insertion sort", "Selection sort", "Quick sort", "Merge sort", "....." }));
        compareComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                compareComboBox1ActionPerformed(evt);
            }
        });

        comparePanel1.setBackground(new Color(255, 255, 255));

        GroupLayout comparePanel1Layout = new GroupLayout(comparePanel1);
        comparePanel1.setLayout(comparePanel1Layout);
        comparePanel1Layout.setHorizontalGroup(
                comparePanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 746, Short.MAX_VALUE)
        );
        comparePanel1Layout.setVerticalGroup(
                comparePanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 169, Short.MAX_VALUE)
        );

        compareComboBox2.setBackground(new Color(0, 204, 204));
        compareComboBox2.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        compareComboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "chọn", "Bubble sort", "Insertion sort", "Selection sort", "Quick sort", "Merge sort", "....." }));
        compareComboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                compareComboBox2ActionPerformed(evt);
            }
        });

        comparePanel2.setBackground(new Color(255, 255, 255));

        GroupLayout comparePanel2Layout = new GroupLayout(comparePanel2);
        comparePanel2.setLayout(comparePanel2Layout);
        comparePanel2Layout.setHorizontalGroup(
                comparePanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 747, Short.MAX_VALUE)
        );
        comparePanel2Layout.setVerticalGroup(
                comparePanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 177, Short.MAX_VALUE)
        );

        algorithmNameLabel1.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        algorithmNameLabel1.setForeground(new Color(255, 255, 255));
        algorithmNameLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        algorithmNameLabel2.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        algorithmNameLabel2.setForeground(new Color(255, 255, 255));
        algorithmNameLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(backCompareMode, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(compareComboBox1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(113, 113, 113)
                                                                .addComponent(compareModeMessenger))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(compareComboBox2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(26, 26, 26)
                                                                .addComponent(algorithmNameLabel1, GroupLayout.PREFERRED_SIZE, 443, GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 26, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(comparePanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(algorithmNameLabel2, GroupLayout.PREFERRED_SIZE, 440, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(96, 96, 96)
                                                                .addComponent(compareStartButton, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(comparePanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(compareModeMessenger, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(backCompareMode)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(compareComboBox1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comparePanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(algorithmNameLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(compareComboBox2, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comparePanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(compareStartButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(algorithmNameLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
    }

    private void compareComboBox2ActionPerformed(ActionEvent evt) {
        Object selectedItem = compareComboBox2.getSelectedItem();

        if (selectedItem == null) {
            algorithmNameLabel2.setText("Please select an item");
        } else {
            String selectedText = selectedItem.toString();

            if ("Bubble sort".equals(selectedText)) {
                algorithmNameLabel2.setText("Bubble sort");
            } else if ("Insertion sort".equals(selectedText)) {
                algorithmNameLabel2.setText("Insertion sort");
            } else if ("Selection sort".equals(selectedText)) {
                algorithmNameLabel2.setText("Selection sort");
            } else if ("Quick sort".equals(selectedText)) {
                algorithmNameLabel2.setText("Quick sort");
            } else if ("Merge sort".equals(selectedText)) {
                algorithmNameLabel2.setText("Merge sort");
            } else {
                algorithmNameLabel2.setText("Unknown sort");
            }
        }
    }

    private void compareComboBox1ActionPerformed(ActionEvent evt) {
        Object selectedItem = compareComboBox1.getSelectedItem();

        if (selectedItem == null) {
            algorithmNameLabel1.setText("Please select an item");
        } else {
            String selectedText = selectedItem.toString();

            if ("Bubble sort".equals(selectedText)) {
                algorithmNameLabel1.setText("Bubble sort");
            } else if ("Insertion sort".equals(selectedText)) {
                algorithmNameLabel1.setText("Insertion sort");
            } else if ("Selection sort".equals(selectedText)) {
                algorithmNameLabel1.setText("Selection sort");
            } else if ("Quick sort".equals(selectedText)) {
                algorithmNameLabel1.setText("Quick sort");
            } else if ("Merge sort".equals(selectedText)) {
                algorithmNameLabel1.setText("Merge sort");
            } else {
                algorithmNameLabel1.setText("Unknown sort");
            }
        }
    }
}