/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.agendatelefonica;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author alex
 */
public class Arquivo {
    public static void salvar( String arquivo, ArrayList<Contatos> lista) throws IOException {
        String conteudo = "";
        for ( int i = 0; i < lista.size(); i++ ){
            conteudo += lista.get(i).nome;
            conteudo += "\n";
            conteudo += lista.get(i).fone;
            conteudo += "\n";            
        }

        FileWriter fw = new FileWriter(arquivo, false);
        fw.write(conteudo);
        fw.close();       
    }
    
    public static ArrayList<Contatos> carregar(String arquivo) throws FileNotFoundException, IOException {
        ArrayList<Contatos> lista = new ArrayList<>();
        
        File arq = new File(arquivo);
        if (arq.exists()) {
            BufferedReader br = new BufferedReader( new FileReader(arquivo));
            String nome;
            String fone;
            while( (nome = br.readLine()) != null ) {
                fone = br.readLine();
                lista.add( new Contatos(nome, fone));
            }
            br.close();            
        }
       
        return lista;
    }
    
}
