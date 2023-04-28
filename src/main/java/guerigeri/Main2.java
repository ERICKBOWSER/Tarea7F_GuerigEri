/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerigeri;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ERICK
 */
public class Main2 {
    public static void main(String[] args) throws IOException {
        List<Empleado> lista = new ArrayList();
        
        lista = Ficheros.leerFicheroCSV("RelPerCen.csv");
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        
        // Fichero JSON de los empleados con tiempo de trabajo entre 10 y 15 años
        FicheroJSON.generarFichero(lista, "empleados.json"); // Hay que colocar la excepción en la clase
        
        int contador = 0;
        
        for (Empleado empleado : lista) {
            if(empleado.getPuesto().contains("Tecnología")){
                contador++;
            }
        }
        System.out.println("Contador sin Stream: " + contador);
        
        System.out.println("Empleados de informática que son coordinadores: ");
        for (Empleado empleado : lista) {
            if(empleado.getPuesto().contains("Informática") &&
                    empleado.getCoordinador().contains("Sí")){
                System.out.println(empleado);
            }
        }
        
        List<Empleado> listaApellidos = new ArrayList();
        for (Empleado empleado : lista) {
            if(empleado.getApellidos().contains("J")){
                listaApellidos.add(empleado);
            }
        }
        
        listaApellidos.sort((e1, e2) -> e1.getDni().compareTo(e2.getDni()));
        
        System.out.println("Emplados con la letra J en el DNI: ");
        listaApellidos.forEach(System.out :: println);
        
        
        System.out.println("Empleados sin nombre Jonh: ");
        List<Empleado> listaNombre = new ArrayList();
        for (Empleado empleado : lista) {
            if(!empleado.getNombre().contains("Jonh")){
                listaNombre.add(empleado);
                System.out.println(empleado);
            }
        }
        
        // ---------- STREAM -------------------
        
        long contadorStream = lista.stream()
                .filter(e1 -> e1.getPuesto().contains("Tecnología"))
                .count();
        
        System.out.println("Contador stream: " + contadorStream);
        
        System.out.println("Empleados de informática que son coordinadores");
        lista.stream()
                .filter(e1 -> e1.getPuesto().contains("Informática"))
                .filter(e1 -> e1.getCoordinador().contains("Sí"))
                .forEach(System.out :: println);
        
        System.out.println("Lista ordenada de los empleados cuyo dni empieza por J");
        lista.stream()
                .filter(e1 -> e1.getDni().contains("J"))
                .sorted((e1, e2) -> e1.getApellidos().compareTo(e2.getApellidos()))
                .forEach(System.out :: println);
        
        System.out.println("Lista con nombres que no contienen el nombre Jonh");
        lista.stream()
                .filter(e1 -> e1.getNombre().contains("Jonh"))
                .distinct()
                .forEach(System.out :: println);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}
