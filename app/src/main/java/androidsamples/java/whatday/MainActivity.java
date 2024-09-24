package androidsamples.java.whatday;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


import java.util.*;


public class MainActivity extends AppCompatActivity {

  private String TAG = "validation";
  private EditText editDate, editMonth, editYear;
  private Button btnCheck;
  private TextView txtDisplay;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    editDate = findViewById(R.id.editDate);
    editMonth = findViewById(R.id.editMonth);
    editYear = findViewById(R.id.editYear);
    btnCheck = findViewById(R.id.btn_check);
    txtDisplay = findViewById(R.id.txt_display);
    // @Override
    btnCheck.setOnClickListener(v -> {
      String dateStr = editDate.getText().toString();
      String monthStr = editMonth.getText().toString();
      String yearStr = editYear.getText().toString();

      DateModel dateModel = new DateModel();
      dateModel.initialize(yearStr, monthStr, dateStr);
      String message = dateModel.getMessage();

      txtDisplay.setText(message);

    });
  }
}
