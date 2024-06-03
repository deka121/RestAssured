/*Used for CRUD -Create,Read,Update and Delete Operation*/

package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class UserEndPointsProp {

    static ResourceBundle getUrl() {
        /*Load the properties file*/
        ResourceBundle routes = ResourceBundle.getBundle("routes");
        return routes;
    }


    public static Response createUser(User payload) {
        /*Using getString method passing key we will be able to get the url in to a variable*/
        String post_url = getUrl().getString("post_url");

        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(post_url);
        return response;
    }

    public static Response readUser(String userName) {
        String get_url = getUrl().getString("get_url");
        Response response = given()
                .pathParam("Username", userName)
                .when()
                .get(get_url); //define the path parameter
        return response;
    }


    public static Response updateUser(String userName, User payload) {
        String update_url = getUrl().getString("update_url");
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("Username", userName)
                .body(payload)
                .when()
                .put(update_url); //define the path parameter
        return response;
    }

    public static Response deleteUser(String userName) {
        String delete_url = getUrl().getString("delete_url");

        Response response = given()
                .pathParam("Username", userName)
                .when()
                .delete(delete_url); //define the path parameter
        return response;
    }


}
