package model;

import co.edu.unisabana.parcialarquitectura.controller.dto.CheckpointDTO;
import co.edu.unisabana.parcialarquitectura.repository.entity.CheckpointEntity;
import co.edu.unisabana.parcialarquitectura.repository.jpa.CheckpointRepository;
import co.edu.unisabana.parcialarquitectura.service.CheckpointService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)

public class CheckpointServiceTest {

    @InjectMocks
    CheckpointService logica;

    @Mock
    CheckpointRepository repository;

    @Test
    void cuando_invoque_checkin_dar_exception(){
        CheckpointEntity check = new CheckpointEntity();
        check.setDayOfMonth(30);
        Mockito.when(repository.findById(1)).thenReturn(Optional.of(check));
        CheckpointDTO checkpointDTO = new CheckpointDTO();
        assertThrows(Exception.class, () ->{
            logica.checkin(checkpointDTO);
        });

    }

}
