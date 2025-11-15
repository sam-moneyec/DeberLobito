package pkAcertijo.Elemento;


public abstract class elemento {
    private String nombre;
 
    public elemento(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public abstract boolean comer(elemento e);

}