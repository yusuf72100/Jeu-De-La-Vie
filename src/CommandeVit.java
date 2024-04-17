public class CommandeVit extends Commande{

    public CommandeVit(Cellule cellule) {
        super(cellule);
    }

    @Override
    public void exectuer() {
        this.cellule.vit();
    }
}
