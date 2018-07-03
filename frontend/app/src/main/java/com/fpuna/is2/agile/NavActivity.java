package com.fpuna.is2.agile;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.fpuna.is2.agile.modelos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class NavActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    Integer idUsuario;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String codigoUsuario=null;
        String nombre=null;
        Integer idRol=null;
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){
            Integer id = (Integer)bundle.get("idUsuario");
            idUsuario =id;
           codigoUsuario  = (String) bundle.get("codigoUsuario");
           nombre= (String) bundle.get("nombre");
           idRol= (Integer) bundle.get("idRol");

           hideItem(idRol);

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        TextView navUsername = (TextView) headerView.findViewById(R.id.nav_codigo_usuario);
        TextView navName = (TextView) headerView.findViewById(R.id.nav_nombre_usuario);
        navUsername.setText(codigoUsuario.toUpperCase());
        navName.setText(nombre.toUpperCase());

        navigationView.setNavigationItemSelectedListener(this);
    }

    private void hideItem(Integer idRol)
    {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu nav_Menu = navigationView.getMenu();
        if (idRol != 1){
            //agregar la wea de comprobación pa la wea de ocultar items del nav
            nav_Menu.findItem(R.id.nav_usuarios).setVisible(false);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(NavActivity.this,LoginActivity.class);
            startActivity(intent);
            //Toast.makeText(NavActivity.this,"Hacer funcion aqui" , Toast.LENGTH_LONG).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        FragmentManager fragmentManager = getFragmentManager();

        if (id == R.id.nav_proyectos_layout) {
            Bundle bundle = new Bundle();
            Log.d("ID", "onNavigationItemSelected: "+idUsuario);
            bundle.putInt("idUsuario", idUsuario );
            setTitle("Creación de Proyectos");
            CrearProyectos cProyecto = new CrearProyectos();
            cProyecto.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, cProyecto )
                    .commit();

        } else if (id == R.id.nav_tareas_layout) {
            Bundle bundle = new Bundle();
            bundle.putInt("idUsuario", idUsuario);
            Log.d("NAV_ACTIVITY", "onNavigationItemSelected: "+idUsuario);
            BuscarTarea mBuscar = new BuscarTarea();
            mBuscar.setArguments(bundle);
            setTitle("Tareas");
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, mBuscar)
                    .commit();
        } else if (id == R.id.nav_usuarios) {
            setTitle("Usuarios");
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new BuscarUsuario())
                    .commit();
        } else if (id == R.id.nav_send) {
            setTitle("Modificar Usuario");
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, new ModificarUsuario())
                    .commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
