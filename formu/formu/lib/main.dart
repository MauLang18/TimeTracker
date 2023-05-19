import 'package:curved_navigation_bar/curved_navigation_bar.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:formu/provider/NavigationProvider.dart';
import 'package:formu/formulas/fisica10.dart';
import 'package:formu/formulas/fisica11.dart';
import 'package:formu/formulas/mate10.dart';
import 'package:formu/formulas/mate11.dart';
import 'package:formu/formulas/mate12.dart';
import 'package:formu/formulas/mate8.dart';
import 'package:formu/formulas/mate7.dart';
import 'package:formu/formulas/mate9.dart';
import 'package:formu/formulas/quimica11.dart';
import 'package:formu/formulas/quimica12.dart';
import 'package:liquid_swipe/liquid_swipe.dart';
import 'package:provider/provider.dart';

import 'widget/DrawerWidget.dart';

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await SystemChrome.setPreferredOrientations([DeviceOrientation.portraitUp]);

  runApp(MyApp());
}

Future initialization(BuildContext? context) async {
  await Future.delayed(const Duration(seconds: 2));
}

class MyApp extends StatelessWidget {
  MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) => ChangeNotifierProvider(
      create: (context) => NavigationProvider(),
      child: const MaterialApp(
        debugShowCheckedModeBanner: false,
        title: "Formu",
        home: Home(),
      ));
}

class Home extends StatefulWidget {
  const Home({Key? key}) : super(key: key);

  @override
  _HomeState createState() => _HomeState();
}

class _HomeState extends State<Home> {
  int index = 0;

  get controller => null;

  @override
  Widget build(BuildContext context) {
    final items = <Widget>[
      Icon(
        Icons.seven_mp,
        size: 30,
        color: Colors.white,
      ),
      Icon(
        Icons.eight_mp,
        size: 30,
        color: Colors.white,
      ),
      Icon(
        Icons.nine_mp,
        size: 30,
        color: Colors.white,
      ),
      Icon(
        Icons.ten_mp,
        size: 30,
        color: Colors.white,
      ),
      Icon(
        Icons.eleven_mp,
        size: 30,
        color: Colors.white,
      ),
      Icon(
        Icons.twelve_mp,
        size: 30,
        color: Colors.white,
      )
    ];

    final controller = LiquidController();

    final conta = <Widget>[
      iconSeptimo(),
      iconOctavo(),
      iconNoveno(),
      iconDecimo(),
      iconUndecimo(),
      iconDuodecimo(),
    ];

    final texto = <Text>[
      const Text('Septimo'),
      const Text('Octavo'),
      const Text('Noveno'),
      const Text('Decimo'),
      const Text('Undecimo'),
      const Text('Duodecimo'),
    ];

    return Scaffold(
      extendBody: true,
      drawer: DrawerWidget(),
      appBar: AppBar(
        backgroundColor: const Color(0xff333333),
        title: texto[index],
        centerTitle: true,
      ),
      body: conta[index],
      bottomNavigationBar: CurvedNavigationBar(
        color: const Color(0xff333333),
        backgroundColor: Colors.transparent,
        height: 60,
        index: index,
        items: items,
        onTap: (index) => setState(() => this.index = index),
      ),
      backgroundColor: const Color(0xFFE1F4F3),
    );
  }

