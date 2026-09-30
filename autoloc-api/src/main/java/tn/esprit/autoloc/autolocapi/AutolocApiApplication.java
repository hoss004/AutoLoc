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

                Vehicule v1 = new Vehicule();
                v1.setImmatriculation("TU-1234-AB");
                v1.setMarque("Renault");
                v1.setModele("Clio");
                v1.setCategorie(CategorieVehicule.CITADINE);
                v1.setTarifJournalier(new BigDecimal("45.00"));
                v1.setStatut(StatutVehicule.DISPONIBLE);
                vehiculeRepository.save(v1);

                Vehicule v2 = new Vehicule();
                v2.setImmatriculation("TU-5678-CD");
                v2.setMarque("Peugeot");
                v2.setModele("308");
                v2.setCategorie(CategorieVehicule.BERLINE);
                v2.setTarifJournalier(new BigDecimal("65.00"));
                v2.setStatut(StatutVehicule.DISPONIBLE);
                vehiculeRepository.save(v2);

                Vehicule v3 = new Vehicule();
                v3.setImmatriculation("TU-9012-EF");
                v3.setMarque("Toyota");
                v3.setModele("RAV4");
                v3.setCategorie(CategorieVehicule.SUV);
                v3.setTarifJournalier(new BigDecimal("95.00"));
                v3.setStatut(StatutVehicule.MAINTENANCE);
                vehiculeRepository.save(v3);

                System.out.println("✅ 3 véhicules de démonstration insérés.");
            }
        };
    }
}