import 'package:flutter/material.dart';
import 'package:formu/widget/DrawerWidget.dart';

class perfil extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return perfilState();
  }
}

class perfilState extends State<perfil> {
  final double coverHeight = 280;
  final double profileHeight = 144;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      drawer: DrawerWidget(),
      appBar: AppBar(
        backgroundColor: const Color(0xff333333),
        title: const Text('Perfil'),
        centerTitle: true,
      ),
      body: ListView(
        padding: EdgeInsets.zero,
        children: <Widget>[buildTop(), buildContent()],
      ),
      backgroundColor: const Color(0xFFE1F4F3),
    );
  }

  Widget buildTop() {
    final bottom = profileHeight / 2;
    final top = coverHeight - profileHeight / 2;

    return Stack(
      clipBehavior: Clip.none,
      alignment: Alignment.center,
      children: [
        Container(
            margin: EdgeInsets.only(bottom: bottom), child: buildCoverImage()),
        Positioned(top: top, child: buildProfileImage())
      ],
    );
  }

  Widget buildCoverImage() => Container(
        color: Colors.grey,
        child: Image.asset(
          'assets/icon/prueba1.png',
          width: double.infinity,
          height: coverHeight,
          fit: BoxFit.cover,
        ),
      );

  Widget buildProfileImage() => CircleAvatar(
        radius: profileHeight / 2,
        backgroundColor: Colors.grey.shade800,
        backgroundImage: AssetImage('assets/icon/perfil.png'),
      );

  Widget buildContent() => Column(
        children: const [
          SizedBox(height: 8),
          Text('Maurice Lang Bonilla',
              style: TextStyle(
                fontSize: 28,
              )),
          SizedBox(height: 25),
          Text(
            'Contacto: ',
            style: TextStyle(fontSize: 25),
          ),
          SizedBox(height: 5),
          Text(
            'maulangbonilla.18@gmail.com',
            style: TextStyle(fontSize: 18),
          ),
        ],
      );
}
