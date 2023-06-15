package com.mycompany.interfazguarderia.logica;

import com.mycompany.interfazguarderia.logica.Duenio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2023-06-07T20:21:41")
@StaticMetamodel(Mascotas.class)
public class Mascotas_ { 

    public static volatile SingularAttribute<Mascotas, Integer> num_cliente;
    public static volatile SingularAttribute<Mascotas, String> raza;
    public static volatile SingularAttribute<Mascotas, String> color;
    public static volatile SingularAttribute<Mascotas, String> nombreMascota;
    public static volatile SingularAttribute<Mascotas, String> alergico;
    public static volatile SingularAttribute<Mascotas, String> observaciones;
    public static volatile SingularAttribute<Mascotas, Duenio> unDuenio;
    public static volatile SingularAttribute<Mascotas, String> atencionEspecial;

}