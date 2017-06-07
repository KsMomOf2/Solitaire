package com.bishopireton.solitaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class scrnSplash extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scrn_splash);

    Button btnStart= (Button) findViewById(R.id.btnStart);
    btnStart.setOnClickListener(new View.OnClickListener() {
      public void onClick(View v) {
        startActivity(new Intent(scrnSplash.this,scrnGame.class));
      }
    });
  }
}
