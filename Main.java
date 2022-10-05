import java.util.Scanner; // Importación de la clase Scanner.

/**
 * Clase inicial del Programa C10743_TP1 (MAQUINA TRAGA-MONEDAS)
 */
public class Main {
    /**
     * Método principal del programa.
     * 
     * @param args Argumentos del programa.
     */
    public static void main(String args[]) {
        start(); // Llamado al método estatico start, ubicado en la clase Main.
    }
    
    /**
     * Metodo estatico que me va a incializar la maquina.
     */
    public static void start() {
        Scanner scan = new Scanner(System.in); // Instanciación de la clase Scanner.
        
        System.out.println("=-=-=-=-=-=-=-=-=-=-=\nMAQUINA TRAGA-MONEDAS\n=-=-=-=-=-=-=-=-=-=-=");
        System.out.print("Sea usted bienvenido. Por favor, digite cuanto desea agregar a su saldo: ");
        int credit = scan.nextInt(); // Pregunta al usuario por su saldo inicial.

        menu(credit); // Llamado al método estatico menu, utilizando de parametro el saldo del usario, ubicado en la clase Main.
    }
    
    /**
     * Método estatico que me inicia el juego. 
     *
     * @param credit Credito actual del jugador.
     */
    public static void menu (int credit) {
        Scanner scan = new Scanner(System.in); // Instanciación de la clase Scanner.

        boolean controller = true; // Controlador del menu.
        while (controller == true) { // Ciclo While que me mantiene dentro del programa siempre y cuando la variable controlador se mantenga en true.
            System.out.print("=-=-=-=-=-=-=-=-=-=-=\n=-=-= MAIN MENU =-=-=\n=-=-=-=-=-=-=-=-=-=-=\n¿Que desea hacer?\n1) Apostar & Jugar\n2) Aumentar Saldo\n3) Retirar Saldo & Salir\n=-=-=-=-=-=-=-=-=-=-=\nSaldo Total: " +credit+ "\n=-=-=-=-=-=-=-=-=-=-=\n → ");
            try { // Try & Catch pensado para manejo de excepciones de tipo InputMismatch.
                int menuOption = scan.nextInt(); // Pregunta al usuario por la opcion del menu a elegir.
                switch (menuOption) {
                    case 1: // El jugador dara una apuesta y comenzara inmediatamente una nueva partida.
                        credit = betAndPlay(credit); // Llamado al metodo estatico de juego el cual al finalizar, me devolvera el valor de las ganacias de la ronda.
                        break;
                    case 2: // El jugador digitara cuanto desea agragar a su saldo.
                        System.out.print("Por favor, digite cuanto desea agregar a su saldo: ");
                        try { // Try & Catch pensado para manejo de excepciones de tipo NumberFormat.
                            scan.nextLine(); // Permite mover el cursor del scanner para que me pueda leer el string luego de un int.
                            String newCreditString = scan.nextLine(); // Pregunta al usuario cuanto desea agregar a su saldo.
                            int newCredit = Integer.parseInt(newCreditString); // Me convierte el string del saldo a un entero tipo interger.
                            boolean correctCredit = false; // Controlador para controlar si el saldo a agregar es correcto o no.
                            while (correctCredit == false) {
                                if (newCredit > 0) { // Si el saldo a agregar es mayor a 0, se agregara a su saldo actual.
                                    credit = credit + newCredit;
                                    correctCredit = true;
                                } else if (newCredit <= 0) { // Si el saldo a agregar es menor o igual a 0, este dara error, avisara al usuario, y lo devolvera al menu principal.
                                    System.out.println("ERROR: Usted no puede ingresar una cantidad menor o igual a 0. Por favor, digite un valor correcto. Por seguridad, se le devolvera al menu principal");
                                    break;
                                }
                            }
                        } catch (Exception NumberFormatException) { // En caso de que en el String se ingresara un valor no convertible en int, el catch se encarga de no tirar el programa y salvarlo.
                            System.out.println("ERROR: Usted ha digitado una opción no válida. Usted debe digitar un valor correcto. Por seguridad, se le devolvera al menu principal");
                            controller = true; // Al ser un valor inválido, el ciclo while me lo mantiene en funcionamiento.
                        }
                        break;
                    case 3: // El jugador desea salir del juego, y que se le devuelva su saldo.
                        System.out.println("=-=-=-=-=-=-=-=-=\nGRACIAS POR JUGAR\n=-=-=-=-=-=-=-=-=\nSe le ha devuelto un saldo de: " + credit);
                        controller = false; // Me cierra el controlador del menu para salir del programa.
                        break;
                    default: // El usuario ha ingresado una opcion no valida.
                        System.out.println("ERROR: Usted ha digitado una opción no válida. Por favor, digite una opción correcta.");
                }
            } catch (Exception InputMismatchException) { // En caso de que se digite una opcion que no sea un int, el catch se encargara de no tirar el programa y salvarlo.
                System.out.println("ERROR: Usted ha digitado una opción no válida. Por favor, digite una opción correcta.");
                controller = true; // Al ser un valor inválido, el ciclo while me lo mantiene en funcionamiento.
                menu(credit); // Llamado al método estatico game de la clase main (este mismo método), con el objetivo de reiniciar el ciclo.
                break; // Break diseñado para que se evite la duplicacion y ciclo indefinido del método.
            }
        }
    }
    
    
    /**
     * Metodo estatico que me controla el juego.
     *
     * @param betCredit Saldo actual del jugador.
     * @return El valor de la ganancia por ronda.
     */
    public static int betAndPlay (int betCredit) {
        Scanner scan = new Scanner(System.in); // Instanciación de la clase Scanner.
        int playerBet = 0; // Inicializacion de la variable que me define la apuesta del jugador.
        int originalPlayerBet = 0; // Inicializacion de la variable que me mantiene el valor original de la apuesta del juegador.
        
        boolean canPlay = false; // Controlador que me permite controlar si el jugador puede o no continuar el juego.
        while (canPlay == false) { // Ciclo while que me permite identificar si se da una opcion valida para asi poder iniciar el juego o no.
            System.out.print("Por favor, digite cuanto desea apostar: ");
            try { // Try & Catch pensado para manejo de excepciones de tipo InputMismatchException.
                playerBet = scan.nextInt(); // Pregunta al usuario por su apuesta.
                originalPlayerBet = playerBet; // Me iguala el valor de la apuesta del usuario y me mantiene el valor original, para posteriormente restarselo al saldo.
                if (playerBet > betCredit) { // Si la apuesta es mayor al saldo.
                    System.out.println("ERROR: Su apuesta no puede ser mayor a su credito actual ("+betCredit+").\nUsted sera llevado de vuelta al Menu por si gusta agragar mas saldo a su cuenta.");
                    canPlay = false;
                    break;
                } else if (playerBet == 0) { // Si la apuesta es igual a 0.
                    System.out.println("ERROR: Su apuesta no puede ser 0.\nUsted sera llevado de vuelta al Menu por si gusta agragar mas saldo a su cuenta.");
                    canPlay = false;
                    break;
                } else if (playerBet < 0) { // Si la apuesta es un valor negativo.
                    System.out.println("ERROR: Su apuesta no puede ser un numero negativo.\nPor seguridad, se le devolvera al menu principal por si gusta agragar mas saldo a su cuenta.");
                    canPlay = false;
                    break;
                }else { // Si la apuesta es por lo tanto menor al saldo y mayor a 0.
                    System.out.println("Su apuesta es de "+ playerBet);
                    canPlay = true;
                    playerBet = machineDisks(playerBet); // Llamado al metodo estatico de discos de la maquina el cual al finalizar, me devolvera el valor de las ganacias de la ronda.
                }
            } catch (Exception InputMismatchException) { // En caso de que se digite una opcion que no sea un int, el catch se encargara de no tirar el programa y salvarlo.
                System.out.println("ERROR: Usted tiene que digitar un valor numerico entero.\nPor seguridad, se le devolvera al menu principal");
                canPlay = false;
                break;
            }
        }
        
        return (betCredit+playerBet) - originalPlayerBet; // Retorna el valor del credito actual del jugador sumado a las ganacias de la ronda, y posteriormente, restandole la apuesta que hizo el jugador.
    }
    
