import TurtleGraphics.Pen;

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
    
    //to be done in child class
    public abstract void draw(Pen p);
    
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
