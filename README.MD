<div id="header" align="center">
  <img src="https://media.giphy.com/media/M9gbBd9nbDrOTu1Mqx/giphy.gif" width="100"/>
</div>

<div id="badges" align="center">
  <a href="https://github.com/C10743-ArtaviaM">
    <img src="https://img.shields.io/badge/GitHub-000000?style=for-the-badge&logo=github&logoColor=white" alt="GitHub Badge"/>
  </a>
</div>

<div align="center">
  <img src="https://media.giphy.com/media/dWesBcTLavkZuG35MI/giphy.gif" width="600" height="300"/>
</div>

---

<div align="center">
  <h2></p>
    <p>UNIVERSIDAD DE COSTA RICA</p>
    <p>FACULTAD DE INGENIERIA</p>
    <p>ESCUELA DE CIENCIAS DE LA COMPUTACION E INFORMATICA</p>
  </h2>
</div>

<div align="center">
  <h2>
    <p>CI0112 Programacion I</p>
    <p>II CICLO 2022</p>
  </h2>
</div>

| _En este laboratorio el o la estudiante utilizara resolucion de problemas para aplicar conceptos de programacion, compilacion y ejecucion, uso de variables con tipos de datos primitivos, operadores, expresiones, estructuras de control, manejo de excepciones y metodos estaticos._ |
| :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |

<h3> Descripcion del problema </h3>

Las maquinas "traga monedas" son maquinas de juegos de azar donde se apuesta una cantidad de dinero, para tratar de ganar un premio en efectivo. Por la naturaleza de las apuestas, no siempre se produce una ganancia para la persona que la utiliza. Hace unos annios, la maquina de este tipo consistia en 3 o mas discos giratorios que contenian varios simbolos, Al presionar una palanca en fisico, la maquina giraba estos discos una cantidad aleatoria de veces y de formas distintas hasta que se detenian los tres, un disco a la vez. De cada uno se tomaba el simbolo que quedo exactamente al frente, y si estos simbolos coinciden, se produce un <b>JACKPOT</b>, es decir, un gane.

Actualmente, la mayoria de estas maquinas son virtuales. En una pantalla, la persona puede seleccionar el monto apostado y poner a girar los discos virtuales. Esto ha abierto la posibilidad de ampliar el juego, pues los discos ya no se limitan a un tamannio fisico de disco giratorio, y puede ser configurada para generar mas premios adicionales. Por ejemplo, ahora se manejan 5 discos virtuales, y no solo se toma en cuenta un valor por disco.

Usted debe realizar un programa en Java que funcione como una maquina tragamonedas de un casino, siguiendo las siguientes condiciones:

<ul class = "hyphens">
  <li>Debe permitir a la persona realizar un ingreso de dinero inicial que acumula en su saldo inicial.</li>
  <li>Debe permitir a la persona hacer una apuesta en cada turno y restarla de su saldo.</li>
  <li>Al jugador cada turno, genera el resultado de girar 5 discos virtuales de forma pseudoaleatoria.</li>
  <li>Si se produce un gane segun las reglas del juego, el premio sera acumulado en su saldo.</li>
  <li>Si la persona no gana en este tiro, no habra ninguna otra modificacion en su saldo.</li>
  <li>Despues de cada turno, se debe dar a la persona la opcion de jugar otro turno, agregar mas dinero a su saldo, o bien terminar su partida y retirar su dinero.</li>
</ul>

<h3> Como funciona la maquina </h3>

<ol class="number-dash">
  <li>El juego se compone de 5 discos giratorios virtuales. Cada disco tiene cierta cantidad de casillas, y cada casilla tiene un simbolo de letra o numero que la identifica. Un simbolo puede aparecer mas de una vez en el mismo disco. A continuacion, se muestran los 5 discos giratorios por emular. Estos discos seran siempre los mismos.

