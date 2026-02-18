package de.lubowiecki;

import java.util.List;

public interface Repository<T extends Entity> {

    public void add(T t);

    public List<T> getAll();

}
