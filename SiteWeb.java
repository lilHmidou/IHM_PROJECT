package application;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class SiteWeb extends Application {
	
	private HostServices hostServices;

    @Override
    public void init() {
        hostServices = getHostServices();
    }

	@Override
	public void start(Stage primaryStage) {

		// Charger l'image pour le haut du site
		Image topImage = new Image(getClass().getResourceAsStream("/images/iconeTitre.jpg"));
		ImageView topImageView = new ImageView(topImage);
		topImageView.setPreserveRatio(true);
		topImageView.setFitWidth(500); // Ajustez la largeur comme nÃ©cessaire

		// CrÃ©er un HBox pour centrer l'ImageView
		HBox imageContainer = new HBox(topImageView);
		imageContainer.setAlignment(Pos.CENTER); // Centrer l'image dans l'HBox

		ImageView imageViewDSE = createImageView("/images/imageDSE.png");
		ImageView imageViewParcoursup = createImageView("/images/imageParcoursup.png");
		ImageView imageViewHome = createImageView("/images/houseIcon.png");
		ImageView imageViewParticulier = createImageView("/images/imageParticulier.png");
		ImageView menuIcon = createImageView("/images/Menuicon.svg.png");
		ImageView profileIcone = createImageView("/images/ProfileIcone.png");

		TextFlow DSE = createTextFlow("Votre DSE", "https://fr.wikipedia.org/wiki/Aymeric");
		TextFlow Parcoursup = createTextFlow("Vos Etudes", "https://amp.etudiant.gouv.fr/");
		TextFlow Loger = createTextFlow("Vous loger", "https://www.lokaviz.fr/");

		HBox DSEBox = new HBox(10);
		DSEBox.setAlignment(Pos.CENTER); // Centre les Ã©lÃ©ments verticalement dans la HBox
		DSEBox.getChildren().addAll(imageViewDSE, DSE);
		HBox.setMargin(DSE, new Insets(25, 0, 0, 0));

		HBox ParcourSupBox = new HBox(10);
		ParcourSupBox.setAlignment(Pos.CENTER);
		ParcourSupBox.getChildren().addAll(imageViewParcoursup, Parcoursup);
		HBox.setMargin(Parcoursup, new Insets(25, 0, 0, 0));

		HBox LogerBox = new HBox(10);
		LogerBox.setAlignment(Pos.CENTER);
		LogerBox.getChildren().addAll(imageViewParticulier, Loger);
		HBox.setMargin(Loger, new Insets(25, 0, 0, 0));

		HBox HomeConnexion = new HBox(10);
		HomeConnexion.setAlignment(Pos.CENTER);

		Connexion connexion = new Connexion();

		Button btnProfil = new Button("", profileIcone);
		btnProfil.setStyle(
				"-fx-background-color: transparent; -fx-padding: 0; -fx-border-width: 0; -fx-border-color: transparent;");
		// Configurez l'action du bouton pour afficher la fenÃªtre de connexion
		btnProfil.setOnAction(e -> {
			try {
				connexion.start(new Stage());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// CrÃ©ez un HBox pour contenir les Ã©lÃ©ments

		HomeConnexion.getChildren().addAll(btnProfil, imageViewHome);

		HBox menuHBox = new HBox(100); // 10 est l'espacement entre les Ã©lÃ©ments
		menuHBox.getChildren().addAll(menuIcon, DSEBox, ParcourSupBox, LogerBox, HomeConnexion);

		// DÃ©finissez la couleur de fond et faites en sorte que le HBox prenne toute la
		// largeur de la scÃ¨ne
		menuHBox.setStyle("-fx-background-color: #1c856a;");
		menuHBox.setAlignment(Pos.CENTER);
		menuHBox.setPrefHeight(70); // DÃ©finissez la hauteur prÃ©fÃ©rÃ©e ou ajustez-la selon vos besoins

		// CrÃ©ez l'image de fond
		ImageView backgroundImageView = new ImageView(
				new Image(getClass().getResourceAsStream("/images/fontstyle.jpeg")));

		// CrÃ©ez un effet d'ajustement de couleur pour assombrir l'image
		ColorAdjust colorAdjust = new ColorAdjust();
		colorAdjust.setBrightness(-0.5); // RÃ©glez cette valeur entre -1.0 (noir) et 0.0 (image originale)

		// Appliquez l'effet d'ajustement de couleur Ã  l'ImageView
		backgroundImageView.setEffect(colorAdjust);

		// Liez la largeur de l'image Ã  la largeur de la scÃ¨ne
		backgroundImageView.fitWidthProperty().bind(primaryStage.widthProperty());
		
		backgroundImageView.setFitHeight(400);
		backgroundImageView.setPreserveRatio(false);

		// CrÃ©ez la barre de recherche avec un style transparent
		TextField searchField = new TextField();
		searchField.setPromptText("Dossier social Etudiant, logement...");
		searchField.setPrefWidth(800); // Largeur de la barre de recherche
		searchField.setPrefHeight(40); // Hauteur de la barre de recherche, ajustez selon vos besoins

		// Style pour arrondir les coins de la barre de recherche
		searchField.setStyle("-fx-background-radius: 20; -fx-border-radius: 20;-fx-border-color: #272953; -fx-border-width: 3px; -fx-padding: 4px;");

		// Bouton de recherche
		Button searchButton = new Button("🔍");
		searchButton.setStyle("-fx-background-radius: 20; -fx-border-radius: 20;");
		searchButton.setPrefWidth(40); // Largeur de la barre de recherche
		searchButton.setPrefHeight(40); // Hauteur de la barre de recherche, ajustez selon vos besoins

		// Placez la barre de recherche et le bouton dans une HBox avec un style de fond
		// appropriÃ©
		HBox searchBox = new HBox(searchField, searchButton);
		searchBox.setAlignment(Pos.CENTER); // Centrez la HBox horizontalement

		// Utilisez un StackPane pour superposer la barre de recherche sur l'image
		StackPane stackPane = new StackPane();
		stackPane.getChildren().addAll(backgroundImageView, searchBox);

		// Positionnez la barre de recherche sur l'image
		StackPane.setAlignment(searchBox, Pos.BOTTOM_CENTER); // Placez la HBox au centre en bas de la StackPane
		StackPane.setMargin(searchBox, new Insets(0, 0, 20, 0)); // Ajustez la marge du bas pour dÃ©placer la barre de

		 // CrÃ©ez une rÃ©gion verte pour la barre de transition
	    Region greenBar = new Region();
	    greenBar.setStyle("-fx-background-color: #135a48;"); // Utilisez le code hexadÃ©cimal de la couleur verte que vous souhaitez
	    greenBar.setPrefHeight(50); // RÃ©glez la hauteur de la barre de transition
		
	   
	    // Création des ImageView
	    ImageView imageViewAider = createImageView("/images/jeVeuxAider.png");
	    ImageView imageViewErasmus = createImageView("/images/erasmus.png");
	    ImageView imageViewAssurance = createImageView("/images/assuranceMaladie.png");
	    
	    // Taille uniforme pour toutes les images
	    double width = 200; // Largeur souhaitée
	    double height = 100; // Hauteur souhaitée

	    // Assurez-vous de définir ces dimensions pour chaque ImageView
	    imageViewAider.setFitWidth(width);
	    imageViewAider.setFitHeight(height);
	    imageViewErasmus.setFitWidth(width);
	    imageViewErasmus.setFitHeight(height);
	    imageViewAssurance.setFitWidth(width);
	    imageViewAssurance.setFitHeight(height);

	    // Création du texte "En Savoir Plus"
	    TextFlow textAider = createTextFlowButton("En Savoir Plus", "https://www.jeveuxaider.gouv.fr/...");
	    TextFlow textErasmus = createTextFlowButton("En Savoir Plus", "https://agence.erasmusplus.fr/...");
	    TextFlow textAssurance = createTextFlowButton("En Savoir Plus", "https://assure.ameli.fr/...");

	    // Création des VBox pour grouper les images et les textes
	    VBox vboxAider = new VBox(imageViewAider, textAider);
	    VBox vboxErasmus = new VBox(imageViewErasmus, textErasmus);
	    VBox vboxAssurance = new VBox(imageViewAssurance, textAssurance);

	    // Ajout d'espacement et d'alignement
	    vboxAider.setSpacing(5);
	    vboxErasmus.setSpacing(5);
	    vboxAssurance.setSpacing(5);
	    vboxAider.setAlignment(Pos.CENTER);
	    vboxErasmus.setAlignment(Pos.CENTER);
	    vboxAssurance.setAlignment(Pos.CENTER);

	    // Création d'un HBox pour aligner les VBox
	    HBox hbox = new HBox(vboxAider, vboxErasmus, vboxAssurance);
	    hbox.setAlignment(Pos.CENTER);
	    hbox.setSpacing(200); // Ajuster l'espacement selon le besoin
		
		// CrÃ©er un BorderPane comme layout principal
		BorderPane borderPane = new BorderPane();
		// Ajouter le HBox au BorderPane principal
	    borderPane.setBottom(hbox);

		// Empiler l'image et la barre verte en utilisant un StackPane ou un VBox
		VBox topSection = new VBox(imageContainer, menuHBox, stackPane, greenBar);

		// Ajouter la section supÃ©rieure et la barre de navigation au BorderPane
		borderPane.setTop(topSection); // Si vous voulez la navigation au centre
		borderPane.setBottom(hbox);

		// CrÃ©er la scÃ¨ne et y ajouter le BorderPane
		Scene scene = new Scene(borderPane);
		scene.getRoot().setStyle("-fx-background-color: #FFFFFF;"); // Remplacez #FFFFFF par votre couleur de fond

		// Faire en sorte que la fenÃªtre occupe tout l'Ã©cran
		primaryStage.setMaximized(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	

	private ImageView createImageView(String imagePath) {
		ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
		imageView.setFitHeight(50);
		// imageView.setPreserveRatio(false); // Allow the width to change
		imageView.setFitWidth(50); // Set the desired width
		return imageView;
	}
	
	

	private TextFlow createTextFlow(String buttonText, String url) {

		Text btnText = new Text(buttonText);

		btnText.setFont(Font.font("Arial", FontWeight.BOLD, 24)); // Ajustez la police et la taille selon vos besoins
		btnText.setFill(Color.WHITE); // DÃ©finissez la couleur du texte

		// Ajoutez un gestionnaire d'Ã©vÃ©nements pour souligner le texte lors du survol
		// de la souris
		btnText.setOnMouseEntered(event -> btnText.setUnderline(true));
		btnText.setOnMouseExited(event -> btnText.setUnderline(false));

		// Set the mouse click event on the Text element
		btnText.setOnMouseClicked(event -> getHostServices().showDocument(url));

		TextFlow textFlow = new TextFlow(btnText);
		textFlow.setTextAlignment(TextAlignment.CENTER);

		return textFlow;
	}
	
	private TextFlow createTextFlowButton(String buttonText, String url) {

		Text btnText = new Text(buttonText);

		// Définir la police en italique et de taille normale
		btnText.setFont(Font.font("Arial", FontPosture.ITALIC, 11)); // Remplacez "Arial" par la famille de police souhaitée
		btnText.setFill(Color.BLACK); // Couleur du texte en vert


		// Ajoutez un gestionnaire d'Ã©vÃ©nements pour souligner le texte lors du survol
		// de la souris
		btnText.setOnMouseEntered(event -> btnText.setUnderline(true));
		btnText.setOnMouseExited(event -> btnText.setUnderline(false));

		// Set the mouse click event on the Text element
		btnText.setOnMouseClicked(event -> getHostServices().showDocument(url));

		TextFlow textFlow = new TextFlow(btnText);
		textFlow.setTextAlignment(TextAlignment.CENTER);

		return textFlow;
	}


	public static void main(String[] args) {
		launch(args);
	}
}