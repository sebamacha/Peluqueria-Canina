
package peluqueriacanina.logica;

import java.util.List;
import peluqueriacanina.persistencia.ControladoraPersistencia;


public class Controladora {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String nombreduenio, String telefono, String alergico, String atenEsp) {
        //metodo creado al cargar el botor guardar por lo tanto creamos un nuebo dueño y mascota y seteamos los valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreduenio);
        duenio.setTelefono(telefono);
        //creamos la mascota y asignamos o seteamos valores
        
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        masco.setObservaciones(observaciones);
        masco.setUnDuenio(duenio);
        
        //llamar a la controladora de persistencia para que guarde los datos en la base de datos
        controlPersis.guardar(duenio,masco);
        
        
        
        
    }

    public List<Mascota> traerMascotas() {
     
        return controlPersis.traerMacostas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

   

    public Mascota traerMascota(int num_cliente) {
       return controlPersis.traerMascosta(num_cliente);
    }

    public void modificarMasco(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String alergico, String atenEsp, String nombreduenio, String telefono) {
       masco.setNombre(nombreMasco);
       masco.setRaza(raza);
       masco.setColor(color);
       masco.setObservaciones(observaciones);
       masco.setAlergico(alergico);
       masco.setAtencion_especial(atenEsp);
       //envio los datos nuevos de la mascota
       controlPersis.modificarMascota(masco);
       //seteo los nuevos valores del dueño
       Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
       dueno.setNombre(nombreduenio);
       dueno.setTelefono(telefono);
       //llamar al modificar dueño con un mthedo modiciar dueño
       this.modificarDuenio(dueno);
       
    }

    private Duenio buscarDuenio(int id_duenio) {
        return  controlPersis.traerduenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
       controlPersis.modificarDuenio(dueno);
    }


   
    
}
