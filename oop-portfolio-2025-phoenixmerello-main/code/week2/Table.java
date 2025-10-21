package week2;

public class Table {
    public static void main(String[] args) {
        String a = ("///////////////////");
        String b = ("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
        String x = ("==          ");
        String y = ("Student Points");
        String z = ("          ==");

        String label1 = "Name            ";
        String label2 = "Lab     ";
        String label3 = "Bonus   ";
        String label4 = "Total";

        String name1 = ("Alex            21      9");
        String name2 = ("Josh            57      3");
        String name3 = ("Sarah           11      7");
        String name4 = ("Will            19      7");
        String name5 = ("Emily           34      5");

        int total1 = (21 + 9);
        int total2 = (57 + 3);
        int total3 = (11 + 7);
        int total4 = (19 + 7);
        int total5 = (34 + 5);


        System.out.println(a + b);
        System.out.println(x + y + z);
        System.out.println(b + a);
        System.out.println();
        System.out.println();
        System.out.println(label1 + label2 + label3 +label4);
        System.out.println(name1 + "        " + total1);
        System.out.println(name2 + "        " + total2);
        System.out.println(name3 + "        " + total3 );
        System.out.println(name4 + "        " +total4);
        System.out.println(name5 + "        " +total5);

    }
}
