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

            }
        });

        return viewGroup;
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
}