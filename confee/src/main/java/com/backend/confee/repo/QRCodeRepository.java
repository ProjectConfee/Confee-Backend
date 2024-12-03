package com.backend.confee.repo;

import com.backend.confee.entity.QRCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QRCodeRepository extends JpaRepository<QRCode, Long> {
    QRCode findByTicketId(String ticketId);
}
