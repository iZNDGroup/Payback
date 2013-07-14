package com.example.payback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TransactionsActivity extends Activity {
	static String transArray[][] = {{"Keagan","Fun Times","-12.3"},{"Tiff","Secret Sauce", "14.3"}};
	Activity thisActivity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_transactions);
		thisActivity = this;
		
		TextView minus = (TextView)findViewById(R.id.minus);
		minus.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(thisActivity, MinusActivity.class);
                startActivity(intent);
			}
			
		});
		
        
		for(int i=0; i<transArray.length; i++){
			
			String current[] = transArray[i];
			LinearLayout ll = new LinearLayout(this);
			
			ll.setOrientation(LinearLayout.HORIZONTAL);
			ll.setBackgroundResource(R.drawable.thumbtackpaper);
			ll.setPadding(75, 35, 0, 0);
			
			
			TextView userView = new TextView(this);
			userView.setText(current[0]);
			userView.setTextSize(15);
			userView.setPadding(5, 5, 5, 5);
			userView.setBackgroundResource(R.drawable.textborder3);
			
			TextView nameView = new TextView(this);
			nameView.setText(current[1]);
			nameView.setTextSize(15);
			nameView.setPadding(5, 5, 5, 5);
			nameView.setBackgroundResource(R.drawable.textborder3);			

			TextView amountView = new TextView(this);
			amountView.setBackgroundResource(R.drawable.textborder3);
			double amount = Double.parseDouble(current[2]);
			
			if(amount > 0)
				amountView.setText("Lent: "+amount);
			else
				amountView.setText("Borrowed: "+Math.abs(amount));

			amountView.setTextSize(15);
			amountView.setPadding(5, 5, 5, 5);
			
			ll.addView(userView);
			ll.addView(nameView);
			ll.addView(amountView);
			ll.setVisibility(LinearLayout.VISIBLE);
			
		
			
	        LinearLayout transList = (LinearLayout)findViewById(R.id.scroll_list3);
	        transList.addView(ll);
	        
		}
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_transactions, menu);
		return true;
	}

}

