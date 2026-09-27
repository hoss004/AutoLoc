package tn.esprit.autoloc.autolocapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tn.esprit.autoloc.autolocapi.domain.CategorieVehicule;
import tn.esprit.autoloc.autolocapi.domain.StatutVehicule;
import tn.esprit.autoloc.autolocapi.domain.Vehicule;
import tn.esprit.autoloc.autolocapi.repository.VehiculeRepository;

import java.math.BigDecimal;

@SpringBootApplication
public class AutolocApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutolocApiApplication.class, args);
    }

    @Bean
    CommandLineRunner initDonnees(VehiculeRepository vehiculeRepository) {
        return args -> {
            if (vehiculeRepository.count() == 0) {
                vehiculeRepository.save(new Vehicule(null, "TU-1234-AB", "Renault", "Clio",
                        CategorieVehicule.CITADINE, new BigDecimal("45.00"), StatutVehicule.DISPONIBLE));

                vehiculeRepository.save(new Vehicule(null, "TU-5678-CD", "Peugeot", "308",
                        CategorieVehicule.BERLINE, new BigDecimal("65.00"), StatutVehicule.DISPONIBLE));

                vehiculeRepository.save(new Vehicule(null, "TU-9012-EF", "Toyota", "RAV4",
                        CategorieVehicule.SUV, new BigDecimal("95.00"), StatutVehicule.MAINTENANCE));

                System.out.println("✅ 3 véhicules de démonstration insérés.");
            }
        };
    }
}