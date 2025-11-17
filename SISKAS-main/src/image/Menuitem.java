package image;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author UsEr
 */
public class Menuitem extends javax.swing.JPanel {
     

    public ArrayList<Menuitem> getSubMenu() {
        
        return subMenu;
        
    }
    
    private final ArrayList<Menuitem> subMenu = new ArrayList<>();  
    private ActionListener act;
    private Color hoverBackgroundColor = new Color(109, 219, 192);
    private Color originalBackgroundColor;
    
    
    
    public Menuitem(Icon icon, boolean sbm, Icon iconSub, String menuName, ActionListener act, Menuitem... subMenu) {
        initComponents();
        lb_icon.setIcon(icon);
        lb_menuName.setText(menuName);
        
        lb_panah = new JLabel(new ImageIcon(getClass().getResource("/image/bawah.png")));
        lb_panah.setPreferredSize(new Dimension(20, 20)); // Sesuaikan ukuran sesuai kebutuhan
        
        add(lb_panah);
        
        

        if (act != null){
        this.act = act;
        }
        this.setSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE, 45));
        for (int i = 0; i < subMenu.length; i++){
            this.subMenu.add(subMenu[i]);
            subMenu[i].setVisible(false);
        }
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                setBackground(hoverBackgroundColor);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                setBackground(originalBackgroundColor);
            }
        });
        }
    

 
    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_menuName = new javax.swing.JLabel();
        lb_icon = new javax.swing.JLabel();
        lb_panah = new javax.swing.JLabel();

        setBackground(new java.awt.Color(60, 211, 173));
        setForeground(new java.awt.Color(0, 167, 98));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        lb_menuName.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 14)); // NOI18N
        lb_menuName.setForeground(new java.awt.Color(255, 255, 255));
        lb_menuName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb_menuName.setText("Menu Item.....");

        lb_icon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_menuName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_panah, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lb_menuName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(lb_icon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_panah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean showing = false;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        
        if (showing){
            hideMenu();
        }else {
            showMenu();
        }
        if (act != null){
            act.actionPerformed(null);
        }
        
            
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb_icon;
    private javax.swing.JLabel lb_menuName;
    private javax.swing.JLabel lb_panah;
    // End of variables declaration//GEN-END:variables

    private void hideMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = subMenu.size() - 1; i >= 0; i--) {
                    sleep();
                    subMenu.get(i).setVisible(false);
                    subMenu.get(i).hideMenu();
                }
                // Tampilkan ikon panah ke bawah
                lb_panah.setIcon(new ImageIcon(getClass().getResource("/image/barang.png")));
                System.out.println("Mencoba mengatur ikon panah ke bawah");


                getParent().repaint();
                getParent().revalidate();
                showing = false;
            }
        }).start();
    }
    private void showMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < subMenu.size(); i++) {
                    sleep();
                    subMenu.get(i).setVisible(true);

                }
                showing = true;
                // Tampilkan ikon panah ke atas
                lb_panah.setIcon(new ImageIcon(getClass().getResource("/image/atas.png")));
                System.out.println("Mencoba mengatur ikon panah ke atas");


                getParent().repaint();
                getParent().revalidate();

            }
        }).start();
    }
    private void sleep(){
        try{
            Thread.sleep(20);
        } catch (Exception e){
            
        }
    }
}
