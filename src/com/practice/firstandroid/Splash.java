package com.practice.firstandroid;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends MainActivity {
	MediaPlayer ourSong;
	@Override
	protected void onCreate(Bundle lol) {
		// TODO Auto-generated method stub
		super.onCreate(lol);
		setContentView(R.layout.splash);
		ourSong = MediaPlayer.create(Splash.this,R.raw.splash);
		ourSong.start();
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(5000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMainActivity = new Intent("com.practice.firstandroid.MENU");
					startActivity(openMainActivity);
				}
			}
		};
		timer.start();
		
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}
	

}
