package finalexam.defaultsorting;

import finalexam.display.SortingDisplay;

public class QuickSort extends Sorting {
    public QuickSort(int[] values) {
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

        quickSort(values, 0, values.length - 1, startTime);
    }

    private void quickSort(int[] arr, int low, int high, long startTime) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high, startTime);

            quickSort(arr, low, partitionIndex - 1, startTime);
            quickSort(arr, partitionIndex + 1, high, startTime);
        }
    }

    private int partition(int[] arr, int low, int high, long startTime) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            this.accessCount++;

            timeExecuted = (System.currentTimeMillis() - startTime) / 1000.0;
            sortingDisplay.updateStats();

            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                this.swapCount++;

                sortingDisplay.repaint();
                sortingDisplay.sleep();
            }

            this.comparisons++;
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        this.swapCount++;

        sortingDisplay.repaint();
        sortingDisplay.sleep();

        return i + 1;
    }
}