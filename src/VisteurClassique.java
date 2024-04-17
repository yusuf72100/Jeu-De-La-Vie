public class VisteurClassique extends Visteur{
    public VisteurClassique(JeuDeLaVie jeuDeLaVie) {
        super(jeuDeLaVie);
    }

    @Override
    public void visiteCelluleVivante(Cellule cellule){
        if(cellule.nombreVoisinesVivantes(this.jeuDeLaVie) < 2 || cellule.nombreVoisinesVivantes(this.jeuDeLaVie) > 3) {
            jeuDeLaVie.ajouterCommande(new CommandeMeurt(cellule));
        }
    }

    @Override
    public void visiteCelluleMorte(Cellule cellule){
        if(cellule.nombreVoisinesVivantes(this.jeuDeLaVie) == 3) {
            jeuDeLaVie.ajouterCommande(new CommandeVit(cellule));
        }
    }
}
