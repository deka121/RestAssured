package api.test;

import api.endpoints.UserEndPointsProp;
import api.payload.User;
import com.github.javafaker.Faker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;



public class UserTests {

    Faker faker;
    User userPayload;
    public Logger logger;
    @BeforeClass
    public void setupData() {
        faker = new Faker();
        userPayload = new User();
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        logger= LogManager.getLogger(this.getClass());

    }

    @Test(priority = 1)
    public void testPostUser() {
        logger.info("******* Creating User ********");
        Response response = UserEndPointsProp.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("******* User is created ********");

    }

    @Test(priority = 2)
    public void testGetUserByName() {
        logger.info("******* Reading User info ********");
        Response response = UserEndPointsProp.readUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.statusCode(), 200);
        logger.info("******* User info is displayed ********");
    }

    @Test(priority = 3)
    public void testUpdateByUser() {
        logger.info("*******Updating User ********");
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());

        Response responseAfterUpdate = UserEndPointsProp.updateUser(this.userPayload.getUsername(), userPayload);
        //this is chai assertion which come along with rest assured
        responseAfterUpdate.then().log().body().statusCode(200);
        //TestNg assertion
        Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
        logger.info("*******User updated ********");
    }

    @Test(priority = 4)
    public void testDeleteUserByName() {
        logger.info("*******deleting User ********");
        Response response = UserEndPointsProp.deleteUser(this.userPayload.getUsername());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("*******User deleted ********");
    }
}
