package com.intabella.utilities;

import com.intabella.pages.*;

public class Pages {
    GeneralFiltersMenuPage generalFiltersMenuPage = new GeneralFiltersMenuPage();
    GeneralInfoPage generalInfoPage = new GeneralInfoPage();
    DashboardPage dashboardPage = new DashboardPage();
    VehicleTableArrangementPage vehicleTableArrangementPage=new VehicleTableArrangementPage();
    LoginPage loginPage = new LoginPage();



    public LoginPage loginPage(){
        if (loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

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

    public VehicleTableArrangementPage vehicleTableArrangementPage(){
        if (vehicleTableArrangementPage == null){
            vehicleTableArrangementPage = new VehicleTableArrangementPage();
        }
        return vehicleTableArrangementPage;
    }

    public GeneralFiltersMenuPage generalFiltersMenuPage(){
        if (generalFiltersMenuPage == null){
            generalFiltersMenuPage = new GeneralFiltersMenuPage();
        }
        return generalFiltersMenuPage;
    }


}
