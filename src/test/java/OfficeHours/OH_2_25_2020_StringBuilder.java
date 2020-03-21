package OfficeHours;

public class OH_2_25_2020_StringBuilder {
    public static void main(String[] args) {

        StringBuilder sb1 = new StringBuilder("word");
        StringBuilder sb2 = sb1;

        sb1.append("for");
        sb1.insert(1,"elcom, w");
        System.out.println(sb1);

        String str1 = "java";
        System.out.println(str1);

        String str2 = "Java";
        System.out.println( str2);

        str1 = "selenium";
        System.out.println(str1 + "\n" + str2);

        System.out.println("----------");
        System.out.println(sb1.toString());
        String str4 = sb1.toString();
        System.out.println(str4);


    }
}
