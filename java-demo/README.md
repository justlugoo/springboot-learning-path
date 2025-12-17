# Java Demo Project

Este proyecto es una demostración práctica de los fundamentos de la Programación Orientada a Objetos (POO) utilizando las últimas características de Java 25. Simula un sistema bancario interactivo para ilustrar cómo interactúan diferentes componentes de software mediante contratos, jerarquías y separación de responsabilidades.

## Estructura del Proyecto

El código está organizado en seis partes principales dentro de `src/main/java/com/banco`:

### 1. `/interfaces` (El Contrato)
*   `iOperacionesCuenta.java`: Define las reglas obligatorias. Cualquier cuenta bancaria debe saber depositar, retirar y mostrar su información.

### 2. `/models` (Los Datos)
*   `Cuenta.java`: Clase abstracta base. Contiene lo que todas las cuentas comparten (titular, saldo, número).
*   `CuentaAhorros.java`: Implementación concreta que hereda de `Cuenta` y añade tasa de interés.

### 3. `/exceptions` (Manejo de Errores)
*   `MontoInvalidoException.java`: Se lanza cuando el monto a depositar/retirar es inválido.
*   `SaldoInsuficienteException.java`: Se lanza cuando no hay fondos suficientes para retirar.

### 4. `/services` (Lógica de Negocio)
*   `BancoService.java`: Encapsula las operaciones bancarias, separando la lógica de la presentación.

### 5. `/ui` (Interfaz de Usuario)
*   `MenuBanco.java`: Maneja toda la interacción con el usuario (inputs, menús).

### 6. `/app` (La Ejecución)
*   `BancoApp.java`: Punto de entrada. Orquesta la interacción entre UI y Services.

## Conceptos Clave Implementados

| Concepto | Descripción |
|----------|-------------|
| **Interface** | Contrato que define qué operaciones debe implementar una cuenta |
| **Clase Abstracta** | Base común que no puede instanciarse directamente |
| **Herencia** | `CuentaAhorros` obtiene automáticamente las características de `Cuenta` |
| **Polimorfismo** | Métodos sobrescritos con comportamiento específico |
| **Encapsulamiento** | Datos protegidos, acceso controlado mediante getters |
| **Excepciones Custom** | Errores tipados para el dominio bancario |
| **Separación de Capas** | UI, Services y Models desacoplados |

## Cómo Ejecutar

```bash
java --enable-preview src/main/java/com/banco/app/BancoApp.java
```

## Requisitos
*   Java 25 (Preview Features habilitadas)
