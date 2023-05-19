import 'package:flutter/material.dart';

class mate7 extends StatelessWidget {
  BuildContext? get context => null;

  List<Tab> tabs = [
    Tab(child: const Text('Areas de los cuadrilateros')),
    Tab(child: const Text('Minimo Comun Multiplo')),
    Tab(child: const Text('Maximo Comun Divisor')),
    Tab(child: const Text('Divisibilidad')),
  ];

  List<Widget> tabsContent = [
    Container(child: Image.asset('assets/images/formula1_m7.png')),
    Container(child: Image.asset('assets/images/formula2_m7.png')),
    Container(child: Image.asset('assets/images/formula3_m7.png')),
    Container(child: Image.asset('assets/images/formula4_m7.png')),
  ];

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: tabs.length,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Matematicas 7°'),
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
