package ch.mhaspra.adapter;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
class BlockingVsNonBlockingResourceTest {
    @Test
    void blockingBlocking() {
      given()
        .when()
          .get("blocking-vs-nonblocking/blocking-blocking")
        .then()
          .statusCode(200)
          .body(startsWith("executor-thread"));
    }

    @Test
    void blockingNonblocking() {
        given()
                .when()
                .get("blocking-vs-nonblocking/blocking-nonblocking")
                .then()
                .statusCode(200)
                .body(startsWith("executor-thread"));
    }

    @Test
    void nonblockingNonblocking() {
        given()
                .when()
                .get("blocking-vs-nonblocking/nonblocking-nonblocking")
                .then()
                .statusCode(200)
                .body(startsWith("vert.x-eventloop-thread"));
    }

    @Test
    void nonblockingBlocking() {
        given()
                .when()
                .get("blocking-vs-nonblocking/nonblocking-blocking")
                .then()
                .statusCode(200)
                .body(startsWith("vert.x-eventloop-thread"));
    }
}