package com.backend.confee.service;

import com.backend.confee.entity.QRCode;
import com.backend.confee.repo.QRCodeRepository;
import com.backend.confee.util.QRCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@Service
public class QRCodeService {

    @Autowired
    private QRCodeRepository qrCodeRepository;

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

    public String scanQRCode(MultipartFile file) throws Exception {
        BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
        return QRCodeUtil.decodeQRCode(bufferedImage);
    }

    public QRCode getQRCodeByTicketId(String ticketId) {
        return qrCodeRepository.findByTicketId(ticketId);
    }
}
