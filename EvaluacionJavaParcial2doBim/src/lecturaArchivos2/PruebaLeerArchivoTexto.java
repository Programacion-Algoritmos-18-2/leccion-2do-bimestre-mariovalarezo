package lecturaArchivos2;

// Fig. 14.12: PruebaLeerArchivoTexto.java
import java.util.ArrayList;

public class PruebaLeerArchivoTexto {

    public static void main(String args[]) {
        LeerArchivoTexto aplicacion = new LeerArchivoTexto();
        OperacionData operacion = new OperacionData();
         
        aplicacion.abrirArchivo("data/data1.csv");
        ArrayList<Profesor> lista2 = aplicacion.leer_Registro2();
        aplicacion.abrirArchivo("data/data2.txt");
        ArrayList<Profesor> lista1 = aplicacion.leer_Registro1();
        ArrayList<Profesor> lista3 = new ArrayList<>();
        for (int i = 0; i < lista2.size(); i++) {
            lista3.add(lista2.get(i));
        }
        
        for (int i = 0; i < lista1.size(); i++) {
            lista3.add(lista1.get(i));
        }
        
        operacion.agregarInformacion(lista3);
        // operacion.lecturaData();

        operacion.ordenarPorCanton();
        System.out.println("Numeros -----------------------------------------------");
        operacion.numero_per();
        operacion.numero_ido();
        
        ArrayList<Profesor> lista4 = operacion.ordenarPorNombres();
        aplicacion.escribir(lista4);
   
        // System.out.println("-------");
        // operacion.lecturaData();
        aplicacion.cerrarArchivo();
    } // fin de main
} // fin de la clase PruebaLeerArchivoTexto