    /**
     * Metodo que me simulara la Maquina Traga-Monedas.
     * 
     * @param playerBet Apuesta hecha por el jugador.
     * @return El valor de la ganancia por ronda.
     */
    public static int machineDisks (int playerBet) {
        // Llamado al metodo estatico de disco para asignar valores a cada disco.
        int disk1 = disk();
        int disk2 = disk();
        int disk3 = disk();
        int disk4 = disk();
        int disk5 = disk();
        
        playerBet = checkDisks(disk1, disk2, disk3, disk4, disk5, playerBet); // Llamado al metodo estatico de chequeo de discos para que me pueda definir las jugadas y devolverme el valor de la ganancia del jugador.
        return playerBet; // Retorna el valor de las ganacias de la ronda.
    }
    
    
    /**
     * Metodo que me dara un valor principal para el disco. Me retorna un valor para el disco segun la posicion de la siguiente forma. Me da un
     * primer numero entre 0.0 y 1.0 sin incluir uno, y posteriormente otro valor de la misma forma. Ambos los multiplico por 10 y posteriormente
     * los sumo para que me de un valor entre 00 y 18, siendo asi asignados a un valor especifico de la lista de valores.
     *
     * @return Valor del disco.
     */
    public static int disk () {
        // Inicializacion con 0 del calculo de giros pseudo-aleatorios que realizaran los discos.
        int diskSpin = 0;
        
        /*
         * Randomizador que me dara dos valores, los cuales multiplico por 10 y luego los sumo entre si mientras los convierte de Double a Interger, para que me de el numero
         * de vueltas que dara el disco.
         */
        double spin1 = Math.random() * 10;
        double spin2 = Math.random() * 10;
        diskSpin = (int)spin1 + (int)spin2;
        
        
        // Inicializacion con valor 0 de los valores que definiran el disco.
        int diskValue1 = 0;
        int diskValue2 = 0;
        
        // Inicializacion en 0 del valor final del disco.
        int diskFinalValue = 0;
        for (int i = 0; i < diskSpin; i++) {
            // Randomizador que me dara los valores a sumar para definir el disco.
            double diskValue1D = Math.random() * 10;
            double diskValue2D = Math.random() * 10;
            
            // Conversion de Double a Interger de los valores a sumar para definir el disco.
            diskValue1 = (int)diskValue1D;
            diskValue2 = (int)diskValue2D;
            
            // Suma de los valores para terminar de definir el valor del disco.
            diskFinalValue = diskValue1 + diskValue2;
        }
        
        // Retorna valor del disco.
        return diskFinalValue;
    }
    
