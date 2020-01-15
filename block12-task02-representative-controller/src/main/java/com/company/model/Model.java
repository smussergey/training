package com.company.model;

import com.company.model.dao.NoteBookDao;
import com.company.model.dao.impl.JDBCDaoFactory;
import com.company.model.dao.impl.JDBCNotebookDao;
import com.company.model.entity.NotUniqueLoginException;
import com.company.model.entity.NoteBook;

/**
 * Created by student on 26.09.2017.
 */
public class Model {
    private NoteBookDao noteBookDao;

    public Model() {
        noteBookDao = JDBCDaoFactory.getInstance().createNoteBookDao();
    }

    public void save(NoteBook noteBook)  throws NotUniqueLoginException {
        noteBookDao.create(noteBook);
    }
}
