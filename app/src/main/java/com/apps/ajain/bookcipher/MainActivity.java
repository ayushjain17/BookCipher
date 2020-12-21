package com.apps.ajain.bookcipher;

import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        et1 =(EditText) findViewById(R.id.et1);
        et2 =(EditText) findViewById(R.id.et2);
        et3 =(EditText) findViewById(R.id.et3);
    }

    public void Encode(View v) {
        StringBuilder r= new StringBuilder();
        String b="";
        String s;
        String std="THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG";
        String num="AFTERSHOCK";
        char ch;
        s=et1.getText().toString().toUpperCase();
        if(!s.equals(""))
        {
            for (int i = 0; i < s.length(); i++)
            {
                ch = s.charAt(i);
                if (Character.isLetter(ch))
                    b=(std.indexOf(ch)+1)+" ";
                else if(Character.isDigit(ch)) {
                    int z=Character.getNumericValue(ch);
                    b = num.charAt(z)+" ";
                }
                else
                    b=". ";
                r.append(b);
            }
            et3.setText(r.toString());
            et2.setText("");
        }
    }

    public void Decode(View v) {
        String r="",s,b="",std="THEQUICKBROWNFOXJUMPSOVERTHELAZYDOG";
        String num="AFTERSHOCK";
        int i=0;
        char ch='\0';
        s=et2.getText().toString().trim().toUpperCase();
        if(!s.equals(""))
        {
            s += " ";
            while(s.length()>0)
            {
                i = s.indexOf(" ");
                b = s.substring(0, i);
                if (Character.isDigit(b.charAt(0)))
                    ch = std.charAt(Integer.parseInt(b)-1);
                else if (b.equals("."))
                    ch = ' ';
                else if(Character.isLetter(b.charAt(0)))
                    ch=(char)(num.indexOf(b.charAt(0))+48);
                r += ch;
                s = s.substring(i + 1);
                ch = '\0';
            }
            et3.setText(r);
            et1.setText("");
        }
    }

    public void Clear(View v) {
        et1.setText("");
        et2.setText("");
        et3.setText("");
    }

    public void Copy(View v) {
        String s=et3.getText().toString();
        ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        cm.setText(s);
    }
}