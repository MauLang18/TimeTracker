import 'package:flutter/material.dart';

class temperatura extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return temperaturaState();
  }
}

class temperaturaState extends State<temperatura> {
  var items = [
    'Celsius(C)',
    'Fahrenheit(F)',
    'Kelvin(K)',
  ];

  String valor = "";
  String valo = 'F=((9*C)/5)+32';
  String va = "";

  String? selectedItem = 'Celsius(C)';

  String? selectedItem2 = 'Fahrenheit(F)';

  String valueChoose = "";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFE1F4F3),
      appBar: AppBar(
        title: const Text('Temperatura'),
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
  var va;

  switch (selectedItem) {
    case 'Celsius(C)':
      switch (selectedItem2) {
        case 'Celsius(C)':
          va = 1.0;
          break;
        case 'Fahrenheit(F)':
          va = 'F=((9*C)/5)+32';
          break;
        case 'Kelvin(K)':
          va = 'K=C+273.15';
          break;
      }
      break;
    case 'Fahrenheit(F)':
      switch (selectedItem2) {
        case 'Celsius(C)':
          va = 'C=(5*(F-32))/9';
          break;
        case 'Fahrenheit(F)':
          va = 1.0;
          break;
        case 'Kelvin(K)':
          va = 'K=((5*(F-32))/9)+273.15';
          break;
      }
      break;
    case 'Kelvin(K)':
      switch (selectedItem2) {
        case 'Celsius(C)':
          va = 'C=K-273.15';
          break;
        case 'Fahrenheit(F)':
          va = 'F=((9*(K-273.15))/5)+32';
          break;
        case 'Kelvin(K)':
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

  valo = double.parse(valor);

  switch (fac) {
    case '1.0':
      va = valo * 1.0;
      break;
    case 'F=((9*C)/5)+32':
      va = ((9 * valo) / 5) + 32;
      break;
    case 'K=C+273.15':
      va = valo + 273.15;
      break;
    case 'C=(5*(F-32))/9':
      va = (5 * (valo - 32)) / 9;
      break;
    case 'K=((5*(F-32))/9)+273.15':
      va = ((5 * (valo - 32)) / 9) + 273.15;
      break;
    case 'C=K-273.15':
      va = valo - 273.15;
      break;
    case 'F=((9*(K-273.15))/5)+32':
      va = ((9 * (valo - 273.15)) / 5) + 32;
      break;
  }

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
