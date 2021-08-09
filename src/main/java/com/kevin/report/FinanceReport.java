package com.kevin.report;

public class FinanceReport implements Report{
    @Override
    public boolean isData() {
        return true;
    }

    @Override
    public void load() {
        System.out.println("讀取財務報告");
    }

    @Override
    public int DataSize() {
        return 20;
    }
}
