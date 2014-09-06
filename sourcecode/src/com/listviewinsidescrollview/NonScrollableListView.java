package com.listviewinsidescrollview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ListView;

public class NonScrollableListView extends ListView {

	private android.view.ViewGroup.LayoutParams 	params;
    private int 									old_count = 0;
    private int										item_height = -1;
    private int										divider_height = -1;
    
	
	public NonScrollableListView(Context context) {
		super(context);
	}

	public NonScrollableListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public NonScrollableListView(Context context, AttributeSet attrs,
			int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		
		if (item_height == -1 && getCount() > 0 && getChildAt(0) != null) {
			
			item_height = getChildAt(0).getHeight();
		}
		
		if (divider_height == -1 && getCount() > 0 && getChildAt(0) != null) {
			
			divider_height = getDividerHeight();
		}
		
		if (getCount() != old_count) {
            old_count = getCount();
            params = getLayoutParams();
            params.height = (getCount() * item_height) + (getCount() * divider_height);
        	setLayoutParams(params);
        }
        super.onDraw(canvas);
	}
}
