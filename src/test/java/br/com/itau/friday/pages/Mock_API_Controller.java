package br.com.itau.friday.pages;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.itau.friday.framework.Hooks;
import br.com.itau.friday.utils.BaseAPIController;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Mock_API_Controller extends BaseAPIController {

	private String responseGet;
	@SuppressWarnings("deprecation")
	JsonParser parser = new JsonParser();
	ObjectMapper mapper = new ObjectMapper();
	Response response;
	Hooks hooks = new Hooks();

	// CT01
	public void getfirst() {
		//responseGetFirst = RestAssured.given().when().get(DEMO_MOCK_API).then().statusCode(200).extract().asString();
		response = RestAssured.given().when().get(DEMO_MOCK_API);
	}
	
	// All Steps
	public void checkStatus(int Status) {
		hooks.node(response);
		response.then().statusCode(Status);
	}

	// CT01
	public void validagetfirst() {
		System.out.println("CT01 Get first : " + response.body().asString());
	}

	// CT03, 04 e 05
	public void get() {
		responseGet = RestAssured.given().when().get(DEMO_MOCK_API).then().statusCode(200).extract().asString();
	}

	// CT03, 04 e 05
	// usando ForEach
	@SuppressWarnings("deprecation")
	public void validaget() {
		System.out.println("Get: " + responseGet);

		JsonElement response_json = new JsonParser().parse(responseGet);
		JsonArray jsonArray = new JsonArray();
		jsonArray = response_json.getAsJsonArray();
		JsonObject body;
		for (JsonElement i : jsonArray) {
			body = i.getAsJsonObject();

			if (body.get("id").getAsString().contentEquals("1")) {
				break;
			}
		}

		JsonElement jsonElements = new JsonParser().parse(responseGet);
		JsonArray response_json_array = jsonElements.getAsJsonArray();
		List<String> to = new ArrayList<>();
		response_json_array.forEach(f -> to.add(f.getAsJsonObject().get("id").getAsString()));
		System.out.println(to.contains("1"));
	}

	// CT02
	public void getfilter() {
		response = RestAssured.given().when().get(DEMO_MOCK_API + "/2");
	}

	// CT02
	// Uso do Mapper
	public void validagetfilter() throws IOException {
		System.out.println("CT02 Get Filtro: " + response.body().asString());

		System.out.println(mapper.readTree(response.body().asString()).get("id").asText());
		assertEquals("id", "2", mapper.readTree(response.body().asString()).get("id").asText());
		System.out.println(mapper.readTree(response.body().asString()).get("name"));

		JsonNode JsResponse = mapper.readTree(response.body().asString()).get("Contato");
		for (JsonNode array : JsResponse) {
			System.out.println(array.get("id").asText());
			System.out.println(array.get("TesteId").asText());
			System.out.println(array.get("fone").asText());
			System.out.println(array.get("fone2").asText());
		}
	}

	// CT03
	public void post() {
		String myJson = "{\r\n" + "    \"fone\": \"55 11 99999-4444\",\r\n" + "    \"fone2\": \"55 11 99999-5555\"\r\n"
				+ "}";
		response = RestAssured.given().when()
				// .auth()
				// .oauth2(token)
				.contentType("application/json").body(myJson).when().post(DEMO_MOCK_API + "/1/contatos");
				//.then().statusCode(201).extract().asString();
	}

	// CT03
	public void validaPost() {
		System.out.println("CT03 Post: " + response.body().asString());

	}

	// CT04
	public void put() {
		String myJson = "{\r\n" + "    \"fone\": \"(11) 99999-9999)\",\r\n" + "    \"fone2\": \"(11) 8888-8888)\"\r\n"
				+ "}";
		response = RestAssured.given().when()
				// .auth()
				// .oauth2(token)
				.contentType("application/json").body(myJson).when().put(DEMO_MOCK_API + "/1/contatos/6");
				//.then().statusCode(200).extract().asString();
	}

	// CT04
	public void validaPut() {
		System.out.println("Put: " + response.then().toString());
	}

	// CT05
	public void delete() {
		response = RestAssured.given().when()
				// .auth()
				// .oauth2(token)
				.contentType("application/json").when().delete(DEMO_MOCK_API + "/1/contatos/6");
				//.then().statusCode(200).extract().asString();
	}

	// CT05
	public void validaDelete() {
		System.out.println("Delete: " + response.body().asString());
	}

	// outros exemplos

	private static final String POSITIONS_ENDPOINT = "https://api.kenoby.com/positions/";
	private static final String APPLICANTS_ENDPOINT = "https://api.kenoby.com/applicants/{_id}";

	String Authorization = "Basic bm9yZXBseS1ybS1ob21vbG9nQGtyb3Rvbi5jb20uYnI6MTIzNA";
	String xtenant = "5ab010cd1bf9bc31b19ab1d8";
	String id = "5e1dec846c1e8b4e9d6255f1";

	// GET
	public void exemplos() {
		Response response;
		response = RestAssured.given().header("Authorization", Authorization).header("x-tenant", xtenant).when()
				.get(POSITIONS_ENDPOINT);

		System.out.println(response.getStatusCode());
		response.then().statusCode(200);

		// GET2
		response = RestAssured.given().header("Authorization", Authorization).header("x-tenant", xtenant)
				.pathParam("_id", id).when().get(APPLICANTS_ENDPOINT);

		System.out.println(response.getStatusCode());
		response.then().statusCode(200);

		// POST
		String body = "{\"positionTemplate\":{\"name\":\"nome do cargo\",\"_id\":\"5df27551cc5cc119941468ea\"},\"company\":{\"_id\":\"5df37eed758c607db9ff4522\",\"name\":\"Filial\"},\"currentStage\":null,\"stageCount\":[],\"sourceCount\":[],\"stageSourceCount\":[],\"pastStageSourceCount\":[],\"code\":\"QC.01\",\"internal\":false,\"name\":\"vaga teste\",\"description\":null,\"quantity\":1,\"manager\":\"5d41984fd566136fcc8a45e8\",\"recruiters\":[\"5d5e9ce20f8cfe58ebe06032\"],\"owners\":[],\"deleted\":false,\"customFields\":[{\"code\":\"state\",\"field\":\"5ab010cf1bf9bc31b19ab213\",\"value\":\"SP\"},{\"code\":\"zipCode\",\"field\":\"5ab010cf1bf9bc31b19ab215\",\"value\":\"30550320\"},{\"code\":\"city\",\"field\":\"5ab010cf1bf9bc31b19ab214\",\"value\":\"Valinhos\"},{\"code\":null,\"field\":\"5d308788510b92239ec9636a\",\"value\":\"AD.0017\"},{\"code\":null,\"field\":\"5d308814603adf07e9ecfc01\",\"value\":null},{\"code\":null,\"field\":\"5d3087887269a010778614ff\",\"value\":\"cod cargo\"},{\"code\":null,\"field\":\"5d3088145c6acf351c1edf14\",\"value\":null},{\"code\":null,\"field\":\"5d308788bb65833b7b970d57\",\"value\":null},{\"code\":null,\"field\":\"5d308814633fe1106e106493\",\"value\":\"Sim\"},{\"code\":null,\"field\":\"5d308814633fe1106e106494\",\"value\":null},{\"code\":null,\"field\":\"5d308788b5ff5707e399eb1a\",\"value\":null},{\"code\":null,\"field\":\"5d308814b5ff5707e399f1d4\",\"value\":null},{\"code\":null,\"field\":\"5d308788bb65833b7b970d58\",\"value\":\"VP ACAD\u00caMICA DIRETORIA DE OPERA\u00c7\u00d5ES ACAD\u00caMICAS\"},{\"code\":null,\"field\":\"5d30881414414d3b7590984d\",\"value\":null},{\"code\":null,\"field\":\"5d308788603adf07e9ecf619\",\"value\":\"CC\"},{\"code\":null,\"field\":\"5d308814603adf07e9ecfc00\",\"value\":null},{\"code\":\"maximumSalary\",\"field\":\"5ab010cf1bf9bc31b19ab20e\",\"value\":3000.96},{\"code\":null,\"field\":\"5d308814bbcba83522d3a147\",\"value\":null}]}";
		response = RestAssured.given().header("Authorization", Authorization).header("x-tenant", xtenant)
				.contentType("application/json").body(body).when().post(POSITIONS_ENDPOINT);

		System.out.println(response.getStatusCode());
		response.then().statusCode(201);
	}
	
	
	public String creatingJsonString() {
		  JSONArray pets = new JSONArray();
		  pets.put("cat");
		  pets.put("dog");
		  JSONObject person = new JSONObject();
		  person.put("name", "John Brown");
		  person.put("age", 35);
		  person.put("pets", pets);
		  return person.toString(2);
		}
}
