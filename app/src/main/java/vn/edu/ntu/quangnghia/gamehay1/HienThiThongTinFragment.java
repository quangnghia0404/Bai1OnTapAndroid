package vn.edu.ntu.quangnghia.gamehay1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class HienThiThongTinFragment extends Fragment {

    TextView txtten, txtngaysinh, txtgio,txtdichvu, txtphuongthuc, txtsdt, txtdiachi;
    Button thoat;
    String ten, ngay,gio, diachi, sdt, phuongthuc, dichvu;

    NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.fragment_hien_thi_thong_tin, container, false);
       getdata();
       addviews(view);
       addevent();
       return view;
    }

    private void addevent() {
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_hienThiThongTinFragment_to_dienThongTinFragment);
            }
        });
    }

    private void addviews(View view) {
        txtten = view.findViewById(R.id.txtten);
        txtngaysinh = view.findViewById(R.id.txtngaysinh);
        txtgio = view.findViewById(R.id.txtgio);
        txtdichvu = view.findViewById(R.id.txtndichvu);
        txtphuongthuc = view.findViewById(R.id.txtthanhtoan);
        txtsdt = view.findViewById(R.id.txtsdt);
        txtdiachi = view.findViewById(R.id.txtdiachi);
        thoat = view.findViewById(R.id.buttonthoat);

        navController = NavHostFragment.findNavController(HienThiThongTinFragment.this);

        txtten.setText(ten);
        txtngaysinh.setText(ngay);
        txtgio.setText(gio);
        txtdichvu.setText(dichvu);
        txtphuongthuc.setText(phuongthuc);
        txtsdt.setText(sdt);
        txtdiachi.setText(diachi);
    }

    private void getdata() {

        Bundle bundle = getArguments();
        ten = bundle.getString("ten");
        ngay = bundle.getString("ngay");
        gio = bundle.getString("gio");
        diachi =bundle.getString("sdt");
        sdt = bundle.getString("diachi");
        phuongthuc = bundle.getString("phuongthuc");
        dichvu = bundle.getString("dichvu");
    }
}