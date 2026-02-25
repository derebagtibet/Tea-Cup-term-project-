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

public class DailyTotal implements TotalCupsCalculation{
    private final TeaLogRepository repo;

    public DailyTotal(TeaLogRepository repo) {
        this.repo = repo;
    }

    @Override
    public int calculate() {
        return repo.getTodayTotal();
    }
    
}