    /**
     * Metodo estatico que me chequeara los discos para asi poder dar un resultado a la apuesta.
     *
     * @param disk1 Valor principal del disco 1.
     * @param disk2 Valor principal del disco 2.
     * @param disk3 Valor principal del disco 3.
     * @param disk4 Valor principal del disco 4.
     * @param disk5 Valor principal del disco 5.
     * @param playerBet Valor de la apuesta actual del jugador.
     * @return El valor de la ganancia por ronda.
     */
    public static int checkDisks(int disk1, int disk2, int disk3, int disk4, int disk5, int playerBet) {
        // Creacion de variables para definir las posiciones de los discos.
        String previous1 = "";
        String previous2 = "";
        String previous3 = "";
        String previous4 = "";
        String previous5 = "";
        String main1 = "";
        String main2 = "";
        String main3 = "";
        String main4 = "";
        String main5 = "";
        String next1 = "";
        String next2 = "";
        String next3 = "";
        String next4 = "";
        String next5 = "";
        
        double winning = 0; // Inicializacion de variable para luego irle sumando los valores de ganancias.
        
        // Definicion de todos los discos segun el valor asignado.
        // Disco 1
        if (disk1 == 0 || disk1 == 13) {
            previous1 = "1";
            main1 = "1";
            next1 = "2";
        } else if (disk1 == 1 || disk1 == 14) {
            previous1 = "1";
            main1 = "2";
            next1 = "3";
        } else if (disk1 == 2  || disk1 == 15) {
            previous1 = "2";
            main1 = "3";
            next1 = "4";
        } else if (disk1 == 3  || disk1 == 16) {
            previous1 = "3";
            main1 = "4";
            next1 = "5";
        } else if (disk1 == 4 || disk1 == 17) {
            previous1 = "4";
            main1 = "5";
            next1 = "6";
        } else if (disk1 == 5 || disk1 == 18) {
            previous1 = "5";
            main1 = "6";
            next1 = "A";
        } else if (disk1 == 6) {
            previous1 = "6";
            main1 = "A";
            next1 = "6";
        } else if (disk1 == 7) {
            previous1 = "A";
            main1 = "6";
            next1 = "5";
        } else if (disk1 == 8) {
            previous1 = "6";
            main1 = "5";
            next1 = "4";
        } else if (disk1 == 9) {
            previous1 = "5";
            main1 = "4";
            next1 = "3";
        } else if (disk1 == 10) {
            previous1 = "4";
            main1 = "3";
            next1 = "2";
        } else if (disk1 == 11) {
            previous1 = "3";
            main1 = "2";
            next1 = "1";
        } else if (disk1 == 12) {
            previous1 = "2";
            main1 = "1";
            next1 = "1";
        }
        // Disco 2
        if (disk2 == 0 || disk2 == 14) {
            previous2 = "6";
            main2 = "1";
            next2 = "3";
        } else if (disk2 == 1 || disk2 == 15) {
            previous2 = "1";
            main2 = "3";
            next2 = "5";
        } else if (disk2 == 2  || disk2 == 16) {
            previous2 = "3";
            main2 = "5";
            next2 = "7";
        } else if (disk2 == 3  || disk2 == 17) {
            previous2 = "5";
            main2 = "7";
            next2 = "A";
        } else if (disk2 == 4 || disk2 == 18) {
            previous2 = "7";
            main2 = "A";
            next2 = "B";
        } else if (disk2 == 5) {
            previous2 = "A";
            main2 = "B";
            next2 = "C";
        } else if (disk2 == 6) {
            previous2 = "B";
            main2 = "C";
            next2 = "1";
        } else if (disk2 == 7) {
            previous2 = "C";
            main2 = "1";
            next2 = "3";
        } else if (disk2 == 8) {
            previous2 = "1";
            main2 = "3";
            next2 = "5";
        } else if (disk2 == 9) {
            previous2 = "3";
            main2 = "5";
            next2 = "7";
        } else if (disk2 == 10) {
            previous2 = "5";
            main2 = "7";
            next2 = "2";
        } else if (disk2 == 11) {
            previous2 = "7";
            main2 = "2";
            next2 = "4";
        } else if (disk2 == 12) {
            previous2 = "2";
            main2 = "4";
            next2 = "6";
        } else if (disk2 == 13) {
            previous2 = "4";
            main2 = "6";
            next2 = "1";
        }
        // Disco 3
        if (disk3 == 0 || disk3 == 16) {
            previous3 = "1";
            main3 = "7";
            next3 = "6";
        } else if (disk3 == 1 || disk3 == 17) {
            previous3 = "7";
            main3 = "6";
            next3 = "5";
        } else if (disk3 == 2 || disk3 == 18) {
            previous3 = "6";
            main3 = "5";
            next3 = "A";
        } else if (disk3 == 3) {
            previous3 = "5";
            main3 = "A";
            next3 = "1";
        } else if (disk3 == 4) {
            previous3 = "A";
            main3 = "1";
            next3 = "C";
        } else if (disk3 == 5) {
            previous3 = "1";
            main3 = "C";
            next3 = "B";
        } else if (disk3 == 6) {
            previous3 = "C";
            main3 = "B";
            next3 = "1";
        } else if (disk3 == 7) {
            previous3 = "B";
            main3 = "1";
            next3 = "4";
        } else if (disk3 == 8) {
            previous3 = "1";
            main3 = "4";
            next3 = "3";
        } else if (disk3 == 9) {
            previous3 = "4";
            main3 = "3";
            next3 = "A";
        } else if (disk3 == 10) {
            previous3 = "3";
            main3 = "A";
            next3 = "1";
        } else if (disk3 == 11) {
            previous3 = "A";
            main3 = "1";
            next3 = "B";
        } else if (disk3 == 12) {
            previous3 = "1";
            main3 = "B";
            next3 = "C";
        } else if (disk3 == 13) {
            previous3 = "B";
            main3 = "C";
            next3 = "2";
        } else if (disk3 == 14) {
            previous3 = "C";
            main3 = "2";
            next3 = "1";
        } else if (disk3 == 15) {
            previous3 = "2";
            main3 = "1";
            next3 = "7";
        }
        // Disco 4
        if (disk4 == 0 || disk4 == 17) {
            previous4 = "7";
            main4 = "C";
            next4 = "B";
        } else if (disk1 == 1 || disk4 == 18) {
            previous4 = "C";
            main4 = "B";
            next4 = "A";
        } else if (disk4 == 2) {
            previous4 = "B";
            main4 = "A";
            next4 = "C";
        } else if (disk4 == 3) {
            previous4 = "A";
            main4 = "C";
            next4 = "7";
        } else if (disk4 == 4) {
            previous4 = "C";
            main4 = "7";
            next4 = "B";
        } else if (disk4 == 5) {
            previous4 = "7";
            main4 = "B";
            next4 = "A";
        } else if (disk4 == 6) {
            previous4 = "B";
            main4 = "A";
            next4 = "1";
        } else if (disk4 == 7) {
            previous4 = "A";
            main4 = "1";
            next4 = "2";
        } else if (disk4 == 8) {
            previous4 = "1";
            main4 = "2";
            next4 = "3";
        } else if (disk4 == 9) {
            previous4 = "2";
            main4 = "3";
            next4 = "1";
        } else if (disk4 == 10) {
            previous4 = "3";
            main4 = "1";
            next4 = "2";
        } else if (disk4 == 11) {
            previous4 = "1";
            main4 = "2";
            next4 = "3";
        } else if (disk4 == 12) {
            previous4 = "2";
            main4 = "3";
            next4 = "4";
        } else if (disk4 == 13) {
            previous4 = "3";
            main4 = "4";
            next4 = "5";
        } else if (disk4 == 14) {
            previous4 = "4";
            main4 = "5";
            next4 = "7";
        } else if (disk4 == 15) {
            previous4 = "5";
            main4 = "7";
            next4 = "7";
        } else if (disk4 == 16) {
            previous4 = "7";
            main4 = "7";
            next4 = "C";
        }
        // Disco 5
        if (disk5 == 0) {
            previous5 = "C";
            main5 = "7";
            next5 = "7";
        } else if (disk5 == 1) {
            previous5 = "7";
            main5 = "7";
            next5 = "6";
        } else if (disk5 == 2) {
            previous5 = "7";
            main5 = "6";
            next5 = "6";
        } else if (disk5 == 3) {
            previous5 = "6";
            main5 = "6";
            next5 = "5";
        } else if (disk5 == 4) {
            previous5 = "6";
            main5 = "5";
            next5 = "5";
        } else if (disk5 == 5) {
            previous5 = "5";
            main5 = "5";
            next5 = "4";
        } else if (disk5 == 6) {
            previous5 = "5";
            main5 = "4";
            next5 = "4";
        } else if (disk5 == 7) {
            previous5 = "4";
            main5 = "4";
            next5 = "3";
        } else if (disk5 == 8) {
            previous5 = "4";
            main5 = "3";
            next5 = "3";
        } else if (disk5 == 9) {
            previous5 = "3";
            main5 = "3";
            next5 = "2";
        } else if (disk5 == 10) {
            previous5 = "3";
            main5 = "2";
            next5 = "2";
        } else if (disk5 == 11) {
            previous5 = "2";
            main5 = "2";
            next5 = "1";
        } else if (disk5 == 12) {
            previous5 = "2";
            main5 = "1";
            next5 = "1";
        } else if (disk5 == 13) {
            previous5 = "1";
            main5 = "1";
            next5 = "A";
        } else if (disk5 == 14) {
            previous5 = "1";
            main5 = "A";
            next5 = "B";
        } else if (disk5 == 15) {
            previous5 = "A";
            main5 = "B";
            next5 = "B";
        } else if (disk5 == 16) {
            previous5 = "B";
            main5 = "B";
            next5 = "C";
        } else if (disk5 == 17) {
            previous5 = "B";
            main5 = "C";
            next5 = "C";
        } else if (disk5 == 18) {
            previous5 = "C";
            main5 = "C";
            next5 = "7";
        }
        
        // Impresion de Ruleta
        // System.out.println("=-=-=-=-=-=-=-=-=\nDISCO 1 =-= Prev: "+previous1+" =-= Main: "+main1+" =-= Next: "+next1); // Graficacion del disco 1.
        // System.out.println("=-=-=-=-=-=-=-=-=\nDISCO 2 =-= Prev: "+previous2+" =-= Main: "+main2+" =-= Next: "+next2); // Graficacion del disco 2.
        // System.out.println("=-=-=-=-=-=-=-=-=\nDISCO 3 =-= Prev: "+previous3+" =-= Main: "+main3+" =-= Next: "+next3); // Graficacion del disco 3.
        // System.out.println("=-=-=-=-=-=-=-=-=\nDISCO 4 =-= Prev: "+previous4+" =-= Main: "+main4+" =-= Next: "+next4); // Graficacion del disco 4.
        // System.out.println("=-=-=-=-=-=-=-=-=\nDISCO 5 =-= Prev: "+previous5+" =-= Main: "+main5+" =-= Next: "+next5+"\n=-=-=-=-=-=-=-=-=");  // Graficacion del disco 5.
        System.out.println("=-=-=-=-=-=-=-=-=\n<<< =-= "+previous1+" =-= "+previous2+" =-= "+previous3+" =-= "+previous4+" =-= "+previous5+" =-= >>>"); // Graficacion de la Linea de Valores Secundarios Previos.
        System.out.println("<<< =-= "+main1+" =-= "+main2+" =-= "+main3+" =-= "+main4+" =-= "+main5+" =-= >>>"); // Graficacion de la Linea de Valores Secundarios Previos.
        System.out.println("<<< =-= "+next1+" =-= "+next2+" =-= "+next3+" =-= "+next4+" =-= "+next5+" =-= >>>\n=-=-=-=-=-=-=-=-="); // Graficacion de la Linea de Valores Secundarios Previos.
        
        // Valoraciones de los casos de ganancias.
        if (main1.equals(main2) && main1.equals(main3) && main1.equals(main4) && main1.equals(main5)) { // Los 5 simbolos principales coinciden.
            winning = winning + 40;
            // Hay 5 simbolos principales coincidentes, y coincide con al menos dos de los secundarios.
            if ((main1.equals(previous1) 
            && (previous2.equals(previous1) || previous3.equals(previous1) || previous4.equals(previous1) 
            || previous5.equals(previous1) || next1.equals(previous1) || next2.equals(previous1)
            || next3.equals(previous1) || next4.equals(previous1) || next5.equals(previous1))) // Termina comparacion con previous 1.
            || (main1.equals(previous2) 
            && (previous3.equals(previous2) || previous4.equals(previous2) || previous5.equals(previous2) 
            || next1.equals(previous2) || next2.equals(previous2) || next3.equals(previous2)
            || next4.equals(previous2) || next5.equals(previous2))) // Termina comparacion con previous 2.
            || (main1.equals(previous3) 
            && (previous4.equals(previous3) || previous5.equals(previous3) || next1.equals(previous3) 
            || next2.equals(previous3) || next3.equals(previous3) || next4.equals(previous3)
            || next5.equals(previous3))) // Termina comparacion con previous 3.
            || (main1.equals(previous4) 
            && (previous5.equals(previous4) || next1.equals(previous4) || next2.equals(previous4) 
            || next3.equals(previous4) || next4.equals(previous4) || next5.equals(previous4)))// Termina comparacion con previous 4.
            || (main1.equals(previous5) 
            && (next1.equals(previous5) || next2.equals(previous5) || next3.equals(previous5) 
            || next4.equals(previous5) || next5.equals(previous5))) // Termina comparacion con previous 5.
            || (main1.equals(next1) 
            && (next2.equals(next1) || next3.equals(next1) || next4.equals(next1) 
            || next5.equals(next1))) // Termina comparacion con next 1.
            || (main1.equals(next2) 
            && (next3.equals(next2) || next4.equals(next2) || next5.equals(next2))) // Termina comparacion con next 2.
            || (main1.equals(next3) 
            && (next4.equals(next3) || next5.equals(next3))) // Termina comparacion con next 3.
            || (main1.equals(next4) && (next5.equals(next4))) // Termina comparacion con next 4.
            )
            {
                winning = winning + 25;
            }
        } else if ((main2.equals(main1) && main3.equals(main1) && main4.equals(main1))
        || (main2.equals(main1) && main3.equals(main1) && main5.equals(main1))
        || (main2.equals(main1) && main4.equals(main1) && main5.equals(main1))
        || (main3.equals(main1) && main4.equals(main1) && main5.equals(main1)) 
        || (main3.equals(main2) && main4.equals(main2) && main5.equals(main2))) { // Hay unicamente 4 simbolos coincidentes entre los resultados principales.
            winning = winning + 50;
            // Hay unicamente 4 simbolos principales coincidentes, y coincide con al menos dos de los secundarios.
            if (((main1.equals(previous1) // Comparando los discos principales
            && (previous2.equals(previous1) || previous3.equals(previous1) || previous4.equals(previous1) 
            || previous5.equals(previous1) || next1.equals(previous1) || next2.equals(previous1)
            || next3.equals(previous1) || next4.equals(previous1) || next5.equals(previous1))) // Termina comparacion con previous 1.
            || (main1.equals(previous2) 
            && (previous3.equals(previous2) || previous4.equals(previous2) || previous5.equals(previous2) 
            || next1.equals(previous2) || next2.equals(previous2) || next3.equals(previous2)
            || next4.equals(previous2) || next5.equals(previous2))) // Termina comparacion con previous 2.
            || (main1.equals(previous3) 
            && (previous4.equals(previous3) || previous5.equals(previous3) || next1.equals(previous3) 
            || next2.equals(previous3) || next3.equals(previous3) || next4.equals(previous3)
            || next5.equals(previous3))) // Termina comparacion con previous 3.
            || (main1.equals(previous4) 
            && (previous5.equals(previous4) || next1.equals(previous4) || next2.equals(previous4) 
            || next3.equals(previous4) || next4.equals(previous4) || next5.equals(previous4)))// Termina comparacion con previous 4.
            || (main1.equals(previous5) 
            && (next1.equals(previous5) || next2.equals(previous5) || next3.equals(previous5) 
            || next4.equals(previous5) || next5.equals(previous5))) // Termina comparacion con previous 5.
            || (main1.equals(next1) 
            && (next2.equals(next1) || next3.equals(next1) || next4.equals(next1) 
            || next5.equals(next1))) // Termina comparacion con next 1.
            || (main1.equals(next2) 
            && (next3.equals(next2) || next4.equals(next2) || next5.equals(next2))) // Termina comparacion con next 2.
            || (main1.equals(next3) 
            && (next4.equals(next3) || next5.equals(next3))) // Termina comparacion con next 3.
            || (main1.equals(next4) && (next5.equals(next4))) // Termina comparacion con next 4.
            )
            || ((main2.equals(previous1) // Comparando los discos principales.
            && (previous2.equals(previous1) || previous3.equals(previous1) || previous4.equals(previous1) 
            || previous5.equals(previous1) || next1.equals(previous1) || next2.equals(previous1)
            || next3.equals(previous1) || next4.equals(previous1) || next5.equals(previous1))) // Termina comparacion con previous 1.
            || (main2.equals(previous2) 
            && (previous3.equals(previous2) || previous4.equals(previous2) || previous5.equals(previous2) 
            || next1.equals(previous2) || next2.equals(previous2) || next3.equals(previous2)
            || next4.equals(previous2) || next5.equals(previous2))) // Termina comparacion con previous 2.
            || (main2.equals(previous3) 
            && (previous4.equals(previous3) || previous5.equals(previous3) || next1.equals(previous3) 
            || next2.equals(previous3) || next3.equals(previous3) || next4.equals(previous3)
            || next5.equals(previous3))) // Termina comparacion con previous 3.
            || (main2.equals(previous4) 
            && (previous5.equals(previous4) || next1.equals(previous4) || next2.equals(previous4) 
            || next3.equals(previous4) || next4.equals(previous4) || next5.equals(previous4)))// Termina comparacion con previous 4.
            || (main2.equals(previous5) 
            && (next1.equals(previous5) || next2.equals(previous5) || next3.equals(previous5) 
            || next4.equals(previous5) || next5.equals(previous5))) // Termina comparacion con previous 5.
            || (main2.equals(next1) 
            && (next2.equals(next1) || next3.equals(next1) || next4.equals(next1) 
            || next5.equals(next1))) // Termina comparacion con next 1.
            || (main2.equals(next2) 
            && (next3.equals(next2) || next4.equals(next2) || next5.equals(next2))) // Termina comparacion con next 2.
            || (main2.equals(next3) 
            && (next4.equals(next3) || next5.equals(next3))) // Termina comparacion con next 3.
            || (main2.equals(next4) && (next5.equals(next4))) // Termina comparacion con next 4.
            ))
            {
                winning = winning + 4.5;
            }
        } else if ((main2.equals(main1) && main3.equals(main1))
        || (main2.equals(main1) && main4.equals(main1))
        || (main2.equals(main1) && main5.equals(main1))
        || (main3.equals(main1) && main4.equals(main1)) 
        || (main3.equals(main1) && main5.equals(main1))
        || (main4.equals(main1) && main5.equals(main1))
        || (main3.equals(main2) && main4.equals(main2))
        || (main3.equals(main2) && main5.equals(main2))
        || (main4.equals(main2) && main5.equals(main2))
        || (main4.equals(main3) && main5.equals(main3))) { // Hay unicamente 3 simbolos coincidentes entre los resultados principales.
            winning = winning + 1.5;
            // Hay unicamente 3 simbolos principales coincidentes, y coincide con al menos dos de los secundarios.
            if (((main1.equals(previous1) // Comparando los discos principales
            && (previous2.equals(previous1) || previous3.equals(previous1) || previous4.equals(previous1) 
            || previous5.equals(previous1) || next1.equals(previous1) || next2.equals(previous1)
            || next3.equals(previous1) || next4.equals(previous1) || next5.equals(previous1))) // Termina comparacion con previous 1.
            || (main1.equals(previous2) 
            && (previous3.equals(previous2) || previous4.equals(previous2) || previous5.equals(previous2) 
            || next1.equals(previous2) || next2.equals(previous2) || next3.equals(previous2)
            || next4.equals(previous2) || next5.equals(previous2))) // Termina comparacion con previous 2.
            || (main1.equals(previous3) 
            && (previous4.equals(previous3) || previous5.equals(previous3) || next1.equals(previous3) 
            || next2.equals(previous3) || next3.equals(previous3) || next4.equals(previous3)
            || next5.equals(previous3))) // Termina comparacion con previous 3.
            || (main1.equals(previous4) 
            && (previous5.equals(previous4) || next1.equals(previous4) || next2.equals(previous4) 
            || next3.equals(previous4) || next4.equals(previous4) || next5.equals(previous4)))// Termina comparacion con previous 4.
            || (main1.equals(previous5) 
            && (next1.equals(previous5) || next2.equals(previous5) || next3.equals(previous5) 
            || next4.equals(previous5) || next5.equals(previous5))) // Termina comparacion con previous 5.
            || (main1.equals(next1) 
            && (next2.equals(next1) || next3.equals(next1) || next4.equals(next1) 
            || next5.equals(next1))) // Termina comparacion con next 1.
            || (main1.equals(next2) 
            && (next3.equals(next2) || next4.equals(next2) || next5.equals(next2))) // Termina comparacion con next 2.
            || (main1.equals(next3) 
            && (next4.equals(next3) || next5.equals(next3))) // Termina comparacion con next 3.
            || (main1.equals(next4) && (next5.equals(next4))) // Termina comparacion con next 4.
            )
            || ((main2.equals(previous1) // Comparando los discos principales.
            && (previous2.equals(previous1) || previous3.equals(previous1) || previous4.equals(previous1) 
            || previous5.equals(previous1) || next1.equals(previous1) || next2.equals(previous1)
            || next3.equals(previous1) || next4.equals(previous1) || next5.equals(previous1))) // Termina comparacion con previous 1.
            || (main2.equals(previous2) 
            && (previous3.equals(previous2) || previous4.equals(previous2) || previous5.equals(previous2) 
            || next1.equals(previous2) || next2.equals(previous2) || next3.equals(previous2)
            || next4.equals(previous2) || next5.equals(previous2))) // Termina comparacion con previous 2.
            || (main2.equals(previous3) 
            && (previous4.equals(previous3) || previous5.equals(previous3) || next1.equals(previous3) 
            || next2.equals(previous3) || next3.equals(previous3) || next4.equals(previous3)
            || next5.equals(previous3))) // Termina comparacion con previous 3.
            || (main2.equals(previous4) 
            && (previous5.equals(previous4) || next1.equals(previous4) || next2.equals(previous4) 
            || next3.equals(previous4) || next4.equals(previous4) || next5.equals(previous4)))// Termina comparacion con previous 4.
            || (main2.equals(previous5) 
            && (next1.equals(previous5) || next2.equals(previous5) || next3.equals(previous5) 
            || next4.equals(previous5) || next5.equals(previous5))) // Termina comparacion con previous 5.
            || (main2.equals(next1) 
            && (next2.equals(next1) || next3.equals(next1) || next4.equals(next1) 
            || next5.equals(next1))) // Termina comparacion con next 1.
            || (main2.equals(next2) 
            && (next3.equals(next2) || next4.equals(next2) || next5.equals(next2))) // Termina comparacion con next 2.
            || (main2.equals(next3) 
            && (next4.equals(next3) || next5.equals(next3))) // Termina comparacion con next 3.
            || (main2.equals(next4) && (next5.equals(next4))) // Termina comparacion con next 4.
            )
            || ((main3.equals(previous1) // Comparando los discos principales.
            && (previous2.equals(previous1) || previous3.equals(previous1) || previous4.equals(previous1) 
            || previous5.equals(previous1) || next1.equals(previous1) || next2.equals(previous1)
            || next3.equals(previous1) || next4.equals(previous1) || next5.equals(previous1))) // Termina comparacion con previous 1.
            || (main3.equals(previous2) 
            && (previous3.equals(previous2) || previous4.equals(previous2) || previous5.equals(previous2) 
            || next1.equals(previous2) || next2.equals(previous2) || next3.equals(previous2)
            || next4.equals(previous2) || next5.equals(previous2))) // Termina comparacion con previous 2.
            || (main3.equals(previous3) 
            && (previous4.equals(previous3) || previous5.equals(previous3) || next1.equals(previous3) 
            || next2.equals(previous3) || next3.equals(previous3) || next4.equals(previous3)
            || next5.equals(previous3))) // Termina comparacion con previous 3.
            || (main3.equals(previous4) 
            && (previous5.equals(previous4) || next1.equals(previous4) || next2.equals(previous4) 
            || next3.equals(previous4) || next4.equals(previous4) || next5.equals(previous4)))// Termina comparacion con previous 4.
            || (main3.equals(previous5) 
            && (next1.equals(previous5) || next2.equals(previous5) || next3.equals(previous5) 
            || next4.equals(previous5) || next5.equals(previous5))) // Termina comparacion con previous 5.
            || (main3.equals(next1) 
            && (next2.equals(next1) || next3.equals(next1) || next4.equals(next1) 
            || next5.equals(next1))) // Termina comparacion con next 1.
            || (main3.equals(next2) 
            && (next3.equals(next2) || next4.equals(next2) || next5.equals(next2))) // Termina comparacion con next 2.
            || (main3.equals(next3) 
            && (next4.equals(next3) || next5.equals(next3))) // Termina comparacion con next 3.
            || (main3.equals(next4) && (next5.equals(next4))) // Termina comparacion con next 4.
            ))
            {
                winning = winning + 4;
            }
        } else if (main2.equals(main1) || main3.equals(main1)
        || main4.equals(main1) || main5.equals(main1)
        || main3.equals(main2) || main4.equals(main2)
        || main5.equals(main2) || main4.equals(main3)
        || main5.equals(main3) || main5.equals(main4)) { // Hay unicamente 2 simbolos coincidentes entre los resultados principales.
            winning = winning + 1.5;
            // Hay unicamente 3 simbolos principales coincidentes, y coincide con al menos dos de los secundarios.
            if (((main1.equals(previous1) // Comparando los discos principales
            && (previous2.equals(previous1) || previous3.equals(previous1) || previous4.equals(previous1) 
            || previous5.equals(previous1) || next1.equals(previous1) || next2.equals(previous1)
            || next3.equals(previous1) || next4.equals(previous1) || next5.equals(previous1))) // Termina comparacion con previous 1.
            || (main1.equals(previous2) 
            && (previous3.equals(previous2) || previous4.equals(previous2) || previous5.equals(previous2) 
            || next1.equals(previous2) || next2.equals(previous2) || next3.equals(previous2)
            || next4.equals(previous2) || next5.equals(previous2))) // Termina comparacion con previous 2.
            || (main1.equals(previous3) 
            && (previous4.equals(previous3) || previous5.equals(previous3) || next1.equals(previous3) 
            || next2.equals(previous3) || next3.equals(previous3) || next4.equals(previous3)
            || next5.equals(previous3))) // Termina comparacion con previous 3.
            || (main1.equals(previous4) 
            && (previous5.equals(previous4) || next1.equals(previous4) || next2.equals(previous4) 
            || next3.equals(previous4) || next4.equals(previous4) || next5.equals(previous4)))// Termina comparacion con previous 4.
            || (main1.equals(previous5) 
            && (next1.equals(previous5) || next2.equals(previous5) || next3.equals(previous5) 
            || next4.equals(previous5) || next5.equals(previous5))) // Termina comparacion con previous 5.
            || (main1.equals(next1) 
            && (next2.equals(next1) || next3.equals(next1) || next4.equals(next1) 
            || next5.equals(next1))) // Termina comparacion con next 1.
            || (main1.equals(next2) 
            && (next3.equals(next2) || next4.equals(next2) || next5.equals(next2))) // Termina comparacion con next 2.
            || (main1.equals(next3) 
            && (next4.equals(next3) || next5.equals(next3))) // Termina comparacion con next 3.
            || (main1.equals(next4) && (next5.equals(next4))) // Termina comparacion con next 4.
            )
            || ((main2.equals(previous1) // Comparando los discos principales.
            && (previous2.equals(previous1) || previous3.equals(previous1) || previous4.equals(previous1) 
            || previous5.equals(previous1) || next1.equals(previous1) || next2.equals(previous1)
            || next3.equals(previous1) || next4.equals(previous1) || next5.equals(previous1))) // Termina comparacion con previous 1.
            || (main2.equals(previous2) 
            && (previous3.equals(previous2) || previous4.equals(previous2) || previous5.equals(previous2) 
            || next1.equals(previous2) || next2.equals(previous2) || next3.equals(previous2)
            || next4.equals(previous2) || next5.equals(previous2))) // Termina comparacion con previous 2.
            || (main2.equals(previous3) 
            && (previous4.equals(previous3) || previous5.equals(previous3) || next1.equals(previous3) 
            || next2.equals(previous3) || next3.equals(previous3) || next4.equals(previous3)
            || next5.equals(previous3))) // Termina comparacion con previous 3.
            || (main2.equals(previous4) 
            && (previous5.equals(previous4) || next1.equals(previous4) || next2.equals(previous4) 
            || next3.equals(previous4) || next4.equals(previous4) || next5.equals(previous4)))// Termina comparacion con previous 4.
            || (main2.equals(previous5) 
            && (next1.equals(previous5) || next2.equals(previous5) || next3.equals(previous5) 
            || next4.equals(previous5) || next5.equals(previous5))) // Termina comparacion con previous 5.
            || (main2.equals(next1) 
            && (next2.equals(next1) || next3.equals(next1) || next4.equals(next1) 
            || next5.equals(next1))) // Termina comparacion con next 1.
            || (main2.equals(next2) 
            && (next3.equals(next2) || next4.equals(next2) || next5.equals(next2))) // Termina comparacion con next 2.
            || (main2.equals(next3) 
            && (next4.equals(next3) || next5.equals(next3))) // Termina comparacion con next 3.
            || (main2.equals(next4) && (next5.equals(next4))) // Termina comparacion con next 4.
            )
            || ((main3.equals(previous1) // Comparando los discos principales.
            && (previous2.equals(previous1) || previous3.equals(previous1) || previous4.equals(previous1) 
            || previous5.equals(previous1) || next1.equals(previous1) || next2.equals(previous1)
            || next3.equals(previous1) || next4.equals(previous1) || next5.equals(previous1))) // Termina comparacion con previous 1.
            || (main3.equals(previous2) 
            && (previous3.equals(previous2) || previous4.equals(previous2) || previous5.equals(previous2) 
            || next1.equals(previous2) || next2.equals(previous2) || next3.equals(previous2)
            || next4.equals(previous2) || next5.equals(previous2))) // Termina comparacion con previous 2.
            || (main3.equals(previous3) 
            && (previous4.equals(previous3) || previous5.equals(previous3) || next1.equals(previous3) 
            || next2.equals(previous3) || next3.equals(previous3) || next4.equals(previous3)
            || next5.equals(previous3))) // Termina comparacion con previous 3.
            || (main3.equals(previous4) 
            && (previous5.equals(previous4) || next1.equals(previous4) || next2.equals(previous4) 
            || next3.equals(previous4) || next4.equals(previous4) || next5.equals(previous4)))// Termina comparacion con previous 4.
            || (main3.equals(previous5) 
            && (next1.equals(previous5) || next2.equals(previous5) || next3.equals(previous5) 
            || next4.equals(previous5) || next5.equals(previous5))) // Termina comparacion con previous 5.
            || (main3.equals(next1) 
            && (next2.equals(next1) || next3.equals(next1) || next4.equals(next1) 
            || next5.equals(next1))) // Termina comparacion con next 1.
            || (main3.equals(next2) 
            && (next3.equals(next2) || next4.equals(next2) || next5.equals(next2))) // Termina comparacion con next 2.
            || (main3.equals(next3) 
            && (next4.equals(next3) || next5.equals(next3))) // Termina comparacion con next 3.
            || (main3.equals(next4) && (next5.equals(next4))) // Termina comparacion con next 4.
            )
            || ((main4.equals(previous1) // Comparando los discos principales.
            && (previous2.equals(previous1) || previous3.equals(previous1) || previous4.equals(previous1) 
            || previous5.equals(previous1) || next1.equals(previous1) || next2.equals(previous1)
            || next3.equals(previous1) || next4.equals(previous1) || next5.equals(previous1))) // Termina comparacion con previous 1.
            || (main4.equals(previous2) 
            && (previous3.equals(previous2) || previous4.equals(previous2) || previous5.equals(previous2) 
            || next1.equals(previous2) || next2.equals(previous2) || next3.equals(previous2)
            || next4.equals(previous2) || next5.equals(previous2))) // Termina comparacion con previous 2.
            || (main4.equals(previous3) 
            && (previous4.equals(previous3) || previous5.equals(previous3) || next1.equals(previous3) 
            || next2.equals(previous3) || next3.equals(previous3) || next4.equals(previous3)
            || next5.equals(previous3))) // Termina comparacion con previous 3.
            || (main4.equals(previous4) 
            && (previous5.equals(previous4) || next1.equals(previous4) || next2.equals(previous4) 
            || next3.equals(previous4) || next4.equals(previous4) || next5.equals(previous4)))// Termina comparacion con previous 4.
            || (main4.equals(previous5) 
            && (next1.equals(previous5) || next2.equals(previous5) || next3.equals(previous5) 
            || next4.equals(previous5) || next5.equals(previous5))) // Termina comparacion con previous 5.
            || (main4.equals(next1) 
            && (next2.equals(next1) || next3.equals(next1) || next4.equals(next1) 
            || next5.equals(next1))) // Termina comparacion con next 1.
            || (main4.equals(next2) 
            && (next3.equals(next2) || next4.equals(next2) || next5.equals(next2))) // Termina comparacion con next 2.
            || (main4.equals(next3) 
            && (next4.equals(next3) || next5.equals(next3))) // Termina comparacion con next 3.
            || (main4.equals(next4) && (next5.equals(next4))) // Termina comparacion con next 4.
            )
            )
            {
                winning = winning;
            }
        }
        
        if (main1.equals("A") && main2.equals("A") && main3.equals("A") && main4.equals("A") && main5.equals("A")) { // Hay 5 simbolos de la letra A entre los resultados principales.
            winning = winning + 200;
        } else if ((main1.equals("A") && main2.equals("A") && main3.equals("A") && main4.equals("A"))
        || (main1.equals("A") && main2.equals("A") && main3.equals("A") && main5.equals("A"))
        || (main1.equals("A") && main2.equals("A") && main4.equals("A") && main5.equals("A"))
        || (main1.equals("A") && main3.equals("A") && main4.equals("A") && main5.equals("A")) 
        || (main2.equals("A") && main3.equals("A") && main4.equals("A") && main5.equals("A"))) { // Hay unicamente 4 simbolos de la letra A entre los resultados principales.
            winning = winning + 50;
        } else if ((main1.equals("A") && main2.equals("A") && main3.equals("A"))
        || (main1.equals("A") && main2.equals("A") && main4.equals("A"))
        || (main1.equals("A") && main2.equals("A") && main5.equals("A"))
        || (main1.equals("A") && main3.equals("A") && main4.equals("A")) 
        || (main1.equals("A") && main3.equals("A") && main5.equals("A"))
        || (main1.equals("A") && main4.equals("A") && main5.equals("A"))
        || (main2.equals("A") && main3.equals("A") && main4.equals("A"))
        || (main2.equals("A") && main3.equals("A") && main5.equals("A"))
        || (main2.equals("A") && main4.equals("A") && main5.equals("A"))
        || (main3.equals("A") && main4.equals("A") && main5.equals("A"))) { // Hay unicamente 3 simbolos de la letra A entre los resultados principales.
            winning = winning + 20;
        }
        
        // Hay 5 simbolos coincidentes entre los resultados secundarios.
        if ((previous2.equals(previous1) && previous3.equals(previous1) && previous4.equals(previous1) && previous5.equals(previous1)) 
        || (previous2.equals(previous1) && previous3.equals(previous1) && previous4.equals(previous1) && next1.equals(previous1)) 
        || (previous2.equals(previous1) && previous3.equals(previous1) && previous4.equals(previous1) && next2.equals(previous1)) 
        || (previous2.equals(previous1) && previous3.equals(previous1) && previous4.equals(previous1) && next3.equals(previous1))
        || (previous2.equals(previous1) && previous3.equals(previous1) && previous4.equals(previous1) && next4.equals(previous1))
        || (previous2.equals(previous1) && previous3.equals(previous1) && previous4.equals(previous1) && next5.equals(previous1))
        || (previous2.equals(previous1) && previous3.equals(previous1) && previous5.equals(previous1) && next1.equals(previous1))
        || (previous2.equals(previous1) && previous3.equals(previous1) && previous5.equals(previous1) && next2.equals(previous1))
        || (previous2.equals(previous1) && previous3.equals(previous1) && previous5.equals(previous1) && next3.equals(previous1))
        || (previous2.equals(previous1) && previous3.equals(previous1) && previous5.equals(previous1) && next4.equals(previous1))
        || (previous2.equals(previous1) && previous3.equals(previous1) && previous5.equals(previous1) && next5.equals(previous1))
        || (previous2.equals(previous1) && previous4.equals(previous1) && previous5.equals(previous1) && next1.equals(previous1))
        || (previous2.equals(previous1) && previous4.equals(previous1) && previous5.equals(previous1) && next2.equals(previous1))
        || (previous2.equals(previous1) && previous4.equals(previous1) && previous5.equals(previous1) && next3.equals(previous1))
        || (previous2.equals(previous1) && previous4.equals(previous1) && previous5.equals(previous1) && next4.equals(previous1))
        || (previous2.equals(previous1) && previous4.equals(previous1) && previous5.equals(previous1) && next5.equals(previous1))
        || (previous3.equals(previous1) && previous4.equals(previous1) && previous5.equals(previous1) && next1.equals(previous1))
        || (previous3.equals(previous1) && previous4.equals(previous1) && previous5.equals(previous1) && next2.equals(previous1))
        || (previous3.equals(previous1) && previous4.equals(previous1) && previous5.equals(previous1) && next3.equals(previous1))
        || (previous3.equals(previous1) && previous4.equals(previous1) && previous5.equals(previous1) && next4.equals(previous1))
        || (previous3.equals(previous1) && previous4.equals(previous1) && previous5.equals(previous1) && next5.equals(previous1))
        || (previous4.equals(previous1) && previous5.equals(previous1) && next1.equals(previous1) && next2.equals(previous1))
        || (previous4.equals(previous1) && previous5.equals(previous1) && next1.equals(previous1) && next3.equals(previous1))
        || (previous4.equals(previous1) && previous5.equals(previous1) && next1.equals(previous1) && next4.equals(previous1))
        || (previous4.equals(previous1) && previous5.equals(previous1) && next1.equals(previous1) && next5.equals(previous1))
        || (previous5.equals(previous1) && next1.equals(previous1) && next2.equals(previous1) && next3.equals(previous1))
        || (previous5.equals(previous1) && next1.equals(previous1) && next2.equals(previous1) && next4.equals(previous1))
        || (previous5.equals(previous1) && next1.equals(previous1) && next2.equals(previous1) && next5.equals(previous1))
        || (next1.equals(previous1) && next2.equals(previous1) && next3.equals(previous1) && next4.equals(previous1))
        || (next1.equals(previous1) && next2.equals(previous1) && next3.equals(previous1) && next5.equals(previous1))
        || (next2.equals(previous1) && next3.equals(previous1) && next4.equals(previous1) && next5.equals(previous1)) // Termina comparacion con previous 1.
        
        || (previous3.equals(previous2) && previous4.equals(previous2) && previous5.equals(previous2) && next1.equals(previous2))
        || (previous3.equals(previous2) && previous4.equals(previous2) && previous5.equals(previous2) && next2.equals(previous2))
        || (previous3.equals(previous2) && previous4.equals(previous2) && previous5.equals(previous2) && next3.equals(previous2))
        || (previous3.equals(previous2) && previous4.equals(previous2) && previous5.equals(previous2) && next4.equals(previous2))
        || (previous3.equals(previous2) && previous4.equals(previous2) && previous5.equals(previous2) && next5.equals(previous2))
        || (previous4.equals(previous2) && previous5.equals(previous2) && next1.equals(previous2) && next2.equals(previous2))
        || (previous4.equals(previous2) && previous5.equals(previous2) && next1.equals(previous2) && next3.equals(previous2))
        || (previous4.equals(previous2) && previous5.equals(previous2) && next1.equals(previous2) && next4.equals(previous2))
        || (previous4.equals(previous2) && previous5.equals(previous2) && next1.equals(previous2) && next5.equals(previous2))
        || (previous5.equals(previous2) && next1.equals(previous2) && next2.equals(previous2) && next3.equals(previous2))
        || (previous5.equals(previous2) && next1.equals(previous2) && next2.equals(previous2) && next4.equals(previous2))
        || (previous5.equals(previous2) && next1.equals(previous2) && next2.equals(previous2) && next5.equals(previous2))
        || (next1.equals(previous2) && next2.equals(previous2) && next3.equals(previous2) && next4.equals(previous2))
        || (next1.equals(previous2) && next2.equals(previous2) && next3.equals(previous2) && next5.equals(previous2))
        || (next2.equals(previous2) && next3.equals(previous2) && next4.equals(previous2) && next5.equals(previous2)) // Termina comparacion con previous 2.
        
        || (previous4.equals(previous3) && previous5.equals(previous3) && next1.equals(previous3) && next2.equals(previous3))
        || (previous4.equals(previous3) && previous5.equals(previous3) && next1.equals(previous3) && next3.equals(previous3))
        || (previous4.equals(previous3) && previous5.equals(previous3) && next1.equals(previous3) && next4.equals(previous3))
        || (previous4.equals(previous3) && previous5.equals(previous3) && next1.equals(previous3) && next5.equals(previous3))
        || (previous5.equals(previous3) && next1.equals(previous3) && next2.equals(previous3) && next3.equals(previous3))
        || (previous5.equals(previous3) && next1.equals(previous3) && next2.equals(previous3) && next4.equals(previous3))
        || (previous5.equals(previous3) && next1.equals(previous3) && next2.equals(previous3) && next5.equals(previous3))
        || (next1.equals(previous3) && next2.equals(previous3) && next3.equals(previous3) && next4.equals(previous3))
        || (next1.equals(previous3) && next2.equals(previous3) && next3.equals(previous3) && next5.equals(previous3))
        || (next2.equals(previous3) && next3.equals(previous3) && next4.equals(previous3) && next5.equals(previous3)) // Termina comparacion con previous 3.
        
        || (previous5.equals(previous4) && next1.equals(previous4) && next2.equals(previous4) && next3.equals(previous4))
        || (previous5.equals(previous4) && next1.equals(previous4) && next2.equals(previous4) && next4.equals(previous4))
        || (previous5.equals(previous4) && next1.equals(previous4) && next2.equals(previous4) && next5.equals(previous4))
        || (next1.equals(previous4) && next2.equals(previous4) && next3.equals(previous4) && next4.equals(previous4))
        || (next1.equals(previous4) && next2.equals(previous4) && next3.equals(previous4) && next5.equals(previous4))
        || (next2.equals(previous4) && next3.equals(previous4) && next4.equals(previous4) && next5.equals(previous4)) // Termina comparacion con previous 4.
        
        || (next1.equals(previous5) && next2.equals(previous5) && next3.equals(previous5) && next4.equals(previous5))
        || (next2.equals(previous5) && next3.equals(previous5) && next4.equals(previous5) && next5.equals(previous5)) // Termina comparacion con previous 5.
        
        || (next2.equals(next1) && next3.equals(next1) && next4.equals(next1) && next5.equals(next1)) // Termina comparacion con next 1.
        ) {
            winning = winning + 2.5;
        }
        
        
        double playerBetD = playerBet * winning; // Variable que me multiplica la apuesta, por el valor de ganancia.
        playerBet = (int)playerBetD; // Conversion de double a int de la variable previa.
            
        System.out.println("Usted ha ganado un total de: "+playerBet+"\n=-=-=-=-=-=-=-=-="); // Impresion de la ganancia del jugador en la partida actual.
        return playerBet; // Retorna el valor de las ganacias de la ronda.
    }
}