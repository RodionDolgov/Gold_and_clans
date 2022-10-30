package main;

import Services.*;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        int donation = 100;
        int repetition = 3;
        int nThreads = 100;

        MockClanService mockClanService = new MockClanService(new ClanCrudRepositoryMock());
        MockTaskService mockTaskService = new MockTaskService(new TaskCrudRepositoryMock());
        Donates donates = new Donates(mockClanService);
        Challenge done = new Challenge(mockClanService, mockTaskService);

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        for (long j = 1; j <= 6; j++){//перебираю кланы в репозитории
            for (int i = 0; i < nThreads; i++) {//потоки
                long finalJ = j;
                executor.submit(() -> donates.addGoldToClan(ThreadLocalRandom.current().nextLong(), finalJ, donation * repetition));
            }
        }
        for (long j = 1; j <= 6; j++){//6 разных боев
            for(int i = 0; i < nThreads; i++){//потоки(игроки) - 100
                long finalJ = j;
                executor.submit(() -> done.winBattle(ThreadLocalRandom.current().nextLong(), 2, finalJ)); // игроки клана с id 2 выиграли 6 разных боев
            }
        }
        executor.shutdown();
        while (!executor.isTerminated()) ;

            System.out.println(mockClanService.getClan(2).getGold());
    }
}
