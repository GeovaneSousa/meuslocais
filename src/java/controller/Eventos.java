package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import model.Local;

import org.primefaces.model.UploadedFile;

@ManagedBean
public class Eventos {
    /*variavel responsável por anexar temporáriamente o 
     arquivo de texto selecionado pelo usuário*/

    private UploadedFile anexo;
    /*File é o arquivo enviado pelo usuário e já salvo no servidor,
     nessa etapa o arquivo de texto está pronto para ser lido.*/
    private File arquivoDeTexto;
    /*conteudo do arquivo de texto no formato String*/
    private static ArrayList<String> conteudoDoArquivo = new ArrayList<String>();
    /*locais a serem marcados no mapa*/
    private static ArrayList<Local> locaisParaOMapa = new ArrayList<Local>();

    public UploadedFile getAnexo() {
        return anexo;
    }

    public void setAnexo(UploadedFile anexo) {
        this.anexo = anexo;
    }

    public File getArquivoDeTexto() {
        return arquivoDeTexto;
    }

    public void setArquivoDeTexto(File arquivoDeTexto) {
        this.arquivoDeTexto = arquivoDeTexto;
    }

    public static ArrayList<String> getConteudoDoArquivo() {
        return conteudoDoArquivo;
    }

    public static void setConteudoDoArquivo(ArrayList<String> conteudoDoArquivo) {
        Eventos.conteudoDoArquivo = conteudoDoArquivo;
    }

    public static ArrayList<Local> getLocaisParaOMapa() {
        return locaisParaOMapa;
    }

    public static void setLocaisParaOMapa(ArrayList<Local> locaisParaOMapa) {
        Eventos.locaisParaOMapa = locaisParaOMapa;
    }

    public String limparSessao() {
        //apaga o conteúdo da lista de locais
        Eventos.conteudoDoArquivo.clear();
        Eventos.locaisParaOMapa.clear();

        //retorna o indice da pagina web de destino
        return "inicial";
    }

    /*método executado quando o botão Enviar Local de Referência
     é pressionado*/
    public String enviarArquivo() throws IOException {
        this.limparSessao();
        /* o "try{" nesse caso específico, verifica se o usuário selecionou 
         algum arquivo, se usuário não tiver selecionado um erro será gerado */
        try {
            this.arquivoDeTexto = Utilitarios.deAnexoParaArquivo(anexo);
            Utilitarios.deArquivoTxtParaString(
                    arquivoDeTexto, conteudoDoArquivo);
            Fabrica.deStringParaLocais(conteudoDoArquivo, locaisParaOMapa);
            //mensagem exibida na página web, confirmando o envio do aquivo.
            FacesMessage message = new FacesMessage("Enviado com sucesso!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            /*retorna o indice da página web que será aberta após a marcação
             dos locais. */
            return "mapa";
        } catch (Exception erro) {
            //mensagem exibida na página web.
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Erro, arquivo nulo ou inválido!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "enviar_locais_adjacentes";
            
        }
        
    }
    
    public String enviarOutroArquivo() throws IOException {
        
        /* o "try{" nesse caso específico, verifica se o usuário selecionou 
         algum arquivo, se usuário não tiver selecionado um erro será gerado */
        try {
            this.arquivoDeTexto = Utilitarios.deAnexoParaArquivo(anexo);
            Utilitarios.deArquivoTxtParaString(
                    arquivoDeTexto, conteudoDoArquivo);
            Fabrica.deStringParaLocais(conteudoDoArquivo, locaisParaOMapa);
            //mensagem exibida na página web, confirmando o envio do aquivo.
            FacesMessage message = new FacesMessage("Enviado com sucesso!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            /*retorna o indice da página web que será aberta após a marcação
             dos locais. */
            return "mapa";
        } catch (Exception erro) {
            //mensagem exibida na página web.
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Erro, arquivo nulo ou inválido!", "");
            FacesContext.getCurrentInstance().addMessage(null, message);
            return "enviar_locais_adjacentes";
        }
    }
}
