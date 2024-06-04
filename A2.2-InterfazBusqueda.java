package Avance2;

import java.util.ArrayList;
import java.util.List;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class InterfazBusqueda extends javax.swing.JFrame {

    DefaultTableModel modeloOriginal;
    List<Object[]> datosOriginales;
    
    public InterfazBusqueda() {
        initComponents();
        modeloOriginal = (DefaultTableModel) Table.getModel();
        datosOriginales = new ArrayList<>();
        
        // Copiar los datos originales a la lista
        for (int i = 0; i < modeloOriginal.getRowCount(); i++) {
            datosOriginales.add(new Object[]{
                modeloOriginal.getValueAt(i, 0),
                modeloOriginal.getValueAt(i, 1),
                modeloOriginal.getValueAt(i, 2),
                modeloOriginal.getValueAt(i, 3)
            });
        }

        // Agregar el DocumentListener al JTextField para escuchar cambios en tiempo real
        jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                filtrarTabla();
            }
            public void removeUpdate(DocumentEvent e) {
                filtrarTabla();
            }
            public void changedUpdate(DocumentEvent e) {
                filtrarTabla();
            }
        });
    }

    private void filtrarTabla() {
        String filtro = jTextField1.getText().toLowerCase();
        DefaultTableModel modeloFiltrado = new DefaultTableModel();
        modeloFiltrado.setColumnIdentifiers(new Object[]{"Nombre", "Precio", "Marca", "Codigo"});
        
        if (filtro.isEmpty()) {
            // Si no hay filtro, mostrar todos los datos
            for (Object[] fila : datosOriginales) {
                modeloFiltrado.addRow(fila);
            }
        } else {
            // Filtrar los datos que coincidan con el texto ingresado
            for (Object[] fila : datosOriginales) {
                String nombre = fila[0].toString().toLowerCase();
                String marca = fila[2].toString().toLowerCase();
                String codigo = fila[3].toString().toLowerCase();
                if (nombre.contains(filtro) || marca.contains(filtro) || codigo.contains(filtro)) {
                    modeloFiltrado.addRow(fila);
                }
            }
        }
        
        Table.setModel(modeloFiltrado);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Laptop",  new Integer(2000), "Asus",  new Integer(1)},
                {"Teclado",  new Integer(100), "Razer",  new Integer(2)},
                {"Mouse",  new Integer(50), "MSI",  new Integer(3)},
                {"Monitor",  new Integer(250), "Teros",  new Integer(4)},
                {"Microfono",  new Integer(75), "Huawei",  new Integer(5)},
                {"Auricular",  new Integer(125), "Corsair",  new Integer(6)},
                {"USB",  new Integer(20), "HP",  new Integer(7)},
                {"Impresor",  new Integer(500), "Canon",  new Integer(10)},
                {"Celular",  new Integer(1250), "Apple",  new Integer(11)},
                {"Tablet",  new Integer(800), "Samsung",  new Integer(12)}
            },
            new String [] {
                "Nombre", "Precio", "Marca", "Codigo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Table);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Busqueda");

        jTextField1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    
  public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazBusqueda().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify                     
    private javax.swing.JTable Table;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   


}
