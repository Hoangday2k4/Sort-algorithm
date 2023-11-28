package display;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SingleModePanel extends JPanel {

    private JLabel algorithmNameLabel;
    private JButton backSingleMode;
    private JComboBox<String> singleComboBox;
    private JLabel singleModeMessenger;
    private JPanel singleSortPanel;
    private JButton singleStartButton;

    public JLabel getAlgorithmNameLabel() {
        return algorithmNameLabel;
    }

    public JButton getBackSingleMode() {
        return backSingleMode;
    }

    public JComboBox<String> getSingleComboBox() {
        return singleComboBox;
    }

    public JLabel getSingleModeMessenger() {
        return singleModeMessenger;
    }

    public JPanel getSingleSortPanel() {
        return singleSortPanel;
    }

    public JButton getSingleStartButton() {
        return singleStartButton;
    }

    public SingleModePanel() {
        initComponents();
    }

    private void initComponents() {
        backSingleMode = new JButton();
        singleModeMessenger = new JLabel();
        singleComboBox = new JComboBox<>();
        singleStartButton = new JButton();
        singleSortPanel = new JPanel();
        algorithmNameLabel = new JLabel();

        setBackground(new Color(51, 51, 51));
        setSize(new Dimension(800, 500));

        backSingleMode.setBackground(new Color(0, 204, 204));
        backSingleMode.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        backSingleMode.setText("Back");

        singleModeMessenger.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        singleModeMessenger.setForeground(new Color(255, 255, 255));
        singleModeMessenger.setHorizontalAlignment(SwingConstants.CENTER);
        singleModeMessenger.setText("Single mode");

        singleComboBox.setBackground(new Color(0, 204, 204));
        singleComboBox.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        singleComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "chọn", "Bubble sort", "Insertion sort", "Selection sort", "Quick sort", "Merge sort", "....." }));
        singleComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                singleComboBoxActionPerformed(evt);
            }
        });

        singleStartButton.setBackground(new Color(0, 204, 204));
        singleStartButton.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        singleStartButton.setText("Start");

        singleSortPanel.setBackground(new Color(255, 255, 255));

        GroupLayout singleSortPanelLayout = new GroupLayout(singleSortPanel);
        singleSortPanel.setLayout(singleSortPanelLayout);
        singleSortPanelLayout.setHorizontalGroup(
                singleSortPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 733, Short.MAX_VALUE)
        );
        singleSortPanelLayout.setVerticalGroup(
                singleSortPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 367, Short.MAX_VALUE)
        );

        algorithmNameLabel.setBackground(new Color(255, 255, 255));
        algorithmNameLabel.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        algorithmNameLabel.setForeground(new Color(255, 255, 255));
        algorithmNameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(backSingleMode, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(singleComboBox, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
                                                .addGap(115, 115, 115)
                                                .addComponent(singleModeMessenger, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 31, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(singleSortPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(algorithmNameLabel, GroupLayout.PREFERRED_SIZE, 289, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(144, 144, 144)
                                                                .addComponent(singleStartButton, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(backSingleMode)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(singleComboBox, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(singleModeMessenger, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(singleSortPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(singleStartButton, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                        .addComponent(algorithmNameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(21, 21, 21))
        );
    }

    private void singleComboBoxActionPerformed(ActionEvent evt) {
        Object selectedItem = singleComboBox.getSelectedItem();

        if (selectedItem == null) {
            algorithmNameLabel.setText("Please select an item");
        } else {
            String selectedText = selectedItem.toString();

            if ("Bubble sort".equals(selectedText)) {
                algorithmNameLabel.setText("Bubble sort");
            } else if ("Insertion sort".equals(selectedText)) {
                algorithmNameLabel.setText("Insertion sort");
            } else if ("Selection sort".equals(selectedText)) {
                algorithmNameLabel.setText("Selection sort");
            } else if ("Quick sort".equals(selectedText)) {
                algorithmNameLabel.setText("Quick sort");
            } else if ("Merge sort".equals(selectedText)) {
                algorithmNameLabel.setText("Merge sort");
            } else {
                algorithmNameLabel.setText("Unknown sort");
            }
        }
    }
}