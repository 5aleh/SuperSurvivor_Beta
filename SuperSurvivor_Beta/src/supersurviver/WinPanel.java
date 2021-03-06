package supersurviver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Nkwabo Saleh
 */

public class WinPanel extends javax.swing.JPanel {

    /**
     * Creates new form WinPanel
     */
    
    BufferedImage img;
    SuperSurvivorView jFrame;
    public WinPanel(SuperSurvivorView jframe) {
        initComponents();
        this.jFrame = jframe;
        try {
            img = ImageIO.read(new File("Images\\youwinimg.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(CabinPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
            MenuPanel menuPan = new MenuPanel(jFrame);
            jFrame.remove(this);
            jFrame.add(menuPan);
            jFrame.validate();
            jFrame.repaint();
            jFrame.pack();
            //menuPan.setBackground(Color.white);
            menuPan.setSize(jFrame.getWidth() - 20, jFrame.getHeight() - 50);   
            menuPan.setVisible(true);
    }//GEN-LAST:event_formMouseReleased

    public void addWinListener(ActionListener listener){
        this.addMouseListener((MouseListener) listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
