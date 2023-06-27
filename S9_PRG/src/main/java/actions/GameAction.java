package actions;

import java.sql.Connection;

import com.opensymphony.xwork2.ActionSupport;

import cardgame.Game;
import cardgame.Game.HigherOrLower;
import data.Database;
import freemarker.log.Logger;

public class GameAction extends ActionSupport {
	
	private Logger log = Logger.getLogger(GameAction.class.getName());
	private static Game game;
	private Database db = Database.getinstance();
	private Connection conn = db.getConnection();
	
	public String higher() {
		
		log.info("Current card: " + game.getCurrentCard() + ", next card: " + game.getNextCard());
		
		if (!game.gameTurn(HigherOrLower.HIGHER))
			return "gameover";
		
		log.info("\nUser selected HIGHER, new score: " + game.getScore() + "!");
		return SUCCESS;
	}
	
	public String lower() {
		
		log.info("Current card: " + game.getCurrentCard() + ", next card: " + game.getNextCard());
		
		if (!game.gameTurn(HigherOrLower.LOWER))
			return "gameover";
		
		log.info("\nUser selected LOWER, new score: " + game.getScore() + "!");
		return SUCCESS;
	}
	
	public String setup() {
		game = new Game();
		game.setup();
		db.maakDB(conn);
		db.maakTabel(conn);
		return SUCCESS;
	}
	
	public static Game getGame() {
		return game;
	}

}
