package Services;

import Objects.Clan;

public interface ClanCrudRepository {
    void save(Clan clan);

    Clan findById(long id);

    void update(long id, Clan clan);

    void delete(long id);
}
