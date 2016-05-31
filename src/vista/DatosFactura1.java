
package vista;

import java.util.Collections;
import java.util.Date;
import javax.swing.JOptionPane;
import modelo.Cliente1;
import modelo.Factura1;
import modelo.ListaClientes1;
import modelo.ListaProductos1;
import modelo.Producto1;
import static supermercado.Supermercado.clientes;
import static supermercado.Supermercado.facturas;
import static supermercado.Supermercado.ficheroFacturas;
import static supermercado.Supermercado.ficheroProductos;
import static supermercado.Supermercado.productos;
import utilidades.EntradaDatos;

/**
 *
 * @author kinky
 */
public class DatosFactura1 extends javax.swing.JDialog {
    
    private Factura1 factura;   
    private ListaClientes1 todosLosClientes;    
    private ListaProductos1 losProductos;

    public ListaProductos1 getLosProductos() {
        return losProductos;
    }

    public void setLosProductos(ListaProductos1 losProductos) {
        this.losProductos = losProductos;
    }


    public ListaClientes1 getTodosLosClientes() {
        return todosLosClientes;
    }

    public void setTodosLosClientes(ListaClientes1 todosLosClientes) {
        this.todosLosClientes = todosLosClientes;
    }


    public Factura1 getFactura() {
        return factura;
    }

    public void setFactura(Factura1 factura) {
        this.factura = factura;
    }


    /**
     * Creates new form DatosFactura1
     */
    public DatosFactura1(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        factura = new Factura1();
        
        todosLosClientes = clientes.copiaClientes();
        Cliente1 auxiliar = new Cliente1();
        auxiliar.setApellidos("---Escoge un cliente---");
        todosLosClientes.altaCliente(auxiliar);
        Collections.sort(todosLosClientes.getLista());
        
        losProductos = productos.productosEnStock();
        Producto1 escoge = new Producto1();
        escoge.setDescripcion("---Escoge un producto---");
        losProductos.altaProducto(escoge);
        Collections.sort(losProductos.getLista());
        
        
        initComponents();
        
        jXDatePicker1.setDate(new Date());
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jXDatePicker1 = new org.jdesktop.swingx.JXDatePicker();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Nº de Fra:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 11, 76, 23);

        jLabel2.setText("Cliente:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 52, 76, 23);

        jLabel3.setText("Producto:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 93, 76, 24);

        jLabel4.setText("Cantidad:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 135, 76, 22);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(119, 12, 85, 20);

        jLabel5.setText("Fecha:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(234, 11, 80, 23);
        getContentPane().add(jXDatePicker1);
        jXDatePicker1.setBounds(332, 11, 91, 22);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(119, 53, 304, 20);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(119, 95, 304, 20);
        getContentPane().add(jSpinner1);
        jSpinner1.setBounds(119, 136, 53, 20);

        jLabel6.setText("Total:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(264, 198, 65, 24);

        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jTextField2);
        jTextField2.setBounds(347, 166, 76, 48);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(400, 290, 71, 23);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 290, 90, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes indicar un nº de fra");
        } else if(EntradaDatos.esEntero(jTextField1.getText())) {
            if (facturas.existeFactura(factura)) {
                JOptionPane.showMessageDialog(this, "Ya existe una fra con ese nº");   
        } else if (jComboBox1.getSelectedIndex() < 1 || factura.getCliente().equals(new Cliente1())) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un cliente");
        } else if (jComboBox2.getSelectedIndex() < 1 || factura.getProducto().equals(new Cliente1())) {
            JOptionPane.showMessageDialog(this, "Debes seleccionar un producto");
        } else if (factura.getCantidad() < 1) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser al menos 1");
        } else if (factura.getCantidad() > factura.getProducto().getStock()) {
            JOptionPane.showMessageDialog(this, "No hay suficiente stock");
            
        } else {
            facturas.altaFactura(factura);
            ficheroFacturas.grabar(facturas);
            factura.getProducto().setStock(factura.getProducto().getStock() - factura.getCantidad());
            ficheroProductos.grabar(productos);
            JOptionPane.showMessageDialog(this, "El nº de fra tiene que ser un número!");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void actualizarLabelTotal() {
        totalLabel1.setText(String.valueOf(factura.total()));
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker1;
    // End of variables declaration//GEN-END:variables
}
