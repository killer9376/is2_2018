package com.fpuna.is2.agile;

import android.app.VoiceInteractor;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class RegistroActivity extends AppCompatActivity {
    private static final String TAG = "RegistroActivity";

  //  @BindView(R.id.input_name) TextView user;
    EditText editText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
      //  ButterKnife.bind(this);
      ///  user.setText("Jhony Benitez");
      //  Log.d(TAG, "onCreate: "+user.toString());
        Button btn1 = (Button) findViewById(R.id.btn_signup);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                CharSequence text = "Error de usuario!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, singleRequest(), duration);
                toast.show();
            }
        });
    }

    public String singleRequest(){
        editText = (EditText) findViewById(R.id.input_name);
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://10.0.2.2:18080/app/api/usuarios";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                       // mTextView.setText("Response is: "+ response.substring(0,500));
                        editText.setText("It works" + response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                editText.setText("That didn't work!" + error);
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

        return "hi";
    }
}
