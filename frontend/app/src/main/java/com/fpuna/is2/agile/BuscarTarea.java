package com.fpuna.is2.agile;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
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
import com.fpuna.is2.agile.modelos.Sprint;
import com.fpuna.is2.agile.modelos.Usuario;
import com.fpuna.is2.agile.servicios.SprintService;
import com.fpuna.is2.agile.servicios.UsuariosService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class BuscarTarea extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters
    View vista;
    ListView ListaTareas;
    Button btnCrear;
    Button btnBuscar;
    ProgressDialog progressDoalog;
    ArrayAdapter adaptador;
    List<Sprint> listaSprint;
    Integer idUsuario;

    //private OnFragmentInteractionListener mListener;

    public BuscarTarea() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    /*public static BuscarTarea newInstance(String param1, String param2) {
        BuscarTarea fragment = new BuscarTarea();
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
        Bundle bundle = this.getArguments();
        if(bundle!= null){
            Integer id = (Integer)bundle.get("idUsuario");
            idUsuario=id;
            Log.d("ID_VALUES", "onCreateView: "+id);
            Log.d("ID", "onCreateView: "+ idUsuario );
        }

        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_buscar_tarea, container, false);

        ListaTareas = (ListView) vista.findViewById(R.id.lisViewTarea);
        btnBuscar = (Button) vista.findViewById(R.id.btn_buscar_tarea);
        btnCrear = (Button) vista.findViewById(R.id.btn_crear_tarea);

        ArrayList<String> listaTar = new ArrayList<>();
        for (int i = 0; i>5; i++){
            listaTar.add("Item " + i);
        }


        adaptador = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listaTar);
        ListaTareas.setAdapter(adaptador);
        ListaTareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                //aca va el codigo cuando se selecciona un item de la lista

                Bundle bundle = new Bundle();
                // bundle.putString();
                String valor = adapterView.getItemAtPosition(pos).toString();
                Sprint tareaSeleccionada = new Sprint();
                for ( Sprint item : listaSprint ) {
                    String valorAcomparar = item.toString();
                    if( valorAcomparar.equals(valor)){
                        tareaSeleccionada = item;
                    }
                }
                if(tareaSeleccionada.getIdSprint()!=null){
                    bundle.putString("nombreTarea",tareaSeleccionada.getTitulo());
                    bundle.putInt("idProyecto",tareaSeleccionada.getIdProyecto().getIdProyecto());
                    bundle.putString("descripcion",tareaSeleccionada.getDescripcion());
                    bundle.putString("fechaInicio",tareaSeleccionada.getFechaInicio());
                    bundle.putString("fechaFin",tareaSeleccionada.getFechaFin());
                    bundle.putInt("duracion",tareaSeleccionada.getDuracion());
                }

                ModificarTarea modificarTarea = new ModificarTarea();
                modificarTarea.setArguments(bundle);

                getActivity().setTitle("Modificar Usuario");
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.content_frame, modificarTarea )
                        .commit();
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                obtenerTareas();
                Toast.makeText(getActivity(), "Buscando la tarea", Toast.LENGTH_LONG).show();
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ModificarTarea modif = new ModificarTarea();
                getActivity().setTitle("Crear Tarea");
                FragmentManager fr = getFragmentManager();
                fr.beginTransaction()
                        .replace(R.id.content_frame, modif)
                        .commit();
            }
        });

        return vista;
    }

    public void obtenerTareas(){
        progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Cargando....");
        progressDoalog.show();

        SprintService service = RetrofitClientInstance.getRetrofitInstance().create(SprintService.class);
        Call<List<Sprint>> call =null;

        EditText filtro = (EditText) getView().findViewById(R.id.cod_tarea_buscar);
        String valor = filtro.getText().toString();
        if(valor.isEmpty()){
            call  = service.obtenerTareasUsuario(idUsuario);
        }else {
            call  = service.obtenerTareasUsuarioFiltro(valor,idUsuario);
        }

        call  = service.obtenerTareasUsuario(idUsuario);

        call.enqueue(new Callback<List<Sprint>>() {
            @Override
            public void onResponse(Call<List<Sprint>> call, Response<List<Sprint>> response) {
                progressDoalog.dismiss();
                int status = response.code();
                List<Sprint> data = response.body();
                listaSprint =data;
                List<String> dataString =new ArrayList<>();
                if(status == 200){

                    for (Sprint item: data ) {
                        dataString.add( "Titulo: "+item.getTitulo() + " \nProyecto: "+ item.getIdProyecto().getNombreProyecto() + " \nEstado: "+item.getIdUserStory().getTitulo()   +"\n");
                    }

                }else{
                    Toast.makeText(getActivity(),"No se obtuvo resultados." , Toast.LENGTH_LONG).show();
                }
                adaptador.clear();
                adaptador.addAll(dataString);
                adaptador.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Sprint>> call, Throwable t) {
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

    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
