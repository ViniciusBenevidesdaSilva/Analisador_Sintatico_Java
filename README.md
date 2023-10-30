# Analisador Sintatico Java :coffee:

> Trabalho proposto pela disciplina de **Compiladores** realizado no 6° semestre do curso de *Engenharia de Computação*.

## Desafio :mag:
Por meio desse projeto foi desenvolvido um analisador sintático em java capaz de validar palavras de acordo com a seguinte gramática:
![image](https://github.com/ViniciusBenevidesdaSilva/Analisador_Sintatico_Java/assets/105802950/e0ef1277-217b-4060-8486-8ffa6da50f7c)

## Solução :bulb:
Inicialmente, foi realizada a definição dos conjuntos *First* e *Follow* baseando-se nas regras gramaticais estabelecidas:
| **Varivável** | *First*       | *Follow*     |
| ------------- | ------------- | ------------ |
| S             | { da, ca, f } | { $, ca, f } |
| T             | { a, ba, ε }  | { $, ca, f } |
| R             | { ca, ε }     | { f }        |

Com tal informação, foi possível a definição da **Tabela de Análise Sintática**:

|   | a       | ba     | ca     | da      | f        | $     |
| - | ------- | ------ | ------ |-------- | -------- | ----- |
| S | S → daT |	S → Rf |        |         | S → Rf   |       |	
| T |         | T → ε  | T → aS | T → baT | T → ε	   | T → ε |
| R |         | R → ε  |        |         | R → caTR |       |

Assim, possuindo tais ferramentas, foi possível a criação de um algoritmo em java personalizado capaz de receber uma String e validar se ela é ou não aceita por essa gramática.

### Modelo de Classes
![image](https://github.com/ViniciusBenevidesdaSilva/Analisador_Sintatico_Java/assets/105802950/fa8a7bcf-46a0-4422-9c45-4a194fe7f5c7)

## Conclusão :trophy:
Por meio desse projeto, foi possível realizar a implementação em *java* de uma *grámatica* no formato de um **analisador sintático**. Foram ainda incluídos **testes unitários** a fim de validar os métodos desenvolvidos, garantindo que futuras mudanças no código não impactem em sua funcionalidade principal
