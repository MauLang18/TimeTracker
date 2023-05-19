import 'package:flutter/material.dart';

class velocidad extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return velocidadState();
  }
}

class velocidadState extends State<velocidad> {
  var items = [
    'Kilometros/hora(Km/h)',
    'Metros/segundo(m/s)',
    'Millas/hora(mph)',
    'Pies/segundos(ft/s)'
  ];

  String valor = "";
  String valo = '0.2777777777777778';
  String va = "";

  String? selectedItem = 'Kilometros/hora(Km/h)';

  String? selectedItem2 = 'Metros/segundo(m/s)';

  String valueChoose = "";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFE1F4F3),
      appBar: AppBar(
        title: const Text('Velocidad'),
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
                      style: const TextStyle(fontSize: 16.5),
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
                      style: const TextStyle(fontSize: 16.5),
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
  var va = 0.2777777777777778;

  switch (selectedItem) {
    case 'Kilometros/hora(Km/h)':
      switch (selectedItem2) {
        case 'Kilometros/hora(Km/h)':
          va = 1.0;
          break;
        case 'Metros/segundo(m/s)':
          va = 0.2777777777777778;
          break;
        case 'Millas/hora(mph)':
          va = 0.621371192237334;
          break;
        case 'Pies/segundos(ft/s)':
          va = 0.09113460763817374;
          break;
      }
      break;
    case 'Metros/segundo(m/s)':
      switch (selectedItem2) {
        case 'Kilometros/hora(Km/h)':
          va = 3.6;
          break;
        case 'Metros/segundo(m/s)':
          va = 1.0;
          break;
        case 'Millas/hora(mph)':
          va = 2.236936290544025;
          break;
        case 'Pies/segundos(ft/s)':
          va = 3.280839895013123;
          break;
      }
      break;
    case 'Millas/hora(mph)':
      switch (selectedItem2) {
        case 'Kilometros/hora(Km/h)':
          va = 1.609344;
          break;
        case 'Metros/segundo(m/s)':
          va = 0.44704;
          break;
        case 'Millas/hora(mph)':
          va = 1.0;
          break;
        case 'Pies/segundos(ft/s)':
          va = 1.4666666666666666;
          break;
      }
      break;
    case 'Pies/segundos(ft/s)':
      switch (selectedItem2) {
        case 'Kilometros/hora(Km/h)':
          va = 1.097278;
          break;
        case 'Metros/segundo(m/s)':
          va = 0.3048;
          break;
        case 'Millas/hora(mph)':
          va = 0.6818181818181819;
          break;
        case 'Pies/segundos(ft/s)':
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
