import java.util.Scanner;
 
class LinkedList{
 
    private int longitud;
    private Nodo head;
    private Nodo tail;
 
    class Nodo{
        private int valor;
        private Nodo siguiente;
 
        Nodo(int elemento){
            this.valor = elemento;
            this.siguiente = null;
        }
    }
 
    public boolean estaVacio(){
        return this.longitud == 0;
    }
 
    public int contarElementos(){
        return this.longitud;
    }
 
    public boolean insertarAlInicio(int elemento){
 
        Nodo nodoActual = this.head;
        Nodo nodoNuevo = new Nodo(elemento);
 
        if (estaVacio()){
            this.head = nodoNuevo;
            this.tail = nodoNuevo;
            this.head.siguiente = nodoNuevo;
            this.longitud++;
            return true;
        }else{
 
            this.head = nodoNuevo;
            this.head.siguiente = nodoActual;
            nodoActual = this.head;
 
            while(nodoActual.siguiente != this.head){
 
                nodoActual = nodoActual.siguiente;
                if(nodoActual.siguiente == this.head){
                    this.tail = nodoActual;
                    this.tail.siguiente = this.head;
                }else if(nodoActual == this.tail){
                    this.tail.siguiente = this.head;
                    break;
                }
            }
 
            this.longitud++;
            return true;
        }
    }
 
    public String mostrarLista(){
 
        if (estaVacio()){
            return "La lista esta vacia.";
        }
 
        String lista = "";
        Nodo nodoActual = this.head;
        while(nodoActual.siguiente != this.head){
            lista += nodoActual.valor + " -> ";
            nodoActual = nodoActual.siguiente;
        }
        lista += this.tail.valor + " -> (Apunta de nuevo a " + this.tail.siguiente.valor + ")";
        return lista;
 
    }
 
    public boolean insertarAlFinal(int elemento){
 
        Nodo nodoActual = this.tail;
        Nodo nodoNuevo = new Nodo(elemento);
        if(estaVacio()){
            this.head = nodoNuevo;
            this.tail = nodoNuevo;
            this.head.siguiente = this.head;
            this.longitud ++;
            return true;
        }else{
            nodoActual.siguiente = nodoNuevo;
            this.tail = nodoNuevo;
            this.tail.siguiente = this.head;
            longitud ++;
            return true;
        }
    }
}
 
public class Main {
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        LinkedList lista = new LinkedList();
        boolean salir = false;
 
        System.out.println("===========================================");
        System.out.println(" LISTA SIMPLEMENTE ENLAZADA CIRCULAR");
        System.out.println("===========================================");
 
        while (!salir) {
 
            System.out.println("\n--- MENU ---");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Mostrar todos los elementos");
            System.out.println("4. Verificar si la lista esta vacia");
            System.out.println("5. Contar el numero de elementos");
            System.out.println("6. Salir");
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
                    int valor = leerEntero(sc, "Ingrese el valor a insertar al inicio: ");
                    lista.insertarAlInicio(valor);
                    System.out.println("Insertado. Lista actual: " + lista.mostrarLista());
                    break;
                }
                case 2: {
                    int valor = leerEntero(sc, "Ingrese el valor a insertar al final: ");
                    lista.insertarAlFinal(valor);
                    System.out.println("Insertado. Lista actual: " + lista.mostrarLista());
                    break;
                }
                case 3:
                    System.out.println("Lista: " + lista.mostrarLista());
                    break;
                case 4:
                    System.out.println(lista.estaVacio() ? "La lista esta vacia." : "La lista NO esta vacia.");
                    break;
                case 5:
                    System.out.println("Numero de elementos: " + lista.contarElementos());
                    break;
                case 6:
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
 