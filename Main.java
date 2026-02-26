public class Main {
    public static void main(String[] args) {
        ListaSimple lista = new ListaSimple();

        int correlativo = 20;
        int errores = 0;

        System.out.println("Carga automática de 17 registros");

        for (int i = 1; i <= 17; i++) {
            String codigo = "SB-" + correlativo + "Y";
            String nombre = "Nombre" + i;
            float salario = (float) (Math.random() * 100);

            try {
                lista.addLast(codigo, nombre, salario);
                System.out.println("OK -> " + i + ", " + codigo + ", " + nombre + ", " + salario);
            } catch (Exception e) {
                errores++;
                System.out.println("ERROR en registro " + i + ": " + e.getMessage());
            }

            correlativo++;
        }

        System.out.println("\nResumen de carga:");
        System.out.println("Total esperados: 17");
        System.out.println("Total en lista: " + lista.size());
        System.out.println("Errores detectados: " + errores);
        System.out.println("¿Lista con ciclos?: " + lista.tieneCiclo());

        if (lista.size() != 17) {
            System.out.println("⚠️ Error: la cantidad final no coincide con 17.");
        }

        lista.listar();
    }
}
