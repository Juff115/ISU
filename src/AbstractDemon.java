

public abstract class AbstractDemon {
    protected double xPos, yPos, kills=0, wave=0;
    protected String level="";
    
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
    
    //check if collison
    public boolean dead(int col){
        if(col==1){
            kills++;
            return true;
        }
        else return false;
    }
    
    public abstract String getImage();
    
    public abstract void setlbl(String l);
    
    public abstract String getlbl();
    
    //move the demon
    public void move(double x, double y) {
        xPos=x;
        yPos=y;
    }
    
    public void nextwave(){
        wave++;
    }
    
    public final double getxPos() {
        return xPos;
    }

    public final double getyPos() {
        return yPos;
    }
    
    public final double getkills(){
        return kills;
    }
    
    public String toString(){
        level="The wave is "+wave;
        return level;
    }
}
