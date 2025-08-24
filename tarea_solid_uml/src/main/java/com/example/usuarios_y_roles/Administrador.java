package com.example.usuarios_y_roles;

import com.example.turismo_y_paseos.PaseoTuristico;

public class Administrador extends Usuario{

    public Administrador(int id, String nombre, String correoStr) {
    super(id, nombre, new Email(correoStr));
}
    
    public void configurarPoliticas(){
    // logica de configurar politicas
    }

    public void  ajustarPlazas(PaseoTuristico paseo){
    // logica para ajustar plazas
    }
    
    public void integrarServicio(){
    // logica para integrar servicios
    }
}
