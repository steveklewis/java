package jmodern;

import java.util.List;
import java.util.Map;
import java.util.Random;
import static java.util.stream.Collectors.*;
import static java.util.stream.IntStream.range;

public class Main {
    public static void main(String[] args) {
        // generate a list of 100 random names
        List<String> students = range(0, 100).mapToObj(i -> randomString(new Random(), 'A', 'Z', 10)).collect(toList());

        // sort names and group by the first letter
        Map<Character, List<String>> directory = students.stream().sorted().collect(groupingBy(name -> name.charAt(0)));

        // print a nicely-formatted student directory
        directory.forEach((letter, names) -> System.out.println(letter + "\n\t" + names.stream().collect(joining("\n\t"))));
    }

    public static String randomString(Random r, char from, char to, int length) {
        return r.ints(from, to + 1).limit(length)
                .collect(() -> new StringBuffer(),
                        (sb, c) -> sb.append((char) c),
                        (sb1, sb2) -> sb1.append(sb2)).toString();
    }
}