# Actividad: gestion y tratamiento de excepciones en Java

Seis ejercicios y reto final de DAM/DAW. Programacion estructurada con metodos static, sin objetos para representar cuentas, alumnos o reservas.

## Archivos

| Archivo en src/ | Contenido |
| --- | --- |
| Ejercicio01Division.java | Division entera y ArithmeticException. |
| Ejercicio02Edad.java | Entrada de edad y InputMismatchException. |
| Ejercicio03Acceso.java | comprobarEdad y lanzamiento manual con throw. |
| Ejercicio04Raiz.java | calcularRaiz, throws y Math.sqrt. |
| Ejercicio05CuentaBancaria.java | Retirada y conservacion del saldo si hay error. |
| SaldoInsuficienteException.java | Excepcion personalizada requerida por el ejercicio 5. |
| Ejercicio06Notas.java | Validacion de notas y repeticion hasta una entrada valida. |
| RetoReservasHotel.java | Entrada, validacion, calculo y presentacion de una reserva. |

## Ejecucion

Requiere un JDK (Java 8 o posterior). Abrir esta carpeta como proyecto independiente en VS Code evita mezclar los ejercicios con otros programas.

Desde esta carpeta, compilar todos los archivos:

```powershell
mkdir bin
javac -encoding UTF-8 -d bin src/*.java
java -cp bin Ejercicio01Division
```

Cambiar el ultimo nombre por el programa que se quiera probar. En VS Code tambien se puede abrir su archivo y pulsar Run Java. SaldoInsuficienteException es una clase auxiliar y no se ejecuta directamente.

Los numeros decimales se introducen con **punto**, por ejemplo `8.5`. Locale.US fija ese formato. Los mensajes usan caracteres sencillos y EUR para evitar problemas de codificacion en la terminal.

## Conceptos para explicar

- `try`: contiene instrucciones que pueden producir una excepcion.
- `catch`: captura un tipo concreto de excepcion y muestra el error sin una terminacion inesperada.
- `throw`: lanza una excepcion en el lugar donde se detecta un dato incorrecto.
- `throws`: declara en la cabecera del metodo una excepcion que puede propagarse al llamador.
- `getMessage()`: obtiene el mensaje guardado en la excepcion.
- Una excepcion **checked**, como SaldoInsuficienteException al heredar de Exception, debe capturarse o declararse.
- ArithmeticException, InputMismatchException e IllegalArgumentException son **unchecked**. Declarar IllegalArgumentException con throws no es obligatorio en Java, pero se hace donde lo exige la actividad.
- `double` representa numeros decimales. Un metodo `static double` devuelve un resultado con `return`, a diferencia de `void`.
- `Double.isNaN` y `Double.isInfinite` rechazan valores especiales que Scanner puede aceptar como decimales. Son comprobaciones adicionales, no mecanismos nuevos de excepciones.
- `nextLine()` dentro del catch de notas descarta la entrada incorrecta para que el bucle no falle una y otra vez sobre el mismo texto.

El enunciado prohibe clases propias adicionales, pero permite expresamente la excepcion del ejercicio 5. Esa clase necesita `extends Exception`, un constructor y `super(mensaje)`. Es la unica excepcion a la restriccion; los demas archivos tienen su clase principal y metodos static.

## Pruebas manuales

| Programa | Entrada | Resultado esperado |
| --- | --- | --- |
| Division | 20 y 4 / 20 y 0 / texto | 5 / error de division / error de entrada. |
| Edad | 20 / hola | Muestra edad / error de entero. |
| Acceso | 18 / 16 | Permitido / error de edad. |
| Raiz | 25 / 0 / -25 | 5.0 / 0.0 / error de numero negativo. |
| Cuenta | 200 / 700 / -10 | Saldo 300 / saldo sigue en 500 / cantidad rechazada. |
| Notas | hola, 15, 8.5 | Dos errores y finalmente nota valida. |
| Hotel | Carlos Garcia, 205, 4, 75 | Total 300.0 EUR. |
| Hotel | Nombre vacio, habitacion 0, noches -2 o precio 0 | Rechaza el primer dato incorrecto con su motivo. |

En el banco, titular y saldo inicial son Juan y 500 EUR, como en el ejemplo. Se usan double porque lo pide la actividad; una aplicacion bancaria real requiere otro tratamiento de importes.

## Entrega en GitHub

Subir el contenido de esta carpeta: README.md, .gitignore y src/. No subir bin/ ni archivos .class. El archivo .gitignore los excluye al usar Git.

Para hacerlo desde la web de GitHub, crear un repositorio y usar Add file > Upload files. Arrastrar README.md y la carpeta src; incluir tambien .gitignore. Enviar al profesor el enlace al repositorio.

Antes de entregar, ejecutar cada programa y repasar por que se captura cada excepcion. El enunciado suma 11 puntos en sus criterios, aunque indica un total de 10; esto no afecta a los requisitos implementados.
