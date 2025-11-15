package pkAcertijo.Elemento;
    public class Lobo extends elemento {

    public Lobo() {
        super("Lobo");
    }

    @Override
    public boolean comer(elemento e) {
      
        return (e instanceof Caperucita);
    }
}