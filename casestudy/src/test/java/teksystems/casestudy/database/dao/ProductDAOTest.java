package teksystems.casestudy.database.dao;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductDAOTest {

    @Autowired
    private ProductDAO productDAO;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveMeasurementsTest() {
//
//        Measurements recipe = Measurements.builder().measureDescription("Pound")
//                .build();
//
//        measurementsDAO.save(recipe);
//
//        Assertions.assertThat(recipe.getId()).isGreaterThan(0);
    }

    @Test
    @Order(2)
    public void getIngredientTest() {
//        Measurements measurements = measurementsDAO.findById(1);
//        Assertions.assertThat(measurements.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void getListOfMeasurements() {
//        List<Measurements> measurements = measurementsDAO.findAll();
//        Assertions.assertThat(measurements.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void updateMeasurementsTest() {
//        Measurements measurements = measurementsDAO.findById(1);
//        measurements.setMeasureDescription("tomato");
//        Assertions.assertThat(measurementsDAO.findById(1).getMeasureDescription()).isEqualTo(measurements.getMeasureDescription());
    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void deleteMeasurementsTest() {
//        Measurements measurements = measurementsDAO.findById(1);
//        measurementsDAO.delete(measurements);
//        Optional<Measurements> optionalMeasurements = Optional.ofNullable(measurementsDAO.findById(measurements.getId()));
//
//        Measurements tempMeasurements = null;
//        if (optionalMeasurements.isPresent()) {
//            tempMeasurements = optionalMeasurements.get();
//        }
//
//        Assertions.assertThat(tempMeasurements).isNull();
    }



}
