import 'package:flutter/material.dart';

class masa extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return masaState();
  }
}

class masaState extends State<masa> {
  var items = ['Gramos(g)', 'Kilogramos(Kg)', 'Onzas(oz)', 'Libras(lb)'];

  String valor = "";
  String valo = '0.001';
  String va = "";

  String? selectedItem = 'Gramos(g)';

  String? selectedItem2 = 'Kilogramos(Kg)';

  String valueChoose = "";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFE1F4F3),
      appBar: AppBar(
        title: const Text('Masa'),
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
  var va = 0.001;

  switch (selectedItem) {
    case 'Gramos(g)':
      switch (selectedItem2) {
        case 'Gramos(g)':
          va = 1.0;
          break;
        case 'Kilogramos(Kg)':
          va = 0.001;
          break;
        case 'Onzas(oz)':
          va = 0.035273961948999996;
          break;
        case 'Libras(lb)':
          va = 0.002204622621848776;
          break;
      }
      break;
    case 'Kilogramos(Kg)':
      switch (selectedItem2) {
        case 'Gramos(g)':
          va = 1000.0;
          break;
        case 'Kilogramos(Kg)':
          va = 1.0;
          break;
        case 'Onzas(oz)':
          va = 35.273961949;
          break;
        case 'Libras(lb)':
          va = 02.2046226218487757;
          break;
      }
      break;
    case 'Onzas(oz)':
      switch (selectedItem2) {
        case 'Gramos(g)':
          va = 28.349523125;
          break;
        case 'Kilogramos(Kg)':
          va = 0.028349523125;
          break;
        case 'Onzas(oz)':
          va = 1.0;
          break;
        case 'Libras(lb)':
          va = 0.0625;
          break;
      }
      break;
    case 'Libras(lb)':
      switch (selectedItem2) {
        case 'Gramos(g)':
          va = 453.59237;
          break;
        case 'Kilogramos(Kg)':
          va = 0.45359237;
          break;
        case 'Onzas(oz)':
          va = 16.0;
          break;
        case 'Libras(lb)':
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
