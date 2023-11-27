import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListadoPersonas {
    public static void main(String[] args) {
        //Definimos nuestro scanner
        Scanner scanner = new Scanner(System.in);

        //Definimos nuestra lista(Array); ArrayList es básicamente un arreglo de tamaño variable.
        //En los corchetes angulares (<>) especificamos el tipo de objetos que vamos a almacenar.
        //Tenga en cuenta que el tipo entre paréntesis debe ser un tipo de objeto y no un tipo primitivo, es decir;
        //List<Persona> ---> Haciendo referencia a que en esta lista almacenaremos objetos de nuestra clase Persona
        //de la clase(archivo) Persona.java
        //También podemos especificar la capacidad inicial de la lista; new ArrayList<>(20);
        List<Persona> personas = new ArrayList<>();

        //Definimos una variable para controlar el Bucle While mas adelante.
        var salir = false;

        //Definimos nuestro Bucle While para que nuestro programa se ejecute hasta que el usuario decida salir.
        //La condicion para cerrar el bucle es la negacion de nuestra variable 'salir', es decir;
        //'salir' actualmente tiene un valor de 'false', al negarlo se vuelve 'true' y es lo que el bucle toma
        //como verdadero para continuar con su ejecucion.
        while(!salir) {

            //Ejecutamos nuestra funcion para mostrar el menu.
            mostrarMenu();

            //En el segmento de codigo dentro del bloque 'try' estara el proceso que tratara de seguir nuestro programa,
            //en caso de que en este ocurra un error, excepcion o falla por algun motivo, entonces 'catch' atrapa
            //dicho error o Excepcion en la variable 'e' ('e' es solo el nombre de variable no es obligatorio
            //llamarla siempre asi pero si se aconseja).
            try {

                //Reasignamos el valor de nuestra variable 'salir', este valor lo dara una funcion que retornara un
                //valor booleano, a esta funcion le pasamos como parametros nuestra lista 'personas' y nuestro scanner.
                salir = operacionLista(personas, scanner);

            } catch (Exception e) {

                //Si es que existe un error en algun momento durante la ejecucion de nuestro programa, lo mostraremos
                //en la consola y volvera a ejecutarse por el bucle While, no cortara la ejecucion lanzandonos un
                //error.
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println(); //Salto de linea para evitar que el programa se ejecute demasiado cerca del anterior.
        }
    }

    //Funcion para mostrar el menu.
    //Funcion privada que no retorna nada 'void', solo muestra datos en consola.
    private static void mostrarMenu() {
        System.out.println("""
                **** Listado de Personas ****
                1.Agregar
                2.Listar
                3.Salir
                ¿Que opcion quiere utilizar? 
                """);
    }

    //Funcion para evaluar los casos, retorna un booleano.
    //Funcion privada que retorna un valor booleano y recibe como parametros una lista y un scanner(linea 38; 'salir').
    private static boolean operacionLista(List<Persona> personas, Scanner scanner) {

        //Parseamos la respuesta del usuario a un numero entero.
        var opcion = Integer.parseInt(scanner.nextLine());

        //Definimos nuevamente la variable 'salir' seteandola en 'false' para poder retornarla al final.
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

                //Ahora creamos el nuevo objeto Persona;
                //Esto utilizando la clase Persona que creamos en nuestra clase(archivo) Persona.java
                //Le pasamos como parametros las variables que anteriormente usamos para recopilar la informacion.
                var persona = new Persona(nombre, tel, email);

                //Agregamos el objeto de la 'persona' actual a la lista de 'personas' que creamos antes.
                personas.add(persona);

                //Al agregar el objeto actual a la lista 'personas' mostramos un mensaje accediendo a la longitud
                //de esta misma lista, confirmando que el registro se agrego correctamente.
                System.out.println("La lista tiene: " + personas.size() + " registros.");
            }
            case 2 -> { //Listar personas
                //Mostramos la lista de personas de la Lista que definimos anteriormente
                System.out.println("Listado de personas: ");

                //Forma 1:
                //personas.forEach((persona -> System.out.println(persona)));

                //Forma 2 simplificada:
                personas.forEach(System.out::println);
                //De esta manera accedemos a cada elemento de la lista y lo mostraremos
                //en la consola pero con una sintaxis mas simplificada.
            }
            case 3 -> { //Salimos del ciclo
                //Mostramos mensaje de despedida y reasignamos el valor de nuestra variable 'salir' a 'true',
                //esto para que nuestra funcion retorne el valor que cortara la ejecucion de nuestro bucle While.
                System.out.println("Hasta pronto...");
                salir = true;
            }
            //Error para numeros fuera del rango del menu.
            default -> System.out.println("Opcion erronea: " + opcion);
        }
        //Retornamos el valor de nuestra variable para que el bucle compruebe si puede seguir ejecutandose o termina
        //su ejecucion.
        return salir;
    }
}
