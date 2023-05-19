import 'package:flutter/material.dart';

class mate9 extends StatelessWidget {
  BuildContext? get context => null;

  List<Tab> tabs = [
    Tab(child: const Text('Numeros reales')),
    Tab(child: const Text('Teorema de Pitagoras')),
    Tab(child: const Text('Distancia entre puntos')),
    Tab(child: const Text('Grados y radianes')),
    Tab(child: const Text('Trigonometria')),
    Tab(child: const Text('Ecuaciones con trigonometria')),
    Tab(child: const Text('Ley de senos')),
    Tab(child: const Text('Funciones cuadraticas')),
  ];

  List<Widget> tabsContent = [
    Container(child: Image.asset('assets/images/formula1_m9.png')),
    Container(child: Image.asset('assets/images/formula2_m9.png')),
    Container(child: Image.asset('assets/images/formula3_m9.png')),
    Container(child: Image.asset('assets/images/formula4_m9.png')),
    Container(child: Image.asset('assets/images/formula5_m9.png')),
    Container(child: Image.asset('assets/images/formula6_m9.png')),
    Container(child: Image.asset('assets/images/formula7_m9.png')),
    Container(child: Image.asset('assets/images/formula8_m9.png')),
  ];

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: tabs.length,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Matematicas 9°'),
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
