package kgu.lab.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class RepositoryTest {
    public void addTest(String id, String text) {
        System.out.print("Id - " + id + ", text - " + text);
    }
}