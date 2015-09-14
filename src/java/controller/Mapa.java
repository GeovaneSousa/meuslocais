package controller;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Local;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@ViewScoped
public class Mapa implements Serializable {

    //modelo do mapa usado, mapa avançado.  
    private MapModel mapaAvancado;
    //cada ponto a ser marcado no mapa
    private Marker marcadorDoMapa;
    //local de referencia
    private Local localDeReferencia = LocalBean.getLocalDeReferencia();
    //lista contendo os locais a serem marcados
    private ArrayList<Local> locaisParaOMapa = Eventos.getLocaisParaOMapa();
    /*latitude e longitude usadas para centralizar o mapa após o upload*/
    private String centroDoMapa;

    @PostConstruct
    public void init() {
        //instancia um novo modelo de mapa
        this.mapaAvancado = new DefaultMapModel();

        /*armazena a latitude e longitude do local de referência, esses
         valores serão usado para centralizar o mapa no local correto*/
        this.centroDoMapa = localDeReferencia.getLatitude() + ", " 
                + localDeReferencia.getLongitude();
        /*marca o ponto de referencia no mapa*/
        LatLng coord = new LatLng(localDeReferencia.getLatitude(), 
                localDeReferencia.getLongitude());
        mapaAvancado.addOverlay(new Marker(coord, localDeReferencia.getRotulo(), null,
                "http://maps.google.com/mapfiles/ms/micons/blue-dot.png"));

     
    }

/*exibe o título do marcador quando o mesmo é pressionado*/
public void onMarkerSelect(OverlaySelectEvent event) {
        marcadorDoMapa = (Marker) event.getOverlay();
    }

    public MapModel getMapaAvancado() {
        return mapaAvancado;
    }

    public Marker getMarcadorDoMapa() {
        return marcadorDoMapa;
    }

    public String getCentroDoMapa() {
        return centroDoMapa;
    }

    public void setCentroDoMapa(String centroDoMapa) {
        this.centroDoMapa = centroDoMapa;
    }

}
