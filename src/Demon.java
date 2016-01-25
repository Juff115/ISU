
import javax.swing.JLabel;




public class Demon extends AbstractDemon{
    String image;
    JLabel lbl;
    String type;
    
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
}
