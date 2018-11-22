//This class is for the start menu of the game
package supersurviver;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class MenuPanel extends javax.swing.JPanel {
    
    SuperSurvivorView jFrame;
    SuperPanel sp = new SuperPanel();
//    JTextArea jta = new JTextArea("TESTING");
    
    private static Font monoFont = new Font("Copperplate Gothic Bold", Font.BOLD
      | Font.ITALIC, 70);
    public MenuPanel(SuperSurvivorView jframe) {
        initComponents();
        this.setVisible(true);
        this.jFrame = jframe;
        jframe.add(this);
        logoPanel.add(sp);
    }
           
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        playerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        btnPlay = new javax.swing.JButton();
        logoPanel = new javax.swing.JPanel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        playerPanel.setLayout(new java.awt.BorderLayout());

        jLabel1.setText("Welcome Player1!");
        playerPanel.add(jLabel1, java.awt.BorderLayout.CENTER);

        buttonsPanel.setLayout(new java.awt.GridBagLayout());

        btnExit.setBackground(new java.awt.Color(0, 0, 0));
        btnExit.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 36)); // NOI18N
        btnExit.setForeground(new java.awt.Color(118, 215, 196));
        btnExit.setText("EXIT");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 361;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 275, 30, 257);
        buttonsPanel.add(btnExit, gridBagConstraints);

        btnPlay.setBackground(new java.awt.Color(0, 0, 0));
        btnPlay.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 36)); // NOI18N
        btnPlay.setForeground(new java.awt.Color(118, 215, 196));
        btnPlay.setText("PLAY");
        btnPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlay.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 347;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 275, 0, 257);
        buttonsPanel.add(btnPlay, gridBagConstraints);

        logoPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(playerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(playerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    //Play Button
    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        BeginningStoryPanel begPan = new BeginningStoryPanel(jFrame);
        jFrame.remove(this);
        begPan.setVisible(false);
        jFrame.add(begPan);
        jFrame.validate();
        jFrame.repaint();
        begPan.setBackground(Color.white);
        begPan.setSize(jFrame.getWidth() - 20, jFrame.getHeight() - 50);   
        begPan.setVisible(true);
    }//GEN-LAST:event_btnPlayActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0); //exit
    }//GEN-LAST:event_btnExitActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized

    }//GEN-LAST:event_formComponentResized
    
    public void addPlayListener(ActionListener listener){
        this.btnPlay.addActionListener(listener);
    }
    
    public void addExitListener(ActionListener listener){
        this.btnExit.addActionListener(listener);
    }
    
    class SuperPanel extends JPanel{
        
        //Draws the Title of the Game 'SuperSurvivor'   
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setFont(monoFont);
            g.drawString("Super", this.getWidth()/2 - 100, this.getHeight()/2);
            g.setColor(Color.green);
            g.drawString("Suvivor", this.getWidth()/2 -150, this.getHeight()/2 + 50);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPlay;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JPanel playerPanel;
    // End of variables declaration//GEN-END:variables
}
