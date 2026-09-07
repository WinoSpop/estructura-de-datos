import java.util.Scanner;
 
public class ReproductorMusica {
 
    static class ReproductorDeMusica{
        private int cantidadMusicas;
        private Musica head;
        private Musica tail;
 
        class Musica{
            private String nombre;
            private Musica siguiente;
 
            Musica(String nombre){
                this.nombre = nombre;
                this.siguiente = null;
            }
        }
 
        public boolean reproductorVacio(){
            return cantidadMusicas == 0;
        }
 
        public int contarCanciones(){
            return cantidadMusicas;
        }
 
        public String mostrarPlayList(){
            if(reproductorVacio()){
                return "PlayList vacia.";
            }
 
            Musica musicaActual = head;
            String lista = "Reproduciendo ahora -> " + musicaActual.nombre;
 
            while (musicaActual.siguiente != head) {
                musicaActual = musicaActual.siguiente;
                lista += " -> " + musicaActual.nombre;
            }
            lista += " -> (vuelve a " + musicaActual.siguiente.nombre +")";
            return lista;
        }
 
        public boolean reproducirSiguiente(){
            if(reproductorVacio()){
                return false;
            }
 
            head = head.siguiente;
            return true;
        }
 
        public boolean eliminarMusica(String nombre){
            if(reproductorVacio()){
                return true;
            }
 
            Musica musicaActual = head;
            int contador = 0;
 
            while(true){
 
                musicaActual = musicaActual.siguiente;
                contador ++;
                if(musicaActual.siguiente.nombre.equals(nombre)){
                   break;
                }else if(contador == cantidadMusicas){
                    return false;
                }
 
            }
 
            if(musicaActual.siguiente == head){
                System.out.println("-- Se ha eliminado " + musicaActual.siguiente.nombre + " del reproductor --");
                tail.siguiente = head.siguiente;
                head = head.siguiente;
                musicaActual.siguiente = musicaActual.siguiente.siguiente;
                cantidadMusicas --;
                return true;
            }else if(musicaActual.siguiente == tail){
                System.out.println("-- Se ha eliminado " + musicaActual.siguiente.nombre + " del reproductor --");
                musicaActual.siguiente = head;
                tail = musicaActual;
                cantidadMusicas --;
                return true;
            }else{
                System.out.println("-- Se ha eliminado " + musicaActual.siguiente.nombre + " del reproductor --");
                musicaActual.siguiente = musicaActual.siguiente.siguiente;
                cantidadMusicas --;
                return true;
            }
        }
 
        public boolean insertarMusicaAlInicio(String nombre){
            Musica musicaActual = this.head;
            Musica musicaNueva = new Musica(nombre);
 
            if(reproductorVacio()){
                head = musicaNueva;
                tail = musicaNueva;
                tail.siguiente = musicaNueva;
                cantidadMusicas ++;
                return true;
            }else{
 
                head = musicaNueva;
                head.siguiente = musicaActual;
                cantidadMusicas ++;
                tail.siguiente = head;
                return true;
            }
        }
 
        public boolean insertarMusicaAlFinal(String nombre){
            Musica musicaActual = this.tail;
            Musica musicaNueva = new Musica(nombre);
 
            if(reproductorVacio()){
                head = musicaNueva;
                tail = musicaNueva;
                tail.siguiente = musicaNueva;
                cantidadMusicas ++;
                return true;
            }else{
 
                musicaActual.siguiente = musicaNueva;
                tail = musicaNueva;
                tail.siguiente = head;
                cantidadMusicas ++;
                return true;
            }
        }
    }
 
    public static void main(String[] args) {
 
        Scanner sc = new Scanner(System.in);
        ReproductorDeMusica playlist = new ReproductorDeMusica();
        boolean salir = false;
 
        System.out.println("===========================================");
        System.out.println(" PLAYLIST MUSICAL CIRCULAR");
        System.out.println("===========================================");
 
        while (!salir) {
 
            System.out.println("\n--- MENU ---");
            System.out.println("1. Agregar cancion al inicio");
            System.out.println("2. Agregar cancion al final");
            System.out.println("3. Mostrar playlist completa");
            System.out.println("4. Reproducir siguiente cancion");
            System.out.println("5. Eliminar cancion por nombre");
            System.out.println("6. Verificar si la playlist esta vacia");
            System.out.println("7. Contar numero de canciones");
            System.out.println("8. Salir");
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
                    System.out.print("Nombre de la cancion: ");
                    String nombre = sc.nextLine().trim();
                    playlist.insertarMusicaAlInicio(nombre);
                    System.out.println("Agregada. " + playlist.mostrarPlayList());
                    break;
                }
                case 2: {
                    System.out.print("Nombre de la cancion: ");
                    String nombre = sc.nextLine().trim();
                    playlist.insertarMusicaAlFinal(nombre);
                    System.out.println("Agregada. " + playlist.mostrarPlayList());
                    break;
                }
                case 3:
                    System.out.println(playlist.mostrarPlayList());
                    break;
                case 4:
                    if (playlist.reproducirSiguiente()) {
                        System.out.println(playlist.mostrarPlayList());
                    } else {
                        System.out.println("La playlist esta vacia, no hay nada que reproducir.");
                    }
                    break;
                case 5: {
                    System.out.print("Nombre de la cancion a eliminar: ");
                    String nombre = sc.nextLine().trim();
                    boolean eliminada = playlist.eliminarMusica(nombre);
                    if (!eliminada) {
                        System.out.println("No se encontro una cancion con ese nombre.");
                    } else {
                        System.out.println(playlist.mostrarPlayList());
                    }
                    break;
                }
                case 6:
                    System.out.println(playlist.reproductorVacio() ? "La playlist esta vacia." : "La playlist NO esta vacia.");
                    break;
                case 7:
                    System.out.println("Numero de canciones: " + playlist.contarCanciones());
                    break;
                case 8:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
 
        sc.close();
    }
}