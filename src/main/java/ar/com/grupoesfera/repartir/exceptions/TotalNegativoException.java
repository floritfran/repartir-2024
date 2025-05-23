package ar.com.grupoesfera.repartir.exceptions;

public class TotalNegativoException extends RuntimeException {
    public TotalNegativoException() {
        super("El gasto total no puede ser negativo");
    }
}
