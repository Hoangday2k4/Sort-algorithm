package finalexam.display.modeframe;

import finalexam.defaultsorting.*;
import finalexam.display.SortingDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CompareModePanel extends JPanel implements ModeInterface {
    // Behavioral variables
    private Sorting sorting1;
    private Sorting sorting2;
    private int[] array1;
    private int[] array2;
    private int arraySize = 200;

    // Display variable
    private JLabel algorithmNameLabel1;
    private JLabel algorithmNameLabel2;
    private JButton backCompareMode;
    private JComboBox<String> compareComboBox1;
    private JComboBox<String> compareComboBox2;
    private JLabel compareModeMessenger;
    private JPanel comparePanel1;
    private JPanel comparePanel2;
    private JButton compareStartButton;
    private JButton resetArray;
    private JButton arraySizeButton;
    private JLabel arraySizeLabel;

    // Getter and setter
    public JButton getBackCompareMode() {
        return backCompareMode;
    }

    public void setArray1(int[] array1) {
        this.array1 = array1;
    }

    public void setArray2(int[] array2) {
        this.array2 = array2;
    }

    public CompareModePanel() {
        initComponents();
        this.array1 = SortingDisplay.generateRandomArray(arraySize, 100);
        this.sorting1 = new BubbleSort(array1);
        comparePanel1.add(sorting1.getSortingDisplay());

        this.array2 = SortingDisplay.generateRandomArray(arraySize, 100);
        this.sorting2 = new BubbleSort(array2);
        comparePanel2.add(sorting2.getSortingDisplay());
    }

    private void initComponents() {
        // Adjust size and background color
        setBackground(new Color(51, 51, 51));
        setSize(new Dimension(800, 500));

        // Back button
        backCompareMode = new JButton();
        backCompareMode.setBackground(new Color(0, 204, 204));
        backCompareMode.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        backCompareMode.setText("Back");
        backCompareMode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                back();
            }
        });

        // Name of Mode
        compareModeMessenger = new JLabel();
        compareModeMessenger.setFont(new Font("Segoe UI", 1, 36)); // NOI18N
        compareModeMessenger.setForeground(new Color(255, 255, 255));
        compareModeMessenger.setHorizontalAlignment(SwingConstants.CENTER);
        compareModeMessenger.setText("Compare Mode");

        // ComboBox1
        compareComboBox1 = new JComboBox<>();
        compareComboBox1.setBackground(new Color(0, 204, 204));
        compareComboBox1.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        compareComboBox1.setModel(new DefaultComboBoxModel<>(new String[]{"Chon","Bubble sort", "Insertion sort", "Selection sort", "Quick sort", "Merge sort", "Heap sort"}));
        compareComboBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                compareComboBox1ActionPerformed(evt);
            }
        });

        // ComboBox2
        compareComboBox2 = new JComboBox<>();
        compareComboBox2.setBackground(new Color(0, 204, 204));
        compareComboBox2.setFont(new Font("Segoe UI", 1, 12)); // NOI18N
        compareComboBox2.setModel(new DefaultComboBoxModel<>(new String[]{"Chon","Bubble sort", "Insertion sort", "Selection sort", "Quick sort", "Merge sort", "Heap sort"}));
        compareComboBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                compareComboBox2ActionPerformed(evt);
            }
        });

        // start button
        compareStartButton = new JButton();
        compareStartButton.setBackground(new Color(0, 204, 204));
        compareStartButton.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        compareStartButton.setText("Start");
        compareStartButton.addActionListener((new ActionListener() {
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
        comparePanel1 = new JPanel();
        comparePanel1.setBackground(new Color(255, 255, 255));
        GroupLayout comparePanel1Layout = new GroupLayout(comparePanel1);
        comparePanel1.setLayout(comparePanel1Layout);
        comparePanel1Layout.setHorizontalGroup(
                comparePanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 733, Short.MAX_VALUE)
        );
        comparePanel1Layout.setVerticalGroup(
                comparePanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 171, Short.MAX_VALUE)
        );

        // Panel set sortingDissplay
        comparePanel2 = new JPanel();
        comparePanel2.setBackground(new Color(255, 255, 255));
        GroupLayout comparePanel2Layout = new GroupLayout(comparePanel2);
        comparePanel2.setLayout(comparePanel2Layout);
        comparePanel2Layout.setHorizontalGroup(
                comparePanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 734, Short.MAX_VALUE)
        );
        comparePanel2Layout.setVerticalGroup(
                comparePanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 171, Short.MAX_VALUE)
        );

        // Name of the algorithm 1
        algorithmNameLabel1 = new JLabel("Unknown sort");
        algorithmNameLabel1.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        algorithmNameLabel1.setForeground(new Color(255, 255, 255));
        algorithmNameLabel1.setHorizontalAlignment(SwingConstants.CENTER);

        // Name of the algorithm 2
        algorithmNameLabel2 = new JLabel("Unknown sort");
        algorithmNameLabel2.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        algorithmNameLabel2.setForeground(new Color(255, 255, 255));
        algorithmNameLabel2.setHorizontalAlignment(SwingConstants.CENTER);

        // resetArray button
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
                                                .addComponent(compareComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(40, 40, 40)
                                                .addComponent(algorithmNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(backCompareMode, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(compareComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(113, 113, 113)
                                                                .addComponent(compareModeMessenger)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(arraySizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(resetArray, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(arraySizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(algorithmNameLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(compareStartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 39, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(comparePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(comparePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(compareModeMessenger, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(arraySizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(backCompareMode)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(compareComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comparePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(compareComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(algorithmNameLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comparePanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(algorithmNameLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(compareStartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(arraySizeButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(resetArray, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap())
        );
    }

    private void compareComboBox1ActionPerformed(ActionEvent evt) {
        Object selectedItem = compareComboBox1.getSelectedItem();
        String selectedText = selectedItem.toString();
        int[] x = SortingDisplay.generateRandomArray(arraySize, 100);

        // Kiểm tra nếu có sortingDisplay cũ, thì xóa nó đi trước khi thêm mới
        if (sorting1.getSortingDisplay() != null) {
            comparePanel1.remove(sorting1.getSortingDisplay());
            comparePanel1.revalidate(); // Cập nhật layout
            comparePanel1.repaint();    // Vẽ lại container
        }

        if ("Bubble sort".equals(selectedText)) {
            sorting1 = new BubbleSort(x);
            algorithmNameLabel1.setText("Bubble sort");
        } else if ("Insertion sort".equals(selectedText)) {
            sorting1 = new InsertionSort(x);
            algorithmNameLabel1.setText("Insertion sort");
        } else if ("Selection sort".equals(selectedText)) {
            sorting1 = new SelectionSort(x);
            algorithmNameLabel1.setText("Selection sort");
        } else if ("Quick sort".equals(selectedText)) {
            sorting1 = new QuickSort(x);
            algorithmNameLabel1.setText("Quick sort");
        } else if ("Merge sort".equals(selectedText)) {
            sorting1 = new MergeSort(x);
            algorithmNameLabel1.setText("Merge sort");
        } else if ("Heap sort".equals(selectedText)) {
            sorting1 = new HeapSort(x);
            algorithmNameLabel1.setText("Heap sort");
        } else {
            algorithmNameLabel1.setText("Unknown sort");
        }

        sorting1.sortingDisplay.setWidth(733);
        sorting1.sortingDisplay.setHeight(170);
        sorting1.sortingDisplay.setSize(733,170);

        // Thêm sortingDisplay mới vào container
        comparePanel1.add(sorting1.getSortingDisplay());

        if ("Chon".equals(selectedText)) {
            comparePanel1.remove(sorting1.getSortingDisplay());
            comparePanel1.revalidate(); // Cập nhật layout
            comparePanel1.repaint();    // Vẽ lại container
        }

        this.sorting1.sortingDisplay.sorting = this.sorting1;
    }
    private void compareComboBox2ActionPerformed(ActionEvent evt) {
        Object selectedItem = compareComboBox2.getSelectedItem();
        String selectedText = selectedItem.toString();
        int[] x = SortingDisplay.generateRandomArray(arraySize, 100);

        // Kiểm tra nếu có sortingDisplay cũ, thì xóa nó đi trước khi thêm mới
        if (sorting2.getSortingDisplay() != null) {
            comparePanel2.remove(sorting2.getSortingDisplay());
            comparePanel2.revalidate(); // Cập nhật layout
            comparePanel2.repaint();    // Vẽ lại container
        }

        if ("Bubble sort".equals(selectedText)) {
            sorting2 = new BubbleSort(x);
            algorithmNameLabel2.setText("Bubble sort");
        } else if ("Insertion sort".equals(selectedText)) {
            sorting2 = new InsertionSort(x);
            algorithmNameLabel2.setText("Insertion sort");
        } else if ("Selection sort".equals(selectedText)) {
            sorting2 = new SelectionSort(x);
            algorithmNameLabel2.setText("Selection sort");
        } else if ("Quick sort".equals(selectedText)) {
            sorting2 = new QuickSort(x);
            algorithmNameLabel2.setText("Quick sort");
        } else if ("Merge sort".equals(selectedText)) {
            sorting2 = new MergeSort(x);
            algorithmNameLabel2.setText("Merge sort");
        } else if ("Heap sort".equals(selectedText)) {
            sorting2 = new HeapSort(x);
            algorithmNameLabel2.setText("Heap sort");
        } else {
            algorithmNameLabel2.setText("Unknown sort");
        }

        sorting2.sortingDisplay.setWidth(733);
        sorting2.sortingDisplay.setHeight(170);
        sorting2.sortingDisplay.setSize(733,170);

        // Thêm sortingDisplay mới vào container
        comparePanel2.add(sorting2.getSortingDisplay());

        if ("Chon".equals(selectedText)) {
            comparePanel2.remove(sorting2.getSortingDisplay());
            comparePanel2.revalidate(); // Cập nhật layout
            comparePanel2.repaint();    // Vẽ lại container
        }

        this.sorting2.sortingDisplay.sorting = this.sorting2;
    }

    @Override
    public void start() throws InterruptedException {
        Thread sortingThread1 = new Thread(() -> {
            // Run the sort() method in the separate thread
            sorting1.sort();
        });

        Thread sortingThread2 = new Thread(() -> {
            // Run the sort() method in the separate thread
            sorting2.sort();
        });

        sortingThread1.start();
        sortingThread2.start();
    }

    @Override
    public void back() {
        compareComboBox1.setSelectedItem("Chon");
        compareComboBox2.setSelectedItem("Chon");
    }

    @Override
    public void resetArray() {
        int[] newValues = SortingDisplay.generateRandomArray(arraySize, 100);

        setArray1(newValues.clone());
        this.sorting1.setValues(array1);
        this.sorting1.getSortingDisplay().repaint();
        this.sorting1.sortingDisplay.resetStats();

        setArray2(newValues.clone());
        this.sorting2.setValues(array2);
        this.sorting2.getSortingDisplay().repaint();
        this.sorting2.sortingDisplay.resetStats();
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