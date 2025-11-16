import pkAcertijo.Bote;
import pkAcertijo.Vikingo;
import pkAcertijo.Controller;

public class App {
    public static void main(String[] args) {

        // Crear objetos principales
        Bote bote = new Bote(1);
        Vikingo vikingo = new Vikingo();

        // Pasarlos al controller
        Controller controller = new Controller(bote, vikingo);

        // Ejecutar ejemplo simple
        controller.iniciarJuego();
        controller.mostrarEstado();
    }
}