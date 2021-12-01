package pe.isil.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    private String documentNumber;
    private String firstName;
    private String lastName;
    private String email; // se necesita para enviar notificaciones
    private LocalDate birthDate;
}
