package ru.skillbranch.roomdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
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
    private int count = 0;

    @BindView(R.id.main_firstName)
    EditText firstNameEdit;
    String firstName;

    @BindView(R.id.main_mainLastname)
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

    @BindView(R.id.main_getFirst)
    Button getFirstUserBtn;

    @BindView(R.id.main_getAll)
    Button getAllUsersBtn;

    //db
    public static TestDatabase testDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initDB();

        addBtn.setOnClickListener(view -> {
            firstName = firstNameEdit.getText().toString();
            lastName = lastNameEdit.getText().toString();
            cityID = cityIDEdit.getText().toString();
            companyID = companyIDEdit.getText().toString();

            //addUser
            UserDTO userDTO = new UserDTO();
            userDTO.setFirstName(firstName);
            userDTO.setLastName(lastName);
            userDTO.setCityID(cityID);
            userDTO.setCompanyID(companyID);
            addUser(userDTO);

            count++;
            Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
            id.setText(String.valueOf(count));

        });
        getFirstUserBtn.setOnClickListener(view -> {
            getFirstUser();
        });
        getAllUsersBtn.setOnClickListener(view -> {
            getAllUsers();
        });


    }

    private void addUser(UserDTO userDTO) {
        MainActivity.testDatabase.testDao().addUser(userDTO);
        Toast.makeText(getApplicationContext(), "User added to DB successfully", Toast.LENGTH_LONG).show();

    }

    private void getAllUsers() {
        List<UserDTO> userDTOList = MainActivity.testDatabase.testDao().getAll();

    }

    private void getFirstUser() {

    }

    private void initDB() {
        //TODO Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
        // Change allowMainThreadQueries!!!
        testDatabase = Room.databaseBuilder(getApplicationContext(), TestDatabase.class, "userDB").allowMainThreadQueries().build();

    }


}