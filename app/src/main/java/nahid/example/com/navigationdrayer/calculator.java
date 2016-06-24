package nahid.example.com.navigationdrayer;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Nahid Hasan on 5/23/2016.
 */
public class calculator extends Fragment {

    private View view;
    private EditText firstName, secondName;
    private Button calculateButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.calculator_fragement,container,false);

        // connect with xml to EditText
        firstName = (EditText)view.findViewById(R.id.firstname);
        secondName = (EditText)view.findViewById(R.id.secondname);


        //connect with Button
        calculateButton= (Button)view.findViewById(R.id.calculatebutton);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view=getView();
                if(firstName.getText().toString().equals("")||secondName.getText().toString().equals("")){
                    Snackbar.make(view, "Nothing fill up! Please fill all field with single name", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                //    Toast.makeText(view.getContext(),"Nothing fill up! Please fill with single name",Toast.LENGTH_SHORT).show();
                }else if(firstName.getText().toString().contains(" ")||secondName.getText().toString().contains(" ")){
                    Snackbar.make(view, "Do not allow space. Input single name", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });

        return view;
    }
}
