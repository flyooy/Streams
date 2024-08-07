package org.example.Streams;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Einfuhrung {
    public static void main(String[] args) {
        List<Integer> numberList = List.of(1,2,3,4,5,6,7,8,9,10);

//        **Liste von Zahlen filtern**
//        - Gegeben: Eine Liste von ganzen Zahlen.
//        - Aufgabe: Filter alle geraden Zahlen aus der Liste.
        List<Integer> filternNumbers = numberList.stream()
                .filter(f-> f.intValue()%2==0)
                .collect(Collectors.toList());
        System.out.println("1.Liste von Zahlen filtern");
        System.out.println(filternNumbers);

        //**Liste von Zeichenketten in Großbuchstaben umwandeln**
        //- Gegeben: Eine Liste von Zeichenketten.
        //- Aufgabe: Wandele alle Zeichenketten in der Liste in Großbuchstaben um.
        List<String> list = List.of("der", "die", "das");

        List<String> upperCase = list.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("2.Liste von Zeichenketten in Großbuchstaben");
        System.out.println(upperCase);

        // **Summe einer Liste von Zahlen berechnen**
        //- Gegeben: Eine Liste von ganzen Zahlen.
        //- Aufgabe: Berechne die Summe aller Zahlen in der Liste.
        int summeNumbers = numberList.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("3.Summe einer Liste von Zahlen");
        System.out.println(summeNumbers);

        //**Duplikate aus einer Liste entfernen**
        //- Gegeben: Eine Liste von ganzen Zahlen mit Duplikaten.
        //- Aufgabe: Entferne alle Duplikate aus der Liste.
        List<Integer> numberListDuplicate = List.of(1,2,2,4,5,5,8,8,9,10);
        List<Integer> numberListWithoutDuplicate = numberListDuplicate.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("4.Entferne alle Duplikate aus der Liste");
        System.out.println(numberListWithoutDuplicate);

        //**Durchschnitt einer Liste von Zahlen berechnen**
        //- Gegeben: Eine Liste von ganzen Zahlen.
        //- Aufgabe: Berechne den Durchschnittswert der Zahlen in der Liste.
        double avrgNumbers = numberList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        System.out.println("5.Durchschnitt einer Liste von Zahlen");
        System.out.println(avrgNumbers);

        //**Zeichenketten nach Länge sortieren**
        //- Gegeben: Eine Liste von Zeichenketten.
        //- Aufgabe: Sortiere die Zeichenketten nach ihrer Länge.

        List<String> list2 = List.of("Auto", "Spiele", "Ok");

        List<String> sortList = list2.stream()
                .sorted((s1,s2)-> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());
        System.out.println("6.Zeichenketten nach Länge sortieren");
        System.out.println(sortList);
        }

}
