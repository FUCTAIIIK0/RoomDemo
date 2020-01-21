package ru.skillbranch.roomdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_id)
    TextView id;
    private int count=0;

    @BindView(R.id.main_firstName)
    EditText firstNameEdit;
    String firstName;

    @BindView(R.id.main_lastName)
    EditText lastNameEdit;
    String lastName;

    @BindView(R.id.main_cityID)
    EditText cityIDEdit;
    String cityID;

    @BindView(R.id.main_companyID)
    EditText companyIDEdit;
    String companyID;

    @BindView(R.id.main_addBtn)
    Button addBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        addBtn.setOnClickListener(view ->{
            firstName = firstNameEdit.getText().toString();
            lastName = lastNameEdit.getText().toString();
            cityID = cityIDEdit.getText().toString();
            companyID = companyIDEdit.getText().toString();

            UserDTO userDTO = new UserDTO(String.valueOf(count));
            userDTO.setFirstName(firstName);
            userDTO.setLastName(lastName);
            userDTO.setCityID(cityID);
            userDTO.setCompanyID(companyID);
            addUser(userDTO);
            count++;
            Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();

        });



    }

    private void addUser(UserDTO userDTO) {
    }
}