package com.fpuna.is2.agile.servicios;

import com.fpuna.is2.agile.modelos.Rol;
import com.fpuna.is2.agile.modelos.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RolesService {
    @GET("roles")
    Call<List<Rol>> obtenerRol();
    @GET("roles/{id}")
    Call<Rol> obtenerUsuario(@Path("id") Integer id);
}
