package com.adrenaline.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class adrenaline extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, tPlayer;
	private Sprite player ;
	private float posX, posY;
	
	@Override
	public void create () {
		
		batch = new SpriteBatch();
		img = new Texture("fundo.jpg");
		tPlayer = new Texture("personagem.png");
		player = new Sprite(tPlayer);
		posX = 0;
		posY = 100;
		
	}

	@Override
	public void render () {
		
		this.moviPlayer();
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.draw(player, posX, posY);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
		tPlayer.dispose();
		
	}
	
	private void moviPlayer() {
	
		if(Gdx.input.isKeyPressed(Input.Keys.D)) {
			
			posX += 10;
			
		}
		
       if(Gdx.input.isKeyPressed(Input.Keys.A) && posX > 0) {
			
			posX -= 10;
			
		}
       
       if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && posY < 200) {
			
    	   posY += 10;
			
			
		}
		
		
		
	}
	
}
