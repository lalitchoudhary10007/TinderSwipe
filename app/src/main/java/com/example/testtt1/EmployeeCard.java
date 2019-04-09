package com.example.testtt1;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.example.testtt1.POJOModels.EmpResponse;
import com.mindorks.placeholderview.SwipePlaceHolderView;
import com.mindorks.placeholderview.annotations.Layout;
import com.mindorks.placeholderview.annotations.Resolve;
import com.mindorks.placeholderview.annotations.View;
import com.mindorks.placeholderview.annotations.swipe.SwipeCancelState;
import com.mindorks.placeholderview.annotations.swipe.SwipeIn;
import com.mindorks.placeholderview.annotations.swipe.SwipeInState;
import com.mindorks.placeholderview.annotations.swipe.SwipeOut;
import com.mindorks.placeholderview.annotations.swipe.SwipeOutState;

@Layout(R.layout.emp_card_details)
public class EmployeeCard {

    @View(R.id.textView)
    private TextView id;

    @View(R.id.textView2)
    private TextView name;

    @View(R.id.textView3)
    private TextView salary;

    @View(R.id.textView4)
    private TextView age;


    private Context mContext;
    private SwipePlaceHolderView mSwipeView;
    EmpResponse empResponse ;

    public EmployeeCard(Context context, EmpResponse res, SwipePlaceHolderView swipeView) {
        mContext = context;
        empResponse = res;
        mSwipeView = swipeView;
    }


    @Resolve
    private void onResolved(){
        id.setText("Id:- "+empResponse.getId());
        name.setText("Name:- "+empResponse.getEmployee_name());
        salary.setText("Salary:- "+empResponse.getEmployee_salary());
        age.setText("Age:- "+empResponse.getEmployee_age());
    }

    @SwipeOut
    private void onSwipedOut(){
        Log.d("EVENT", "onSwipedOut");
        mSwipeView.addView(this);
    }

    @SwipeCancelState
    private void onSwipeCancelState(){
        Log.d("EVENT", "onSwipeCancelState");
    }

    @SwipeIn
    private void onSwipeIn(){
        Log.d("EVENT", "onSwipedIn");
    }

    @SwipeInState
    private void onSwipeInState(){
        Log.d("EVENT", "onSwipeInState");
    }

    @SwipeOutState
    private void onSwipeOutState(){
        Log.d("EVENT", "onSwipeOutState");
    }

}
