import 'package:flutter/material.dart';

class fisica11 extends StatelessWidget {
  BuildContext? get context => null;

  List<Tab> tabs = [
    Tab(child: const Text('Densidad')),
    Tab(child: const Text('Presion hidrostatica')),
    Tab(child: const Text('Presion total')),
    Tab(child: const Text('Prensa hidraulica')),
    Tab(child: const Text('Fuerza de empuje')),
    Tab(child: const Text('Masa aparente')),
    Tab(child: const Text('Peso aparente')),
    Tab(child: const Text('Cargas electricas')),
    Tab(child: const Text('Ley de Coulomb')),
    Tab(child: const Text('Campo electrico')),
    Tab(child: const Text('Diferencia de potencial o voltaje')),
    Tab(child: const Text('Corriente electrica')),
    Tab(child: const Text('Ley de Ohm')),
    Tab(child: const Text('Potencia')),
    Tab(child: const Text('Circuito en serie')),
    Tab(child: const Text('Circuito en paralelo')),
    Tab(child: const Text('Campo magnetico bobina')),
    Tab(child: const Text('Campo magnetico solenoide')),
    Tab(child: const Text('Campo magnetico conductor')),
    Tab(child: const Text('Velocidad de la onda')),
    Tab(child: const Text('Dilatacion del tiempo')),
    Tab(child: const Text('Contraccion de la longitud')),
    Tab(child: const Text('Aumento de la masa con la velocidad')),
    Tab(child: const Text('Energia en reposo')),
  ];

  List<Widget> tabsContent = [
    Container(child: Image.asset('assets/images/formula1_f11.png')),
    Container(child: Image.asset('assets/images/formula2_f11.png')),
    Container(child: Image.asset('assets/images/formula3_f11.png')),
    Container(child: Image.asset('assets/images/formula4_f11.png')),
    Container(child: Image.asset('assets/images/formula5_f11.png')),
    Container(child: Image.asset('assets/images/formula6_f11.png')),
    Container(child: Image.asset('assets/images/formula7_f11.png')),
    Container(child: Image.asset('assets/images/formula8_f11.png')),
    Container(child: Image.asset('assets/images/formula9_f11.png')),
    Container(child: Image.asset('assets/images/formula10_f11.png')),
    Container(child: Image.asset('assets/images/formula11_f11.png')),
    Container(child: Image.asset('assets/images/formula12_f11.png')),
    Container(child: Image.asset('assets/images/formula13_f11.png')),
    Container(child: Image.asset('assets/images/formula14_f11.png')),
    Container(child: Image.asset('assets/images/formula15_f11.png')),
    Container(child: Image.asset('assets/images/formula16_f11.png')),
    Container(child: Image.asset('assets/images/formula17_f11.png')),
    Container(child: Image.asset('assets/images/formula18_f11.png')),
    Container(child: Image.asset('assets/images/formula19_f11.png')),
    Container(child: Image.asset('assets/images/formula20_f11.png')),
    Container(child: Image.asset('assets/images/formula21_f11.png')),
    Container(child: Image.asset('assets/images/formula22_f11.png')),
    Container(child: Image.asset('assets/images/formula23_f11.png')),
    Container(child: Image.asset('assets/images/formula24_f11.png')),
  ];

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: tabs.length,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Fisica 11°'),
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
