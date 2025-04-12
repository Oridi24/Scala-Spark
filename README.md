# *Procesamiento de Big Data con Scala y Apache Spark*

## *Descripción*

Este proyecto forma parte del módulo de *Procesamiento de Big Data* del bootcamp de **Big Data, Inteligencia Artificial y Machine Learning**, y tiene como objetivo poner en práctica los conceptos clave en el tratamiento de datos masivos utilizando **Apache Spark** junto con el lenguaje de programación **Scala**.

Se trabaja sobre una estructura sólida de desarrollo basada en buenas prácticas profesionales, incluyendo la aplicación de **TDD (Test-Driven Development)** para garantizar la calidad y el funcionamiento del código.

---

## *Tecnologías Utilizadas*

- **Scala** : Lenguaje funcional y orientado a objetos, ideal para aplicaciones distribuidas y procesamiento de datos.
- **Apache Spark** : Framework de procesamiento distribuido en clústeres, orientado al análisis de grandes volúmenes de datos.
- **SBT** : Herramienta de construcción para proyectos Scala.
- **ScalaTest** : Librería de pruebas para Scala, usada para implementar TDD.

---

## *Contenidos y Aprendizajes Aplicados*

### *Fundamentos de Scala*

- Tipos de datos y estructuras de control, `case class`, `trait`, objetos `singleton` y `companion objects`:Uso de colecciones y funciones de orden superior (`map`, `reduce`, `filter`)
- Programación funcional vs. orientada a objetos
- Pattern matching, interpolación de strings y expresiones regulares; Conceptos de herencia y reutilización de código

### *Apache Spark*

- Creación de **DataFrames** y **RDDs**
- Operaciones básicas: filtrado, selección, ordenamiento, configuración de SparkSession
- Uso de funciones definidas por el usuario (**UDFs**)
- Joins y agregaciones entre múltiples datasets,procesamiento de archivos CSV, particionamiento de datos

### *TDD (Test-Driven Development)*

- Implementación de pruebas automáticas con `ScalaTest`, Validación del comportamiento esperado para cada función, Estructura de pruebas con `FunSuite` o `AnyFlatSpec` + `should` matcher
- Separación de responsabilidades: lógica de negocio, punto de entrada (`Main`) y pruebas (`Test`)

---

## 📂 *Estructura del Proyecto*

```bash
.
├── src
│   ├── main
│   │   └── scala
│   │       └── PracticaKC-Examen
│   │           ├── Main.scala           # Punto de entrada de la aplicación
│   │           └── Preguntas.scala      # Implementación de lógica
│   └── test
│       └── scala
│           └── PracticaKC-Examen
│               └── PreguntasTest.scala      # Pruebas unitarias (TDD)
├── project
│   └── build.properties
├── build.sbt                            # Configuración de dependencias
└── README.md                            
