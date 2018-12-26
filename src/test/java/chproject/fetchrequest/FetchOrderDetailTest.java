/**
 * 
 */
package chproject.fetchrequest;

import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

/**
 * @author naveenbhardwaj
 *
 */
public class FetchOrderDetailTest {

	final static String ROOT_URI = "http://localhost:51544";
	
	@Test
	public void testResponseCodeOK() {
		Assert.assertEquals(get(ROOT_URI + "/v1/orders/1").getStatusCode(), 200);
	}
	
	@Test
	public void testResponseCodeNotFound() {
		Assert.assertEquals(get(ROOT_URI + "/v1/orders/2").getStatusCode(), 404);
	}
}
