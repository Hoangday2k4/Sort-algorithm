package finalexam.defaultsorting;

import finalexam.display.SortingDisplay;

public class HeapSort extends Sorting {
    public HeapSort(int[] values) {
        super(values);
        this.sortingDisplay = new SortingDisplay();
        this.sortingDisplay.setVisible(true);
    }

    @Override
    public void sort() {
        long startTime = System.currentTimeMillis();

        int n = values.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(n, i);

            timeExecuted = (System.currentTimeMillis() - startTime) / 1000.0;
            sortingDisplay.updateStats();
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap values[0] with the last element
            int temp = values[0];
            values[0] = values[i];
            values[i] = temp;

            // Increment swapCount for each swap
            swapCount++;
            timeExecuted = (System.currentTimeMillis() - startTime) / 1000.0;
            sortingDisplay.updateStats();

            heapify(i, 0);

            sortingDisplay.repaint();
            sortingDisplay.sleep();
        }
    }

    private void heapify(int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Increment accessCount for accessing values[i]
        accessCount++;

        if (left < n) {
            // Increment comparisons for the comparison in the if statement
            comparisons++;

            // Increment accessCount for accessing values[left]
            accessCount++;

            if (values[left] > values[largest]) {
                largest = left;
            }
        }

        if (right < n) {
            // Increment comparisons for the comparison in the if statement
            comparisons++;

            // Increment accessCount for accessing values[right]
            accessCount++;

            if (values[right] > values[largest]) {
                largest = right;
            }
        }

        if (largest != i) {
            // Swap values[i] with values[largest]
            int temp = values[i];
            values[i] = values[largest];
            values[largest] = temp;

            // Increment swapCount for each swap
            swapCount++;

            heapify(n, largest);

            sortingDisplay.repaint();
            sortingDisplay.sleep();
        }
    }

}
