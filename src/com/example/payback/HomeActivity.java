package com.example.payback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {
	static String curUsr;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		if(curUsr == null){
			Intent intent = getIntent();
			String message = intent.getStringExtra(LoginActivity.EXTRA_MESSAGE);
			curUsr = message.split("@")[0];
		}
		TextView nameView = (TextView) findViewById(R.id.profName);
		nameView.setText(curUsr);
		
		
		
		final Activity thisActivity = this;
        
        TextView b = new TextView(this);
        b = (TextView)findViewById(R.id.balance);
        b.setText("Balance");
        
        double sum = 0;
        for(int i =0;i<TransactionsActivity.transArray.length;i++){
        	sum+= Double.parseDouble(TransactionsActivity.transArray[i][2]);
        }
        b.setText("Total Balance:   $"+sum);
        
        final Button transaction = (Button) findViewById(R.id.transaction);
        transaction.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Toast t = Toast.makeText(thisActivity, "transaction!", Toast.LENGTH_LONG);
                t.show();
                Intent intent = new Intent(thisActivity, TransactionsActivity.class);
                //intent.putExtra(EXTRA_MESSAGE,)
                startActivity(intent);
                
                
            }
        });
        final Button network = (Button) findViewById(R.id.network);
        network.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast t = Toast.makeText(thisActivity, "network!", Toast.LENGTH_LONG);
                t.show();
                Intent intent = new Intent(thisActivity, NetworkActivity.class);
                startActivity(intent);
            }
        });
        final Button addTransaction = (Button) findViewById(R.id.add_transaction);
        addTransaction.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Toast t = Toast.makeText(thisActivity, "transaction added!", Toast.LENGTH_LONG);
            	t.show();
            	Intent intent = new Intent(thisActivity, AddTransActivity.class);
                //intent.putExtra(EXTRA_MESSAGE,)
                startActivity(intent);
            }
        });

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_home, menu);
		return true;
	}

}
