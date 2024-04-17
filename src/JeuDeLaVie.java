import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class JeuDeLaVie implements Observable{
    private Cellule[][] grille;
    private List<Observateur> observateurs;
    private List<Commande> commandes;
    private Visteur visiteur;
    int xMax;
    int yMax;

    public JeuDeLaVie(int xmax , int ymax) {
        this.xMax = xmax;
        this.yMax = ymax;
        this.grille = new Cellule[this.xMax][this.yMax];
        this.observateurs = new ArrayList<>();
        this.commandes = new ArrayList<>();
        initialiserGrille();::
    }

    private void setVisiteur(Visteur visiteur) {
        this.visiteur = visiteur;
    }

    private void initialiserGrille() {
        for (int x = 0; x < xMax; x++) {
            for (int y = 0; y < yMax; y++) {
                this.grille[x][y] = new Cellule(x, y, ((Math.random() < 0.5) ? new CelluleEtatMorte() : new CelluleEtatVivante()));
            }
        }
    }

    public int getxMax() {
        return xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public Cellule getGrille(int x, int y) {
        return this.grille[x][y];
    }

    public boolean estDansLaGrille(int x, int y) {
        return x < this.xMax && x >= 0 && y < this.yMax && y >= 0;
    }

    @Override
    public void attachObservateur(Observateur o) {
        this.observateurs.add(o);
    }

    @Override
    public void detachObservateur(Observateur o) {
        this.observateurs.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observateur o : this.observateurs) {
            o.actualise();
        }
    }

    public void ajouterCommande(Commande c) {
        this.commandes.add(c);
    }

    public void executeCommandes() {
        for (Commande c : this.commandes) {
            c.exectuer();
        }
        commandes.clear();
    }

    public void distribuerVisiteur() {
        for (int x = 0; x < xMax; x++) {
            for (int y = 0; y < yMax; y++) {
                this.grille[x][y].accepte(this.visiteur);
            }
        }
    }

    public void calculerGenerationSuivante() {
        distribuerVisiteur();
        executeCommandes();
        notifyObservers();
    }

    public static void main(String[] args) throws InterruptedException {
        int xmax = 200;
        int ymax = 200;

        JeuDeLaVie jeuDeLaVie = new JeuDeLaVie(xmax , ymax);
        JeuDeLaVieUI jeuDeLaVieUI = new JeuDeLaVieUI(jeuDeLaVie);
        jeuDeLaVie.setVisiteur(new VisteurClassique(jeuDeLaVie));

        jeuDeLaVie.attachObservateur(jeuDeLaVieUI);
        jeuDeLaVie.notifyObservers();

        int i = 0;
        while (true) {
            System.out.println("Génération n°" + i++);
            jeuDeLaVie.calculerGenerationSuivante();
            sleep(200);
        }
    }
}