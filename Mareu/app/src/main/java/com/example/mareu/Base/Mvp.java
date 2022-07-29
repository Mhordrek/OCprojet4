package com.example.mareu.Base;

public interface Mvp {
    interface View{
    }
    interface Model{}
    interface Presenter<V>{
        public void attachView(V view);
    }
}
