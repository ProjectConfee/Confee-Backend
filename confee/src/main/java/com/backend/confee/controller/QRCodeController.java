package com.backend.confee.controller;

import com.backend.confee.dto.QRCodeRequest;
import com.backend.confee.entity.QRCode;
import com.backend.confee.service.QRCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/qr")
public class QRCodeController {

    @Autowired
    private QRCodeService qrCodeService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateQRCode(@RequestBody QRCodeRequest request) {
        try {
            QRCode qrCode = qrCodeService.generateQRCode(request.getTicketId());
            return ResponseEntity.ok("QR code generated successfully for ticket ID: " + qrCode.getTicketId());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error generating QR code: " + e.getMessage());
        }
    }

    @PostMapping("/scan")
    public ResponseEntity<String> scanQRCode(@RequestParam("file") MultipartFile file) {
        try {
            String ticketId = qrCodeService.scanQRCode(file);
            return ResponseEntity.ok("Scanned Ticket ID: " + ticketId);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error scanning QR code: " + e.getMessage());
        }
    }

    @GetMapping("/get/{ticketId}")
    public ResponseEntity<byte[]> getQRCode(@PathVariable String ticketId) {
        try {
            QRCode qrCode = qrCodeService.getQRCodeByTicketId(ticketId);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + ticketId + ".png")
                    .body(qrCode.getQrCodeImage());
        } catch (Exception e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}
