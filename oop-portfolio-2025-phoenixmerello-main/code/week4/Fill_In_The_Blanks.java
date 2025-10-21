package week4;

public class Fill_In_The_Blanks {
    public static void main(String[] args) {
        String college = new String ("Leeds Beckett University");
        String town = new String (" Anytown, UK");

        int stringlength;
        stringlength = college.length();
        System.out.println("Contains " + stringlength + " characters");

        String change1 = college.toUpperCase();
        System.out.println(change1);

        String change2 = change1;
        System.out.println(change2.replace('E', '*'));

        System.out.println();

        String change3 = (college.concat(town));
        System.out.println("The final string is " + change3);


    }
}
