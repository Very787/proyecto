
package Modelo;

    
public class Proyecto {
   int idpro;
   String desc;
   int id;

    public Proyecto() {
    }

    public Proyecto(String desc, int id) {
        this.desc = desc;
        this.id = id;
    }

    
    public int getIdpro() {
        return idpro;
    }

    public void setIdpro(int idpro) {
        this.idpro = idpro;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
