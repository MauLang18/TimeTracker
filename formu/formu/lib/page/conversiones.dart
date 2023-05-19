import 'package:flutter/material.dart';
import 'package:formu/conversiones/longitud.dart';
import 'package:formu/conversiones/masa.dart';
import 'package:formu/conversiones/temperatura.dart';
import 'package:formu/conversiones/tiempo.dart';
import 'package:formu/conversiones/velocidad.dart';
import 'package:formu/conversiones/volumen.dart';
import 'package:formu/widget/DrawerWidget.dart';

class conversiones extends StatelessWidget {
  Card makeDashboardItem(
      String title, String img, int index, BuildContext context) {
    return Card(
      elevation: 2,
      margin: const EdgeInsets.all(8),
      child: Container(
        decoration: BoxDecoration(
            borderRadius: BorderRadius.circular(5),
            gradient: const LinearGradient(
              begin: FractionalOffset(0.0, 0.0),
              end: FractionalOffset(3.0, -1.0),
              colors: [Color(0xff00488d), Color(0xffffffff)],
            ),
            boxShadow: const [
              BoxShadow(
                color: Colors.white,
                blurRadius: 3,
                offset: Offset(2, 2),
              ),
            ]),
        child: InkWell(
          onTap: () {
            selectItem(context, index);
          },
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            mainAxisSize: MainAxisSize.min,
            verticalDirection: VerticalDirection.down,
            children: [
              const SizedBox(height: 50),
              Center(
                child: Image.asset(
                  img,
                  height: 50,
                  width: 50,
                ),
              ),
              const SizedBox(height: 20),
              Center(
                child: Text(
                  title,
                  style: const TextStyle(
                    fontSize: 19,
                    color: Colors.white,
                    fontWeight: FontWeight.bold,
                  ),
                ),
              ),
            ],
          ),
        ),
      ),
    );
  }

  @override
  Widget build(BuildContext context) => Scaffold(
        drawer: DrawerWidget(),
        backgroundColor: const Color(0xFFE1F4F3),
        appBar: AppBar(
          title: const Text('Conversiones'),
          centerTitle: true,
          backgroundColor: const Color(0xff333333),
        ),
        body: Container(
          decoration: BoxDecoration(
              image: DecorationImage(
                  image: AssetImage('assets/images/fondo6.png'),
                  fit: BoxFit.cover)),
          child: Column(
            children: [
              const SizedBox(height: 100),
              Padding(
                padding: const EdgeInsets.only(left: 16, right: 16),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.spaceBetween,
                  children: [
                    Column(
                      crossAxisAlignment: CrossAxisAlignment.start,
                      /*children: const [
                        Text(
                          'Button',
                          style: TextStyle(
                            fontSize: 20,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                        Text(
                          'Button2',
                          style: TextStyle(
                            fontSize: 18,
                            fontWeight: FontWeight.bold,
                          ),
                        ),
                      ],*/
                    )
                  ],
                ),
              ),
              const SizedBox(height: 20),
              Expanded(
                child: GridView.count(
                  crossAxisCount: 2,
                  padding: const EdgeInsets.all(2),
                  children: [
                    makeDashboardItem(
                        'Longitud', 'assets/icon/longitud.png', 0, context),
                    makeDashboardItem(
                        'Masa', 'assets/icon/masa.png', 1, context),
                    makeDashboardItem(
                        'Velocidad', 'assets/icon/velocidad.png', 2, context),
                    makeDashboardItem(
                        'Tiempo', 'assets/icon/tiempo.png', 3, context),
                    makeDashboardItem('Temperatura',
                        'assets/icon/temperatura.png', 4, context),
                    makeDashboardItem(
                        'Volumen', 'assets/icon/volumen.png', 5, context),
                  ],
                ),
              ),
            ],
          ),
        ),
      );

  void selectItem(BuildContext context, int index) {
    final navigateTo =
        (conversiones) => Navigator.of(context).push(MaterialPageRoute(
              builder: (context) => conversiones,
            ));

    //Navigator.of(context).pop();

    switch (index) {
      case 0:
        navigateTo(longitud());
        break;
      case 1:
        navigateTo(masa());
        break;
      case 2:
        navigateTo(velocidad());
        break;
      case 3:
        navigateTo(tiempo());
        break;
      case 4:
        navigateTo(temperatura());
        break;
      case 5:
        navigateTo(volumen());
        break;
    }
  }
}
