package pkAcertijo.Elemento;
public class Caperucita extends elemento {
    public Caperucita() {
        super("Caperucita");
    }
     public boolean comer(elemento e) {
        return (e instanceof Uvas);
    }
}