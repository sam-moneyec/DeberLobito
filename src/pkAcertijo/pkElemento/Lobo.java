package pkAcertijo.pkElemento;

public class Lobo extends Elemento {
    public Lobo() {
        super("Lobo");
    }

    
    public void comer(Caperucita caperucita) {
       
        System.err.println("\n!!! El Lobo se comió a Caperucita... ¡FIN DEL JUEGO! !!!");
    }
}