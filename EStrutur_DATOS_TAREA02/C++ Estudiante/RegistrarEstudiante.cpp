#include <iterator>
#include <iostream>
#include <string>
using namespace std;

class Estudiante{
    protected:

        string nombre;
        int edad;
        int id;
        double promedio;

    public:

    //==> Inicializamos el objeto por default para definir el arreglo.
    Estudiante(){
        nombre = "";
        edad= 0;
        id = 0;
        promedio = 0.0;
    }

    Estudiante(string nombre, int edad, int id, double promedio){
        this->nombre = nombre;
        this->edad = edad;
        this-> id = id;
        this-> promedio = promedio;
    }

    int getEdad(){
        return edad;
    }

    string getNombre(){
        return nombre;
    }

    double getPromedio(){
        return promedio;
    }

    int getId(){
        return id;
    }

    void setEdad(int nuevaEdad){
        edad = nuevaEdad;
    }

    void setNombre(string nuevoNombre){
        nombre = nuevoNombre;
    }

    void setPromedio(double nuevoPromedio){
        promedio = nuevoPromedio;
    }

    void mostrarInfoEstudiante(){
        cout << "- "<< "Nombre: "<< nombre << " |ID: "<<id
            <<" |Edad: "<<edad<< " |Promedio: " <<promedio << endl;
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

        Estudiante* getEstudiantes(){
            return this->estudiantes;
        }

        // ==> AQUI SE IMPLEMENTA READ
        void listar(){
            cout << "========ESTUDIANTES========" << endl;
            for(int i=0; i<getCantidad(); i++){
                estudiantes[i].mostrarInfoEstudiante();
            }
        }
        
        // ==> AQUI SE IMPLEMENTA CREATE
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

        // ==> AQUI SE IMPLEMENTA UPDATE
        bool modificar(Estudiante* estudiante, string nuevoNombre, int nuevaEdad, double nuevoPromedio){
            if(estudiante == nullptr){
                return false;
            }
            estudiante->setNombre(nuevoNombre);
            estudiante->setEdad(nuevaEdad);
            estudiante->setPromedio(nuevoPromedio);
            return true;
        }

        // ==> AQUI SE IMPLEMENTA DELETE
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
};

int main(){

    RegistrarEstudiante* curso = new RegistrarEstudiante(31);

    curso->registrar(new Estudiante("Altamirano Segovia Jullisa Brigitte", 20, 1, 8.5));
    curso->registrar(new Estudiante("Caguana Quishpe Lenin Josue", 19, 2, 7.8));
    curso->registrar(new Estudiante("Caiza Caizabuano Jose Ruben", 21, 3, 9.2));
    curso->registrar(new Estudiante("Camacho Monta Josue Jampier", 20, 4, 8.0));
    curso->registrar(new Estudiante("Chalco Tasna Kenneth Mateo", 22, 5, 7.5));
    curso->registrar(new Estudiante("Chico Yunda Juan Carlos", 20, 6, 9.6));
    curso->registrar(new Estudiante("Cunalata Mendoza Damian Alexander", 19, 7, 8.3));
    curso->registrar(new Estudiante("Espinoza Reyes Kerly Margoth", 21, 8, 9.0));
    curso->registrar(new Estudiante("Gamboa Araujo Rommel Fabricio", 20, 9, 7.9));
    curso->registrar(new Estudiante("Guamanquispe Guaman Edwin David", 22, 10, 8.7));
    curso->registrar(new Estudiante("Ierra Mera Jose Ernesto", 19, 11, 8.1));
    curso->registrar(new Estudiante("Jijon Viscaino Gabriel Sebastian", 21, 12, 9.4));
    curso->registrar(new Estudiante("Llamuca Abrajan Andres Joel", 20, 13, 7.6));
    curso->registrar(new Estudiante("Maigua Shigui Lenin Alexander", 22, 14, 8.8));
    curso->registrar(new Estudiante("Manobanda Puaquiza Italo Esteban", 19, 15, 9.1));
    curso->registrar(new Estudiante("Moyota Chavez Kleber Andres", 20, 16, 8.4));
    curso->registrar(new Estudiante("Ortiz Yaucan Everly Oseas", 21, 17, 7.7));
    curso->registrar(new Estudiante("Oto Cundulle Cristopher Raul", 20, 18, 9.3));
    curso->registrar(new Estudiante("Romo Nuñez Joseph Alejandro", 22, 19, 8.2));
    curso->registrar(new Estudiante("Silva Camuendo Luis Alexander", 19, 20, 8.9));
    curso->registrar(new Estudiante("Tacuri Santillan Monica Sara", 20, 21, 9.5));
    curso->registrar(new Estudiante("Tenorio Ronquillo Jonathan Sebastian", 21, 22, 7.4));
    curso->registrar(new Estudiante("Tisalema Guashco Darwin Joel", 19, 23, 8.6));
    curso->registrar(new Estudiante("Torosina Armendariz Jeremy Alejandro", 22, 24, 9.0));
    curso->registrar(new Estudiante("Tuza Quinatoa Edith Noemi", 20, 25, 7.8));
    curso->registrar(new Estudiante("Villacres Lopez Walter Fernando", 21, 26, 8.5));
    curso->registrar(new Estudiante("Yanchatipan Moreta Shirley Micaela", 19, 27, 9.2));

    while(true){
        cout<<endl;
        cout << "========MENU=======" << endl;
        cout << "1.Registrar estudiante" << endl;
        cout << "2.Listar estudiantes" << endl;
        cout << "3.Buscar estudiante" << endl;
        cout << "4.Modificar estudiante" << endl;
        cout << "5.Eliminar estudiante" << endl;
        cout << "6.Mostrar numero de estudiantes registrados" << endl;
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
            string nombre;
            int edad;
            double promedio;
            cout << "Ingrese nombre: ";
            cin >> nombre;
            cout << endl;

            cout << "Ingrese edad: ";
            cin >> edad;
            cout << endl;

            cout << "Ingrese promedio: ";
            cin >> promedio;
            cout << endl;

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

            if(curso->registrar(new Estudiante(nombre,edad,id,promedio))){
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
            double nuevoPromedio;

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

            cout << "Ingrese nueva edad: ";
            cin >> nuevaEdad;
            cout << endl;

            cout << "Ingrese nuevo promedio: ";
            cin >> nuevoPromedio;
            cout << endl;

            curso->modificar(encontrado2, nuevoNombre, nuevaEdad, nuevoPromedio);

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