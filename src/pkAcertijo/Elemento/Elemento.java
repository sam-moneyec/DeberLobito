package pkAcertijo.Elemento;


public abstract class Elemento {
    private String nombre;
 
    public Elemento(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public abstract boolean comer(Elemento e);

}