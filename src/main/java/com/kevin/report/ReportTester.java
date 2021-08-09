package com.kevin.report;

import java.util.ArrayList;
import java.util.List;

public class ReportTester {
    public static void main(String[] args) {

        List<Report> reports = new ArrayList<>();
        reports.add(new HealthReport());
        reports.add(new FinanceReport());
        reports.add(new FinanceReport());
        for (Report report : reports) {
            System.out.println(report.isData());
            System.out.println(report.DataSize());
            report.load();
        }
    }
}
