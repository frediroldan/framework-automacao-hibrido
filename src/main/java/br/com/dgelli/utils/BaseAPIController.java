package br.com.dgelli.utils;

import io.restassured.RestAssured;

/**
 * 
 * @author Douglas Gelli
 *
 */
public class BaseAPIController {

	public static final String DEMO_MOCK_API = "http://5df531907305820014bcc7a7.mockapi.io/BackEnd/Teste";
	public static final String GENERATE_PDA_TOKEN_ENDPOINT = "https://pcuvk9sdrj.execute-api.us-east-1.amazonaws.com/testing/generate-token/";
	public static final String GENERATE_AVA_TOKEN_ENDPOINT = "http://a476cad4b4e6c11eaab7602e38978fa9-814168582.us-east-1.elb.amazonaws.com/usuario/login/v1/token/";

	public String autenticacaoMockAPI() {
		String token = "QualquerValidacaoDeToken";
		return token;
	}

	public String autenticacao(String username, String shortname) {

		// Get token PDA
		String pdaToken = RestAssured.given().get(GENERATE_PDA_TOKEN_ENDPOINT + username).then().statusCode(200)
				.extract().jsonPath().getString("pdaToken");

		// Get token Ava
		String avaToken = RestAssured.given().when().queryParam("shortname", shortname)
				.get(GENERATE_AVA_TOKEN_ENDPOINT + pdaToken).then().statusCode(200).extract().jsonPath()
				.getString("token");

		return avaToken;
	}

}
