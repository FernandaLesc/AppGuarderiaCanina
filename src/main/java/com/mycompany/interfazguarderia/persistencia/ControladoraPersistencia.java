package com.mycompany.interfazguarderia.persistencia;
import com.mycompany.interfazguarderia.logica.Duenio;
import com.mycompany.interfazguarderia.logica.Mascotas;
import com.mycompany.interfazguarderia.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {  //clase controladora de la persistencia

    DuenioJpaController duenioJpa = new DuenioJpaController();     
    MascotasJpaController mascotasJpa = new MascotasJpaController();
    
    public void guardar(Duenio duenio, Mascotas mascot) {
        duenioJpa.create(duenio); //creo en la base de datos el objeto duenio
        mascotasJpa.create(mascot); //creo en la bd el objeto mascotas
    }

    public List<Mascotas> traerMascotas() {
        return mascotasJpa.findMascotasEntities(); //busca todos los registros de la tabla de mascotas y lo devuelve a la logica
    }

    public void borrarDato(int num_cliente) {
        try {
            mascotasJpa.destroy(num_cliente);  //elimino el dato seleccionado por el usuario desde la bd
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Mascotas traerMascotas(int num_cliente) {
        return mascotasJpa.findMascotas(num_cliente);
    }

    public void modificarDatos(Mascotas mascot) {
        try {
            mascotasJpa.edit(mascot);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio duenio) {
        try {
            duenioJpa.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}