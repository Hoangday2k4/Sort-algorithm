package finalexam.display.modeframe;

import javax.swing.*;

public abstract class SelectModePanel extends JPanel implements ModeInterface {
    protected int arraySize;
    protected JButton arraySizeButton;
    protected JLabel arraySizeLabel = new JLabel();

    protected void showArraySizeInputDialog() {
        String input = JOptionPane.showInputDialog("Nhập giá trị cho arraySize:");
        try {
            // Chuyển đổi giá trị nhập thành số nguyên
            int newSize = Integer.parseInt(input);

            // Cập nhật arraySize
            setArraySize(newSize);

            // Cập nhật hiển thị trên label
            arraySizeLabel.setText("Array size: " + arraySize);
            repaint();
        } catch (NumberFormatException ex) {
            // Xử lý nếu người dùng nhập không phải là số
            JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên.");
        }
    }

    @Override
    public abstract void start() throws InterruptedException;

    @Override
    public abstract void back();

    @Override
    public abstract void resetArray();

    // Cập nhật arraySize với giá trị mới
    @Override
    public void setArraySize(int newSize) {
        arraySize = newSize;
    }
}
