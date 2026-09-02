

class Estudiante{

    private String cedula;
    private String nombre;
    private int id;
    private int edad;
    private double [] notas; // 7 notas

    public Estudiante(String cedula, String nombre,int id, int edad, double [] notas){
        this.cedula = cedula;
        this.nombre = nombre;
        this.edad = edad;
        this.notas = notas;
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public double [] getNotas() {
        return notas;
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

    public void setNotas(double [] notas) {
        this.notas = notas;
    }

    public double promedio(){
        double suma = 0;
        for(double nota : notas){
            suma += nota;
        }
        return suma / notas.length;
    }

    @Override
    public String toString(){
        return "Cedula: "+ cedula + " |Nombre: "+ nombre + " |ID: "+ id + " |Edad: " + edad + " |Promedio: " + promedio(); 
    }
}
