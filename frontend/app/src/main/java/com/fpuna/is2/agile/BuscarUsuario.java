package com.fpuna.is2.agile;

import android.app.Fragment;
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

    //private OnFragmentInteractionListener mListener;

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

        ArrayList<String> listaUsr = new ArrayList<>();
        listaUsr.add("asd");
        listaUsr.add("dsa");
        listaUsr.add("alv");
        listaUsr.add("alv");
        listaUsr.add("alv");
        listaUsr.add("alv");
        listaUsr.add("alv");
        listaUsr.add("alv");
        listaUsr.add("alv");
        listaUsr.add("alv");

        ArrayAdapter adaptador = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listaUsr);
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
                Toast.makeText(getActivity(), "Yoni se la come", Toast.LENGTH_LONG).show();
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
