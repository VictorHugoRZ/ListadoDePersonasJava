import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Persona> personas = new ArrayList<>();

        var salir = false;
        while(!salir) {
            mostrarMenu();
            try {
                salir = operacionLista(personas, scanner);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    //Funcion para mostrar el menu
    private static void mostrarMenu() {
        System.out.println("**** Listado de Personas ****");
        System.out.println("""
                1.Agregar
                2.Listar
                3.Salir
                """);
        System.out.print("¿Que opcion quiere utilizar? ");
    }

    //Funcion para evaluar casos
    private static boolean operacionLista(List<Persona> personas, Scanner scanner) {
        var opcion = Integer.parseInt(scanner.nextLine());
        var salir = false;
        //Revisamos la opcion proporcionada
        switch (opcion) {
            case 1 -> { //Agregar persona a la Lista
                //Hacemos uso de variables temporales para recopilar datos.
                System.out.print("Proporciona el nombre: ");
                var nombre = scanner.nextLine();
                System.out.print("Proporciona el telefono: ");
                var tel = scanner.nextLine();
                System.out.print("Proporciona el email: ");
                var email = scanner.nextLine();
                //Ahora creamos el nuevo objeto Persona
                var persona = new Persona(nombre, tel, email);
                //Agregamos el objeto de la persona actual a la lista de personas que
                //creamos antes
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " registros.");
            }
            case 2 -> { //Listar personas
                System.out.println("Listado de personas: ");
                //Mostramos la lista de personas de la Lista que definimos anteriormente
                //Forma 1:
                //personas.forEach((persona -> System.out.println(persona)));
                //Forma 2 simplificada:
                personas.forEach(System.out::println);
                //De esta manera accedemos a cada elemento de la lista y lo mostraremos
                //en la consola pero con una sintaxis mas simplificada.
            }
            case 3 -> { //Salimos del ciclo
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("Opcion erronea: " + opcion);
        }
        return salir;
    }
}
