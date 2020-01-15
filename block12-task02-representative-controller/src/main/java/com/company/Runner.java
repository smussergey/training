package com.company;

import com.company.model.dao.DaoFactory;
import com.company.model.dao.NoteBookDao;
import com.company.model.entity.NotUniqueLoginException;
import com.company.model.entity.NoteBook;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        DaoFactory factory = DaoFactory.getInstance();
        NoteBookDao dao = factory.createNoteBookDao();

        System.out.println(dao.findById(1));

        System.out.println(dao.findAll());

        try {
            dao.create(new NoteBook("Taras2","taras12345"));
        } catch (NotUniqueLoginException e) {
            e.printStackTrace();
        }

        List<NoteBook> noteBookList = dao.findAll();
        int maxId = Integer.MIN_VALUE;
        int currentId;
        for (NoteBook currentBook : noteBookList){
            if ((currentId = currentBook.getId()) > maxId){
                maxId = currentId;
            }
        }
        System.out.println(dao.findById(maxId));

        dao.update(new NoteBook(maxId,"Nik2","nik12345"));
        System.out.println(dao.findById(maxId));

        dao.delete(maxId);

    }

}
