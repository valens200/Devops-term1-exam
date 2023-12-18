package decops.exam.rca.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
}
