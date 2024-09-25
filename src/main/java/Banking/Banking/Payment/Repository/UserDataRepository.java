package Banking.Banking.Payment.Repository;


import Banking.Banking.Payment.Entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Integer> {

    Optional<UserData> findByAccountNumberAndName(String accountNumber, String name);
}
