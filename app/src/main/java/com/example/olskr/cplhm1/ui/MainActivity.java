package com.example.olskr.cplhm1.ui;

import android.os.Bundle;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.olskr.cplhm1.R;
import com.example.olskr.cplhm1.mvp.presenter.MainPresenter;
import com.example.olskr.cplhm1.mvp.view.MainView;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @BindView(R.id.btnCounter1)
    Button buttonOne;
    @BindView(R.id.btnCounter2)
    Button buttonTwo;
    @BindView(R.id.btnCounter3)
    Button buttonThree;
    @BindString(R.string.countEquals)
    String countEquals;

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initListener();
    }

    @ProvidePresenter
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    public void initListener() {
        buttonOne.setOnClickListener(view -> {
            presenter.buttonOneClick();
        });

        buttonTwo.setOnClickListener(view -> {
            presenter.buttonTwoClick();
        });

        buttonThree.setOnClickListener(v -> {
            presenter.buttonThreeClick();
        });
    }

    @Override
    public void setButtonOneValue(int value) {
        buttonOne.setText(String.format(countEquals, value));
    }

    @Override
    public void setButtonTwoValue(int value) {
        buttonTwo.setText(String.format(countEquals, value));
    }

    @Override
    public void setButtonThreeValue(int value) {
        buttonThree.setText(String.format(countEquals, value));
    }
}
