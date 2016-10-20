package kr.hs.emirim.dbfl0406.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editName,editAge;
    SharedPreferences sp; //이건 한 컬럼당 한 데이터밖에 저장 못해서 환경설정 등에 많이 쓰

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName=(EditText)findViewById(R.id.edit_name);
        editAge=(EditText)findViewById(R.id.edit_age);
        sp=getSharedPreferences("appInfo", Context.MODE_PRIVATE); //world는 다른 앱에서도 쓰고 private는 이 앱에서만 쓰고
    }

    @Override
    protected void onResume() {
        super.onResume();
        String name=sp.getString("name","");
        String age=sp.getString("age","");
        editName.setText(name);
        editAge.setText(age);
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor edit=sp.edit(); //Edit의 참조값을 받는다...?
        edit.putString("name",editName.getText().toString());
        edit.putString("age",editAge.getText().toString());
        edit.commit();
    }
}
