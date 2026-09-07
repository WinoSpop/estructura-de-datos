import java.util.Scanner;
 
class ColaRoundRobin{
    static class RoundRobin {
 
        static final int QUATUM = 2;
        private int longitud;
        private Proceso head;
        private Proceso tail;
 
        //==> Clase que crea Procesos
        class Proceso{
            private int tiempo;
            private String nombreProceso;
            private Proceso siguiente;
 
            Proceso(int tiempo){
                this.tiempo = tiempo;
                this.nombreProceso = "P" + (longitud+1);
                this.siguiente = null;
            }
 
            @Override
            public String toString(){
                return nombreProceso + "(" + "tiempo=" + tiempo + ")";
            }
        }
 
        public boolean estaVacio(){
            return longitud == 0;
        }
 
        public int contarElementos(){
            return longitud;
        }
 
        //==> Ingresa procesos
        public boolean insertarProceso(int tiempo){
 
            if(tiempo < 1){
                throw new IllegalArgumentException("El tiempo debe ser mayor a 0.");
            }
 
            Proceso procesoActual = tail;
            Proceso procesoNuevo = new Proceso(tiempo);
 
            //==> Si la "lista" esta vacia, head, tail y siguiente de ese nodo, sera si mismo.
            if(estaVacio()){
                head = procesoNuevo;
                tail = procesoNuevo;
                head.siguiente = procesoNuevo;
                longitud ++;
                return true;
            }else{
 
                //==> Al crear un proceso, este se colocara al ultimo de la "lista".
                procesoActual.siguiente = procesoNuevo;
                tail = procesoNuevo;
                tail.siguiente = head;
                longitud ++;
                return true;
            }
        }
 
        public String mostrarCola(){
 
            if(estaVacio()){
                return "La cola esta vacia.";
            }
 
            Proceso nodoActual = head;
            String lista = "head -> " + nodoActual;
 
            //==> Busca hasta encontra que el enlace del nodo actual sea el head.
            while(nodoActual.siguiente != this.head){
                nodoActual = nodoActual.siguiente;
                lista += " -> " + nodoActual;
            }
 
            lista += " -> (vuelve a " + nodoActual.siguiente.nombreProceso + ")";
            return lista;
        }
 
        public void ejecutarRoundRobin(){
            if(estaVacio()){
                System.out.println("No hay procesos que ejecutar.");
                return;
            }
 
            int contador = 1;
 
            while(longitud != 0){
 
                System.out.println("===== ITERACION " + contador + " ====");
                head.tiempo -= QUATUM;
 
                if(head.tiempo < 1){
                    System.out.println("--El " + head.nombreProceso + " ha terminado--" );
                    head = head.siguiente;
                    if (!estaVacio() && longitud > 1) {
                        tail.siguiente = head;
                    }
                    longitud --;
                    contador ++;
                }else{
                    head = head.siguiente;
                    contador ++;
                }
 
                System.out.println(mostrarCola());
            }
 
            System.out.println("La cola ha terminado.");
        }
    }
 
    public static void main(String[] args){
 
        Scanner sc = new Scanner(System.in);
        RoundRobin cola = new RoundRobin();
        boolean salir = false;
        boolean simulacionEjecutada = false;
 
        System.out.println("=========================================");
        System.out.println(" SIMULACION ROUND-ROBIN - LISTA CIRCULAR");
        System.out.println(" Quantum fijo = " + RoundRobin.QUATUM);
        System.out.println("=========================================");
 
        while (!salir) {
 
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar proceso (nombre automatico)");
            System.out.println("2. Mostrar cola de procesos");
            System.out.println("3. Verificar si la cola esta vacia");
            System.out.println("4. Contar numero de procesos");
            System.out.println("5. Ejecutar simulacion Round-Robin");
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
                    if (simulacionEjecutada) {
                        System.out.println("La simulacion ya se ejecuto. Reinicie el programa para cargar procesos nuevos.");
                        break;
                    }
                    int tiempo = leerEntero(sc, "Ingrese el tiempo del proceso (entero mayor a 0): ");
                    try {
                        cola.insertarProceso(tiempo);
                        System.out.println("Proceso agregado. Cola actual: " + cola.mostrarCola());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                }
                case 2:
                    System.out.println("Cola: " + cola.mostrarCola());
                    break;
                case 3:
                    System.out.println(cola.estaVacio() ? "La cola esta vacia." : "La cola NO esta vacia.");
                    break;
                case 4:
                    System.out.println("Numero de procesos: " + cola.contarElementos());
                    break;
                case 5:
                    if (cola.estaVacio()) {
                        System.out.println("Agregue al menos un proceso antes de ejecutar la simulacion.");
                        break;
                    }
                    if (simulacionEjecutada) {
                        System.out.println("La simulacion ya fue ejecutada anteriormente (la cola quedo vacia).");
                        break;
                    }
                    System.out.println();
                    cola.ejecutarRoundRobin();
                    simulacionEjecutada = true;
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