package com.example.dowith;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class study extends Fragment {

    private View view;
    View makeview;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.study,container,false);
        //공간 목록을 담을 ArrayList<String> 형의 비어 있는 변수 studylist 선언
        ArrayList <String> studylist = new ArrayList<String>();
        //리스트뷰 변수 studylistView 생성, XML의 studylist에 대응시킴
        ListView studylistView = (ListView) view.findViewById(R.id.joinlist);
        //버튼 변수 make 생성, XML의 make에 대응시킴
        ImageButton make = (ImageButton) view.findViewById(R.id.make);
        //버튼 변수 join 생성, XML의 join에 대응시킴
        ImageButton join = (ImageButton) view.findViewById(R.id.join);

        //add() 메소드로 studylist 항목 추가
        studylist.add("운동 스터디");
        studylist.add("영어 회화 스터디");
        studylist.add("수학 멘토멘티");
        studylist.add("가가중 3-2반 스터디 모임");
        studylist.add("드로잉 공부");

        //ArrayAdapter<String> 형 변수 선언, 리스트뷰 형식 지정, studylist 배열 적용
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, studylist);
        //adapter를 studylistView에 적용
        studylistView.setAdapter(adapter);

        //studylistView 클릭하면 실행하는 코드
        studylistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                //Intent 생성, study_chat에 클래스 study_chat를 넘김
                Intent intent = new Intent(getActivity(), study_chat.class);
                //study_chat 액티비티 실행
                startActivity(intent);
            }
        });

        //스터디 생성 버튼을 누르면 생성할 수 있는 대화상자가 나타나는 코드
        make.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeview = (View) View.inflate(study.this.getActivity(), R.layout.study_make, null);

                //대화상자 생성
                AlertDialog.Builder dlg = new AlertDialog.Builder(study.this.getActivity());
                dlg.setTitle("스터디 생성");
                dlg.setIcon(R.drawable.add);
                dlg.setView(makeview);
                dlg.setPositiveButton("생성", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Intent 생성, study_chat로 화면 전환
                        Intent intent = new Intent(getActivity(), study_chat.class);
                        //study_chat 액티비티 실행
                        startActivity(intent);
                    }
                });

                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });

        //스터디 가입 버튼을 누르면 화면 전환하는 코드
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent 생성, study_join로 화면 전환
                Intent intent = new Intent(getActivity(), study_join.class);
                //study_join 액티비티 실행
                startActivity(intent);
            }
        });
        return view;
    }
}