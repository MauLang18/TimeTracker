import 'package:flutter/material.dart';

class tiempo extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return tiempoState();
  }
}

class tiempoState extends State<tiempo> {
  var items = [
    'Segundos(s)',
    'Minuto',
    'Hora(h)',
    'Dia',
    'Semana',
    'Mes',
    'Año'
  ];

  String valor = "";
  String valo = '0.0002777777777777778';
  String va = "";

  String? selectedItem = 'Segundos(s)';

  String? selectedItem2 = 'Hora(h)';

  String valueChoose = "";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFE1F4F3),
      appBar: AppBar(
        title: const Text('Tiempo'),
        centerTitle: true,
        backgroundColor: const Color(0xff333333),
      ),
      body: Container(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Row(
              children: [
                Container(
                  width: MediaQuery.of(context).size.width * 0.5,
                  child: inputValor1(),
                ),
                Container(
                  width: MediaQuery.of(context).size.width * 0.5,
                  child: spinner1(),
                ),
              ],
            ),
            const SizedBox(height: 35),
            Row(
              children: [
                Container(
                  width: MediaQuery.of(context).size.width * 0.5,
                  child: inputValor2(),
                ),
                Container(
                  width: MediaQuery.of(context).size.width * 0.5,
                  child: spinner2(),
                ),
              ],
            ),
            SizedBox(height: 20),
            Container(
              child: const Text('Factor de conversion:',
                  style: TextStyle(fontSize: 18)),
            ),
            Container(
              child: Text(valo, style: const TextStyle(fontSize: 18)),
            ),
            SizedBox(height: 20),
            Container(
              child: boton(),
            )
          ],
        ),
      ),
    );
  }

  Container inputValor1() {
    return Container(
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(5),
        border: Border.all(color: Colors.grey),
      ),
      padding: const EdgeInsets.symmetric(horizontal: 20),
      margin: const EdgeInsets.symmetric(horizontal: 20),
      child: TextField(
          style: const TextStyle(fontSize: 20),
          keyboardType: TextInputType.number,
          decoration: const InputDecoration(border: InputBorder.none),
          onChanged: (value) {
            valor = value;
            print(valor);

            /*if (!(valor != null)) {
              print('nulo carepicha');
              valor = '0';
              print(valor);
            }*/

            //va = conver(valor, valo);
          }),
    );
  }

  Container inputValor2() {
    return Container(
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(5),
        border: Border.all(color: Colors.grey),
      ),
      padding: const EdgeInsets.symmetric(horizontal: 20),
      margin: const EdgeInsets.symmetric(horizontal: 20),
      child: Text(va, style: const TextStyle(fontSize: 20)),
    );
  }

  Widget boton() {
    return Center(
      child: GestureDetector(
        onTapDown: (_) => va = conver(valor, valo),
        onTapUp: (_) => FocusScope.of(context).unfocus(),
        child: Container(
          padding: const EdgeInsets.symmetric(vertical: 10, horizontal: 20),
          decoration: const BoxDecoration(
            color: Colors.black87,
            //borderRadius: BorderRadius.circular(10.0),
          ),
          child: const Text("Convertir",
              style: TextStyle(
                color: Colors.white,
                fontSize: 18,
              )),
        ),
      ),
    );
  }

  Container spinner1() {
    return Container(
      //padding: const EdgeInsets.symmetric(horizontal: 20),
      //margin: const EdgeInsets.symmetric(horizontal: 20),
      child: DropdownButton<String>(
          value: selectedItem,
          items: items
              .map((item) => DropdownMenuItem(
                    value: item,
                    child: Text(
                      item,
                      style: const TextStyle(fontSize: 24),
                    ),
                  ))
              .toList(),
          onChanged: (item) => {
                setState(() => selectedItem = item),
                valo = dat(selectedItem, selectedItem2),
              }),
    );
  }

  Container spinner2() {
    return Container(
      //padding: const EdgeInsets.symmetric(horizontal: 20),
      //margin: const EdgeInsets.symmetric(horizontal: 20),
      child: DropdownButton<String>(
          value: selectedItem2,
          items: items
              .map((item) => DropdownMenuItem(
                    value: item,
                    child: Text(
                      item,
                      style: const TextStyle(fontSize: 24),
                    ),
                  ))
              .toList(),
          onChanged: (item) => {
                setState(() => selectedItem2 = item),
                valo = dat(selectedItem, selectedItem2),
              }),
    );
  }
}

