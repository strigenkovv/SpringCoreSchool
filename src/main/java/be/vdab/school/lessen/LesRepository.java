package be.vdab.school.lessen;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class LesRepository {
    public List<Les> findAll() {
        try (var regels = Files.lines(Path.of("D:/opleding/Spring/SpringCoreMateriaal/lessen.csv"))) {
            return regels
                    .map(regel -> regel.split(","))
                    .map(regelOnderdelen -> new Les(
                            regelOnderdelen[0],
                            regelOnderdelen[1]))
                    .toList();
        } catch (IOException | ArrayIndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("Lessenbestand bevat verkeerde data", ex);
        }
    }
}
