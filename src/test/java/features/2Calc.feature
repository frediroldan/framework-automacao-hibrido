#language: pt
#author: Douglas
#encoding: UTF-8
@DesckTop @regression @winium @closeProcess
Funcionalidade: Testar Calc com o Winium

  Contexto: Evidenciar Teste;
    Dado que utilizo o word para evidencias com as informacoes de execucao
      #| Objetivo                        | Resultado esperado        |
      | Testar a calculadora com Winuim | Executar uma soma simples |

  @CT002
  Esquema do Cenario: CT-Calc - Testar calc
    Dado que abro o programa "<Process>"
    Quando passo os valores
    Entao resultado

    Exemplos: 
      | Process        |
      | Calculator.exe |
