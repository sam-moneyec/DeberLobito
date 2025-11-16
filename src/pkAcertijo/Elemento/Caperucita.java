package pkAcertijo.Elemento;
public class Caperucita extends Elemento {
    public Caperucita() {
        super("Caperucita");
    }
     public boolean comer(Elemento e) {
        return (e instanceof Uvas);
    }
}