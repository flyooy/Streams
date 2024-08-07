package org.example.Streams;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Flatmap {
    public static void main(String[] args) {
        //**Liste von Listen zu einer einzigen Liste “flach machen”**
        //- Gegeben: Eine Liste von Listen von ganzen Zahlen.
        //- Aufgabe: Verwende `flatMap`, um eine flache Liste zu erstellen, die alle Zahlen enthält.
    List<List<Integer>> lists = Arrays.asList(
            Arrays.asList(1,2,3),
            Arrays.asList(4,5,6),
            Arrays.asList(7,8,9)
    );
    List<Integer> flattenedList = lists.stream()
            .flatMap(List::stream)
            .collect(Collectors.toList());
        System.out.println("1.Liste von Listen zu einer einzigen Liste");
        System.out.println(flattenedList);

        //**Zeichenketten in eine Liste von Wörtern aufteilen**
        //- Gegeben: Eine Liste von Sätzen (Zeichenketten).
        //- Aufgabe: Verwende `flatMap`, um eine Liste von einzelnen Wörtern zu erstellen.

        System.out.println("2.Zeichenketten in eine Liste von Wörtern aufteilen");
        List<String> str = List.of("kategorie hat Enumclass");
        System.out.println(str);
        List<String> strOfWorts = str.stream()
                .flatMap(s->Arrays.stream(s.split(" ")))
                .collect(Collectors.toList());
        System.out.println(strOfWorts);

        //**Filtern und flach machen einer Liste von Listen**
        //- Gegeben: Eine Liste von Listen von ganzen Zahlen.
        //- Aufgabe: Filter alle Zahlen, die größer als 5 sind.

        List<Integer> filtNumbers = lists.stream()
                .flatMap(List::stream)
                .filter(num -> num>5)
                .collect(Collectors.toList());
        System.out.println("3. eine Liste,die größer als 5 sind");
                System.out.println(filtNumbers);
    }
}
