package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Connexion extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Page de Connexion");

        // CrÃƒÂ©er un SplitPane pour sÃƒÂ©parer les sections de connexion et de crÃƒÂ©ation de compte
        SplitPane splitPane = new SplitPane();
        splitPane.setDividerPositions(0.5);

        // CrÃƒÂ©er des GridPanes pour les sections de connexion et de crÃƒÂ©ation de compte
        GridPane panneauConnexion = creerPanneauConnexion();
        GridPane panneauCreerCompte = creerPanneauCreerCompte();

        // Ajouter les GridPanes au SplitPane
        splitPane.getItems().addAll(panneauConnexion, panneauCreerCompte);

        // StackPane pour centrer le SplitPane
        StackPane root = new StackPane(splitPane);

        Scene scene = new Scene(root, 1000, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private GridPane creerPanneauConnexion() {
        GridPane panneauConnexion = new GridPane();
        panneauConnexion.setStyle("-fx-background-color: #135a48;"); // Vert foncé
        panneauConnexion.setHgap(20);
        panneauConnexion.setVgap(10);
        panneauConnexion.setPadding(new Insets(20, 20, 20, 20));

        // Ajouter des contraintes de colonne pour contrÃƒÂ´ler la largeur des colonnes
        ColumnConstraints colonne1 = new ColumnConstraints();
        colonne1.setPercentWidth(50);
        ColumnConstraints colonne2 = new ColumnConstraints();
        colonne2.setPercentWidth(50);
        panneauConnexion.getColumnConstraints().addAll(colonne1, colonne2);

        Label labelConnexion = new Label("Connexion");
        labelConnexion.setFont(Font.font(20));
        panneauConnexion.add(labelConnexion, 0, 0, 2, 1); // ÃƒÂ©tendre sur 2 colonnes

        Label labelEmail = new Label("Email :");
        TextField champEmail = new TextField();
        champEmail.setPromptText("Entrez votre email");
        panneauConnexion.add(labelEmail, 0, 1);
        panneauConnexion.add(champEmail, 1, 1);

        Label labelMotDePasse = new Label("Mot de passe :");
        PasswordField champMotDePasse = new PasswordField();
        champMotDePasse.setPromptText("Entrez votre mot de passe");
        panneauConnexion.add(labelMotDePasse, 0, 2);
        panneauConnexion.add(champMotDePasse, 1, 2);

        Button boutonConnexion = new Button("Connexion");
        panneauConnexion.add(boutonConnexion, 1, 3);
        
        // Configurer les styles des composants
        labelConnexion.setStyle("-fx-text-fill: white; -fx-font-style: italic;");
        labelEmail.setStyle("-fx-text-fill: white; -fx-font-style: italic;");
        labelMotDePasse.setStyle("-fx-text-fill: white; -fx-font-style: italic;");


        return panneauConnexion;
    }

    private GridPane creerPanneauCreerCompte() {
        GridPane panneauCreerCompte = new GridPane();
        panneauCreerCompte.setStyle("-fx-background-color: #135a48;"); // Vert foncé
        panneauCreerCompte.setHgap(20);
        panneauCreerCompte.setVgap(10);
        panneauCreerCompte.setPadding(new Insets(20, 20, 20, 20));

        // Ajouter des contraintes de colonne pour controler la largeur des colonnes
        ColumnConstraints colonne1 = new ColumnConstraints();
        colonne1.setPercentWidth(50);
        ColumnConstraints colonne2 = new ColumnConstraints();
        colonne2.setPercentWidth(50);
        panneauCreerCompte.getColumnConstraints().addAll(colonne1, colonne2);

        // Titre du panneau
        Label creerCompteLabel = new Label("Creer un Compte");
        creerCompteLabel.setFont(Font.font(20));
        panneauCreerCompte.add(creerCompteLabel, 0, 0, 2, 1); // Span 2 columns

        // Section email
        Label labelNouvelEmail = new Label("Nouvel Email :");
        TextField champNouvelEmail = new TextField();
        champNouvelEmail.setPromptText("Entrez votre nouvel email");
        panneauCreerCompte.add(labelNouvelEmail, 0, 1);
        panneauCreerCompte.add(champNouvelEmail, 1, 1);

        // Section mot de passe
        Label labelNouveauMotDePasse = new Label("Nouveau Mot de passe :");
        PasswordField champNouveauMotDePasse = new PasswordField();
        champNouveauMotDePasse.setPromptText("Entrez votre nouveau mot de passe");
        panneauCreerCompte.add(labelNouveauMotDePasse, 0, 2);
        panneauCreerCompte.add(champNouveauMotDePasse, 1, 2);

        // Bouton de création de compte
        Button boutonCreerCompte = new Button("Creer un Compte");
        panneauCreerCompte.add(boutonCreerCompte, 1, 3);

        // Description de FranceConnect
        Label franceConnectDescription = new Label("FranceConnect est la solution proposée par l'État pour sécuriser et simplifier la connexion à vos services en ligne.");
        franceConnectDescription.setWrapText(true);
        panneauCreerCompte.add(franceConnectDescription, 0, 4, 2, 1); // Span 2 columns

        // Bouton FranceConnect avec image
        Button franceConnectButton = new Button();      
        Image franceConnectImage = new Image(getClass().getResourceAsStream("/images/FranceConnect-Logo.png"));
        franceConnectButton.setGraphic(new ImageView(franceConnectImage));
        franceConnectButton.setOnAction(event -> {
            // Ouvrir l'URL de FranceConnect
            getHostServices().showDocument("https://app.franceconnect.gouv.fr/api/v1/authorize?...");
        });
        
        panneauCreerCompte.add(franceConnectButton, 1, 5);

        // Lien hypertexte pour plus d'informations
        Hyperlink franceConnectInfoLink = new Hyperlink("Qu'est-ce que c'est FranceConnect");
        franceConnectInfoLink.setOnAction(event -> {
            getHostServices().showDocument("https://franceconnect.gouv.fr/");
        });
        panneauCreerCompte.add(franceConnectInfoLink, 1, 6);
        
        
        // Configurer les styles des composants
        creerCompteLabel.setStyle("-fx-text-fill: white; -fx-font-style: italic;");
        labelNouvelEmail.setStyle("-fx-text-fill: white; -fx-font-style: italic;");
        labelNouveauMotDePasse.setStyle("-fx-text-fill: white; -fx-font-style: italic;");
        franceConnectDescription.setStyle("-fx-text-fill: white; -fx-font-style: italic;");
        franceConnectInfoLink.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");


        return panneauCreerCompte;
    }

    

    public static void main(String[] args) {
        launch(args);
    }
}
