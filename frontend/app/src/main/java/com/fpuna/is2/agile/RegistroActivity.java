package com.fpuna.is2.agile;

import android.app.ProgressDialog;
import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fpuna.is2.agile.acceso.RetrofitClientInstance;
import com.fpuna.is2.agile.modelos.Rol;
import com.fpuna.is2.agile.modelos.Usuario;
import com.fpuna.is2.agile.servicios.LoginService;
import com.fpuna.is2.agile.servicios.UsuariosService;

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistroActivity extends AppCompatActivity {
    private static final String TAG = "RegistroActivity";
    ProgressDialog progressDoalog;
    EditText codigoUsuario;
    EditText nombre;
    EditText apellido;
    EditText pass;
    EditText rePass;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Button btn1 = (Button) findViewById(R.id.btn_signup);
        TextView irLogin = (TextView) findViewById(R.id.link_login);
        irLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irLogin();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Error de usuario!";
                int duration = Toast.LENGTH_LONG;
                 pass = (EditText) findViewById(R.id.input_password);
                 rePass = (EditText) findViewById(R.id.input_re_password);

                if(!checkPass(pass.getText().toString(),rePass.getText().toString())){
                    Toast.makeText(context,"Las contrasenias no coinciden" , duration).show();
                }else{
                    registrarUsuario();
                }
            }
        });
    }
    public void irLogin(){
        Intent intent = new Intent(RegistroActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
    public boolean checkPass( String pass, String rePass){
        return pass.equals(rePass);
    }

    public void registrarUsuario(){

        codigoUsuario = (EditText) findViewById(R.id.input_user);
        nombre = (EditText) findViewById(R.id.input_name);
        apellido = (EditText) findViewById(R.id.input_last_name);
        progressDoalog = new ProgressDialog(RegistroActivity.this);
        progressDoalog.setMessage("Cargando....");
        progressDoalog.show();
        UsuariosService service = RetrofitClientInstance.getRetrofitInstance().create(UsuariosService.class);
        Usuario usuario = new Usuario();
        usuario.setCodigoUsuario( codigoUsuario.getText().toString());
        usuario.setNombre(nombre.getText().toString());
        usuario.setApellido(apellido.getText().toString());
        usuario.setContrasenia(pass.getText().toString());
        Rol rol = new Rol();
        rol.setIdRol(2);
        usuario.setIdRol( rol);

        Call<Usuario> call = service.agregar(usuario);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                progressDoalog.dismiss();
                int status = response.code();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(status == 204){
                    Intent intent = new Intent(RegistroActivity.this,LoginActivity.class);
                    intent.putExtra("codigoUsuario",codigoUsuario.getText().toString());
                    startActivity(intent);
                    finish();
                    Toast.makeText(RegistroActivity.this,"Usuario Creado.!" , Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegistroActivity.this,"El c�digo usuario ya existe." , Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(RegistroActivity.this,t.getMessage() , Toast.LENGTH_LONG).show();
            }
        });
    }
}
