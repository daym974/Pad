
package com.example.pad;
 
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
 
public class MainActivity extends Activity {
	private MediaPlayer mPlayer = null;
	private MediaPlayer loop = null;
	private boolean edite  = false;
	private EcouteurMusic ecouteur = new EcouteurMusic();
	Button[] tabB = new Button[9];
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		
		final ButtonMusic bouton4 = new ButtonMusic((Button) findViewById(R.id.button4),R.raw.coin);
		bouton4.setOnClickListener(ecouteur);
		
		Button editer = (Button) findViewById(R.id.button11);
		editer.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
				if(edite == false){
				edite = true;
				Toast.makeText(MainActivity.this, "yo", Toast.LENGTH_SHORT).show();
				
				}else{
					edite = false;
					Toast.makeText(MainActivity.this, "plus yo", Toast.LENGTH_SHORT).show();
					
					
				}
			}
 
		});	
		
	}
 
	private void playSound(int resId) {
		if(mPlayer != null) {
			mPlayer.stop();
			mPlayer.release();
		}
		mPlayer = MediaPlayer.create(this, resId);
		mPlayer.start();
	}
	
	private void playLoop(int resId){
		loop = MediaPlayer.create(this, resId);
		loop.start();

	}
	
	
	public abstract class EcouteurMusic implements View.OnClickListener{

		public void onClick(ButtonMusic b) {
			playSound(b.getRefSon());
			
		}

	}
}


			
