/* 
 * Name: Robert Elmore
 * Class: COSC 1174
 * Assignment: Poker1
 * Due Date: 11/7/2021
 */

package poker;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;



import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 
 * Create program Poker 2
 *
 */
public class Poker1 extends Application{

	private Card[] cards=new Card[5];//this defines the hand that is viewed
	
	private ArrayList<Integer> deckOfCards=new ArrayList<>();
	
	public static void main (String[] args) {
		launch(args);
	}

	@Override //start the primaty stage for the deck
	public void start(Stage primaryStage) throws Exception {
		for (int i=0; i<52; i++) {
			deckOfCards.add(i+1);
		}
		shuffle(deckOfCards);//shuffle the deck of cards
		
		//create card layout box
		HBox cardLayoutBox= createCardLayoutBox();
		Scene scene=new Scene(cardLayoutBox);
		primaryStage.setTitle("Poker");
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	
	public HBox createCardLayoutBox() { //create card layout box horizontally
		
		for (int i=0; i<5; i++) {
			cards[i]=new Card(deckOfCards.get(i));
			
		}
		HBox cardLayoutBox=new HBox();
		cardLayoutBox.setSpacing(5);
		
		for (int i=0; i<5; i++) {
			cardLayoutBox.getChildren().add(cards[i]);
		}
		
		return cardLayoutBox;
	}
	
	/*Generic method to randomize a list in Java*/
    public static <T> void shuffle(ArrayList<T> list) {
            Random random = new Random();
            int n = list.size();

            /*start from the beginning of the list*/
            for (int i = 0; i < n - 1; i++) {
                    /*get a random index `j` such that `i <= j <= n`*/
                    int j = i + random.nextInt(n - i);

                    /*swap element at i'th position in the list with the element at*/
                    /*randomly generated index `j`*/
                    T obj = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, obj);
            }
    }
	//card image vertically
	public class Card extends VBox {
		private Image cardImage;
		private ImageView cardImageView=new ImageView();
		private int cardNumber=0;
		
		//select the card number randomly
		public Card(int cardNumber) {
			this.cardNumber=cardNumber;
			String fileName = cardNumber + ".png";
			String fullFileName = "file:" + System.getProperty("user.dir") + 
					File.separator + "card" + File.separator +  fileName;
			cardImage=new Image(fullFileName);
			cardImageView.setImage(cardImage);
			getChildren().add(cardImageView);
			
		}

		//getters and setters for card image and card numbers
		public Image getCardImage() {
			return cardImage;
		}


		public void setCardImage(Image cardImage) {
			this.cardImage = cardImage;
		}


		public ImageView getCardImageView() {
			return cardImageView;
		}


		public void setCardImageView(ImageView cardImageView) {
			this.cardImageView = cardImageView;
		}


		public int getCardNumber() {
			return cardNumber;
		}


		public void setCardNumber(int cardNumber) {
			this.cardNumber = cardNumber;
		}
		
		
	}
	
	
}



