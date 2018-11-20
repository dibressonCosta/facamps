package asteroids;

import java.awt.Dimension;
import java.util.Random;
import javax.swing.JFrame;

public class TesteUniverso {
    
    public static void main(String[] listargs){
        int w = 700;
        int h = 500;
        JFrame jf = new JFrame();
        jf.setSize(new Dimension(w,h));
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Random r = new Random(0);
        Universo u = Universo.getInstance();
        for (int i = 0; i < 10; i++) {
            double x = r.nextInt(w);
            double y = r.nextInt(h);
            double vx = r.nextDouble()*2;
            double vy = r.nextDouble()*2;
            double raio =25;
            boolean vivo = true;
             u.addElemento(new Asteroide(x,y,vx,vy,raio,vivo));
             
        }
        jf.getContentPane().add(u);
        
        jf.setVisible(true);
        Thread t = new Thread(u);
        t.start();
        
    }
}
