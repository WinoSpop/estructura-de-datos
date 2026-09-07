import java.util.Scanner;
 
public class JosephProblem {
 
    static class ListaJosephus {
 
        private Nodo tail;
        private Nodo head;
        private int longitud;
        private int k;
        private int n;
 
        class Nodo {
            private Nodo siguiente;
            private String nombre;
 
            Nodo() {
                this.siguiente = null;
                this.nombre = "P" + (longitud + 1);
            }
        }
 
        ListaJosephus(int k, int n) {
            this.head = null;
            this.tail = null;
            this.k = k;
            this.n = n;
            this.longitud = 0;
        }
 
        public boolean estaVacio() {
            return longitud == 0;
        }
 
        public String mostrar() {
 
            if (estaVacio()) {
                return "La lista esta vacia.";
            }
 
            Nodo nodoActual = this.head;
            String lista = "";
 
            while (nodoActual.siguiente != this.head) {
                lista += nodoActual.nombre + " -> ";
                nodoActual = nodoActual.siguiente;
            }
 
            lista += nodoActual.nombre + " -> (HEAD " + nodoActual.siguiente.nombre + ")";
            return lista;
        }
 
        public boolean insertarNodo() {
            if (longitud == n) {
                System.out.println("Se alcanzo el máximo de elementos.");
                return false;
            }
 
            Nodo nodoNuevo = new Nodo();
            Nodo nodoActual = this.tail;
 
            if (estaVacio()) {
                head = nodoNuevo;
                tail = nodoNuevo;
                tail.siguiente = nodoNuevo;
                longitud++;
                return true;
            } else {
                nodoActual.siguiente = nodoNuevo;
                tail = nodoNuevo;
                tail.siguiente = head;
                longitud++;
                return true;
            }
        }
 
        public void ejecutarJosephus() {
 
            if (estaVacio()) {
                System.out.println("La lista esta vacia.");
                return;
            }
 
            Nodo nodoActual = this.head;
            Nodo nodoActualSiguiente;
            int contador;
 
            while (longitud > 1) {
 
                contador = 1;
                while (contador < k - 1) {
                    nodoActual = nodoActual.siguiente;
                    contador++;
                }
 
                nodoActualSiguiente = nodoActual.siguiente;
 
                System.out.println(nodoActual.nombre + " mata a " + nodoActualSiguiente.nombre);

                if (nodoActualSiguiente == this.head) {
                    this.head = nodoActualSiguiente.siguiente;
                }
                nodoActual.siguiente = nodoActualSiguiente.siguiente;
                nodoActual = nodoActualSiguiente.siguiente;
                longitud--;
                System.out.println(mostrar());
            }
 
            System.out.println("Ganador: " + nodoActual.nombre);
        }
    }
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
 
        System.out.println("=====================================");
        System.out.println(" PROBLEMA DE JOSEPHUS - LISTA CIRCULAR");
        System.out.println("=====================================");
 
        while (!salir) {
 
            System.out.println("\n--- MENU ---");
            System.out.println("1. Probar caso n=5, k=2");
            System.out.println("2. Probar caso n=7, k=3");
            System.out.println("3. Ingresar valores personalizados de n y k");
            System.out.println("4. Salir");
            System.out.print("Elija una opcion: ");
 
            int opcion;
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida, ingrese un numero.");
                continue;
            }
 
            switch (opcion) {
                case 1:
                    correrCaso(2, 5);
                    break;
                case 2:
                    correrCaso(3, 7);
                    break;
                case 3:
                    int n = leerEntero(sc, "Ingrese el numero de personas (n): ");
                    int k = leerEntero(sc, "Ingrese el valor de k: ");
                    if (n <= 0 || k <= 0) {
                        System.out.println("n y k deben ser mayores a 0.");
                        break;
                    }
                    correrCaso(k, n);
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
 
        sc.close();
    }
 
    private static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un numero entero valido.");
            }
        }
    }
 
    private static void correrCaso(int k, int n) {
        System.out.println("\n>>> Ejecutando con n=" + n + ", k=" + k + " <<<");
 
        ListaJosephus lista = new ListaJosephus(k, n);
 
        for (int i = 0; i < n; i++) {
            lista.insertarNodo();
        }
 
        System.out.println("Lista inicial: " + lista.mostrar());
        System.out.println();
        lista.ejecutarJosephus();
    }
}
 