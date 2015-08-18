import java.util.HashMap;
import java.util.ArrayList;
import.java.util.Timer;
import.java.util.TimerTask;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("template", "templates/index.vtl");

        Pet myPet = request.session().attribute("myPet");
        model.put ("myPet", myPet); // $myPet.getName

        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      // form action =/pet come from the homepage.vtl
      post("/pet", (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();

        String myPetName = request.queryParams("myPet");//"myPet" is the name=
        Pet newPet = new Pet(myPetName);

        request.session().attribute("myPet", newPet);//save so we can access elsewhere in app
        model.put("myPet", newPet);

        model.put("template", "templates/success.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      post("/feed"), (request, response) -> {
        HashMap<String, Object> model = new HashMap<String, Object>();
        Pet myPet = request.session().attribute("myPet";//"myPet" is the name=
        Float foodAmount = 10.0;
        Float sleepyTime = -10.0;
        Float playTime = -10.0;
        myPet.setFoodLevel(foodTime);
        myPet.setTiredLevel(sleepyTime);
        myPet.setActivityLevel(playTime);
        model.put("myPet", newPet);

        post("/rest"), (request, response) -> {
          HashMap<String, Object> model = new HashMap<String, Object>();
          Pet myPet = request.session().attribute("myPet";//"myPet" is the name=
          Float foodAmount = -10.0;
          Float sleepyTime = 10.0;
          Float playTime = -10.0;
          myPet.setFoodLevel(foodTime);
          myPet.setTiredLevel(sleepyTime);
          myPet.setActivityLevel(playTime);
          model.put("myPet", newPet);

          post("/play"), (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            Pet myPet = request.session().attribute("myPet";//"myPet" is the name=
            Float foodAmount = -10.0;
            Float sleepyTime = -10.0;
            Float playTime = 10.0;
            myPet.setFoodLevel(foodTime);
            myPet.setTiredLevel(sleepyTime);
            myPet.setActivityLevel(playTime);
            model.put("myPet", newPet);

        model.put("template", "templates/success.vtl");
        return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

//
// get("/create_pet") ->
//
//  Pet myPet = new Pet();
//  request.session().attribute("myPet", myPet);
// )
//
// get("/play", ... ->
//  myPet = request.session().attribute("myPet");
//
//  myPet.play();
// )
//
//
// get("/create_pet") ->
//
//  Pet myPet = new Pet();
//  request.session().attribute("myPet", myPet);
// )
//
// get("/play", ... ->
//  myPet = request.session().attribute("myPet");
//
//  myPet.play();
// )
