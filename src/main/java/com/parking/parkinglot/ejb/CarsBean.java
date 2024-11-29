package com.parking.parkinglot.ejb;

import com.parking.parkinglot.common.CarDto;
import com.parking.parkinglot.entities.Car;
import jakarta.ejb.EJBException;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class CarsBean {

    private static final Logger LOG = Logger.getLogger(CarsBean.class.getName());

    @PersistenceContext
    private EntityManager entityManager;


    public List<CarDto> findAllCars() {
        LOG.info("findAllCars"); // Log că metoda a fost apelată

        try {

            TypedQuery<Car> typedQuery = entityManager.createQuery("SELECT c FROM Car c", Car.class);

            List<Car> cars = typedQuery.getResultList();

            return copyCarsToDto(cars);

        } catch (Exception ex) {
            LOG.severe("Eroare la găsirea tuturor mașinilor: " + ex.getMessage());
            throw new EJBException(ex);
        }
    }


    private List<CarDto> copyCarsToDto(List<Car> cars) {
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car : cars) {

            CarDto carDto = new CarDto(
                    car.getId(),
                    car.getLicensePlate(),
                    car.getParkingSpot(),
                    car.getOwner().getUsername()
            );
            carDtos.add(carDto);
        }
        return carDtos;
    }
}

