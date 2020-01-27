package ru.skillbranch.roomdemo.ui;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.skillbranch.roomdemo.R;
import ru.skillbranch.roomdemo.demo.RecordDao;
import ru.skillbranch.roomdemo.demo.RecordDatabase;
import ru.skillbranch.roomdemo.dto.SosDTO;
import ru.skillbranch.roomdemo.entity.Record;

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

            int date = (int) Calendar.getInstance().getTime().getTime();


            //addRecord
            Record record = new Record();
            record.setDate(date);
            record.setSerializeObject(object);
            record.setObjectType("Object");
            addRecord(record);

            //count++;
            Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
            //id.setText(String.valueOf(count));

        });
        addObjectbtn.setOnClickListener(view -> {
            addObject();
        });

        getFirstRecordBtn.setOnClickListener(view -> {
            //getFirstRecordByID();
        });
        dellFirstRecordBtn.setOnClickListener(view ->{
            dellFirstRecordBYTime();
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

        Record record = new Record();
        record.setDate((int) Calendar.getInstance().getTime().getTime());
        record.setObjectType(sosDTO.getClass().getName());
        record.setSerializeObject(convertToJson(sosDTO));



        try {
            convertFromRecordDto(record);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        addRecord(record);


    }

    private void addRecord(Record record) {
        RecordDao recordDao = recordDatabase.testDao();
        recordDao.addRecord(record);
        Toast.makeText(getApplicationContext(), "User added to DB successfully", Toast.LENGTH_LONG).show();
    }
    private void getAllRecords() {
        List<Record> recordList = MainActivity.recordDatabase.testDao().getAll();
        String info = " ";
        for (Record record : recordList) {
            int id = record.getId();

            int date = record.getDate();
            String object = record.getSerializeObject();
            String objectType = record.getObjectType();

            info = info + "\n" +
                    "id " + id + "\n" +
                    "date " + date + "\n" +
                    "object " + object + "\n" +
                    "object type " + objectType + "\n";
            Log.d("Main", info);
            outputText.setText(info);
        }

    }

    //
    private Record getFirstRecordByID() {
        Record firstRecord = MainActivity.recordDatabase.testDao().getFirstByID();

        int id = firstRecord.getId();
        int date = firstRecord.getDate();
        String object = firstRecord.getSerializeObject();
        String objectType = firstRecord.getObjectType();


        String info = " ";
        info = info + "\n" +
                "id " + id + "\n" +
                "date " + date + "\n" +
                "object " + object + "\n" +
                "object type " + objectType + "\n";
        Log.d("Main", info);

        outputText.setText(info);

        return firstRecord;
    }
    private Record getFirstRecordByTime() {
        Record firstRecord = MainActivity.recordDatabase.testDao().getFirstRecordByTime();

        int id = firstRecord.getId();
        int date = firstRecord.getDate();
        String object = firstRecord.getSerializeObject();
        String objectType = firstRecord.getObjectType();


        String info = " ";
        info = info + "\n" +
                "id " + id + "\n" +
                "date " + date + "\n" +
                "object " + object + "\n" +
                "object type " + objectType + "\n";
        Log.d("Main", info);

        outputText.setText(info);

        return firstRecord;
    }
    private void dellFirstRecordBYTime() {
        Record firstRecord = getFirstRecordByTime();
        if (firstRecord != null) {
            MainActivity.recordDatabase.testDao().delete(firstRecord);
        }
    }

    private String convertToJson(Object object) {
        Gson gson = new Gson();
        String serializeObject = gson.toJson(object);
        Log.d(TAG, "convertToJson: " + serializeObject);
        return serializeObject;
    };
    private Object convertFromRecordDto(Record record) throws ClassNotFoundException {
        String serializeObject = record.getSerializeObject();
        String objectType = record.getObjectType();
        Gson gson = new Gson();

        //Restore sosDTO
        SosDTO restoredDTO =  gson.fromJson(serializeObject, (Type) Class.forName(objectType));
        restoredDTO.getDate();

        return new Object();
    };



}