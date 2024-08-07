package factories;

import models.BotDifficultyLevel;
import strategies.botplayerstrategy.BotPlayingStrategy;
import strategies.botplayerstrategy.EasyBoatPlayingStrategy;
import strategies.botplayerstrategy.HardPlayingStrategy;
import strategies.botplayerstrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategyFactory(BotDifficultyLevel botDifficultyLevel){

        if(botDifficultyLevel.equals(BotDifficultyLevel.EASY)) return new EasyBoatPlayingStrategy();

        else if(botDifficultyLevel.equals(BotDifficultyLevel.MEDIUM)) return new MediumBotPlayingStrategy();

        else return new HardPlayingStrategy();

    }
}
