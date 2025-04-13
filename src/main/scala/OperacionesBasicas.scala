package Examen

import

/** P01 (*) Encuentra el último elemento de una lista.
* Ejemplo: scala> último(Lista(1, 1, 2, 3, 5, 8))
* res0: entero = 8 **/
def ultimo[A](lista: List[A]): A = lista.last

/** P02 (*) Encuentra el penúltimo elemento de una lista.
* Por convención, el primer elemento de la lista es el elemento 0.
* Ejemplo:* scala> penultima(List(1, 1, 2, 3, 5, 8))
* res0: entero = 5 */
 def penultimo[A](lista: List[A]): A =  ultimo(-1) // ??

/** P04 (*) Encuentra el número de elementos de una lista.
 * Ejemplo: scala> longitud(Lista(1, 1, 2, 3, 5, 8))
 ** res0: entero = 6 */
 def longitud[A]( ls: List[A]): A = ls.length : Int

/** P05 (*) Invertir una lista. *
 * Ejemplo: * scala> invertir(Lista(1, 1, 2, 3, 5, 8))
 * res0: Lista[Int] = Lista(8, 5, 3, 2, 1, 1) */
def invertir[A](Lista: List[A]): A = Lista.reverse

/** P06 (*) Averiguar si una lista es un palíndromo. *
 * Ejemplo: scala> esPalíndromo(Lista(1, 2, 3, 2, 1))
 * res0: Booleano = verdadero */
def isPalindrome[A](ls: List[A]): Boolean = ls == ls.reverse


val set = Set(1,2,3,1)
val aumentar = set + 3
val concatenar = set ++ Set(4,5,6)
val eliminacion = set - 3
val diferencia = set -- Set(1,3)
val union = set union Set(4,5,6)
val diferencia2 = set diff Set(1,3)
val interseccion = set & Set(3)



