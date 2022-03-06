/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.unicauca.microkernel.presentation;

import co.unicauca.microkernel.infra.Publisher;
import co.unicauca.microkernel.business.DeliveryService;
import co.unicauca.microkernel.business.ProductService;
import co.unicauca.microkernel.common.entities.Delivery;
import co.unicauca.microkernel.common.entities.Product;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.List;

/**
 *
 * @author ahurtado
 */
public class GUISendProduct extends javax.swing.JFrame{
    
    private ProductService productService;
    private DeliveryService deliveryService;
    List<Product> products;
    Publisher publisher;

    /**
     * Creates new form GUISendProduct
     */
    public GUISendProduct() {
        initComponents();
        productService = new ProductService();
        publisher = new Publisher();
        products = productService.getAll();
        for (int index = 0; index < products.size(); index++) {
        jComboBox1.addItem(products.get(index).getName());
        }
        jTextField4.setEnabled(false);
        jTextField4.setText("...");
        jButton2.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Envío de producto");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.GridLayout(4, 2));

        jLabel2.setText("Seleccione el producto");
        jPanel1.add(jLabel2);

        jPanel1.add(jComboBox1);

        jLabel3.setText("Indique la distancia en Km");
        jPanel1.add(jLabel3);
        jPanel1.add(jTextField2);

        jLabel4.setText("Indique el código del país");
        jPanel1.add(jLabel4);
        jPanel1.add(jTextField3);

        jLabel5.setText("Costo del Envío");
        jPanel1.add(jLabel5);
        jPanel1.add(jTextField4);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jButton1.setText("Calcular Valor de Envío");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setText("Realizar Envío Pago a Contra Entrega");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    double costo = 0;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Product selectedProduct = products.get(this.jComboBox1.getSelectedIndex());
        Delivery deliveryEntity = new Delivery(selectedProduct, 
                                                Double.parseDouble(jTextField2.getText()), 
                                                jTextField3.getText());
        try {
            deliveryService = new DeliveryService();
            double cost = deliveryService.calculateDeliveryCost(deliveryEntity);
            jTextField4.setText(""+cost);
            this.costo = cost;
            jButton2.setVisible(true);
        } catch (Exception exception) {
            System.out.println("No fue posible calcular el costo del envío. " + exception.getMessage());
        }

        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Product selectedProduct = products.get(this.jComboBox1.getSelectedIndex());
        //Gson gson = new Gson();
        //String msgJson = gson.toJson(selectedProduct);
        Gson gson = new Gson();
        JsonObject ObjectMessage = (JsonObject) gson.toJsonTree(selectedProduct);
        ObjectMessage.addProperty("price", this.costo);
        ObjectMessage.addProperty("country", this.jTextField3.getText());
        publisher.publish(ObjectMessage.toString());//Publicar Mensaje
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables

}
