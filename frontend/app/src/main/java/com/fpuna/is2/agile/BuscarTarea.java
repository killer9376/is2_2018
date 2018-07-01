package com.fpuna.is2.agile;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class BuscarTarea extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters
    View vista;
    ListView ListaTareas;
    Button btnCrear;
    Button btnBuscar;

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
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_buscar_tarea, container, false);

        ListaTareas = (ListView) vista.findViewById(R.id.lisViewTarea);
        btnBuscar = (Button) vista.findViewById(R.id.btn_buscar_tarea);
        btnCrear = (Button) vista.findViewById(R.id.btn_crear_tarea);

        ArrayList<String> listaTar = new ArrayList<>();
        for (int i = 0; i>5; i++){
            listaTar.add("Item " + i);
        }

        ArrayAdapter adaptador = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listaTar);
        ListaTareas.setAdapter(adaptador);
        ListaTareas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //aca va el codigo cuando se selecciona un item de la lista
            }
        });

        btnBuscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
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
