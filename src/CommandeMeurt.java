public class CommandeMeurt extends Commande{

    public CommandeMeurt(Cellule cellule) {
        super(cellule);
    }

    @Override
    public void exectuer() {
        this.cellule.meurt();
    }
}