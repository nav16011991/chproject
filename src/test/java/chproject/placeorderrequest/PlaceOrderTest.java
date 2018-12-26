/**
 * 
 */
package chproject.placeorderrequest;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * @author naveenbhardwaj
 *
 */
public class PlaceOrderTest {

	final static String ROOT_URI = "http://localhost:51544";
	
	@Test
	public void testResponseCodeOK() {
		Response response = given().
				contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body("{\"stops\": [{ \"lat\":\"22.344674\", \"lng\": \"114.124651\"}]}")
				.when()
				.post(ROOT_URI + "/v1/orders");
		Assert.assertEquals(201, response.getStatusCode());
		/*System.out.println("POST Response\n" + response.asString());
		response.then().body("id", Matchers.any(Integer.class));*/
		
	}
	
	@Test
	public void testResponseCodeNotFound() {
		Assert.assertEquals(get("http://localhost:51544/v1/orders/100").getStatusCode(), 404);
	}
}
