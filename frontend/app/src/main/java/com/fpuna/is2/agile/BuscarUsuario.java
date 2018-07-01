package com.fpuna.is2.agile;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.fpuna.is2.agile.acceso.RetrofitClientInstance;
import com.fpuna.is2.agile.modelos.Usuario;
import com.fpuna.is2.agile.servicios.UsuariosService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BuscarUsuario extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g.4 ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
    //private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    //private String mParam1;
    //private String mParam2;
    View vista;
    ListView ListaUser;
    Button btnBuscar;
    ProgressDialog progressDoalog;
    //private OnFragmentInteractionListener mListener;
     ArrayList<String> listaUsr;
    ArrayAdapter adaptador;
    public BuscarUsuario() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    /*public static BuscarUsuario newInstance(String param1, String param2) {
        BuscarUsuario fragment = new BuscarUsuario();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_buscar_usuario, container, false);

        ListaUser = (ListView) vista.findViewById(R.id.lisViewUser);

      listaUsr = new ArrayList<>();
        adaptador = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listaUsr);
        ListaUser.setAdapter(adaptador);
        ListaUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //aca va el codigo cuando se selecciona un item de la lista
            }
        });

        btnBuscar = (Button) vista.findViewById(R.id.btn_buscar_user);
        btnBuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                obtenerUsuarios();
            }
        });

        return vista;
    }
    public void obtenerUsuarios(){

        progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Cargando....");
        progressDoalog.show();

        UsuariosService service = RetrofitClientInstance.getRetrofitInstance().create(UsuariosService.class);
        Call<List<Usuario>> call =null;

        EditText dato = (EditText) getView().findViewById(R.id.cod_user_buscar);
        String filtro =dato.getText().toString();

        if(filtro.isEmpty()){
            call  = service.obtenerUsuario();
        }else{
            call  = service.obtenerUsuarios(filtro);
        }


        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                progressDoalog.dismiss();
                int status = response.code();
                List<Usuario> data = response.body();
                if(status == 200){
                    List<String> dataString =new ArrayList<>();
                    for (Usuario item: data ) {
                        dataString.add( "Codigo: "+item.getCodigoUsuario() + " \nNombre: "+ item.getNombre() + " "+item.getApellido());
                    }
                  //  Toast.makeText(getActivity(),"Se obtuvieron " + data.size() +" usuarios!" + "Total lista origial: "+listaUsr.size(), Toast.LENGTH_SHORT).show();
                    adaptador.clear();
                    adaptador.addAll(dataString);
                    adaptador.notifyDataSetChanged();

                }else{
                    Toast.makeText(getActivity(),"No se obtuvo resultados." , Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(getActivity(),t.getMessage() , Toast.LENGTH_LONG).show();
            }
        });
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
