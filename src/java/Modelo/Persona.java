
package Modelo;


public class Persona {
    
    int id;
    String ced;
    String nom;

    public Persona() {
    }

    public Persona(String ced, String nom) {
        this.ced = ced;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCed() {
        return ced;
    }

    public void setCed(String ced) {
        this.ced = ced;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
     
}
