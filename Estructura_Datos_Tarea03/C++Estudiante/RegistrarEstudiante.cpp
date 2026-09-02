#include <iterator>
#include <iostream>
#include <string>
#include <iomanip>
#include <algorithm>
using namespace std;

class Estudiante{
    protected:

        string cedula;
        string nombre;
        int edad;
        int id;
        double notas[7];

    public:

    //==> Inicializamos el objeto por default para definir el arreglo.
    Estudiante(){
        cedula = "";
        nombre = "";
        edad= 0;
        id = 0;
        for(int i = 0; i < 7; i++){
            notas[i] = 0.0;
        }
    }

    Estudiante(string cedula, string nombre, int edad, int id, double notas[]){
        this->cedula = cedula;
        this->nombre = nombre;
        this->edad = edad;
        this->id = id;
        for(int i = 0; i < 7; i++){
            this->notas[i] = notas[i];
        }
    }

    string getCedula(){
        return cedula;
    }

    int getEdad(){
        return edad;
    }

    string getNombre(){
        return nombre;
    }

    double* getNotas(){
        return notas;
    }

    int getId(){
        return id;
    }

    void setCedula(string nuevaCedula){
        cedula = nuevaCedula;
    }

    void setEdad(int nuevaEdad){
        edad = nuevaEdad;
    }

    void setNombre(string nuevoNombre){
        nombre = nuevoNombre;
    }

    void setNotas(double nuevasNotas[]){
        for(int i = 0; i < 7; i++){
            notas[i] = nuevasNotas[i];
        }
    }

    double promedio(){
        double suma = 0;
        for(int i = 0; i < 7; i++){
            suma += notas[i];
        }
        return suma / 7;
    }

    void mostrarInfoEstudiante(){
        cout << fixed << setprecision(2);
        cout << "- "<< "Cedula: " << cedula << " |Nombre: "<< nombre << " |ID: "<<id
            <<" |Edad: "<<edad<< " |Promedio: " <<promedio() << endl;
    }
};

class RegistrarEstudiante{
    protected:
        //==> Declaramos una lista en la que se referencie.
        Estudiante* estudiantes; 
        int cantidadMaxima;
        int cantidadActual;
    
    public:
        RegistrarEstudiante(int cantidadMaxima){
            if(cantidadMaxima<=0){
                throw invalid_argument("La cantidad no puede ser negativa o 0.");
            }
            this->cantidadMaxima = cantidadMaxima;
            //==> Salta un error por no saber como crear un objeto Estudiante.
            this->estudiantes = new Estudiante[0];
            this->cantidadActual = 0;
        }

        //==> Devulve la cantidad elementos del array.
        int getCantidad(){
            return cantidadActual;
        }

        //==> Devuelve la capacidad maxima que puede alcanzar el array
        //    (El usuario define esto)
        int getCapacidad(){
            return cantidadMaxima;
        }

        bool estaLleno(){
            return cantidadMaxima == getCantidad();
        }

        bool estaVacio(){
            return 0 == getCantidad();
        }

        bool idEstaRepetido(int id){
            for(int i= 0; i < cantidadActual ; i++){
                if(id == estudiantes[i].getId()){
                    return true;
                }
            }
            return false;
        }

        bool cedulaEstaRepetida(string cedula){
            for(int i = 0; i < cantidadActual; i++){
                if(cedula == estudiantes[i].getCedula()){
                    return true;
                }
            }
            return false;
        }

        Estudiante* getEstudiantes(){
            return this->estudiantes;
        }

        void listar(){
            cout << "========ESTUDIANTES========" << endl;
            for(int i=0; i<getCantidad(); i++){
                estudiantes[i].mostrarInfoEstudiante();
            }
        }
        
        bool registrar(Estudiante* estudiante){
            if(estudiante == nullptr){
                return false;
            }

            if(getCantidad() == cantidadMaxima){
                cout << "El registro esta lleno con: "<< cantidadMaxima << " estudiantes." << endl;
                return false;
            }

            int nuevaCantidad = cantidadActual +1;
            Estudiante* nuevaLista = new Estudiante[nuevaCantidad];
            int j=0;
            for(int i = 0; i< nuevaCantidad-1; i++){
                nuevaLista[j++] = estudiantes[i];
            }
            nuevaLista[nuevaCantidad-1] = *estudiante;

            delete[] estudiantes;
            cantidadActual = nuevaCantidad;
            estudiantes =  nuevaLista;
            return true;
        }