| ID  | Orden de los simbolos en el disco                                         |
| :-: | :------------------------------------------------------------------------ |
|  1  | 1 - 2 - 3 - 4 - 5 - 6 - A - 6 - 5 - 4 - 3 - 2 - 1                         |
|  2  | 1 - 3 - 5 - 7 - A - B - C - 1 - 3 - 5 - 7 - 2 - 4 - 6                     |
|  3  | 7 - 6 - 5 - A - 1 - C - B - 1 - 4 - 3 - A - 1 - B - C - 2 - 1             |
|  4  | C - B - A - C - 7 - B - A - 1 - 2 - 3 - 1 - 2 - 3 - 4 - 5 - 6 - 7 - 7     |
|  5  | 7 - 7 - 6 - 6 - 5 - 5 - 4 - 4 - 3 - 3 - 2 - 2 - 1 - 1 - A - B - B - C - C |

  </li>
  <li>Al  jugar  un  turno,  los  5  discos  giran,  cada  uno  de  ellos  realiza  una  cantidad de  giros  definida  por  el sistema de forma pseudoaleatoria. Es decir, en un turno el disco 1 podría girar 5 veces; el 2, 20 veces; el disco 3, 27 veces; y así con los 5 discos.</li>
  <li>Una vez que cada disco ha sido girado, se generará entonces un resultado de 3 símbolos para ese disco: un principal, y dos adyacentes (es decir, los valores que aparecen arriba y abajo del resultado principal). Es importante tomar en cuenta todos esos resultados, pues podrían repercutir en el monto ganado.</li>
  <li>La combinación de los resultados de los 5 discos debe ser comparada contra las reglas del juego, para determinar el monto que la persona ha ganado. También podría ocurrir  que  no  se genere ninguna ganancia.</li>
  <li>Si hay varios resultados favorables para la persona en la combinacion, los ganara todos.</li>
  <li>Al finalizar el calculo, el programa debe notificar a la persona el resultado exacto de su turno.</li>
</ol>

<h3> Como se ve el programa </h3>

El programa debe manejar interacción con el usuario clara y concisa. Debe mostrarle el resultado de cada turno (los resultados de cada giro y el monto final ganado).

El resultado de cada disco debe ser mostrado en cada turno.

Siempre al mostrar el menú se debe mostrar también el saldo actualizado.

Para montos, puede redondear valores al entero más cercano.

<h3> Reglas del juego para la persona que apuesta </h3>

<ol class = "alpha-dot">
  <li>Para comenzar, usted debe ingresar un saldo inicial de dinero.</li>
  <li>Para jugar un turno, primero debe realizar una apuesta. Usted puede seleccionar la cantidad que desee, siempre que tenga saldo suficiente. Si no tiene saldo suficiente, la maquina le notificara que su apuesta no es valida. Si su apuesta es valida, podra jugar su turno.</li>
  <li>El juego se compone de 5 discos giratorios virtuales. Al jugar un turno, estos discos giran de forma pseudoaleatoria y finalmente cada uno se detiene mostrando un resultado principal (central) y 2 resultados secundarios (las casillas adyacentes).</li>
  <li>Usted ganara premios segun las siguientes reglas, considerando que x es el monto apostado:
  
  | Caso  | Ganancia                                        |
  | :--- | :------------------------------------------------------------------------: |
  | Hay unicamente 2 simbolos coincidentes entre los resultados principales  | 1.2 X        |
  | Hay unicamente 3 simbolos coincidentes entre los resultados principales  | 1.5 X      |
  | Hay unicamente 4 simbolos coincidentes entre los resultados principales  | 5 X    |
  | Los 5 simbolos principales coinciden  | 40 X  |
  | Hay unicamente 2 simbolos principales coincidentes, y coincide con al menos dos de los secundarios  | 1 X |
  | Hay unicamente 3 simbolos principales coincidentes, y coincide con al menos dos de los secundarios | 4 X |
  | Hay unicamente 4 simbolos principales coincidentes, y coincide con al menos dos de los secundarios | 4.5 X |
  | Hay 5 simbolos principales coincidentes, y coincide con al menos dos de los secundarios | 25 X |
  | Hay unicamente 3 simbolos de la letra A entre los resultados principales | 20 X |
  | Hay unicamente 4 simbolos de la letra A entre los resultados principales | 50 X |
  | Hay 5 simbolos de la letra A entre los resultados principales | 200 X |
  | Hay 5 simbolos coincidentes entre los resultados secundarios | 2.5 X |

  </li>
  <li>El sistema le brindarta la oportunidad de jugar mas turnos, ingresar mas dinero a su saldo, o bien terminar la partida y terminar el juego.</li>
</ol>

<h3> Partes del Problema </h3>

Resuelva el problema planteado, considerando los siguientes subproblemas:

<ul>
  <li>Girar un disco y obtener 3 resultados - un principal y 2 secundarios.</li>
  <li>Jugar un turno con los 5 discos dados, segun apuesta realizada, y producir un resultado en efectivo segun las reglas del juego.</li>
  <li>Manejo de saldo total, turnos e interracion con menu principal para la persona que apuesta.</li>
  <li>Validaciones necesarias para que el programa no caiga abruptamente.</li>
</ul>

<h3> Requerimientos Tecnicos </h3>

Debe resolver todo utilizando unicamente los temas cubiertos en clase, por lo que unicamente puede incluir importacion de librerias contempladas en el curso, variables de tipo primitivas y tipo String(NO uso de vectores o arrays, ni memoria dinamica), interaccion de usuario por entrada y salida estandar, operaciones con tipos de datos primitivos y String, estructuras de control, uso de metodos estaticos y metodos de la clase String. El metodo principal no recibira parametros, y unicamente debe contener un llamado inicial a otro metodo.

