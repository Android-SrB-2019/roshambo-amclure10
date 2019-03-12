/**
 * Alex McLure
 * 2019-03-11
 */
package com.example.owner.roshambo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Roshambo roshambo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * @param view
     */
    public void playGame(View view) {
        int move = Integer.parseInt(view.getTag().toString());
        roshambo = new Roshambo();
        roshambo.playerMakesMove(move);
        int playerMove = roshambo.getPlayerMove();
        int compMove = roshambo.getGameMove();
        setImage((ImageView)findViewById(R.id.computerimage), compMove);
        setImage((ImageView)findViewById(R.id.playerimage), playerMove);
        TextView txt = findViewById(R.id.display_winner);
        txt.setText(roshambo.winLoseOrDraw());
    }

    /**
     * Sets the image view based on the value that it is given
     * @param imageView
     * @param value
     */
    private void setImage(ImageView imageView, int value){
        switch (value){
            case Roshambo.ROCK:
                imageView.setImageResource(R.drawable.rock);
                break;
            case Roshambo.PAPER:
                imageView.setImageResource(R.drawable.paper);
                break;
            case Roshambo.SCISSOR:
                imageView.setImageResource(R.drawable.scissors);
                break;
            default:
                break;
        }
    }
}
