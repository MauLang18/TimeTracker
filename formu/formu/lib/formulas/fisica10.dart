import 'package:flutter/material.dart';

class fisica10 extends StatelessWidget {
  BuildContext? get context => null;

  List<Tab> tabs = [
    const Tab(child: Text('Suma de vectores')),
    const Tab(child: Text('Distancia, rapidez y tiempo')),
    const Tab(child: Text('Desplazamiento, velocidad y tiempo')),
    const Tab(child: Text('Magnitud')),
    const Tab(child: Text('Direccion')),
    const Tab(child: Text('Movimiento Rectilineo Uniforme')),
    const Tab(child: Text('Movimiento Rectilineo Uniformemente Acelerado')),
    const Tab(child: Text('Movimiento Vertical/Caida libre y tiro vertical')),
    const Tab(child: Text('Peso')),
    const Tab(child: Text('Fuerza de friccion')),
    const Tab(child: Text('Segunda ley de Newton')),
    const Tab(child: Text('Fuerza de elasticidad')),
    const Tab(child: Text('Fuerza gravitatoria')),
    const Tab(child: Text('Aceleracion gravitatoria')),
    const Tab(child: Text('Fuerza centifuga')),
    const Tab(child: Text('Velocidad satelital')),
    const Tab(child: Text('Periodo satelital')),
    const Tab(child: Text('Trabajo mecanico')),
    const Tab(child: Text('Energia potencial elastico')),
    const Tab(child: Text('Energia cinetica')),
    const Tab(child: Text('Energia mecanica')),
    const Tab(child: Text('Ley conservacion de la energia mecanica')),
  ];

  List<Widget> tabsContent = [
    Container(child: Image.asset('assets/images/formula1_f10.png')),
    Container(child: Image.asset('assets/images/formula2_f10.png')),
    Container(child: Image.asset('assets/images/formula3_f10.png')),
    Container(child: Image.asset('assets/images/formula4_f10.png')),
    Container(child: Image.asset('assets/images/formula5_f10.png')),
    Container(child: Image.asset('assets/images/formula6_f10.png')),
    Container(child: Image.asset('assets/images/formula7_f10.png')),
    Container(child: Image.asset('assets/images/formula8_f10.png')),
    Container(child: Image.asset('assets/images/formula9_f10.png')),
    Container(child: Image.asset('assets/images/formula10_f10.png')),
    Container(child: Image.asset('assets/images/formula11_f10.png')),
    Container(child: Image.asset('assets/images/formula12_f10.png')),
    Container(child: Image.asset('assets/images/formula13_f10.png')),
    Container(child: Image.asset('assets/images/formula14_f10.png')),
    Container(child: Image.asset('assets/images/formula15_f10.png')),
    Container(child: Image.asset('assets/images/formula16_f10.png')),
    Container(child: Image.asset('assets/images/formula17_f10.png')),
    Container(child: Image.asset('assets/images/formula18_f10.png')),
    Container(child: Image.asset('assets/images/formula19_f10.png')),
    Container(child: Image.asset('assets/images/formula20_f10.png')),
    Container(child: Image.asset('assets/images/formula21_f10.png')),
    Container(child: Image.asset('assets/images/formula22_f10.png')),
  ];

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: tabs.length,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Fisica 10°'),
          backgroundColor: const Color(0xff333333),
          centerTitle: true,
          brightness: Brightness.dark,
          bottom: PreferredSize(
            preferredSize: const Size.fromHeight(30),
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
