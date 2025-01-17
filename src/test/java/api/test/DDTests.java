package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.Dataproviders;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DDTests {

    @Test(priority = 1,dataProvider="Data",dataProviderClass = Dataproviders.class)
    public void testPostUser(String userID, String userName, String fname, String lname, String useremail,String pw,String ph) {
       User userPayload= new User();
        userPayload.setId(Integer.parseInt(userID));
        userPayload.setUsername(userName);
        userPayload.setFirstName(fname);
        userPayload.setLastName(lname);
        userPayload.setEmail(useremail);
        userPayload.setPassword(pw);
        userPayload.setPhone(ph);

        Response response = UserEndPoints.createUser(userPayload);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2, dataProvider = "UserNames",dataProviderClass = Dataproviders.class)
    public void testDeleteUserByName(String userName)
    {
       Response response= UserEndPoints.deleteUser(userName);
       Assert.assertEquals(response.statusCode(),200);
    }

}
