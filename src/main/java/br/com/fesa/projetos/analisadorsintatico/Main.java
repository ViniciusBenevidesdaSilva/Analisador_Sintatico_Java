
package br.com.fesa.projetos.analisadorsintatico;


public class Main {
    
    private static Analisador analisadorSintatico;
    
    public static void main(String[] args) {
        analisadorSintatico = new Analisador();
        
        if(analisadorSintatico.realizaAnalise("daba")){
            System.out.println("Válido");
        }
        else{
            System.out.println("Inválido");
        }
    }
}
