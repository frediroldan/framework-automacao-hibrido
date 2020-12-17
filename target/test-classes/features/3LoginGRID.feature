#language: en
#author: Douglas
#version: 1.1
#encoding: UTF-8
@loginGrid
Feature: Logar na aplicacao de cadastro de clientes da Conductor em Grid

  Background: Evidenciar Teste;
    Given que utilizo o word para evidencias com as informacoes de execucao
      #| Objetivo                        | Resultado esperado                          |
      | Logar na Aplicacao da Conductor | Logar na Aplicacao da Conductor com sucesso |

  @CT001 @gridchrome
  Scenario Outline: Logar na Aplicacao da Conductor com sucesso Grid com Chrome.
    Given que estou na pagina de login atraves da url em Grid
    When preencho o campo login "<LOGIN>" em Grid
    And preencho o campo password "<PASSWORD>" em Grid
    And clico no botao Signin em Grid
    Then a aplicacao exibe a mensagem "<MENSAGEM>" de bem vindo em Grid
    And clico no botao Sair em Grid

    Examples: 
      | LOGIN                  | PASSWORD | MENSAGEM                  |
      | douglasgelli@gmail.com | 12345678 | Bem vindo, Douglas Gelli! |
      | douglasgelli@gmail.com | 12345678 | Bem vindo Douglas Gelli!  |

  @CT002 @gridfirefox
  Scenario Outline: Logar na Aplicacao da Conductor com sucesso Grid com FireFox.
    Given que estou na pagina de login atraves da url em Grid
    When preencho o campo login "<LOGIN>" em Grid
    And preencho o campo password "<PASSWORD>" em Grid
    And clico no botao Signin em Grid
    Then a aplicacao exibe a mensagem "<MENSAGEM>" de bem vindo em Grid
    And clico no botao Sair em Grid

    Examples: 
      | LOGIN                  | PASSWORD | MENSAGEM                  |
      | douglasgelli@gmail.com | 12345678 | Bem vindo, Douglas Gelli! |
      | douglasgelli@gmail.com | 12345678 | Bem vindo Douglas Gelli!  |

  @CT003 @gridedge
  Scenario Outline: Logar na Aplicacao da Conductor com sucesso Grid com Edge.
    Given que estou na pagina de login atraves da url em Grid
    When preencho o campo login "<LOGIN>" em Grid
    And preencho o campo password "<PASSWORD>" em Grid
    And clico no botao Signin em Grid
    Then a aplicacao exibe a mensagem "<MENSAGEM>" de bem vindo em Grid
    And clico no botao Sair em Grid

    Examples: 
      | LOGIN                  | PASSWORD | MENSAGEM                  |
      | douglasgelli@gmail.com | 12345678 | Bem vindo, Douglas Gelli! |
      | douglasgelli@gmail.com | 12345678 | Bem vindo Douglas Gelli!  |
