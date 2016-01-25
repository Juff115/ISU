
import javax.swing.JLabel;



public abstract class AbstractDemon {
    protected int xPos, yPos, wave=0;
    protected String level="";
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
    
    public abstract String getImage();
    
    public abstract void setlbl(JLabel l);
    
    public abstract JLabel getlbl();
    
    //move the demon
    public void move(int x, int y) {
        xPos=x;
        yPos=y;
    }
    
    public final int getxPos() {
        return xPos;
    }

    public final int getyPos() {
        return yPos;
    }
    
    public void updatescore(int s){
        score+=s;
    }
    
    public int score(){
        return score;
    }
}
