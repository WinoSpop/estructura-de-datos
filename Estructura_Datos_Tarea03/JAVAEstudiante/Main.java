import java.util.Scanner;

public class Main {
    public static void main (String [] args){

        RegistrarEstudiante curso =  new RegistrarEstudiante(31);
        Scanner sc  = new Scanner(System.in);

        curso.registrar(new Estudiante("0000000001", "Altamirano Segovia Jullisa Brigitte", 1, 20, new double[]{8.5,8.5,8.5,8.5,8.5,8.5,8.5}));
        curso.registrar(new Estudiante("0000000002", "Caguana Quishpe Lenin Josue", 2, 19, new double[]{7.8,7.8,7.8,7.8,7.8,7.8,7.8}));
        curso.registrar(new Estudiante("0000000003", "Caiza Caizabuano Jose Ruben", 3, 21, new double[]{9.2,9.2,9.2,9.2,9.2,9.2,9.2}));
        curso.registrar(new Estudiante("0000000004", "Camacho Monta Josue Jampier", 4, 20, new double[]{8.0,8.0,8.0,8.0,8.0,8.0,8.0}));
        curso.registrar(new Estudiante("0000000005", "Chalco Tasna Kenneth Mateo", 5, 22, new double[]{7.5,7.5,7.5,7.5,7.5,7.5,7.5}));
        curso.registrar(new Estudiante("0000000006", "Chico Yunda Juan Carlos", 6, 20, new double[]{9.6,9.6,9.6,9.6,9.6,9.6,9.6}));
        curso.registrar(new Estudiante("0000000007", "Cunalata Mendoza Damian Alexander", 7, 19, new double[]{8.3,8.3,8.3,8.3,8.3,8.3,8.3}));
        curso.registrar(new Estudiante("0000000008", "Espinoza Reyes Kerly Margoth", 8, 21, new double[]{9.0,9.0,9.0,9.0,9.0,9.0,9.0}));
        curso.registrar(new Estudiante("0000000009", "Gamboa Araujo Rommel Fabricio", 9, 20, new double[]{7.9,7.9,7.9,7.9,7.9,7.9,7.9}));
        curso.registrar(new Estudiante("0000000010", "Guamanquispe Guaman Edwin David", 10, 22, new double[]{8.7,8.7,8.7,8.7,8.7,8.7,8.7}));
        curso.registrar(new Estudiante("0000000011", "Ierra Mera Jose Ernesto", 11, 19, new double[]{8.1,8.1,8.1,8.1,8.1,8.1,8.1}));
        curso.registrar(new Estudiante("0000000012", "Jijon Viscaino Gabriel Sebastian", 12, 21, new double[]{9.4,9.4,9.4,9.4,9.4,9.4,9.4}));
        curso.registrar(new Estudiante("0000000013", "Llamuca Abrajan Andres Joel", 13, 20, new double[]{7.6,7.6,7.6,7.6,7.6,7.6,7.6}));
        curso.registrar(new Estudiante("0000000014", "Maigua Shigui Lenin Alexander", 14, 22, new double[]{8.8,8.8,8.8,8.8,8.8,8.8,8.8}));
        curso.registrar(new Estudiante("0000000015", "Manobanda Puaquiza Italo Esteban", 15, 19, new double[]{9.1,9.1,9.1,9.1,9.1,9.1,9.1}));
        curso.registrar(new Estudiante("0000000016", "Moyota Chavez Kleber Andres", 16, 20, new double[]{8.4,8.4,8.4,8.4,8.4,8.4,8.4}));
        curso.registrar(new Estudiante("0000000017", "Ortiz Yaucan Everly Oseas", 17, 21, new double[]{7.7,7.7,7.7,7.7,7.7,7.7,7.7}));
        curso.registrar(new Estudiante("0000000018", "Oto Cundulle Cristopher Raul", 18, 20, new double[]{9.3,9.3,9.3,9.3,9.3,9.3,9.3}));
        curso.registrar(new Estudiante("0000000019", "Romo Nuñez Joseph Alejandro", 19, 22, new double[]{8.2,8.2,8.2,8.2,8.2,8.2,8.2}));
        curso.registrar(new Estudiante("0000000020", "Silva Camuendo Luis Alexander", 20, 19, new double[]{8.9,8.9,8.9,8.9,8.9,8.9,8.9}));
        curso.registrar(new Estudiante("0000000021", "Tacuri Santillan Monica Sara", 21, 20, new double[]{9.5,9.5,9.5,9.5,9.5,9.5,9.5}));
        curso.registrar(new Estudiante("0000000022", "Tenorio Ronquillo Jonathan Sebastian", 22, 21, new double[]{7.4,7.4,7.4,7.4,7.4,7.4,7.4}));
        curso.registrar(new Estudiante("0000000023", "Tisalema Guashco Darwin Joel", 23, 19, new double[]{8.6,8.6,8.6,8.6,8.6,8.6,8.6}));
        curso.registrar(new Estudiante("0000000024", "Torosina Armendariz Jeremy Alejandro", 24, 22, new double[]{9.0,9.0,9.0,9.0,9.0,9.0,9.0}));
        curso.registrar(new Estudiante("0000000025", "Tuza Quinatoa Edith Noemi", 25, 20, new double[]{7.8,7.8,7.8,7.8,7.8,7.8,7.8}));
        curso.registrar(new Estudiante("0000000026", "Villacres Lopez Walter Fernando", 26, 21, new double[]{8.5,8.5,8.5,8.5,8.5,8.5,8.5}));
        curso.registrar(new Estudiante("0000000027", "Yanchatipan Moreta Shirley Micaela", 27, 19, new double[]{9.2,9.2,9.2,9.2,9.2,9.2,9.2}));

        while(true){
            System.out.println();
            System.out.println("====MENU======");
            System.out.println("1.Registrar estudiante");
            System.out.println("2.Listar estudiantes");
            System.out.println("3.Buscar estudiante");
            System.out.println("4.Modificar estudiante");
            System.out.println("5.Eliminar estudiante");
            System.out.println("6.Mostrar cantidad de estudiantes");
            System.out.println("7.Calcular promedio de un estudiante");
            System.out.println("8.Ver notas de un estudiante");
            System.out.println("9.Ver mejor promedio");
            System.out.println("10.Ver promedio general del curso");
            System.out.println("11.Ver aprobados y no aprobados");
            System.out.println("12.Obtener estudiante por posicion");
            System.out.println("13.Contar aprobados (nota minima)");
            System.out.println("14.Buscar estudiante por nombre");
            System.out.println("15.Buscar estudiante por cedula");
            System.out.println("0.Salir");
            System.out.println("Ingrese una opcion: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1:
                    int id;
                    boolean repetido;
                    boolean cedulaRepetida;
                    String cedula;
                    System.out.println("Ingrese nombre: ");
                    String nombre = sc.nextLine();

                    int edad;
                    do{
                        System.out.println("Ingrese edad: ");
                        edad = sc.nextInt();
                        if(edad < 0){
                            System.out.println("La edad no puede ser negativa.");
                        }
                    }while(edad < 0);
                    sc.nextLine();

                    double [] notas = new double[7];
                    for(int i = 0; i < 7; i++){
                        double nota;
                        do{
                            System.out.println("Ingrese nota "+(i+1)+": ");
                            nota = sc.nextDouble();
                            if(nota < 0){
                                System.out.println("La nota no puede ser negativa.");
                            }
                        }while(nota < 0);
                        notas[i] = nota;
                    }
                    sc.nextLine();

                    do{
                        cedulaRepetida = false;
                        System.out.println("Ingrese cedula: ");
                        cedula = sc.nextLine();
                        for(Estudiante e : curso.getEstudiantes()){
                            if(cedula.equals(e.getCedula())){
                                System.out.println("La cedula esta repetida, pruebe otra.");
                                cedulaRepetida = true;
                                break;
                            }
                        }
                    }while(cedulaRepetida);

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
                    if(curso.registrar(new Estudiante(cedula, nombre, id, edad, notas))){
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

                    int nuevaEdad;
                    do{
                        System.out.println("Ingrese nueva edad: ");
                        nuevaEdad = sc.nextInt();
                        if(nuevaEdad < 0){
                            System.out.println("La edad no puede ser negativa.");
                        }
                    }while(nuevaEdad < 0);

                    double [] nuevasNotas = new double[7];
                    for(int i = 0; i < 7; i++){
                        double nuevaNota;
                        do{
                            System.out.println("Ingrese nota "+(i+1)+": ");
                            nuevaNota = sc.nextDouble();
                            if(nuevaNota < 0){
                                System.out.println("La nota no puede ser negativa.");
                            }
                        }while(nuevaNota < 0);
                        nuevasNotas[i] = nuevaNota;
                    }
                    if(curso.modificar(encontrado2, nuevoNombre, nuevaEdad, nuevasNotas)){
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

                case 7:
                    System.out.println("Ingrese ID del estudiante: ");
                    int idProm = sc.nextInt();
                    sc.nextLine();
                    Estudiante paraPromedio = curso.buscarEstudiante(idProm);
                    if(paraPromedio != null){
                        System.out.println("Promedio de "+ paraPromedio.getNombre() + ": " + paraPromedio.promedio());
                    }
                break;

                case 8:
                    System.out.println("Ingrese ID del estudiante: ");
                    int idNotas = sc.nextInt();
                    sc.nextLine();
                    Estudiante paraNotas = curso.buscarEstudiante(idNotas);
                    if(paraNotas != null){
                        System.out.println("Notas de "+ paraNotas.getNombre() + ":");
                        double [] notasEst = paraNotas.getNotas();
                        for(int i = 0; i < notasEst.length; i++){
                            System.out.printf("  Nota %d: %.2f%n", (i+1), notasEst[i]);
                        }
                    }
                break;

                case 9:
                    Estudiante mejor = curso.mejorPromedio();
                    if(mejor != null){
                        System.out.println("Mejor promedio: " + mejor);
                    }else{
                        System.out.println("No hay estudiantes registrados.");
                    }
                break;

                case 10:
                    System.out.println("Promedio general del curso: " + curso.promedioGeneral());
                break;

                case 11:
                    curso.mostrarAprobadosReprobados(7.0);
                break;

                case 12:
                    System.out.println("Ingrese posicion: ");
                    int posicion = sc.nextInt();
                    sc.nextLine();
                    Estudiante enPosicion = curso.obtener(posicion);
                    if(enPosicion != null){
                        System.out.println(enPosicion);
                    }
                break;

                case 13:
                    System.out.println("Ingrese nota minima: ");
                    double minimo = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Aprobados: " + curso.contarAprobados(minimo));
                break;

                case 14:
                    System.out.println("Ingrese nombre: ");
                    String nombreBuscar = sc.nextLine();
                    Estudiante porNombre = curso.buscarPorNombre(nombreBuscar);
                    if(porNombre != null){
                        System.out.println(porNombre);
                    }
                break;

                case 15:
                    System.out.println("Ingrese cedula: ");
                    String cedulaBuscar = sc.nextLine();
                    Estudiante porCedula = curso.buscarPorCedula(cedulaBuscar);
                    if(porCedula != null){
                        System.out.println(porCedula);
                    }
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
