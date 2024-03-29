package com.springecommerce.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        uniqueConstraints = {@UniqueConstraint(
                name = "email_unique",
                columnNames = {"email"}
        )}
)
public class Customer {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long customerId;

    @NotBlank(message = "please add First name")
    private String firstName;

    @NotBlank(message = "please add Last name")
    private String lastName;

    @Email(message = "please add valid mail")
    @NotBlank(message = "please add email")
    private String email;

    @NotBlank(message = "please add password")
    @Length(max = 20, min = 4)
    private String password;

    @OneToMany(
            mappedBy = "customer",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.ALL}
    )
    private List<Order> orders;
}