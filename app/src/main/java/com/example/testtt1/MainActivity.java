package com.example.testtt1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.example.testtt1.POJOModels.EmpResponse;
import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private SwipePlaceHolderView mSwipeView;
    private Context mContext;
    private ProgressBar progressBar ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSwipeView = (SwipePlaceHolderView)findViewById(R.id.swipeView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar3);
        progressBar.setVisibility(View.VISIBLE);
        mContext = getApplicationContext();

        mSwipeView.getBuilder()
                .setDisplayViewCount(3)
                .setSwipeDecor(new SwipeDecor()
                        .setPaddingTop(20)
                        .setRelativeScale(0.01f));


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<EmpResponse>> call = apiService.getTopRatedMovies();
        call.enqueue(new Callback<List<EmpResponse>>() {
            @Override
            public void onResponse(Call<List<EmpResponse>> call, Response<List<EmpResponse>> response) {
                Log.d(TAG, "Number of movies received: " + response.body());
                progressBar.setVisibility(View.GONE);
                List<EmpResponse> emps = response.body();

                for(EmpResponse emp : emps){
                    mSwipeView.addView(new EmployeeCard(mContext, emp, mSwipeView));
                }


            }

            @Override
            public void onFailure(Call<List<EmpResponse>> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                progressBar.setVisibility(View.GONE);
            }
        });


    }
}
