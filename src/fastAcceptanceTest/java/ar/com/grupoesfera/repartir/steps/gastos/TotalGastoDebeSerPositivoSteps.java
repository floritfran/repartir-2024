package ar.com.grupoesfera.repartir.steps.gastos;

import ar.com.grupoesfera.repartir.exceptions.TotalNegativoException;
import ar.com.grupoesfera.repartir.model.Grupo;
import ar.com.grupoesfera.repartir.steps.FastCucumberSteps;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TotalGastoDebeSerPositivoSteps extends FastCucumberSteps {
    private Grupo grupo;
    private String mensajeError;

    @Dado("un grupo con saldo {int}")
    public void unGrupoConSaldo(int saldo) {
        List<String> miembros = new LinkedList<String>();
        miembros.add( "Oscar" );

        grupo = new Grupo();
        grupo.setMiembros( miembros );
        grupo.setTotal(BigDecimal.valueOf(saldo));
    }

    @Cuando("el usuario intenta agregar un gasto de {int}")
    public void elUsuarioIntentaAgregarUnGastoDe(int gasto) {
        BigDecimal total = grupo.getTotal();
        try {
            grupo.setTotal(total.add(BigDecimal.valueOf(gasto)));
        } catch (TotalNegativoException e) {
            mensajeError = e.getMessage();
        }
    }

    @Entonces("el gasto total será {int}")
    public void elGastoTotalSera(int total) {
        assertThat(grupo.getTotal()).isEqualTo(BigDecimal.valueOf(total));
    }

    @Entonces("se obtendra el error {string}")
    public void seObtendraElError(String string) {
        assertThat(mensajeError).isEqualTo(string);
    }
}
