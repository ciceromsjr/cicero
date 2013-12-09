package br.cicero.currencyedittext;

import br.cicero.views.EditTextCurrency;
import br.cicero.views.RobotoButton;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	private EditTextCurrency txtSalary, txtExpenses, txtRest;
	private RobotoButton btnCalculate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		LoadViews();
	}
	
	private void LoadViews()
	{
		txtSalary = (EditTextCurrency)findViewById(R.id.txtSalary);
		txtExpenses = (EditTextCurrency)findViewById(R.id.txtExpenses);
		txtRest = (EditTextCurrency)findViewById(R.id.txtRest);
		
		btnCalculate = (RobotoButton)findViewById(R.id.btnCalculate);
		btnCalculate.setOnClickListener(this);
	}

	@Override
	public void onClick(View v)
	{
		if(v == btnCalculate)
		{
		    txtRest.setValue(txtSalary.getValue() - txtExpenses.getValue());
		}
		
	}

}
