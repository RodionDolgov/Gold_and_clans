package Services;

import Objects.Clan;

import java.util.HashMap;

//Замена БД (таблица "Clan")
public class MockClanService implements ClanService {
    private final ClanCrudRepository repository;

    public MockClanService(ClanCrudRepository repository) {
        this.repository = repository;
        repository.save(new Clan(1, "Sharks"));
        repository.save(new Clan(2, "Valkiria"));
        repository.save(new Clan(3, "Destrs"));
        repository.save(new Clan(4, "Bears"));
        repository.save(new Clan(5, "Crocodiles"));
        repository.save(new Clan(6, "Spiders"));
    }

    @Override
    public Clan getClan(long clanId) {
        return repository.findById(clanId);
    }
}
