package controller;

import java.util.List;
import javax.faces.bean.ManagedBean;
import model.Local;
import org.primefaces.event.map.GeocodeEvent;
import org.primefaces.model.map.GeocodeResult;
import org.primefaces.model.map.LatLng;

@ManagedBean
public class LocalBean extends Local {

    private static Local localDeReferencia;

    public static Local getLocalDeReferencia() {
        return localDeReferencia;
    }

    public static void setLocalDeReferencia(Local localDeReferencia) {
        LocalBean.localDeReferencia = localDeReferencia;
    }

    public String novoLocalDeReferencia() {
        LocalBean.localDeReferencia = new Local();
        LocalBean.localDeReferencia.setRotulo(this.getRotulo());
        LocalBean.localDeReferencia.setLatitude(this.getLatitude());
        LocalBean.localDeReferencia.setLongitude(this.getLongitude());

        return "enviar_locais_adjacentes";
    }

    public String alterarLocalDeReferencia() {
        LocalBean.localDeReferencia = new Local();
        LocalBean.localDeReferencia.setRotulo(this.getRotulo());
        LocalBean.localDeReferencia.setLatitude(this.getLatitude());
        LocalBean.localDeReferencia.setLongitude(this.getLongitude());

        return "mapa";
    }

}
