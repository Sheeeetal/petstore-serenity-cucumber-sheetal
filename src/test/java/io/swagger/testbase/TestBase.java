package io.swagger.testbase;

import io.swagger.utils.PropertyReader;

public class TestBase {
    public static PropertyReader propertyReader;

    @BeforeClass
    public static void init() {
        propertyReader = PropertyReader.getInstance();
        RestAssured.baseURI = propertyReader.getProperty("baseUrl");
        // RestAssured.port = Integer.parseInt(propertyReader.getProperty("port"));
        // RestAssured.basePath = Path.USERS;
    }
}
