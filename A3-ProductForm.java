package Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductForm extends JFrame {
    private JTextField searchField;
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton deleteButton, editButton, createButton;

    public ProductForm() {
        setTitle("GESTIONAR INFORMACIÓN");
        setSize(600, 305);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel de búsqueda
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Buscar: "));
        searchField = new JTextField(20);
        searchPanel.add(searchField);
        add(searchPanel, BorderLayout.NORTH);

        // Datos de la tabla
        String[] columnNames = {"Nombre", "Precio", "Marca", "Codigo"};
        Object[][] data = {
            {"Laptop", 2000, "Asus", 1},
            {"Teclado", 100, "Razer", 2},
            {"Mouse", 50, "MSI", 3},
            {"Monitor", 250, "Teros", 4},
            {"Micrófono", 75, "HP", 5},
            {"Auricular", 125, "Corsair", 6},
            {"USB", 20, "Lenovo", 7},
            {"Impresor", 500, "Canon", 10},
            {"Celular", 1250, "Apple", 11},
            {"Tablet", 800, "Samsung", 12}        
        };

        tableModel = new DefaultTableModel(data, columnNames);
        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Panel de botones en la parte inferior
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        createButton = new JButton("Crear Producto");
        buttonPanel.add(createButton);

        editButton = new JButton("Editar Producto");
        buttonPanel.add(editButton);

        deleteButton = new JButton("Eliminar Producto");
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Filtro de búsqueda
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filterTable();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filterTable();
            }
        });

        // Botón eliminar
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int modelRow = table.convertRowIndexToModel(selectedRow);
                    tableModel.removeRow(modelRow);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Botón editar
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    int modelRow = table.convertRowIndexToModel(selectedRow);
                    Object[] productData = {
                        tableModel.getValueAt(modelRow, 0),
                        tableModel.getValueAt(modelRow, 1),
                        tableModel.getValueAt(modelRow, 2),
                        tableModel.getValueAt(modelRow, 3)
                    };

                    JTextField nameField = new JTextField(productData[0].toString());
                    JTextField priceField = new JTextField(productData[1].toString());
                    JTextField brandField = new JTextField(productData[2].toString());
                    JTextField codeField = new JTextField(productData[3].toString());
                    JComponent[] inputs = new JComponent[] {
                        new JLabel("Nombre"),
                        nameField,
                        new JLabel("Precio"),
                        priceField,
                        new JLabel("Marca"),
                        brandField,
                        new JLabel("Codigo"),
                        codeField
                    };

                    int result = JOptionPane.showConfirmDialog(null, inputs, "Editar Producto", JOptionPane.PLAIN_MESSAGE);
                    if (result == JOptionPane.OK_OPTION) {
                        tableModel.setValueAt(nameField.getText(), modelRow, 0);
                        tableModel.setValueAt(priceField.getText(), modelRow, 1);
                        tableModel.setValueAt(brandField.getText(), modelRow, 2);
                        tableModel.setValueAt(codeField.getText(), modelRow, 3);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila para editar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Botón crear
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField nameField = new JTextField();
                JTextField priceField = new JTextField();
                JTextField brandField = new JTextField();
                JTextField codeField = new JTextField();
                JComponent[] inputs = new JComponent[] {
                    new JLabel("Nombre"),
                    nameField,
                    new JLabel("Precio"),
                    priceField,
                    new JLabel("Marca"),
                    brandField,
                    new JLabel("Codigo"),
                    codeField
                };

                int result = JOptionPane.showConfirmDialog(null, inputs, "Crear Producto", JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    tableModel.addRow(new Object[]{
                        nameField.getText(),
                        priceField.getText(),
                        brandField.getText(),
                        codeField.getText()
                    });
                }
            }
        });
    }

    private void filterTable() {
        String searchText = searchField.getText().toLowerCase();
        DefaultTableModel filteredModel = new DefaultTableModel(new String[]{"Nombre", "Precio", "Marca", "Codigo"}, 0);

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String nombre = tableModel.getValueAt(i, 0).toString().toLowerCase();
            String precio = tableModel.getValueAt(i, 1).toString().toLowerCase();
            String marca = tableModel.getValueAt(i, 2).toString().toLowerCase();
            String codigo = tableModel.getValueAt(i, 3).toString().toLowerCase();

            if (nombre.contains(searchText) || precio.contains(searchText) || marca.contains(searchText) || codigo.contains(searchText)) {
                filteredModel.addRow(new Object[]{nombre, precio, marca, codigo});
            }
        }

        table.setModel(filteredModel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductForm().setVisible(true);
        });
    }
}
