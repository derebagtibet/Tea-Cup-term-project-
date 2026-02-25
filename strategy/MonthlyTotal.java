/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

/**
 *
 * @author emirersan
 */
import persistence.TeaLogRepository;

public class MonthlyTotal implements TotalCupsCalculation{
   
    private final TeaLogRepository repo;

    public MonthlyTotal(TeaLogRepository repo) {
        this.repo = repo;
    }

    @Override
    public int calculate() {
        return repo.getMonthlyTotal();
    }
}
