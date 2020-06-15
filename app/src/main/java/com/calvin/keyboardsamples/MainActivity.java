package com.calvin.keyboardsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

// Implementing an interface in onClickListener that allows to handle click events on the calendar picker dialog
public class MainActivity extends AppCompatActivity implements View.OnClickListener , AdapterView.OnItemSelectedListener {
//Declaring an Edit text variable that is in the focus of the calendar dialog
// Declaring the variable that holds the selected date
    private EditText birthday;
    private int mYear;
    private int mMonth;
    private int mDay;
    private String mSpinnerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  // Connecting the edit text with the one in the layout for receiving the date value
        birthday=findViewById(R.id.birthday);
   // Connecting the Edit text to the onClick Listener
   birthday.setOnClickListener(this);
   Spinner phoneSpinner=findViewById(R.id.phone_spinner);

   if (phoneSpinner!=null){
       phoneSpinner.setOnItemSelectedListener(this);
   }
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.spinner_label, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (phoneSpinner!=null) {
            phoneSpinner.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(View v) {
 // Getting instance of the current date. Ensure the focus is on the edit Variable birthday

        if (v==birthday){
            //Declare a calendar to get current selected date
            final Calendar c= Calendar.getInstance();
            mYear=c.get(Calendar.YEAR);
            mMonth=c.get(Calendar.MONTH);
            mDay=c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    birthday.setText(dayOfMonth +"_"+(month+1+"_"+year));

                }
            },mYear,mMonth,mDay);

            datePickerDialog.show();

        }


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        mSpinnerLabel=adapterView.getItemAtPosition(i).toString();
        Toast myToast=Toast.makeText(this,"Select phone as:"+mSpinnerLabel,Toast.LENGTH_SHORT);
        myToast.show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast toast=Toast.makeText(this,"Nothing selected",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void showToast(View view) {
        Toast check=Toast.makeText(this,"Please accept Terms and Conditions",Toast.LENGTH_SHORT);
        check.show();
    }

    public void createAccount(View view) {
        Toast toastSubmit=Toast.makeText(this,"Account creation successful",Toast.LENGTH_SHORT);
        toastSubmit.show();
    }
}
