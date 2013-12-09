package br.cicero.views;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class RobotoButton extends Button 
{

	public RobotoButton(Context context) 
	{
		super(context);
		init(null);
	}
	
	 public RobotoButton(Context context, AttributeSet attrs)
	 {
	       super(context, attrs);
	       init(attrs);
	  }

	    public RobotoButton(Context context, AttributeSet attrs, int defStyle)
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

	        if(!isInEditMode())
			{
	        	//Set font in textview
				Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"Fonts/Roboto-Light.ttf");
				this.setTypeface(tf);
			}

	    }
}
