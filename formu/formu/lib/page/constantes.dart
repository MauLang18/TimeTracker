import 'package:flutter/material.dart';
import 'package:formu/widget/DrawerWidget.dart';

class constantes extends StatelessWidget {
  List<Tab> tabs = [
    const Tab(child: const Text('Constantes fisicas')),
  ];

  List<Widget> tabsContent = [
    Container(child: Image.asset('assets/images/fisica_C.png')),
  ];

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: tabs.length,
      child: Scaffold(
        drawer: DrawerWidget(),
        appBar: AppBar(
          title: const Text('Constantes'),
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
