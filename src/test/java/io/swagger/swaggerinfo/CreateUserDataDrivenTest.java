package io.swagger.swaggerinfo;

import io.swagger.testbase.TestBase;

public class CreateUserDataDrivenTest extends TestBase {
    private int id;

    private String userName;

    private String firstName;

    private String lastName;
    private String email;
    private String password;
    private String phone;
    private int userStatus;

    @Steps
    UserSteps userSteps;

    @Title("Data driven test for adding multiple user to the application")
    @Test
    public void createMultipleUsers(){
        userSteps.createUser(id,userName,firstName,lastName,email,password,phone,userStatus).statusCode(200);

    }
}
