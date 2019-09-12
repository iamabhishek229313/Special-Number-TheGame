package com.example.specialnumber_thegame;



import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    public int randomNumber = (int) (Math.random() * 100);
    private int record = 10 ;
    private int totalTrials = 10 ;
    public void restart(){
        totalTrials = 10 ;
        randomNumber = (int) (Math.random() * 100) ;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void guessButtonClicked(View view) {
        totalTrials-- ;
        TextView message = (TextView) findViewById(R.id.boldText) ;

        EditText userInput = (EditText) findViewById(R.id.userNumber);
        int numberQueried = Integer.parseInt(userInput.getText().toString());
        int comparator = Math.abs(numberQueried-randomNumber) ;
        if(comparator > 35){
            message.setText("Too Far from Target !");
        }else if(comparator > 20 && comparator  <= 35){
            message.setText("You are little bit closer !");
        }else if(comparator > 5 && comparator <= 20){
            message.setText("Woahh ! You are very close to target Keep Going .");
        }else if(comparator > 1 && comparator <= 5){
            message.setText("Extremly Close !! Good Luck ");
        }else if (comparator == 0 ){
            message.setText("Winner ! You are Genius . \n{ Game Restarted }");
            if((10 - totalTrials) < record){
                record = 10 - totalTrials ;
                setBestScore(record);
            }
            restart();
        }
        if(totalTrials == 0 ){
            message.setText("You have Lost ! \n { Game Restarted }");
            restart();
        }
        trailsHandler(totalTrials);
    }

    public void trailsHandler(int trailsRemaining){
        TextView trailsText = (TextView) findViewById(R.id.trailsText);
        trailsText.setText("Trails Remaining : " + trailsRemaining);
    }
    public void setBestScore(int new_record){
        TextView bestScore = (TextView) findViewById(R.id.textView3);
        bestScore.setText("Best Score is of "+ new_record + " trails");
    }

}

