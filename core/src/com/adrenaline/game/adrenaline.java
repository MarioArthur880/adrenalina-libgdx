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
    private Sprite player;
    private float posX, posY, velocidadeX, deltaTime, gravidade, forcaPulo, velocidadeY;
    private boolean noChao;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("fundo.jpg");
        tPlayer = new Texture("personagem.gif");
        player = new Sprite(tPlayer);
        player.setSize(tPlayer.getWidth() / 4f, tPlayer.getHeight() / 4f); 

  


        posX = 0;

        posY = getChaoY();

        velocidadeX = 400;
        velocidadeY = 0;
        gravidade = -1600;
        forcaPulo = 600;
        noChao = true;
    }

    @Override
    public void render() {

        deltaTime = Gdx.graphics.getDeltaTime();

 
        moviPlayer();


        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        batch.draw(img, 0, 0);
        player.setPosition(posX, posY);
        player.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        tPlayer.dispose();
    }
    
    private float getChaoY() {
        return 100;
    }

    private void moviPlayer() {
        boolean moveu = false;

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            posX += velocidadeX * deltaTime;

            if (player.isFlipX()) {
                player.flip(true, false);
            }

            moveu = true;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A) && posX > 0) {
            posX -= velocidadeX * deltaTime;

            if (!player.isFlipX()) {
                player.flip(true, false);
            }

            moveu = true;
        }


        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && noChao) {
            velocidadeY = forcaPulo;
            noChao = false;
        }


        velocidadeY += gravidade * deltaTime;
        posY += velocidadeY * deltaTime;


        if (posY <= getChaoY()) {
            posY = getChaoY();
            velocidadeY = 0;
            noChao = true;
        }
    }

}

