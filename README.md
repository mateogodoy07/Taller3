# 🧙 Proyecto de Gestión de Magos y Hechizos
## 🧾 Descripción del Proyecto
El proyecto consiste en un sistema de gestión de **magos** y **hechizos**, donde cada mago puede poseer una lista de hechizos de distintos tipos: Fuego, Tierra, Planta y Agua.  
Toda la información es almacenada y leída desde archivos `.txt`, permitiendo que los datos persistan entre ejecuciones.  
El sistema cuenta con dos roles: **Administrador**, que puede agregar, modificar y eliminar magos y hechizos, y **Analista**, que puede consultar rankings y puntuaciones.

---

## 👥 Integrantes
**Nombre:** Mateo Godoy Carrasco  
**Usuario GitHub:** mateogodoy07

---

## 🏗️ Estructura del Proyecto

El proyecto utiliza **herencia entre clases** y una **interfaz** para organizar la lógica del sistema.

### 📁 Clases principales

| Clase | Descripción |
|---|---|
| `Hechizos` | Clase padre con atributos comunes: nombre, tipo y daño |
| `Fuego` | Hereda de `Hechizos`, agrega `duracionQuemadura` |
| `Roca` | Hereda de `Hechizos`, agrega `mejoraDefensa` |
| `Planta` | Hereda de `Hechizos`, agrega `duracionStun` y `cantPlantas` |
| `Agua` | Hereda de `Hechizos`, agrega `cantidadHeal` y `presionDelAgua` |
| `Mago` | Contiene nombre y una lista de hechizos |
| `Interface` | Define los métodos que debe implementar el sistema |
| `Implementacion_Interface` | Implementa todos los métodos de la interfaz |
| `Taller3` | Clase principal con el `main`, carga los archivos y gestiona los menús |

### 📦 Paquetes utilizados

```java
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
```

Estos paquetes permiten:
- Leer y escribir archivos `.txt`
- Manejar errores de entrada/salida
- Recibir datos desde el teclado
- Trabajar con listas dinámicas

---

## 📂 Archivos de Datos

El programa requiere dos archivos `.txt` en la raíz del proyecto:

### `Hechizos.txt`
Cada línea representa un hechizo con el siguiente formato:

```
NombreHechizo;Tipo;Daño;AtributoEspecial
```

- **Fuego y Tierra:** el atributo especial es un solo número entero.
- **Planta y Agua:** el atributo especial son dos números separados por coma.

Ejemplo:
```
Sofoco;Fuego;36;4
Tumba Rocas;Tierra;18;40
Polen Somnífero;Planta;81;3,10
Escaldar;Agua;110;45,360
```

### `Magos.txt`
Cada línea representa un mago con el siguiente formato:

```
NombreMago;Hechizo1|Hechizo2|Hechizo3
```

Si el mago aún no tiene hechizos asignados, se usa `vacio`:

```
Alvaro;vacio|vacio|vacio
```

---

## ⚙️ Instrucciones de Uso

⚠️ **ATENCIÓN:** Seguir las instrucciones del programa al pie de la letra. Ingresar datos incorrectos puede causar fallos en la ejecución.

Al iniciar el programa aparecerán **3 opciones principales**:

```
1) Menú Administrador
2) Menú Analista
3) Salir
```

### 🛠️ Menú Administrador
| Opción | Descripción |
|---|---|
| 1 | Agregar un nuevo mago |
| 2 | Modificar un mago existente |
| 3 | Eliminar un mago |
| 4 | Agregar un nuevo hechizo |
| 5 | Modificar un hechizo existente |
| 6 | Eliminar un hechizo |
| 7 | Salir del menú |

### 📊 Menú Analista
| Opción | Descripción |
|---|---|
| 1 | Top 10 mejores hechizos por puntuación |
| 2 | Top 3 magos con mayor puntuación |
| 3 | Mostrar todos los hechizos |
| 4 | Mostrar todos los magos |
| 5 | Mostrar hechizos con su puntuación |
| 6 | Mostrar magos con su puntuación total |
| 7 | Salir del menú |

---

## 🧮 Fórmulas de Puntuación

Cada tipo de hechizo tiene su propia fórmula:

| Tipo | Fórmula |
|---|---|
| Fuego | `daño × duracionQuemadura` |
| Tierra | `(daño × mejoraDefensa) / 2` |
| Planta | `daño + (duracionStun × cantPlantas)` |
| Agua | `(daño + cantidadHeal + presionAgua) / 2` |

La puntuación total de un mago es la **suma de las puntuaciones de todos sus hechizos**.

---

## ❗ Importante

- Todas las opciones de menú funcionan con **números enteros**.
- Los atributos numéricos de los hechizos también deben ser **números enteros**.
- Si se ingresa un dato de tipo incorrecto, el programa lanzará una excepción y se cerrará.
- Los archivos `Magos.txt` y `Hechizos.txt` deben existir antes de ejecutar el programa.
- Los hechizos deben cargarse **antes** que los magos al iniciar el programa.

---

## ⚠️ Advertencias

- No ingresar el nombre de un mago o hechizo que no exista, ya que el programa no lo encontrará y no realizará ninguna acción.
- Al modificar o eliminar, el archivo completo es **reescrito**, por lo que cualquier error en los datos en memoria se verá reflejado en el archivo.
- Si el programa se cierra inesperadamente durante una escritura, el archivo podría quedar incompleto.

---

## 💬 Nota Final

Sin nada más que agregar, me despido.  
En caso de no sobrevivir a este taller, les deseo un bonito día, tarde o noche.

**P.D.: No me rajen 🙁**
