package Avance2;


import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class Interfaz extends javax.swing.JFrame {
    
    private DefaultTableModel tableModel;
    private List<Producto> productos;
    
    public Interfaz() {
        productos = new ArrayList<>();
        productos.add(new Producto("Laptop", 2000, "Asus", 1));
        productos.add(new Producto("Teclado", 100, "Razer", 2));
        productos.add(new Producto("Mouse", 50, "MSI", 3));
        productos.add(new Producto("Monitor", 250, "Teros", 4));
        productos.add(new Producto("Micrófono", 75, "HP", 5));
        productos.add(new Producto("Auricular", 125, "Corsair", 6));
        productos.add(new Producto("USB", 20, "Lenovo", 7));
        productos.add(new Producto("Impresor", 500, "Canon", 10));
        productos.add(new Producto("Celular", 1250, "Apple", 11));
        productos.add(new Producto("Tablet", 800, "Samsung", 12));

        tableModel = new DefaultTableModel(
            new Object [][] {},
            new String [] {"Nombre", "Precio", "Marca", "Código"}
        );

        initComponents();
        Table1.setModel(tableModel);
        updateTable();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        OrdenamientoNombre = new javax.swing.JButton();
        OrdenamientoPrecio = new javax.swing.JButton();
        OrdenamientoMarca = new javax.swing.JButton();
        OrdenamientoCodigo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Laptop",  new Integer(2000), "Asus",  new Integer(1)},
                {"Teclado",  new Integer(100), "Razer",  new Integer(2)},
                {"Mouse",  new Integer(50), "MSI",  new Integer(3)},
                {"Monitor",  new Integer(250), "Teros",  new Integer(4)},
                {"Microfono",  new Integer(75), "HP",  new Integer(5)},
                {"Auricular",  new Integer(125), "Corsair",  new Integer(6)},
                {"USB",  new Integer(20), "Lenovo",  new Integer(7)},
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
        jScrollPane1.setViewportView(Table1);

        OrdenamientoNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        OrdenamientoNombre.setText("Ordenamiento por Nombre");
        OrdenamientoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenamientoNombreActionPerformed(evt);
            }
        });

        OrdenamientoPrecio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        OrdenamientoPrecio.setText("Ordenamiento por Precio");
        OrdenamientoPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenamientoPrecioActionPerformed(evt);
            }
        });

        OrdenamientoMarca.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        OrdenamientoMarca.setText("Ordenamiento por Marca");
        OrdenamientoMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenamientoMarcaActionPerformed(evt);
            }
        });

        OrdenamientoCodigo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        OrdenamientoCodigo.setText("Ordenamiento por Codigo");
        OrdenamientoCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenamientoCodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(OrdenamientoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OrdenamientoMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(98, 98, 98)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(OrdenamientoCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OrdenamientoPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OrdenamientoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OrdenamientoPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OrdenamientoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OrdenamientoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        


    private void OrdenamientoCodigoActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        OrdenamientoDeDatos.ordenarPorCodigo(productos);
        updateTable();

    }                                                  

    private void OrdenamientoMarcaActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        OrdenamientoDeDatos.ordenarPorMarca(productos);
        updateTable();
    }                                                 

    private void OrdenamientoPrecioActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        OrdenamientoDeDatos.ordenarPorPrecio(productos);
        updateTable();
    }                                                  

    private void OrdenamientoNombreActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        OrdenamientoDeDatos.ordenarPorNombre(productos);
        updateTable();
    }                                                  
    
    private void updateTable() {
        tableModel.setRowCount(0);
        for (Producto producto : productos) {
            tableModel.addRow(new Object[]{producto.getNombre(), producto.getPrecio(), producto.getMarca(), producto.getCodigo()});
        }
    }
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton OrdenamientoCodigo;
    private javax.swing.JButton OrdenamientoMarca;
    private javax.swing.JButton OrdenamientoNombre;
    private javax.swing.JButton OrdenamientoPrecio;
    private javax.swing.JTable Table1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
