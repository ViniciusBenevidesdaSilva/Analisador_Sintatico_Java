
package br.com.fesa.projetos.analisadorsintatico;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class Analisador {
    
    private String input;
    private int indiceAtual;
    
    private final Stack<Character> pilha = new Stack();
    private final List<Character> terminais = new ArrayList<>();
    private final List<Character> variaveis = new ArrayList<>();

    private final String[][] tabelaTransicoes = {
        { "-",  "-",   "Rf",   "daT", "Rf", "-" },
        { "aS", "baT", "",     "-",   "",   ""  },
        { "-",  "-",   "caTR", "-",   "",   "-" }
    };
    
    public Analisador(){
        iniciaGramatica();
    }
    
    private void iniciaGramatica(){
        
        terminais.clear();
        terminais.add('a');
        terminais.add('b');
        terminais.add('c');
        terminais.add('d');
        terminais.add('f');
        
        variaveis.clear();
        variaveis.add('S');
        variaveis.add('T');
        variaveis.add('R');
    }
    
    public boolean realizaAnalise(String input){
        iniciaNovaAnalise(input);
        return validaInput();
    }
    
    private void iniciaNovaAnalise(String input) {
        pilha.clear();
        pilha.push('S');

        indiceAtual = 0;
        this.input = input.toLowerCase();
    }
    
     private boolean validaInput() {

        char simboloAtual;
        
        while (!pilha.isEmpty()) {
            simboloAtual = pilha.pop();
            
            if(validaTerminal(simboloAtual)){
                continue;
            }
            
            if(validaVariavel(simboloAtual)){
                continue;
            }
            
            return false;
        }
        
        return indiceAtual == input.length();
    }
     
    private boolean validaTerminal(char simboloAtual){
       
        if(!validaSeContem(simboloAtual, terminais)){
            return false;   
        }
        
        if(indiceAtual >= input.length() || input.charAt(indiceAtual) != simboloAtual){
            return false;
        }       
        
        indiceAtual++;
        return true;
    }
    
    private boolean validaVariavel(char simboloAtual){
        
        if(!validaSeContem(simboloAtual, variaveis)){
            return false;
        }
        
        int posVariavel = variaveis.indexOf(simboloAtual);
        
        // Se eu já tiver terminado meu input, pego a posição do fim da pilha ($)
        int posTerminal = (indiceAtual >= input.length()) ? tabelaTransicoes[0].length - 1
                                                             : terminais.indexOf(input.charAt(indiceAtual));
        
        return empilhaTransicao(posVariavel, posTerminal);
    }
    
    private boolean empilhaTransicao(int posVariavel, int posTerminal){
        
        if(posTerminal == -1){
            return false;
        }
        
        String valorEmpilhar = tabelaTransicoes[posVariavel][posTerminal];
        if (valorEmpilhar.equals("-")) {
                return false;
        }
        
        for (int i = valorEmpilhar.length() - 1; i >= 0; i--) {
            pilha.push(valorEmpilhar.charAt(i));
        }
        
        return true;
    }
    
    private boolean validaSeContem(char simbolo, List<Character> lista) {
        return lista.contains(simbolo);
    }
}
