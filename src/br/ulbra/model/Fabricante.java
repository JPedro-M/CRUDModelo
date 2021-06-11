
package br.ulbra.model;

/**
 * @author Jeferson
 */
public class Fabricante {
    private int id;
    private String marca;
    private String fone;
    private String site;
    private String email;
    
    public Fabricante(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", marca=" + marca + ", telefone=" + fone + ", site=" + site + ", email=" + email + '}';
    }
    
}
