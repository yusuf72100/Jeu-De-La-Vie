public class Verbose implements Observateur{
    private JeuDeLaVie jeuDeLaVie;

    public Verbose(JeuDeLaVie jeuDeLaVie){
        this.jeuDeLaVie = jeuDeLaVie;
    }

    @Override
    public void actualise() {
        verboseMe();
    }

    private void verboseMe(){
        int compteur = 0;

        for(int y = 0; y < jeuDeLaVie.getyMax(); y++){
            for(int x = 0; x < jeuDeLaVie.getxMax(); x++){
                compteur += jeuDeLaVie.getGrille(x,y).estVivante() ? 1 : 0;
            }
        }

        System.out.println("------------------ Génération n°" + jeuDeLaVie.getNbGen() + " ------------------");
        System.out.println("Nombre ce cellules en vie : " + compteur);
        System.out.println("------------------------------------------------------------------------\n");
    }
}
