Einfaches TicTacToe-Spiel für zwei Spieler.
Das Spielfeld besteht aus 3x3 Feldern. Die Spieler wählen abwechselnd ein Spielfeld aus, gewonnen hat der Spieler, der als erstes drei seiner Symbole in einer Zeile, Spalte oder diagonal gesetzt hat.
Ein Zufallsgenerator entscheidet, welcher Spieler beginnt.

Die Klasse für die Benutzeroberfläche erweitert JFrame und implementiert ActionListener. 

Im Konstruktor wird das Layout gesetzt und die Methode ersterZug() aufgerufen.
In der überschriebenen Methode actionPerformed() wird mit for-Schleife und if-Abfrage überprüft, welcher Spieler am Zug ist. Hat der Spieler eine Fläche ohne Symbol angeklickt, wird sein Symbol auf die Fläche gesetzt.

In der Methode ersterZug() wird mit einem Zufallsgenerator festgelegt, welcher Spieler beginnt.

In der Methode werGewinnt() wird der Gewinner ermittelt. Mit if-Abfrage wird überprüft, ob eine Siegbedingung zutrifft. 

In den Methoden xGewinnt() und oGewinnt() die Schaltflächen abgeschaltet und die Schaltflächen, die eine Sigebdingung erfüllen, grün gefärbt.
Im Textfeld wird der Gewinner angegeben.
