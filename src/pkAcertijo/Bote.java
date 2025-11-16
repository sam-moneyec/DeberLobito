package pkAcertijo;

import pkAcertijo.pkElemento.Elemento;

public class Bote {
    private boolean Sentido = false; 
    private final int capacidad = 1; 
    private Elemento carga = null;

    public boolean getSentido() {
        return Sentido;
    }

    public Elemento getCarga() {
        return carga;
    }

    public void setCarga(Elemento e) {
        this.carga = e;
    }

    public void desembarcar() {
        if (carga != null) {
            carga = null;
        }
    }


    public boolean mover(Vikingo vikingo, Elemento e) {
        if (vikingo.estaRemando()) {
            this.Sentido = !this.Sentido; 
            return true;
        }
        return false;
    }
}