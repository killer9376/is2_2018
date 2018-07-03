package com.fpuna.is2.agile;

import android.app.DatePickerDialog;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fpuna.is2.agile.modelos.Sprint;

import java.util.Calendar;

public class ModificarTarea extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    // TODO: Rename and change types of parameters
    View vista;
    Button btnModificar;
    Button btnEliminar;
    Button btnCrear;
    TextView fechaIni;
    TextView fechaFin;
    final Calendar cFin = Calendar.getInstance();
    final Calendar cIni = Calendar.getInstance();
    Sprint tarea;

    //private OnFragmentInteractionListener mListener;

    public ModificarTarea() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    /*public static ModificarTarea newInstance(String param1, String param2) {
        ModificarTarea fragment = new ModificarTarea();
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
        vista = inflater.inflate(R.layout.fragment_modif_tarea, container, false);


        btnCrear = vista.findViewById(R.id.btn_crear_tarea);
        btnModificar = vista.findViewById(R.id.btn_modif_tarea);
        btnEliminar = vista.findViewById(R.id.btn_eliminar_tarea);
        fechaIni = vista.findViewById(R.id.fecha_inicio_tarea);
        fechaFin = vista.findViewById(R.id.fecha_fin_tarea);
        btnCrear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Creanding..", Toast.LENGTH_SHORT).show();
            }
        });
        btnModificar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Actualizando..", Toast.LENGTH_SHORT).show();
            }
        });
        btnEliminar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Eliminando..", Toast.LENGTH_SHORT).show();
            }
        });
        fechaIni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerFechaIni();
            }
        });
        fechaFin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerFechaFin();
            }
        });
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            tarea =new Sprint();
            String nombre = bundle.getString("nombreTarea");
            tarea.setTitulo(nombre);
            EditText nombreT = (EditText)vista.findViewById(R.id.nombre_tarea);
            nombreT.setText(nombre);

//            // nombre
//            Integer idProyecto = bundle.getInt("idProyecto");
//            EditText nombreUsu = (EditText)vista.findViewById(R.id.);
//            nombreUsu.setText(nombre);
//
//            usuarioParam.setNombre(nombre);
//            // apellido
//            Integer duracion = bundle.getInt("duracion");
//            EditText duracionT = (EditText)vista.findViewById(R.id.duracion_tarea);
//            duracionT.setText(apellido);
//            usuarioParam.setApellido(apellido);
//            // idUsuario
//            Integer idUsuario = bundle.getInt("idUsuario");
//            usuarioParam.setIdUsuario(idUsuario);


        }

        return vista;
    }

    public void obtenerFechaIni(){

        final int mes = cIni.get(Calendar.MONTH);
        final int dia = cIni.get(Calendar.DAY_OF_MONTH);
        final int anio = cIni.get(Calendar.YEAR);

        DatePickerDialog recogerFecha = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                int mesActual = month + 1;
                String diaFormateado = (dayOfMonth < 10)? "0" + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String mesFormateado = (mesActual < 10)? "0" + String.valueOf(mesActual):String.valueOf(mesActual);

                fechaIni.setText(diaFormateado + "/" + mesFormateado +"/"+ year);

            }
        },anio, mes, dia);

        recogerFecha.show();

    }

    public void obtenerFechaFin(){

        final int mes = cFin.get(Calendar.MONTH);
        final int dia = cFin.get(Calendar.DAY_OF_MONTH);
        final int anio = cFin.get(Calendar.YEAR);

        DatePickerDialog recogerFecha = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                int mesActual = month + 1;
                String diaFormateado = (dayOfMonth < 10)? "0" + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String mesFormateado = (mesActual < 10)? "0" + String.valueOf(mesActual):String.valueOf(mesActual);

                fechaFin.setText(diaFormateado + "/" + mesFormateado +"/"+ year);

            }
        },anio, mes, dia);

        recogerFecha.show();

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
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
