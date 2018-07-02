package com.fpuna.is2.agile.servicios;

import com.fpuna.is2.agile.modelos.Proyecto;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ProyectosService {
    @GET("proyectos")
    Call<List<Proyecto>> obtenerProyectos();
    @GET("proyectos/{id}")
    Call<Proyecto> obtenerProyecto(@Path("id") Integer id);
    @POST("proyectos")
    Call<Proyecto> agregar(@Body Proyecto proyecto);
}
