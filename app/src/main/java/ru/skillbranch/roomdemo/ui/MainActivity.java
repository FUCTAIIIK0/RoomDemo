package ru.skillbranch.roomdemo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.skillbranch.roomdemo.R;
import ru.skillbranch.roomdemo.demo.RecordDao;
import ru.skillbranch.roomdemo.demo.RecordDatabase;
import ru.skillbranch.roomdemo.dto.RecordDTO;
import ru.skillbranch.roomdemo.dto.SosDTO;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "Main";

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

    @BindView(R.id.main_dellFirst)
    Button dellFirstRecordBtn;

    @BindView(R.id.main_getAllRecords)
    Button getAllUsersBtn;

    @BindView(R.id.main_addObject)
    Button addObjectbtn;


    //db
    public static RecordDatabase recordDatabase;

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


            //addRecord
            RecordDTO recordDTO = new RecordDTO();
            recordDTO.setDate(date);
            recordDTO.setSerializeObject(object);
            recordDTO.setObjectType("Object");
            addRecord(recordDTO);

            //count++;
            Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
            //id.setText(String.valueOf(count));

        });
        addObjectbtn.setOnClickListener(view -> {
            addObject();
        });

        getFirstRecordBtn.setOnClickListener(view -> {
            getFirstRecord();
        });
        dellFirstRecordBtn.setOnClickListener(view ->{
            dellFirstRecord();
        });

        getAllUsersBtn.setOnClickListener(view -> {
            getAllRecords();
        });

    }

    //init
    private void initDB() {
        //TODO Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
        // Change allowMainThreadQueries!!!
        recordDatabase = Room.databaseBuilder(getApplicationContext(),
                RecordDatabase.class, "userDB").allowMainThreadQueries().build();

    }

    //test methods
    private void addObject() {
        //generate object
        SosDTO sosDTO = new SosDTO();
        sosDTO.setUserName("Jhon Osterman");
        sosDTO.setOnline(true);
        sosDTO.setDate(Calendar.getInstance().getTime());

        //put object to RecordDTo

        RecordDTO recordDTO = new RecordDTO();
        recordDTO.setDate(Calendar.getInstance().getTime().toString());
        recordDTO.setObjectType(sosDTO.getClass().getName());
        recordDTO.setSerializeObject(convertToJson(sosDTO));



        try {
          convertFromRecordDto(recordDTO);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        addRecord(recordDTO);


    }
    private void addRecord(RecordDTO recordDTO) {
        RecordDao recordDao = recordDatabase.testDao();
        recordDao.addRecord(recordDTO);
        Toast.makeText(getApplicationContext(), "User added to DB successfully", Toast.LENGTH_LONG).show();
    }
    private void getAllRecords() {
        List<RecordDTO> recordDTOList = MainActivity.recordDatabase.testDao().getAll();
        String info = " ";
        for (RecordDTO recordDTO : recordDTOList) {
            int id = recordDTO.getId();

            String date = recordDTO.getDate().toString();
            String object = recordDTO.getSerializeObject();
            String objectType = recordDTO.getObjectType();

            info = info + "\n" +
                    "id " + id + "\n" +
                    "date " + date + "\n" +
                    "object " + object + "\n" +
                    "object type " + objectType + "\n";
            Log.d("Main", info);
            outputText.setText(info);
        }

    }

    private void getFirstRecord(){
        RecordDTO firstRecordDTO = MainActivity.recordDatabase.testDao().getFirst();


        int id = firstRecordDTO.getId();
        String date = firstRecordDTO.getDate().toString();
        String object = firstRecordDTO.getSerializeObject();
        String objectType = firstRecordDTO.getObjectType();


        String info = " ";
        info = info + "\n" +
                "id " + id + "\n" +
                "date " + date + "\n" +
                "object " + object + "\n" +
                "object type " + objectType + "\n";
        Log.d("Main", info);

        outputText.setText(info);


    }
    private void dellFirstRecord(){}

    //lib methods

    private String convertToJson(Object object) {
        Gson gson = new Gson();
        String serializeObject = gson.toJson(object);
        Log.d(TAG, "convertToJson: " + serializeObject);
        return serializeObject;
    };
    private Object convertFromRecordDto(RecordDTO recordDTO) throws ClassNotFoundException {
        String serializeObject = recordDTO.getSerializeObject();
        String objectType = recordDTO.getObjectType();
        Gson gson = new Gson();

        //Restore sosDTO
        SosDTO restoredDTO =  gson.fromJson(serializeObject, (Type) Class.forName(objectType));
        restoredDTO.getDate();


        return new Object();
    };



}