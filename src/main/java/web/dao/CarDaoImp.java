package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImp implements CarDao {

    private static final List<Car> carList = new ArrayList<>();

    static {
        carList.add(new Car("Audi", "black", 2006));
        carList.add(new Car("Mercedes", "brown", 2017));
        carList.add(new Car("KIA", "white", 2012));
        carList.add(new Car("Ford", "black", 2017));
        carList.add(new Car("Lada", "yellow", 2013));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count == 0 || count >= carList.size()) {
            return carList;
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
