public abstract class Commande {
    protected Cellule cellule;

    public Commande(Cellule cellule) {
        this.cellule = cellule;
    }

    public abstract void exectuer();
}