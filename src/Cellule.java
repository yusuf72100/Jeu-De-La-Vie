public class Cellule {
    private int x;
    private int y;
    private CelluleEtat etat;

    public Cellule(int x, int y, CelluleEtat etat) {
        this.etat = etat;
        this.x = x;
        this.y = y;
    }

    public boolean estVivante() {
        return etat.estVivante();
    }

    public void vit() {
        this.etat = this.etat.vit();
    }

    public void meurt() {
        this.etat = this.etat.meurt();
    }

    public int nombreVoisinesVivantes(JeuDeLaVie jeu) {
        int compteur = 0;

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) {       // on vérifie que la cellule ne se compte pas elle meme
                    if (jeu.estDansLaGrille(this.x + dx, this.y + dy)) {
                        if (jeu.getGrille(this.x + dx, this.y + dy).estVivante()) {
                            compteur++;
                        }
                    }
                }
            }
        }

        return compteur;
    }

    public CelluleEtat getEtat() {
        return this.etat;
    }

    public void accepte(Visteur visteur) {
        this.etat.accepte(visteur,this);
    }
}
