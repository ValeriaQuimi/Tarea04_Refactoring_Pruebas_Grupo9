package com.example.usuarios_y_roles;

import com.example.turismo_y_paseos.PaseoTuristico;

public class Administrador extends Usuario{

    public Administrador(int id, String nombre, String correoStr) {
    super(id, nombre, new Email(correoStr));
}
    
    public void configurarPoliticas(){}

    public void  ajustarPlazas(PaseoTuristico paseo){}
    
    public void integrarServicio(){}
}
