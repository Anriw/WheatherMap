import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println(Pattern.matches("[0-9]{2}-[0-9]{3}","30-618"));
        System.out.println(Pattern.matches("(\\(?(\\+|00)?48\\)?)? ?([0-9]{3}[ -]?){3}","48783764526"));
        System.out.println(Pattern.matches("(\\+?48)? ?[0-9]{9}","+48512292455"));
        System.out.println(Pattern.matches("[A-ZĄĘĆŁŃŚÓŹŻ][a-ząęćłńśóźż]{2,30} [A-ZĄĘĆŁŃŚÓŹŻ][a-ząęćłńśóźż]{2,30}","Łukasz Pyjas"));

    }
}
