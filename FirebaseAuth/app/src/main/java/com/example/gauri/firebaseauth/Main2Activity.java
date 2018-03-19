package com.example.gauri.firebaseauth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {
    Button logout;
    FirebaseAuth mAuth;
    FirebaseAuth.AuthStateListener mAuthListener;
    private EditText userText;
    private Button button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonEqual,buttonAdd,buttonSub,
            buttonMul,buttonDiv,buttonSin,buttonCos,buttonTan,buttonClear,buttonPoint;
    float mValueOne , mValueTwo ;
    boolean mAddition , mSubtract ,mMultiplication ,mDivision,mSinCal,mCosCal,mTanCal ;

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        logout = (Button)findViewById(R.id.logout_button);
        mAuth = FirebaseAuth.getInstance();
        button0 = (Button) findViewById(R.id.button_0);
        button1 = (Button) findViewById(R.id.button_1);
        button2 = (Button) findViewById(R.id.button_2);
        button3 = (Button) findViewById(R.id.button_3);
        button4 = (Button) findViewById(R.id.button_4);
        button5 = (Button) findViewById(R.id.button_5);
        button6 = (Button) findViewById(R.id.button_6);
        button7 = (Button) findViewById(R.id.button_7);
        button8 = (Button) findViewById(R.id.button_8);
        button9 = (Button) findViewById(R.id.button_9);
        buttonAdd = (Button) findViewById(R.id.button_add);
        buttonSub = (Button) findViewById(R.id.button_minus);
        buttonMul = (Button) findViewById(R.id.button_mul);
        buttonDiv = (Button) findViewById(R.id.button_divide);
        buttonClear = (Button) findViewById(R.id.Clear);
        buttonEqual = (Button) findViewById(R.id.Equal);
        buttonPoint =(Button) findViewById(R.id.button_point);
        buttonSin = (Button) findViewById(R.id.button_sin);
        buttonCos = (Button) findViewById(R.id.button_cos);
        buttonTan = (Button) findViewById(R.id.button_tan);
        userText =(EditText) findViewById(R.id.inputoutput);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() == null){
                    startActivity(new Intent(Main2Activity.this, MainActivity.class));
                }
            }
        };
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText.setText(userText.getText()+"1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText.setText(userText.getText()+"2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText.setText(userText.getText()+"3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText.setText(userText.getText()+"4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText.setText(userText.getText()+"5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText.setText(userText.getText()+"6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText.setText(userText.getText()+"7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText.setText(userText.getText()+"8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText.setText(userText.getText()+"9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText.setText(userText.getText()+"0");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (userText == null){
                    userText.setText("");
                }else {
                    mValueOne = Float.parseFloat(userText.getText() + "");
                    mAddition = true;
                    userText.setText(null);
                }
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(userText.getText() + "");
                mSubtract = true ;
                userText.setText(null);
            }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(userText.getText() + "");
                mMultiplication = true ;
                userText.setText(null);
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(userText.getText()+"");
                mDivision = true ;
                userText.setText(null);
            }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSinCal == false && mCosCal == false && mTanCal == false) {
                    mValueTwo = Float.parseFloat(userText.getText() + "");
                }
                if (mAddition == true){
                    userText.setText(mValueOne + mValueTwo +"");
                    mAddition=false;
                }


                if (mSubtract == true){
                    userText.setText(mValueOne - mValueTwo+"");
                    mSubtract=false;
                }

                if (mMultiplication == true){
                    userText.setText(mValueOne * mValueTwo+"");
                    mMultiplication=false;
                }

                if (mDivision == true){
                    userText.setText(mValueOne / mValueTwo+"");
                    mDivision=false;
                }
                if (mSinCal == true){
                    double result = Math.sin(Math.toRadians(mValueOne));
                    Log.d("sine",result+"");
                    userText.setText(result+"");
                    mSinCal=false;
                }
                if (mCosCal == true){
                    double result = Math.cos(Math.toRadians(mValueOne));
                    Log.d("cosine",result+"");
                    userText.setText(result+"");
                    mCosCal=false;
                }
                if (mTanCal == true){
                    double result = Math.tan(Math.toRadians(mValueOne));
                    Log.d("tan",result+"");
                    userText.setText(result+"");
                    mTanCal=false;
                }
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText.setText("");
            }
        });

        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userText.setText(userText.getText()+".");
            }
        });
        buttonSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(userText.getText()+"");
                Log.d("sinbut",mValueOne+"");
                userText.setText("sin("+userText.getText()+")");
                mSinCal = true;
            }
        });
        buttonCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(userText.getText()+"");
                Log.d("cos_but",mValueOne+"");
                userText.setText("cos("+userText.getText()+")");
                mCosCal = true;
            }
        });
        buttonTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValueOne = Float.parseFloat(userText.getText()+"");
                Log.d("tan_but",mValueOne+"");
                userText.setText("tan("+userText.getText()+")");
                mTanCal = true;
            }
        });
    }
}
