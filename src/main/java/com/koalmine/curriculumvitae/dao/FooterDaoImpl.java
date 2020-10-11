package com.koalmine.curriculumvitae.dao;

import com.koalmine.curriculumvitae.constants.Page;
import com.koalmine.curriculumvitae.model.dto.Footer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository("Database-Fake")
public class FooterDaoImpl implements FooterDao {

    private Map<Page, Footer> DATABASE = new HashMap<>();

    @Override
    public Footer getFooterInformation(Page pageName) {
        if (DATABASE.isEmpty()) {
            DATABASE.put(Page.home, new Footer("JAVA", "Spring Boot"));
        }
        return DATABASE.get(pageName);
    }
}
