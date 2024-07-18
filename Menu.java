public class Menu {
    Input in = new Input();
    String name;
    double credit;

    public void run() {
        this.welcome();
        this.menu();
    }

    public void welcome() {
        String income;
        in.printString("=-=-=-=-=-=--=-=-=-=-=-=\nBienvenido a JACKPOTJIVE\n=-=-=-=-=-=--=-=-=-=-=-=");
        name = "Ingrese Nombre de Usuario: ";
        // name = in.inputString(name);
        income = "Ingrese Cuanto Saldo Desea Ingresar: ";
        this.credit = 5000; // in.inputDouble(income);
    }

    public void menu() {
        String addIncomeMessage = "Ingrese cuanto desea aumentar su saldo: ";
        int menuSelection = 0;
        double addedIncome = 0;

        while (menuSelection != 3) {
            String incomeMessage = "Su saldo actual es de " + this.credit + " colones. Ingrese:\n"
                    + "1) Apostar & Jugar\n"
                    + "2) Aumentar Saldo\n"
                    + "3) Salir & Retirar";
            menuSelection = in.inputInteger(incomeMessage);
            // System.out.println(menuSelection);

            if (menuSelection == 1) {
                play();
            } else if (menuSelection == 2) {
                // AGREGAR SALDO
                addedIncome = in.inputDouble(addIncomeMessage);
                this.credit = this.credit + addedIncome;
            } else if (menuSelection == 3) {
                // SALIR
            }
        }
    }

    public void play() {
        double playerBet;
        boolean canPlay = false;
        String betText = "Por favor, digite cuanto desea apostar: ";

        while (canPlay == false) {
            playerBet = in.inputDouble(betText);

            if (playerBet > this.credit) {
                in.printString("ERROR: Su apuesta ( " + playerBet + " ) no puede ser mayor a su credito actual ( "
                        + this.credit + " ).");
            } else if (playerBet == 0) {
                in.printString("ERROR: Su apuesta no puede ser 0");
            } else if (playerBet > 0 && playerBet <= this.credit) {
                in.printString("CORRECTO");
                canPlay = true;
            }
        }
        in.printString("SALIMO");
        Device device = new Device();
        device.generateDisk();
    }
}
