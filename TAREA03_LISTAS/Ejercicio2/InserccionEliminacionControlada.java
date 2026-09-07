import java.util.Scanner;
 
public class InserccionEliminacionControlada {
 
    // Nodo
    static class Nodo {
        int elemento;
        Nodo siguiente;
 
        public Nodo(int elemento) {
            this.elemento = elemento;
            this.siguiente = null;
        }
    }
 
    // Lista enlazada circular
    static class ListaCircular {
 
        private Nodo head;
        private Nodo tail;
        private int longitud;
 
        public ListaCircular() {
            this.head = null;
            this.tail = null;
            this.longitud = 0;
        }
 
        public boolean estaVacio() {
            return this.longitud == 0;
        }
 
        public int contarElementos() {
            return this.longitud;
        }
 
        public boolean insertarEnPosicion(int elemento, int posicion) {
 
            if (posicion < 0 || posicion > this.longitud) {
                return false;
            }
 
            Nodo nodoNuevo = new Nodo(elemento);
 
            if (estaVacio()) {
                this.head = nodoNuevo;
                this.tail = nodoNuevo;
                this.tail.siguiente = this.head;
                this.longitud++;
                return true;
            }
 
            if (posicion == 0) {
                nodoNuevo.siguiente = this.head;
                this.head = nodoNuevo;
                this.tail.siguiente = this.head;
                this.longitud++;
                return true;
            }
 
            Nodo nodoActual = this.head;
            int i = 0;
 
            while (i < posicion - 1) {
                nodoActual = nodoActual.siguiente;
                i++;
            }
 
            nodoNuevo.siguiente = nodoActual.siguiente;
            nodoActual.siguiente = nodoNuevo;
 
            if (posicion == this.longitud) {
                this.tail = nodoNuevo;
            }
 
            this.longitud++;
            return true;
        }
 
        public boolean eliminarPorPosicion(int posicion){
            if(posicion < 0 || posicion >= longitud){
                return false;
            }
            if(estaVacio()){
                return false;
            }
 
            Nodo nodoActual = this.head;
            int i = 0;
 
            while(i < posicion - 1){
                nodoActual = nodoActual.siguiente;
                i++;
            }
 
            if(i == longitud){
                System.out.println("-- Se ha eliminado el nodo "+nodoActual.siguiente.elemento+ " --");
                nodoActual.siguiente = this.head;
                this.tail = nodoActual;
                longitud --;
                return true;
            }else if(nodoActual == this.head && posicion == 0){
                System.out.println("-- Se ha eliminado el nodo "+nodoActual.elemento+ " --");
                this.head = nodoActual.siguiente;
                this.tail.siguiente = this.head;
                longitud --;
                return true;
            }else{
                System.out.println("-- Se ha eliminado el nodo "+nodoActual.siguiente.elemento+ " --");
                Nodo nodoActualSiguiente = nodoActual.siguiente;
                nodoActual.siguiente =  nodoActualSiguiente.siguiente;
                if (nodoActualSiguiente == this.tail){
                    this.tail = nodoActual;
                }
                longitud --;
                return true;
            }
        }
 
        public boolean eliminarElementoPorValor(int elemento){
            if(estaVacio()){
                return false;
            }
 
            Nodo nodoActual = this.head;
            int contador = 0;
 
            while (nodoActual.siguiente.elemento != elemento && contador !=longitud) {
                nodoActual = nodoActual.siguiente;
                contador ++;
            }
 
            if(contador == longitud){return false;}
 
            if(nodoActual.siguiente == this.head){
                System.out.println("-- Se ha eliminado el nodo " + nodoActual.siguiente.elemento + " --");
                this.tail.siguiente = this.head.siguiente;
                nodoActual.siguiente = nodoActual.siguiente.siguiente;
                this.head = this.head.siguiente;
                longitud --;
                return true;
 
            }else if(nodoActual.siguiente == this.tail){
                System.out.println("-- Se ha eliminado el nodo " + nodoActual.siguiente.elemento + " --");
                nodoActual.siguiente = nodoActual.siguiente.siguiente;
                this.tail = nodoActual;
                longitud --;
                return true;
 
            }else{
                System.out.println("-- Se ha eliminado el nodo " + nodoActual.siguiente.elemento + " --");
                nodoActual.siguiente = nodoActual.siguiente.siguiente;
                longitud --;
                return  true;
 
            }
        }
 
        // Método para ver la lista
        public String mostrar() {
 
            if (estaVacio()) {
                return "La lista esta vacia.";
            }
 
            Nodo actual = this.head;
            String lista = "";
 
            for (int i = 0; i < this.longitud; i++) {
                lista += actual.elemento + " -> ";
                actual = actual.siguiente;
            }
 
            lista += "(vuelve al HEAD: " + this.head.elemento + ")";
            return lista;
        }
    }
 
    // MAIN
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        ListaCircular lista = new ListaCircular();
        boolean salir = false;
 
        System.out.println("===========================================");
        System.out.println(" INSERCION Y ELIMINACION CONTROLADA");
        System.out.println("===========================================");
 
        while (!salir) {
 
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insertar elemento en una posicion");
            System.out.println("2. Eliminar elemento por posicion");
            System.out.println("3. Eliminar elemento por valor");
            System.out.println("4. Mostrar la lista");
            System.out.println("5. Verificar si la lista esta vacia");
            System.out.println("6. Contar numero de elementos");
            System.out.println("7. Salir");
            System.out.print("Elija una opcion: ");
 
            int opcion;
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida, ingrese un numero.");
                continue;
            }
 
            switch (opcion) {
                case 1: {
                    int elemento = leerEntero(sc, "Ingrese el elemento a insertar: ");
                    int posicion = leerEntero(sc, "Ingrese la posicion (0 a " + lista.contarElementos() + "): ");
                    System.out.println("Antes: " + lista.mostrar());
                    boolean ok = lista.insertarEnPosicion(elemento, posicion);
                    if (!ok) {
                        System.out.println("Posicion invalida. No se realizo la insercion.");
                    }
                    System.out.println("Despues: " + lista.mostrar());
                    break;
                }
                case 2: {
                    int posicion = leerEntero(sc, "Ingrese la posicion a eliminar: ");
                    System.out.println("Antes: " + lista.mostrar());
                    boolean ok = lista.eliminarPorPosicion(posicion);
                    if (!ok) {
                        System.out.println("Posicion invalida. No se realizo la eliminacion.");
                    }
                    System.out.println("Despues: " + lista.mostrar());
                    break;
                }
                case 3: {
                    int elemento = leerEntero(sc, "Ingrese el valor a eliminar: ");
                    System.out.println("Antes: " + lista.mostrar());
                    boolean ok = lista.eliminarElementoPorValor(elemento);
                    if (!ok) {
                        System.out.println("El valor no existe en la lista. No se realizo la eliminacion.");
                    }
                    System.out.println("Despues: " + lista.mostrar());
                    break;
                }
                case 4:
                    System.out.println(lista.mostrar());
                    break;
                case 5:
                    System.out.println(lista.estaVacio() ? "La lista esta vacia." : "La lista NO esta vacia.");
                    break;
                case 6:
                    System.out.println("Numero de elementos: " + lista.contarElementos());
                    break;
                case 7:
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
}