package finalexam.defaultsorting;

import finalexam.display.SortingDisplay;

public class InsertionSort extends Sorting {
    public InsertionSort(int[] values) {
        super(values);
        this.sortingDisplay = new SortingDisplay();
        this.sortingDisplay.setVisible(true);
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public SortingDisplay getSortingDisplay() {
        return sortingDisplay;
    }

    public void setSortingDisplay(SortingDisplay sortingDisplay) {
        this.sortingDisplay = sortingDisplay;
    }

    @Override
    public void sort() {
        long startTime = System.currentTimeMillis();

        int n = values.length;
        for (int i = 1; i < n; i++) {
            int key = values[i];
            int j = i - 1;

            // Increment accessCount for accessing key
            accessCount++;

            while (j >= 0 && values[j] > key) {
                // Increment accessCount for accessing values[j]
                accessCount++;
                timeExecuted = (System.currentTimeMillis() - startTime) / 1000.0;
                sortingDisplay.updateStats();

                // Increment comparisons for the comparison in the while loop
                comparisons++;

                values[j + 1] = values[j];

                // Increment swapCount for each swap
                swapCount++;

                j = j - 1;

                this.sortingDisplay.repaint();
                this.sortingDisplay.sleep();
            }

            values[j + 1] = key;
        }
    }

}