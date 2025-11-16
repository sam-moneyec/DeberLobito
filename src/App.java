
import pkAcertijo.Controller;
import pkAcertijo.Bote;
import pkAcertijo.Vikingo;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        Bote bote = new Bote(); 
        Vikingo vikingo = new Vikingo(); 
        Controller controller = new Controller(bote, vikingo);
        
        controller.imprimirSolucion();

        
        System.out.println("\n\n==============================================");
        System.out.println("            MODO INTERACTIVO");
        System.out.println("     ¡Intenta resolver el acertijo!");
        System.out.println("===================================================");

        boolean juegoTerminado = false;
        controller.iniciarJuegoCaperucita(); 
        
        while (!juegoTerminado) {
           
            controller.mostrarEstadoCompleto();
            
            
            if (!controller.validarReglas()) {
                juegoTerminado = true;
                break;
            }
            
          
            if (controller.juegoGanado()) {
                System.out.println("\n\n🎉 ¡FELICIDADES! ¡Has cruzado a todos con éxito! 🎉");
                juegoTerminado = true;
                break;
            }
            
            // --- Interfaz de usuario y entrada ---
            boolean boteVacio = controller.getBote().getCarga() == null;
            String ladoActual = controller.getBote().getSentido() ? "DERECHA" : "IZQUIERDA";
            
            System.out.println("\n** El Bote está en la orilla " + ladoActual + " **");
            System.out.println("¿Qué quieres hacer?");
            
            if (boteVacio) {
                System.out.println("1. Cruzar solo (Mover Bote)");
                System.out.println("2. Embarcar a Caperucita");
                System.out.println("3. Embarcar al Lobo");
                System.out.println("4. Embarcar las Uvas");
                System.out.println("5. Salir del juego");
            } else {
                System.out.println("1. Mover Bote (Cruzar el río)");
                System.out.println("2. Desembarcar");
                System.out.println("5. Salir del juego");
            }

            System.out.print("Ingresa tu opción (1-5): ");
            String input = scanner.nextLine().trim();
            
            try {
                int opcion = Integer.parseInt(input);
                
                if (boteVacio) {
                    switch (opcion) {
                        
                        case 1: controller.moverBarco(); break;
                    
                        case 2: vikingo.transportar(bote, controller.getCaperucita()); break;
                        case 3: vikingo.transportar(bote, controller.getLobo()); break;
                        case 4: vikingo.transportar(bote, controller.getUvas()); break;
                        case 5: juegoTerminado = true; System.out.println("Juego terminado."); break;
                        default: System.out.println("Opción inválida. Intenta de nuevo.");
                    }
                } else {
                    switch (opcion) {
                        // Llama al controller
                        case 1: controller.moverBarco(); break;
                        case 2: controller.desembarcar(); break;
                        case 5: juegoTerminado = true; System.out.println("Juego terminado."); break;
                        default: System.out.println("Opción inválida. Intenta de nuevo.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un número.");
            }
            
            if (!juegoTerminado) {
                System.out.println("\nPresiona ENTER para continuar el turno...");
                scanner.nextLine();
            }
        }
        
        scanner.close();
    }
}