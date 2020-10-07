package up.edu.campbellfaceapp;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class FaceController implements Button.OnClickListener, SeekBar.OnSeekBarChangeListener,
        RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener{
    private Face faceView;
    int redColor, greenColor, blueColor, radioInd;
    public static final int HAIR = 0;
    public static final int EYES = 1;
    public static final int SKIN = 2;

    public FaceController (Face view) {
        this.faceView=view;
    }

    @Override
    public void onClick(View view) {
        //calls randomize to get new values
        faceView.randomize();
        faceView.invalidate();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int checkedId = radioGroup.getCheckedRadioButtonId();

        if(checkedId == R.id.hairRadioButton) {
            radioInd = HAIR;
        }
        else if(checkedId == R.id.eyesRadioButton) {
            radioInd = EYES;
        }
        else if (checkedId == R.id.skinRadioButton) {
            radioInd = SKIN;
        }
        faceView.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        if(seekBar.getId() == R.id.redBar){
            redColor = progress;
        }
        else if (seekBar.getId() == R.id.greenBar) {
            greenColor = progress;
        }
        else if(seekBar.getId() == R.id.blueBar) {
            blueColor= progress;
        }
        if(radioInd == HAIR) {
            faceView.setHairColor(redColor, greenColor, blueColor);
        }
        else if (radioInd == EYES) {
            faceView.setEyeColor(redColor, greenColor, blueColor);
        }
        else if (radioInd == SKIN) {
            faceView.setSkinColor(redColor, greenColor, blueColor);
        }
        faceView.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //dont need
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //dont need
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        faceView.hairStyle = i;
        faceView.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //dont need
    }
}
