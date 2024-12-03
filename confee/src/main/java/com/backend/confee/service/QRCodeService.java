package com.backend.confee.service;
import java.util.HashMap;
import java.util.Map;
import com.backend.confee.entity.QRCode;
import com.backend.confee.repo.QRCodeRepository;
import com.backend.confee.util.QRCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Optional;

@Service
public class QRCodeService {

    @Autowired
    private QRCodeRepository qrCodeRepository;


    public Map<String, Object> updateQRCodeStatus(String ticketId, String cardName) {
        Map<String, Object> response = new HashMap<>();
        try {
            // Fetch QR Code record using ticketId
            Optional<QRCode> qrCodeOptional = Optional.ofNullable(qrCodeRepository.findByTicketId(ticketId));

            if (qrCodeOptional.isPresent()) {
                QRCode qrCode = qrCodeOptional.get();
                boolean alreadyScanned = false;

                // Check the corresponding column based on the card name
                switch (cardName.toLowerCase()) {
                    case "registration":
                        if (qrCode.isEntrance()) {
                            alreadyScanned = true;
                        } else {
                            qrCode.setEntrance(true); // Update the column to true
                        }
                        break;
                    case "lunch":
                        if (qrCode.isLunch()) {
                            alreadyScanned = true;
                        } else {
                            qrCode.setLunch(true); // Update the column to true
                        }
                        break;
                    case "refreshments":
                        if (qrCode.isRefreshments()) {
                            alreadyScanned = true;
                        } else {
                            qrCode.setRefreshments(true); // Update the column to true
                        }
                        break;
                    default:
                        response.put("success", false);
                        response.put("message", "Invalid card name: " + cardName);
                        return response;
                }

                if (alreadyScanned) {
                    response.put("success", false);
                    response.put("message", "QR Code already scanned for " + cardName);
                } else {
                    qrCodeRepository.save(qrCode); // Save the updated record
                    response.put("success", true);
                    response.put("message", cardName + " successfully scanned.");
                }
            } else {
                response.put("success", false);
                response.put("message", "QR Code not found for ticketId: " + ticketId);
            }
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "An error occurred: " + e.getMessage());
        }
        return response;
    }


    public QRCode generateQRCode(String ticketId) throws Exception {
        // Generate the QR code
        BufferedImage qrImage = QRCodeUtil.generateQRCodeImage(ticketId);

        // Convert the image to byte array
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(qrImage, "png", outputStream);
        byte[] qrCodeBytes = outputStream.toByteArray();

        // Save to database
        QRCode qrCode = new QRCode(ticketId, qrCodeBytes);
        return qrCodeRepository.save(qrCode);
    }

    public QRCode getQRCodeByTicketId(String ticketId) {
        return qrCodeRepository.findByTicketId(ticketId);
    }
}