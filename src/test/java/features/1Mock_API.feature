#language: en
#Author: Douglas Gelli
#Version: 1.0
#encoding: UTF-8
@MockAPI @regression
Feature: - MOCK API

  @GetMock
  Scenario: Get
    Given que faco uma requisicao GET
    When valido status response 200
    Then retona status e conteudo

  @GetMockFilter
  Scenario: Get com filtro
    Given que faco uma requisicao GET com filtro
    When valido status response 200
    Then retona status e conteudo filtrado

  @PostMock
  Scenario: Post
    Given que faco uma requisicao Post
    When valido status response 201
    Then retona status e conteudo do Post

  @PutMock
  Scenario: Put
    Given que faco uma requisicao Put
    When valido status response 200
    Then retona status e conteudo do Put

  @DeleteMock
  Scenario: Delete
    Given que faco uma requisicao Delete
    When valido status response 200
    Then retona status e conteudo do Delete