Para generar numeros pseudoaleatorios puede usar el metodo estatico <i>random</i> de la clase <i>Math</i>. Este metodo no recibe parametros, y le retorna un valor pseudoaleatorio flotante entre 0 y 1 (excluyendo el 1).

Use manejo de excepciones para que, en caso de error, no se detenga abruptamente.

<h6> Notas </h6>

Al ser una mejoria del proyecto inicial, por hobby, se permitira el uso de vectores, arrays y similares, ademas de que se podra tener interaccion por interfaz grafica, y demas cosas que estuvieron restringidas en un inicio.

<h3> Formato de Entrega </h3>

Entregue el reporte de laboratorio antes de la fecha y hora descrita en la plataforma virtual. Debe entregar los archivos <b>de tipo .java</b> con la solucion. La entrega debe ser un archivo comprimido en .zip, .rar o .7z y el titulo debe ser: numero de carne, guion bajo, "TP1". Por ejemplo, si el carne es <i>A12345</i>, el archivo debe llamarse "<i>A12345_TP1</i>".

<h3> Rubrica </h3>

| <div align="center">Rúbrica</div>                          |     |
| :--------------------------------------------------------- | :-: |
| Interaccion de usuario (evaludado de forma general)        | 10% |
| Definicion de clase y metodos estaticos                    | 10% |
| Giro de disco                                              | 15% |
| Manejo de un turno                                         | 20% |
| Logica de repeticion y saldos                              | 20% |
| Validaciones de entradas y manejo de excepciones           | 20% |
| Orden del codigo y uso de buenas practicas de programacion | 5%  |

<h3> Ejemplo de ejecucion </h3>

Los valores en negrita representan entradas de la persona que juega.

<div class="two-columns">
  <div class="column">
    <pre>
Le doy la bienvenida al juego.
Comencemos el juego! Ingrese su monto inicial: <b>5000</b>
Todo listo!
Su saldo actual es de 5000 colones. Ingrese:
1 para Apostar y jugar, 2 para aumentar su saldo, o 3 para tomar su dinero y terminar. <b>1</b>
Ingrese su apuesta: <b>200</b>
Girando los discos...
<<< S : A     P : 6     S : 5 >>>
<<< S : A     P : B     S : C >>>
<<< S : 1     P : B     S : C >>>
<<< S : 2     P : 3     S : 1 >>>
<<< S : 6     P : 5     S : 5 >>>
=== Monto ganado: 240.0 ===
Su saldo actual es de 5040 colones. Ingrese:
1 para Apostar y jugar, 2 para aumentar su saldo, o 3 para tomar su dinero y terminar. <b>1</b>
Ingrese su apuesta: <b>200</b>
Girando los discos...
<<< S : 5     P : 6     S : A >>>
<<< S : 5     P : 7     S : 2 >>>
<<< S : B     P : C     S : 2 >>>
<<< S : B     P : A     S : C >>>
<<< S : 6     P : 6     S : 5 >>>
=== Monto ganado: 240.0 ===
Su saldo actual es de 5080 colones. Ingrese:
1 para Apostar y jugar, 2 para aumentar su saldo, o 3 para tomar su dinero y terminar. <b>1</b>
Ingrese su apuesta: <b>250</b>
Girando los discos...
<<< S : 3     P : 4     S : 5 >>>
<<< S : 7     P : A     S : B >>>
<<< S : B     P : C     S : 2 >>>
<<< S : A     P : 1     S : 2 >>>
<<< S : A     P : B     S : B >>>
=== Monto ganado: 0.0 ===
Su saldo actual es de 4830 colones. Ingrese:
1 para Apostar y jugar, 2 para aumentar su saldo, o 3 para tomar su dinero y terminar. <b>1</b>
Ingrese su apuesta: <b>5000</b>
No tiene suficiente saldo para apostar tanto!
Su saldo actual es de 4830 colones. Ingrese:
1 para Apostar y jugar, 2 para aumentar su saldo, o 3 para tomar su dinero y terminar. <b>1</b>
Ingrese su apuesta: <b>Hola</b>
Entrada invalida, debe ingresar un numero.
Su saldo actual es de 4830 colones. Ingrese:
1 para Apostar y jugar, 2 para aumentar su saldo, o 3 para tomar su dinero y terminar. <b>Jugar</b>
Entrada invalida, por favor ingrese 1, 2 o 3.
    </pre>
  </div>
  <div class="column">
  <pre>
