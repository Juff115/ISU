
import javax.swing.JLabel;

public class Demon extends AbstractDemon{
    String image;
    JLabel lbl;
    String type;
    boolean isalive=true;
    
    public Demon(){
        super(0,0);
        image="/Big demon.png";
        type="Demon";
    }
    
    public Demon(int x, int y){
        super(x,y);
        image="/Big demon.png";
        type="Demon";
    }
    
    @Override
    public String getImage() {
        return image;
    }
    
    public String getType() {
        return type;
    }

    @Override
    public void setlbl(JLabel l) {
        lbl=l;
    }
    
    public JLabel getlbl(){
        return lbl;
    }

    @Override
    public void setAlive(boolean a) {
        isalive = a;
    }

    @Override
    public boolean check() {
        return isalive;
    }

}
