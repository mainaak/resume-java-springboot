package com.koalmine.curriculumvitae.constants;

public enum Page {
    home;

    public boolean matches(String value){
        Page[] pages = Page.values();
        for (Page page: pages){
            if (value.equals(page.name()))
                return true;
        }
        return false;
    }
}
