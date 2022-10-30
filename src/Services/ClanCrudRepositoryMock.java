package Services;

import Objects.Clan;

import java.util.HashMap;
import java.util.Map;

public class ClanCrudRepositoryMock implements ClanCrudRepository {
    private final Map<Long, Clan> clans = new HashMap<>();

    @Override
    public void save(Clan clan) {
        clans.put(clan.getId(), clan);
    }

    @Override
    public Clan findById(long id) {
        return clans.get(id);
    }

    @Override
    public void update(long id, Clan clan) {//Меняем имя
        Clan oldClan = clans.get(id);
        if (oldClan != null) {
            oldClan.setName(clan.getName());
        }
    }

    @Override
    public void delete(long id) {
        clans.remove(id);
    }
}
