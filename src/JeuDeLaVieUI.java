import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class JeuDeLaVieUI extends JFrame implements Observateur{
    private JeuDeLaVie jeuDeLaVie;

    public JeuDeLaVieUI(JeuDeLaVie jeuDeLaVie) {
        this.jeuDeLaVie = jeuDeLaVie;
        this.setTitle("Jeu de la vie");
        this.setVisible(true);
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actualise() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // buffer
        BufferedImage buffer = new BufferedImage(jeuDeLaVie.getxMax() * 5, jeuDeLaVie.getyMax() * 5, BufferedImage.TYPE_INT_ARGB);
        Graphics2D bufferGraphics = buffer.createGraphics();

        // mise à jour du buffer
        bufferGraphics.setColor(Color.BLUE);
        for(int x = 0; x < jeuDeLaVie.getxMax(); x++) {
            for(int y = 0; y < jeuDeLaVie.getyMax(); y++) {
                if(jeuDeLaVie.getGrille(x,y).getEtat().estVivante()) {
                    bufferGraphics.fillOval(x * 5, y * 5, 5, 5);
                }
            }
        }

        g.drawImage(buffer, 0, 0, null);
        bufferGraphics.dispose();
    }
}
