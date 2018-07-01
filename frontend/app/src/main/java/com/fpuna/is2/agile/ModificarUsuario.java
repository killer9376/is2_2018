package com.fpuna.is2.agile;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.fpuna.is2.agile.acceso.RetrofitClientInstance;
import com.fpuna.is2.agile.modelos.Rol;
import com.fpuna.is2.agile.modelos.Usuario;
import com.fpuna.is2.agile.servicios.RolesService;
import com.fpuna.is2.agile.servicios.UsuariosService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ModificarUsuario extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters
    View vista;
    Button btnModificar;
    Button btnEliminar;
    Spinner spinner;
    ArrayList<String> values;
    ArrayAdapter<String> dataAdapter;
    ProgressDialog progressDoalog;
    List<Rol>  roles;
    Rol rolSeleccionado;
    Usuario usuarioParam;
    //private OnFragmentInteractionListener mListener;

    public ModificarUsuario() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    /*public static ModificarUsuario newInstance(String param1, String param2) {
        ModificarUsuario fragment = new ModificarUsuario();
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
        vista = inflater.inflate(R.layout.fragment_modif_usuario, container, false);
        spinner = (Spinner) vista.findViewById(R.id.idSpinRol);
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
               String valor = parent.getItemAtPosition(pos).toString();
                for (Rol item :roles) {
                    String valorItem = item.toString();
                    if(valorItem.equals(valor)){
                        rolSeleccionado = item;
                    }

                }

            }
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            usuarioParam=new Usuario();

            String codigoUsuario = bundle.getString("codigoUsuario");

            usuarioParam.setCodigoUsuario(codigoUsuario);

            EditText codUsu = (EditText)vista.findViewById(R.id.cod_user);
            codUsu.setText(codigoUsuario);
            codUsu.setFocusable(false);
            codUsu.setEnabled(false);
            codUsu.setCursorVisible(false);
            codUsu.setKeyListener(null);
            codUsu.setBackgroundColor(Color.TRANSPARENT);
        // nombre
            String nombre = bundle.getString("nombre");
            EditText nombreUsu = (EditText)vista.findViewById(R.id.nombre_user);
            nombreUsu.setText(nombre);

            usuarioParam.setNombre(nombre);
        // apellido
            String apellido = bundle.getString("apellido");
            EditText apellidoUsu = (EditText)vista.findViewById(R.id.apell_user);
            apellidoUsu.setText(apellido);
            usuarioParam.setApellido(apellido);
        // idUsuario
            Integer idUsuario = bundle.getInt("idUsuario");
            usuarioParam.setIdUsuario(idUsuario);


        }

        values = new ArrayList();
        values.add("Sin Datos.");
        obtenerRoles();

        dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        btnModificar = (Button) vista.findViewById(R.id.btn_modif_user);
        btnModificar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
             //   Toast.makeText(getActivity(), "Modificando..", Toast.LENGTH_SHORT).show();
                modificarUsuario();
            }
        });

        btnEliminar = (Button) vista.findViewById(R.id.btn_eliminar_user);
        btnEliminar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Eliminando..", Toast.LENGTH_SHORT).show();
            }
        });


        return vista;
    }
    public void modificarUsuario(){
        progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Cargando....");
        progressDoalog.show();
        // nombre
        EditText nombreUsu = (EditText)vista.findViewById(R.id.nombre_user);
        usuarioParam.setNombre(nombreUsu.getText().toString());
        // apellido
        EditText apellidoUsu = (EditText)vista.findViewById(R.id.apell_user);
        usuarioParam.setApellido(apellidoUsu.getText().toString());

        //  Toast.makeText(getActivity(),apellidoUsu.getText().toString() , Toast.LENGTH_LONG).show();

        UsuariosService service = RetrofitClientInstance.getRetrofitInstance().create(UsuariosService.class);
        Call<Usuario> call =null;
        usuarioParam.setIdRol( rolSeleccionado );
        call  = service.actualizarUsuario(usuarioParam.getIdUsuario() ,usuarioParam);

        call.enqueue(new Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                progressDoalog.dismiss();
                int status = response.code();
                if(response.isSuccessful()){
                    Toast.makeText(getActivity(), "Modificado..", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(),"No se obtuvo resultados." , Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(getActivity(),t.getMessage() , Toast.LENGTH_LONG).show();
            }
        });
    }
    public void obtenerRoles(){

        progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Cargando....");
        progressDoalog.show();

        RolesService service = RetrofitClientInstance.getRetrofitInstance().create(RolesService.class);
        Call<List<Rol>> call =null;
        call  = service.obtenerRol();

        call.enqueue(new Callback<List<Rol>>() {
            @Override
            public void onResponse(Call<List<Rol>> call, Response<List<Rol>> response) {
                progressDoalog.dismiss();
                int status = response.code();
                List<Rol> data = response.body();
                roles=data;
                if(status == 200){
                    List<String> dataString =new ArrayList<>();
                    for (Rol item: data ) {
                        dataString.add(item.getIdRol()+"-"+item.getDescripcion());
                    }
                    dataAdapter.clear();
                    dataAdapter.addAll(dataString);
                    dataAdapter.notifyDataSetChanged();

                }else{
                    Toast.makeText(getActivity(),"No se obtuvo resultados." , Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<List<Rol>> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(getActivity(),t.getMessage() , Toast.LENGTH_LONG).show();
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    /*public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/

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
