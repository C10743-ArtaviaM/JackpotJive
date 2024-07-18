import java.util.Scanner;

public class Input {
    private char character;
    private double numberD;
    private int numberI;
    private String text;

    private Scanner scan = new Scanner(System.in);

    public double inputDouble(String message) {
        System.out.print(message + "\n$ ");
        this.text = scan.nextLine();
        try {
            this.numberD = Double.parseDouble(text);
            if (numberD < 0) {
                throw new Exception("No puede ser negativo");
            }
        } catch (Exception d) {
            System.err.println("No ha ingresado un valor numerico decimal valido (" + d.getMessage() + ")");
        }
        return this.numberD;
    }

    public int inputInteger(String message) {
        System.out.print(message + "\n$ ");
        this.text = scan.nextLine();
        try {
            this.numberI = Integer.parseInt(text);
            if (numberI < 0) {
                throw new Exception("No puede ser negativo");
            }
        } catch (Exception i) {
            System.err.println("No ha ingresado un valor numerico entero valido (" + i.getMessage() + ")");
        }
        return this.numberI;
    }

    public String inputString(String message) {
        System.out.print(message + "\n$ ");
        String text = scan.nextLine();
        return text;
    }

    public void printString(String message) {
        System.out.println(message);
    }

    public void printDevice(String[][] disk) {
        System.out.println("<<<\t" + disk[0][0] + "\t" + disk[1][0] + "\t" + disk[2][0] + "\t" + disk[3][0] + "\t"
                + disk[4][0] + "\t>>>");
        System.out.println("<<<\t" + disk[0][1] + "\t" + disk[1][1] + "\t" + disk[2][1] + "\t" + disk[3][1] + "\t"
                + disk[4][1] + "\t>>>");
        System.out.println("<<<\t" + disk[0][2] + "\t" + disk[1][2] + "\t" + disk[2][2] + "\t" + disk[3][2] + "\t"
                + disk[4][2] + "\t>>>");
    }
}
