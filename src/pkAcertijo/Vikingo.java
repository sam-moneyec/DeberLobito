package pkAcertijo;

import pkAcertijo.pkElemento.Elemento;

public class Vikingo {
    private boolean estaRemando = false;

    public void remar() {
        this.estaRemando = true;
    }

    public void transportar(Bote bote, Elemento e) { // Cambiado Barco a Bote
        // Verifica si el Elemento está en la misma orilla que el bote y si hay espacio
        if (e.enOrillaDerecha == bote.getSentido() && bote.getCarga() == null) {
            bote.setCarga(e);
            System.out.println("El vikingo embarca a " + e.getNombre() + " en el Bote.");
        } else {
             System.out.println("No se pudo embarcar a " + e.getNombre() + ". El Bote no está en la misma orilla o ya está cargado.");
        }
    }
    
    // Método auxiliar necesario para la lógica de Bote.mover()
    public boolean estaRemando() {
        return estaRemando;
    }
    
    // Método auxiliar necesario para la lógica de Bote.mover()
    public void detenerRemo() {
        this.estaRemando = false;
    }
}