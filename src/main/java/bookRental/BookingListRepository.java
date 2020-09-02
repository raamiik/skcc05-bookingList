package bookRental;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookingListRepository extends CrudRepository<BookingList, Long> {
    Optional<BookingList> findByBookingId(Long bookingID);

  //  List<BookingList> findByUserId(String userId);

    //void deleteByUserId(String userId);

}