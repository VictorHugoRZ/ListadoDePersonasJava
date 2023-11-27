//Creamos nuestra clase Persona y definimos sus atributos junto con el tipo de dato de cada uno.
public class Persona {
    private int id;
    private String nombre;
    private String tel;
    private String email;
    private static int numeroPersonas = 0;

    //Creacion de Constructores

    //Constructor vacio
    public Persona() {
        this.id = ++Persona.numeroPersonas;
    }

    //Constructor con argumentos
    public Persona(String nombre, String tel, String email) {
        this();
        this.nombre = nombre;
        this.tel = tel;
        this.email = email;
    }

    //Creacion de metodos para acceder y modificar la informacion de nuestra clase Persona

    //ID
    //Get Id
    public int getId() {
        return this.id;
    }
    //Set Id
    public void setId(int id) {
        this.id = id;
    }

    //NOMBRE
    //Get Nombre
    public String getNombre() {
        return this.nombre;
    }
    //Set Nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //TELEFONO
    //Get Tel
    public String getTel() {
        return this.tel;
    }
    //Set Tel
    public void setTel(String tel) {
        this.tel = tel;
    }

    //EMAIL
    //Get Email
    public String getEmail() {
        return this.email;
    }
    //Set Email
    public void setEmail(String email) {
        this.email = email;
    }

    //@Override indica que este metodo esta sobrescribiendo el metodo toString() de la clase base Object.
    //Es una anotacion que ayuda a prevenir errores de sintaxis al asegurarse de que realmente estas sobrescribiendo
    //un metodo existente en la superclase.
    //------------------------------------------------------------------------------------------------------------------
    //Dentro del metodo toString(), se construye una cadena de texto usando la concatenacion de multiples partes.
    //Esta cadena sigue el formato "Persona{id=valorID, nombre='valorNombre', tel='valorTel', email='valorEmail'}".
    //------------------------------------------------------------------------------------------------------------------
    //Cada parte de la cadena comienza con el nombre del atributo seguido por su valor correspondiente en el objeto
    //Persona, utilizando el operador + para concatenar valores de atributos y texto fijo.
    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    //Creamos la funcion Main para utilizar nuestra clase
    //Esto solo en esta clase de Java(archivo) ya que usaremos esta clase sin esta ultima funcion en la clase
    //ListadoPersonas.java
    public static void main(String[] args) {
        Persona persona1 = new Persona("Victor Ramirez", "(55) 1716 8649", "v.zamoravictor@gmail.com");
        System.out.println(persona1); //Persona@6acbcfc0 (Referencia en memoria)
    }
}
