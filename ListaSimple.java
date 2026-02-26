public class ListaSimple {

    private Nodo head;
    private int size;

    public ListaSimple() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void addLast(String codigo, String nombre, float salario) {
        Nodo nuevo = new Nodo(codigo, nombre, salario);

        if (head == null) {
            head = nuevo;
        } else {
            Nodo actual = head;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }

        size++;
    }

    public void addFirst(String codigo, String nombre, float salario) {
        Nodo nuevo = new Nodo(codigo, nombre, salario);
        nuevo.siguiente = head;
        head = nuevo;
        size++;
    }

    public void addAt(int posicion, String codigo, String nombre, float salario) {
        if (posicion <= 0 || posicion >= size) {
            System.out.println("Posición inválida para inserción intermedia: " + posicion);
            return;
        }

        Nodo nuevo = new Nodo(codigo, nombre, salario);
        Nodo actual = head;

        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.siguiente;
        }

        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
        size++;
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        head = head.siguiente;
        size--;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }

        if (head.siguiente == null) {
            head = null;
            size--;
            return;
        }

        Nodo actual = head;
        while (actual.siguiente.siguiente != null) {
            actual = actual.siguiente;
        }

        actual.siguiente = null;
        size--;
    }

    public void removeAt(int posicion) {
        if (posicion <= 0 || posicion >= size - 1) {
            System.out.println("Posición inválida para eliminación intermedia: " + posicion);
            return;
        }

        Nodo actual = head;
        for (int i = 0; i < posicion - 1; i++) {
            actual = actual.siguiente;
        }

        actual.siguiente = actual.siguiente.siguiente;
        size--;
    }

    public boolean tieneCiclo() {
        Nodo lento = head;
        Nodo rapido = head;

        while (rapido != null && rapido.siguiente != null) {
            lento = lento.siguiente;
            rapido = rapido.siguiente.siguiente;

            if (lento == rapido) {
                return true;
            }
        }

        return false;
    }

    public void listar() {
        if (tieneCiclo()) {
            System.out.println("⚠️ Error: se detectó un ciclo en la lista. No se puede listar de forma segura.");
            return;
        }

        Nodo actual = head;
        System.out.println("Código | Nombre | Salario");

        while (actual != null) {
            System.out.println(actual.codigo + " | " + actual.nombre + " | " + actual.salario);
            actual = actual.siguiente;
        }

        System.out.println("Tamaño actual: " + size);
        System.out.println("--------------------------------");
    }
}
