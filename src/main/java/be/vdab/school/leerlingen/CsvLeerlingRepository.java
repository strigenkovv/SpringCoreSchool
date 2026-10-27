package be.vdab.school.leerlingen;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
@Qualifier("CSV")
public class CsvLeerlingRepository implements LeerlingRepository {
    private final Path pad;

    public CsvLeerlingRepository(@Value("${leerlingen.csv}") String pad) {
        this.pad = Path.of(pad);
    }

    @Override
    public List<Leerling> findAll() {
        try (var regels = Files.lines(pad)) {
            return regels
                    .map(regel -> regel.split(","))
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
