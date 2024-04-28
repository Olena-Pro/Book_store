package mate.academy.bookstore.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record UserRegistrationRequestDto(
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Length(min = 8, max = 65)
        String password,
        @NotBlank
        @Length(min = 8, max = 65)
        String repeatPassword,
        @NotNull
        String firstName,
        @NotNull
        String lastName,
        String shippingAddress) {
}
