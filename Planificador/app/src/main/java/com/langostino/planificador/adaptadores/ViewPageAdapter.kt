package com.langostino.planificador.adaptadores

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import java.util.ArrayList

class ViewPageAdapter(supportFragmentManager: FragmentManager) : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    //variables para agregar ls titulos y la cantidad de pestañas
    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleArray = ArrayList<String>()

    //funcion para obtener el tamaño de la array list
    override fun getCount(): Int {
        return mFragmentList.size
    }

    //funcion para obtener la pestaña
    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    //funcion para obtener el titulo
    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleArray[position]
    }

    //funcion para añadir titulo y una pestaña al array list
    fun addFragment(fragment: Fragment, title: String){
        mFragmentList.add(fragment)
        mFragmentTitleArray.add(title)
    }
}