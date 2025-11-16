package pkAcertijo;

import pkAcertijo.pkElemento.Caperucita;
import pkAcertijo.pkElemento.Lobo;
import pkAcertijo.pkElemento.Uvaa;
import pkAcertijo.pkElemento.Elemento;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    private Bote bote;
    private Vikingo vikingo;
    private Caperucita caperucita;
    private Lobo lobo;
    private Uvaa uvas; 

    public Controller(Bote bote, Vikingo vikingo) {
        this.bote = bote;
        this.vikingo = vikingo;
        
 
        this.caperucita = new Caperucita();
        this.lobo = new Lobo();
        this.uvas = new Uvaa();
    }


    public boolean validarReglas() {
        boolean boteEnDerecha = bote.getSentido();
        
        
        for (int i = 0; i < 2; i++) {
            boolean orilla = (i != 0); 
            
            if (orilla == boteEnDerecha) {
                continue; 
            }
            
        
            boolean caperucitaC = caperucita.enOrillaDerecha == orilla;
            boolean loboC = lobo.enOrillaDerecha == orilla;
            boolean uvasC = uvas.enOrillaDerecha == orilla;
           

            if (loboC && caperucitaC) {
                lobo.comer(caperucita);
                return false; 
            }

         
            if (caperucitaC && uvasC) {
                caperucita.comer(uvas);
                return false; 
            }
        }
        return true; 
    }

    public void iniciarJuegoCaperucita() {
        
    }

    // --- Métodos de Interacción ---

    public void desembarcar() {
        Elemento e = (Elemento) bote.getCarga();
        if (e != null) {
            bote.desembarcar();
            e.enOrillaDerecha = bote.getSentido();
            System.out.println("El vikingo desembarca a " + e.getNombre() + " en la orilla " + (e.enOrillaDerecha ? "DERECHA" : "IZQUIERDA") + ".");
        } else {
            System.out.println("El bote está vacío, no hay nada que desembarcar.");
        }
    }

    
    public boolean moverBarco() {
        Elemento carga = bote.getCarga();
        vikingo.remar(); 

        if (bote.mover(vikingo, carga)) {
            String lado = bote.getSentido() ? "derecha" : "izquierda";
            
            
            if (carga != null) {
                carga.enOrillaDerecha = bote.getSentido();
                System.out.println("El vikingo rema con " + carga.getNombre() + " hacia la " + lado + ".");
            } else {
                System.out.println("El vikingo cruza solo hacia la " + lado + ".");
            }

            vikingo.detenerRemo();
            return true;
        } else {
            System.out.println("El bote no puede moverse.");
            return false;
        }
    }

    public boolean juegoGanado() {
        
        return caperucita.enOrillaDerecha && lobo.enOrillaDerecha && uvas.enOrillaDerecha && bote.getSentido();
    }

    // --- Métodos de Visualización (para la parte interactiva) ---

    public void imprimirSolucion() {
        System.out.println("\n=============================================");
        System.out.println("        SOLUCIÓN AL ACERTIJO\nIntegrantes:Robayo Samuel, Soria Ariel, Rosero Mao");
        System.out.println("=============================================");
        System.out.println("1.  Cruzamos a **Caperucita**.");
        System.out.println("2.  Regresamos **solo**.");
        System.out.println("3.  Cruzamos al **Lobo**.");
        System.out.println("4.  Regresamos con **Caperucita**.");
        System.out.println("5.  Cruzamos las **Uvas**.");
        System.out.println("6.  Regresamos **solo**.");
        System.out.println("7.  Cruzamos a **Caperucita**.");
        System.out.println("\n=============================================");
    }
    
    public void mostrarEstadoCompleto() {
        List<String> itemsIzquierda = new ArrayList<>();
        if (!caperucita.enOrillaDerecha) itemsIzquierda.add(caperucita.getNombre());
        if (!lobo.enOrillaDerecha) itemsIzquierda.add(lobo.getNombre());
        if (!uvas.enOrillaDerecha) itemsIzquierda.add(uvas.getNombre());
        
        String botePos = bote.getSentido() ? "                        | BOTE | " : "| BOTE |"; 
        String carga = bote.getCarga() != null ? "(" + bote.getCarga().getNombre() + ")" : "(vacío)";
        String separador = "                          | RÍO |";

        System.out.println("\n-------------------------------------------");
        System.out.println("            ESTADO DEL RÍO");
        System.out.println("-------------------------------------------");
        System.out.printf("ORILLA IZQUIERDA: %s\n", String.join(" | ", itemsIzquierda));
        System.out.printf("%s %s\n", botePos, carga);
        System.out.println(separador);

        List<String> itemsDerecha = new ArrayList<>();
        if (caperucita.enOrillaDerecha) itemsDerecha.add(caperucita.getNombre());
        if (lobo.enOrillaDerecha) itemsDerecha.add(lobo.getNombre());
        if (uvas.enOrillaDerecha) itemsDerecha.add(uvas.getNombre());
        
        System.out.printf("ORILLA DERECHA:  %s\n", String.join(" | ", itemsDerecha));
        System.out.println("-------------------------------------------");
    }

    public Bote getBote() { return bote; }
    public Caperucita getCaperucita() { return caperucita; }
    public Lobo getLobo() { return lobo; }
    public Uvaa getUvas() { return uvas; }
}