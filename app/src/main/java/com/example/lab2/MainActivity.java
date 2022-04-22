package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Thumbnails;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai1_bai2);
        bai1_bai2();
       /* setContentView(R.layout.bai3);
        bai3();*/
       /* setContentView(R.layout.bai4);
        bai4();*/
     /*   setContentView(R.layout.bai5);
        bai5();*/
       /* setContentView(R.layout.activity_main);
        bai6();*/
    }
    ArrayList<String> arr = new ArrayList<String>();
    ArrayList<String> employees = new ArrayList<String>();
    ArrayList<Employee> employeesBai4 = new ArrayList<Employee>();
    ArrayList<Thumbnail> thumbnailList = new ArrayList<Thumbnail>();
    ArrayList<Dish> dishList = new ArrayList<Dish>();
    Employee employee;

    void bai1_bai2(){
        arr.add("Teo");
        arr.add("Ti");
        arr.add("Bin");
        arr.add("Bo");
        ListView lvPerson = (ListView)
        findViewById(R.id.lv_person);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);

        lvPerson.setAdapter(adapter);
        lvPerson.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?>arg0, View arg1, int indexArr, long arg3){
                TextView textSelected = findViewById(R.id.tv_display);
                textSelected.setText("postition: " + indexArr + "; value = " + arr.get(indexArr));
            }
        });
        Button addBtn = (Button) findViewById(R.id.addBtn);
        EditText input = (EditText) findViewById(R.id.textValue);
        addBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String value = input.getText().toString();

                        arr.add(value);
                        input.setText("");
                        adapter.notifyDataSetChanged();
                    }
                }
        );
        lvPerson.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                arr.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
    void bai3(){
        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        ListView lvEmployee = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, employees);
        lvEmployee.setAdapter(adapter);
        submitBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        addNewEmployee();
                        employees.add(employee.ToString());
                        adapter.notifyDataSetChanged();
                    }
                }
        );
    }

    void bai4(){
        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        ListView lvEmployee = (ListView) findViewById(R.id.listView);
        EmployeeAdapter adapter = new EmployeeAdapter(this, R.layout.item_employee, employeesBai4);
        lvEmployee.setAdapter(adapter);
        submitBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Employee newEmployee = addNewEmployeeBai4();
                        employeesBai4.add(newEmployee);
                        adapter.notifyDataSetChanged();
                    }
                }
        );
    }

    public void addNewEmployee(){
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        EditText idInput = (EditText) findViewById(R.id.idInput);
        EditText nameInput = (EditText) findViewById(R.id.nameInput);


        int radioCheckedID = radioGroup.getCheckedRadioButtonId();
        String id = idInput.getText().toString();
        String name = nameInput.getText().toString();
        if (radioCheckedID == R.id.fullTime){
            employee = new EmployeeFullTime();
        }else{
            employee = new EmployeePartTime();
        }
        employee.setId(id);
        employee.setName(name);
        idInput.setText("");
        nameInput.setText("");
        idInput.clearFocus();
        nameInput.clearFocus();
    }

    public Employee addNewEmployeeBai4(){
        EditText idInput = (EditText) findViewById(R.id.idEmployee);
        EditText nameInput = (EditText) findViewById(R.id.nameEmployee);
        CheckBox checkBox = (CheckBox) findViewById(R.id.isManager);

        boolean isManager = checkBox.isChecked();
        String id = idInput.getText().toString();
        String fullName = nameInput.getText().toString();
        Employee newEmployee = new Employee() {
            @Override
            public double TinhLuong() {
                return 0;
            }

            @Override
            public String ToString() {
                return null;
            }
        };

        newEmployee.setName(fullName);
        newEmployee.setId(id);
        newEmployee.setIsManager(isManager);
        idInput.setText("");
        nameInput.setText("");
        checkBox.setChecked(false);
        idInput.clearFocus();
        nameInput.clearFocus();

        return newEmployee;
    }


    Thumbnail ThumbnailL1 = new Thumbnail("Thumbnail 1", R.drawable.first_thumbnail);
    Thumbnail ThumbnailL2 = new Thumbnail("Thumbnail 2", R.drawable.second_thumbnail);
    Thumbnail ThumbnailL3 = new Thumbnail("Thumbnail 3", R.drawable.third_thumbnail);
    Thumbnail ThumbnailL4 = new Thumbnail("Thumbnail 4", R.drawable.fourth_thumbnail);
    Thumbnail ThumbnailL5 = new Thumbnail("Thumbnail 5", R.drawable.fifth_thumbnail);
    void bai5(){
        thumbnailList.add(ThumbnailL1);
        thumbnailList.add(ThumbnailL2);
        thumbnailList.add(ThumbnailL3);
        thumbnailList.add(ThumbnailL4);
        thumbnailList.add(ThumbnailL5);
        Spinner spinner = (Spinner) findViewById(R.id.select);
        GridView gridView = (GridView) findViewById(R.id.gridView);
        Button submitBtn = (Button) findViewById(R.id.submitBtn);
        ThumbnailAdapter spinnerAdapter = new ThumbnailAdapter(this, R.layout.popup_spinner, thumbnailList);
        DishAdapter gridViewAdapter = new DishAdapter(this, R.layout.item_dish, dishList);

        spinner.setAdapter(spinnerAdapter);
        gridView.setAdapter(gridViewAdapter);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dish newDish = addNewDish();
                if (newDish.getDishName().isEmpty()){
                    Toast.makeText(getBaseContext(), "Dish name is Required!", Toast.LENGTH_SHORT).show();
                }else{
                    dishList.add(newDish);
                    Toast.makeText(getBaseContext(), "Added successfully", Toast.LENGTH_SHORT).show();
                    gridViewAdapter.notifyDataSetChanged();
                }

            }
        });


    }
    public Dish addNewDish(){
        Dish newDish = new Dish();

        EditText inputName = (EditText) findViewById(R.id.foodName);
        Spinner spinner = (Spinner) findViewById(R.id.select);
        CheckBox checkBox = (CheckBox) findViewById(R.id.isPromotion);


        Thumbnail spinnerValue = (Thumbnail) spinner.getSelectedItem();
        System.out.println(spinnerValue.getName());
        System.out.println(spinnerValue.getImg());

        String dishName = inputName.getText().toString();
        boolean isPromotion = checkBox.isChecked();

        newDish.setDishName(dishName);
        newDish.setIsPromotion(isPromotion);
        newDish.setThumbnail(spinnerValue.getName(), spinnerValue.getImg());

        inputName.setText("");
        checkBox.setChecked(false);
        inputName.clearFocus();

        return newDish;
    }
    ArrayList<Employee> listEmployeeBai6 = new ArrayList<Employee>();
    void bai6(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        Button submitButton = (Button) findViewById(R.id.submitBtn);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, listEmployeeBai6);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        submitButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View view) {
                Employee newEmployee = addNewEmployeeBai4();
                listEmployeeBai6.add(newEmployee);
                recyclerAdapter.notifyDataSetChanged();
            }
        });

    }

}
