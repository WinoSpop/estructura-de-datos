

class Estudiante{

    private String nombre;
    private int id;
    private int edad;
    private double promedio;

    public Estudiante(String nombre,int id, int edad, double promedio){
        this.nombre = nombre;
        this.edad = edad;
        this.promedio = promedio;
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPromedio() {
        return promedio;
    }

    public int getId() {
        return id;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString(){
        return "Nombre: "+ nombre + " |ID: "+ id + " |Edad: " + edad + " |Promedio: " + promedio; 
    }
}