package pkAcertijo.Elemento;
    public class Lobo extends Elemento {

    public Lobo() {
        super("Lobo");
    }

    @Override
    public boolean comer(Elemento e) {
      
        return (e instanceof Caperucita);
    }
}