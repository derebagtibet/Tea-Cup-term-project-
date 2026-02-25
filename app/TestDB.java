/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author emirersan
 */
import persistence.TeaLogRepository;
public class TestDB {
    public static void main(String[] args) {
        TeaLogRepository repo = new TeaLogRepository();
        repo.insertCups(2);
        System.out.println("Insert try has done.");
    }
    
}
