package com.example.olskr.cplhm1.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.example.olskr.cplhm1.mvp.model.Model;
import com.example.olskr.cplhm1.mvp.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    Model model;

    public MainPresenter() {
        this.model = new Model();
    }

    public int calculateButtonValue(int index) {
        model.setAt(index, model.getAt(index) + 1);
        return model.getAt(index);
    }

    public void buttonOneClick() {
        getViewState().setButtonOneValue(calculateButtonValue(0));
    }

    public void buttonTwoClick() {
        getViewState().setButtonTwoValue(calculateButtonValue(1));
    }

    public void buttonThreeClick() {
        getViewState().setButtonThreeValue(calculateButtonValue(2));
    }
}
