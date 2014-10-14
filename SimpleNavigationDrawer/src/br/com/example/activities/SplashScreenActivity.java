package br.com.example.activities;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import br.com.example.R;

public class SplashScreenActivity extends Activity {

	long Delay = 1000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_splash_screen);

		Timer RunSplash = new Timer();

		TimerTask ShowSplash = new TimerTask() {
			@Override
			public void run() {
				finish();

				Intent myIntent = new Intent(SplashScreenActivity.this, MainActivity.class);
				startActivity(myIntent);
			}
		};

		RunSplash.schedule(ShowSplash, Delay);
	}
	
	@Override
	public void onBackPressed() {
//		super.onBackPressed();
	}
}