Su saldo actual es de 4830 colones. Ingrese:
1 para Apostar y jugar, 2 para aumentar su saldo, o 3 para tomar su dinero y terminar. <b>1</b>
Ingrese su apuesta: <b>250</b>
Girando los discos...
<<< S : 1     P : 2     S : 3 >>>
<<< S : 1     P : 3     S : 5 >>>
<<< S : B     P : 1     S : 4 >>>
<<< S : A     P : 1     S : 2 >>>
<<< S : 6     P : 6     S : 5 >>>
=== Monto ganado: 300.0 ===
Su saldo actual es de 4880 colones. Ingrese:
1 para Apostar y jugar, 2 para aumentar su saldo, o 3 para tomar su dinero y terminar. <b>1</b>
Ingrese su apuesta: <b>1000</b>
Girando los discos...
<<< S : 5     P : 4     S : 3 >>>
<<< S : 3     P : 5     S : 7 >>>
<<< S : C     P : B     S : 1 >>>
<<< S : 3     P : 4     S : 5 >>>
<<< S : 7     P : 6     S : 6 >>>
=== Monto ganado: 1200.0 ===
Su saldo actual es de 5080 colones. Ingrese: 
1 para Apostar y jugar, 2 para aumentar su saldo, o 3 para tomar su dinero y terminar. <b>2</b> 
Ingrese cuanto desea agregar a su saldo: <b>Mil</b> 
Entrada invalida, debe ingresar un numero. 
Su saldo actual es de 5080 colones. Ingrese: 
1 para Apostar y jugar, 2 para aumentar su saldo, o 3 para tomar su dinero y terminar. <b>2</b>
Ingrese cuanto desea agregar a su saldo: <b>1000</b> 
Su saldo actual es de 6080 colones. Ingrese: 
1 para Apostar y jugar, 2 para aumentar su saldo, o 3 para tomar su dinero y terminar. <b>1</b> 
Ingrese su apuesta: <b>4500</b>
Girando los discos... 
<<< S : 1     P : 2     S: 3 >>> 
<<< S : A     P : B     S: C >>> 
<<< S : 1     P : B     S: C >>> 
<<< S : 2     P : 3     S: 1 >>> 
<<< S : B     P : B     S: C >>> 
==== Monto ganado: 6750.0 ==== 
Su saldo actual es de 8330 colones. Ingrese: 
1 para Apostar y jugar, 2 para aumentar su saldo, o 3 para tomar su dinero y terminar. <b>3</b>
Gracias por jugar! Usted retira su saldo de 8330 colones 
    </pre>
  </div>
</div>

---

### :man_technologist: About Us :

We are Computer Science and Informatics Students <img src="https://media.giphy.com/media/WUlplcMpOCEmTGBtBW/giphy.gif" width="30"> from Universidad de Costa Rica.

- :man_technologist: Students: Mauricio Artavia Monge, C10743 | Kenneth Fabricio Delgado ... | (Nombre Integrante 3) | (Nombre Integrante 4).

- 👨‍🏫 Professor: Jorhan Chaverri Hernandez.

- :mailbox:How to reach us: mauricio.artavia@ucr.ac.cr | (Correo Kenneth) | (Correo Integrante 3) | (Correo Integrante 4)

- :bookmark_tabs: Description: Repository created with the objective of having a backup and workplace for the MA0294 Algebra Lineal Para Computacion course Project.

---

### :hammer_and_wrench: Languages and Tools :

<div>
  <img src="https://github.com/devicons/devicon/blob/master/icons/java/java-original.svg" title="Java" alt="Java" width="40" height="40"/>&nbsp;
</div>

---

<style>
  /* Estilo para la lista con números y guiones */
  .number-dash {
    counter-reset: item;
  }
  .numer-dash > li {
    display: block;
  }
  .number-dash > li : before {
    content: counter(item) "- ";
    counter-increment: item;
  }

  /* Estilo para la lista con letras mayúsculas y puntos */
  .alpha-dot {
    list-style: none;
    counter-reset: list;
  }
  .alpha-dot > li {
    counter-increment: list;
  }
  .alpha-dot > li:before {
    content: counter(list, upper-alpha) ". ";
  }

  /* Estilo para la lista con guiones */
  .hyphens {
    list-style-type: none; /* Elimina los puntos predeterminados */
  }
  .hyphens li {
    position: relative; /* Posiciona el contenido relativo al li */
    padding-left: 1em; /* Agrega espacio a la izquierda */
  }
  
  .hyphens li::before {
    content: "-"; /* Añade un guion antes del contenido del li */
    position: absolute; /* Posiciona el guion de forma absoluta dentro del li */
    left: 0; /* Coloca el guion en la posición izquierda */
  }

  .two-columns {
    display: flex;
  }
  .column {
    flex: 1;
    padding: 10px;
  }
</style>
