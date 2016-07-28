package com.senierr.senote.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

	protected SessionApplication application;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    application = SessionApplication.getInstance();
		application.addActivity(this);
	}

    @Override
	protected void onDestroy() {
		super.onDestroy();
		application.removeActivity(this);
	}
}
