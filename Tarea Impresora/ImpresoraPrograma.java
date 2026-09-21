import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ImpresoraPrograma{

    class Impresora{
        Deque <String> colaImpresiones;
        Deque <String> historial;

        Impresora(){
            this.historial = new ArrayDeque<>();
            this.colaImpresiones = new ArrayDeque<>();
        }

        public boolean registrarDocumento(String nombre){
            
            System.out.println( nombre + " se ha registrado.");
            return colaImpresiones.offerLast(nombre);
        }

        public boolean imprimirSiguiente(){
            if(colaImpresiones.isEmpty()){
                System.out.println("No hay documentos pendientes.");
                return false;
            }

            String impreso = colaImpresiones.pollFirst();
            System.out.println(impreso + " se ha impreso.");
            return guardarImpresion(impreso);
        }

        public boolean guardarImpresion(String nombre){
            historial.push(nombre);
            System.out.println(nombre + " se ha guardado en historial.");
            return true;
        }

        public boolean recuperarUltima(){
            if(historial.isEmpty()){
                System.out.println("No hay elementos que recuperar.");
                return false;
            }
            
            String recuperado = historial.pop();
            System.out.println(recuperado + " se ha recuperado de vuelta a pendientes.");
            colaImpresiones.addFirst(recuperado);
            return true;
        }

        public void mostrarHistorial(){

            System.out.println("Historial -> " + historial);
        }

        public void mostrarDocumentosPendientes(){
            System.out.println("Documentos pendientes -> " + colaImpresiones);
        }
    }

    public static void main(String[] args) {
        ImpresoraPrograma.Impresora impresora = new ImpresoraPrograma().new Impresora();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("=======IMPRESORA=======");
            System.out.println("1. Registrar documento.");
            System.out.println("2. Imprimir siguiente.");
            System.out.println("3. Guardar impresion.");
            System.out.println("4. Recuperar ultima.");
            System.out.println("5. Mostrar historial.");
            System.out.println("6. Mostrar documentos pendientes.");
            System.out.println("0. Salir.");
            System.out.print("Elija una opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();
            System.out.println();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del documento:  ");
                    String documento = sc.nextLine();
                    System.out.println();

                    impresora.registrarDocumento(documento);
                    break;
                
                case 2:
                    impresora.imprimirSiguiente();
                    break;

                case 3:
                    System.out.print("Ingrese el nombre del documento: ");
                    String documento2 = sc.nextLine();
                    System.out.println();
                    impresora.guardarImpresion(documento2);
                    break;
                
                case 4:
                    impresora.recuperarUltima();
                    break;

                case 5:
                    impresora.mostrarHistorial();
                    break;

                case 6:
                    impresora.mostrarDocumentosPendientes();
                    break;

                case 0:
                    System.out.println("Hasta luego...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }   
    }
}
