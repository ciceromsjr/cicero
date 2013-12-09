package br.cicero.views;
import java.text.NumberFormat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class EditTextCurrency extends EditText 
{

	private double value =  0;
	private boolean currency = true;
	private String textTemp = "0";
    private int maxLength = 0;

	public EditTextCurrency(Context context) 
	{
		super(context);
		init(null);
	}
	
	 public EditTextCurrency(Context context, AttributeSet attrs)
	 {
	       super(context, attrs);
	       init(attrs);
	  }

	    public EditTextCurrency(Context context, AttributeSet attrs, int defStyle)
	    {
	        super(context, attrs, defStyle);
	        init(attrs);

	    }

	    protected void onDraw (Canvas canvas) 
	    {
	        super.onDraw(canvas);
	        
	       
	    }
	    
	    private void init(AttributeSet attrs)
	    {

	    	// If you want to make a generic EditText, put a boolean attribute
	    	//  http://stackoverflow.com/questions/2029719/how-can-i-create-my-custom-properties-on-xml-for-android
//	    	if(attrs != null)
//	    	{
//	    		TypedArray a = getContext().obtainStyledAttributes(attrs,R.styleable.RobotoEditText);
//
//	    		int N = a.getIndexCount();
//	    		for (int i = 0; i < N; i++) 
//	    		{
//					int attr = a.getIndex(i);
//					
//					switch (attr) 
//					{
//						case R.styleable.RobotoEditText_currency:
//						currency = a.getBoolean(attr, false);
//						break;
//
//						default:
//						break;
//					}
//				}
//	    		   //Don't forget this
//		        a.recycle();
//	    	}
	    	
	        if(!isInEditMode())
			{
                maxLength = getResources().getInteger(br.cicero.currencyedittext.R.integer.max_length);

	        	//Set font in edittext
				Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"Fonts/Roboto-Light.ttf");
				this.setTypeface(tf);
				

				if(currency)
				{
					//Default value
					setValue(0);
					
					setOnFocusChangeListener(new OnFocusChangeListener() {
						
						@Override
						public void onFocusChange(View v, boolean hasFocus) 
						{
							if(hasFocus)
								selectAll();
						}
					});
					
					this.addTextChangedListener(new TextWatcher()
					{
						
						@Override
						public void onTextChanged(CharSequence s, int start, int before, int count) 
						{

							//Remove that when we insert the new text does not call this event again
							removeTextChangedListener(this);

							// These numbers only
							textTemp = s.toString().replaceAll("[^0-9]", "");
							
							//This is the case empty string
							textTemp = (textTemp.equals("") ? "0" : textTemp);

							//divided by 100, it enters the first end
							value = Double.parseDouble(textTemp) / 100;
							String formated = NumberFormat.getCurrencyInstance().format(value);

                            //Max  length | Value
                            if(formated.length() >= maxLength)
                            {
                                textTemp = "0";
                                value = 0;
                                formated = NumberFormat.getCurrencyInstance().format(value);
                            }

							setText(formated);
							setSelection(formated.length());
							
							Log.i("VALUE_FORM", formated);
							Log.i("VALUE_STR",s.toString());
							
							//Adds the event again for future changes
							addTextChangedListener(this);
							
							
						}
						
						@Override
						public void beforeTextChanged(CharSequence s, int start, int count,
								int after) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void afterTextChanged(Editable s) {
							// TODO Auto-generated method stub
							
						}
					});
				}
			}

	    }

		public double getValue() {
			return value;
		}

		public void setValue(double valor)
		{
			this.value = valor;
			this.setText(NumberFormat.getCurrencyInstance().format(valor));
		}

//		public boolean isCurrency() {
//			return currency;
//		}
//
//		public void setCurrency(boolean currency) {
//			this.currency = currency;
//		}
//
//

}
