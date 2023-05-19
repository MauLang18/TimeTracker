import 'package:flutter/material.dart';

class mate11 extends StatelessWidget {
  BuildContext? get context => null;

  List<Tab> tabs = [
    Tab(child: const Text('Simetria axial')),
    Tab(child: const Text('Transformaciones en el plano')),
    Tab(child: const Text('Cono')),
    Tab(child: const Text('Cono truncado')),
    Tab(child: const Text('Estadistica')),
    Tab(child: const Text('Funcion lineal')),
    Tab(child: const Text('Funcion cuadratica')),
    Tab(child: const Text('Sistema de ecuaciones')),
    Tab(child: const Text('Circulo y circunferencias')),
    Tab(child: const Text('Puntos de la circunferencia')),
    Tab(child: const Text('Distancia entre puntos')),
    Tab(child: const Text('Punto medio de un segmento')),
    Tab(child: const Text('Trasladacion de un punto')),
    Tab(child: const Text('Rectas en la circunferencia')),
    Tab(child: const Text('Poligonos regulares')),
    Tab(child: const Text('Poligonos irregulares')),
    Tab(child: const Text('Esfera')),
    Tab(child: const Text('Cilindro')),
    Tab(child: const Text('Conjuntos numericos')),
    Tab(child: const Text('Funciones')),
    Tab(child: const Text('Graficas')),
    Tab(child: const Text('Funciones exponenciales')),
    Tab(child: const Text('Funciones logaritmicas')),
    Tab(child: const Text('Probabilidad')),
  ];

  List<Widget> tabsContent = [
    Container(child: Image.asset('assets/images/formula1_m11.png')),
    Container(child: Image.asset('assets/images/formula2_m11.png')),
    Container(child: Image.asset('assets/images/formula3_m11.png')),
    Container(child: Image.asset('assets/images/formula4_m11.png')),
    Container(child: Image.asset('assets/images/formula5_m11.png')),
    Container(child: Image.asset('assets/images/formula6_m11.png')),
    Container(child: Image.asset('assets/images/formula7_m11.png')),
    Container(child: Image.asset('assets/images/formula8_m11.png')),
    Container(child: Image.asset('assets/images/formula9_m11.png')),
    Container(child: Image.asset('assets/images/formula10_m11.png')),
    Container(child: Image.asset('assets/images/formula11_m11.png')),
    Container(child: Image.asset('assets/images/formula12_m11.png')),
    Container(child: Image.asset('assets/images/formula13_m11.png')),
    Container(child: Image.asset('assets/images/formula14_m11.png')),
    Container(child: Image.asset('assets/images/formula15_m11.png')),
    Container(child: Image.asset('assets/images/formula16_m11.png')),
    Container(child: Image.asset('assets/images/formula17_m11.png')),
    Container(child: Image.asset('assets/images/formula18_m11.png')),
    Container(child: Image.asset('assets/images/formula19_m11.png')),
    Container(child: Image.asset('assets/images/formula20_m11.png')),
    Container(child: Image.asset('assets/images/formula21_m11.png')),
    Container(child: Image.asset('assets/images/formula22_m11.png')),
    Container(child: Image.asset('assets/images/formula23_m11.png')),
    Container(child: Image.asset('assets/images/formula24_m11.png')),
  ];

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: tabs.length,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Matematicas 11°'),
          backgroundColor: const Color(0xff333333),
          centerTitle: true,
          brightness: Brightness.dark,
          bottom: PreferredSize(
            preferredSize: Size.fromHeight(30),
            child: TabBar(
              indicatorColor: Colors.white,
              isScrollable: true,
              tabs: tabs,
            ),
          ),
        ),
        body: TabBarView(
          children: tabsContent,
        ),
        backgroundColor: const Color(0xFFE1F4F3),
      ),
    );
  }
}
