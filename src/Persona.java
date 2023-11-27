//Creamos nuestra clase Persona y definimos sus atributos junto con el tipo de dato de cada uno
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
    public static void main(String[] args) {
        Persona persona1 = new Persona("Victor Ramirez", "(55) 1716 8649", "v.zamoravictor@gmail.com");
        System.out.println(persona1); //Persona@6acbcfc0 (Referencia en memoria)
    }
}
