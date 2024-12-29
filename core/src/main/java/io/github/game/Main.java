package io.github.game;

import com.badlogic.gdx.Game;

import io.github.game.Screens.GameScreen;

public class Main extends Game{
    @Override
	public void create() {
		setScreen(new GameScreen());
	}
	
}
