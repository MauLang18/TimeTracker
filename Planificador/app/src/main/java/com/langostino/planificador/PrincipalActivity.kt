package com.langostino.planificador

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.langostino.planificador.adaptadores.ViewPageAdapter
import com.langostino.planificador.fragments.ActividadesFragment
import com.langostino.planificador.fragments.HorarioFragment
import com.langostino.planificador.fragments.PlanificadorFragment

class PrincipalActivity : AppCompatActivity() {
    //variables que se van a utilizar
    lateinit var viewPager : ViewPager
    lateinit var tabs : TabLayout
    lateinit var btnBuscar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_princiapal)
        //inicializar las variables con la id de los objetos del xml
        viewPager=findViewById(R.id.viewPager);
        tabs=findViewById(R.id.tabs);

        setUpTabs()
    }

    //funcion para agregar pestañas al tablayout
    private fun setUpTabs(){
        val adapter = ViewPageAdapter(supportFragmentManager)
        adapter.addFragment(PlanificadorFragment(),"Planificador")
        adapter.addFragment(HorarioFragment(),"Horario")
        adapter.addFragment(ActividadesFragment(), "Actividades")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

    }
}