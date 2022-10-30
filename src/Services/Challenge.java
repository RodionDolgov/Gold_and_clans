package Services;

import Objects.Clan;
import Objects.Task;

import java.util.logging.Logger;

public class Challenge {
    private final ClanService clanService;
    private final TaskService taskService;
    private final Logger logger = Logger.getAnonymousLogger();//Можно вести логирование в файле. Можно в БД табличку заполнять

    public Challenge(ClanService clanService, TaskService taskService) {
        this.clanService = clanService;
        this.taskService = taskService;
    }

    public void winBattle(long userId, long clanId, long taskId) {// Игрок победил в бою
        Clan clan = clanService.getClan(clanId);
        Task task = taskService.getTask(taskId);

        if(task.haveDone(taskId)){//выполнил ли игрок задание
            clan.addGold(task.getAward());
        }
        logger.info("User with id " + userId + " of clan " + clan + " added " + task.getAward());
    }

    public void visitedGame(long clanId, long taskId) {// Игрок посещал игру какое-то количество дней
        Clan clan = clanService.getClan(clanId);
        Task task = taskService.getTask(taskId);
        clan.addGold(-350);
    }
}
