/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Local;

/**
 *
 * @author geovane
 */
public class Fabrica {

    public static void deStringParaLocais(
            ArrayList<String> conteudoDoArquivo, 
            ArrayList<Local> locaisParaOMapa) throws NumberFormatException{
        /*variável responsável por controlar quantas linhas já foram adicionadas
         a lista de Locais*/
        int i = 0;
        /*para cada item da lista executa os comandos que estão entre chaves*/
        for (String a : conteudoDoArquivo) {
            try{
            /*cria um novo Local(em branco) para que nele sejam adicionadas
             as informações necessárias*/
            Local local = new Local();
            /*local.setRotulo(recebe o paramêtro aqui) recebe como parâmetro 
             o título do local que no nosso padrão de arquivo de texto o 
             título é a primeira linha do aquivo. */
            local.setRotulo(conteudoDoArquivo.get(i));
            /*local.setLatitude(paramêtro aqui) recebe como parâmetro a 
             Latitude do local a ser marcado que no nosso caso é a segunda 
             linha do arquivo de texto */
            local.setLatitude(Double.parseDouble(conteudoDoArquivo.get(i + 1)));
            /*local.setLongitude(paramêtro aqui) recebe como parâmetro a 
             Longitude do local a ser marcado que no nosso caso é a terceira */
            local.setLongitude(Double.parseDouble(conteudoDoArquivo.get(i + 2)));
            /*adiciona o novo Local criado à lista*/
            locaisParaOMapa.add(local);
            }catch(IndexOutOfBoundsException erro){
                break;
            }
            /* a cada 4 itens da "listaInfo" percorridos, mais 4 serão 
             percorridos dessa iniciando do quarto item "i = 0 + 4". */
            i = i + 3;
        }
    }

}
