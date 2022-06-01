package sg.edu.rp.c346.id21018812.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URI;
import java.util.Locale;

import sg.edu.rp.c346.id21018812.mylocalbanks.R;

public class MainActivity extends AppCompatActivity {

    TextView button1;
    TextView button2;
    TextView button3;


    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.buttondbs);
        button2 = findViewById(R.id.buttonocbc);
        button3 = findViewById(R.id.buttonuob);

        registerForContextMenu(button1);
        registerForContextMenu(button2);
        registerForContextMenu(button3);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "website");
        menu.add(0, 1, 1, "contact");

        if (v == button1){
            wordClicked = "1";
        }
        else if(v == button2){
            wordClicked = "2";
        }
        else if (v == button3){
            wordClicked = "3";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(wordClicked.equalsIgnoreCase("0")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);


                return true; //menu item successfully handled


            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:18001111111"));
                startActivity(intent);

                return true; //menu item successfully handled


            }
        }else if(wordClicked.equalsIgnoreCase("1")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);


                return true; //menu item successfully handled


            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:18003633333"));
                startActivity(intent);

                return true; //menu item successfully handled


            }
        }else{
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);


                return true; //menu item successfully handled


            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:18002222121"));
                startActivity(intent);

                return true; //menu item successfully handled

            }
        }

        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            button1.setText("DBS");
            button2.setText("OCBC");
            button3.setText("UOB");

            return true;
        } else if (id == R.id.ChineseSelection) {
            button1.setText("星展银行");
            button2.setText("华侨银行");
            button3.setText("大华银行");

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
