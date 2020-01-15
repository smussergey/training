package com.company.model.dao.impl;

import com.company.model.dao.DaoFactory;
import com.company.model.dao.NoteBookDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {
    @Override
    public NoteBookDao createNoteBookDao() {
        return new JDBCNotebookDao(getConnection());
    }

    private Connection getConnection(){
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/notebook_db",
                    "root" ,
                    "12345" );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
