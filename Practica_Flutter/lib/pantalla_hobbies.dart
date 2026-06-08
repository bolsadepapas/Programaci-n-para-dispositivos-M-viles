import 'package:flutter/material.dart';

class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Mis hobbies'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            hobbyItem(
              'https://i.imgur.com/k9jIe98.jpeg',
              'Videojuegos',
            ),
            hobbyItem(
              'https://i.imgur.com/ZKdhoDn.png',
              'Música',
            ),
            hobbyItem(
              'https://i.imgur.com/P3vOECk.jpeg',
              'Programar',
            ),
          ],
        ),
      ),
    );
  }

  Widget hobbyItem(String imageUrl, String texto) {
    return Padding(
      padding: const EdgeInsets.symmetric(vertical: 8),
      child: Row(
        children: [
          ClipRRect(
            borderRadius: BorderRadius.circular(8),
            child: Image.network(
              imageUrl,
              width: 60,
              height: 60,
              fit: BoxFit.cover,
            ),
          ),
          const SizedBox(width: 12),
          Text(
            texto,
            style: const TextStyle(fontSize: 18),
          ),
        ],
      ),
    );
  }
}
