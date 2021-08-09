package com.kevin.report;

public class HealthReport implements Report{

    @Override
    public boolean isData() {
        return false;
    }

    @Override
    public void load() {
        System.out.println("讀取健康報告");
    }

    @Override
    public int DataSize() {
        return 20;
    }
}
