package ch.amsler.simon.kundenverwaltung.kunden;
import ch.amsler.simon.kundenverwaltung.kunden.KundenData;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class KundenRepositoryTests {
    @Autowired
    private KundenRepository kundenRepository;

    private KundenData kunden;

    @Test
    @Order(1)
    public void testSave() {
        this.kunden = new KundenData();
        kundenRepository.save(this.kunden);
        Assertions.assertEquals(1, kundenRepository.count());
        Assertions.assertEquals(this.kunden, kundenRepository.findById(this.kunden.getId()).get());
    }


    @Test
    @Order(2)
    public void testDelete() {
        kundenRepository.deleteById(this.kunden.getId());
        Assertions.assertEquals(0, kundenRepository.count());
        Assertions.assertFalse(kundenRepository.findById(this.kunden.getId()).isPresent());
    }
}