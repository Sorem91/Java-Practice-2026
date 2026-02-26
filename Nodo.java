public class Nodo {
    String codigo;
    String nombre;
    float salario;
    Nodo siguiente;

    public Nodo(String codigo, String nombre, float salario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        this.siguiente = null;
    }
}
