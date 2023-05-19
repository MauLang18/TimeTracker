import 'package:flutter/material.dart';

class mate10 extends StatelessWidget {
  BuildContext? get context => null;

  List<Tab> tabs = [
    Tab(child: const Text('Circulo y circunferencia')),
    Tab(child: const Text('Puntos en la circunferencia')),
    Tab(child: const Text('Rectas en la circunferencia')),
    Tab(child: const Text('Poligonos regulares')),
    Tab(child: const Text('Esfera')),
    Tab(child: const Text('Cilindro')),
    Tab(child: const Text('Funcion lineal')),
    Tab(child: const Text('Funcion cuadratica')),
    Tab(child: const Text('Sistema de ecuaciones')),
  ];

  List<Widget> tabsContent = [
    Container(child: Image.asset('assets/images/formula1_m10.png')),
    Container(child: Image.asset('assets/images/formula2_m10.png')),
    Container(child: Image.asset('assets/images/formula3_m10.png')),
    Container(child: Image.asset('assets/images/formula4_m10.png')),
    Container(child: Image.asset('assets/images/formula5_m10.png')),
    Container(child: Image.asset('assets/images/formula6_m10.png')),
    Container(child: Image.asset('assets/images/formula7_m10.png')),
    Container(child: Image.asset('assets/images/formula8_m10.png')),
    Container(child: Image.asset('assets/images/formula9_m10.png')),
  ];

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: tabs.length,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Matematicas 10°'),
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
