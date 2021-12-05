package com.intabella.utilities;

import com.intabella.pages.DashboardPage;
import com.intabella.pages.GeneralInfoPage;

public class Pages {

    GeneralInfoPage generalInfoPage = new GeneralInfoPage();
    DashboardPage dashboardPage = new DashboardPage();

    public GeneralInfoPage generalInfoPage(){
        if (generalInfoPage == null) {
            generalInfoPage = new GeneralInfoPage();
        }
        return generalInfoPage;
    }

    public DashboardPage dashboardPage(){
        if (dashboardPage == null){
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;
    }
}
