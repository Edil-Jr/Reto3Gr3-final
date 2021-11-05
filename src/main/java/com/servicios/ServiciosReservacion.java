
package com.servicios;

import com.modelo.Reservacion;
import com.repositorio.ContadorClientes;
import com.repositorio.RepositorioReservacion;
import com.repositorio.StatusReservas;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author EDILBERTO HOLGUIN URREGO
 * UNIVERSIDAD SERGIO ARBOLEDA
 */
@Service
public class ServiciosReservacion {
    /**
     * ANotacion para autoescritura
     **/
     @Autowired
    private RepositorioReservacion metodosCrud;
     /**
     * Creamos el metodo obteber todo y le enviamos una lista del 
     * objeto reservacion
     **/
    public List<Reservacion> getAll(){
        return metodosCrud.getAll();
    }
     /**
     * Metodo Opcional para omitir el nulo
     **/
    public Optional<Reservacion> getReservation(int reservationId) {
        return metodosCrud.getReservacion(reservationId);
    }
     /**
     * Metodo para guardar 
     *
     **/
    public Reservacion save(Reservacion reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservacion> e= metodosCrud.getReservacion(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
     /**
     * Metodo para actualizar
     * 
     **/
    public Reservacion update(Reservacion reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservacion> e= metodosCrud.getReservacion(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
     /**
     * Creamos el metodo para consumir la api delete
     * objeto reservacion
     **/
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    /**
     * Creamos los metodos para obtener los servicios
     */
    public StatusReservas reporteStatusServicio (){
        List<Reservacion>completed= metodosCrud.ReservacionStatusRepositorio("completed");
        List<Reservacion>cancelled= metodosCrud.ReservacionStatusRepositorio("cancelled");
        
        return new StatusReservas(completed.size(), cancelled.size() );
    }
     /**
     * Creamos los metodos para obtener reporte tiempo de servicio
     */
    
    public List<Reservacion> reporteTiempoServicio (String datoA, String datoB){
        SimpleDateFormat parser = new SimpleDateFormat ("yyyy-MM-dd");
        
        Date datoUno = new Date();
        Date datoDos = new Date();
        
        try{
             datoUno = parser.parse(datoA);
             datoDos = parser.parse(datoB);
        }catch(ParseException evt){
            evt.printStackTrace();
        }if(datoUno.before(datoDos)){
            return metodosCrud.ReservacionTiempoRepositorio(datoUno, datoDos);
        }else{
            return new ArrayList<>();
        
        } 
    }
         /**
     * Creamos los metodos para obtener los servicios contador
     */
        public List<ContadorClientes> reporteClientesServicio(){
            return metodosCrud.getClientesRepositorio();
        }
    
}