        Estudiante* buscarEstudiante(int id){
            if(id <= 0){
                cout << "No existen IDs negativos o 0s." <<endl;
                return nullptr;
            }

            for(int i=0; i< getCantidad(); i++){
                if(id == estudiantes[i].getId()){
                    return &estudiantes[i];
                }
            }

            return nullptr;
        }

        // ==> NIVEL 2: obtener(int posicion)
        Estudiante* obtener(int posicion){
            if(posicion < 0 || posicion >= cantidadActual){
                cout << "Posicion fuera de rango." << endl;
                return nullptr;
            }
            return &estudiantes[posicion];
        }

        // ==> NIVEL 2: contarAprobados(double minimo)
        int contarAprobados(double minimo){
            int contador = 0;
            for(int i = 0; i < cantidadActual; i++){
                if(estudiantes[i].promedio() >= minimo){
                    contador++;
                }
            }
            return contador;
        }

        // ==> NIVEL 2: buscar por nombre sin distinguir mayusculas
        Estudiante* buscarPorNombre(string nombre){
            string nombreMin = nombre;
            transform(nombreMin.begin(), nombreMin.end(), nombreMin.begin(), ::tolower);

            for(int i = 0; i < cantidadActual; i++){
                string actual = estudiantes[i].getNombre();
                transform(actual.begin(), actual.end(), actual.begin(), ::tolower);
                if(actual == nombreMin){
                    return &estudiantes[i];
                }
            }
            return nullptr;
        }

        Estudiante* buscarPorCedula(string cedula){
            for(int i = 0; i < cantidadActual; i++){
                if(estudiantes[i].getCedula() == cedula){
                    return &estudiantes[i];
                }
            }
            return nullptr;
        }

        bool modificar(Estudiante* estudiante, string nuevoNombre, int nuevaEdad, double nuevasNotas[]){
            if(estudiante == nullptr){
                return false;
            }
            estudiante->setNombre(nuevoNombre);
            estudiante->setEdad(nuevaEdad);
            estudiante->setNotas(nuevasNotas);
            return true;
        }

        bool eliminar(int id){
            
            if(cantidadActual<=0){
                cout << "No hay estudiantes a eliminar." << endl;
                return false;
            }
            
            int index = 0;
            Estudiante* estudianteEncontrado = buscarEstudiante(id);
            if(estudianteEncontrado != nullptr){
                for(int i=0; i< getCantidad(); i++){
                    if(id == estudiantes[i].getId())
                        index = i;
                }

                int nuevaCantidad = cantidadActual - 1;
                Estudiante* nuevaLista = new Estudiante[nuevaCantidad];
                int j =0;
                for(int i=0; i< cantidadActual; i++){
                    if(i != index){
                        nuevaLista[j++] = estudiantes[i];
                    }
                }  


                delete[] estudiantes;
                estudiantes = nuevaLista;
                cantidadActual = nuevaCantidad;
                return true;

            }
            return false;
        }

        // ==> PROMEDIO GENERAL DEL CURSO
        double promedioGeneral(){
            if(estaVacio()){
                return 0;
            }
            double suma = 0;
            for(int i = 0; i < cantidadActual; i++){
                suma += estudiantes[i].promedio();
            }
            return suma / cantidadActual;
        }

        // ==> MEJOR PROMEDIO
        Estudiante* mejorPromedio(){
            if(estaVacio()){
                return nullptr;
            }
            Estudiante* mejor = &estudiantes[0];
            for(int i = 1; i < cantidadActual; i++){
                if(estudiantes[i].promedio() > mejor->promedio()){
                    mejor = &estudiantes[i];
                }
            }
            return mejor;
        }

        // ==> APROBADOS Y NO APROBADOS
        void mostrarAprobadosReprobados(double minimo){
            cout << endl;
            cout << "========APROBADOS (>= " << minimo << ")=========" << endl;
            for(int i = 0; i < cantidadActual; i++){
                if(estudiantes[i].promedio() >= minimo){
                    estudiantes[i].mostrarInfoEstudiante();
                }
            }

            cout << endl;
            cout << "========NO APROBADOS (< " << minimo << ")=========" << endl;
            for(int i = 0; i < cantidadActual; i++){
                if(estudiantes[i].promedio() < minimo){
                    estudiantes[i].mostrarInfoEstudiante();
                }
            }
        }
};

