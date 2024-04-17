public abstract class Visteur {
    protected JeuDeLaVie jeuDeLaVie;

    public Visteur(JeuDeLaVie jeuDeLaVie) {
        this.jeuDeLaVie = jeuDeLaVie;
    }

    public abstract void visiteCelluleVivante(Cellule cellule);
    public abstract void visiteCelluleMorte(Cellule cellule);
}