  Widget iconSeptimo() {
    return Stack(
      children: [
        LiquidSwipe(
            liquidController: controller,
            enableSideReveal: true,
            slideIconWidget:
                const Icon(Icons.arrow_back_ios, color: Colors.white),
            pages: [
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo5.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnMate7()],
                      )
                    ],
                  )),
              Container(
                decoration: BoxDecoration(
                    image: DecorationImage(
                        image: AssetImage('assets/images/fondo3.png'),
                        fit: BoxFit.cover)),
                child: Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  mainAxisSize: MainAxisSize.max,
                  children: [
                    Column(
                      mainAxisAlignment: MainAxisAlignment.center,
                      mainAxisSize: MainAxisSize.max,
                      children: [btnFisica7()],
                    )
                  ],
                ),
              ),
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo4.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnQuimica7()],
                      )
                    ],
                  )),
            ]),
        Positioned(
            bottom: 0,
            left: 16,
            right: 32,
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                //TextButton(onPressed: () {}, child: const Text('Atras')),
                //TextButton(onPressed: () {}, child: const Text('Siguiente'))
              ],
            )),
      ],
    );
  }

  Widget iconOctavo() {
    return Stack(
      children: [
        LiquidSwipe(
            liquidController: controller,
            enableSideReveal: true,
            slideIconWidget:
                const Icon(Icons.arrow_back_ios, color: Colors.white),
            pages: [
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo5.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnMate8()],
                      )
                    ],
                  )),
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo3.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnFisica8()],
                      )
                    ],
                  )),
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo4.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnQuimica8()],
                      )
                    ],
                  )),
            ]),
        Positioned(
            bottom: 0,
            left: 16,
            right: 32,
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                //TextButton(onPressed: () {}, child: const Text('Atras')),
                //TextButton(onPressed: () {}, child: const Text('Siguiente'))
              ],
            )),
      ],
    );
  }

  Widget iconNoveno() {
    return Stack(
      children: [
        LiquidSwipe(
            liquidController: controller,
            enableSideReveal: true,
            slideIconWidget:
                const Icon(Icons.arrow_back_ios, color: Colors.white),
            pages: [
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo5.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnMate9()],
                      )
                    ],
                  )),
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo3.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnFisica9()],
                      )
                    ],
                  )),
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo4.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnQuimica9()],
                      )
                    ],
                  )),
            ]),
        Positioned(
            bottom: 0,
            left: 16,
            right: 32,
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                //TextButton(onPressed: () {}, child: const Text('Atras')),
                //TextButton(onPressed: () {}, child: const Text('Siguiente'))
              ],
            )),
      ],
    );
  }

  Widget iconDecimo() {
    return Stack(
      children: [
        LiquidSwipe(
            liquidController: controller,
            enableSideReveal: true,
            slideIconWidget:
                const Icon(Icons.arrow_back_ios, color: Colors.white),
            pages: [
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo5.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnMate10()],
                      )
                    ],
                  )),
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo3.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnFisica10()],
                      )
                    ],
                  )),
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo4.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnQuimica10()],
                      )
                    ],
                  )),
            ]),
        Positioned(
            bottom: 0,
            left: 16,
            right: 32,
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                //TextButton(onPressed: () {}, child: const Text('Atras')),
                //TextButton(onPressed: () {}, child: const Text('Siguiente'))
              ],
            )),
      ],
    );
  }

  Widget iconUndecimo() {
    return Stack(
      children: [
        LiquidSwipe(
            liquidController: controller,
            enableSideReveal: true,
            slideIconWidget:
                const Icon(Icons.arrow_back_ios, color: Colors.white),
            pages: [
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo5.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnMate11()],
                      )
                    ],
                  )),
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo3.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnFisica11()],
                      )
                    ],
                  )),
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo4.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnQuimica11()],
                      )
                    ],
                  )),
            ]),
        Positioned(
            bottom: 0,
            left: 16,
            right: 32,
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                //TextButton(onPressed: () {}, child: const Text('Atras')),
                //TextButton(onPressed: () {}, child: const Text('Siguiente'))
              ],
            )),
      ],
    );
  }

  Widget iconDuodecimo() {
    return Stack(
      children: [
        LiquidSwipe(
            liquidController: controller,
            enableSideReveal: true,
            slideIconWidget:
                const Icon(Icons.arrow_back_ios, color: Colors.white),
            pages: [
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo5.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnMate12()],
                      )
                    ],
                  )),
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo3.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnFisica12()],
                      )
                    ],
                  )),
              Container(
                  decoration: BoxDecoration(
                      image: DecorationImage(
                          image: AssetImage('assets/images/fondo4.png'),
                          fit: BoxFit.cover)),
                  child: Row(
                    mainAxisAlignment: MainAxisAlignment.center,
                    mainAxisSize: MainAxisSize.max,
                    children: [
                      Column(
                        mainAxisAlignment: MainAxisAlignment.center,
                        mainAxisSize: MainAxisSize.max,
                        children: [btnQuimica12()],
                      )
                    ],
                  )),
            ]),
        Positioned(
            bottom: 0,
            left: 16,
            right: 32,
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                //TextButton(onPressed: () {}, child: const Text('Atras')),
                //TextButton(onPressed: () {}, child: const Text('Siguiente'))
              ],
            )),
      ],
    );
  }

  Widget btnMate7() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: () {
        Navigator.push(
            context, MaterialPageRoute(builder: (context) => mate7()));
      },
      child: const Text(
        'Matematicas',
        style: TextStyle(fontSize: 18),
      ),
    );
  }

  Widget btnFisica7() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: null,
      child: const Text(
        'Fisica',
        style:
            TextStyle(color: Color.fromARGB(255, 148, 148, 148), fontSize: 18),
      ),
    );
  }

  Widget btnQuimica7() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: null,
      child: const Text('Quimica',
          style: TextStyle(
              color: Color.fromARGB(255, 148, 148, 148), fontSize: 18)),
    );
  }

  Widget btnMate8() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: () {
        Navigator.push(
            context, MaterialPageRoute(builder: (context) => mate8()));
      },
      child: const Text(
        'Matematicas',
        style: TextStyle(fontSize: 18),
      ),
    );
  }

  Widget btnFisica8() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: null,
      child: const Text(
        'Fisica',
        style:
            TextStyle(color: Color.fromARGB(255, 148, 148, 148), fontSize: 18),
      ),
    );
  }

  Widget btnQuimica8() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: null,
      child: const Text('Quimica',
          style: TextStyle(
              color: Color.fromARGB(255, 148, 148, 148), fontSize: 18)),
    );
  }

  Widget btnMate9() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: () {
        Navigator.push(
            context, MaterialPageRoute(builder: (context) => mate9()));
      },
      child: const Text(
        'Matematicas',
        style: TextStyle(fontSize: 18),
      ),
    );
  }

  Widget btnFisica9() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: null,
      child: const Text('Fisica',
          style: TextStyle(
              color: Color.fromARGB(255, 148, 148, 148), fontSize: 18)),
    );
  }

  Widget btnQuimica9() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: null,
      child: const Text('Quimica',
          style: TextStyle(
              color: Color.fromARGB(255, 148, 148, 148), fontSize: 18)),
    );
  }

  Widget btnMate10() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: () {
        Navigator.push(
            context, MaterialPageRoute(builder: (context) => mate10()));
      },
      child: const Text(
        'Matematicas',
        style: TextStyle(fontSize: 18),
      ),
    );
  }

  Widget btnFisica10() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: () {
        Navigator.push(
            context, MaterialPageRoute(builder: (context) => fisica10()));
      },
      child: const Text(
        'Fisica',
        style: TextStyle(fontSize: 18),
      ),
    );
  }

  Widget btnQuimica10() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: null,
      child: const Text('Quimica',
          style: TextStyle(
              color: Color.fromARGB(255, 148, 148, 148), fontSize: 18)),
    );
  }

  Widget btnMate11() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: () {
        Navigator.push(
            context, MaterialPageRoute(builder: (context) => mate11()));
      },
      child: const Text(
        'Matematicas',
        style: TextStyle(fontSize: 18),
      ),
    );
  }

  Widget btnFisica11() {
    return ElevatedButton(
        style: ButtonStyle(
          backgroundColor:
              getColor(const Color(0xff333333), const Color(0xff706C61)),
        ),
        onPressed: () {
          Navigator.push(
              context, MaterialPageRoute(builder: (context) => fisica11()));
        },
        child: const Text(
          'Fisica',
          style: TextStyle(fontSize: 18),
        ));
  }

  Widget btnQuimica11() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: () {
        Navigator.push(
            context, MaterialPageRoute(builder: (context) => quimica11()));
      },
      child: const Text(
        'Quimica',
        style: TextStyle(fontSize: 18),
      ),
    );
  }

  Widget btnMate12() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: () {
        Navigator.push(
            context, MaterialPageRoute(builder: (context) => mate12()));
      },
      child: const Text(
        'Matematicas',
        style: TextStyle(fontSize: 18),
      ),
    );
  }

  Widget btnFisica12() {
    return ElevatedButton(
      style: ButtonStyle(
        backgroundColor:
            getColor(const Color(0xff333333), const Color(0xff706C61)),
      ),
      onPressed: null,
      child: const Text(
        'Fisica',
        style:
            TextStyle(color: Color.fromARGB(255, 148, 148, 148), fontSize: 18),
      ),
    );
  }

  Widget btnQuimica12() {
    return ElevatedButton(
        style: ButtonStyle(
          backgroundColor:
              getColor(const Color(0xff333333), const Color(0xff706C61)),
        ),
        onPressed: () {
          Navigator.push(
              context, MaterialPageRoute(builder: (context) => quimica12()));
        },
        child: const Text(
          'Quimica',
          style: TextStyle(fontSize: 18),
        ));
  }
}

MaterialStateProperty<Color> getColor(Color color, Color colorPressed) {
  final getColor = (Set<MaterialState> states) {
    if (states.contains(MaterialState.pressed)) {
      return colorPressed;
    } else {
      return color;
    }
  };

  return MaterialStateProperty.resolveWith(getColor);
}
