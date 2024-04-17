public class CelluleEtatMorte implements CelluleEtat {

    public CelluleEtat vit() {
        return new CelluleEtatVivante();
    }

    public CelluleEtat meurt() {
        return this;
    }

    public boolean estVivante() {
        return false;
    }

    public void accepte(Visteur visiteur, Cellule cellule) {
        visiteur.visiteCelluleMorte(cellule);
    }
}
