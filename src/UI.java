

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.GroupLayout.Alignment;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class Main extends Application {
	
	final Color SAYREBLUE = Color.rgb(0,46,95);
	final Color SAYREYELLOW = Color.rgb(255,204,1);
	
@Override
public void start(Stage primaryStage) {
	QuinteroBackend allData = new QuinteroBackend();
	primaryStage.setFullScreen(true);
	
	VBox pairingsVBox = new VBox();
	pairingsVBox.setSpacing(10);
	pairingsVBox.setLayoutX(450);
	pairingsVBox.setLayoutY(250);
	
	VBox pairingsVBoxTwo = new VBox();
	pairingsVBoxTwo.setSpacing(10);
	pairingsVBoxTwo.setLayoutX(850);
	pairingsVBoxTwo.setLayoutY(250);
	
	Group root = new Group();
	Group settingsGroup = new Group();
	Group editAdvisoriesGroup = new Group();
	Group editLocationsGroup = new Group();
	Group locationsGroup = new Group();
	Group advisoriesGroup = new Group();
	Group helpGroup = new Group();
	Group infoGroup = new Group();
	
	Scene homeScene = new Scene(root);
	Scene settingsScene = new Scene(settingsGroup);
	Scene editAdvisoriesScene = new Scene(editAdvisoriesGroup);
	Scene editLocationsScene = new Scene(editLocationsGroup);
	Scene locationsScene = new Scene(locationsGroup);
	Scene advisoriesScene = new Scene(advisoriesGroup);
	Scene helpScene = new Scene(helpGroup);
	Scene infoScene = new Scene(infoGroup);
	
	helpScene.setFill(SAYREBLUE);
	
	Image backImageSix = new Image("backIcon.png");
	ImageView backImageViewSix = new ImageView(backImageSix);
	backImageViewSix.setLayoutX(50);
	backImageViewSix.setLayoutY(58);
	
	Button backButtona = new Button("Back");
	backButtona.setPrefWidth(150);
	backButtona.setPrefHeight(75);
	backButtona.setLayoutX(50);
	backButtona.setLayoutY(50);
	backButtona.setFont(new Font("Consolas",25));
	backButtona.setTextFill(SAYREYELLOW);
	backButtona.setStyle("-fx-background-color: rgb(0,46,200);");
	backButtona.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	backButtona.setOnMouseEntered(e-> {
		backButtona.setStyle("-fx-background-color: rgb(0,46,125);");
	});
	
	backButtona.setOnMouseExited(e-> {
		backButtona.setStyle("-fx-background-color: rgb(0,46,150);");
	});
	
	backButtona.setOnAction(e-> {
		primaryStage.setScene(homeScene);
		primaryStage.setFullScreen(true);
	});
	
	Label firstTitle = new Label("How to add an advisory: ");
	firstTitle.setLayoutX(50);
	firstTitle.setLayoutY(150);
	firstTitle.setFont(Font.font("Consolas",FontWeight.BOLD,25));
	firstTitle.setTextFill(SAYREYELLOW);
	
	Label firstStep = new Label("1. Go to settings and select the edit advisories option");
	firstStep.setLayoutX(50);
	firstStep.setLayoutY(200);
	firstStep.setFont(Font.font("Consolas",20));
	firstStep.setTextFill(SAYREYELLOW);
	
	Label secondStep = new Label("2. Enter the new advisor's name and click the add button");
	secondStep.setLayoutX(50);
	secondStep.setLayoutY(250);
	secondStep.setFont(Font.font("Consolas",20));
	secondStep.setTextFill(SAYREYELLOW);
	
	Label thirdStep = new Label("3. Add a corresponding location for the new advisor");
	thirdStep.setLayoutX(50);
	thirdStep.setLayoutY(300);
	thirdStep.setFont(Font.font("Consolas",20));
	thirdStep.setTextFill(SAYREYELLOW);
	
	Label secondTitle = new Label("How to add a location: ");
	secondTitle.setLayoutX(50);
	secondTitle.setLayoutY(350);
	secondTitle.setFont(Font.font("Consolas",FontWeight.BOLD,25));
	secondTitle.setTextFill(SAYREYELLOW);
	
	Label fourthStep = new Label("1. Go to settings and select the edit locations option");
	fourthStep.setLayoutX(50);
	fourthStep.setLayoutY(400);
	fourthStep.setFont(Font.font("Consolas",20));
	fourthStep.setTextFill(SAYREYELLOW);
	
	Label fifthStep = new Label("2. Enter the location's name and its score");
	fifthStep.setLayoutX(50);
	fifthStep.setLayoutY(450);
	fifthStep.setFont(Font.font("Consolas",20));
	fifthStep.setTextFill(SAYREYELLOW);
	
	Label sixthStep = new Label("3. Press the add location button");
	sixthStep.setLayoutX(50);
	sixthStep.setLayoutY(500);
	sixthStep.setFont(Font.font("Consolas",20));
	sixthStep.setTextFill(SAYREYELLOW);
	
	
	Label thirdTitle = new Label("Once you add a new advisor and location, make sure to randomize assignments again");
	thirdTitle.setLayoutX(50);
	thirdTitle.setLayoutY(550);
	thirdTitle.setFont(Font.font("Consolas",FontWeight.BOLD,25));
	thirdTitle.setTextFill(SAYREYELLOW);
	
	helpGroup.getChildren().addAll(backButtona,backImageViewSix,firstTitle,firstStep,secondStep,thirdStep,
			secondTitle,fourthStep,fifthStep,sixthStep,thirdTitle);
	
	editLocationsScene.setFill(SAYREBLUE);
	Image backImageThree = new Image("backIcon.png");
	ImageView backImageViewThree = new ImageView(backImageThree);
	backImageViewThree.setLayoutX(50);
	backImageViewThree.setLayoutY(58);
	
	Button backToSettingsTwo = new Button("Back");
	backToSettingsTwo.setPrefWidth(150);
	backToSettingsTwo.setPrefHeight(75);
	backToSettingsTwo.setLayoutX(50);
	backToSettingsTwo.setLayoutY(50);
	backToSettingsTwo.setFont(new Font("Consolas",25));
	backToSettingsTwo.setTextFill(SAYREYELLOW);
	backToSettingsTwo.setStyle("-fx-background-color: rgb(0,46,200);");
	backToSettingsTwo.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	backToSettingsTwo.setOnMouseEntered(e-> {
		backToSettingsTwo.setStyle("-fx-background-color: rgb(0,46,125);");
	});
	
	backToSettingsTwo.setOnMouseExited(e-> {
		backToSettingsTwo.setStyle("-fx-background-color: rgb(0,46,150);");
	});
	
	backToSettingsTwo.setOnAction(e-> {
		primaryStage.setScene(settingsScene);
		primaryStage.setFullScreen(true);
	});
	
	Label locationsLabel = new Label("Current Locations: ");
	locationsLabel.setFont(Font.font("Consolas",FontWeight.BOLD,30));
	locationsLabel.setTextFill(SAYREYELLOW);
	locationsLabel.setLayoutX(250);
	locationsLabel.setLayoutY(75);
	
	VBox locationsVBox = new VBox();
	locationsVBox.setSpacing(10);
	locationsVBox.setLayoutX(275);
	locationsVBox.setLayoutY(125);
	
	VBox locationsVBoxTwo = new VBox();
	locationsVBoxTwo.setSpacing(10);
	locationsVBoxTwo.setLayoutX(600);
	locationsVBoxTwo.setLayoutY(125);
	
	TextField locationInput = new TextField("Location");
	locationInput.setPrefWidth(125);
	locationInput.setPrefHeight(75);
	locationInput.setLayoutX(900);
	locationInput.setLayoutY(75);
	locationInput.setFont(new Font("Consolas",20));
	locationInput.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	TextField scoreInput = new TextField("Score");
	scoreInput.setPrefWidth(125);
	scoreInput.setPrefHeight(75);
	scoreInput.setLayoutX(900);
	scoreInput.setLayoutY(150);
	scoreInput.setFont(new Font("Consolas",20));
	scoreInput.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	Button addLocation = new Button("Add");
	addLocation.setPrefWidth(100);
	addLocation.setPrefHeight(75);
	addLocation.setLayoutX(1025);
	addLocation.setLayoutY(75);
	addLocation.setFont(new Font("Consolas",20));
	addLocation.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	addLocation.setOnAction(e-> {
		allData.addLocation(locationInput.getText(),Integer.parseInt(scoreInput.getText()));
		allData.save();
		Label currentLabel = new Label(locationInput.getText() + " : " + scoreInput.getText());
		currentLabel.setFont(new Font("Consolas",15));
		currentLabel.setTextFill(SAYREYELLOW);
		
		for(int i = 0;i<allData.locations.size();i++) {
			if(allData.locations.get(i).name.contentEquals(locationInput.getText())) {
				if(i > 15) {
					locationsVBoxTwo.getChildren().add(currentLabel);
				} else {
					locationsVBox.getChildren().add(currentLabel);
				}
			}
		}
	});
	
	Button removeLocation = new Button("Remove");
	removeLocation.setPrefWidth(100);
	removeLocation.setPrefHeight(75);
	removeLocation.setLayoutX(1125);
	removeLocation.setLayoutY(75);
	removeLocation.setFont(new Font("Consolas",20));
	removeLocation.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	removeLocation.setOnAction(e-> {
		allData.removeLocation(locationInput.getText());
		allData.save();
		for(int i = 0;i<locationsVBox.getChildren().size();i++) {
			Label currentLabel = (Label) locationsVBox.getChildren().get(i);
			if(currentLabel.getText().equals(locationInput.getText())) {
				locationsVBox.getChildren().remove(i);
			}
		}
		for(int i = 0;i<locationsVBoxTwo.getChildren().size();i++) {
			Label currentLabel = (Label) locationsVBoxTwo.getChildren().get(i);
			if(currentLabel.getText().equals(locationInput.getText())) {
				locationsVBoxTwo.getChildren().remove(i);
			}
		}
		locationsVBox.getChildren().clear();
		locationsVBoxTwo.getChildren().clear();
		for(int i = 0;i<allData.locations.size();i++) {
			Label currentLabel = new Label(allData.locations.get(i).name + " : " + allData.locations.get(i).score);
			currentLabel.setFont(new Font("Consolas",15));
			currentLabel.setTextFill(SAYREYELLOW);
			if(i<15) {
				locationsVBox.getChildren().add(currentLabel);
			} else {
				locationsVBoxTwo.getChildren().add(currentLabel);
			}
		}
	});
	
	for(int i = 0;i<allData.locations.size();i++) {
		Label currentLabel = new Label(allData.locations.get(i).name + " : " + allData.locations.get(i).score);
		currentLabel.setFont(new Font("Consolas",15));
		currentLabel.setTextFill(SAYREYELLOW);
		if(i<15) {
			locationsVBox.getChildren().add(currentLabel);
		} else {
			locationsVBoxTwo.getChildren().add(currentLabel);
		}
	}
	
	editLocationsGroup.getChildren().addAll(backToSettingsTwo,backImageViewThree,locationsLabel,locationsVBox,
			locationsVBoxTwo,locationInput,scoreInput,addLocation,removeLocation);
		
	editAdvisoriesScene.setFill(SAYREBLUE);
	
	primaryStage.setScene(homeScene);
	homeScene.setFill(SAYREBLUE);
	
	Image backImageTwo = new Image("backIcon.png");
	ImageView backImageViewTwo = new ImageView(backImageTwo);
	backImageViewTwo.setLayoutX(50);
	backImageViewTwo.setLayoutY(58);
	
	settingsScene.setFill(SAYREBLUE);
	
	Button backToSettings = new Button("Back");
	backToSettings.setPrefWidth(150);
	backToSettings.setPrefHeight(75);
	backToSettings.setLayoutX(50);
	backToSettings.setLayoutY(50);
	backToSettings.setFont(new Font("Consolas",25));
	backToSettings.setTextFill(SAYREYELLOW);
	backToSettings.setStyle("-fx-background-color: rgb(0,46,200);");
	backToSettings.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	backToSettings.setOnMouseEntered(e-> {
		backToSettings.setStyle("-fx-background-color: rgb(0,46,125);");
	});
	
	backToSettings.setOnMouseExited(e-> {
		backToSettings.setStyle("-fx-background-color: rgb(0,46,150);");
	});
	
	backToSettings.setOnAction(e-> {
		primaryStage.setScene(settingsScene);
		primaryStage.setFullScreen(true);
	});
	
	Label advisoriesLabel = new Label("Current Advisories: ");
	advisoriesLabel.setFont(Font.font("Consolas",FontWeight.BOLD,30));
	advisoriesLabel.setTextFill(SAYREYELLOW);
	advisoriesLabel.setLayoutX(250);
	advisoriesLabel.setLayoutY(75);
	
	VBox advisoriesVBox = new VBox();
	advisoriesVBox.setSpacing(10);
	advisoriesVBox.setLayoutX(275);
	advisoriesVBox.setLayoutY(125);
	
	VBox advisoriesVBoxTwo = new VBox();
	advisoriesVBoxTwo.setSpacing(10);
	advisoriesVBoxTwo.setLayoutX(400);
	advisoriesVBoxTwo.setLayoutY(125);
	
	TextField input = new TextField("Advisory");
	input.setLayoutX(600);
	input.setLayoutY(75);
	input.setPrefWidth(250);
	input.setPrefHeight(75);
	input.setFont(new Font("Consolas",30));
	input.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	Button addAdvisor = new Button("Add");
	addAdvisor.setLayoutX(850);
	addAdvisor.setLayoutY(75);
	addAdvisor.setPrefWidth(100);
	addAdvisor.setPrefHeight(37);
	addAdvisor.setFont(new Font("Consolas",20));
	addAdvisor.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	Button removeAdvisor = new Button("Remove");
	removeAdvisor.setLayoutX(850);
	removeAdvisor.setLayoutY(112);
	removeAdvisor.setPrefWidth(100);
	removeAdvisor.setPrefHeight(37);
	removeAdvisor.setFont(new Font("Consolas",20));
	removeAdvisor.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	for(int i = 0;i<allData.advisories.size();i++) {
		Label currentLabel = new Label(allData.advisories.get(i).name);
		currentLabel.setTextFill(SAYREYELLOW);
		currentLabel.setFont(new Font("Consolas",15));
		if(i<15) {
			advisoriesVBox.getChildren().add(currentLabel);
		} else {
			advisoriesVBoxTwo.getChildren().add(currentLabel);
		}
	}
	
	addAdvisor.setOnAction(e-> {
		allData.addAdvisory(input.getText());
		allData.save();
		Label currentLabel = new Label(input.getText());
		currentLabel.setFont(new Font("Consolas",15));
		currentLabel.setTextFill(SAYREYELLOW);
		
		for(int i = 0;i<allData.advisories.size();i++) {
			if(allData.advisories.get(i).name.contentEquals(input.getText())) {
				if(i > 15) {
					advisoriesVBoxTwo.getChildren().add(currentLabel);
				} else {
					advisoriesVBox.getChildren().add(currentLabel);
				}
			}
		}
	});
	
	removeAdvisor.setOnAction(e-> {
		allData.removeAdvisory(input.getText());
		allData.save();
		allData.advisories.clear();
		allData.locations.clear();
		advisoriesVBox.getChildren().clear();
		advisoriesVBoxTwo.getChildren().clear();
		allData.getData();
		for(int i = 0;i<allData.advisories.size();i++) {
			Label currentLabel = new Label(allData.advisories.get(i).name);
			currentLabel.setFont(new Font("Consolas",15));
			currentLabel.setTextFill(SAYREYELLOW);
			if(i<15) {
				advisoriesVBox.getChildren().add(currentLabel);
			} else {
				advisoriesVBoxTwo.getChildren().add(currentLabel);
			}
		}
	});
	
	editAdvisoriesGroup.getChildren().addAll(backToSettings,backImageViewTwo,advisoriesLabel,advisoriesVBox,
			advisoriesVBoxTwo,input,addAdvisor,removeAdvisor);
	
	Image backImage = new Image("backIcon.png");
	ImageView backImageView = new ImageView(backImage);
	backImageView.setLayoutX(50);
	backImageView.setLayoutY(58);
	
	Button backButton = new Button("Back");
	backButton.setPrefWidth(150);
	backButton.setPrefHeight(75);
	backButton.setLayoutX(50);
	backButton.setLayoutY(50);
	backButton.setFont(new Font("Consolas",25));
	backButton.setTextFill(SAYREYELLOW);
	backButton.setStyle("-fx-background-color: rgb(0,46,200);");
	backButton.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	backButton.setOnMouseEntered(e-> {
		backButton.setStyle("-fx-background-color: rgb(0,46,125);");
	});
	
	backButton.setOnMouseExited(e-> {
		backButton.setStyle("-fx-background-color: rgb(0,46,150);");
	});
	
	backButton.setOnAction(e-> {
		primaryStage.setScene(homeScene);
		primaryStage.setFullScreen(true);
		allData.locations.clear();
		allData.advisories.clear();
		allData.lines.clear();
		pairingsVBox.getChildren().clear();
		pairingsVBoxTwo.getChildren().clear();
		allData.getData();
		for(int i = 0;i<allData.advisories.size();i++) {
			int index = allData.advisories.get(i).locationIndex;
			String name = allData.advisories.get(i).name;
			String location = allData.locations.get(index).name;
			Label currentLabel = new Label(name + " : " + location);
			currentLabel.setFont(new Font("Consolas",15));
			currentLabel.setTextFill(SAYREYELLOW);
			if(i<15) {
				pairingsVBox.getChildren().add(currentLabel);
			} else {
				pairingsVBoxTwo.getChildren().add(currentLabel);
			}
		}
	});
	
	Button editAdvisories = new Button("Edit Advisories");
	editAdvisories.setPrefWidth(200);
	editAdvisories.setPrefHeight(75);
	editAdvisories.setLayoutX(500);
	editAdvisories.setLayoutY(200);
	editAdvisories.setTextFill(SAYREYELLOW);
	editAdvisories.setFont(new Font("Consolas",20));
	editAdvisories.setStyle("-fx-background-color:rgb(0,46,125);");
	editAdvisories.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	editAdvisories.setOnMouseEntered(e-> {
		editAdvisories.setStyle("-fx-background-color: rgb(0,46,150);");
	});
	
	editAdvisories.setOnMouseExited(e-> {
		editAdvisories.setStyle("-fx-background-color: rgb(0,46,125);");
	});
	
	editAdvisories.setOnAction(e-> {
		primaryStage.setScene(editAdvisoriesScene);
		primaryStage.setFullScreen(true);
	});
	
	Button editLocations = new Button("Edit Locations");
	editLocations.setPrefWidth(200);
	editLocations.setPrefHeight(75);
	editLocations.setLayoutX(500);
	editLocations.setLayoutY(300);
	editLocations.setTextFill(SAYREYELLOW);
	editLocations.setFont(new Font("Consolas",20));
	editLocations.setStyle("-fx-background-color:rgb(0,46,125);");
	editLocations.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	editLocations.setOnMouseEntered(e-> {
		editLocations.setStyle("-fx-background-color: rgb(0,46,150);");
	});
	
	editLocations.setOnMouseExited(e-> {
		editLocations.setStyle("-fx-background-color: rgb(0,46,125);");
	});
	
	editLocations.setOnAction(e-> {
		primaryStage.setScene(editLocationsScene);
		primaryStage.setFullScreen(true);
	});
	
	settingsGroup.getChildren().addAll(backButton,backImageView,editAdvisories,editLocations);
	
	Label titleLabel = new Label("Sayre Advisory Assigning Program");
	titleLabel.setFont(Font.font("Consolas",FontWeight.BOLD,35));
	titleLabel.setTextFill(SAYREYELLOW);
	titleLabel.setLayoutX(450);
	titleLabel.setLayoutY(50);
	
	Rectangle menuRectangle = new Rectangle(0,0,400,800);
	menuRectangle.setFill(SAYREYELLOW);
	
	Image sayreImage = new Image("sayreIcon.png");
	ImageView sayreImageView = new ImageView(sayreImage);
	sayreImageView.setLayoutX(100);
	sayreImageView.setLayoutY(10);
	
	Image settingsImage = new Image("settingsIcon.png");
	ImageView settingsImageView = new ImageView(settingsImage);
	settingsImageView.setLayoutX(25);
	settingsImageView.setLayoutY(250);
	
	Image locationImage = new Image("locationsIcon.png");
	ImageView locationImageView = new ImageView(locationImage);
	locationImageView.setLayoutX(25);
	locationImageView.setLayoutY(325);
	
	Image profileImage = new Image("profileIcon.png");
	ImageView profileImageView = new ImageView(profileImage);
	profileImageView.setLayoutX(25);
	profileImageView.setLayoutY(400);
	
	Image helpImage = new Image("helpIcon.png");
	ImageView helpImageView = new ImageView(helpImage);
	helpImageView.setLayoutX(25);
	helpImageView.setLayoutY(475);
	
	Image infoImage = new Image("infoIcon.png");
	ImageView infoImageView = new ImageView(infoImage);
	infoImageView.setLayoutX(25);
	infoImageView.setLayoutY(550);
	
	Button settingsButton = new Button("Settings");
	settingsButton.setFont(new Font("Consolas",20));
	settingsButton.setStyle("-fx-background-color: rgb(0,46,150)");
	settingsButton.setPrefWidth(400);
	settingsButton.setPrefHeight(50);
	settingsButton.setLayoutY(250);
	settingsButton.setLayoutX(0);
	settingsButton.setTextFill(SAYREYELLOW);
	settingsButton.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	
	settingsButton.setOnMouseEntered(e-> {
		settingsButton.setStyle("-fx-background-color: rgb(0,46,100);");
	});
	
	settingsButton.setOnMouseExited(e-> {
		settingsButton.setStyle("-fx-background-color: rgb(0,46,150);");
	});
	
	settingsButton.setOnAction(e-> {
		primaryStage.setScene(settingsScene);
		primaryStage.setFullScreen(true);
	});
	
	Button locationsButton = new Button("Locations");
	locationsButton.setFont(new Font("Consolas",20));
	locationsButton.setStyle("-fx-background-color: rgb(0,46,150)");
	locationsButton.setPrefWidth(400);
	locationsButton.setPrefHeight(50);
	locationsButton.setLayoutY(325);
	locationsButton.setLayoutX(0);
	locationsButton.setTextFill(SAYREYELLOW);
	locationsButton.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	
	locationsButton.setOnMouseEntered(e-> {
		locationsButton.setStyle("-fx-background-color: rgb(0,46,100);");
	});
	
	locationsButton.setOnMouseExited(e-> {
		locationsButton.setStyle("-fx-background-color: rgb(0,46,150);");
	});
	
	locationsButton.setOnAction(e-> {
		primaryStage.setScene(locationsScene);
		primaryStage.setFullScreen(true);
	});
	
	Label locationLabel = new Label("Current Locations: ");
	locationLabel.setFont(new Font("Consolas",30));
	locationLabel.setTextFill(SAYREYELLOW);
	locationLabel.setLayoutX(50);
	locationLabel.setLayoutY(25);
	locationsScene.setFill(SAYREBLUE);
	
	VBox locationInfoVBox = new VBox();
	locationInfoVBox.setSpacing(10);
	locationInfoVBox.setLayoutX(50);
	locationInfoVBox.setLayoutY(75);
	
	VBox locationInfoVBoxTwo = new VBox();
	locationInfoVBoxTwo.setSpacing(10);
	locationInfoVBoxTwo.setLayoutX(350);
	locationInfoVBoxTwo.setLayoutY(75);
	
	Button backToHomeTwo = new Button("Back");
	backToHomeTwo.setPrefWidth(200);
	backToHomeTwo.setPrefHeight(75);
	backToHomeTwo.setLayoutX(50);
	backToHomeTwo.setLayoutY(500);
	backToHomeTwo.setFont(new Font("Consolas",25));
	backToHomeTwo.setTextFill(SAYREYELLOW);
	backToHomeTwo.setStyle("-fx-background-color: rgb(0,46,200);");
	backToHomeTwo.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	backToHomeTwo.setOnMouseEntered(e-> {
		backToHomeTwo.setStyle("-fx-background-color: rgb(0,46,125);");
	});
	
	backToHomeTwo.setOnMouseExited(e-> {
		backToHomeTwo.setStyle("-fx-background-color: rgb(0,46,150);");
	});
	
	backToHomeTwo.setOnAction(e-> {
		primaryStage.setScene(homeScene);
		primaryStage.setFullScreen(true);
	});
	
	Image backImageFive = new Image("backIcon.png");
	ImageView backImageViewFive = new ImageView(backImageFive);
	backImageViewFive.setLayoutX(50);
	backImageViewFive.setLayoutY(510);
	
	for(int i = 0;i<allData.locations.size();i++) {
		Label currentLabel = new Label(allData.locations.get(i).name + " : " + allData.locations.get(i).score);
		currentLabel.setFont(new Font("Consolas",15));
		currentLabel.setTextFill(SAYREYELLOW);
		if(i < 15) {
			locationInfoVBox.getChildren().add(currentLabel);
		} else {
			locationInfoVBoxTwo.getChildren().add(currentLabel);
		}
	}
	
	locationsGroup.getChildren().addAll(locationLabel,locationInfoVBox,locationInfoVBoxTwo,backToHomeTwo,
			backImageViewFive);
	
	Button advisoriesButton = new Button("Advisories");
	advisoriesButton.setFont(new Font("Consolas",20));
	advisoriesButton.setStyle("-fx-background-color: rgb(0,46,150)");
	advisoriesButton.setPrefWidth(400);
	advisoriesButton.setPrefHeight(50);
	advisoriesButton.setLayoutY(400);
	advisoriesButton.setLayoutX(0);
	advisoriesButton.setTextFill(SAYREYELLOW);
	advisoriesButton.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	advisoriesButton.setOnMouseEntered(e-> {
		advisoriesButton.setStyle("-fx-background-color: rgb(0,46,100);");
	});
	
	advisoriesButton.setOnMouseExited(e-> {
		advisoriesButton.setStyle("-fx-background-color: rgb(0,46,150);");
	});
	
	advisoriesButton.setOnAction(e-> {
		primaryStage.setScene(advisoriesScene);
		primaryStage.setFullScreen(true);
	});
	
	advisoriesScene.setFill(SAYREBLUE);
	
	Label advisories= new Label("Current Advisories: ");
	advisories.setFont(new Font("Consolas",30));
	advisories.setTextFill(SAYREYELLOW);
	advisories.setLayoutX(50);
	advisories.setLayoutY(25);
	advisories.setLayoutY(25);
	
	VBox advisoriesInfoVBox = new VBox();
	advisoriesInfoVBox.setSpacing(10);
	advisoriesInfoVBox.setLayoutX(50);
	advisoriesInfoVBox.setLayoutY(75);
	
	VBox advisoriesInfoVBoxTwo = new VBox();
	advisoriesInfoVBoxTwo.setSpacing(10);
	advisoriesInfoVBoxTwo.setLayoutX(200);
	advisoriesInfoVBoxTwo.setLayoutY(75);
	
	Button backToHome = new Button("Back");
	backToHome.setPrefWidth(200);
	backToHome.setPrefHeight(75);
	backToHome.setLayoutX(50);
	backToHome.setLayoutY(500);
	backToHome.setFont(new Font("Consolas",25));
	backToHome.setTextFill(SAYREYELLOW);
	backToHome.setStyle("-fx-background-color: rgb(0,46,200);");
	backToHome.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	backToHome.setOnMouseEntered(e-> {
		backToHome.setStyle("-fx-background-color: rgb(0,46,125);");
	});
	
	backToHome.setOnMouseExited(e-> {
		backToHome.setStyle("-fx-background-color: rgb(0,46,150);");
	});
	
	backToHome.setOnAction(e-> {
		primaryStage.setScene(homeScene);
		primaryStage.setFullScreen(true);
	});
	
	Image backImageFour = new Image("backIcon.png");
	ImageView backImageViewFour = new ImageView(backImageFour);
	backImageViewFour.setLayoutX(50);
	backImageViewFour.setLayoutY(510);
	
	for(int i = 0;i<allData.advisories.size();i++) {
		Label currentLabel = new Label(allData.advisories.get(i).name);
		currentLabel.setFont(new Font("Consolas",15));
		currentLabel.setTextFill(SAYREYELLOW);
		if(i < 15) {
			advisoriesInfoVBox.getChildren().add(currentLabel);
		} else {
			advisoriesInfoVBoxTwo.getChildren().add(currentLabel);
		}
	}
	
	advisoriesGroup.getChildren().addAll(advisories,advisoriesInfoVBox,advisoriesInfoVBoxTwo,backToHome,
			backImageViewFour);
	
	Button helpButton = new Button("Help");
	helpButton.setFont(new Font("Consolas",20));
	helpButton.setStyle("-fx-background-color: rgb(0,46,150)");
	helpButton.setPrefWidth(400);
	helpButton.setPrefHeight(50);
	helpButton.setLayoutY(475);
	helpButton.setLayoutX(0);
	helpButton.setTextFill(SAYREYELLOW);
	helpButton.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	
	helpButton.setOnMouseEntered(e-> {
		helpButton.setStyle("-fx-background-color: rgb(0,46,100);");
	});
	
	helpButton.setOnMouseExited(e-> {
		helpButton.setStyle("-fx-background-color: rgb(0,46,150);");
	});
	
	helpButton.setOnAction(e-> {
		primaryStage.setScene(helpScene);
		primaryStage.setFullScreen(true);
	});
	
	Button infoButton = new Button("Info");
	infoButton.setFont(new Font("Consolas",20));
	infoButton.setStyle("-fx-background-color: rgb(0,46,150)");
	infoButton.setPrefWidth(400);
	infoButton.setPrefHeight(50);
	infoButton.setLayoutY(550);
	infoButton.setLayoutX(0);
	infoButton.setTextFill(SAYREYELLOW);
	infoButton.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	
	infoButton.setOnMouseEntered(e-> {
		infoButton.setStyle("-fx-background-color: rgb(0,46,100);");
	});
	
	infoButton.setOnMouseExited(e-> {
		infoButton.setStyle("-fx-background-color: rgb(0,46,150);");
	});
	
	LocalDate today = LocalDate.now();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
	String date = formatter.format(today);
	Label dateToday = new Label("Date: " + date);
	dateToday.setFont(Font.font("Consolas",FontWeight.BOLD,30));
	dateToday.setTextFill(SAYREYELLOW);
	dateToday.setLayoutX(450);
	dateToday.setLayoutY(150);
	
	Label assignmentsLabel = new Label("Current Assignments:");
	assignmentsLabel.setFont(Font.font("Consolas",FontWeight.BOLD,25));
	assignmentsLabel.setTextFill(SAYREYELLOW);
	assignmentsLabel.setLayoutX(450);
	assignmentsLabel.setLayoutY(200);
	
	Button randomize = new Button("Randomize");
	randomize.setPrefWidth(150);
	randomize.setFont(new Font("Consolas",20));
	randomize.setLayoutX(dateToday.getLayoutX()+327);
	randomize.setLayoutY(dateToday.getLayoutY());
	randomize.setPrefHeight(50);
	randomize.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	Button save = new Button("Save");
	save.setPrefWidth(150);
	save.setFont(new Font("Consolas",20));
	save.setLayoutX(dateToday.getLayoutX()+475);
	save.setLayoutY(dateToday.getLayoutY());
	save.setPrefHeight(50);
	save.setBorder(new Border(new BorderStroke(Color.BLACK, 
            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	
	save.setOnAction(e-> {
		
        FileChooser fileChooser = new FileChooser();
        
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        
        File file = fileChooser.showSaveDialog(primaryStage);
        if(file == null) {
        	return;
        }
        String path = file.getAbsolutePath();
        allData.saveCSV(path);
	});
	
	randomize.setOnAction(e-> {
		allData.randomize();
		allData.save();
		allData.advisories.clear();
		allData.locations.clear();
		pairingsVBox.getChildren().clear();
		pairingsVBoxTwo.getChildren().clear();
		allData.getData();
		
		for(int i = 0;i<allData.advisories.size();i++) {
			int currentIndex = allData.advisories.get(i).locationIndex;
			String name = allData.advisories.get(i).name;
			String location = allData.locations.get(currentIndex).name;
			Label currentLabel = new Label(name + " : " + location);
			currentLabel.setFont(new Font("Consolas",15));
			currentLabel.setTextFill(SAYREYELLOW);
			if(i<15) {
				pairingsVBox.getChildren().add(currentLabel);
			} else {
				pairingsVBoxTwo.getChildren().add(currentLabel);
			}
		}
	});
	
	for(int i = 0;i<allData.advisories.size();i++) {
		int currentIndex = allData.advisories.get(i).locationIndex;
		String name = allData.advisories.get(i).name;
		String location = allData.locations.get(currentIndex).name;
		Label currentLabel = new Label(name + " : " + location);
		currentLabel.setFont(new Font("Consolas",15));
		currentLabel.setTextFill(SAYREYELLOW);
		if(i<15) {
			pairingsVBox.getChildren().add(currentLabel);
		} else {
			pairingsVBoxTwo.getChildren().add(currentLabel);
		}
	}
	
	root.getChildren().addAll(menuRectangle,titleLabel,settingsButton,locationsButton,advisoriesButton,helpButton,
			infoButton,settingsImageView,locationImageView,profileImageView,helpImageView,infoImageView,sayreImageView,
			assignmentsLabel,dateToday,pairingsVBox,pairingsVBoxTwo,randomize,save);
	primaryStage.show();
}

public static void main(String[] args) {
	launch(args);
	}
}
