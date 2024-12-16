import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    private Repository<Sneakers> repository = new Repository<>();
    private JTextArea displayArea;

    public Main() {
        JFrame frame = new JFrame("Sneakers Management App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(7, 2));

        JTextField modelField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField typeField = new JTextField();
        JTextField producerField = new JTextField();
        JTextField countryField = new JTextField();

        inputPanel.add(new JLabel("Модель:"));
        inputPanel.add(modelField);
        inputPanel.add(new JLabel("Цена:"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Тип:"));
        inputPanel.add(typeField);
        inputPanel.add(new JLabel("Производитель:"));
        inputPanel.add(producerField);
        inputPanel.add(new JLabel("Страна:"));
        inputPanel.add(countryField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Добавить");
        JButton removeButton = new JButton("Удалить");
        JButton showAllButton = new JButton("Показать все");

        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(showAllButton);

        addButton.addActionListener(e -> {
            String model = modelField.getText().trim();
            String priceStr = priceField.getText().trim();
            String type = typeField.getText().trim();
            String producerName = producerField.getText().trim();
            String country = countryField.getText().trim();

            if (model.isEmpty() || priceStr.isEmpty() || type.isEmpty() || producerName.isEmpty() || country.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Пожалуйста, заполните все поля!");
                return;
            }

            try {
                double price = Double.parseDouble(priceStr);
                Producer producer = new Producer(producerName, country);
                repository.add(new Sneakers(model, price, type, producer));
                updateDisplay();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Неверный ввод числовых значений!");
            }
        });

        removeButton.addActionListener(e -> {
            String indexStr = JOptionPane.showInputDialog(frame, "Введите индекс модели для удаления:");
            if (indexStr != null) {
                try {
                    int index = Integer.parseInt(indexStr.trim()) - 1;
                    List<Sneakers> sneakersList = repository.getAll();
                    if (index >= 0 && index < sneakersList.size()) {
                        repository.remove(sneakersList.get(index));
                        updateDisplay();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Неверный индекс!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Неверный индекс!");
                }
            }
        });

        showAllButton.addActionListener(e -> updateDisplay());

        frame.setLayout(new BorderLayout());
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void updateDisplay() {
        List<Sneakers> sneakersList = repository.getAll();
        StringBuilder sb = new StringBuilder("Список кроссовок:\n");
        for (int i = 0; i < sneakersList.size(); i++) {
            sb.append(i + 1).append(". ").append(sneakersList.get(i)).append("\n");
        }
        displayArea.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Main::new);
    }
}