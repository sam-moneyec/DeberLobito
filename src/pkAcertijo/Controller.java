package pkAcertijo;

import pkAcertijo.Elemento.Caperucita;
import pkAcertijo.Elemento.Elemento;
import pkAcertijo.Elemento.Lobo;
import pkAcertijo.Elemento.Uvas;

public class Controller {

    private Bote bote;
    private Vikingo vikingo;

    // Elementos disponibles
    private Caperucita caperucita;
    private Lobo lobo;
    private Uvas uvas;

    public Controller(Bote bote, Vikingo vikingo) {
        this.bote = bote;
        this.vikingo = vikingo;
        this.caperucita = new Caperucita();
        this.lobo = new Lobo();
        this.uvas = new Uvas();
    }

    // ----------------------------------------------------------
    //           MÉTODOS DE INTERACCIÓN
    // ----------------------------------------------------------

    public void remar() {
        vikingo.remar();
        System.out.println("El vikingo comienza a remar.");
    }

    public void detenerRemo() {
        vikingo.detenerRemo();
        System.out.println("El vikingo dejó de remar.");
    }

    public void embarcarElemento(Elemento e) {
        boolean ok = vikingo.transportar(bote, e);
        if (ok) {
            System.out.println("El vikingo embarca a " + e.getNombre() + " en el bote.");
        } else {
            System.out.println("No se pudo embarcar a " + e.getNombre() + ".");
        }
    }

    public void desembarcar() {
        Elemento e = bote.getCarga();
        if (e != null) {
            bote.desembarcar();
            System.out.println("El vikingo desembarca a " + e.getNombre() + ".");
        } else {
            System.out.println("El bote está vacío, no hay nada que desembarcar.");
        }
    }

    public void moverBote() {
        Elemento carga = bote.getCarga();

        if (bote.mover(vikingo, carga)) {
            String lado = bote.getSentido() ? "derecha" : "izquierda";

            if (carga != null) {
                System.out.println("El vikingo está remando con " + carga.getNombre() +
                                   " hacia la " + lado + " del río.");
            } else {
                System.out.println("El vikingo cruza solo hacia la " + lado + " del río.");
            }

            vikingo.detenerRemo();
        } else {
            System.out.println("El bote no puede moverse. Asegúrate de remar.");
        }
    }

    // ----------------------------------------------------------
    //                MÉTODO DE INICIO DE EJEMPLO
    // ----------------------------------------------------------
    public void iniciarJuego() {
        System.out.println("Iniciando demostración de interacciones...");

        remar();
        embarcarElemento(caperucita);
        moverBote();
        desembarcar();
    }

    public void mostrarEstado() {
        System.out.println("\n--- ESTADO ACTUAL ---");
        System.out.println("Bote en lado: " + (bote.getSentido() ? "derecha" : "izquierda"));

        if (bote.getCarga() != null) {
            System.out.println("Carga en bote: " + bote.getCarga().getNombre());
        } else {
            System.out.println("El bote está vacío.");
        }
    }
}