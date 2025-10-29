public class Pépinière {
    private Plante[] inventaire;
    final int MAXPLANTES=1000;
    private int nombreDePlantes=0;
    public Pépinière(){
        inventaire=new Plante[MAXPLANTES];
    }
    void ajouterPlante (Plante plante) {
        if(nombreDePlantes>MAXPLANTES){
            System.out.println("Pépinère pleine!!!!!!!!!!!");
            return;
        }
        else {
            inventaire[nombreDePlantes++]=plante;
        }
    }
    public void afficherInventaire(){
        System.out.print("Inventaire de la pépinière: "+"\n");
        for (int i = 0; i < nombreDePlantes; i++) {
            System.out.println("Plante #" + (i+1)+"\n" + inventaire[i].toString());
            if (inventaire[i] instanceof Fleur){
                ((Fleur) inventaire[i]).fleurir();
            }
        }
    }
    public double totalAbsorptionTotaleCO2(){
        double total=0;
        for  (int i = 0; i < nombreDePlantes; i++) {
            if (inventaire[i] instanceof Arbre){
                total=total+ ((Arbre) inventaire[i]).absorptionCO2();
            }
        }
        return total;
    }
    public int compterArbresCaduques() {
        int compteur = 0;
        for (int i = 0; i < nombreDePlantes; i++) {
            if (inventaire[i] instanceof Arbre) {
                Arbre arbre = (Arbre) inventaire[i];
                if ("Caduque".equals(arbre.getType_Feuillage())) {
                    compteur++;
                }
            }
        }
        return compteur;
    }
}
