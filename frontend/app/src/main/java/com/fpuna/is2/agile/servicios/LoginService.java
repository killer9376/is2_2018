package com.fpuna.is2.agile.servicios;

import com.fpuna.is2.agile.modelos.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    @POST("login")
    Call<Usuario> login(@Body Usuario user);
}
