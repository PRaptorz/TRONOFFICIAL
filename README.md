# TRON Fangame

**Developers:** Anirudha Patel S.K and Adam Wakelin
**Date:** March, 2026
**Course:** AP Computer Science A 

---

## 🎮 Game Description
This Tron fan-game is based on the classic 1982 Tronaracade minigame, lightcycles. 2 player 1v1 game, players control bikes.  Players will play in a grid arena with the bikes. The Bikes will produce a light trail that is collidable, and the main goal is to try and get the opponents bike to crash into your light trail, or trap and make them crash into their own light trail. 


## 🕹️ Controls
* **[W, A, S, D]** : To Control Blue Bike **[Arrow Keys]**: To Control Yellow Bike.
* **[Spacebar]** or **[Left Mouse Click]**: Shoot / Jump / Interact.
* **[P]**: Pause the game.
* **[Escape]**: Quit.

---

## 🧠 AP CSA Developer Notes
*This section shows how we aligned to the AP CSA standards.*

* **Encapsulation & Architecture:** All classes use `private` instance variables with `public` getters and setters. We created a class hierarchy where `[Subclass 1]`, `[Subclass 2]`, and `[Subclass 3]` all extend our base `GameObject` class.
* **Polymorphism:** In our main `render()` loop, we call the `.move()` and `.draw()` methods on a list of `GameObject` references, but the specific overridden methods in our subclasses execute at runtime.
* **ArrayList Traversal:** We manage our game entities using an `ArrayList<GameObject>`. We successfully implemented a backwards traversal loop in the `[Insert Method Name]` method to safely remove objects without causing an `IndexOutOfBoundsException`.
* **Standard Arrays & Sorting:** We used a standard 1D array to manage `[Insert Mechanic, e.g., the top 5 high scores]`. We used `[Selection Sort / Insertion Sort]` to order these scores before displaying them on the Game Over screen.
* **File I/O & String Parsing:** Our game saves data persistently to `[filename.txt]`. When the game loads, it reads the file using a `Scanner` and uses String methods like `[substring() / indexOf()]` to parse the saved names and scores.

---

## 🛠️ How to Run Locally

If you want to pull this repository and play the game yourself, follow these steps:

1. **Clone the repository:** `git clone [Insert your GitHub Repo URL here]`
2. **Open the project** in your IDE (VS Code, IntelliJ IDEA, or Eclipse).
3. **Run the Desktop Launcher:** Navigate to `src/Launcher.java` and run the `main` method. 