int main(){

    RegistrarEstudiante* curso = new RegistrarEstudiante(31);

    double n1[7]={8.5,8.5,8.5,8.5,8.5,8.5,8.5};   curso->registrar(new Estudiante("0000000001","Altamirano Segovia Jullisa Brigitte",20,1,n1));
    double n2[7]={7.8,7.8,7.8,7.8,7.8,7.8,7.8};   curso->registrar(new Estudiante("0000000002","Caguana Quishpe Lenin Josue",19,2,n2));
    double n3[7]={9.2,9.2,9.2,9.2,9.2,9.2,9.2};   curso->registrar(new Estudiante("0000000003","Caiza Caizabuano Jose Ruben",21,3,n3));
    double n4[7]={8.0,8.0,8.0,8.0,8.0,8.0,8.0};   curso->registrar(new Estudiante("0000000004","Camacho Monta Josue Jampier",20,4,n4));
    double n5[7]={7.5,7.5,7.5,7.5,7.5,7.5,7.5};   curso->registrar(new Estudiante("0000000005","Chalco Tasna Kenneth Mateo",22,5,n5));
    double n6[7]={9.6,9.6,9.6,9.6,9.6,9.6,9.6};   curso->registrar(new Estudiante("0000000006","Chico Yunda Juan Carlos",20,6,n6));
    double n7[7]={8.3,8.3,8.3,8.3,8.3,8.3,8.3};   curso->registrar(new Estudiante("0000000007","Cunalata Mendoza Damian Alexander",19,7,n7));
    double n8[7]={9.0,9.0,9.0,9.0,9.0,9.0,9.0};   curso->registrar(new Estudiante("0000000008","Espinoza Reyes Kerly Margoth",21,8,n8));
    double n9[7]={7.9,7.9,7.9,7.9,7.9,7.9,7.9};   curso->registrar(new Estudiante("0000000009","Gamboa Araujo Rommel Fabricio",20,9,n9));
    double n10[7]={8.7,8.7,8.7,8.7,8.7,8.7,8.7}; curso->registrar(new Estudiante("0000000010","Guamanquispe Guaman Edwin David",22,10,n10));
    double n11[7]={8.1,8.1,8.1,8.1,8.1,8.1,8.1}; curso->registrar(new Estudiante("0000000011","Ierra Mera Jose Ernesto",19,11,n11));
    double n12[7]={9.4,9.4,9.4,9.4,9.4,9.4,9.4}; curso->registrar(new Estudiante("0000000012","Jijon Viscaino Gabriel Sebastian",21,12,n12));
    double n13[7]={7.6,7.6,7.6,7.6,7.6,7.6,7.6}; curso->registrar(new Estudiante("0000000013","Llamuca Abrajan Andres Joel",20,13,n13));
    double n14[7]={8.8,8.8,8.8,8.8,8.8,8.8,8.8}; curso->registrar(new Estudiante("0000000014","Maigua Shigui Lenin Alexander",22,14,n14));
    double n15[7]={9.1,9.1,9.1,9.1,9.1,9.1,9.1}; curso->registrar(new Estudiante("0000000015","Manobanda Puaquiza Italo Esteban",19,15,n15));
    double n16[7]={8.4,8.4,8.4,8.4,8.4,8.4,8.4}; curso->registrar(new Estudiante("0000000016","Moyota Chavez Kleber Andres",20,16,n16));
    double n17[7]={7.7,7.7,7.7,7.7,7.7,7.7,7.7}; curso->registrar(new Estudiante("0000000017","Ortiz Yaucan Everly Oseas",21,17,n17));
    double n18[7]={9.3,9.3,9.3,9.3,9.3,9.3,9.3}; curso->registrar(new Estudiante("0000000018","Oto Cundulle Cristopher Raul",20,18,n18));
    double n19[7]={8.2,8.2,8.2,8.2,8.2,8.2,8.2}; curso->registrar(new Estudiante("0000000019","Romo Nuñez Joseph Alejandro",22,19,n19));
    double n20[7]={8.9,8.9,8.9,8.9,8.9,8.9,8.9}; curso->registrar(new Estudiante("0000000020","Silva Camuendo Luis Alexander",19,20,n20));
    double n21[7]={9.5,9.5,9.5,9.5,9.5,9.5,9.5}; curso->registrar(new Estudiante("0000000021","Tacuri Santillan Monica Sara",20,21,n21));
    double n22[7]={7.4,7.4,7.4,7.4,7.4,7.4,7.4}; curso->registrar(new Estudiante("0000000022","Tenorio Ronquillo Jonathan Sebastian",21,22,n22));
    double n23[7]={8.6,8.6,8.6,8.6,8.6,8.6,8.6}; curso->registrar(new Estudiante("0000000023","Tisalema Guashco Darwin Joel",19,23,n23));
    double n24[7]={9.0,9.0,9.0,9.0,9.0,9.0,9.0}; curso->registrar(new Estudiante("0000000024","Torosina Armendariz Jeremy Alejandro",22,24,n24));
    double n25[7]={7.8,7.8,7.8,7.8,7.8,7.8,7.8}; curso->registrar(new Estudiante("0000000025","Tuza Quinatoa Edith Noemi",20,25,n25));
    double n26[7]={8.5,8.5,8.5,8.5,8.5,8.5,8.5}; curso->registrar(new Estudiante("0000000026","Villacres Lopez Walter Fernando",21,26,n26));
    double n27[7]={9.2,9.2,9.2,9.2,9.2,9.2,9.2}; curso->registrar(new Estudiante("0000000027","Yanchatipan Moreta Shirley Micaela",19,27,n27));

    while(true){
        cout<<endl;
        cout << "========MENU=======" << endl;
        cout << "1.Registrar estudiante" << endl;
        cout << "2.Listar estudiantes" << endl;
        cout << "3.Buscar estudiante" << endl;
        cout << "4.Modificar estudiante" << endl;
        cout << "5.Eliminar estudiante" << endl;
        cout << "6.Mostrar numero de estudiantes registrados" << endl;
        cout << "7.Calcular promedio de un estudiante" << endl;
        cout << "8.Ver notas de un estudiante" << endl;
        cout << "9.Ver mejor promedio" << endl;
        cout << "10.Ver promedio general del curso" << endl;
        cout << "11.Ver aprobados y no aprobados" << endl;
        cout << "12.Obtener estudiante por posicion" << endl;
        cout << "13.Contar aprobados (nota minima)" << endl;
        cout << "14.Buscar estudiante por nombre" << endl;
        cout << "15.Buscar estudiante por cedula" << endl;
        cout << "0.Salir" << endl;
        cout << "Ingrese una opcion: ";
        int opcion;
        cin >> opcion ;
        cout << endl;

        switch (opcion)
        {
        case 1:{
            int id;
            bool repetido;
            bool cedulaRepetida;
            string cedula;
            string nombre;
            int edad;
            double notas[7];

            cout << "Ingrese nombre: ";
            cin >> nombre;
            cout << endl;

            do{
                cout << "Ingrese edad: ";
                cin >> edad;
                cout << endl;
                if(edad < 0){
                    cout << "La edad no puede ser negativa." << endl;
                }
            }while(edad < 0);

            for(int i = 0; i < 7; i++){
                do{
                    cout << "Ingrese nota " << (i+1) << ": ";
                    cin >> notas[i];
                    cout << endl;
                    if(notas[i] < 0){
                        cout << "La nota no puede ser negativa." << endl;
                    }
                }while(notas[i] < 0);
            }

            do{
                cedulaRepetida = false;
                cout << "Ingrese cedula: ";
                cin >> cedula;
                cout << endl;
                if(curso->cedulaEstaRepetida(cedula)){
                    cedulaRepetida = true;
                    cout << "La cedula ya esta en uso, pruebe otra." << endl;
                }
            }while(cedulaRepetida);

            do{
                repetido = false;
                cout << "Ingrese Id: ";
                cin >> id;
                cout << endl;
                if(curso->idEstaRepetido(id)){
                    repetido = true;
                    cout << "Este id ya esta en uso, pruebe otro." << endl;
                }else{
                    repetido = false;
                }
            }while(repetido);

            if(curso->registrar(new Estudiante(cedula,nombre,edad,id,notas))){
                cout << "Estudiante registrado."<<endl;
            }else{
                cout << "No se pudo registrar estudiante." <<endl;
            }
            break;
        }
        
        case 2:{
            curso->listar();
            break;
        }
        case 3:{
            int idBuscar;
            Estudiante* encontrado;

            cout << "Ingrese ID del estudiante: ";
            cin >> idBuscar;
            cout << endl;
            encontrado = curso->buscarEstudiante(idBuscar);
            if(encontrado != nullptr){
                encontrado->mostrarInfoEstudiante();
                cout << endl;
            }else{
                cout << "Estudiante no se encuentra en la lista." << endl;
            }

            break;
        }

        case 4:{
            Estudiante* encontrado2;
            int idMod;
            string nuevoNombre;
            int nuevaEdad;
            double nuevasNotas[7];

            cout << "Ingrese ID del estudiante a modificar: ";
            cin >> idMod;
            cout << endl;
            encontrado2 = curso->buscarEstudiante(idMod);
            if(encontrado2==nullptr){
                cout << "Estudiante no encontrado" << endl;
                break;
            }

            cout << "Ingrese nuevo nombre:";
            cin >> nuevoNombre;
            cout << endl;

            do{
                cout << "Ingrese nueva edad: ";
                cin >> nuevaEdad;
                cout << endl;
                if(nuevaEdad < 0){
                    cout << "La edad no puede ser negativa." << endl;
                }
            }while(nuevaEdad < 0);

            for(int i = 0; i < 7; i++){
                do{
                    cout << "Ingrese nota " << (i+1) << ": ";
                    cin >> nuevasNotas[i];
                    cout << endl;
                    if(nuevasNotas[i] < 0){
                        cout << "La nota no puede ser negativa." << endl;
                    }
                }while(nuevasNotas[i] < 0);
            }

            curso->modificar(encontrado2, nuevoNombre, nuevaEdad, nuevasNotas);

            break;
        }    
        
        case 5:{
            int idElim;
            cout << "Ingrse ID del estudiante a eliminar: ";
            cin >> idElim;
            cout << endl;

            if(curso->eliminar(idElim)){
                cout << "Estudiante eliminado."<<endl;
            }else{
                cout << "Estudiante no encontrado." << endl;
            }
            break;
        }

        case 6:{
            cout << "Se han registrado "<< curso->getCantidad() << " estudiantes en el curso." << endl;
            break;
        }

        case 7:{
            int idProm;
            cout << "Ingrese ID del estudiante: ";
            cin >> idProm;
            cout << endl;
            Estudiante* paraPromedio = curso->buscarEstudiante(idProm);
            if(paraPromedio != nullptr){
                cout << fixed << setprecision(2);
                cout << "Promedio de " << paraPromedio->getNombre() << ": " << paraPromedio->promedio() << endl;
            }
            break;
        }

        case 8:{
            int idNotas;
            cout << "Ingrese ID del estudiante: ";
            cin >> idNotas;
            cout << endl;
            Estudiante* paraNotas = curso->buscarEstudiante(idNotas);
            if(paraNotas != nullptr){
                cout << "Notas de " << paraNotas->getNombre() << ":" << endl;
                double* notasEst = paraNotas->getNotas();
                cout << fixed << setprecision(2);
                for(int i = 0; i < 7; i++){
                    cout << "  Nota " << (i+1) << ": " << notasEst[i] << endl;
                }
            }
            break;
        }

        case 9:{
            Estudiante* mejor = curso->mejorPromedio();
            if(mejor != nullptr){
                cout << "Mejor promedio: ";
                mejor->mostrarInfoEstudiante();
            }else{
                cout << "No hay estudiantes registrados." << endl;
            }
            break;
        }

        case 10:{
            cout << fixed << setprecision(2);
            cout << "Promedio general del curso: " << curso->promedioGeneral() << endl;
            break;
        }

        case 11:{
            curso->mostrarAprobadosReprobados(7.0);
            break;
        }

        case 12:{
            int posicion;
            cout << "Ingrese posicion: ";
            cin >> posicion;
            cout << endl;
            Estudiante* enPosicion = curso->obtener(posicion);
            if(enPosicion != nullptr){
                enPosicion->mostrarInfoEstudiante();
            }
            break;
        }

        case 13:{
            double minimo;
            cout << "Ingrese nota minima: ";
            cin >> minimo;
            cout << endl;
            cout << "Aprobados: " << curso->contarAprobados(minimo) << endl;
            break;
        }

        case 14:{
            string nombreBuscar;
            cout << "Ingrese nombre: ";
            cin >> nombreBuscar;
            cout << endl;
            Estudiante* porNombre = curso->buscarPorNombre(nombreBuscar);
            if(porNombre != nullptr){
                porNombre->mostrarInfoEstudiante();
            }else{
                cout << "Estudiante no encontrado." << endl;
            }
            break;
        }

        case 15:{
            string cedulaBuscar;
            cout << "Ingrese cedula: ";
            cin >> cedulaBuscar;
            cout << endl;
            Estudiante* porCedula = curso->buscarPorCedula(cedulaBuscar);
            if(porCedula != nullptr){
                porCedula->mostrarInfoEstudiante();
            }else{
                cout << "Estudiante no encontrado." << endl;
            }
            break;
        }

        case 0:
            cout << "Hasta luego..." << endl;
            exit(0);
            break;

        default:
            cout << "Opcion invalida." << endl;
            break;
        }
    }

    return 0;
}
