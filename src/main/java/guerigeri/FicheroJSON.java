/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guerigeri;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ERICK
 */
public class FicheroJSON{
    public static void generarFichero(List<Empleado> lista, String nombre) throws IOException{ // Pillar excepción
        
        
        ObjectMapper mapeador = new ObjectMapper();
        
        // minusYears() devuelve una fecha aumentandole los años que se ponga
        // isAfter() comprueba si la fecha es después de la especificada
        // isBefore() comprueba si la fecha es antes de la especificada
        
        lista.stream()
                .filter(l -> l.getFechaPosesion().isBefore(LocalDate.now().minusYears(10)))
                .filter(l -> l.getFechaPosesion().isAfter(LocalDate.now().minusYears(15)));
                
//        listaVehiculosCopia.stream()
//                .filter( v -> v.isDisponible())
//                .map(v -> v.getMarca())
//                .distinct()
//                .forEach(System.out :: println);
        
        
        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());
        
        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        // Escribe en un fichero JSON 
        mapeador.writeValue(new File("empleados.json"), lista);
                
    }
}
