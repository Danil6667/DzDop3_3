package com.example.dzdop3_3;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class FirstFragment extends Fragment {

    private EditText etText;
    private MaterialButton btmAdd, btmClear;
    private ListOfTextAdapter adapter = new ListOfTextAdapter();
    private final List<String> listOfName = new ArrayList<>();
    private RecyclerView rvListOfText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvListOfText = view.findViewById(R.id.rv_recycler);
        etText = view.findViewById(R.id.et_get_text);
        btmAdd = view.findViewById(R.id.btm_add);
        btmClear = view.findViewById(R.id.btm_clear);
        click();
    }

    private void initialize() {
        rvListOfText.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        rvListOfText.setAdapter(adapter);
    }

    private void click() {
        btmAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etText.getText().toString().trim();
                if (text.isEmpty()) {
                    etText.setError("Текст пуст!");
                } else {
                    listOfName.add(text);
                    adapter.setData(listOfName);
                    etText.getText().clear();
                    initialize();
                }
            }
        });

        btmClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listOfName.isEmpty()) {
                    Toast.makeText(getContext(), "Лист Пуст", Toast.LENGTH_SHORT).show();
                } else {
                    listOfName.clear();
                    adapter.setData(listOfName);
                }
            }
        });
    }
}