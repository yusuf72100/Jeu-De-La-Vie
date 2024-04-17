public class CelluleEtatVivante implements CelluleEtat {
    @Override
    public CelluleEtat vit() {
        return this;
    }

    @Override
    public CelluleEtat meurt() {
        return new CelluleEtatMorte();
    }

    @Override
    public boolean estVivante() {
        return true;
    }

    @Override
    public void accepte(Visteur visiteur, Cellule cellule) {
        visiteur.visiteCelluleVivante(cellule);
    }
}