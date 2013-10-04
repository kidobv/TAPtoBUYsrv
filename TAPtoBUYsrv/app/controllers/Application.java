package controllers;

import java.util.ArrayList;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import models.Product;
import play.*;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
    	System.out.println("");
        return ok(index.render("Your new application is ready."));
    }
    
    public static Result example() { 

    	    ArrayList<Product> theList = new ArrayList<Product>();
    	    Product item1 = new Product("libro",10);
    	    Product item2 = new Product("Carro",500);
    	    theList.add(item1);
    	    theList.add(item2);
    	    Json.newObject().POJONode(item1);
    	    
    	    ObjectNode json = Json.newObject();
    	    json.put("Kevin", "Cast");
    	    json.put("Ca", 25);
    	    json.putObject("jas");
    	    json.putPOJO("Pojo", Json.toJson(theList));
    	    return ok(json); 
    	} 
    public static Result checkLogin(){
    	JsonNode json = request().body().asJson();
    	  if(json == null) {
    	    return badRequest("Expecting Json data");
    	  } 
    	  else {
    	    String username = json.findPath("username").getTextValue();
    	    String password = json.findPath("password").getTextValue();
    	    if(username.equals("Lolo") && password.equals("bond")){
    	      return ok("You're now signed in");
    	    }
    	    else{
    	    	return unauthorized("Bad username or password");
    	    }
    	  }

    }
  
}
