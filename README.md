# gui_swing_anim
Program pokazujący prostą symulację - figury latające po panelu
i odbijające sie od jego krawędzi.

W ramach dodatkowej funkjonalności:
- poprawione zostało odbijanie się figur
- naprawiony został błąd przez który kolor panelu nie zmieniał się na biały
- naprawiony został błąd z zacinaniem się figur na krawędziach panelu
- dodano menu nad panelem, za pomocą którego można wybrać tworzoną figure oraz jej kolor

Klasy:
- Figura - klasa abstrakcyjna obsługująca wygląd i zachowalnie figur
- Prostokat i Elipsa - klasy dziedziczące po klasie Figura
- AnimatorApp - okno programu
- AnimPanel - panel po którym poruszają się figury
- GetSetHelper - klasa pomocnicza
