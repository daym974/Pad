
package com.example.pad;
 
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
 
public class MainActivity extends Activity {
	private int nb = 9;
	private Button[] tabB = new Button[nb];
	private int[] refSon = new int[nb];
	private MediaPlayer[] mp = new MediaPlayer[nb];
	private boolean edite  = false;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tabB[0] = (Button)findViewById(R.id.button1);
		tabB[1] = (Button)findViewById(R.id.button2);
		tabB[2] = (Button)findViewById(R.id.button3);
		tabB[3] = (Button)findViewById(R.id.button4);
		tabB[4] = (Button)findViewById(R.id.button5);
		tabB[5] = (Button)findViewById(R.id.button6);
		tabB[6] = (Button)findViewById(R.id.button7);
		tabB[7] = (Button)findViewById(R.id.button8);
		tabB[8] = (Button)findViewById(R.id.button9);
		
		refSon[0] = R.raw.caisseclaire;
		refSon[1] = R.raw.grossecaisse;
		refSon[2] = R.raw.drop;
		refSon[3] = R.raw.bim;
		refSon[4] = R.raw.zbre;
		refSon[5] = R.raw.coin;
		refSon[6] = R.raw.izi;
		refSon[7] = R.raw.up;
		refSon[8] = R.raw.zbra;
		
		for(int x = 0;x<nb;x++){
			mp[x] = new MediaPlayer();
		}
		
		assigner();
		
		Button editer = (Button) findViewById(R.id.button11);
		editer.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
				if(edite == false){
				edite = true;
				Toast.makeText(MainActivity.this, "edite = true", Toast.LENGTH_SHORT).show();				
				}else{
					edite = false;
					Toast.makeText(MainActivity.this, "edite = false", Toast.LENGTH_SHORT).show();	
				}
			}
		});	
		
		Button stop = (Button) findViewById(R.id.button12);
		stop.setOnClickListener(new OnClickListener() {
 
			@Override
			public void onClick(View v) {
				
					for(int x = 0;x<nb;x++){
						onDestroy(mp[x]);
				}
			}
		});		
	}
 
	private void playSound(int resId, MediaPlayer mp) {
		/*if(mp != null) {
			mp.stop();
			mp.release();
		}*/
		mp = MediaPlayer.create(this, resId);
		mp.setLooping(true);
		mp.start();
	}

	public void assigner(){
	for(int x = 0;x<tabB.length;x++){
		final int son = refSon[x];
		final MediaPlayer mediaP = mp[x];
		tabB[x].setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				playSound(son,mediaP );	
			}			
		});
	}
	}
	
    public void onDestroy(MediaPlayer mp) {
        super.onDestroy ();
        if( mp.isLooping()) {
        	try {
				mp.prepare();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            mp.stop();
            mp.release(); 
            mp = null;
        }
    }
}