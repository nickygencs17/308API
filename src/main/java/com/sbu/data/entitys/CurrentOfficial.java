package com.sbu.data.entitys;

public class CurrentOfficial {

    String state_id;
    String type_office;
    String full_name;
    String party;
    String district_id;


    public CurrentOfficial(String state_id, String type_office, String full_name, String party, String district_id) {
        this.state_id = state_id;
        this.type_office = type_office;
        this.full_name = full_name;
        this.party = party;
        this.district_id = district_id;
    }

    public CurrentOfficial() {
    }

    public String getState_id() {
        return state_id;
    }

    public void setState_id(String state_id) {
        this.state_id = state_id;
    }

    public String getType_office() {
        return type_office;
    }

    public void setType_office(String type_office) {
        this.type_office = type_office;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(String district_id) {
        this.district_id = district_id;
    }




}
