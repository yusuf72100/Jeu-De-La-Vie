public interface CelluleEtat {
    public CelluleEtat vit();
    public CelluleEtat meurt();
    public boolean estVivante();
    public void accepte(Visteur visiteur, Cellule cellule);
}
