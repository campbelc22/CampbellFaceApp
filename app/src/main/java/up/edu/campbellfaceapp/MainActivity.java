package up.edu.campbellfaceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    //strings to populate spinner
    String [] hairNames = {"long", "short", "ponytail"};
    private Spinner hairSpin;
    private Button randomFaceButton;
    private RadioButton hairRadio, eyesRadio, skinRadio;
    private RadioGroup rgroup;
    private SeekBar redBar, greenBar, blueBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * External Citation
         * date:10-6-2020
         * problem: forgot how to populate a spinner
         * resource: code form lecture.
         * solution: adapted the lecture code
         */
        //to put the strings into the spinner!
        hairSpin = findViewById(R.id.hairSpinner);
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>(this,android.
                R.layout.simple_spinner_dropdown_item,
                this.hairNames);
        hairSpin.setAdapter(hairAdapter);


        randomFaceButton = findViewById(R.id.randButton);
        Face faceView = findViewById(R.id.surfaceView);
        FaceController control = new FaceController(faceView);

        randomFaceButton.setOnClickListener(control);

        //set listener for radio group
        rgroup = findViewById(R.id.radioGroup);
        rgroup.setOnCheckedChangeListener(control);
        hairRadio = findViewById(R.id.hairRadioButton);
        eyesRadio = findViewById(R.id.eyesRadioButton);
        skinRadio = findViewById(R.id.skinRadioButton);

        //listeners for the seek bars!
        redBar = findViewById(R.id.redBar);
        redBar.setOnSeekBarChangeListener(control);
        greenBar = findViewById(R.id.greenBar);
        greenBar.setOnSeekBarChangeListener(control);
        blueBar = findViewById(R.id.blueBar);
        blueBar.setOnSeekBarChangeListener(control);

        /**
         * External Citation
         * date: 10-6-2020
         * problem: couldn't find the correct method for spinner
         * resource: https://developer.android.com/guide/topics/ui/controls/spinner
         * solution: found it!
         */
        hairSpin.setOnItemSelectedListener(control);
    }
}