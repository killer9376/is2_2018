package com.fpuna.is2.agile.servicios;
import com.fpuna.is2.agile.modelos.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UsuariosService {
    @GET("usuarios")
    Call<List<Usuario>> obtenerUsuario();
    @GET("usuarios/{id}")
    Call<Usuario> obtenerUsuario(@Path("id") Integer id);
    @POST("usuarios")
    Call<Usuario> agregar(@Body Usuario user);
    @GET("usuarios/obtener/{codigoUsuario}")
    Call<List<Usuario>> obtenerUsuarios(@Path( "codigoUsuario") String codigoUsuario);
    @PUT("usuarios/{id}")
    Call<Usuario> actualizarUsuario(@Path("id") Integer id, @Body Usuario user);
    @POST("usuarios/eliminar/{id}")
    Call<Usuario> eliminar(@Path("id") Integer id);
}
