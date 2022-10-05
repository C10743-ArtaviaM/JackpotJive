------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------
PROJECT TITLE: MÁQUINA TRAGA-MONEDAS || Tarea Programada 1
------------------------------------------------------------------------
PURPOSE OF PROJECT:
    Realizar un programa en Java que funcione como una máquina tragamonedas de un casino, siguiendo las siguientes condiciones:
        - Debe permitir a la persona realizar un ingreso de dinero inicial que acumula en su saldo inicial
        - Debe permitir a la persona hacer una apuesta en cada turno y restarla de su saldo
        - Al jugar cada turno, genera el resultado de girar 5 discos virtuales de forma pseudoaleatoria
        - Si se produce un gane según las reglas del juego, el premio será acumulado en su saldo
        - Si la persona no gana en este tiro, no habrá ninguna otra modificación en su saldo
        - Después de cada turno, se debe dar a la persona la opción de jugar otro turno, agregar más dinero a su saldo, o bien terminar su partida y retirar su dinero.
------------------------------------------------------------------------
VERSION or DATE: V5.0.0 || 9/21/2022
------------------------------------------------------------------------
HOW TO START THIS PROJECT:
    Dentro del programa BlueJ, se le debe dar click derecho a la casilla de la clase "Main", en la lista de opciones, primero le debe dar a "Compile" si es que el programa no
le sale compilado, una vez el programa este compilado, debe realizar la misma accion, sin embargo, ahora elegir la opcion de "void main(String[] args)". Una vez hecho esto,
el programa se inicializara para su uso.
------------------------------------------------------------------------
AUTHORS: Mauricio Artavia Monge | C10743
------------------------------------------------------------------------
USER INSTRUCTIONS:
    Dentro del programa BlueJ, se le debe dar click derecho a la casilla de la clase "Main", en la lista de opciones, primero le debe dar a "Compile" si es que el programa no
    le sale compilado, una vez el programa este compilado, debe realizar la misma accion, sin embargo, ahora elegir la opcion de "void main(String[] args)". Una vez hecho esto,
    el programa se inicializara para su uso.
------------------------------------------------------------------------

------------------------------------------------------------------------
NOTAS DURANTE PROCESO DE CREACION DEL PROGRAMA:                                                             Leyenda: Sin Solucionar (X)
                                                                                                                     Solucionado    (/)
9/21/2022 | 4:29 PM → El programa me esta aceptando montos negativos para el saldo.                                                                                       /
9/21/2022 | 4:31 PM → Primeramente, si me ingresa el saldo con el monto valido, sin embargo, me tira otras respuestas con saldo 0 segun el numero de errores que tuve.    /
9/21/2022 | 5:05 PM → En el menu, me esta permitiendo poner numeros mayores a 3 y menores a 1.                                                                            /
------------------------------------------------------------------------
BITACORA:
9/21/2022 | 6:51 PM → Metodo start (v1) listo.                                                                                       X
9/21/2022 | 4:31yores a 3 y menores a 1.                                                                            X

4/10/2022 | 8:50 AM → Recapitulacion
    Se hicieron los metodos de forma estatica.
    Metodo Main queda con un unico llamado al metodo start.
    Metodo Start me define el saldo inicial del jugador y me llama al metodo menu.
    Metodo Menu me maneja todo el menu del juego, haciendo que me llame al metodo para apostar y jugar, o para subir el saldo del jugador.
    Metodo Bet&Play me maneja la apuesta del jugador y me lama al metodo para controlar la maquina de discos.
    Metodo MachineDisks me hace un llamado al metodo disk el cual me dara un valor de disco para luego analizarlo en el metodo de chequeo de discos.
    Metodo Disk me da un valor pseudo-aleatorio el cual me define un valor principal del disco.
    Metodo CheckDisk se encarga de analizar los discos y segun los valores que da poder dar la ganancia del jugador segun su apuesta.
    Version 2.0 implico un reinicio del 50% del codigo escrito hasta el momento.
    Version 3.0 implico la modificacion del metodo Main incorporando el metodo start.
    Version 4.0 implico la modificacion total del sistema de aplicacion de credito y de los metodos Disk, MachineDisks & CheckDisk.
    Version 5.0 implico la incorporacion del analisis de casos de ganancia y una modificacion leve del sistema de apuesta.


Finalizado el 4/10/2022 | 6:52 PM