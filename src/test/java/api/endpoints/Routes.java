package api.endpoints;
/*
* Swagger URI -->https://petstore.swagger.io
* Create user(Post): https://petstore.swagger.io/v2/user
* Get user(Get):https://petstore.swagger.io/#/user/getUserByName
* Update user(Put):https://petstore.swagger.io/#/user/updateUser
* Delete user(Delete):https://petstore.swagger.io/#/user/deleteUser
* */
public class Routes {
    public static String base_url="https://petstore.swagger.io/v2/";

    //User Module
    public static String post_url=base_url+"user";
    public static String get_url=base_url+"user/{Username}";
    public static String update_url=base_url+"user/{Username}";
    public static String delete_url=base_url+"user/{Username}";

}
