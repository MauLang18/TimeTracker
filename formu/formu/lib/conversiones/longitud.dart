import 'package:flutter/material.dart';

class longitud extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return longitudState();
  }
}

class longitudState extends State<longitud> {
  var items = [
    'Kilometro(Km)',
    'Metro(m)',
    'Centimetro(cm)',
    'Milla(m)',
    'Yarda(yd)',
    'Pie(ft)',
    'Pulgada'
  ];

  String valor = "";
  String valo = '0.001';
  String va = "";

  String? selectedItem = 'Metro(m)';

  String? selectedItem2 = 'Kilometro(Km)';

  String valueChoose = "";

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: const Color(0xFFE1F4F3),
      appBar: AppBar(
        title: const Text('Longitud'),
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
    case 'Metro(m)':
      switch (selectedItem2) {
        case 'Metro(m)':
          va = 1.0;
          break;
        case 'Kilometro(Km)':
          va = 0.001;
          break;
        case 'Centimetro(cm)':
          va = 100.0;
          break;
        case 'Milla(m)':
          va = 0.0006213711922373339;
          break;
        case 'Yarda(yd)':
          va = 1.0936132983377078;
          break;
        case 'Pie(ft)':
          va = 3.2808398950131235;
          break;
        case 'Pulgada':
          va = 39.37007874015748;
          break;
      }
      break;
    case 'Kilometro(Km)':
      switch (selectedItem2) {
        case 'Metro(m)':
          va = 1000.0;
          break;
        case 'Kilometro(Km)':
          va = 1.0;
          break;
        case 'Centimetro(cm)':
          va = 100000.0;
          break;
        case 'Milla(m)':
          va = 0.621371192237334;
          break;
        case 'Yarda(yd)':
          va = 1093.6132983377079;
          break;
        case 'Pie(ft)':
          va = 3280.8398950131236;
          break;
        case 'Pulgada':
          va = 39370.07874015748;
          break;
      }
      break;
    case 'Centimetro(cm)':
      switch (selectedItem2) {
        case 'Metro(m)':
          va = 0.01;
          break;
        case 'Kilometro(Km)':
          va = 0.00001;
          break;
        case 'Centimetro(cm)':
          va = 1.0;
          break;
        case 'Milla(m)':
          va = 0.00000621371192237334;
          break;
        case 'Yarda(yd)':
          va = 0.010936132983377079;
          break;
        case 'Pie(ft)':
          va = 0.03280839895013123;
          break;
        case 'Pulgada':
          va = 0.3937007874015748;
          break;
      }
      break;
    case 'Milla(m)':
      switch (selectedItem2) {
        case 'Metro(m)':
          va = 1609.344;
          break;
        case 'Kilometro(Km)':
          va = 1.609344;
          break;
        case 'Centimetro(cm)':
          va = 160934.4;
          break;
        case 'Milla(m)':
          va = 1.0;
          break;
        case 'Yarda(yd)':
          va = 1760.0;
          break;
        case 'Pie(ft)':
          va = 5280.0;
          break;
        case 'Pulgada':
          va = 63360.0;
          break;
      }
      break;
    case 'Yarda(yd)':
      switch (selectedItem2) {
        case 'Metro(m)':
          va = 0.9143999999999999;
          break;
        case 'Kilometro(Km)':
          va = 0.0009143999999999999;
          break;
        case 'Centimetro(cm)':
          va = 91.43999999999998;
          break;
        case 'Milla(m)':
          va = 0.00056818181818182;
          break;
        case 'Yarda(yd)':
          va = 1.0;
          break;
        case 'Pie(ft)':
          va = 3.0;
          break;
        case 'Pulgada':
          va = 36.0;
          break;
      }
      break;
    case 'Pie(ft)':
      switch (selectedItem2) {
        case 'Metro(m)':
          va = 0.3048;
          break;
        case 'Kilometro(Km)':
          va = 304.8;
          break;
        case 'Centimetro(cm)':
          va = 30.48;
          break;
        case 'Milla(m)':
          va = 0.0001893939393939394;
          break;
        case 'Yarda(yd)':
          va = 0.3333333333333333;
          break;
        case 'Pie(ft)':
          va = 1.0;
          break;
        case 'Pulgada':
          va = 12.0;
          break;
      }
      break;
    case 'Pulgada':
      switch (selectedItem2) {
        case 'Metro(m)':
          va = 0.0254;
          break;
        case 'Kilometro(Km)':
          va = 25.4;
          break;
        case 'Centimetro(cm)':
          va = 2.54;
          break;
        case 'Milla(m)':
          va = 0.000015782828282828283;
          break;
        case 'Yarda(yd)':
          va = 0.027777777777777776;
          break;
        case 'Pie(ft)':
          va = 0.08333333333333333;
          break;
        case 'Pulgada':
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
