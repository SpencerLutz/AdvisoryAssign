
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;  

public class UI extends Application {

Stage window;
Scene mainScene;
Scene settingsScene;

public static String[] advisoryList = {"Bator","Bebensee","Beck/Martinez","Mrs. Berryman","Mr. Berryman","Bishop","Davis","Dunn",
						 "Everts","Holsinger","Leer","Mahler","Morrish","O'Neill","Pergande","Samples","Snowden",
						 "Thompson","Wheeler","Wiggs"};

public static String[] locationList = {"Upper Left Alcove","Upper Left Hallway","Upper Left Diagonal Bench","Upper Left Center Rail",
						 "Upper Right Alcove","Upper Right Hallway","Upper Right Diagonal Bench","Upper Left Center Rail",
						 "Stair landing","Upper Stairs","Lower Stairs","Atrium Floor","Mic Stand","Lower Left Diagonal",
						 "Lower Left Hallway","Student Kitchen","Left Giant Step","Right Giant Step","Lower Right Diagonal 1",
						 "Lower Right Hallway","Lower Right Diagonal 2"};


@Override
public void start(Stage primaryStage) throws Exception {      

	  window = primaryStage;
      Group main = new Group();
      mainScene = new Scene(main ,1000, 600); 
      mainScene.setFill(Color.SKYBLUE);  
           
      Group settings = new Group();
      Scene settingsScene = new Scene(settings,1000,600);
      settingsScene.setFill(Color.ALICEBLUE);
      Button goBack = new Button();
      goBack.setText("Go Back");
      goBack.setPrefWidth(200);
      goBack.setPrefHeight(50);
      goBack.setFont(new Font(25));
      goBack.setOnAction(e->window.setScene(mainScene));
      VBox listOfAdvisories = new VBox(5);
      listOfAdvisories.setLayoutY(55);
      Label advisories = new Label("Advisories");
      advisories.setFont(Font.font(null, FontWeight.BOLD,15));
      listOfAdvisories.getChildren().add(advisories);
      for(int i = 0;i<advisoryList.length;i++) {
    	  Label advisory = new Label(advisoryList[i]);
    	  advisory.setFont(new Font(15));
    	  listOfAdvisories.getChildren().add(advisory);
      }
      
      VBox listOfLocations = new VBox(5);
      Label locations = new Label("Locations");
      locations.setFont(Font.font(null,FontWeight.BOLD,15));
      listOfLocations.setLayoutX(200);
      listOfLocations.setLayoutY(55);
      listOfLocations.getChildren().add(locations);
      for(int i = 0;i<locationList.length;i++) {
    	  Label location = new Label(locationList[i]);
    	  location.setFont(new Font(15));
    	  listOfLocations.getChildren().add(location);
      }
      
      Button addAdvisory = new Button("Add Advisory");
      addAdvisory.setPrefWidth(200);
      addAdvisory.setPrefHeight(50);
      addAdvisory.setLayoutX(200);
      addAdvisory.setFont(new Font(25));
      
      Button removeAdvisory = new Button("Remove Advisory");
      removeAdvisory.setPrefWidth(250);
      removeAdvisory.setPrefHeight(50);
      removeAdvisory.setLayoutX(400);
      removeAdvisory.setFont(new Font(25));
      
      TextField enterAdvisory = new TextField("Advisory To Add");
      enterAdvisory.setLayoutX(650);
      
      TextField enterAdvisoryToRemove = new TextField("Advisory To Remove");
      enterAdvisoryToRemove.setLayoutX(798);
      
      Button randomlyAssign = new Button("Assign randomly");
      randomlyAssign.setPrefWidth(300);
      randomlyAssign.setPrefHeight(50);
      randomlyAssign.setLayoutX(700);
      randomlyAssign.setLayoutY(550);
      randomlyAssign.setFont(new Font(25));
      
      settings.getChildren().addAll(goBack,listOfAdvisories,listOfLocations,addAdvisory,enterAdvisory,removeAdvisory,
    		  						enterAdvisoryToRemove,randomlyAssign);
      
      Button settingsButton = new Button();
      settingsButton.setText("Settings");
      settingsButton.setPrefWidth(200);
      settingsButton.setPrefHeight(50);
      settingsButton.setFont(new Font(25));
      settingsButton.setOnAction(e->window.setScene(settingsScene));
      main.getChildren().add(settingsButton);
      
      Label currentArrangement = new Label("Current Arrangement: ");
      currentArrangement.setFont(Font.font(null,FontWeight.BOLD,15));
      currentArrangement.setLayoutY(55);
      main.getChildren().add(currentArrangement);
      
      VBox curArrangement = new VBox(5);
      curArrangement.setLayoutY(80);
      for(int i = 0;i<advisoryList.length;i++) {
    	  Label curAssignment = new Label(advisoryList[i] + " assigned to " + locationList[i] + ".");
    	  curAssignment.setFont(new Font(15));
    	  curArrangement.getChildren().add(curAssignment);
      }
      main.getChildren().add(curArrangement);
      
      window.setScene(mainScene);
      window.setTitle("Advisory Assigning");
      window.show(); 
   }    

public void settings(Stage settingsStage) throws Exception {
	Group root = new Group();
	Scene settingsScene = new Scene(root,1000,600);
	settingsStage.show();
}
   public static void main(String args[]){          
      launch(args);    
   }         
}