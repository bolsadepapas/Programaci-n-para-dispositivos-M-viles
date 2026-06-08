import 'package:flutter/material.dart';

class PantallaPerfil extends StatelessWidget {
  const PantallaPerfil({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Mi perfil'),
      ),
      body: SingleChildScrollView(
        padding: const EdgeInsets.all(16),
        child: Column(
          children: [
            // imagen desde internet
            ClipRRect(
              borderRadius: BorderRadius.circular(60),
              child: Image.network(
                'https://i.imgur.com/zNebLLI.jpeg',
                width: 120,
                height: 120,
                fit: BoxFit.cover,
              ),
            ),
            const SizedBox(height: 16),
            const Text(
              'Luis Gonzalo',
              style: TextStyle(fontSize: 22, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 8),
            const Text(
              'Estudiante de ingenieria de software en ulasalle',
              style: TextStyle(fontSize: 16),
            ),
            const SizedBox(height: 16),
            // contacto
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: const [
                Icon(Icons.email),
                SizedBox(width: 8),
                Text('lbasurcom@ulasalle.edu.pe'),
              ],
            ),
            const SizedBox(height: 8),
            Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children: const [
                Icon(Icons.phone),
                SizedBox(width: 8),
                Text('+51 999 999 999'),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
