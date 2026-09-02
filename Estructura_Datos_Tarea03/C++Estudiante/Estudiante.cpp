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
        cout << "- " << "Nombre: "<< nombre << " |ID: "<<id
            <<" |Edad: "<<edad<< " |Promedio: " <<promedio << endl;
    }
};