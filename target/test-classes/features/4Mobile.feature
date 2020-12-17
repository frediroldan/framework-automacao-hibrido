#language: pt
#author: Douglas
#encoding: UTF-8
@mobile @regression 
Funcionalidade: Testar Mobile

  Contexto: Evidenciar Teste;
    Dado que utilizo o word para evidencias com as informacoes de execucao
      #| Objetivo                 | Resultado esperado            |
      | Teste de funcionalidades | todas as funções com sucessoo |

  @MobileCt1 @mobile @resetMobileApp
  Cenario: Algumas funcoes para mobile
    Dado que realizo algumas funcoes

  @MobileCt2 @mobile @closeMobile
  Cenario: Diversas funcoes para mobile
    Dado que abro o app e ja faz tudo
