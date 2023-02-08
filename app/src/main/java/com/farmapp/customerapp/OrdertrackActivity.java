package com.farmapp.customerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.baoyachi.stepview.VerticalStepView;

import java.util.ArrayList;
import java.util.List;

public class OrdertrackActivity extends AppCompatActivity {
    VerticalStepView stepview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordertrack);
        stepview=findViewById(R.id.stepview);
        setStepView();
    }
    private void setStepView() {
        stepview.setStepsViewIndicatorComplectingPosition(getList().size())
                .reverseDraw(false)
                .setStepViewTexts(getList())
                .setLinePaddingProportion(0.85f)
                .setStepsViewIndicatorCompletedLineColor(getColor(R.color.purple_200))
                .setStepViewComplectedTextColor(getColor(R.color.purple_500))
                .setStepViewUnComplectedTextColor(getColor(R.color.black))
                .setStepsViewIndicatorCompleteIcon(getDrawable(R.drawable.accept))
                .setStepsViewIndicatorAttentionIcon(getDrawable(com.baoyachi.stepview.R.drawable.attention))
                .setStepsViewIndicatorDefaultIcon(getDrawable(R.drawable.circle));

        stepview.setStepsViewIndicatorComplectingPosition(2);

    }

    private List<String> getList(){
        List<String> list=new ArrayList<>();
        List<String> list1=new ArrayList<>();

        list.add("Your order was placed for delivery");
        list.add("Your order is pending for confirnation");
        list.add("Your order is confirmed will deliver soon");
        list.add("Your product is processing to deliver you on time");
        list.add("Product delivered to you");
        return list;
    }

    /*private List<String> getList1(){
        List<String> list1=new ArrayList<>();


        list1.add("Order Placed");
        list1.add("Second Step");
        list1.add("Third Step");
        list1.add("Fourth Step");
        list1.add("Fifth Step");
        return list1;
    }*/

}