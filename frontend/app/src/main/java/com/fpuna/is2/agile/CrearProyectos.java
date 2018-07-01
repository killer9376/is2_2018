package com.fpuna.is2.agile;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.fpuna.is2.agile.acceso.RetrofitClientInstance;
import com.fpuna.is2.agile.modelos.Proyecto;
import com.fpuna.is2.agile.modelos.Usuario;
import com.fpuna.is2.agile.servicios.ProyectosService;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CrearProyectos extends Fragment {
    ProgressDialog progressDoalog;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    /*private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;*/
    final Calendar c = Calendar.getInstance();
    View vista;
    Button btnCrear;
    TextView fecha_;


    Integer idUsuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    //private OnFragmentInteractionListener mListener;

    public CrearProyectos() {
        // Required empty public constructor
    }

    /*// TODO: Rename and change types and number of parameters
    public static CrearProyectos newInstance(String param1, String param2) {
        CrearProyectos fragment = new CrearProyectos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int id = bundle.getInt("idUsuario", -1);
            setIdUsuario(id);
        }

        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_buscar_proyectos, container, false);

        fecha_ = (TextView) vista.findViewById(R.id.input_fecha_proyecto);

        fecha_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerFecha();
            }
        });

        btnCrear = (Button) vista.findViewById(R.id.btn_crear_proyecto);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarProyecto();
                //Toast.makeText(getActivity(), "Yoni se la come", Toast.LENGTH_LONG).show();
            }
        });
        return vista;
    }

    public  void agregarProyecto() {

        TextView nombreProyect = (TextView)getView().findViewById(R.id.input_nombre_proyecto);
        TextView descripcionProyect = (TextView)getView().findViewById(R.id.input_desc_proyecto);
        TextView anio =(TextView)getView().findViewById(R.id.input_year_proyecto);
        TextView fecInicio =(TextView)getView().findViewById(R.id.input_fecha_proyecto);
        Integer idUsuario=null;
        progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Cargando....");
        progressDoalog.show();
        ProyectosService service = RetrofitClientInstance.getRetrofitInstance().create(ProyectosService.class);
        Proyecto proyecto = new Proyecto();
        // usuario administrador del proyecto
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(getIdUsuario());

        proyecto.setAdminProyecto(usuario);
        proyecto.setNombreProyecto(nombreProyect.getText().toString());
        proyecto.setDescripcion(descripcionProyect.getText().toString());
        proyecto.setAnio(anio.getText().toString());
        proyecto.setEstado("ACTIVO");
        proyecto.setFechaInicio(fecInicio.getText().toString());

        Call<Proyecto> call = service.agregar(proyecto);

        call.enqueue(new Callback<Proyecto>() {
            @Override
            public void onResponse(Call<Proyecto> call, Response<Proyecto> response) {
                progressDoalog.dismiss();
                int status = response.code();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(status == 204)
                    Toast.makeText(getActivity(), "Proyecto Creado.!", Toast.LENGTH_LONG).show();
                else{
                    Toast.makeText(getActivity(),"No se pudo realizar la operacion." , Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<Proyecto> call, Throwable t) {
                progressDoalog.dismiss();
                Toast.makeText(getActivity(),t.getMessage() , Toast.LENGTH_LONG).show();
            }
        });




    }
    public void obtenerFecha(){

        final int mes = c.get(Calendar.MONTH);
        final int dia = c.get(Calendar.DAY_OF_MONTH);
        final int anio = c.get(Calendar.YEAR);

        DatePickerDialog recogerFecha = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                int mesActual = month + 1;
                String diaFormateado = (dayOfMonth < 10)? "0" + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String mesFormateado = (mesActual < 10)? "0" + String.valueOf(mesActual):String.valueOf(mesActual);

                fecha_.setText(diaFormateado + "/" + mesFormateado +"/"+ year);

            }
        },anio, mes, dia);

        recogerFecha.show();

    }

    /*// TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
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
