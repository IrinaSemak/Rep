import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    private RadixSort radixSort = new RadixSort();
    private JTextArea displayArea;

    public Main() {
        JFrame frame = new JFrame("Radix Sort Management App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));

        JTextField arrayField = new JTextField();

        inputPanel.add(new JLabel("Массив (через запятую):"));
        inputPanel.add(arrayField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Добавить");
        JButton removeButton = new JButton("Удалить");
        JButton updateButton = new JButton("Обновить");
        JButton sortButton = new JButton("Отсортировать");
        JButton showAllButton = new JButton("Показать все");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(sortButton);
        buttonPanel.add(showAllButton);

        addButton.addActionListener(e -> {
            String arrayStr = arrayField.getText().trim();
            if (arrayStr.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Пожалуйста, введите массив!");
                return;
            }

            try {
                String[] arrayParts = arrayStr.split(",");
                int[] array = new int[arrayParts.length];
                for (int i = 0; i < arrayParts.length; i++) {
                    array[i] = Integer.parseInt(arrayParts[i].trim());
                }

                radixSort.addArray(array);
                updateDisplay();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Неверный ввод числовых значений!");
            }
        });

        removeButton.addActionListener(e -> {
            String indexStr = JOptionPane.showInputDialog(frame, "Введите индекс массива для удаления:");
            if (indexStr != null) {
                try {
                    int index = Integer.parseInt(indexStr.trim()) - 1;
                    radixSort.removeArrayByIndex(index);
                    updateDisplay();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Неверный индекс!");
                }
            }
        });

        updateButton.addActionListener(e -> {
            String indexStr = JOptionPane.showInputDialog(frame, "Введите индекс массива для обновления:");
            if (indexStr != null) {
                try {
                    int index = Integer.parseInt(indexStr.trim()) - 1;
                    String arrayStr = JOptionPane.showInputDialog(frame, "Введите новый массив (через запятую):");
                    if (arrayStr != null) {
                        String[] arrayParts = arrayStr.split(",");
                        int[] array = new int[arrayParts.length];
                        for (int i = 0; i < arrayParts.length; i++) {
                            array[i] = Integer.parseInt(arrayParts[i].trim());
                        }
                        radixSort.updateArray(index, array);
                        updateDisplay();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Неверный индекс или массив!");
                }
            }
        });

        sortButton.addActionListener(e -> {
            for (int[] arr : radixSort.getAllArrays()) {
                RadixSort.radixSort(arr);
            }
            updateDisplay();
        });

        showAllButton.addActionListener(e -> updateDisplay());

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void updateDisplay() {
        List<int[]> arrays = radixSort.getAllArrays();
        StringBuilder sb = new StringBuilder("Массивы:\n");
        for (int i = 0; i < arrays.size(); i++) {
            sb.append(i + 1).append(". ");
            for (int num : arrays.get(i)) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        displayArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}
