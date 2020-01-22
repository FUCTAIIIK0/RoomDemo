package ru.skillbranch.roomdemo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.skillbranch.roomdemo.R;
import ru.skillbranch.roomdemo.demo.Dao;
import ru.skillbranch.roomdemo.demo.Demo1Database;
import ru.skillbranch.roomdemo.demo2.RecordDB;
import ru.skillbranch.roomdemo.demo2.RecordDao;
import ru.skillbranch.roomdemo.dto.RecordDTO;
import ru.skillbranch.roomdemo.dto.UserDTO;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_id)
    TextView id;
    //private int count = 0;

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

    @BindView(R.id.main_output)
    TextView outputText;
    String output;

    @BindView(R.id.main_addUserBtn)
    Button addUserBtn;

    @BindView(R.id.main_addRecordBtn)
    Button addRecordBtn;

    @BindView(R.id.main_getFirst)
    Button getFirstUserBtn;

    @BindView(R.id.main_getAll)
    Button getAllUsersBtn;

    @BindView(R.id.main_getAllRecords)
    Button getAddRecordBtn;

    //db
    public static Demo1Database demo1Database;
    public static RecordDB recordDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDB();

        addUserBtn.setOnClickListener(view -> {
//            firstName = firstNameEdit.getText().toString();
//            lastName = lastNameEdit.getText().toString();
//            cityID = cityIDEdit.getText().toString();
//            companyID = companyIDEdit.getText().toString();
//
//            //addUser
//            UserDTO userDTO = new UserDTO();
//            userDTO.setFirstName(firstName);
//            userDTO.setLastName(lastName);
//            userDTO.setCityID(cityID);
//            userDTO.setCompanyID(companyID);
//            addUser(userDTO);
//
//            //count++;
//            Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
//            //id.setText(String.valueOf(count));

        });
        addRecordBtn.setOnClickListener(view -> {
            addRecordDTo();
            Toast.makeText(getApplicationContext(), "Record added to DB successfully", Toast.LENGTH_LONG).show();
        });

        getFirstUserBtn.setOnClickListener(view -> {
            getFirstUser();
        });
        getAllUsersBtn.setOnClickListener(view -> {
           // getAllUsers();
        });

        getAddRecordBtn.setOnClickListener(view -> {
            getAllRecords();

        });
    }

//    private void addUser(UserDTO userDTO) {
//        Dao dao = demo1Database.testDao();
//        dao.addUser(userDTO);
//        //MainActivity.demo1Database.testDao().addUser(userDTO);
//        Toast.makeText(getApplicationContext(), "User added to DB successfully", Toast.LENGTH_LONG).show();
//    }

    private void addRecordDTo() {
        Date currentDate = Calendar.getInstance().getTime();
        RecordDTO recordDTO = new RecordDTO();

        recordDTO.setAdded(currentDate.toString());
        recordDTO.setSerializeObject("test Json");

        RecordDao recordDao = (RecordDao) recordDB.iManager();
        recordDao.add(recordDTO);
    }

//    private void getAllUsers() {
//        List<UserDTO> userDTOList = MainActivity.demo1Database.testDao().getAll();
//        String info = " ";
//        for (UserDTO user : userDTOList) {
//            int id = user.getUid();
//            String firstName = user.getFirstName();
//            String lastName = user.getLastName();
//            String cityID = user.getCityID();
//            String companyID = user.getCompanyID();
//
//            info = info + "\n\n" +
//                    "id " + id + "\n" +
//                    "firstname " + firstName + "\n" +
//                    "lastname " + lastName + "\n" +
//                    "CityID " + cityID + "\n" +
//                    "company " + companyID + "\n";
//            Log.d("Main", info);
//
//            outputText.setText(info);
//
//        }
//
//    }

    private void getAllRecords() {
        RecordDao recordDao = (RecordDao) recordDB.iManager();

        List<RecordDTO> recordDTOList = recordDao.getAll();

        String info = "";
        for (RecordDTO recordDTO : recordDTOList){
            long id = recordDTO.getId();
            String date = recordDTO.getAdded();
            String object = recordDTO.getSerializeObject();

            info = info + "\n\n" +
                    "id " + id + "\n" +
                    "date " + date.toString() + "\n" +
                    "object " + object + "\n";

            Log.d("Main", info);

            outputText.setText(info);

        }


    }

    private void getFirstUser() {

    }


    private void initDB() {
        //TODO Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
        // Change allowMainThreadQueries!!!
//        demo1Database = Room.databaseBuilder(getApplicationContext(),
//                Demo1Database.class, "userDB").allowMainThreadQueries().build();

        recordDB = Room.databaseBuilder(getApplicationContext(),
                RecordDB.class, "userDB").allowMainThreadQueries().build();


    }


}