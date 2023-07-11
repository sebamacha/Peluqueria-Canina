
package peluqueriacanina.persistencia;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.List;
import peluqueriacanina.logica.Duenio;
import peluqueriacanina.logica.Mascota;
import peluqueriacanina.persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    
    DuenioJpaController dueniojpa = new DuenioJpaController();
    MascotaJpaController mascojpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
        //llamar al duenio primero despues la mascota, para crear en la DB
        dueniojpa.create(duenio);
        mascojpa.create(masco);
    }

    public List<Mascota> traerMacostas() {
        
        return mascojpa.findMascotaEntities();
    }

    public void borrarMascota(int num_cliente) {
        try {
              mascojpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }

    public Mascota traerMascosta(int num_cliente) {
       return mascojpa.findMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco) {
        try {
            mascojpa.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerduenio(int id_duenio) {
       return dueniojpa.findDuenio(id_duenio);
    
}

    public void modificarDuenio(Duenio dueno) {
        try {
            dueniojpa.edit(dueno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}