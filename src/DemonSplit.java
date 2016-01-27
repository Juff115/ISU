
import javax.swing.JLabel;

//see Demon class and AbstractDemon for info
public class DemonSplit extends Demon {
    JLabel lbl;
    
    public DemonSplit(){
        super(0,0);
        image="/Split demon.png";
        type="Demon";
    }
    
    public DemonSplit(int x, int y){
        super(x,y);
        image="/Split demon.png";
        type="Demon";
    }
    
}
