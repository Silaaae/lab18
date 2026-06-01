
# Lab 18 — ViewModel et LiveData en Android

Ce projet illustre l'utilisation de **ViewModel** et **LiveData** pour gérer un compteur qui survit aux rotations d'écran.

---

## Fonctionnalités

- Incrémenter, décrémenter et réinitialiser un compteur
- Les données persistent lors de la rotation de l'écran grâce au ViewModel
- L'interface se met à jour automatiquement via LiveData

---

## Architecture

- **`CounterViewModel`** — contient la logique du compteur et expose les données via `LiveData`
- **`MainActivity`** — observe le ViewModel et met à jour l'affichage en temps réel

---

## Aperçu

> Les captures ci-dessous montrent le compteur et la persistance des données lors de la rotation.
<img width="152" height="316" alt="image" src="https://github.com/user-attachments/assets/7e3d1730-7e1e-4ef0-b7c8-0266c4ce1072" />
*
> <img width="156" height="305" alt="image" src="https://github.com/user-attachments/assets/67590da4-d412-49b4-8474-0f61d50b69d4" />
<img width="156" height="307" alt="image" src="https://github.com/user-attachments/assets/1853896d-4e23-4f9d-a3ff-39645af81ce2" />
