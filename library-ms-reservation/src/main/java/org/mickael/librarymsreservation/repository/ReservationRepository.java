package org.mickael.librarymsreservation.repository;

import org.mickael.librarymsreservation.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    List<Reservation> findAllByCustomerId(Integer customerId);

    List<Reservation> findAllByBookId(Integer bookId);

    Optional<Reservation> findById(Integer reservationId);

    Reservation findByCustomerId(Integer customerId);

    @Query("select case when count (reservation) > 0 then true else false end " +
                   "from Reservation reservation where (reservation.customerId = :customerId) " +
                   "and (reservation.bookId = :bookId)")
    boolean existByCustomerIdAndBookId(@Param("customerId") Integer customerId,@Param("bookId") Integer bookId);

    Reservation findByCustomerIdAndBookId(Integer customerId, Integer bookId);



}
