package finalexam.display;

import finalexam.defaultsorting.Sorting;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class SortingDisplay extends JPanel{
    private static int width = 733;
    private static int height = 365;
    private static final int DELAY = 5;
    private BufferedImage offScreenImage;

    public Sorting sorting;

    public static void setWidth(int width) {
        SortingDisplay.width = width;
    }

    public static void setHeight(int height) {
        SortingDisplay.height = height;
    }

    public SortingDisplay() {
    }
    private void drawArray(Graphics g) {
        int BAR_WIDTH = width / sorting.values.length;
        int SHIFT_AMOUNT = (width - BAR_WIDTH * sorting.values.length) / 2; // Adjust this value to control the shift

        for (int i = 0; i < sorting.values.length; i++) {
            int x = i * BAR_WIDTH + SHIFT_AMOUNT; // Include the shift
            int height = sorting.values[i];
            g.setColor(Color.BLUE);
            g.fillRect(x, SortingDisplay.height - height, BAR_WIDTH, height);
            g.setColor(Color.BLACK);
            g.drawRect(x, SortingDisplay.height - height, BAR_WIDTH, height);
        }
    }

    private void drawStats(Graphics g) {
        g.setColor(Color.RED);
        int yOffset = 20; // Adjust this value to control the vertical spacing

        Font newFont = new Font("Segoe UI", 1, 12); //set Font and size
        g.setFont(newFont);

        g.drawString("Access Count: " + sorting.accessCount, 10, yOffset);
        g.drawString("Comparisons: " + sorting.comparisons, 140, yOffset);
        g.drawString("Swap Count: " + sorting.swapCount, 290, yOffset);
        g.drawString("Time Executed: " + sorting.timeExecuted + " seconds", 440, yOffset);
    }

    public void updateStats() {
        repaint();
    }

    public void resetStats() {
        if (this.sorting != null) {
            sorting.accessCount = 0;
            sorting.comparisons = 0;
            sorting.swapCount = 0;
            sorting.timeExecuted = 0;
        }
    }

    public void sleep() {
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paint(Graphics g) {
        if (offScreenImage == null) {
            offScreenImage = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        }

        Graphics offScreenGraphics = offScreenImage.getGraphics();
        offScreenGraphics.setColor(Color.WHITE);
        offScreenGraphics.fillRect(0, 0, getWidth(), getHeight());

        drawArray(offScreenGraphics);
        drawStats(offScreenGraphics);

        g.drawImage(offScreenImage, 0, 0, this);
    }

    public static int[] generateRandomArray(int size, int columnHeight) {
        int[] arr = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(columnHeight);
        }

        return arr;
    }
}