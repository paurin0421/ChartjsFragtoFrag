package com.example.chartjsfragtofrag;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.fragment.NavHostFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Fragment1 extends Fragment {

    private View view;
    private Button btn;
    EditText edit1, edit2,edit3,edit4,edit5;
//    ArrayList<String> numlist;
    String numlist_str;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_1, container, false);

        edit1 = view.findViewById(R.id.edit1);
        edit2 = view.findViewById(R.id.edit2);
        edit3 = view.findViewById(R.id.edit3);
        edit4 = view.findViewById(R.id.edit4);
        edit5 = view.findViewById(R.id.edit5);

        btn = view.findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener() { // 프래그먼트2로 이동
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle(); // 번들을 통해 값 전달

//                numlist.add(edit1.getText().toString());
//                numlist.add(edit2.getText().toString());
//                numlist.add(edit3.getText().toString());
//                numlist.add(edit4.getText().toString());
//                numlist.add(edit5.getText().toString());
//                numlist_str= numlist.toString();

                numlist_str = "["+edit1.getText().toString()+","+edit2.getText().toString()+","+edit3.getText().toString()+","+edit4.getText().toString()+","+edit5.getText().toString()+"]";
                bundle.putString("edit1",edit1.getText().toString());//번들에 넘길 값 저장
                bundle.putString("edit2",edit2.getText().toString());//번들에 넘길 값 저장
                bundle.putString("edit3",edit3.getText().toString());//번들에 넘길 값 저장
                bundle.putString("edit4",edit4.getText().toString());//번들에 넘길 값 저장
                bundle.putString("edit5",edit5.getText().toString());//번들에 넘길 값 저장
                bundle.putString("numlist",numlist_str);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment2 fragment2 = new Fragment2();//프래그먼트2 선언
                fragment2.setArguments(bundle);//번들을 프래그먼트2로 보낼 준비
                transaction.replace(R.id.frame, fragment2);
                transaction.commit();
            }
        });


        return view;
    }


}