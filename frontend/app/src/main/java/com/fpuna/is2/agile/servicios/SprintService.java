package com.fpuna.is2.agile.servicios;

import com.fpuna.is2.agile.modelos.Proyecto;
import com.fpuna.is2.agile.modelos.Sprint;
import com.fpuna.is2.agile.modelos.Usuario;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface SprintService {
    @GET("sprints/tareas/{id}")
    Call<List<Sprint>> obtenerTareasUsuario(@Path("id") Integer id);

    @GET("sprints/pendientes/{id}")
    Call<List<Sprint>> obtenerPendientes(@Path("id") Integer id);

    @GET("sprints/proyecto/{id}")
    Call<List<Proyecto>> obtenerProyectos(@Path("id") Integer id);

    @GET("sprints/obtener/{filtro}/{idUsuario}")
    Call<List<Sprint>> obtenerTareasUsuarioFiltro(@Path("filtro") String filtro,@Path("idUsuario") Integer idUsuario);

    @PUT("sprints/{id}")
    Call<Sprint> actualizarSprint(@Path("id") Integer id, @Body Sprint tarea);


    @POST("sprint")
    Call<Sprint> agregar(@Body Sprint tarea);

    @POST("sprint/eliminar/{id}")
    Call<Usuario> eliminar(@Path("id") Integer id);
}
