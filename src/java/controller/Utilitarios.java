/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ArrayList;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author geovane
 */
public class Utilitarios {

    public static File deAnexoParaArquivo(UploadedFile anexo)
            throws Exception {
        /*cria um arquivo temporário que receberá o conteúdo do anexo 
         enviado pelo usuário. */
        File arquivoTemporario = File.createTempFile(
                anexo.getFileName(), ".txt");

        /*armazena as entradas do arquivo de texto anexado pelo usuário*/
        InputStream entrada = anexo.getInputstream();

        /* transfere as entradas do arquivo anexado para o 
         arquivo temporário criado no servidor*/
        Files.copy(entrada, arquivoTemporario.toPath(), REPLACE_EXISTING);

        return arquivoTemporario;
    }

    public static void deArquivoTxtParaString(
            File arquivoTxt, ArrayList<String> conteudoDoArquivo)
            throws FileNotFoundException, IOException {
        /* recebe o fluxo de caracteres do arquivo txt */
        FileReader fluxoDeCaracteres = new FileReader(
                arquivoTxt.getAbsolutePath());

        /* lê o fluxo de caracteres */
        BufferedReader leitorDeFluxo = new BufferedReader(fluxoDeCaracteres);
        /* a variável "linha" recebe o conteudo da primeira linha do arquivo 
         a linha é lida pelo método "this.carregar.readLine()" */
        String linhaLida = leitorDeFluxo.readLine();

        /* adiciona o conteúdo da linha lida à lista de String que, guarda o 
         conteúdo de todas as linhas do arquivo de texto. */
        conteudoDoArquivo.add(linhaLida);
        /*controla a leitura do arquivo verificando se a linha lida está nula*/
        while (linhaLida != null) {
            //"linha" recebe o conteúdo da linha
            linhaLida = leitorDeFluxo.readLine();

            //se a linha não for nula
            if (linhaLida != null) {
              if(!(linhaLida.trim().equals(""))){
                /*adiciona o conteúdo da linha ao lista de Strings*/
                conteudoDoArquivo.add(linhaLida);
            }
            }

        }

    }

}
