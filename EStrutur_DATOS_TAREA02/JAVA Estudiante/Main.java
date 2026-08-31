import java.util.Scanner;

public class Main {
    public static void main (String [] args){

        RegistrarEstudiante curso =  new RegistrarEstudiante(31);
        Scanner sc  = new Scanner(System.in);

        curso.registrar(new Estudiante("Altamirano Segovia Jullisa Brigitte", 1, 20, 8.5));
        curso.registrar(new Estudiante("Caguana Quishpe Lenin Josue", 2, 19, 7.8));
        curso.registrar(new Estudiante("Caiza Caizabuano Jose Ruben", 3, 21, 9.2));
        curso.registrar(new Estudiante("Camacho Monta Josue Jampier", 4, 20, 8.0));
        curso.registrar(new Estudiante("Chalco Tasna Kenneth Mateo", 5, 22, 7.5));
        curso.registrar(new Estudiante("Chico Yunda Juan Carlos", 6, 20, 9.6));
        curso.registrar(new Estudiante("Cunalata Mendoza Damian Alexander", 7, 19, 8.3));
        curso.registrar(new Estudiante("Espinoza Reyes Kerly Margoth", 8, 21, 9.0));
        curso.registrar(new Estudiante("Gamboa Araujo Rommel Fabricio", 9, 20, 7.9));
        curso.registrar(new Estudiante("Guamanquispe Guaman Edwin David", 10, 22, 8.7));
        curso.registrar(new Estudiante("Ierra Mera Jose Ernesto", 11, 19, 8.1));
        curso.registrar(new Estudiante("Jijon Viscaino Gabriel Sebastian", 12, 21, 9.4));
        curso.registrar(new Estudiante("Llamuca Abrajan Andres Joel", 13, 20, 7.6));
        curso.registrar(new Estudiante("Maigua Shigui Lenin Alexander", 14, 22, 8.8));
        curso.registrar(new Estudiante("Manobanda Puaquiza Italo Esteban", 15, 19, 9.1));
        curso.registrar(new Estudiante("Moyota Chavez Kleber Andres", 16, 20, 8.4));
        curso.registrar(new Estudiante("Ortiz Yaucan Everly Oseas", 17, 21, 7.7));
        curso.registrar(new Estudiante("Oto Cundulle Cristopher Raul", 18, 20, 9.3));
        curso.registrar(new Estudiante("Romo Nuñez Joseph Alejandro", 19, 22, 8.2));
        curso.registrar(new Estudiante("Silva Camuendo Luis Alexander", 20, 19, 8.9));
        curso.registrar(new Estudiante("Tacuri Santillan Monica Sara", 21, 20, 9.5));
        curso.registrar(new Estudiante("Tenorio Ronquillo Jonathan Sebastian", 22, 21, 7.4));
        curso.registrar(new Estudiante("Tisalema Guashco Darwin Joel", 23, 19, 8.6));
        curso.registrar(new Estudiante("Torosina Armendariz Jeremy Alejandro", 24, 22, 9.0));
        curso.registrar(new Estudiante("Tuza Quinatoa Edith Noemi", 25, 20, 7.8));
        curso.registrar(new Estudiante("Villacres Lopez Walter Fernando", 26, 21, 8.5));
        curso.registrar(new Estudiante("Yanchatipan Moreta Shirley Micaela", 27, 19, 9.2));

        while(true){
            System.out.println();
            System.out.println("====MENU======");
            System.out.println("1.Registrar estudiante");
            System.out.println("2.Listar estudiantes");
            System.out.println("3.Buscar estudiante");
            System.out.println("4.Modificar estudiante");
            System.out.println("5.Eliminar estudiante");
            System.out.println("6.Mostrar cantidad de estudiantes");
            System.out.println("0.Salir");
            System.out.println("Ingrese una opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:
                    int id;
                    boolean repetido;
                    System.out.println("Ingrese nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese edad: ");
                    int edad = sc.nextInt();
                    System.out.println("Ingrese promedio: ");
                    double promedio = sc.nextDouble();
                    
                    do{
                        repetido = false;
                        System.out.println("Ingrese Id: ");
                        id = sc.nextInt();
                        for(Estudiante e : curso.getEstudiantes()){
                            if(id == e.getId()){
                                System.out.println("El id esta repetido, pruebe otro.");
                                repetido = true;
                                break;
                            }
                        }
                    }while(repetido);

                    sc.nextLine();
                    if(curso.registrar(new Estudiante(nombre,id, edad, promedio))){
                        System.out.println("Estudiante registrado.");
                    }else{
                        System.out.println("No se pudo registrar estudiante.");
                    }

                break;

                case 2:
                    curso.listar();
                break;

                case 3:
                    System.out.println("Ingrese ID del estudiante");
                    int idBuscar = sc.nextInt();
                    sc.nextLine();
                    Estudiante encontrado = curso.buscarEstudiante(idBuscar);
                    if(encontrado != null){
                        System.out.println(encontrado);
                    }else{
                        System.out.println("El estudiante no se encuentra en el listado.");
                    }
                break;

                case 4:
                    //modificar(int id, String nuevoNombre, int nuevoEdad, double nuevoPromedio)
                    System.out.println("Ingrese ID del estudiante a modificar: ");
                    int idMod = sc.nextInt();
                    sc.nextLine();

                    Estudiante encontrado2 = curso.buscarEstudiante(idMod); 
                    if(encontrado2 == null){
                        System.out.println("Estudiante no encontrado.");
                        break;
                    }

                    System.out.println("Ingrese nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();
                    System.out.println("Ingrese nueva edad: ");
                    int nuevaEdad =  sc.nextInt();
                    System.out.println("Ingrese nuevo promedio: ");
                    double nuevoPromedio = sc.nextDouble();
                    if(curso.modificar(encontrado2, nuevoNombre, nuevaEdad, nuevoPromedio)){
                        System.out.println("El estudiante se ah actualizado.");
                    }else{
                        System.out.println("No se pudo actualizar el estudiante.");
                    }
                    sc.nextLine();

                    break;

                case 5:
                    System.out.println("Ingrese ID del estudiante a eliminar: ");
                    int idElim = sc.nextInt();
                    sc.nextLine();
                    if(curso.eliminar(idElim)){
                        System.out.println("Estudiante eliminado.");
                    }else{
                        System.out.println("Estudiante no encontrado.");
                    }
                break;

                case 6:
                    System.out.println("Se han registrado "+ curso.getCantidad() + " en el curso.");
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
