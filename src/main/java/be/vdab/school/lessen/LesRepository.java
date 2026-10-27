package be.vdab.school.lessen;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Component
public class LesRepository {
    private final Path pad;

    public LesRepository(@Value("${lessen.csv}") String pad) {
        this.pad = Path.of(pad);
    }

    public List<Les> findAll() {
        try (var regels = Files.lines(pad)) {
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
