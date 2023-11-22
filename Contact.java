package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Contact extends Application{

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Page de Connexion");

		// Création des panneaux
		GridPane panneauIdentite = creerPanneauIdentite();
		GridPane panneauEtudiant = creerPanneauEtudiant();
		GridPane panneauMessage = creerPanneauMessage(primaryStage);

		// Création du VBox
		VBox vbox = new VBox();
		vbox.getChildren().addAll(panneauIdentite, panneauEtudiant, panneauMessage);

		// Configuration du VBox (espacement, padding, etc.)
		vbox.setSpacing(10); // Espacement entre les éléments
		vbox.setPadding(new Insets(10, 10, 10, 10)); // Padding autour du VBox

		// Création et configuration du ScrollPane
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setContent(vbox);
		scrollPane.setFitToWidth(true);
		scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

		// Ajout du ScrollPane à la scène ou à la fenêtre principale
		Scene scene = new Scene(scrollPane, 800, 600); // Ajuste la taille selon tes besoins
		primaryStage.setScene(scene);
		primaryStage.show();

;
	}
	
	private GridPane creerPanneauIdentite() {
		GridPane panneauIdentite = new GridPane();
	    panneauIdentite.setStyle("-fx-background-color: #135a48;"); // Vert foncé
	    panneauIdentite.setHgap(20);
	    panneauIdentite.setVgap(10);
	    panneauIdentite.setPadding(new Insets(20, 20, 20, 20));

	    // Configuration des colonnes
	    ColumnConstraints colonne1 = new ColumnConstraints();
	    colonne1.setPercentWidth(50);
	    ColumnConstraints colonne2 = new ColumnConstraints();
	    colonne2.setPercentWidth(50);
	    panneauIdentite.getColumnConstraints().addAll(colonne1, colonne2);
		
		 // Checkbox pour compte existant
		 CheckBox checkBoxCompte = new CheckBox("J'ai déjà un compte");
		 panneauIdentite.add(checkBoxCompte, 0, 0, 2, 1); // Étendu sur 2 colonnes
		
		 // Label "Etudiant" - à supprimer si pas nécessaire
		 Label labelContact = new Label("Contact");
		 labelContact.setFont(Font.font(20));
		 panneauIdentite.add(labelContact, 0, 1, 2, 1); // Étendu sur 2 colonnes
		
		 // Champs pour le Nom
		 Label labelNom = new Label("Nom :");
		 TextField champNom = new TextField();
		 champNom.setPromptText("Entrez votre Nom");
		 panneauIdentite.add(labelNom, 0, 2);
		 panneauIdentite.add(champNom, 1, 2);
		
		 // Champs pour le Prénom
		 Label labelPrenom = new Label("Prénom :");
		 TextField champPrenom = new TextField();
		 champPrenom.setPromptText("Entrez votre Prénom");
		 panneauIdentite.add(labelPrenom, 0, 3);
		 panneauIdentite.add(champPrenom, 1, 3);
		
		 // Champs pour l'Email
		 Label labelEmail = new Label("Email :");
		 TextField champEmail = new TextField();
		 champEmail.setPromptText("Entrez votre email");
		 panneauIdentite.add(labelEmail, 0, 4);
		 panneauIdentite.add(champEmail, 1, 4);
		
		 // Champs pour le Téléphone
		 Label labelTel = new Label("Téléphone :");
		 TextField champTel = new TextField();
		 champTel.setPromptText("Entrez votre numéro de téléphone 0X XX XX XX XX");
		 panneauIdentite.add(labelTel, 0, 5);
		 panneauIdentite.add(champTel, 1, 5);
		
		 // Utilisation d'un DatePicker pour la date de naissance
		 Label labelDate = new Label("Date de naissance :");
		 DatePicker champDate = new DatePicker();
		 champDate.setPromptText("JJ/MM/AAAA");
		 panneauIdentite.add(labelDate, 0, 6);
		 panneauIdentite.add(champDate, 1, 6);
		
        // Application du style
        appliquerStyle(labelDate, "white", "italic");
        appliquerStyle(labelContact, "white", "italic");
        appliquerStyle(labelNom, "white", "italic");
        appliquerStyle(labelPrenom, "white", "italic");
        appliquerStyle(labelEmail, "white", "italic");
        appliquerStyle(labelTel, "white", "italic");


        return panneauIdentite;
    }

    private void appliquerStyle(Label label, String textColor, String fontStyle) {
        label.setStyle("-fx-text-fill: " + textColor + "; -fx-font-style: " + fontStyle + ";");
    }
	
	private GridPane creerPanneauEtudiant() {
		GridPane panneauEtudiant = new GridPane();
		panneauEtudiant.setStyle("-fx-background-color: #135a48;"); // Vert foncé
		panneauEtudiant.setHgap(20);
		panneauEtudiant.setVgap(10);
		panneauEtudiant.setPadding(new Insets(20, 20, 20, 20));

	    // Configuration des colonnes
	    ColumnConstraints colonne1 = new ColumnConstraints();
	    colonne1.setPercentWidth(50);
	    ColumnConstraints colonne2 = new ColumnConstraints();
	    colonne2.setPercentWidth(50);
	    panneauEtudiant.getColumnConstraints().addAll(colonne1, colonne2);
	    
 		// Texte explicatif sur le numéro INE ou BEA
 		Label labelExplicationINE = new Label("Le numéro INE (Identification Nationale Etudiant) ou BEA figure sur votre carte d’étudiant, sur le relevé de notes du baccalauréat, ou sur l’imprimé de confirmation d’inscription au baccalauréat.");
 		labelExplicationINE.setWrapText(true); // Pour s'assurer que le texte s'enroule correctement
 		panneauEtudiant.add(labelExplicationINE, 0, 8, 2, 1); // Étendu sur 2 colonnes

 		// Champ de texte pour le numéro INE
 		Label labelINE = new Label("Numéro INE :");
 		TextField champINE = new TextField();
 		champINE.setPromptText("Entrez votre numéro INE");
 		panneauEtudiant.add(labelINE, 0, 9);
 		panneauEtudiant.add(champINE, 1, 9);
 		
        appliquerStyle(labelExplicationINE, "white", "italic");
        appliquerStyle(labelINE, "white", "italic");
	    
        
		return panneauEtudiant;
	}
	
	private GridPane creerPanneauMessage(Stage stage) {
		GridPane PanneauMessage = new GridPane();
		PanneauMessage.setStyle("-fx-background-color: #135a48;"); // Vert foncé
		PanneauMessage.setHgap(20);
		PanneauMessage.setVgap(10);
		PanneauMessage.setPadding(new Insets(20, 20, 20, 20));

	    // Configuration des colonnes
	    ColumnConstraints colonne1 = new ColumnConstraints();
	    colonne1.setPercentWidth(50);
	    ColumnConstraints colonne2 = new ColumnConstraints();
	    colonne2.setPercentWidth(50);
	    PanneauMessage.getColumnConstraints().addAll(colonne1, colonne2);
		
		// Titre de la section Message
		Label labelSectionMessage = new Label("Message");
		labelSectionMessage.setFont(Font.font(20));
		PanneauMessage.add(labelSectionMessage, 0, 10, 2, 1); // Étendu sur 2 colonnes

		// Catégorie du message
		Label labelCategorie = new Label("Catégorie :");
		ComboBox<String> comboBoxCategorie = new ComboBox<>();
		comboBoxCategorie.getItems().addAll("Contribution Vie Etudiante", "Bourse", "Autres Aides", "Logement", "DSE", "Compte messervices.etudiant.gouv.fr", "Autres");
		PanneauMessage.add(labelCategorie, 0, 11);
		PanneauMessage.add(comboBoxCategorie, 1, 11);

		// Le Crous
		Label labelCrous = new Label("Le Crous :");
		ComboBox<String> comboBoxCrous = new ComboBox<>();
		comboBoxCrous.getItems().addAll(/* Liste des Crous */);
		PanneauMessage.add(labelCrous, 0, 12);
		PanneauMessage.add(comboBoxCrous, 1, 12);

		// Thème, Sujet et Message
		Label labelTheme = new Label("Thème :");
		TextField champTheme = new TextField();
		PanneauMessage.add(labelTheme, 0, 13);
		PanneauMessage.add(champTheme, 1, 13);

		Label labelSujet = new Label("Sujet :");
		TextField champSujet = new TextField();
		PanneauMessage.add(labelSujet, 0, 14);
		PanneauMessage.add(champSujet, 1, 14);

		Label labelMessage = new Label("Votre Message :");
		TextArea champMessage = new TextArea();
		champMessage.setPromptText("Tapez votre message ici");
		PanneauMessage.add(labelMessage, 0, 15);
		PanneauMessage.add(champMessage, 1, 15);

		// Bouton pour l'ajout de pièce jointe
		Button boutonPieceJointe = new Button("Ajouter une pièce jointe");
		PanneauMessage.add(boutonPieceJointe, 1, 16);

		// Bouton d'envoi
		Button boutonEnvoi = new Button("Envoyer");
		boutonEnvoi.setOnAction(e -> {
		    	stage.close() ;
		});
		PanneauMessage.add(boutonEnvoi, 1, 17);
		
		appliquerStyle(labelSectionMessage, "white", "italic");
        appliquerStyle(labelCategorie, "white", "italic");
        appliquerStyle(labelCrous, "white", "italic");
        appliquerStyle(labelTheme, "white", "italic");
        appliquerStyle(labelSujet, "white", "italic");
        appliquerStyle(labelMessage, "white", "italic");
				
				
		return PanneauMessage;
	}
	
	public static void main(String[] args) {
        launch(args);
    }

}
