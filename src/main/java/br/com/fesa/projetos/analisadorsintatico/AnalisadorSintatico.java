
package br.com.fesa.projetos.analisadorsintatico;

public class AnalisadorSintatico {

    public static void main(String[] args) {
        Analisador analisadorSintatico = new Analisador();
        
        if(analisadorSintatico.realizaAnalise("f")){
            System.out.println("Válido");
        }
        else{
            System.out.println("Inválido");
        }
    }
}
