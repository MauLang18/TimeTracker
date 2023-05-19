import 'package:flutter/material.dart';

class mate8 extends StatelessWidget {
  BuildContext? get context => null;

  List<Tab> tabs = [
    Tab(child: const Text('Numeros racionales')),
    Tab(child: const Text('Homotecia')),
    Tab(child: const Text('Congruencia de triangulos')),
    Tab(child: const Text('Semejanza de triangulos')),
    Tab(child: const Text('Valor numerico de una expresion algebraica')),
    Tab(child: const Text('Monomio y sus partes')),
    Tab(child: const Text('Multiplicacion de Polinomios')),
    Tab(child: const Text('Productos notables')),
    Tab(child: const Text('Ecuaciones')),
    Tab(child: const Text('Lenguaje algebraico')),
    Tab(child: const Text('Potencias')),
    Tab(child: const Text('Raiz n-esimas de un numero racional')),
  ];

  List<Widget> tabsContent = [
    Container(child: Image.asset('assets/images/formula1_m8.png')),
    Container(child: Image.asset('assets/images/formula2_m8.png')),
    Container(child: Image.asset('assets/images/formula3_m8.png')),
    Container(child: Image.asset('assets/images/formula4_m8.png')),
    Container(child: Image.asset('assets/images/formula5_m8.png')),
    Container(child: Image.asset('assets/images/formula6_m8.png')),
    Container(child: Image.asset('assets/images/formula7_m8.png')),
    Container(child: Image.asset('assets/images/formula8_m8.png')),
    Container(child: Image.asset('assets/images/formula9_m8.png')),
    Container(child: Image.asset('assets/images/formula10_m8.png')),
    Container(child: Image.asset('assets/images/formula11_m8.png')),
    Container(child: Image.asset('assets/images/formula12_m8.png')),
  ];

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: tabs.length,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Matematicas 8°'),
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
