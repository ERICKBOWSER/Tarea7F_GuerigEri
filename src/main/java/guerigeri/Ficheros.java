/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerigeri;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author guerig
 */
public class Ficheros {
    public static List<Empleado> leerFicheroCSV(String nombre){

        List<Empleado> empLista = new ArrayList();
        
        String[] tokens;
        String linea;
        
        try (Scanner datosFichero = new Scanner(new File(nombre), "ISO-8859-1")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                tokens = linea.split(",");  
                Empleado empleado = new Empleado(); // Creamos un nuevo empleado por cada vez que se repite el bucle
                
                for (int i = 0; i < tokens.length; i++) {
                    tokens[i] = tokens[i].replaceAll("\"", ""); // Donde haya comillas lo reemplaza por nada
                }
                
                empleado.setApellidos(tokens[0]);
                empleado.setNombre(tokens[1]);
                empleado.setDni(tokens[2]);
                empleado.setPuesto(tokens[3]);
                
                if(tokens[4].equalsIgnoreCase("")){
                    empleado.setFechaPosesion(null);
                }else{
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formato para la fecha
                    LocalDate fecha = LocalDate.parse(tokens[4], formato);

                    empleado.setFechaPosesion(fecha);                    
                }
                
                if(tokens[5].equalsIgnoreCase("")){
                    empleado.setFechaCese(null);
                }else{
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate fecha = LocalDate.parse(tokens[5], formato);
                    
                    empleado.setFechaCese(fecha);
                }
                
                empleado.setTelefono(tokens[6]); // Si telefono es de tipo int da error aunque se parsee
                empleado.setEvaluador(tokens[7]);
                empleado.setCoordinador(tokens[8]);
                
                // Añadimos los empleados
                empLista.add(empleado);                
                
            }

            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        return empLista;
    }
}
