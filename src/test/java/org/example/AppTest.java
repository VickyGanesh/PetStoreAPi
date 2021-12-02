package org.example;

import static org.junit.Assert.assertTrue;

import Data.RequestModel;
import Data.ResponseModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
//import org.testng.annotations.Test;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    RequestModel user ;
    RequestModel userOne;
    RequestModel userTwo;
    RequestModel updatedUser;

   @Test
    public void createSingleUser(){
        user = new RequestModel();
        user.setId(1000);
        user.setUsername("MickyMouse");
        user.setFirstName("Mickey");
        user.setLastName("Mouse");
        user.setEmail("mickeymouse@disney.com");
        user.setPassword("clubhouse");
        user.setPhone("9823523");
        user.setUserStatus(0);

//        ResponseModel responseObjOne = RestAssured.given().contentType(ContentType.JSON).body(user).when()
//                .post("https://petstore.swagger.io/v2/user").as(ResponseModel.class);
//        Assert.assertEquals(responseObjOne.getCode() , 200);
//        String strId = "" + user.getId();
//        Assert.assertEquals(strId , responseObjOne.getMessage());

    }

   /* @Test
    public void createUserArray(){
        ArrayList<RequestModel> userList = new ArrayList<RequestModel>();
        userOne = new RequestModel();
        userOne.setId(1001);
        userOne.setUsername("TomCat");
        userOne.setFirstName("Tom");
        userOne.setLastName("Cat");
        userOne.setEmail("tomcat@mgm.com");
        userOne.setPassword("butch");
        userOne.setPhone("1223232");
        userOne.setUserStatus(0);
        userList.add(userOne);

        userTwo = new RequestModel();
        userTwo = new RequestModel();
        userTwo.setId(1001);
        userTwo.setUsername("TomCat");
        userTwo.setFirstName("Tom");
        userTwo.setLastName("Cat");
        userTwo.setEmail("tomcat@mgm.com");
        userTwo.setPassword("butch");
        userTwo.setPhone("1223232");
        userTwo.setUserStatus(0);
        userList.add(userTwo);

        ResponseModel responseObjTwo = RestAssured.given().contentType(ContentType.JSON).body(userList)
                .when().post("https://petstore.swagger.io/v2/user/createWithArray")
                .as(ResponseModel.class);
        Assert.assertEquals(responseObjTwo.getCode() , 200);
        System.out.println(responseObjTwo.getMessage());
        System.out.println(responseObjTwo.getCode());
        Assert.assertEquals(responseObjTwo.getMessage() , "ok");

    }*/

    @Test
    public void updateUser(){
        updatedUser = new RequestModel();
        updatedUser.setId(1000);
        updatedUser.setUsername("MickeyMinnieMouse");
        updatedUser.setFirstName("MickeyMinnie");
        updatedUser.setLastName("Mouse");
        updatedUser.setEmail("mmmouse@mgm.com");
        updatedUser.setPassword("pluto");
        updatedUser.setPhone("1223232");
        updatedUser.setUserStatus(0);
//      System.out.println("User Name before update "+user.returnUserName());
//        ResponseModel responseObjTHREE = RestAssured.given().contentType(ContentType.JSON).body(updatedUser)
//                .when().put("https://petstore.swagger.io/v2/user/" + user.returnUserName())
//                .as(ResponseModel.class);
//        Assert.assertEquals(responseObjTHREE.getCode() , 200);
//        System.out.println(responseObjTHREE.getMessage());
//        System.out.println(responseObjTHREE.getCode());
//        Response responseOne =  RestAssured.get("https://petstore.swagger.io/v2/user/" + updatedUser.returnUserName());
//        System.out.println(responseOne.asPrettyString());
    }

    @Test
    public void deleteUser(){
        System.out.println(updatedUser.returnUserName());
        ResponseModel responseObjFOUR = RestAssured.given().
                delete("https://petstore.swagger.io/v2/user/" + updatedUser.returnUserName())
                .as(ResponseModel.class);
        Response response = RestAssured.get("https://petstore.swagger.io/v2/user/" + updatedUser.returnUserName());
        Assert.assertNotEquals(responseObjFOUR.getCode() , 200);
        System.out.println(responseObjFOUR.getMessage());
        System.out.println(responseObjFOUR.getCode());
        Response responseTwo =  RestAssured.get("https://petstore.swagger.io/v2/user/" + updatedUser.returnUserName());
        System.out.println(responseTwo.asPrettyString());
    }



}
