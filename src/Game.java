
import AppPackage.AnimationClass;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

//This is a demon hunter game that only contains 2 waves of demons
//It contains 4 labels for demons and a system to reuse the labels and assign new demons to empty labels because the code for the game is designed for a large multi level game
//The game can have a max of 4 demons on screen at once, but in the demo the max amount that is seen at once is 3 demons
//This is a DEMO VERSION of the game Demon Hunter
//demons and split demons are worth 10 points, small demons are worth 20 points
//a perfect score in the demo is 90

public class Game extends javax.swing.JFrame {
    //create an array of demons
    AbstractDemon d[];
    
    //create and animationclass to allow the movement of Demons
    AnimationClass ac= new AnimationClass();
    //declare 3 threads to check if demons go off screen
    Thread thread, thread2, thread3;
    int che=1;
    

    

    
    
    public Game() {
        initComponents();
        this.getContentPane().setBackground(Color.white);
        d = new AbstractDemon[8];
        d[0]= new Demon();
        //create 5 and 6 to allow thread2 to run
        d[5]=new SmallDemon();
        d[6]=new SmallDemon();
        int id=1;
        //start labels and wave 2 button not visible
        lbld1.setVisible(false);
        lbld2.setVisible(false);
        lbld3.setVisible(false);
        lbld4.setVisible(false);
        btnwave2.setVisible(false);
        thread = new Thread(){
            public void run(){
                while(true){
                    try {
                        //see if demon is off screen
                        if(d[1].getlbl().getLocation().x>1200){
                            d[1].getlbl().setVisible(false);
                            d[1].getlbl().setIcon(null);
                            d[1].setAlive(false);
                            //check if next wave can start
                            if(d[1].check()==false && d[2].check()==false){
                            btnwave2.setVisible(true);
                            }
                        }
                        //see if demon is off screen
                         if(d[2].getlbl().getLocation().x>1200){
                            d[2].getlbl().setVisible(false);
                            d[2].getlbl().setIcon(null);
                            d[2].setAlive(false);
                            //check if next wave can start
                            if(d[1].check()==false && d[2].check()==false){
                            btnwave2.setVisible(true);
                            }
                        }
                        
                        
                        Thread.currentThread().sleep(1000);
                } catch (InterruptedException ex) {
                    }
                }
            }
        };

        thread2 = new Thread(){
            public void run(){
                while(true){
                    try {
                        //see if demon is off screen
                           if(d[4].getlbl().getLocation().x>1200){
                            d[4].getlbl().setVisible(false);
                            d[4].getlbl().setIcon(null);
                            d[4].setAlive(false);
                            //check if demon split has split, if it has not check if game done
                            if(che==1){
                                if(d[3].check()==false && d[4].check()==false){
                                    btnwave2.setText("Game Over");
                                    end();
                                }
                            }
                            //if demon split has split check to see if everything is dead
                            else if(d[3].check()==false && d[4].check()==false && d[5].check()==false && d[6].check()==false){
                                btnwave2.setText("Game Over");
                                end();
                            }
                        }
                        //check if demon iss off screen   
                        if(d[3].getlbl().getLocation().x>1200){
                            d[3].getlbl().setVisible(false);
                            d[3].getlbl().setIcon(null);
                            d[3].setAlive(false);
                            //check if game is done
                            if(d[3].check()==false && d[4].check()==false){
                                btnwave2.setText("Game Over");
                                end();
                            }
                        }
                      
                        
                        
                        Thread.currentThread().sleep(1000);
                } catch (InterruptedException ex) {
                    }
                }
            }
        };
        
        thread3 = new Thread(){
            public void run(){
                while(true){
                    try {
                        //check if demon is off screen
                        if(d[5].getlbl().getLocation().x>1200){
                            d[5].getlbl().setVisible(false);
                            d[5].getlbl().setIcon(null);
                            d[5].setAlive(false);
                            //check if game over
                            if(d[3].check()==false && d[4].check()==false && d[5].check()==false && d[6].check()==false){
                                btnwave2.setText("Game Over");
                                end();
                            }
                        }
                        //check if demon is off screen
                         if(d[6].getlbl().getLocation().x>1200){
                            d[6].getlbl().setVisible(false);
                            d[6].getlbl().setIcon(null);
                            d[6].setAlive(false);
                            //check if game is over
                            if(d[3].check()==false && d[4].check()==false && d[5].check()==false && d[6].check()==false){
                                btnwave2.setText("Game Over");
                                end();
                            }
                        }
                        
                        
                        Thread.currentThread().sleep(1000);
                } catch (InterruptedException ex) {
                    }
                }
            }
        };

       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbld1 = new javax.swing.JLabel();
        lbld2 = new javax.swing.JLabel();
        lbld3 = new javax.swing.JLabel();
        lbld4 = new javax.swing.JLabel();
        btnwave1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblscore = new javax.swing.JLabel();
        btnwave2 = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Demon Hunter");
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1200, 900));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        getContentPane().setLayout(null);

        lbld1.setBackground(new java.awt.Color(204, 204, 204));
        lbld1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbld1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbld1MousePressed(evt);
            }
        });
        getContentPane().add(lbld1);
        lbld1.setBounds(20, 20, 120, 60);

        lbld2.setBackground(new java.awt.Color(204, 204, 204));
        lbld2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbld2MousePressed(evt);
            }
        });
        getContentPane().add(lbld2);
        lbld2.setBounds(20, 90, 120, 60);

        lbld3.setBackground(new java.awt.Color(204, 204, 204));
        lbld3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbld3MousePressed(evt);
            }
        });
        getContentPane().add(lbld3);
        lbld3.setBounds(20, 160, 120, 60);

        lbld4.setBackground(new java.awt.Color(204, 204, 204));
        lbld4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbld4MousePressed(evt);
            }
        });
        getContentPane().add(lbld4);
        lbld4.setBounds(20, 230, 120, 60);

        btnwave1.setBackground(new java.awt.Color(204, 0, 0));
        btnwave1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnwave1.setText("Press to Start Wave 1");
        btnwave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnwave1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnwave1);
        btnwave1.setBounds(450, 10, 360, 250);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Score:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 820, 40, 20);

        lblscore.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblscore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblscore);
        lblscore.setBounds(70, 820, 34, 20);

        btnwave2.setBackground(new java.awt.Color(255, 0, 0));
        btnwave2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnwave2.setText("Press to Start Wave 2");
        btnwave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnwave2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnwave2);
        btnwave2.setBounds(450, 270, 360, 250);

        btnexit.setText("Exit");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });
        getContentPane().add(btnexit);
        btnexit.setBounds(1100, 810, 73, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int check(){
        String ia, ib, ic, id;
        ia = ""+lbld1.getIcon();
        ib = ""+lbld2.getIcon();
        ic = ""+lbld3.getIcon();
        id = ""+lbld4.getIcon();
        //compare the labels to what icon they have in them to see if they are empty
        if (!(ia.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Big%20demon.png")) && !(ia.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Small%20demon.png")) && !(ia.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Split%20demon.png")) ){
            return 1;
        }
        else if (!(ib.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Big%20demon.png")) && !(ib.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Small%20demon.png")) && !(ib.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Split%20demon.png"))){
            return 2;
        }
        else if (!(ic.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Big%20demon.png")) && !(ic.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Small%20demon.png")) && !(ic.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Split%20demon.png"))){
            return 3;
        }
        else if (!(id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Big%20demon.png")) && !(id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Small%20demon.png")) && !(id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Split%20demon.png"))){
            return 4;
        }
        else return 0;    
    }
  
    public void end(){
        //run game over code
        JOptionPane.showMessageDialog(this, "Game is over your final score is "+d[0].score()+"\n The demo is now over to buy the full game go to www.spacehunter.com");
        System.exit(0);
    }
    
    public void assign(int id){
        //set demon to empty icon
        //set label location of demon
        if(check()==1){
            lbld1.setIcon(new javax.swing.ImageIcon(getClass().getResource(d[id].getImage())));
            d[id].setlbl(lbld1);
        }
        else if(check()==2){
            lbld2.setIcon(new javax.swing.ImageIcon(getClass().getResource(d[id].getImage())));
            d[id].setlbl(lbld2);
        }
        else if(check()==3){
            lbld3.setIcon(new javax.swing.ImageIcon(getClass().getResource(d[id].getImage())));
            d[id].setlbl(lbld3);
        }
        else if(check()==4) {
            lbld4.setIcon(new javax.swing.ImageIcon(getClass().getResource(d[id].getImage())));
            d[id].setlbl(lbld4);
        }
        
    }
    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyTyped

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    
    }//GEN-LAST:event_formKeyPressed

    private void btnwave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnwave1ActionPerformed
        //disable and invisible button so game can be played
        btnwave1.setEnabled(false);
        btnwave1.setVisible(false);
        //make new demon
        d[1]=new Demon(20,20);
        assign(1);
        //make second demon
        d[2]=new Demon(20,800);
        assign(2);
        //line up the label it is in
        d[1].getlbl().setVisible(true);
        d[1].getlbl().setBounds(d[1].getxPos(), d[1].getyPos(), 120, 60);
        //line up second label
        d[2].getlbl().setVisible(true);
        d[2].getlbl().setBounds(d[2].getxPos(), d[2].getyPos(), 120, 60);
        //move demon 1
        ac.jLabelXRight(d[1].getxPos(), 1300, 2, 1, d[1].getlbl());
        //move demon 2
        ac.jLabelXRight(d[2].getxPos(), 1300, 2, 1, d[2].getlbl());
        ac.jLabelYUp(d[2].getyPos(), 300, 5, 1, d[2].getlbl());
        //called to check if demons go off screen
        thread.start();
        
       
        
        
    }//GEN-LAST:event_btnwave1ActionPerformed

    private void lbld1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbld1MousePressed
        String id=""+lbld1.getIcon();
        //see if it is a demon or split demon
        if(id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Big%20demon.png") || id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Split%20demon.png")){
            //set and updte score
            d[0].updatescore(10);
            lblscore.setText(""+d[0].score());
        }
        //see if small demon
        if(id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Small%20demon.png")){
           //set and update score
           d[0].updatescore(20);
           lblscore.setText(""+d[0].score());
        }
        //allow split demon to split
        if(id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Split%20demon.png")){
            che=0;
            //create 2 small demons
            d[5]= new SmallDemon(d[3].getlbl().getLocation().x,d[3].getlbl().getLocation().y-50);
            d[6]= new SmallDemon(d[3].getlbl().getLocation().x,d[3].getlbl().getLocation().y+50);
            lbld3.setIcon(new javax.swing.ImageIcon(getClass().getResource(d[5].getImage())));
            d[5].setlbl(lbld3);
            lbld4.setIcon(new javax.swing.ImageIcon(getClass().getResource(d[6].getImage())));
            d[6].setlbl(lbld4);
            //line up the label it is in
            d[5].getlbl().setVisible(true);
            d[5].getlbl().setBounds(d[5].getxPos(), d[5].getyPos(), 120, 60);
            //line up second label
            d[6].getlbl().setVisible(true);
            d[6].getlbl().setBounds(d[6].getxPos(), d[6].getyPos(), 120, 60);
            //move demon 5
            ac.jLabelXRight(d[5].getxPos(), 1300, 2, 1, d[5].getlbl());
            //move demon 6
            ac.jLabelXRight(d[6].getxPos(), 1300, 2, 1, d[6].getlbl());
            //check if demons are off screen
            thread3.start();
    	}

        
        //make labe lgone
        lbld1.setVisible(false);
        lbld1.setIcon(null);
        
        if(btnwave1.isEnabled()==false && btnwave2.isEnabled()==false){
            //set demon dead
            d[3].setAlive(false);
          
        }
        else if(btnwave1.isEnabled()==false){
            d[1].setAlive(false);
            //check if next wave can start
            if(d[1].check()==false && d[2].check()==false){
                btnwave2.setVisible(true);
              
            }
        }
    }//GEN-LAST:event_lbld1MousePressed

    private void lbld1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbld1MouseClicked
        
    }//GEN-LAST:event_lbld1MouseClicked

    private void lbld2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbld2MousePressed
         String id=""+lbld2.getIcon();
         //see if it is a demon or split demon
        if(id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Big%20demon.png")|| id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Split%20demon.png")){
            //set and updte score
            d[0].updatescore(10);
            lblscore.setText(""+d[0].score());
        }
        //see if small demon
        if(id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Small%20demon.png")){
            //set and updte score
            d[0].updatescore(20);
            lblscore.setText(""+d[0].score());
        }
        //make labe lgone
        lbld2.setIcon(null);
        lbld2.setVisible(false);
        //set demon dead
        if(btnwave1.isEnabled()==false && btnwave2.isEnabled()==false){
            d[4].setAlive(false);
             //check if done
            if(d[3].check()==false && d[4].check()==false && d[5].check() && d[6].check()){
               end();
            }
        }    
        else if(btnwave1.isEnabled()==false){
            d[1].setAlive(false);
            //check if next wave can start
            if(d[1].check()==false && d[2].check()==false){
                btnwave2.setVisible(true);
              
            }
        }
    }//GEN-LAST:event_lbld2MousePressed

    private void btnwave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnwave2ActionPerformed
         //disable and invisible button so game can be played
        btnwave2.setEnabled(false);
        btnwave2.setVisible(false);
        //make new demon
        d[3]=new DemonSplit(20,20); //change to split if time
        assign(3);
        //make second demon
        d[4]=new SmallDemon(20,700);
        assign(4);
        //line up the label it is in
        d[3].getlbl().setVisible(true);
        d[3].getlbl().setBounds(d[3].getxPos(), d[3].getyPos(), 120, 60);
        //line up second label
        d[4].getlbl().setVisible(true);
        d[4].getlbl().setBounds(d[4].getxPos(), d[4].getyPos(), 120, 60);
        //move demon 1
        ac.jLabelXRight(d[3].getxPos(), 1300, 2, 1, d[3].getlbl());
        ac.jLabelYDown(d[3].getyPos(), 600, 5, 1, d[3].getlbl());
        //move demon 2
        ac.jLabelXRight(d[4].getxPos(), 1300, 3, 1, d[4].getlbl());
       
        //check if demons are off screen
        thread2.start();
    }//GEN-LAST:event_btnwave2ActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnexitActionPerformed

    private void lbld3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbld3MousePressed
        String id=""+lbld3.getIcon();
     	//see if it is a demon or split demon
    	if(id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Big%20demon.png")|| id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Split%20demon.png")){
        	//set and updte score
        	d[0].updatescore(10);
        	lblscore.setText(""+d[0].score());
    	}
    	if(id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Small%20demon.png")){
        	//set and updte score
        	d[0].updatescore(20);
        	lblscore.setText(""+d[0].score());
    	}
    	//make labe lgone
    	lbld3.setIcon(null);
    	lbld3.setVisible(false);
    	//set demon dead
    	if(btnwave1.isEnabled()==false && btnwave2.isEnabled()==false){
        	d[5].setAlive(false);
         	//check if done
        	if(d[3].check()==false && d[4].check()==false && d[5].check()==false && d[6].check()==false){
           	end();
        	}
    	}


    }//GEN-LAST:event_lbld3MousePressed

    private void lbld4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbld4MousePressed
        String id=""+lbld4.getIcon();
     	//see if it is a demon or split demon
    	if(id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Big%20demon.png")|| id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Split%20demon.png")){
        	//set and updte score
        	d[0].updatescore(10);
        	lblscore.setText(""+d[0].score());
    	}
        //check if small demon
    	if(id.equals("file:/T:/ISS-ICS4U1-1/jame5380/Unit%205/ISU/build/classes/Small%20demon.png")){
        	//set and updte score
        	d[0].updatescore(20);
        	lblscore.setText(""+d[0].score());
    	}
    	//make labe lgone
    	lbld4.setIcon(null);
    	lbld4.setVisible(false);
    	//set demon dead
    	if(btnwave1.isEnabled()==false && btnwave2.isEnabled()==false){
        	d[6].setAlive(false);
         	//check if done
        	if(d[3].check()==false && d[4].check()==false && d[5].check()==false && d[6].check()==false){
           	end();
        	}
    	}
    }//GEN-LAST:event_lbld4MousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnwave1;
    private javax.swing.JButton btnwave2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbld1;
    private javax.swing.JLabel lbld2;
    private javax.swing.JLabel lbld3;
    private javax.swing.JLabel lbld4;
    private javax.swing.JLabel lblscore;
    // End of variables declaration//GEN-END:variables
}
