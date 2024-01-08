package model;

import model.types.BotDifficultyLevel;
import model.types.PlayerType;

public class Bot extends Player{
    BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, Symbol symbol, PlayerType playerType) {
        super(name, symbol, playerType);
    }

    public BotDifficultyLevel getBotDifficultyLevel(){
        return this.botDifficultyLevel;
    }
}
