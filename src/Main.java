import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Double.parseDouble;

public class Main {

    private static double ergebnis = 0;
    public static String antwort = "`";
    public static void main(String[] args) {


        Scanner eingabe = new Scanner(System.in);
        boolean bool = true;
        ArrayList<Double> operanden = new ArrayList<>();


        while (bool) {

            System.out.println("...Entschuldigen Sie, ich vergaß... war es der Beginn einer Rechnung(y) oder die Fortführung der Rechnung(n)?");
            String question = eingabe.nextLine();
            if(question.equals("y")) {

                System.out.println("Bitte geben Sie die Operanden ein (Gleitkomma, getrennt durch ein Leerzeichen)!: ");

                String operandenUndefined = eingabe.nextLine();
                String[] operandenString = operandenUndefined.split(" ");

                operanden.clear();

                for (String operand : operandenString) {
                    if (!operand.isEmpty())
                        operanden.add(parseDouble(operand));
                }

            }else if(question.equals("n")) System.out.println("...dann geht es direkt hier weiter:");
            System.out.println("Nun bitte die Rechenoperation angeben: \n a-addieren, s-subtrahieren, m-multiplizieren, d-dividieren.E für escape.");
            String operation = eingabe.nextLine();

            for (int u = 1; u < operanden.size(); u++) {


                if (operation.equals("a")) {
                    if (antwort.equals("y")) ergebnis += operanden.get(u);
                    ergebnis = Rechenoperationen.add(operanden.get(0), operanden.get(u));
                    System.out.println(ergebnis);
                }
                if (operation.equals("s")) {
                    if (antwort.equals("y")) ergebnis -= operanden.get(u);
                    ergebnis = Rechenoperationen.sub(operanden.get(0), operanden.get(u));
                    System.out.println(ergebnis);
                }
                if (operation.equals("m")) {
                    if (antwort.equals("y")) ergebnis *= operanden.get(u);
                    ergebnis = Rechenoperationen.multiply(operanden.get(0), operanden.get(u));
                    System.out.println(ergebnis);
                }
                if (operation.equals("d")) {
                    if (antwort.equals("y")) ergebnis /= operanden.get(u);
                    ergebnis = Rechenoperationen.divide(operanden.get(0), operanden.get(u));
                    System.out.println(ergebnis);
                }
                if (operation.equals("E")) {
                    bool = false;
                }


                System.out.println("Möchten Sie mit dem Ergebnis der letzten Rechnung weiterrechnen? y/n");
                String antwort = eingabe.nextLine();
                if (antwort.equals("y")) {
                    System.out.println("Bitte geben Sie den zweiten Operanden ein!");
                    double zweiterOperand = Double.parseDouble(eingabe.nextLine());

                    operanden.clear();
                    operanden.add(ergebnis);
                    operanden.add(zweiterOperand);

                    }
                }


            }


        }

    }











