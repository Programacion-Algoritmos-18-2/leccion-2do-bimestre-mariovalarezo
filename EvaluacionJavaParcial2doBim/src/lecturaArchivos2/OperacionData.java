/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecturaArchivos2;

import java.util.ArrayList;
import java.util.Collections;


/**
 *
 * @author reroes
 */
public class OperacionData {
    

    ArrayList<Profesor> informacion = new ArrayList<>();

    public void agregarInformacion(ArrayList<Profesor> info) {
        informacion = new ArrayList<Profesor>(info.subList(1, 4));
    }

    public ArrayList<Profesor> obtenerInformacion() {
        return informacion;
    }

  
    
    // proceso de ordenar, a través del uso de Collections
    public void ordenarPorCanton(){
        ArrayList<Profesor> dataPorCantones = new ArrayList<>();
        dataPorCantones.addAll(informacion);
        Collections.sort(dataPorCantones, 
                        (o1, o2) -> o1.canton.compareTo(o2.canton));
        for (int i = 0; i < dataPorCantones.size(); i++) {
            System.out.println(dataPorCantones.get(i));
        }
    }
    
    public ArrayList<Profesor> ordenarPorNombres(){
        ArrayList<Profesor> dataPorNombres = new ArrayList<>();
        dataPorNombres.addAll(informacion);
        Collections.sort(dataPorNombres, 
                        (o1, o2) -> o1.nombres.compareTo(o2.nombres));
        return dataPorNombres;
        
    }
    
    
    public void numero_per() {
        int cont1 = 0;
        int cont2 = 0;
        for (int i = 0; i < this.informacion.size(); i++) {
            if (this.informacion.get(i).getPersonalidad().equals("ADECUADO")) {
                cont1 = cont1 + 1;
            } else if (this.informacion.get(i).getPersonalidad().equals("POR CONVOCAR")) {
                cont2 = cont2 + 1;
            }
        }
        
        System.out.println("El numero de adecuados es:" +cont1);
        System.out.println("El numero de por convocar es:" +cont2);
        
        
    }
    
    public void numero_ido() {
        int cont1 = 0;
        int cont2 = 0;
        for (int i = 0; i < this.informacion.size(); i++) {
            if (this.informacion.get(i).getDictamenIdoniedad().equals("IDONEO")) {
                cont1 = cont1 + 1;
            } else if (this.informacion.get(i).getDictamenIdoniedad().equals("NO IDONEO")) {
                cont2 = cont2 + 1;
            }
        }
        System.out.println("El numero de idoneo es:" +cont1);
        System.out.println("El numero de no idoneo es:" +cont2);
    }
    
    
    
    
    
    public void lecturaData() {
        for (int i = 0; i<obtenerInformacion().size(); i++) {
            System.out.println(obtenerInformacion().get(i));
            
        }
        
    }

}
