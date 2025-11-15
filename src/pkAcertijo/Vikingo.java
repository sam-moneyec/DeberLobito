import pkAcertijo.Elemento.elemento;

public class Vikingo {

    private boolean remando;

    public Vikingo() {
        this.remando = false;
    }

    public void remar() {
        this.remando = true; // listo para mover el bote
    }

    public boolean estaRemando() {
        return remando;
    }

    public boolean transportar(Bote b, elemento e) {
        // Embarcar un elemento en el bote
        return b.embarcar(e);
    }

    public void detenerRemo() {
        this.remando = false;
    }
}