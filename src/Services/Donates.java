package Services;

import Objects.Clan;

import java.util.logging.Logger;

public class Donates {
    private final ClanService service;
    private final Logger logger = Logger.getAnonymousLogger();//Можно вести логирование в файле. Можно в БД табличку заполнять

    public Donates(ClanService service) {
        this.service = service;
    }

    public void addGoldToClan(long userId, long clanId, int gold) {// Добавление золота в казну клана
        Clan clan = service.getClan(clanId);
        clan.addGold(gold);
        logger.info("User with id " + userId + " of clan " + clan + " added " + gold);
    }

    public void decraseGoldofClan(long userId, long clanId, int minusGold) {// Уменьшение золота в клане
        Clan clan = service.getClan(clanId);
        clan.addGold(minusGold);
        logger.info("User with id " + userId + " of clan " + clan + " added " + minusGold);
    }
}
