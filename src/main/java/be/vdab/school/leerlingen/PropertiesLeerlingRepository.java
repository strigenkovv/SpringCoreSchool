package be.vdab.school.leerlingen;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
@Qualifier("PROPERTIES")
public class PropertiesLeerlingRepository implements LeerlingRepository {
    @Override
    public List<Leerling> findAll() {
        try (var regels = Files.lines(Path.of("D:/opleding/Spring/SpringCoreMateriaal/leerlingen.properties"))) {
            return regels
                    .map(regel -> regel.split(":|,"))
                    .map(regelOnderdelen -> new Leerling(
                            Long.parseLong(regelOnderdelen[0]),
                            regelOnderdelen[1],
                            regelOnderdelen[2]))
                    .toList();
        } catch (IOException | ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            throw new IllegalArgumentException("Leerlingenbestand bevat verkeerde data", ex);
        }
    }
}
