package lecturaArchivos2;

// Fig. 14.11: LeerArchivoTexto.java
// Este programa lee un archivo de texto y muestra cada registro.

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LeerArchivoTexto {

    private Scanner entrada;

    // permite al usuario abrir el archivo
    public void abrirArchivo(String elemento) {
        try {
            entrada = new Scanner(new File(elemento));
        } // fin de try
        catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error al abrir el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del m�todo abrirArchivo

    // lee registro del archivo
    
    public ArrayList<Profesor> leer_Registro1() {

      
        ArrayList<Profesor> lista = new ArrayList<>();

        try // lee registros del archivo, usando el objeto Scanner
        {
            entrada.nextLine();
            while (entrada.hasNext()) {
                // se crea el objeto para leer Json
                Gson g = new Gson();
                String linea = entrada.nextLine();
                // se hace el proceso de transformación
                Profesor p = g.fromJson(linea, Profesor.class);
                lista.add(p);
                //System.out.println(p);

            } // fin de while

        } // fin de try
        catch (NoSuchElementException elementException) {
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } // fin de catch
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
        return lista;
    } // fin del m�todo leerRegistros
    // cierra el archivo y termina la aplicaci�n

    
    public ArrayList<Profesor> leer_Registro2() {
        ArrayList<Profesor> lis = new ArrayList<>();
        try{
            String linea = entrada.nextLine();
            while (entrada.hasNext()) {
                linea = entrada.nextLine();
                // Hacemos un split al ArrayList
                ArrayList<String> dato = new ArrayList<String>(Arrays.asList(linea.split(",")));
                Profesor pr = new Profesor();        
                pr.setCedula(dato.get(0));   
                pr.setNombres(dato.get(1));
                pr.setZona(dato.get(2));
                pr.setProvincia(dato.get(3));
                pr.setCanton(dato.get(4));
                pr.setPersonalidad(dato.get(5));
                pr.setRazonamiento(dato.get(6));
                pr.setDictamenIdoniedad(dato.get(7));
                // Agregamos cada objeto en el ArrayList
                lis.add(pr);
            } 
        }
        catch (NoSuchElementException elementException) {           
            System.err.println("El archivo no esta bien formado.");
            entrada.close();
            System.exit(1);
        } 
        catch (IllegalStateException stateException) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } 
        return lis;
        
    }
    
    
    
       
    public void escribir(ArrayList<Profesor> lista) throws IOException {
        String ubi = "data/data3.txt";
        File archivo = new File(ubi);
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        BufferedWriter aux = null;
        String pres = "";
        try {
            // Se escribe el archivo
            aux = new BufferedWriter(new FileWriter(archivo));
            aux.write("El fichero ya esta creado");
            aux = new BufferedWriter(new FileWriter(archivo));
           
            for (int i = 0; i < lista.size(); i++) {
                Profesor prof = lista.get(i);
                pres = String.format("%s ; %s ; %s ; %s ; %s ; %s ; %s ; %s \n",
                        prof.getCedula(), prof.getNombres(), prof.getZona(), prof.getProvincia(), prof.getCanton(),
                        prof.getPersonalidad(), prof.getRazonamiento(), prof.getDictamenIdoniedad());
               
                aux.write(pres);
            }
            
            aux.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        

    }
    
    
    
    public void cerrarArchivo() {
        if (entrada != null) {
            entrada.close(); // cierra el archivo
        }
    } // fin del m�todo cerrarArchivo
} // fin de la clase LeerArchivoTexto

/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigaci�n y prueba de las teor�as y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garant�a de      *
 * ning�n tipo, expresa o impl�cita, en relaci�n con estos programas o    *
 * con la documentaci�n contenida en estos libros. Los autores y el       *
 * editor no ser�n responsables en ning�n caso por los da�os consecuentes *
 * en conexi�n con, o que surjan de, el suministro, desempe�o o uso de    *
 * estos programas.                                                       *
 *************************************************************************/
