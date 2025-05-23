# language: es

Característica: Agregar gastos a los Grupos para llevar el total gastado

  Regla: El total del gasto del grupo debe ser positivo

    Escenario: Puedo agregar un gasto negativo a un grupo si resulta un saldo positivo
      Dado un grupo con saldo 2000
      Cuando el usuario intenta agregar un gasto de -1000
      Entonces el gasto total será 1000

    Escenario: Puedo agregar un gasto negativo a un grupo si resulta un saldo cero
      Dado un grupo con saldo 2000
      Cuando el usuario intenta agregar un gasto de -2000
      Entonces el gasto total será 0

    Escenario: Agregar un gasto negativo a un grupo si resulta negativo muestra un error
      Dado un grupo con saldo 1000
      Cuando el usuario intenta agregar un gasto de -2000
      Entonces se obtendra el error "El gasto total no puede ser negativo"
