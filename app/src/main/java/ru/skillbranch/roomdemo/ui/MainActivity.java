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
import ru.skillbranch.roomdemo.demo.RecordDao;
import ru.skillbranch.roomdemo.demo.RecordDatabase;
import ru.skillbranch.roomdemo.dto.RecordDTO;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_id)
    TextView id;
    //private int count = 0;

    @BindView(R.id.main_date)
    EditText dateEdit;


    @BindView(R.id.main_object)
    EditText objectEdit;

    @BindView(R.id.main_output)
    TextView outputText;
    String output;

    @BindView(R.id.main_addRecord)
    Button addRecordBtn;

    @BindView(R.id.main_getFirstRecord)
    Button getFirstRecordBtn;

    @BindView(R.id.main_getAllRecords)
    Button getAllUsersBtn;


    //db
    public static RecordDatabase recordDatabase;
    //public static RecordDB recordDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initDB();

        addRecordBtn.setOnClickListener(view -> {
            //String date = dateEdit.getText().toString();
            String object = objectEdit.getText().toString();

            String date = Calendar.getInstance().getTime().toString();



            //addUser
            RecordDTO recordDTO = new RecordDTO();
            recordDTO.setDate(date);
            recordDTO.setSerializeObject(object);
            addUser(recordDTO);

            //count++;
            Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
            //id.setText(String.valueOf(count));

        });

        getFirstRecordBtn.setOnClickListener(view -> {

        });
        getAllUsersBtn.setOnClickListener(view -> {
            getAllUsers();
        });

    }

    private void addUser(RecordDTO recordDTO) {
        RecordDao recordDao = recordDatabase.testDao();
        recordDao.addUser(recordDTO);
        //MainActivity.recordDatabase.testDao().addUser(recordDTO);
        Toast.makeText(getApplicationContext(), "User added to DB successfully", Toast.LENGTH_LONG).show();
    }

//    private void addRecordDTo() {
//        Date currentDate = Calendar.getInstance().getTime();
//        RecordDTO recordDTO = new RecordDTO();
//
//        recordDTO.setAdded(currentDate.toString());
//        recordDTO.setSerializeObject("test Json");
//
//        RecordDao recordDao = (RecordDao) recordDB.iManager();
//        recordDao.add(recordDTO);
//    }

    private void getAllUsers() {
        List<RecordDTO> recordDTOList = MainActivity.recordDatabase.testDao().getAll();
        String info = " ";
        for (RecordDTO recordDTO : recordDTOList) {
            int id = recordDTO.getUid();

            String date = recordDTO.getDate().toString();
            String object = recordDTO.getSerializeObject();

            info = info + "\n" +
                    "id " + id + "\n" +
                    "date " + date + "\n" +
                    "object " + object + "\n";
                    Log.d("Main", info);
            outputText.setText(info);
        }

    }

//    private void getAllRecords() {
//        RecordDao recordDao = (RecordDao) recordDB.iManager();
//
//        List<RecordDTO> recordDTOList = recordDao.getAll();
//
//        String info = "";
//        for (RecordDTO recordDTO : recordDTOList){
//            long id = recordDTO.getId();
//            String date = recordDTO.getAdded();
//            String object = recordDTO.getSerializeObject();
//
//            info = info + "\n\n" +
//                    "id " + id + "\n" +
//                    "date " + date.toString() + "\n" +
//                    "object " + object + "\n";
//
//            Log.d("Main", info);
//
//            outputText.setText(info);
//
//        }
//
//
//    }
//

    private void initDB() {
        //TODO Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
        // Change allowMainThreadQueries!!!
        recordDatabase = Room.databaseBuilder(getApplicationContext(),
                RecordDatabase.class, "userDB").allowMainThreadQueries().build();

    }


}