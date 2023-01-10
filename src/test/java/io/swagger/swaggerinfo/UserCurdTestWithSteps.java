package io.swagger.swaggerinfo;

import io.swagger.testbase.TestBase;
import io.swagger.utils.TestUtils;
import junit.framework.Assert;
import junit.framework.Test;

import java.util.HashMap;

public class UserCurdTestWithSteps extends TestBase {
    static int id = TestUtils.getRandomNum();
    static String username = "Hasit" + TestUtils.getRandomValue();
    static String firstName = "Hasit";
    static String lastName = "Patel";
    static String email = "Hasit.Patel" + TestUtils.getRandomValue() + "@email.com";
    static String password = "Happy" + TestUtils.getRandomNum();
    static String phone = "075" + TestUtils.getRandomPhone();
    static int userStatus = 1;

    static int userID;

    @Steps
    UserSteps userSteps;

    @Title("This will create a new user")
    @Test
    public void test001() {

        ValidatableResponse response = userSteps.createUser(id, username, firstName, lastName, email, password, phone, userStatus);
        response.log().all().statusCode(200);
        response.extract().path("id");


    }

    @Title("This will verify that new user has been created")
    @Test
    public void test002() {
        HashMap<String, Object> userMap = userSteps.getUserInfoByUserId(username);
        Assert.assertThat(userMap, hasValue(username));
        userID = (int) userMap.get("id");
    }


    @Title("This will update a new user")
    @Test
    public void test003() {
        firstName = firstName + "_update";
        ValidatableResponse response = userSteps.updateUser(id, username, firstName, lastName, email, password, phone, userStatus);
        response.log().all().statusCode(200);


        HashMap<String, Object> userMap = userSteps.getUserInfoByUserId(username);
        Assert.assertThat(userMap, hasValue(userID));
    }

    @Title("Deleting user and verifying user is deleted")
    @Test
    public void test004(){
        userSteps.deleteUser(username).statusCode(200);
        userSteps.getUserInfoAfterDeletion(username).statusCode(404);

    }
}
