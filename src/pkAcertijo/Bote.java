package pkAcertijo;
import pkAcertijo.Elemento.Elemento;

public class Bote {

    private boolean sentido;   // true = derecha, false = izquierda
    private int capacidad;
    private Elemento carga;    // elemento actualmente en el bote

    public Bote(int capacidad) {
        this.capacidad = capacidad;
        this.sentido = false; // inicia en la izquierda
        this.carga = null;
    }

    public boolean embarcar(Elemento e) {
        if (carga == null && capacidad == 1) {
            carga = e;
            return true;
        }
        return false;
    }

    public void desembarcar() {
        carga = null;
    }

    public Elemento getCarga() {
        return carga;
    }

    public boolean mover(Vikingo v, Elemento e) {
        // El vikingo debe estar remando
        if (!v.estaRemando()) return false;

        // Si hay un elemento para llevar, verificar si está embarcado
        if (e != null && e != carga) return false;

        // Cambia el sentido
        sentido = !sentido;

        return true;
    }

    public boolean getSentido() {
        return sentido;
    }
}