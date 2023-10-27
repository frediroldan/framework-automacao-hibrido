#language: en
#author: Douglas
#version: 1.1
#encoding: UTF-8
@login @regression
Feature: Logar na aplicacao de cadastro de clientes da Conductor

  Background: Evidenciar Teste;
    Given que utilizo o word para evidencias com as informacoes de execucao
      #| Objetivo                        | Resultado esperado                          |
      | Logar na Aplicacao da Conductor | Logar na Aplicacao da Conductor com sucesso |

  @CT001 @web @closeBrowser
  Scenario Outline: Logar na Aplicacao da Conductor com sucesso.
    Given que estou na pagina de login atraves da url
    When preencho o campo login "<LOGIN>"
    And preencho o campo password "<PASSWORD>"
    And clico no botao Signin
    Then a aplicacao exibe a mensagem "<MENSAGEM>" de bem vindo
    And clico no botao Sair

    Examples:
      | LOGIN                 | PASSWORD | MENSAGEM          |
      | frediroldan@gmail.com | 12345    | Bem vindo, Fredi! |
      | frediroldan@gmail.com | 12345    | Bem vindo, Fredi! |

