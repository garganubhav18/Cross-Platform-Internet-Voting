package com.cpi.voting;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Det  extends Activity implements AdapterView.OnItemSelectedListener{ 
	Button b1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_det);
		TextView T1=(TextView)findViewById(R.id.tv1);
		TextView T2=(TextView)findViewById(R.id.tv2);
		TextView T3=(TextView)findViewById(R.id.tv3);
		TextView T4=(TextView)findViewById(R.id.tv4);
		TextView T5=(TextView)findViewById(R.id.tv5);
		TextView T6=(TextView)findViewById(R.id.tv6);
		TextView T7=(TextView)findViewById(R.id.tv7);
		T1.setText(Landing.detail[Landing.pos][0]);
		T2.setText(Landing.detail[Landing.pos][1]);
		T3.setText(Landing.detail[Landing.pos][2]);
		T4.setText(Landing.detail[Landing.pos][3]);
		T5.setText(Landing.detail[Landing.pos][4]);
		T6.setText(Landing.detail[Landing.pos][5]);
		T7.setText(Landing.detail[Landing.pos][6]);
		String url="http://www.cpivoting.cpanel.byethost8.com/" + Landing.detail[Landing.pos][7];
		WebView	mWebView=(WebView) findViewById (R.id.webView1);
			mWebView.setWebViewClient(new Ourwebview());
			mWebView.loadUrl(url);
			mWebView.getSettings().setJavaScriptEnabled(true);
	
			b1 = (Button) findViewById(R.id.button2);
			
			b1.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
							Det.this);
			 
						// set title
						alertDialogBuilder.setTitle("Confirmation");
			 
						// set dialog message
						alertDialogBuilder
							.setMessage("Click yes to exit!")
							.setCancelable(false)
							.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,int id) {
									// if this button is clicked, close
									// current activity
									//Regstu1.this.finish();
									Toast.makeText(Det.this, "You Have Successfully Voted", Toast.LENGTH_LONG).show();
									Intent intent = new Intent(Det.this ,MainActivity.class);
							    	startActivity(intent);
								}
							  })
							.setNegativeButton("No",new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,int id) {
									// if this button is clicked, just close
									// the dialog box and do nothing
									dialog.cancel();
								}
							});
			 
							// create alert dialog
							AlertDialog alertDialog = alertDialogBuilder.create();
			 
							// show it
							alertDialog.show();
				}
				
			});
	
	}


	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			 long arg3) {
		// TODO Auto-generated method stub
		
		
	}
	
	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}


	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.det, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/
}
