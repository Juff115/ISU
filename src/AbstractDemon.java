
import javax.swing.JLabel;



public abstract class AbstractDemon {
    protected int xPos, yPos, wave=0;
    public static int score;
    
    //create basic demon
    public AbstractDemon(){
        xPos=0;
        yPos=0;
    }
    //create basic demon with location
    public AbstractDemon(int x, int y){
        xPos=x;
        yPos=y;
    }
    
    //used in children to ditermine image
    public abstract String getImage();
    
    //used in children to assign lbl location
    public abstract void setlbl(JLabel l);
    
    //retrive lbl location in children
    public abstract JLabel getlbl();
    
    //in children check set their life
    public abstract void setAlive(boolean a);
    
    //check life status in children
    public abstract boolean check();
    
    //move the demon location
    public void move(int x, int y) {
        xPos=x;
        yPos=y;
    }
    
    //retrive x start location 
    public final int getxPos() {
        return xPos;
    }

    //retrive y start location
    public final int getyPos() {
        return yPos;
    }
    
    //update score
    public void updatescore(int s){
        score+=s;
    }
    
    //return score so it can be displayed
    public int score(){
        return score;
    }
}
