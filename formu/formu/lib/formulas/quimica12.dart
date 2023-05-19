import 'package:flutter/material.dart';

class quimica12 extends StatelessWidget {
  BuildContext? get context => null;

  List<Tab> tabs = [
    Tab(child: const Text('Oxidos metalicos')),
    Tab(child: const Text('Oxidos no metalicos')),
    Tab(child: const Text('Hidroxidos')),
    Tab(child: const Text('Hidruros')),
    Tab(child: const Text('Hidracidos')),
    Tab(child: const Text('Oxacidos')),
    Tab(child: const Text('Sales binarias')),
    Tab(child: const Text('Sales ternarias')),
    Tab(child: const Text('Sales de amonio ternarias')),
    Tab(child: const Text('Sales de amonio cuaternarias')),
    Tab(child: const Text('Unidad fisica porcentaje masa/masa Caso A')),
    Tab(child: const Text('Unidad fisica porcentaje masa/masa Caso B')),
    Tab(child: const Text('Unidad fisica porcentaje masa/masa Caso C')),
    Tab(child: const Text('Unidad fisica porcentaje masa/volumen Caso A')),
    Tab(child: const Text('Unidad fisica porcentaje masa/volumen Caso B')),
    Tab(child: const Text('Unidad fisica porcentaje volumen/volumen')),
  ];

  List<Widget> tabsContent = [
    Container(child: Image.asset('assets/images/formula1_q12.png')),
    Container(child: Image.asset('assets/images/formula2_q12.png')),
    Container(child: Image.asset('assets/images/formula3_q12.png')),
    Container(child: Image.asset('assets/images/formula4_q12.png')),
    Container(child: Image.asset('assets/images/formula5_q12.png')),
    Container(child: Image.asset('assets/images/formula6_q12.png')),
    Container(child: Image.asset('assets/images/formula7_q12.png')),
    Container(child: Image.asset('assets/images/formula8_q12.png')),
    Container(child: Image.asset('assets/images/formula9_q12.png')),
    Container(child: Image.asset('assets/images/formula10_q12.png')),
    Container(child: Image.asset('assets/images/formula11_q12.png')),
    Container(child: Image.asset('assets/images/formula12_q12.png')),
    Container(child: Image.asset('assets/images/formula13_q12.png')),
    Container(child: Image.asset('assets/images/formula14_q12.png')),
    Container(child: Image.asset('assets/images/formula15_q12.png')),
    Container(child: Image.asset('assets/images/formula16_q12.png')),
  ];

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: tabs.length,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Quimica 12°'),
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
