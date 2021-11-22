package com.callor.lotto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    // 각각의 로또번호의 id값 호출하는 2차원 배열
    int idNumbers[][] = {
            {R.id.lotto11, R.id.lotto12, R.id.lotto13, R.id.lotto14, R.id.lotto15, R.id.lotto16},
            {R.id.lotto21, R.id.lotto22, R.id.lotto23, R.id.lotto24, R.id.lotto25, R.id.lotto26},
            {R.id.lotto31, R.id.lotto32, R.id.lotto33, R.id.lotto34, R.id.lotto35, R.id.lotto36},
            {R.id.lotto41, R.id.lotto42, R.id.lotto43, R.id.lotto44, R.id.lotto45, R.id.lotto46},
            {R.id.lotto51, R.id.lotto52, R.id.lotto53, R.id.lotto54, R.id.lotto55, R.id.lotto56},
    };
    // 생성된 로또번호 6개를 저장할 배열
    int lottoNums[] = new int[6];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button makeNumber = findViewById(R.id.makeNumber);
        makeNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Lotto 번호를 생성하였습니다.", Toast.LENGTH_SHORT).show();

                for (int i = 0; i < idNumbers.length; i++) {
                    // 한벌의 로또번호 생성
                    fillLottoNumbers();
                    for (int j = 0; j < idNumbers[0].length; j++) {
                        // 2차원 배열에 저장한 button의 id값으로 버튼을 찾아서
                        Button lottoNumber = findViewById(idNumbers[i][j]);
                        // 정수를 문자로 바꾸어
                        String str = "" + lottoNums[j];
                        // 버튼에 번호를 표시
                        lottoNumber.setText(str);
                    }
                }
            }
        });
    } // 로또번호 생성과 표시하기 위한 준비


    // 로또번호 생성하기 위한 함수들
    // 초기화
    private void init() {
        for (int i = 0; i < lottoNums.length; i++) {
            lottoNums[i] = 0;
        }
    }
    // 정렬(작은 번호부터 표시되기 위해)
    private void sort() {
        int temp;
        for(int i = 0; i < 5; i++) {
            for(int j = i; j < 6; j++) {
                if(lottoNums[i] > lottoNums[j]) {
                    temp = lottoNums[i];
                    lottoNums[i] = lottoNums[j];
                    lottoNums[j] = temp;
                }
            }
        }
    }

    // 로또번호를 저장할 배열을 초기화, 생성, 생성된 번호를 정렬
    private void fillLottoNumbers() {
        init();
        for (int i = 0; i < 6; i++) {
            makeLottoNumbers();
        }
        sort();
    }

    // HashSet 을 사용하여 중복없이 번호를 생성하기
    private void makeLottoNumbers() {
        HashSet<Integer> set = new HashSet<>();
        int num;
        for(int i = 0; i < 6;) {
            num = (int) (Math.random() * 45 + 1);
            if(set.add(num)) {
                lottoNums[i++] = num;
            }
        }
        set.clear();
    }





}