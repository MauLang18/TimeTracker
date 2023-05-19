import 'package:flutter/material.dart';
import 'package:formu/widget/DrawerWidget.dart';

class compuestos extends StatelessWidget {
  List<Tab> tabs = [
    const Tab(child: const Text('Radicales Compuestos')),
    const Tab(child: const Text('Radicales Simples')),
    const Tab(child: const Text('Numero de oxidacion Metales')),
    const Tab(child: const Text('Numero de oxidacion No Metales')),
  ];

  List<Widget> tabsContent = [
    Container(child: Image.asset('assets/images/quimica_RC.png')),
    Container(child: Image.asset('assets/images/quimica_RS.png')),
    Container(child: Image.asset('assets/images/quimica_OxM.png')),
    Container(child: Image.asset('assets/images/quimica_OxNM.png')),
  ];

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: tabs.length,
      child: Scaffold(
        drawer: DrawerWidget(),
        appBar: AppBar(
          title: const Text('Compuestos'),
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
