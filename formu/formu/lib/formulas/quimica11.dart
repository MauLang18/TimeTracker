import 'package:flutter/material.dart';

class quimica11 extends StatelessWidget {
  BuildContext? get context => null;

  List<Tab> tabs = [
    Tab(child: const Text('Numero atomico y numero masico')),
    Tab(child: const Text('Masa molecular y formular')),
    Tab(child: const Text('Formula empirica')),
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
  ];

  List<Widget> tabsContent = [
    Container(child: Image.asset('assets/images/formula1_q11.png')),
    Container(child: Image.asset('assets/images/formula2_q11.png')),
    Container(child: Image.asset('assets/images/formula3_q11.png')),
    Container(child: Image.asset('assets/images/formula4_q11.png')),
    Container(child: Image.asset('assets/images/formula5_q11.png')),
    Container(child: Image.asset('assets/images/formula6_q11.png')),
    Container(child: Image.asset('assets/images/formula7_q11.png')),
    Container(child: Image.asset('assets/images/formula8_q11.png')),
    Container(child: Image.asset('assets/images/formula9_q11.png')),
    Container(child: Image.asset('assets/images/formula10_q11.png')),
    Container(child: Image.asset('assets/images/formula11_q11.png')),
    Container(child: Image.asset('assets/images/formula12_q11.png')),
    Container(child: Image.asset('assets/images/formula13_q11.png')),
  ];

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: tabs.length,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Quimica 11°'),
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
