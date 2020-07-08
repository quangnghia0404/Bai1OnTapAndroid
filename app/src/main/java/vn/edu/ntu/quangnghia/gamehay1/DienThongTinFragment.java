package vn.edu.ntu.quangnghia.gamehay1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DienThongTinFragment extends Fragment {
    EditText edtten, edtngaysinh,edtsdt,edtdiachi,edtGio;
    RadioButton rbtienmat, rbnganhang, rbvidientu;
    Spinner spinner;
    Button dangky;
    ImageView lich, time;
    NavController navController;
    String ten, ngay, gio, diachi, sdt, phuongthuc, dichvu;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dien_thong_tin, container, false);
        addviews(view);
        addEvents();
        return view;
    }

    private void addEvents() {
        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ten = edtten.getText().toString();
                ngay= edtngaysinh.getText().toString();
                gio = edtGio.getText().toString();
                sdt = edtsdt.getText().toString();
                diachi = edtdiachi.getText().toString();

                if(rbtienmat.isChecked())
                {
                    phuongthuc = "Tiền mặt";
                }

                if(rbnganhang.isChecked())
                {
                    phuongthuc = "Ngân hàng";
                }

                if(rbvidientu.isChecked())
                {
                    phuongthuc = "Ví điện tử";
                }

                //Toast.makeText(dienthongtinFragment.this.getActivity(),phuongthuc,Toast.LENGTH_SHORT).show();

                dichvu = spinner.getSelectedItem().toString();

                //setdata
                Bundle bundle = new Bundle();
                bundle.putString("ten",ten);
                bundle.putString("ngay",ngay);
                bundle.putString("gio",gio);
                bundle.putString("sdt",sdt);
                bundle.putString("diachi",diachi);
                bundle.putString("phuongthuc",phuongthuc);
                bundle.putString("dichvu",dichvu);
                navController.navigate(R.id.action_dienThongTinFragment_to_hienThiThongTinFragment,bundle);
                Toast.makeText(getActivity(),"Đã đăng ký thành công",Toast.LENGTH_LONG).show();
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                TimePickerDialog.OnTimeSetListener setListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(hourOfDay)
                                .append(":")
                                .append(minute);
                        edtGio.setText(builder.toString());
                    }
                };
                TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), setListener,calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),true);
                timePickerDialog.show();
            }
        });
        lich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(dayOfMonth)
                                .append("/")
                                .append(++month)
                                .append("/")
                                .append(year);
                        edtngaysinh.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),listener
                        ,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
    }

    private void addviews(View view) {
        edtten = view.findViewById(R.id.edtten);
        edtngaysinh = view.findViewById(R.id.edtngaysinh);
        edtGio = view.findViewById(R.id.edtGio);
        edtsdt = view.findViewById(R.id.edtsdt);
        edtdiachi = view.findViewById(R.id.edtdiachi);
        rbtienmat= view.findViewById(R.id.radiotienmat);
        rbnganhang = view.findViewById(R.id.radionganhang);
        rbvidientu = view.findViewById(R.id.radiovidientu);
        spinner = view.findViewById(R.id.spinner);
        lich = view.findViewById(R.id.imageView);
        time = view.findViewById(R.id.imageView2);
        dangky = view.findViewById(R.id.button);
        navController = NavHostFragment.findNavController(DienThongTinFragment.this);

        final String[] dichvu = new  String[]{"Truyền hình cáp", "VTV4", "FPT"};
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(DienThongTinFragment.this.getActivity(),
                R.layout.support_simple_spinner_dropdown_item,dichvu);
        spinner.setAdapter(arrayAdapter);
    }
}