String dat(String? selectedItem, String? selectedItem2) {
  var va = 0.0002777777777777778;

  switch (selectedItem) {
    case 'Segundos(s)':
      switch (selectedItem2) {
        case 'Segundos(s)':
          va = 1.0;
          break;
        case 'Minuto':
          va = 0.016666666666666666;
          break;
        case 'Hora(h)':
          va = 0.0002777777777777778;
          break;
        case 'Dia':
          va = 0.000011574074074074073;
          break;
        case 'Semana':
          va = 0.0000016534391534391535;
          break;
        case 'Mes':
          va = 3.8051750380517503e-7;
          break;
        case 'Año':
          va = 3.1709791983764586e-8;
          break;
      }
      break;
    case 'Minuto':
      switch (selectedItem2) {
        case 'Segundos(s)':
          va = 60.0;
          break;
        case 'Minuto':
          va = 1.0;
          break;
        case 'Hora(h)':
          va = 0.016666666666666666;
          break;
        case 'Dia':
          va = 0.0006944444444444445;
          break;
        case 'Semana':
          va = 0.0000992063492063492;
          break;
        case 'Mes':
          va = 0.000022831050228310503;
          break;
        case 'Año':
          va = 0.0000019025875190258753;
          break;
      }
      break;
    case 'Hora(h)':
      switch (selectedItem2) {
        case 'Segundos(s)':
          va = 3600.0;
          break;
        case 'Minuto':
          va = 60.0;
          break;
        case 'Hora(h)':
          va = 1.0;
          break;
        case 'Dia':
          va = 0.041666666666666664;
          break;
        case 'Semana':
          va = 0.005952380952380952;
          break;
        case 'Mes':
          va = 0.0013698630136986301;
          break;
        case 'Año':
          va = 0.00011415525114155251;
          break;
      }
      break;
    case 'Dia':
      switch (selectedItem2) {
        case 'Segundos(s)':
          va = 86400.0;
          break;
        case 'Minuto':
          va = 4320.0;
          break;
        case 'Hora(h)':
          va = 24.0;
          break;
        case 'Dia':
          va = 1.0;
          break;
        case 'Semana':
          va = 0.14285714285714285;
          break;
        case 'Mes':
          va = 0.03287671232876712;
          break;
        case 'Año':
          va = 0.00273972602739726;
          break;
      }
      break;
    case 'Semana':
      switch (selectedItem2) {
        case 'Segundos(s)':
          va = 604800.0;
          break;
        case 'Minuto':
          va = 10080.0;
          break;
        case 'Hora(h)':
          va = 168.0;
          break;
        case 'Dia':
          va = 7.0;
          break;
        case 'Semana':
          va = 1.0;
          break;
        case 'Mes':
          va = 0.23013698630136986;
          break;
        case 'Año':
          va = 0.019178082191780823;
          break;
      }
      break;
    case 'Mes':
      switch (selectedItem2) {
        case 'Segundos(s)':
          va = 2628000.0;
          break;
        case 'Minuto':
          va = 43800.0;
          break;
        case 'Hora(h)':
          va = 730.0;
          break;
        case 'Dia':
          va = 30.416666666666668;
          break;
        case 'Semana':
          va = 4.345238095238096;
          break;
        case 'Mes':
          va = 1.0;
          break;
        case 'Año':
          va = 0.08333333333333333;
          break;
      }
      break;
    case 'Año':
      switch (selectedItem2) {
        case 'Segundos(s)':
          va = 31536000.0;
          break;
        case 'Minuto':
          va = 525600.0;
          break;
        case 'Hora(h)':
          va = 8760.0;
          break;
        case 'Dia':
          va = 365.0;
          break;
        case 'Semana':
          va = 52.142857142857146;
          break;
        case 'Mes':
          va = 12.0;
          break;
        case 'Año':
          va = 1.0;
          break;
      }
      break;
  }

  var g = va.toString();

  print(va);
  return g;
}

String conver(String valor, String fac) {
  var va = 0.0;

  double valo = 0.0;
  double fact = double.parse(fac);

  if (valor == null) {
    valo = 0.0;
  }

  valo = double.parse(valor);

  va = valo * fact;

  var g = va.toString();

  print(va);
  return g;
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
