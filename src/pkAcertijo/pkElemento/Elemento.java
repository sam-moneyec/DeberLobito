package pkAcertijo.pkElemento;


public abstract class Elemento {
    protected String nombre;
   
    public boolean enOrillaDerecha = false; 

    public Elemento(String nombre) {
        this.nombre = nombre;
    }

    
    public String getNombre() {
        return nombre;
    }
}