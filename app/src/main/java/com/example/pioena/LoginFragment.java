package com.example.pioena;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class LoginFragment extends Fragment {
    Context context;
    com.example.pioena.OnTabItemSelectedListener listener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof com.example.pioena.OnTabItemSelectedListener) {
            listener = (com.example.pioena.OnTabItemSelectedListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (context != null) {
            context = null;
            listener = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.loginfragment, container, false);

        initUI(rootView);

        return rootView;
    }

    private void initUI(ViewGroup rootView) {
        // 하단바를 숨기는 코드
        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
        bottomNavigationView.setVisibility(View.GONE);

        EditText editText1, editText2;
        editText1 = rootView.findViewById(R.id.etEmail);
        editText2 = rootView.findViewById(R.id.etPassword);

        final String[] id = new String[1];
        final String[] pw = new String[1];

        ImageButton imageButton = rootView.findViewById(R.id.roundButton1);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "애플 로그인", Toast.LENGTH_SHORT).show();
            }
        });

        Button LoginButton = rootView.findViewById(R.id.btnLogin);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id[0] = editText1.getText().toString();
                pw[0] = editText2.getText().toString();
                if (id[0].length() == 0) {
                    Toast.makeText(getContext(), "ID를 다시 입력해주세요", Toast.LENGTH_LONG).show();
                } else if (pw[0].length() == 0) {
                    Toast.makeText(getContext(), "PW를 다시 입력해주세요", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getContext(), "로그인 되었습니다", Toast.LENGTH_SHORT).show();
                    if (listener != null) {
                        listener.onTabSelected(0);  // fragment1으로(홈) 전환
                    }
                    else {
                        Toast.makeText(getContext(), "에러", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}