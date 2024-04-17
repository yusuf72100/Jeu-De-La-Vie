import javax.swing.*;
import java.awt.*;

public class JeuDeLaVieUI extends JFrame implements Observateur{
    private JeuDeLaVie jeuDeLaVie;

    public JeuDeLaVieUI(JeuDeLaVie jeuDeLaVie) {
        this.jeuDeLaVie = jeuDeLaVie;
        this.setTitle("Jeu de la vie");
        this.setVisible(true);
        this.setSize(1000, 1000);
    }

    @Override
    public void actualise() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        for(int x = 0; x < jeuDeLaVie.getxMax(); x++) {
            for(int y = 0; y < jeuDeLaVie.getyMax(); y++) {
                if(jeuDeLaVie.getGrille(x,y).getEtat().estVivante()) {
                    g.fillOval(x * 5, y * 5, 5, 5);
                }
            }
        }
    }
}
