
import javax.swing.JLabel;


public class SmallDemon extends AbstractDemon {

   String image;
    JLabel lbl;
    String type;
    
    public SmallDemon(){
        super(0,0);
        image="/Small demon.png";
        type="Demon";
    }
    
    public SmallDemon(int x, int y){
        super(x,y);
        image="/Small demon.png";
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
