
class RegistrarEstudiante{

    private Estudiante [] estudiantes;
    private int cantidadMaxima;
    

    public RegistrarEstudiante(int cantidad){
        if(cantidad < 0){
            throw new IllegalArgumentException("El numero no puede ser negativo");
        }
        this.cantidadMaxima = cantidad;
        this.estudiantes = new Estudiante [0];
    }

    public int getCantidad() {
        return cantidadMaxima;
    }

    public int getCapacidad(){
        return estudiantes.length;
    }

    public boolean estaLleno(){
        return cantidadMaxima == estudiantes.length;
    }

    public boolean estaVacio(){
        return estudiantes.length == 0;
    }

    public Estudiante [] getEstudiantes(){
        return this.estudiantes;
    } 

    // ==> AQUI SE IMPLEMENTA CREATE
    public boolean registrar(Estudiante estudiante){
        if(estudiante == null){
                System.out.println("El objeto esta vacio");
                return false;
            }
            
        if(estudiantes.length == cantidadMaxima){
            System.out.println("El registro esta lleno con: "+cantidadMaxima+" estudiantes.");
            return false;
        }
        
        Estudiante [] nuevaListaEstudiantes = new Estudiante[estudiantes.length+1];
        int j = 0;
        for(int i = 0; i<nuevaListaEstudiantes.length-1; i++){
            nuevaListaEstudiantes[j++] = estudiantes[i];
        }
        nuevaListaEstudiantes[nuevaListaEstudiantes.length-1] = estudiante;
        
        estudiantes = nuevaListaEstudiantes;
        return true;
    }

    // ==> AQUI SE IMPLEMENTA READ
    public void listar(){

        if(estaVacio()){
            System.out.println("La lista esta vacia.");
            return;
        }

        System.out.println();
        System.out.println("========ESTUDIANTES=========");
        for(Estudiante e: estudiantes){
            System.out.println("- "+ e);
        }
    }

    public Estudiante buscarEstudiante(int id){
        if(id <= 0){
            System.out.println("No existen IDs negativos o 0s.");
            return null;
        }

        for(Estudiante e : estudiantes){
            if(id == e.getId()){
                return e;
            }
        }

        System.out.println("Estudiante no encontrado");
        return null;
    }

    // ==> AQUI SE IMPLEMENTA UPDATE
    public boolean modificar(Estudiante estudiante, String nuevoNombre, int nuevoEdad, double nuevoPromedio){

        if(estudiante == null){
            return false;
        }
        estudiante.setNombre(nuevoNombre);
        estudiante.setEdad(nuevoEdad);
        estudiante.setPromedio(nuevoPromedio);
        return true;
        
    }

    // ==> AQUI SE IMPLEMENTA DELETE
    public boolean eliminar(int id){
        
        int index = -1;
        for(int i = 0; i < estudiantes.length; i++){
            if(id == estudiantes[i].getId()){
                index = i;
                break;
            }
        }

        if(index < 0){
            return false;
        }

        Estudiante [] nuevaListaEstudiantes = new Estudiante[estudiantes.length-1];
        
        int j = 0;
        for(int i = 0; i < estudiantes.length; i++){
            if( i!= index){
                nuevaListaEstudiantes[j++] = estudiantes[i];
            }
        }

        estudiantes = nuevaListaEstudiantes;
        return true;
   
    }

    

}