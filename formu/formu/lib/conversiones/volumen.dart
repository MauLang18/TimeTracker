import 'package:flutter/material.dart';

class volumen extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return volumenState();
  }
}

class volumenState extends State<volumen> {
  var items = [
    'Litro(L)',
    'Mililitro(ml)',
    'Metro cubico(m^3)',
    'Centimetro cubico(cc)',
    'Pulgada cubica(in^3)',
    'Pie cubico(ft^3)'
  ];

  String valor = "";
  String valo = '1000.0';
  String va = "";

  String? selectedItem = 'Litro(L)';

  String? selectedItem2 = 'Mililitro(ml)';

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
  var va = 1000.0;

  switch (selectedItem) {
    case 'Litro(L)':
      switch (selectedItem2) {
        case 'Litro(L)':
          va = 1.0;
          break;
        case 'Mililitro(ml)':
          va = 1000.0;
          break;
        case 'Metro cubico(m^3)':
          va = 0.001;
          break;
        case 'Centimetro cubico(cc)':
          va = 1000.0;
          break;
        case 'Pulgada cubica(in^3)':
          va = 61.02374409473229;
          break;
        case 'Pie cubico(ft^3)':
          va = 0.03531466672148859;
          break;
      }
      break;
    case 'Mililitro(ml)':
      switch (selectedItem2) {
        case 'Litro(L)':
          va = 0.001;
          break;
        case 'Mililitro(ml)':
          va = 1.0;
          break;
        case 'Metro cubico(m^3)':
          va = 0.000001;
          break;
        case 'Centimetro cubico(cc)':
          va = 1.0;
          break;
        case 'Pulgada cubica(in^3)':
          va = 0.06102374409473229;
          break;
        case 'Pie cubico(ft^3)':
          va = 0.00003531466672148859;
          break;
      }
      break;
    case 'Metro cubico(m^3)':
      switch (selectedItem2) {
        case 'Litro(L)':
          va = 1000.0;
          break;
        case 'Mililitro(ml)':
          va = 1000000.0;
          break;
        case 'Metro cubico(m^3)':
          va = 1.0;
          break;
        case 'Centimetro cubico(cc)':
          va = 1000000.0;
          break;
        case 'Pulgada cubica(in^3)':
          va = 61023.74409473228;
          break;
        case 'Pie cubico(ft^3)':
          va = 35.31466672148859;
          break;
      }
      break;
    case 'Centimetro cubico(cc)':
      switch (selectedItem2) {
        case 'Litro(L)':
          va = 0.001;
          break;
        case 'Mililitro(ml)':
          va = 1.0;
          break;
        case 'Metro cubico(m^3)':
          va = 0.000001;
          break;
        case 'Centimetro cubico(cc)':
          va = 1.0;
          break;
        case 'Pulgada cubica(in^3)':
          va = 0.06102374409473229;
          break;
        case 'Pie cubico(ft^3)':
          va = 0.00003531466672148859;
          break;
      }
      break;
    case 'Pulgada cubica(in^3)':
      switch (selectedItem2) {
        case 'Litro(L)':
          va = 0.016387064;
          break;
        case 'Mililitro(ml)':
          va = 1.0;
          break;
        case 'Metro cubico(m^3)':
          va = 0.000016387064;
          break;
        case 'Centimetro cubico(cc)':
          va = 1.0;
          break;
        case 'Pulgada cubica(in^3)':
          va = 1.0;
          break;
        case 'Pie cubico(ft^3)':
          va = 0.0005787037037037037;
          break;
      }
      break;
    case 'Pie cubico(ft^3)':
      switch (selectedItem2) {
        case 'Litro(L)':
          va = 28.316846592;
          break;
        case 'Mililitro(ml)':
          va = 1.0;
          break;
        case 'Metro cubico(m^3)':
          va = 0.028316846592;
          break;
        case 'Centimetro cubico(cc)':
          va = 1.0;
          break;
        case 'Pulgada cubica(in^3)':
          va = 1728.0;
          break;
        case 'Pie cubico(ft^3)':
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
