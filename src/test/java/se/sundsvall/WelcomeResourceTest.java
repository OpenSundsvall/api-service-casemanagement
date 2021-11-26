package se.sundsvall;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class WelcomeResourceTest {

    @Test
    void testHelloEndpoint() {
        given().when().get("/").then().statusCode(200);
    }

}