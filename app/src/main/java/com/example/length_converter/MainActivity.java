package com.example.length_converter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    private EditText inputValueEditText;
    private Spinner inputUnitSpinner;
    private Spinner outputUnitSpinner;
    private Button convertButton;
    private Button swapButton;
    private TextView outputValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValueEditText = findViewById(R.id.input_value);
        inputUnitSpinner = findViewById(R.id.input_unit);
        outputUnitSpinner = findViewById(R.id.output_unit);
        convertButton = findViewById(R.id.convert_button);
        swapButton = findViewById(R.id.swap_button);
        outputValueTextView = findViewById(R.id.output_value);

        // Handle the Convert button click
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertLength();
            }
        });

        // Handle the Swap button click
        swapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swapUnits();
            }
        });
    }

    private void convertLength() {
        String inputValue = inputValueEditText.getText().toString();

        // Check if input is empty
        if (inputValue.isEmpty()) {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
            return;
        }

        String inputUnit = inputUnitSpinner.getSelectedItem().toString();
        String outputUnit = outputUnitSpinner.getSelectedItem().toString();
        double value = Double.parseDouble(inputValue);

        double result = 0.0;

        // Conversion logic
        switch (inputUnit) {
            case "Mét":
                switch (outputUnit) {
                    case "Mét":
                        result = value;
                        break;
                    case "Kilômét":
                        result = value / 1000;
                        break;
                    case "Milimet":
                        result = value * 1000;
                        break;
                    case "Dặm":
                        result = value / 1609.34;
                        break;
                    case "Feet":
                        result = value * 3.281;
                        break;
                }
                break;
            case "Kilômét":
                switch (outputUnit) {
                    case "Mét":
                        result = value * 1000;
                        break;
                    case "Kilômét":
                        result = value;
                        break;
                    case "Milimet":
                        result = value * 1000000;
                        break;
                    case "Dặm":
                        result = value / 1.60934;
                        break;
                    case "Feet":
                        result = value * 3280.84;
                        break;
                }
                break;
            case "Milimet":
                switch (outputUnit) {
                    case "Mét":
                        result = value / 1000;
                        break;
                    case "Kilômét":
                        result = value / 1000000;
                        break;
                    case "Milimet":
                        result = value;
                        break;
                    case "Dặm":
                        result = value / 1609340;
                        break;
                    case "Feet":
                        result = value / 304.8;
                        break;
                }
                break;
            case "Dặm":
                switch (outputUnit) {
                    case "Mét":
                        result = value * 1609.34;
                        break;
                    case "Kilômét":
                        result = value * 1.60934;
                        break;
                    case "Milimet":
                        result = value * 1609340;
                        break;
                    case "Dặm":
                        result = value;
                        break;
                    case "Feet":
                        result = value * 5280;
                        break;
                }
                break;
            case "Feet":
                switch (outputUnit) {
                    case "Mét":
                        result = value / 3.281;
                        break;
                    case "Kilômét":
                        result = value / 3280.84;
                        break;
                    case "Milimet":
                        result = value * 304.8;
                        break;
                    case "Dặm":
                        result = value / 5280;
                        break;
                    case "Feet":
                        result = value;
                        break;
                }
                break;
        }

        outputValueTextView.setText(String.valueOf(result));
    }

    // Swap the selected units in the spinners
    private void swapUnits() {
        int inputPosition = inputUnitSpinner.getSelectedItemPosition();
        int outputPosition = outputUnitSpinner.getSelectedItemPosition();

        inputUnitSpinner.setSelection(outputPosition);
        outputUnitSpinner.setSelection(inputPosition);
    }
}
