import pkAcertijo.Elemento.elemento;

public class Bote {

    private boolean sentido;   // true = derecha, false = izquierda
    private int capacidad;
    private elemento carga;    // elemento que está actualmente en el bote

    public Bote(int capacidad) {
        this.capacidad = capacidad;
        this.sentido = false; // inicia en la izquierda
        this.carga = null;
    }

    public boolean embarcar(elemento e) {
        if (carga == null && capacidad == 1) {
            carga = e;
            return true;
        }
        return false;
    }

    public void desembarcar() {
        carga = null;
    }

    public elemento getCarga() {
        return carga;
    }

    public boolean mover(Vikingo v, elemento e) {
        // El vikingo debe estar remando
        if (!v.estaRemando()) return false;

        // Si hay un elemento para llevar verifica si está embarcado
        if (e != null && e != carga) return false;

        // Cambia el sentido del bote
        sentido = !sentido;

        return true;
    }

    public boolean getSentido() {
        return sentido;
    }
}