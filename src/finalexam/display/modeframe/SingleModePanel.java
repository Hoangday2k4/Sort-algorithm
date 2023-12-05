package finalexam.display.modeframe;

import finalexam.defaultsorting.*;
import finalexam.defaultsorting.BubbleSort;
import finalexam.defaultsorting.InsertionSort;
import finalexam.defaultsorting.MergeSort;
import finalexam.defaultsorting.QuickSort;
import finalexam.defaultsorting.SelectionSort;
import finalexam.display.SortingDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SingleModePanel extends JPanel implements ModeInterface {
    // Behavioral variables
    private Sorting sorting;
    private int[] array;
    private int arraySize = 200;

    // Display variable
    private JLabel algorithmNameLabel;
    private JButton backSingleMode;
    private JComboBox<String> singleComboBox;
    private JLabel singleModeMessenger;
    private JPanel singleSortPanel;
    private JButton singleStartButton;
    private JButton resetArray;
    private JButton arraySizeButton;
    private JLabel arraySizeLabel;


    // Getter and Setter
    public JButton getBackSingleMode() {
        return backSingleMode;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public SingleModePanel() {
        initComponents();
        this.array = SortingDisplay.generateRandomArray(arraySize, 300);
        this.sorting = new BubbleSort(array);
        singleSortPanel.add(sorting.getSortingDisplay(), BorderLayout.CENTER);
    }

    private void initComponents() {
        // Adjust size and background color
        setBackground(new Color(51, 51, 51));
        setSize(new Dimension(800, 500));

        // Back button
        backSingleMode = new JButton();
        backSingleMode.setBackground(new Color(0, 204, 204));
        backSingleMode.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        backSingleMode.setText("Back");
        backSingleMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                back();
            }
        });

        // Name of Mode
        singleModeMessenger = new JLabel();
        singleModeMessenger.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        singleModeMessenger.setForeground(new Color(255, 255, 255));
        singleModeMessenger.setHorizontalAlignment(SwingConstants.CENTER);
        singleModeMessenger.setText("Single mode");

        // ComboBox
        singleComboBox = new JComboBox<>();
        singleComboBox.setBackground(new Color(0, 204, 204));
        singleComboBox.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        singleComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Chon", "Bubble sort", "Insertion sort", "Selection sort", "Quick sort", "Merge sort", "Heap sort"}));
        singleComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                singleComboBoxActionPerformed(evt);
            }
        });

        // Start button
        singleStartButton = new JButton();
        singleStartButton.setBackground(new Color(0, 204, 204));
        singleStartButton.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        singleStartButton.setText("Start");
        singleStartButton.addActionListener((new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    start();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }));

        // Panel set sortingDissplay
        singleSortPanel = new JPanel();
        singleSortPanel.setLayout(new BorderLayout());
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

        // Name of the algorithm
        algorithmNameLabel = new JLabel("Unknown sort");
        algorithmNameLabel.setBackground(new Color(255, 255, 255));
        algorithmNameLabel.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        algorithmNameLabel.setForeground(new Color(255, 255, 255));
        algorithmNameLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // ResetArray button
        resetArray = new JButton();
        resetArray.setBackground(new Color(0, 204, 204));
        resetArray.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        resetArray.setText("Reset Array");
        resetArray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                resetArray();
            }
        });

        // arraySize button
        arraySizeButton = new JButton();
        arraySizeButton.setBackground(new java.awt.Color(0, 204, 204));
        arraySizeButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        arraySizeButton.setText("Array size");
        arraySizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showArraySizeInputDialog();
            }
        });

        // arraySize label
        arraySizeLabel = new JLabel();
        arraySizeLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        arraySizeLabel.setForeground(new java.awt.Color(255, 255, 255));
        arraySizeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        arraySizeLabel.setText("Array size: " + arraySize);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(backSingleMode, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(singleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(115, 115, 115)
                                                .addComponent(singleModeMessenger, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(arraySizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(resetArray)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(arraySizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(84, 84, 84)
                                                                .addComponent(algorithmNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(159, 159, 159)
                                                                .addComponent(singleStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(singleSortPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(backSingleMode)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(singleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(singleModeMessenger)
                                                .addComponent(arraySizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(singleSortPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(singleStartButton, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                        .addComponent(algorithmNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(resetArray, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(arraySizeButton)))
                                .addGap(21, 21, 21))
        );
    }

    private void singleComboBoxActionPerformed(ActionEvent evt) {
        Object selectedItem = singleComboBox.getSelectedItem();

        int[] x = SortingDisplay.generateRandomArray(arraySize, 300);

        // Kiểm tra nếu có sortingDisplay cũ, thì xóa nó đi trước khi thêm mới
        if (sorting.getSortingDisplay() != null) {
            singleSortPanel.remove(sorting.getSortingDisplay());
            singleSortPanel.revalidate(); // Cập nhật layout
            singleSortPanel.repaint();    // Vẽ lại container        }
            String selectedText = selectedItem.toString();

            if ("Bubble sort".equals(selectedText)) {
                sorting = new BubbleSort(x);
                algorithmNameLabel.setText("Bubble sort");
            } else if ("Insertion sort".equals(selectedText)) {
                sorting = new InsertionSort(x);
                algorithmNameLabel.setText("Insertion sort");
            } else if ("Selection sort".equals(selectedText)) {
                sorting = new SelectionSort(x);
                algorithmNameLabel.setText("Selection sort");
            } else if ("Quick sort".equals(selectedText)) {
                sorting = new QuickSort(x);
                algorithmNameLabel.setText("Quick sort");
            } else if ("Merge sort".equals(selectedText)) {
                sorting = new MergeSort(x);
                algorithmNameLabel.setText("Merge sort");
            } else if ("Heap sort".equals(selectedText)) {
                sorting = new HeapSort(x);
                algorithmNameLabel.setText("Heap sort");
            } else {
                algorithmNameLabel.setText("Unknown sort");
            }

            sorting.sortingDisplay.setWidth(733);
            sorting.sortingDisplay.setHeight(365);
            sorting.sortingDisplay.setSize(733, 365);

            // Thêm sortingDisplay mới vào container
            singleSortPanel.add(sorting.getSortingDisplay(), BorderLayout.CENTER);

            if ("Chon".equals(selectedText)) {
                singleSortPanel.remove(sorting.getSortingDisplay());
                singleSortPanel.revalidate(); // Cập nhật layout
                singleSortPanel.repaint();    // Vẽ lại container
            }
            this.sorting.sortingDisplay.sorting = this.sorting;
        }
    }

    @Override
    public void start() throws InterruptedException {
        Thread sortingThread = new Thread(() -> {
            // Run the sort() method in the separate thread
            sorting.sort();
        });

        sortingThread.start();
    }

    @Override
    public void back() {
        singleComboBox.setSelectedItem("Chon");
    }

    @Override
    public void resetArray() {
        int[] newValues = SortingDisplay.generateRandomArray(arraySize, 300);

        setArray(newValues.clone());
        this.sorting.setValues(array);
        this.sorting.getSortingDisplay().repaint();
        this.sorting.sortingDisplay.resetStats();
    }

    @Override
    public void setArraySize(int newSize) {
        this.arraySize = newSize;
        resetArray();
    }

    private void showArraySizeInputDialog() {
        String input = JOptionPane.showInputDialog("Nhập giá trị cho arraySize:");
        try {
            int newSize = Integer.parseInt(input);
            setArraySize(newSize);
            arraySizeLabel.setText("Array size: " + arraySize);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên.");
        }
    }
}