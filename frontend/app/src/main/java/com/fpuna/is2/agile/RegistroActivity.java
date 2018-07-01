package com.fpuna.is2.agile;

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

/*import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;*/

import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.util.HashMap;

public class RegistroActivity extends AppCompatActivity {
    private static final String TAG = "RegistroActivity";

  //  @BindView(R.id.input_name) TextView user;
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
                Toast toast=null;
                if(!checkPass(pass.getText().toString(),rePass.getText().toString())){
                     toast = Toast.makeText(context,"Las contrasenias no coinciden" , duration);
                }else{
                    singleRequest();
                    toast = Toast.makeText(context,"Text" , duration);
                }
                toast.show();
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
    public String singleRequest(){
        /*codigoUsuario = (EditText) findViewById(R.id.input_user);
        nombre = (EditText) findViewById(R.id.input_name);
        apellido = (EditText) findViewById(R.id.input_last_name);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://10.0.2.2:18080/app/api/usuarios";

        RequestFuture<StringRequest> requestFuture=RequestFuture.newFuture();

        StringRequest response = null;
        final StringRequest request = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: "+response);
                Intent intent = new Intent(RegistroActivity.this,LoginActivity.class);
                intent.putExtra("codigoUsuario",codigoUsuario.getText().toString());
                startActivity(intent);
                finish();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "onResponse: " +error.getStackTrace());
            }
        }) {
            @Override
            public byte[] getBody() throws AuthFailureError {
                HashMap<String, Object> params2 = new HashMap<String, Object>();
                params2.put("codigoUsuario",codigoUsuario.getText().toString());
                params2.put("contrasenia", pass.getText().toString());
                params2.put("nombre", nombre.getText().toString());
                params2.put("apellido", apellido.getText().toString());
                params2.put("idRol", 1);

                return new JSONObject (params2).toString().getBytes();
            }

            @Override
            public String getBodyContentType() {
                return "application/json";
            }
        };
        queue.add(request);*/
        return "hi";
    }
}
