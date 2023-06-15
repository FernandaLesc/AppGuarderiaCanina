package com.mycompany.interfazguarderia.logica;
import com.mycompany.interfazguarderia.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {  //clase controladora de los objetos dueño y mascotas

    ControladoraPersistencia controladoraPersis = new ControladoraPersistencia();//instancia de llamado de la controladora de la lógica hacia la persistencia
    public List<Mascotas> traerMascotas;

 

    public void guardar(String nombreMascota, String raza,
            String color, String observaciones, String alergico, String atencionEsp,
            String nombreDuenio, String celular) {
        
        Duenio duenio = new Duenio();  //instancia dueño y sus valores
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celular);
        
        Mascotas mascot = new Mascotas(); //instancia mascota y sus valores
        mascot.setNombreMascota(nombreMascota);
        mascot.setRaza(raza);
        mascot.setColor(color);
        mascot.setAlergico(alergico);
        mascot.setAtencionEspecial(atencionEsp);
        mascot.setObservaciones(observaciones);
        mascot.setUnDuenio(duenio); //asocio un dueño a esa mascota. Ya esta mapeado
        
        //llamar a la persistencia desde la logica
        controladoraPersis.guardar(duenio, mascot);  //guardamos las intancias en la base de datos

    }

    public List<Mascotas> traerMascotas() {
       return controladoraPersis.traerMascotas(); //hago la conexion de la controladora de la logica con la controladora de bd
    }

    public void borrarDato(int num_cliente) {
        controladoraPersis.borrarDato(num_cliente);
    }

    public Mascotas traerMascotas(int num_cliente) {
        return controladoraPersis.traerMascotas(num_cliente);
    }

    public void modificarDatos(Mascotas mascot, String nombreMascota, String raza, String color, String observaciones, String alergico, String atencionEsp, String nombreDuenio, String celular) {
        //caracteristicas mascotas
        mascot.setNombreMascota(nombreMascota);
        mascot.setRaza(raza);
        mascot.setColor(color);
        mascot.setObservaciones(observaciones);
        mascot.setAlergico(alergico);
        mascot.setAtencionEspecial(atencionEsp);
        //modifico la mascota
        controladoraPersis.modificarDatos(mascot);
        //seteo nuevos valores del dueño
        Duenio duenio = this.buscarDuenio(mascot.getUnDuenio().getId_duenio());
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celular);
        //llamo a la clase de modificar para cambiar datos del dueño
        this.modificarDuenio(duenio);
       
    }   

    private Duenio buscarDuenio(int id_duenio) {
        return controladoraPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controladoraPersis.modificarDuenio(duenio);
    }
    
}
