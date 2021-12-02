package com.example.lotto02.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lotto02.R;
import com.example.lotto02.databinding.FragmentHomeBinding;

import java.util.HashSet;

public class HomeFragment extends Fragment {

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


//    private HomeViewModel homeViewModel;
//    private FragmentHomeBinding binding;




    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
//
//        binding = FragmentHomeBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        Button button = viewGroup.findViewById(R.id.makeNumber);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Lotto 번호를 생성했습니다", Toast.LENGTH_SHORT).show();

                for (int i = 0; i < idNumbers.length; i++) {
                    // 한벌의 로또번호 생성
                    fillLottoNumbers();
                    for (int j = 0; j < idNumbers[0].length; j++) {
                        // 2차원 배열에 저장한 button의 id값으로 버튼을 찾아서
                        Button lottoNumber = getView().findViewById(idNumbers[i][j]);
                        // 정수를 문자로 바꾸어
                        String str = "" + lottoNums[j];
                        // 버튼에 번호를 표시
                        lottoNumber.setText(str);
                    }
                }
            }
        });

        return viewGroup;
    } // 로또번호 생성과 표시하기 위한 준비


    // 로또번호 생성하기 위한 함수들
    // 초기화
    public void init() {
        for (int i = 0; i < lottoNums.length; i++) {
            lottoNums[i] = 0;
        }
    }
    // 정렬(작은 번호부터 표시되기 위해)
    public void sort() {
        int temp;
        for (int i = 0; i < 5; i++) {
            for (int j = i; j < 6; j++) {
                if (lottoNums[i] > lottoNums[j]) {
                    temp = lottoNums[i];
                    lottoNums[i] = lottoNums[j];
                    lottoNums[j] = temp;
                }
            }
        }
    }

    // 로또번호를 저장할 배열을 초기화, 생성, 생성된 번호를 정렬
    public void fillLottoNumbers() {
        init();
        for (int i = 0; i < 6; i++) {
            makeLottoNumbers();
        }
        sort();
    }

    // HashSet 을 사용하여 중복없이 번호를 생성하기
    public void makeLottoNumbers() {
        HashSet<Integer> set = new HashSet<>();
        int num;
        for (int i = 0; i < 6;) {
            num = (int) (Math.random() * 45 + 1);
            if (set.add(num)) {
                lottoNums[i++] = num;
            }
        }
        set.clear();
    }





//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
}