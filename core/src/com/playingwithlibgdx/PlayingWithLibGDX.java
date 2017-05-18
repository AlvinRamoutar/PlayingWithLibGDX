package com.playingwithlibgdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class PlayingWithLibGDX extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	
	private float rot;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("pika.jpg");
		
		TextureRegion tr = new TextureRegion(img, 0, 0, 274, 275);
		sprite = new Sprite(tr);
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		//Drawing directly to batch.
		//batch.draw(img, Gdx.graphics.getWidth()/2 - img.getWidth(), Gdx.graphics.getHeight()/2 - img.getHeight());
		
		//Slowly rotate sprite @DPS degrees per second using @Gdx.graphics.getDeltaTime()
		sprite.draw(batch);
		final float DPS = 10.0f;
		rot = (rot + Gdx.graphics.getDeltaTime() * DPS) % 360;
		
		//Shake effect
		final float SHAKE_AMPLITUDE_D = 5.0f;
		float shake = MathUtils.sin(rot) * SHAKE_AMPLITUDE_D;
		
		sprite.setRotation(shake);
		
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
